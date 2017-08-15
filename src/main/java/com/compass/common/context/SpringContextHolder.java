package com.compass.common.context;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * <p>Class Name: SpringContextHolder</p>
 * <p>Description: Spring容器工具类</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午12:18:59
 * @version 2.0
 */
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
	 
    private static ApplicationContext applicationContext = null;
    private static Logger LOGGER = Logger.getLogger(SpringContextHolder.class);
 
    /**
     * 
     * <p>Method Name: getApplicationContext</p>
     * <p>Description: 获取存储在静态变量中的ApplicationContext</p>
     * @author wkm
     * @date 2017年8月15日下午12:19:21
     * @version 2.0
     * @return applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }
 
    /**
     * 
     * <p>Method Name: getBean</p>
     * <p>Description: 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型</p>
     * @author wkm
     * @date 2017年8月15日下午12:19:52
     * @version 2.0
     * @param name bean名称
     * @return bean对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        LOGGER.debug("从SpringContextHolder中取出Bean:" + name);
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }
 
    /**
     * 
     * <p>Method Name: getBean</p>
     * <p>Description: 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型</p>
     * @author wkm
     * @date 2017年8月15日下午12:20:18
     * @version 2.0
     * @param requiredType bean类型
     * @return bean对象
     */
    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return applicationContext.getBean(requiredType);
    }
 
    /**
     * 
     * <p>Method Name: clearHolder</p>
     * <p>Description: 清除SpringContextHolder中的ApplicationContext</p>
     * @author wkm
     * @date 2017年8月15日下午12:21:12
     * @version 2.0
     */
    public static void clearHolder() {
        LOGGER.debug("清除SpringContextHolder中的ApplicationContext:"
                + applicationContext);
        applicationContext = null;
    }
 
    /**
     * （非 Javadoc）
     * <p>Method Name: setApplicationContext</p>
     * <p>Description: 实现ApplicationContextAware接口, 注入Context到静态变量中</p>
     * @author wkm
     * @date 2017年8月15日下午12:21:42
     * @version 2.0
     * @param applicationContext
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
    	LOGGER.debug("注入ApplicationContext到SpringContextHolder:" + applicationContext);
 
        if (SpringContextHolder.applicationContext != null) {
            LOGGER.warn("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:" + SpringContextHolder.applicationContext);
        }
        SpringContextHolder.applicationContext = applicationContext; // NOSONAR
    }
 
    /**
     * （非 Javadoc）
     * <p>Method Name: destroy</p>
     * <p>Description: 实现DisposableBean接口, 在Context关闭时清理静态变量</p>
     * @author wkm
     * @date 2017年8月15日下午12:22:18
     * @version 2.0
     * @throws Exception
     * @see org.springframework.beans.factory.DisposableBean#destroy()
     */
    @Override
    public void destroy() throws Exception {
        SpringContextHolder.clearHolder();
    }
 
    /**
     * 
     * <p>Method Name: assertContextInjected</p>
     * <p>Description: 检查ApplicationContext不为空</p>
     * @author wkm
     * @date 2017年8月15日下午12:22:36
     * @version 2.0
     */
    private static void assertContextInjected() {
        if(applicationContext == null) {
            throw new IllegalStateException("applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
        }
    }
}

