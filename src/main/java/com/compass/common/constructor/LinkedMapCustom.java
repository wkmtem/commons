package com.compass.common.constructor;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * 
 * <p>Class Name: LinkedMapCustom</p>
 * <p>Description: 自定义LinkedMap类</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午12:14:11
 * @version 2.0
 */
public class LinkedMapCustom extends LinkedHashMap<String, Object> {
	
	private static final long serialVersionUID = -8543864472664802624L;
	
	/**
	 * 初始容量
	 */
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	/**
	 * 扩容倍率
	 */
	private static final float DEFAULT_LOAD_FACTOR = 0.5f;
	
	/**
	 * 初始容量1
	 */
	private static final int MAP_SINGLE_CAPACITY = 1;
	
	/**
	 * 
	 * <p>Constructor Name: </p>
	 * <p>Description: 禁用</p>
	 * @author wkm
	 * @date 2017年8月15日下午12:15:01
	 * @version 2.0
	 */
	private LinkedMapCustom() {
	}
	
	/**
	 * 
	 * <p>Constructor Name: </p>
	 * <p>Description: </p>
	 * @author wkm
	 * @date 2017年8月15日下午12:15:18
	 * @version 2.0
	 * @param initialCapacity 初始容量
	 * @param loadFactor 扩容率
	 */
	private LinkedMapCustom(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }
	
	public static LinkedMapCustom singleMap(String key, String value) {
		return new LinkedMapCustom.Builder(MAP_SINGLE_CAPACITY, DEFAULT_LOAD_FACTOR)
					.put(key, value)
					.builder();
	}
	
	public static LinkedMapCustom singleMap(String key, int value) {
		return new LinkedMapCustom.Builder(MAP_SINGLE_CAPACITY, DEFAULT_LOAD_FACTOR)
					.put(key, value)
					.builder();
	}
	
	public static LinkedMapCustom singleMap(String key, double value) {
		return new LinkedMapCustom.Builder(MAP_SINGLE_CAPACITY, DEFAULT_LOAD_FACTOR)
					.put(key, value)
					.builder();
	}
	
	public static LinkedMapCustom singleMap(String key, float value) {
		return new LinkedMapCustom.Builder(MAP_SINGLE_CAPACITY, DEFAULT_LOAD_FACTOR)
					.put(key, value)
					.builder();
	}
	
	public static LinkedMapCustom singleMap(String key, long value) {
		return new LinkedMapCustom.Builder(MAP_SINGLE_CAPACITY, DEFAULT_LOAD_FACTOR)
					.put(key, value)
					.builder();
	}
	
	public static LinkedMapCustom singleMap(String key, char value) {
		return new LinkedMapCustom.Builder(MAP_SINGLE_CAPACITY, DEFAULT_LOAD_FACTOR)
					.put(key, value)
					.builder();
	}
	
	public static LinkedMapCustom singleMap(String key, Date value) {
		return new LinkedMapCustom.Builder(MAP_SINGLE_CAPACITY, DEFAULT_LOAD_FACTOR)
					.put(key, value)
					.builder();
	}
	
	public static LinkedMapCustom singleMap(String key, Object value) {
		return new LinkedMapCustom.Builder(MAP_SINGLE_CAPACITY, DEFAULT_LOAD_FACTOR)
					.put(key, value)
					.builder();
	}
	
	public LinkedMapCustom put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	
	/**
	 * 
	 * <p>Class Name: Builder</p>
	 * <p>Description: 构建内部类</p>
	 * <p>Company: www.compass.com</p> 
	 * @author wkm
	 * @date 2017年8月15日下午12:17:18
	 * @version 2.0
	 */
	public static final class Builder {
		
		LinkedMapCustom map;
		
		/**
		 * 
		 * <p>Constructor Name: </p>
		 * <p>Description: </p>
		 * @author wkm
		 * @date 2017年8月15日下午12:17:51
		 * @version 2.0
		 */
		public Builder() {
			map = new LinkedMapCustom(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
		}
		
		public Builder(int initialCapacity, float loadFactor) {
			map = new LinkedMapCustom(initialCapacity, loadFactor);
		}
		
		public Builder put(String key, String value) {
			map.put(key, value);
			return this;
		}
		
		public Builder put(String key, int value) {
			map.put(key, value);
			return this;
		}
		
		public Builder put(String key, boolean value) {
			map.put(key, value);
			return this;
		}
		
		public Builder put(String key, byte value) {
			map.put(key, value);
			return this;
		}
		
		public Builder put(String key, float value) {
			map.put(key, value);
			return this;
		}
		
		public Builder put(String key, double value) {
			map.put(key, value);
			return this;
		}
		
		public Builder put(String key, long value) {
			map.put(key, value);
			return this;
		}
		
		public Builder put(String key, char value) {
			map.put(key, value);
			return this;
		}
		
		public Builder put(String key, Date value) {
			map.put(key, value);
			return this;
		}
		
		public Builder put(String key, Object value) {
			map.put(key, value);
			return this;
		}
		
		/**
		 * 
		 * <p>Method Name: builder</p>
		 * <p>Description: </p>
		 * @author wkm
		 * @date 2017年8月15日下午12:18:17
		 * @version 2.0
		 * @return linkedMap
		 */
		public LinkedMapCustom builder() {
			return map;
		}
	}
}
