package com.compass.common.uuid;

import java.net.InetAddress;
import java.util.UUID;

/**
 * 
 * <p>Class Name: UUIDBuild</p>
 * <p>Description: UUID工具类,模拟Hibernate的UUID生成规则--当前时间戳、当前ip、随机串等信息组合在一起生成UUID</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午2:45:09
 * @version 2.0
 */
public class UUIDBuild {
	
	private String sep = "";
	private static final int IP;
	private static short counter = (short) 0;
	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);
	private static UUIDBuild uuidgen = new UUIDBuild();

	static {
		int ipadd;
		try {
			ipadd = toInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}

	/**
	 * 
	 * <p>Method Name: getInstance</p>
	 * <p>Description: 获取实例</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:46:44
	 * @version 2.0
	 * @return
	 */
	public static UUIDBuild getInstance() {
		return uuidgen;
	}

	/**
	 * 
	 * <p>Method Name: toInt</p>
	 * <p>Description: 字节转int</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:47:36
	 * @version 2.0
	 * @param bytes 字节数组
	 * @return int
	 */
	public static int toInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}

	protected String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	protected String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	protected int getJVM() {
		return JVM;
	}

	protected synchronized short getCount() {
		if (counter < 0) {
			counter = 0;
		}
		return counter++;
	}

	protected int getIP() {
		return IP;
	}

	protected short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	protected int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	/**
	 * 
	 * <p>Method Name: generate</p>
	 * <p>Description: 获取当前信息串</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:48:14
	 * @version 2.0
	 * @return String
	 */
	public String generate() {
		return new StringBuffer(36).append(format(getIP())).append(sep)
				.append(format(getJVM())).append(sep)
				.append(format(getHiTime())).append(sep)
				.append(format(getLoTime())).append(sep)
				.append(format(getCount())).toString();
	}
	
	/**
	 * 
	 * <p>Method Name: getUUID</p>
	 * <p>Description: 获取单个UUID</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:49:33
	 * @version 2.0
	 * @return String 大写UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		return (s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
				+ s.substring(19, 23) + s.substring(24)).toUpperCase();
	}
	
	/**
	 * 
	 * <p>Method Name: getUUID</p>
	 * <p>Description: 获取多个UUID</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:51:34
	 * @version 2.0
	 * @param number 指定个数
	 * @return String数组
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] UUIDs = new String[number];
		for (int i = 0; i < UUIDs.length; i++) {
			UUIDs[i] = getUUID();
		}
		return UUIDs;
	}
	
	/**
	 * 
	 * <p>Method Name: getUUID64Bit</p>
	 * <p>Description: 获取单个64位的UUID</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:52:58
	 * @version 2.0
	 * @return String UUID
	 */
	public static String getUUID64Bit() {
		String[] UUIDs = getUUID(2);
		return UUIDs[0] + UUIDs[1];
	}
}
