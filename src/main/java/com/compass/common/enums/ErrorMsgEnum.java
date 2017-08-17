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
	
	EM000("EM000", ""),
	EM001("EM001", "企业账号不能为空"),
	EM002("EM002", "企业账号不存在"),
	EM003("EM003", "企业账号已存在"),
	EM004("EM004", "企业账号未激活"),
	EM005("EM005", "企业账号注册失败"),
	EM006("EM006", "企业账号已激活"),
	EM007("EM007", "企业名称不能为空"),
	EM008("EM008", "企业ID不能为空"),
	EM009("EM009", "企业ID不存在"),
	EM010("EM010", "未设置管理员账号"),
	EM011("EM011", "尚未发送激活邮件"),
	EM012("EM012", "用户账号不能为空"),
	EM013("EM013", "用户账号不存在"),
	EM014("EM014", "用户账号已存在"),
	EM015("EM015", "用户账号注册失败"),
	EM016("EM016", "用户账号已删除"),
	EM017("EM017", "用户账号已停用"),
	EM018("EM018", "用户ID不能为空"),
	EM019("EM019", "用户ID不存在"),
	EM020("EM020", "用户Token不能为空"),
	EM021("EM021", "用户登录超时"),
	EM022("EM022", "密码不能为空"),
	EM023("EM023", "密码错误"),
	EM024("EM024", "电子邮箱不能为空"),
	EM025("EM025", "电子邮箱格式错误"),
	EM026("EM026", "MD5激活码不能为空"),
	EM027("EM027", "激活码已失效"),
	EM028("EM028", ""),
	EM029("EM029", ""),
	EM030("EM030", ""),
	EM031("EM031", ""),
	EM032("EM032", ""),
	EM033("EM033", ""),
	EM034("EM034", ""),
	EM035("EM035", "");

	public String code;
	public String value;
	
	ErrorMsgEnum(String code, String value){
		this.code = code;
		this.value = value;
	}
}
