package com.compass.common.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.compass.common.constant.Constant;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * 
 * <p>Class Name: JsonMapper</p>
 * <p>Description: json与对象转换工具类</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午12:24:03
 * @version 2.0
 */
public class JsonMapper {

	private ObjectMapper mapper;

	  public JsonMapper(Include inclusion) {
	    mapper = new ObjectMapper();
	    /*
	     * 设置输出时包含属性的风格
	     */
	    mapper.setSerializationInclusion(inclusion);
	    /*
	     * 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
	     */
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    /*
	     * 禁止使用int代表Enum的order()來反序列化Enum,非常危險
	     */
	    mapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
	    
	  }

	  /**
	   * 
	   * <p>Method Name: buildNormalMapper</p>
	   * <p>Description: 创建输出全部属性到Json字符串的Mapper</p>
	   * @author wkm
	   * @date 2017年8月15日下午1:47:36
	   * @version 2.0
	   * @return JsonMapper
	   */
	  public static JsonMapper buildNormalMapper() {
	    return new JsonMapper(Include.ALWAYS);
	  }

	  /**
	   * 
	   * <p>Method Name: buildNonNullMapper</p>
	   * <p>Description: 创建只输出非空属性到Json字符串的Mapper</p>
	   * @author wkm
	   * @date 2017年8月15日下午1:48:28
	   * @version 2.0
	   * @return JsonMapper
	   */
	  public static JsonMapper buildNonNullMapper() {
	    return new JsonMapper(Include.NON_NULL);
	  }

	  /**
	   * 
	   * <p>Method Name: buildNonDefaultMapper</p>
	   * <p>Description: 创建只输出初始值被改变的属性到Json字符串的Mapper</p>
	   * @author wkm
	   * @date 2017年8月15日下午1:48:55
	   * @version 2.0
	   * @return JsonMapper
	   */
	  public static JsonMapper buildNonDefaultMapper() {
	    return new JsonMapper(Include.NON_DEFAULT);
	  }

	  /**
	   * 
	   * <p>Method Name: buildNonEmptyMapper</p>
	   * <p>Description: 创建只输出非Null且非Empty(如List.isEmpty)的属性到Json字符串的Mapper</p>
	   * @author wkm
	   * @date 2017年8月15日下午1:49:09
	   * @version 2.0
	   * @return JsonMapper
	   */
	  public static JsonMapper buildNonEmptyMapper() {
	    return new JsonMapper(Include.NON_EMPTY);
	  }

	  /**
	   * 
	   * <p>Method Name: toJson</p>
	   * <p>Description: toJson</p>
	   * @author wkm
	   * @date 2017年8月15日下午1:49:26
	   * @version 2.0
	   * @param object
	   * @return 如果对象为Null, 返回"null"； 如果集合为空集合, 返回"[]"
	   */
	  public String toJson(Object object) {

	    try {
	      return mapper.writeValueAsString(object);
	    } catch (IOException e) {
	    }
		return null;
	  }

	  /**
	   * 
	   * <p>Method Name: fromJson</p>
	   * <p>Description: 如需读取集合如List/Map, 且不是List<String>这种简单类型时,先使用函數constructParametricType构造类型</p>
	   * @author wkm
	   * @date 2017年8月15日下午1:50:23
	   * @version 2.0
	   * @param jsonString JSON串
	   * @param clazz 需转换对象的类
	   * @return 如果JSON字符串为Null或"null"字符串, 返回Null；如果JSON字符串为"[]", 返回空集合	      
	   */
	  public <T> T fromJson(String jsonString, Class<T> clazz) {
	    if (StringUtils.isEmpty(jsonString)) {
	        return null;
	    }

	    try {
	        return mapper.readValue(jsonString, clazz);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		return null;
	  }

	  /**
	   * 
	   * <p>Method Name: fromJson</p>
	   * <p>Description: 如需读取集合如List/Map, 且不是List<String>这种简单类型时,先使用函數constructParametricType构造类型</p>
	   * @author wkm
	   * @date 2017年8月15日下午1:52:13
	   * @version 2.0
	   * @param jsonString JSON串
	   * @param javaType java类型
	   * @return 如果JSON字符串为Null或"null"字符串, 返回Null；如果JSON字符串为"[]", 返回空集合
	   */
	  @SuppressWarnings("unchecked")
	  public <T> T fromJson(String jsonString, JavaType javaType) {
	    if (StringUtils.isEmpty(jsonString)) {
	      return null;
	    }

	    try {
	      return (T) mapper.readValue(jsonString, javaType);
	    } catch (IOException e) {
	    }
		return null;
	  }
	  
	  /**
	   * 
	   * <p>Method Name: fromJson</p>
	   * <p>Description: </p>
	   * @author wkm
	   * @date 2017年8月15日下午1:53:34
	   * @version 2.0
	   * @param jsonString
	   * @param parametrized
	   * @param parameterClasses
	   * @return 类对象
	   */
	  @SuppressWarnings("unchecked")
	  public <T> T fromJson(String jsonString, Class<?> parametrized, Class<?>... parameterClasses) {
	    return (T) this.fromJson(jsonString, constructParametricType(parametrized, parameterClasses));
	  }
	  
	  /**
	   * 
	   * <p>Method Name: fromJsonToList</p>
	   * <p>Description: </p>
	   * @author wkm
	   * @date 2017年8月15日下午1:53:38
	   * @version 2.0
	   * @param jsonString
	   * @param classMeta
	   * @return 类对象集合
	   */
	  @SuppressWarnings("unchecked")
	  public <T> List<T> fromJsonToList(String jsonString, Class<T> classMeta){
	    return (List<T>) this.fromJson(jsonString,constructParametricType(List.class, classMeta));
	  }
	  
	  /**
	   * 
	   * <p>Method Name: constructParametricType</p>
	   * <p>Description: 構造泛型的Type如List<MyBean>, 则调用constructParametricType(ArrayList.class,MyBean.class)
	   *                 Map<String,MyBean>则调用(HashMap.class,String.class, MyBean.class)</p>
	   * @author wkm
	   * @date 2017年8月15日下午1:54:17
	   * @version 2.0
	   * @param parametrized
	   * @param parameterClasses
	   * @return
	   */
	  public JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses) {
	    return mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
	  }

	  /**
	   * 
	   * <p>Method Name: update</p>
	   * <p>Description: 当JSON中含有Bean的部分属性时，更新一个已存在Bean，只覆盖该部分的属性</p>
	   * @author wkm
	   * @date 2017年8月15日下午1:57:14
	   * @version 2.0
	   * @param object
	   * @param jsonString JSON串
	   * @return
	   */
	  @SuppressWarnings("unchecked")
	  public <T> T update(T object, String jsonString) {
	    try {
	      return (T) mapper.readerForUpdating(object).readValue(jsonString);
	    } catch (JsonProcessingException e) {
	      //logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
	    } catch (IOException e) {
	     // logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
	    }
	    return null;
	  }

	  /**
	   * 
	   * <p>Method Name: toJsonP</p>
	   * <p>Description: toJsonP</p>
	   * @author wkm
	   * @date 2017年8月15日下午1:58:36
	   * @version 2.0
	   * @param functionName 函数名称
	   * @param object 对象
	   * @return 返回JSONP格式数据
	   */
	  public String toJsonP(String functionName, Object object) {
	    return toJson(new JSONPObject(functionName, object));
	  }

	  /**
	   * 
	   * <p>Method Name: getMapper</p>
	   * <p>Description: 获取Mapper做进一步的设置或使用其他序列化API</p>
	   * @author wkm
	   * @date 2017年8月15日下午1:59:46
	   * @version 2.0
	   * @return ObjectMapper
	   */
	  public ObjectMapper getMapper() {
	    return mapper;
	  }
	  
	  public JsonNode parseNode(String json){
	    try {
	      return mapper.readValue(json, JsonNode.class);
	    } catch (IOException e) {
	    }
		return null;
	  }
	  
	  /**
	   * 
	   * <p>Method Name: toNormalJson</p>
	   * <p>Description: 输出全部属性</p>
	   * @author wkm
	   * @date 2017年8月15日下午2:00:24
	   * @version 2.0
	   * @param object
	   * @return 
	   */
	  public static String toNormalJson(Object object){
	    return new JsonMapper(Include.ALWAYS).toJson(object);
	  }
	  
	  /**
	   * 
	   * <p>Method Name: toNonNullJson</p>
	   * <p>Description: 输出非空属性</p>
	   * @author wkm
	   * @date 2017年8月15日下午2:00:46
	   * @version 2.0
	   * @param object
	   * @return
	   */
	  public static String toNonNullJson(Object object){
	    return new JsonMapper(Include.NON_NULL).toJson(object);
	  }
	  
	  /**
	   * 
	   * @Method Name: toNonDefaultJson
	   * @Description: 输出初始值被改变部分的属性
	   * @params:
	   * @author: wkm
	   * @version: 2.0
	   * @Create date: 2017年8月13日上午11:31:04
	   * @param object
	   * @return:
	   */
	  public static String toNonDefaultJson(Object object){
	    return new JsonMapper(Include.NON_DEFAULT).toJson(object);
	  }
	  
	  /**
	   * 
	   * @Method Name: toNonEmptyJson
	   * @Description: 输出非Null且非Empty(如List.isEmpty)的属性
	   * @params:
	   * @author: wkm
	   * @version: 2.0
	   * @Create date: 2017年8月13日上午11:31:12
	   * @param object
	   * @return:
	   */
	  public static String toNonEmptyJson(Object object){
	    return new JsonMapper(Include.NON_EMPTY).toJson(object);
	  }
	  
	  public void setDateFormat(String dateFormat){
	    mapper.setDateFormat(new SimpleDateFormat(dateFormat));
	  }
	  
	  public static String toLogJson(Object object){
	    JsonMapper jsonMapper = new JsonMapper(Include.ALWAYS);
	    jsonMapper.setDateFormat(Constant.DATE_FORMAT_DATETIME);
	    return jsonMapper.toJson(object);
	  }
	  
	  /**
	   * 
	   * @Method Name: toLogJson1
	   * @Description: 输出非Null且非Empty(如List.isEmpty)带自定义时间格式的属性
	   * @params:
	   * @author: wkm
	   * @version: 2.0
	   * @Create date: 2017年8月13日上午11:31:19
	   * @param object
	   * @return:
	   */
	  public static String toLogJson1(Object object){
		    JsonMapper jsonMapper = new JsonMapper(Include.NON_EMPTY);
		    jsonMapper.setDateFormat(Constant.DATE_FORMAT_DATETIME);
		    return jsonMapper.toJson(object);
	}
}
