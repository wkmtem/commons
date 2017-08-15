package com.compass.mvc.component.json.date;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.compass.common.constant.Constant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

/**
 * 
 * <p>Class Name: JsonDateMutualComponent</p>
 * <p>Description: Json与Date对象双向转换工具类</p>
 * 				   Json转Date，@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")配置在Date的get方法上(必须)
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午3:07:41
 * @version 2.0
 */
public class JsonDateMutualComponent {

	private static final ObjectMapper mapper;

	public ObjectMapper getMapper() {
		return mapper;
	}

	static {
		// yyyy-MM-dd HH:mm:ss
		DateFormat dateFormat = new SimpleDateFormat(Constant.DATE_FORMAT_DATETIME);

		mapper = new ObjectMapper();
		mapper.setDateFormat(dateFormat);
		mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {

			/** serialVersionUID */
			private static final long serialVersionUID = -1196061249386097525L;

			@Override
			public Object findSerializer(Annotated a) {
				if (a instanceof AnnotatedMethod) {
					AnnotatedElement m = a.getAnnotated();
					DateTimeFormat an = m.getAnnotation(DateTimeFormat.class);
					if (an != null) {
						if (!Constant.DATE_FORMAT_DATETIME.equals(an.pattern())) {
							return new JsonDateSerializer(an.pattern());
						}
					}
				}
				return super.findSerializer(a);
			}
		});
	}
	

	/**
	 * 
	 * <p>Method Name: toJson</p>
	 * <p>Description: 对象转JSON</p>
	 * @author wkm
	 * @date 2017年8月15日下午3:09:41
	 * @version 2.0
	 * @param obj对象
	 * @return JSON
	 */
	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException("转换json字符失败!");
		}
	}
	

	/**
	 * 
	 * <p>Method Name: toObject</p>
	 * <p>Description: JSON转对象</p>
	 * @author wkm
	 * @date 2017年8月15日下午3:10:49
	 * @version 2.0
	 * @param json串
	 * @param clazz 对象类
	 * @return 对象
	 */
	public <T> T toObject(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			throw new RuntimeException("将json字符转换为对象时失败!");
		}
	}

	
	/**
	 * 
	 * <p>Class Name: JsonDateSerializer</p>
	 * <p>Description: JSON日期序列化</p>
	 * <p>Company: www.compass.com</p> 
	 * @author wkm
	 * @date 2017年8月15日下午3:11:38
	 * @version 2.0
	 */
	public static class JsonDateSerializer extends JsonSerializer<Date> {
		private SimpleDateFormat dateFormat;

		public JsonDateSerializer(String format) {
			dateFormat = new SimpleDateFormat(format);
		}

		@Override
		public void serialize(Date date, JsonGenerator gen,
				SerializerProvider provider) throws IOException,
				JsonProcessingException {
			String value = dateFormat.format(date);
			gen.writeString(value);
		}
	}
}
