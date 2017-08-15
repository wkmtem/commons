package com.compass.api.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <p>Class Name: SessionProvider</p>
 * <p>Description: Session供应类接口（4个方法），配置xml实例化</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日上午11:48:40
 * @version 2.0
 */
public interface SessionProvider {

	/**
	 * 
	 * <p>Method Name: setAttribute</p>
	 * <p>Description: 设置session值</p>
	 * @author wkm
	 * @date 2017年8月15日上午11:49:02
	 * @version 2.0
	 * @param request 调用者传入
	 * @param response 调用者传入
	 * @param name 值名称
	 * @param value 设置的值（必须实现序列化）
	 */
	void setAttribute(HttpServletRequest request, HttpServletResponse response, String name, Serializable value);
	
	/**
	 * 
	 * <p>Method Name: getAttribute</p>
	 * <p>Description: 从session中取值</p>
	 * @author wkm
	 * @date 2017年8月15日上午11:51:49
	 * @version 2.0
	 * @param request 调用者传入
	 * @param response 调用者传入
	 * @param name 值名称
	 * @return Serializable value的对象
	 */
	Serializable getAttribute(HttpServletRequest request, HttpServletResponse response, String name);
	
	/**
	 * 
	 * <p>Method Name: logout</p>
	 * <p>Description: 退出登录, 销毁session</p>
	 * @author wkm
	 * @date 2017年8月15日上午11:54:07
	 * @version 2.0
	 * @param request 调用者传入
	 * @param response 调用者传入
	 */
	void logout(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 
	 * <p>Method Name: getSessionId</p>
	 * <p>Description: 获取sessionID</p>
	 * @author wkm
	 * @date 2017年8月15日上午11:54:50
	 * @version 2.0
	 * @param request 调用者传入
	 * @param response 调用者传入
	 * @return String sessionId
	 */
	String getSessionId(HttpServletRequest request, HttpServletResponse response);
}
