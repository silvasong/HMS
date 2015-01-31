package com.hms.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>Title: SecurityTools.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年1月31日 下午1:56:30
 * @version 1.0
 */
public class SecurityTools {
	
	public static String SHA1(String str){
		try {   
			    StringBuffer hexStr = new StringBuffer();
	            MessageDigest digest = java.security.MessageDigest
	                    .getInstance("SHA-1");
	            digest.update(str.getBytes());
	            byte messageDigest[] = digest.digest();
	            for (int i = 0; i < messageDigest.length; i++) {
	                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
	                if (shaHex.length() < 2) {
	                	hexStr.append(0);
	                }
	                hexStr.append(shaHex);
	            }
	            return hexStr.toString();
	 
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return "";
	   }

}
