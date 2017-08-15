package com.compass.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Class Name: DateUtil
 * @Description: 
 * @author: wkm
 * @Company: www.compass.com
 * @Create date: 2016-11-27下午2:39:32
 * @version: 2.0
 */
public class DateUtil {
	
	
	/**
	 * 
	 * <p>Method Name: strDateToDate</p>
	 * <p>Description: 字符串日期转Date类型</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:05:22
	 * @version 2.0
	 * @param strDate 字符串日期
	 * @param formatPattern 日期格式
	 * @return Date
	 * @throws Exception
	 */
	public static Date strDateToDate(String strDate, String formatPattern) throws Exception {
		DateFormat dateFormat = 
				new SimpleDateFormat(formatPattern);
		return dateFormat.parse(strDate);
	}
	
	
	/**
	 * 
	 * <p>Method Name: strDateToStamp</p>
	 * <p>Description: 字符串日期转Stamp时间戳</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:06:39
	 * @version 2.0
	 * @param strDate 字符串日期
	 * @param formatPattern 日期格式
	 * @return String 毫秒值
	 * @throws ParseException
	 */
    public static Long strDateToStamp(String strDate, String formatPattern) throws ParseException{
        DateFormat dateFormat = new SimpleDateFormat(formatPattern);
        return dateFormat.parse(strDate).getTime();
    }
    
    
    /**
     * 
     * <p>Method Name: stampToStrDate</p>
     * <p>Description: stamp时间戳转字符串日期</p>
     * @author wkm
     * @date 2017年8月15日下午2:08:13
     * @version 2.0
     * @param stamp 毫秒值
     * @param formatPattern 日期格式
     * @return String date
     */
    public static String stampToStrDate(Long stamp, String formatPattern){
        DateFormat dateFormat = new SimpleDateFormat(formatPattern);
        return dateFormat.format(new Date(stamp));
    }

}
