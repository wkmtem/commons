package com.compass.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.common.base.Charsets;

/**
 * 
 * <p>Class Name: httpUtil</p>
 * <p>Description: http工具类</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午2:08:50
 * @version 2.0
 */
public class httpUtil {
	
	/**
	 * 
	 * <p>Method Name: getIPaddress</p>
	 * <p>Description: 通过HttpServletRequest获取IP地址</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:09:03
	 * @version 2.0
	 * @param request
	 * @return String ip
	 * @throws Exception
	 */
	public static String getIPaddress(HttpServletRequest request) throws Exception {
		
		String ip = request.getHeader("x-forwarded-for");
		
		if (ip == null || ip.length() == 0
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 
	 * <p>Method Name: sendGet</p>
	 * <p>Description: 发送GET请求</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:13:34
	 * @version 2.0
	 * @param url 发送请求的URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式
	 * @return String 远程资源响应结果
	 */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("Cookie", param);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            //Map<String, List<String>> map = connection.getHeaderFields();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    
    /**
     * 
     * <p>Method Name: sendGet</p>
     * <p>Description: 发送GET请求</p>
     * @author wkm
     * @date 2017年8月15日下午2:17:44
     * @version 2.0
     * @param url 发送请求的URL
     * @param param 请求参数
     * @param headers 请求头参数
     * @param timeout 超时时间
     * @return String 远程资源响应结果
     */
    public static String sendGet(String url, String param, Map<String, String> headers, int timeout) {
        String result = "";
        BufferedReader in = null;
        String reqUrl = url ;
        try {
            // 构造httprequest设置
            RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout)
                    .setConnectionRequestTimeout(timeout).build();
            HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
            HttpGet htGet = new HttpGet(reqUrl);
            // 添加http headers
            if (headers != null && headers.size() > 0) {
                for (String key : headers.keySet()) {
                    htGet.addHeader(key, headers.get(key));
                }
            }
            // 读取数据
            HttpResponse r = client.execute(htGet);
            in = new BufferedReader(new InputStreamReader(r.getEntity().getContent(), Charsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
	 * 
	 * <p>Method Name: sendPost</p>
	 * <p>Description: 发送POST请求</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:13:34
	 * @version 2.0
	 * @param url 发送请求的URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式
	 * @return String 远程资源响应结果
	 */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        // 关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }  
}
