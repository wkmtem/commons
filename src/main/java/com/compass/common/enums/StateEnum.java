package com.compass.common.enums;

/**
 * 
 * <p>Class Name: StateEnum</p>
 * <p>Description: 状态枚举常量</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月17日下午6:00:08
 * @version 2.0
 */
public enum StateEnum {
	
	SUCCEEDED("1", "SUCCEEDED"),
	FAILED("0", "FAILED");

	public String code;
	public String value;
	
	StateEnum(String code, String value){
		this.code = code;
		this.value = value;
	}
}
