package com.compass.common.http;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * <p>Class Name: HttpRequest</p>
 * <p>Description: http请求request对象的基本操作</p>
 * 				      必须在web.xml中添加监听org.springframework.web.context.request.RequestContextListener
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月16日下午2:55:38
 * @version 2.0
 */
public class HttpRequest {
	
	private HttpServletRequest request;
	
	private HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();
	}

	public HttpServletRequest getRequest() {
		if(null == request){
			request = getHttpServletRequest();
		}
		return request;
	}
	
	/**
	 * 
	 * <p>Method Name: getBaseURL</p>
	 * <p>Description: 获取当前协议域名IP端口</p>
	 * @author wkm
	 * @date 2017年8月16日下午2:48:20
	 * @version 2.0
	 * @return http://www.domain.com:port
	 */
	public String getBaseURL() {
		String scheme = getRequest().getScheme();
		String serverName = getRequest().getServerName();
		int serverPort = getRequest().getServerPort();
		return scheme + "://" + serverName + (serverPort == 80 ? "" : (":" + serverPort));
	}
	
	/**
	 * 
	 * <p>Method Name: getContextPath</p>
	 * <p>Description: 获取应用相对路径</p>
	 * @author wkm
	 * @date 2017年8月16日下午2:53:21
	 * @version 2.0
	 * @return /project
	 */
	public String getContextPath() {
		return getRequest().getContextPath();
	}
	
	/**
	 * 
	 * <p>Method Name: getRealPath</p>
	 * <p>Description: 获取当前应用的服务器绝对路径</p>
	 * @author wkm
	 * @date 2017年8月16日下午2:48:09
	 * @version 2.0
	 * @return /home/tomcat/project_name/
	 */
	public String getRealPath() {
		return getRequest().getServletContext().getRealPath("/");
	}
	
	/**
	 * 
	 * <p>Method Name: getRequestURL</p>
	 * <p>Description: 获取完整的请求地址</p>
	 * @author wkm
	 * @date 2017年8月16日下午3:02:56
	 * @version 2.0
	 * @return http://www.domain.com:port/project/module/index.jsp
	 */
	public String getRequestURL() {
		return getRequest().getRequestURL().toString();
	}
	
	/**
	 * 
	 * <p>Method Name: getRequestURI</p>
	 * <p>Description: 获取完整的资源地址</p>
	 * @author wkm
	 * @date 2017年8月16日下午3:04:32
	 * @version 2.0
	 * @return /project/module/index.jsp
	 */
	public String getRequestURI() {
		return getRequest().getRequestURI();
	}

	/**
	 * 
	 * <p>Method Name: getRemoteAddr</p>
	 * <p>Description: 获取客户端IP</p>
	 * @author wkm
	 * @date 2017年8月16日下午3:09:48
	 * @version 2.0
	 * @return xxx.xxx.xxx.xxx
	 */
	public String getRemoteAddr() {
		return getRequest().getRemoteAddr();
	}
	
}
