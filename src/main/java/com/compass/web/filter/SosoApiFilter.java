package com.compass.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @Class Name: SosoApiFilter
 * @Description: SosoApi调试, App接口JSON过滤器，在web.xml中配置过滤
 * @author: wkm
 * @Company: www.compass.com
 * @Create date: 2017年8月14日下午4:03:56
 * @version: 2.0
 */
public class SosoApiFilter implements Filter {
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse resp = (HttpServletResponse)response;
		/**
		 * "*"存在风险，建议指定可信任的域名来接收响应信息，如"http://www.sosoapi.com"
		 */
		resp.addHeader("Access-Control-Allow-Origin", "*");
		
		/**
		 * 如果存在自定义的header参数，需要在此处添加，逗号分隔
		 */
		resp.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, "
				+ "If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, "
				+ "Content-Type, X-E4M-With");
		resp.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");  
		
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
