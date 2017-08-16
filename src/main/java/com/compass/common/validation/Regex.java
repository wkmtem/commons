package com.compass.common.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * <p>Class Name: Regex</p>
 * <p>Description: 正则工具类</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午2:55:09
 * @version 2.0
 */
public class Regex {
	
	/**
	 * 
	 * <p>Method Name: checkStrDate</p>
	 * <p>Description: 校验字符串时间格式YYYY-MM-DD</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:55:28
	 * @version 2.0
	 * @param date
	 * @return boolean
	 */
	public static boolean checkStrDate(String date) {
		String regex = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$";
		if (date.matches(regex)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * <p>Method Name: checkStrDateTime</p>
	 * <p>Description: 校验字符串时间格式YYYY-MM-DD HH:mm 或 YYYY-MM</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:55:59
	 * @version 2.0
	 * @param date
	 * @return boolean
	 */
	public static boolean checkStrDateTime(String date) {
		String regex = "^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2})|(\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2})|(\\d{4}-\\d{2})|(\\d{4}/\\d{2})$";
		if (date.matches(regex)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * <p>Method Name: checkCellphoneNo</p>
	 * <p>Description: 校验手机号码</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:56:47
	 * @version 2.0
	 * @param cellphone 手机号码
	 * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
	 * 联通：130、131、132、152、155、156、185、186、176
	 * 电信：133、153、180、189、177（1349卫通）
	 * @return boolean
	 */
	public static boolean checkCellphoneNo(String cellphone){  
		// 手机号正则表达式（13、15、17、18）  
		Pattern cellphonePattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[6-8])|(18[0,5-9]))\\d{8}$");  
		// 通过Pattern获得Matcher  
		Matcher cellphoneMatcher = cellphonePattern.matcher(cellphone);  
		// 返回结果
		return cellphoneMatcher.matches();  
	}  

	/**
	 * 
	 * <p>Method Name: checkUnsignedNum</p>
	 * <p>Description: 校验正整数</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:57:43
	 * @version 2.0
	 * @param num
	 * @return boolean
	 */
	public static boolean checkUnsignedNum(String num) {
		String regex = "^\\+?[0-9][0-9]*$";
		if (num.matches(regex)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * <p>Method Name: checkDecimal</p>
	 * <p>Description: 校验数字或小数点两位</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:58:03
	 * @version 2.0
	 * @param num
	 * @return boolean
	 */
	public static boolean checkDecimal(String num) {
		String regex = "^\\d*\\.{0,2}\\d{0,2}$";
		if (num.matches(regex)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * <p>Method Name: checkGender</p>
	 * <p>Description: 检验性别</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:59:05
	 * @version 2.0
	 * @param gender 性别
	 * @return
	 */
	public static boolean checkGender(String gender) {
		String regex = "^(男|女)$";
		if (gender.matches(regex)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * <p>Method Name: checkIdentityNo</p>
	 * <p>Description: 校验身份证号码</p>
	 * @author wkm
	 * @date 2017年8月15日下午2:59:32
	 * @version 2.0
	 * @param identityNo 身份证号码15或18位
	 * @return
	 */
	public static boolean checkIdentityNo(String identityNo) {
		String regex = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";
		if (identityNo.matches(regex)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * <p>Method Name: getBirthdayFromID</p>
	 * <p>Description: 获取身份证号码中的出生日期</p>
	 * @author wkm
	 * @date 2017年8月15日下午3:00:25
	 * @version 2.0
	 * @param identityNo 身份证号码15或18位
	 * @return String yyyy-MM-dd
	 */
	public static String getBirthdayFromID(String identityNo) {
		// 身份证号正则表达式（要么是15位，要么是18位，最后一位可以为字母）  
		Pattern idNumPattern = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])"); 
		// 通过Pattern获得Matcher  
		Matcher idNumMatcher = idNumPattern.matcher(identityNo); 
		
		 // 是身份证号，定义正则表达式提取出身份证中的出生日期：身份证上的前6位以及出生年月日  
        if(idNumMatcher.matches()){  
            Pattern birthDatePattern = Pattern.compile("\\d{6}(\\d{4})(\\d{2})(\\d{2}).*");
            // 通过Pattern获得Matcher  
            Matcher birthDateMather = birthDatePattern.matcher(identityNo);  
            // 通过Matcher获得出生年月日  
            if(birthDateMather.find()){  
                String year = birthDateMather.group(1);  
                String month = birthDateMather.group(2);  
                String date = birthDateMather.group(3);  
                // 返回出生年月日
                return year + "-" + month + "-" + date;                  
            }     
        }
        return null;
	}
	
	/**
	 * 
	 * <p>Method Name: checkEmail</p>
	 * <p>Description: 校验电子邮箱</p>
	 * @author wkm
	 * @date 2017年8月15日下午3:01:19
	 * @version 2.0
	 * @param email 电子邮箱
	 * @return boolean
	 */
	public static boolean checkEmail(String email) {
		/**
		 * 邮箱正则表达式
		 * p{Alpha}:内容是必选的，和字母字符[\p{Lower}\p{Upper}]等价。如：200896@163.com不是合法的
		 * w{2,15}: 2~15个[a-zA-Z_0-9]字符；w{}内容是必选的。 如：dyh@152.com是合法的
		 * [a-z0-9]{3,}：至少三个[a-z0-9]字符,[]内的是必选的；如：dyh200896@16.com是不合法的
		 * [.]:'.'号时必选的； 如：dyh200896@163com是不合法的
		 * p{Lower}{2,}小写字母，两个以上。如：dyh200896@163.c是不合法的
		 */
		String regex = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		if (email.matches(regex)) { 
			return true;
	    }
	    return false;
	}
}
