package com.hms.model;
/**
 * <p>Title: PagingData.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年1月31日 下午2:37:30
 * @version 1.0
 */
public class PagingData {
	
	private String sEcho; 

    private int iTotalRecords; 

    private int iTotalDisplayRecords; 

    private Object[] aaData; 

    public PagingData() {
        this.sEcho = "";
        this.iTotalRecords = 0;
        this.iTotalDisplayRecords = 0;
        this.aaData = null;             
    }

    public PagingData(final int recordsTotal, final int recordsFiltered, Object[] data) {
    	this.iTotalRecords =recordsTotal;
        this.iTotalDisplayRecords = recordsFiltered;
        this.aaData = data;             
    }

	public String getSEcho() {
		return sEcho;
	}

	public void setSEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public int getITotalRecords() {
		return iTotalRecords;
	}

	public void setITotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getITotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setITotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public Object[] getAaData() {
		return aaData;
	}

	public void setAaData(Object[] aaData) {
		this.aaData = aaData;
	}

}
