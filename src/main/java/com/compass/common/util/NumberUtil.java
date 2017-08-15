package com.compass.common.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 
 * <p>Class Name: NumberUtil</p>
 * <p>Description: 数字工具类</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午2:01:46
 * @version 2.0
 */
public class NumberUtil {

	/**
	 * 
	 * <p>Method Name: getStrNumber</p>
	 * <p>Description: 格式化数字为定宽字符串(位数不足，前面补0)</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:02:00
	 * @version 2.0
	 * @param sourceNum 需格式化的原数字
	 * @param formatPattern 格式化的位数
	 * @return String targetFormatNum
	 * @throws Exception
	 */
	public static String getStrNumber(Integer sourceNum, String formatPattern) throws Exception {
		NumberFormat numberFormat = new DecimalFormat(formatPattern);
		return numberFormat.format(sourceNum);
	}
}
