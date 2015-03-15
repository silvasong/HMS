package com.hms.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;




import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.hms.model.PagingData;

/**
 * <p>
 * Title: BaseDao.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年1月31日 下午2:36:43
 * @version 1.0
 */
public class BaseDao<T> extends HibernateDaoSupport {

	protected Class<T> clazz;
    
	@SuppressWarnings("unchecked")
	public BaseDao()
    {
       
        Type type = getClass().getGenericSuperclass();
        
        if (type instanceof ParameterizedType)
        {            
            Type[] paramTypes = ((ParameterizedType)type)
                .getActualTypeArguments();
            clazz = (Class<T>)paramTypes[0];
        }
    }
	
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Serializable sava(T t) {

		return this.getHibernateTemplate().save(t);
	}

	public void SaveOrUpdate(T t) {

		this.getHibernateTemplate().saveOrUpdate(t);
	}

	public void update(T t) {

		this.getHibernateTemplate().update(t);
	}

	public T get(Serializable id) {

		return this.getHibernateTemplate().get(clazz, id);
	}

	public List<T> loadAll() {

		return this.getHibernateTemplate().loadAll(clazz);
	}

	public void delete(T t) {

		this.getHibernateTemplate().delete(t);
	}

	public void delete(Serializable id) {

		this.getHibernateTemplate().delete(get(id));
	}

	public void deleteAll(Collection<T> list) {

		this.getHibernateTemplate().deleteAll(list);
	}

	public void deletAll(String[] ids) {

		for (String id : ids) {
			delete(id);
		}
	}
    
	public void deletAll(Integer[] ids) {

		for (Integer id : ids) {
			delete(id);
		}
	}
	
	public Criteria createCriteria() {

		return this.currentSession().createCriteria(clazz);
	}

	public Criteria createCriteria(Criterion[] criterions) {
		Criteria criteria = this.currentSession().createCriteria(clazz);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		return criteria;
	}

	public Criteria createCriteria(Criterion criterion) {

		return createCriteria(new Criterion[] { criterion });
	}

	public Criteria createCriteria(String orderBy, boolean isAsc,
			Criterion[] criterions) {

		Criteria criteria = createCriteria(criterions);
		if (isAsc) {
			criteria.addOrder(Order.asc(orderBy));
		} else {
			criteria.addOrder(Order.desc(orderBy));
		}
		return criteria;
	}

	public Criteria createCriteria(String orderBy, boolean isAsc) {
		return createCriteria(orderBy, isAsc, new Criterion[] {});
	}

	public Criteria createCriteria(String orderBy, boolean isAsc,
			Criterion criterion) {
		return createCriteria(orderBy, isAsc, new Criterion[] { criterion });
	}

	public void merge(T t) {
		this.getHibernateTemplate().merge(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(String orderBy, boolean isAsc) {
		return createCriteria(orderBy, isAsc).list();
	}

	@SuppressWarnings("unchecked")
	public T findUnique(String name, Object value) {
		return (T) createCriteria(Restrictions.eq(name, value)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> findBy(String name, Object value) {
		return createCriteria(Restrictions.eq(name, value)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findBy(String propertyName, Object value, String orderBy,
			boolean isAsc) {
		return createCriteria(orderBy, isAsc,
				Restrictions.eq(propertyName, value)).list();
	}
	
	public long getMaxValue(String propertyName){
		Criteria criteria = createCriteria();
		Object res = criteria.setProjection(Projections.max(propertyName)).uniqueResult();
		if(res == null){
			return 0;
		}
		return (Long)res;
	}
	
	public long getMinValue(String propertyName){
		Criteria criteria = createCriteria();
		Object res = criteria.setProjection(Projections.min(propertyName)).uniqueResult();
		if(res == null){
			return 0;
		}
		return (Long)res;
	}
	
	public T findUnique(String [] propertyName,Object[]value){
		Criteria criteria = createCriteria();
		for(int i=0 ; i<propertyName.length;i++){
			criteria.add(Restrictions.eq(propertyName[i], value[i]));
		}
		return (T) criteria.uniqueResult();
	}
	
	@SuppressWarnings("rawtypes")
	public List findByHqlName(String hql){
		Query query = this.currentSession().getNamedQuery(hql);
		return query.list();
	}
	
	public List findByHqlName(String hql,Object[]params){
		Query query = this.currentSession().getNamedQuery(hql);
		for(int i=0;i<params.length;i++){
			query.setParameter(i, params[i]);
		}
		return query.list();
	}
	
	 @SuppressWarnings("rawtypes")
		public PagingData findPage(Criteria criteria, int startNo, int pageSize)
	    {
	        CriteriaImpl impl = (CriteriaImpl)criteria;
	        Projection projection = impl.getProjection();        

	        int totalCount = ((Long)criteria.setProjection(
	            Projections.rowCount()).uniqueResult()).intValue();
	        
	        criteria.setProjection(projection);
	        if (projection == null)
	        {
	            criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
	        }        

	        if (totalCount == 0)
	        {
	            return new PagingData();
	        }
	        
	        List list = criteria.setFirstResult(startNo).setMaxResults(pageSize).list();
	        PagingData page = new PagingData(totalCount, totalCount, list.toArray());        
	        return page;
	    }

	    public PagingData findPage(int startNo, int pageSize)
	    {
	        return findPage(new Criterion[] {}, startNo, pageSize);
	    }

	    public PagingData findPage(Criterion criterion, int startNo, int pageSize)
	    {
	        return findPage(createCriteria(criterion), startNo, pageSize);
	    }

	    public PagingData findPage(Criterion[] criterions, int startNo,int pageSize)
	    {
	        return findPage(createCriteria(criterions), startNo, pageSize);
	    }

	    public PagingData findPage(String orderBy, boolean isAsc,int startNo, int pageSize)
	    {
	        return findPage(orderBy, isAsc, new Criterion[] {}, startNo,pageSize);
	    }

	    public PagingData findPage(String orderBy, boolean isAsc,Criterion criterion, int startNo, int pageSize)
	    {
	        return findPage(orderBy, isAsc, new Criterion[] {criterion},startNo, pageSize);
	    }

	    public PagingData findPage(String orderBy, boolean isAsc,Criterion[] criterions, int startNo, int pageSize)
	    {
	        return findPage(createCriteria(orderBy, isAsc, criterions),startNo, pageSize);
	    }

	    public PagingData findPage(final String hql, final int startNo, final int pageSize)
	    {
	        return findPage(hql, startNo, pageSize, new Object[] {});
	    }

	    public PagingData findPage(final String hql, final int startNo,
	                         final int pageSize, final Object param)
	    {
	        return findPage(hql, startNo, pageSize, new Object[] {param});
	    }

	    @SuppressWarnings("rawtypes")
		public PagingData findPage(final String hql, final int startNo,
	                         final int pageSize, final Object[] params)
	    {
	        String countHql = getCountHql(hql);
	        Query countQuery = currentSession().createQuery(countHql);
	        Query query = currentSession().createQuery(hql);
	        for (int i = 0; i < params.length; i++ )
	        {
	            countQuery.setParameter(i, params[i]);
	            query.setParameter(i, params[i]);
	        }
	        int totalCount = ((Long)countQuery.iterate().next()).intValue();
	        if (totalCount == 0)
	        {
	            return new PagingData();
	        }        
	        List list = query.setFirstResult(startNo).setMaxResults(pageSize).list();
	        PagingData page = new PagingData(totalCount, totalCount, list.toArray());        
	        return page;
	    }

	    public PagingData findPageByNamedQuery(final String queryName, final int startNo,
	                                     final int pageSize)
	    {
	        return findPageByNamedQuery(queryName, startNo, pageSize,
	            new Object[] {});
	    }

	    public PagingData findPageByNamedQuery(final String queryName, final int startNo,
	                                     final int pageSize, Object param)
	    {
	        return findPageByNamedQuery(queryName, startNo, pageSize,
	            new Object[] {param});
	    }

	    public PagingData findPageByNamedQuery(final String queryName, final int startNo,
	                                     final int pageSize, Object[] params)
	    {
	        String hql = currentSession().getNamedQuery(queryName).getQueryString();
	        return findPage(hql, startNo, pageSize, params);
	    }
	    
	    public int getCount(){
	    	Criteria criteria = createCriteria();
	    	return ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
	    }
	    
	    protected String getCountHql(String hql)
	    {
	        Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
	            Pattern.CASE_INSENSITIVE);
	        Matcher m = p.matcher(hql);
	        StringBuffer sb = new StringBuffer();
	        while (m.find())
	        {
	            m.appendReplacement(sb, "");
	        }
	        hql = m.appendTail(sb).toString();
	        int pos = hql.toLowerCase().indexOf("from");
	        if (pos == -1)
	        {
	            throw new RuntimeException("Invalid hql for findPage: " + hql);
	        }
	        hql = hql.substring(pos);
	        String countHql = " select count(*) " + hql;
	        return countHql;
	    }

}
