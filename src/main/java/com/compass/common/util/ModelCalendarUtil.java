package com.compass.common.util;

import java.util.Calendar;

/**
 * 
 * <p>Class Name: ModelCalendarUtil</p>
 * <p>Description: Calendar模块化工具类，封装了一些常用的方法</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午2:19:50
 * @version 2.0
 */
public class ModelCalendarUtil {

    public final static int SUNDAY = 1;
    public final static int MONDAY = 2;
    public final static int TUESDAY = 3;
    public final static int WEDNESDAY = 4;
    public final static int THURSDAY = 5;
    public final static int FRIDAY = 6;
    public final static int SATURDAY = 7;
    public Calendar mCalendar = Calendar.getInstance();
    public int mYear;
    public int mMonth;

    /**
     * 
     * <p>Constructor Name: ModelCalendarUtil</p>
     * <p>Description: 初始化年、月</p>
     * @author wkm
     * @date 2017年8月15日下午2:20:37
     * @version 2.0
     */
    public ModelCalendarUtil() {
        mYear = mCalendar.get(Calendar.YEAR);
        mMonth = mCalendar.get(Calendar.MONTH);
        initCalendarUtil();
    }

    /**
     * 
     * <p>Constructor Name: ModelCalendarUtil</p>
     * <p>Description: 指定年、月</p>
     * @author wkm
     * @date 2017年8月15日下午2:21:18
     * @version 2.0
     * @param year 指定年份yyyy
     * @param month 指定月份0-11
     */
    public ModelCalendarUtil(int year, int month) {
        mYear = year;
        mMonth = month;
        initCalendarUtil();
    }

    /**
     * 
     * <p>Method Name: initCalendarUtil</p>
     * <p>Description: 初始化月的第1天</p>
     * @author wkm
     * @date 2017年8月15日下午2:21:43
     * @version 2.0
     */
    private void initCalendarUtil() {
        mCalendar.set(mYear, mMonth, 1);
    }

    /**
     * 
     * <p>Method Name: getFirstDayWeek</p>
     * <p>Description: 获取当前月第1天的星期</p>
     * @author wkm
     * @date 2017年8月15日下午2:22:21
     * @version 2.0
     * @return 星期1-7
     */
    public int getFirstDayWeek() {
        int firstDayWeek;
        firstDayWeek = mCalendar.get(Calendar.DAY_OF_WEEK);
        return firstDayWeek;
    }

    /**
     * 
     * <p>Method Name: getFirstDayWeek</p>
     * <p>Description: 获取指定月第1天的星期</p>
     * @author wkm
     * @date 2017年8月15日下午2:24:38
     * @version 2.0
     * @param defMonth 指定月份0-11
     * @return 星期1-7
     */
    public int getFirstDayWeek(int defMonth) {
        int firstDayWeek;
        if (defMonth != 0) {
            mCalendar.add(Calendar.MONTH, defMonth);
            firstDayWeek = getFirstDayWeek();
            initCalendarUtil();
        } else {
            firstDayWeek = getFirstDayWeek();
        }
        return firstDayWeek;
    }

    /**
     * 
     * <p>Method Name: getLastDayWeek</p>
     * <p>Description: 获取当前月最后1天的星期</p>
     * @author wkm
     * @date 2017年8月15日下午2:29:24
     * @version 2.0
     * @return 星期1-7
     */
    public int getLastDayWeek() {
        int lastDayWeek;
        mCalendar.roll(Calendar.DATE, -1);
        lastDayWeek = mCalendar.get(Calendar.DAY_OF_WEEK);
        initCalendarUtil();
        return lastDayWeek;
    }

    /**
     * 
     * <p>Method Name: getLastDayWeek</p>
     * <p>Description: 获取指定月最后1天的星期</p>
     * @author wkm
     * @date 2017年8月15日下午2:29:42
     * @version 2.0
     * @param defMonth 指定月份0-11
     * @return 星期1-7
     */
    public int getLastDayWeek(int defMonth) {
        int lastDayWeek;
        if (defMonth != 0) {
            mCalendar.add(Calendar.MONTH, defMonth);
        }
        lastDayWeek = getLastDayWeek();
        return lastDayWeek;
    }

    /**
     * 
     * <p>Method Name: getDayWeek</p>
     * <p>Description: 获取当前月指定号的星期</p>
     * @author wkm
     * @date 2017年8月15日下午2:30:13
     * @version 2.0
     * @param day 指定日期1-31
     * @return 星期1-7
     */
    public int getDayWeek(int day) {
        int dayWeek;
        if (day != 0) {
            mCalendar.set(mYear, mMonth, day);
            dayWeek = mCalendar.get(Calendar.DAY_OF_WEEK);
            initCalendarUtil();
        } else {
            dayWeek = mCalendar.get(Calendar.DAY_OF_WEEK);
        }
        return dayWeek;
    }

    /**
     * 
     * <p>Method Name: getDays</p>
     * <p>Description: 获取当前月天数</p>
     * @author wkm
     * @date 2017年8月15日下午2:30:54
     * @version 2.0
     * @return 天数28-31
     */
    public int getDays() {
        int days;
        days = mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days;
    }

    /**
     * 
     * <p>Method Name: getDays</p>
     * <p>Description: 获取指定月的天数</p>
     * @author wkm
     * @date 2017年8月15日下午2:31:27
     * @version 2.0
     * @param defMonth 指定月份0-11
     * @return 天数28-31
     */
    public int getDays(int defMonth) {
        int days;
        if (defMonth != 0) {
            mCalendar.add(Calendar.MONTH, defMonth);
            days = getDays();
            initCalendarUtil();
        } else {
            days = getDays();
        }
        return days;
    }

    /**
     * 
     * <p>Method Name: getWeekOfMonth</p>
     * <p>Description: 获取指定日期是当前月中是第几周</p>
     * @author wkm
     * @date 2017年8月15日下午2:31:47
     * @version 2.0
     * @param day 指定日期1-31
     * @return 周数1-5
     */
    public int getWeekOfMonth(int day) {
        int weekOfMonth;
        if (day != 1) {
            mCalendar.set(mYear, mMonth, day);
            weekOfMonth = mCalendar.get(Calendar.WEEK_OF_MONTH);
            initCalendarUtil();
        } else {
            weekOfMonth = 1;
        }
        return weekOfMonth;
    }

    /**
     * 
     * <p>Method Name: getWeekOfMonth</p>
     * <p>Description: 获取指定日期在指定月中是第几周</p>
     * @author wkm
     * @date 2017年8月15日下午2:32:18
     * @version 2.0
     * @param defMonth 指定月份0-11
     * @param day 指定日期1-31
     * @return 周数1-5
     */
    public int getWeekOfMonth(int defMonth, int day) {
        int weekOfMonth;
        mCalendar.set(mYear, mMonth, day);
        if (defMonth != 0) {
            mCalendar.add(Calendar.MONTH, defMonth);
            weekOfMonth = mCalendar.get(Calendar.WEEK_OF_MONTH);
            initCalendarUtil();
        } else {
            weekOfMonth = getWeekOfMonth(day);
        }
        return weekOfMonth;
    }

    /**
     * 
     * <p>Method Name: getDayOfYear</p>
     * <p>Description: 获取当前年中第几天</p>
     * @author wkm
     * @date 2017年8月15日下午2:32:40
     * @version 2.0
     * @return 天数1-366
     */
    public int getDayOfYear() {
        int days;
        days = mCalendar.get(Calendar.DAY_OF_YEAR);
        return days;
    }

    /**
     * 
     * <p>Method Name: getDayOfYear</p>
     * <p>Description: 获取指定年中第几天</p>
     * @author wkm
     * @date 2017年8月15日下午2:33:03
     * @version 2.0
     * @param defYear 指定年份yyyy
     * @return 1-366
     */
    public int getDayOfYear(int defYear) {
        int days;
        if (defYear != 0) {
            mCalendar.add(Calendar.YEAR, defYear);
            days = mCalendar.get(Calendar.DAY_OF_YEAR);
            initCalendarUtil();
        } else {
            days = mCalendar.get(Calendar.DAY_OF_YEAR);
        }
        return days;
    }

    /**
     * 
     * <p>Method Name: getDaysInYear</p>
     * <p>Description: 获取当前年的天数</p>
     * @author wkm
     * @date 2017年8月15日下午2:43:10
     * @version 2.0
     * @return 天数365-366
     */
    public int getDaysInYear() {
        int days;
        if (mYear % 400 == 0 || (mYear % 4 == 0 && mYear % 100 != 0)) {
            days = 366;
        } else {
            days = 365;
        }
        return days;
    }

    /**
     * 
     * <p>Method Name: getDaysInYear</p>
     * <p>Description: 获取指定年的天数</p>
     * @author wkm
     * @date 2017年8月15日下午2:43:43
     * @version 2.0
     * @param defYear 指定年份yyyy
     * @return 天数365-366
     */
    public int getDaysInYear(int defYear) {
        int days;
        int tYear = mYear + defYear;
        if (tYear % 400 == 0 || (tYear % 4 == 0 && tYear % 100 != 0)) {
            days = 366;
        } else {
            days = 365;
        }
        return days;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        this.mYear = year;
    }

    public int getMonth() {
        return mMonth;
    }

    public void setMonth(int month) {
        this.mMonth = month;
    }

    @Override
    public boolean equals(Object o) {
        ModelCalendarUtil other = (ModelCalendarUtil) o;
        if (other.mYear == mYear && other.mMonth == mMonth) {
            return true;
        } else {
            return super.equals(o);
        }
    }

    @Override
    public int hashCode() {
        return mYear * 1000 + mMonth;
    }
}
