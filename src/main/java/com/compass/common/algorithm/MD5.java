package com.compass.common.algorithm;

import java.security.MessageDigest;

/**
 * 
 * <p>Class Name: MD5</p>
 * <p>Description: MD5工具类</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午12:10:59
 * @version 2.0
 */
public class MD5 {
	public static String getMD5(String sourceStr) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = sourceStr.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>>
															// 为逻辑右移，将符号位一起右移

				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	/**
	 * 
	 * <p>Method Name: get2MD5StrByTimeMillis</p>
	 * <p>Description: 根据时间戳获取2次MD5大写32位字符串</p>
	 * @author wkm
	 * @date 2017年8月15日下午12:12:00
	 * @version 2.0
	 * @return String code 32bit
	 */
	public static String get2MD5StrByTimeMillis() {
		return getMD5(getMD5(System.currentTimeMillis() + "")).toUpperCase();
	}
	
	
	/**
	 * 
	 * <p>Method Name: get2MD5StrBySaltWithPwd</p>
	 * <p>Description: 根据散列盐和明文密码获取2次MD5大写32位字符串</p>
	 * @author wkm
	 * @date 2017年8月15日下午12:12:48
	 * @version 2.0
	 * @param salt 盐
	 * @param pwd 密码
	 * @return String code 32bit
	 */
	public static String get2MD5StrBySaltWithPwd(String salt, String pwd) {
		return getMD5(getMD5(salt + pwd)).toUpperCase();
	}
}
