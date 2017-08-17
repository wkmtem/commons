package com.compass.common.algorithm;

import java.io.UnsupportedEncodingException;

/**
 * 
 * <p>Class Name: Base64</p>
 * <p>Description: Base64 加解密工具类</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月17日下午5:23:31
 * @version 2.0
 */
public class Base64 {
	
	/**
	 * 
	 * <p>Method Name: base64Eecode</p>
	 * <p>Description: base64加密-UTF-8</p>
	 * @author wkm
	 * @date 2017年8月17日下午5:20:21
	 * @version 2.0
	 * @param source 输入字符串
	 * @return base64加密字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String base64Eecode(String source) throws UnsupportedEncodingException {
		 byte[] result = org.apache.commons.codec.binary.Base64.encodeBase64(source.getBytes("UTF-8"));
		 return new String(result, "UTF-8");
	}
	
	
	/**
	 * 
	 * <p>Method Name: base64Decode</p>
	 * <p>Description: base64解密-UTF-8</p>
	 * @author wkm
	 * @date 2017年8月17日下午4:13:54
	 * @version 2.0
	 * @param base64Str base64加密字符串
	 * @return base64解密字符串
	 * @throws UnsupportedEncodingException 
	 */
	public static String base64Decode(String base64Str) throws UnsupportedEncodingException {
		byte[] result = org.apache.commons.codec.binary.Base64.decodeBase64(base64Str);
		return new String(result, "UTF-8");
	}
}
