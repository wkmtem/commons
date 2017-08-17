package com.compass.common.enums;

/**
 * 
 * <p>Class Name: RetCodeMsgEnum</p>
 * <p>Description: 响应码描述枚举常量</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午12:23:40
 * @version 2.0
 */
public enum RetCodeMsgEnum {
	
	RC000("RC000", "请求成功"),
	RC001("RC001", "企业账号不能为空"),
	RC002("RC002", "企业账号不存在"),
	RC003("RC003", "企业账号已存在"),
	RC004("RC004", "企业账号未激活"),
	RC005("RC005", "企业账号注册失败"),
	RC006("RC006", "企业账号已激活"),
	RC007("RC007", "企业名称不能为空"),
	RC008("RC008", "企业ID不能为空"),
	RC009("RC009", "企业ID不存在"),
	RC010("RC010", "未设置管理员账号"),
	RC011("RC011", "尚未发送激活邮件"),
	RC012("RC012", "用户账号不能为空"),
	RC013("RC013", "用户账号不存在"),
	RC014("RC014", "用户账号已存在"),
	RC015("RC015", "用户账号注册失败"),
	RC016("RC016", "用户账号已删除"),
	RC017("RC017", "用户账号已停用"),
	RC018("RC018", "用户ID不能为空"),
	RC019("RC019", "用户ID不存在"),
	RC020("RC020", "用户Token不能为空"),
	RC021("RC021", "用户登录超时"),
	RC022("RC022", "密码不能为空"),
	RC023("RC023", "密码错误"),
	RC024("RC024", "电子邮箱不能为空"),
	RC025("RC025", "电子邮箱格式错误"),
	RC026("RC026", "MD5激活码不能为空"),
	RC027("RC027", "激活码已失效"),
	RC028("RC028", ""),
	RC029("RC029", ""),
	RC030("RC030", ""),
	RC031("RC031", ""),
	RC032("RC032", ""),
	RC033("RC033", ""),
	RC034("RC034", ""),
	RC035("RC035", "");

	public String code;
	public String value;
	
	RetCodeMsgEnum(String code, String value){
		this.code = code;
		this.value = value;
	}
}
