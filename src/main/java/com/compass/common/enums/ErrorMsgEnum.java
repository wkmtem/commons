package com.compass.common.enums;

/**
 * 
 * <p>Class Name: ErrorMsgEnum</p>
 * <p>Description: 错误代码描述枚举</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午12:23:40
 * @version 2.0
 */
public enum ErrorMsgEnum {
	
	EM00("EM00", ""),
	EM01("EM01", "企业账号不能为空"),
	EM02("EM02", "企业名称不能为空"),
	EM03("EM03", "企业账号不存在"),
	EM04("EM04", "企业账号尚未激活"),
	EM05("EM05", "企业账号注册失败"),
	EM06("EM06", "用户名不能为空"),
	EM07("EM07", "用户名不存在"),
	EM08("EM08", "密码不能为空"),
	EM09("EM09", "密码错误"),
	EM10("EM10", "用户注册失败"),
	EM11("EM11", "用户账号已删除"),
	EM12("EM12", "用户账号已停用"),
	EM13("EM13", "电子邮箱不能为空"),
	EM14("EM14", "电子邮箱格式错误"),
	EM15("EM15", "租户ID不能为空"),
	EM16("EM16", "MD5激活码不能为空"),
	EM17("EM17", "无效企业ID，或企业尚未注册"),
	EM18("EM18", "激活码已过期"),
	EM19("EM19", "激活码错误"),
	EM20("EM20", "企业账号已存在"),
	EM21("EM21", "未设置管理员账号"),
	EM22("EM22", "用户账号不存在"),
	EM23("EM23", "用户ID不能为空"),
	EM24("EM24", "用户Token不能为空"),
	EM25("EM25", "用户ID不存在"),
	EM26("EM26", "用户登录超时"),
	EM27("EM27", "激活成功"),
	EM28("EM28", "激活失败"),
	EM29("EM29", "激活超时"),
	EM30("EM30", "");

	public String code;
	public String value;
	
	ErrorMsgEnum(String code, String value){
		this.code = code;
		this.value = value;
	}
}
