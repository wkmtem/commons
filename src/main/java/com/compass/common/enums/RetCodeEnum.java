package com.compass.common.enums;

/**
 * 
 * <p>Class Name: RetCodeEnum</p>
 * <p>Description: 响应代码描述枚举</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午12:23:11
 * @version 2.0
 */
public enum RetCodeEnum {
	
	SUCCEEDED("1", "SUCCEEDED"),
	FAILED("0", "FAILED");

	public String code;
	public String value;
	
	RetCodeEnum(String code, String value){
		this.code = code;
		this.value = value;
	}
}
