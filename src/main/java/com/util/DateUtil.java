/*
package com.util;

import com.alibaba.common.lang.StringUtil;
import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

*/
/**
 * Bogda的时间日期处理工具。
 * 
 * @author yingchao.zyc
 *//*

@SuppressWarnings("deprecation")
public class DateUtil extends DateUtils {

    private static       Logger           logger      = new Logger();

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final String FMT_YYYY = "yyyy";

    public static final String FMT_Y_M = "yyyy-MM";

    public static final String FMT_Y_M_D = "yyyy-MM-dd";

    public static final String FMT_Y_M_D_H_M = "yyyy-MM-dd HH:mm";

    public static final String FMT_Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";

    public static final String FMT_Y_M_D_H_M_S_NEW = "yyyy MM dd HH:mm:ss";
    public static final String FMT_Y_M_D_H_M_S_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    */
/**
     * 拿到今天的日期的字符显示。
     * 
     * @return
     *//*

    public static String getTodayDate() {
        return DATE_FORMAT.format(new Date());
    }

    */
/**
     * 拿到今天的日期+时间的字符显示。
     * 
     * @return
     *//*

    public static String getTodayDateTime() {
        return DATETIME_FORMAT.format(new Date());
    }

    */
/**
     * 格式化制定的date
     * 
     * @param date
     * @return
     *//*

    public static String formateDate(Date date) {
        if (date == null) {
            return StringUtil.EMPTY_STRING;
        }

        return DATE_FORMAT.format(date);
    }

    */
/**
     * 格式化制定的datetime
     * 
     * @param date
     * @return
     *//*

    public static String formateDatetime(Date date) {
        if (date == null) {
            return StringUtil.EMPTY_STRING;
        }

        return DATETIME_FORMAT.format(date);
    }

    public static Date addDayFroDate(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, days);
        return c.getTime();
    }

    public static Date minusDayForDate(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -days);
        return c.getTime();
    }
 
	public static Date getDateMin(Date date) {
        try {
            return DATETIME_FORMAT.parse(formateDate(date) + " 00:00:00");
        } catch (Exception ex) {
            logger.error("getDateMin error, date = " + date.toString(), ex);
        }
        return date;
    }

    public static Date getDateMax(Date date) {
        try {
            return DATETIME_FORMAT.parse(formateDate(date) + " 23:59:59");
        } catch (Exception ex) {
            logger.error("getDateMax error, date = " + date.toString(), ex);
        }
        return date;
    }

    public static Date parseDate(String dateStr) {
        if (StringUtil.isBlank(dateStr)) {
            return null;
        }
        try {
            return DATE_FORMAT.parse(dateStr);
        } catch (Exception ex) {
            logger.error("parseDate error, dateString = " + dateStr, ex);
        }
        return null;

    }

    */
/**
     * startDate加上days是否超过endate，超过返回true，否则返回false
     * 
     * @param startDate
     * @param endDate
     * @param days
     * @return
     *//*

    public static boolean compareDate(Date startDate, Date endDate, int days) {
        // Date tempStartDate = parseDate(formateDate(startDate));
        if (startDate == null || endDate == null) {
            return false;
        }
        return addDays(startDate, days).after(endDate);
    }

    public static int getCurrentWeek() {

        return getWeekByDate(new Date());
    }

    public static int getWeekByDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public static String ymdFormat(Date date) {
        if (date == null) {
            return null;
        }

        return DATE_FORMAT.format(date);
    }

    public static String ymdhmsFormatDate(Date date) {
        if (date == null) {
            return null;
        }

        return DATETIME_FORMAT.format(date);
    }

    */
/**
     * 返回指定日期是哪一年
     * 
     * @param date
     * @return
     *//*

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }

    */
/**
     * 使用预设Format格式化Date成FMT_Y_M_D_H_M_S
     * 
     * @param
     * @return
     *//*

    public static String format(long mils) {
        return format(new Date(mils), FMT_Y_M_D_H_M_S);
    }

    */
/**
     * 使用参数Format格式化Date成字符串
     * 
     * @param date
     * @param pattern
     * @return
     *//*

    public static String format(Date date, String pattern) {
        return date == null ? "" : new SimpleDateFormat(pattern).format(date);
    }
    
    */
/**
     * startDate减去endDate返回相差天数
     * @param big
     * @param small
     * @return
     *//*

    public static int compareDateByYmd(Date big, Date small) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(big);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(small);
        if (cal1.get(Calendar.MONTH) != 11 && cal2.get(Calendar.MONTH) == 11) {// 跨年
            Calendar cal3 = Calendar.getInstance();
            cal3.set(Calendar.MONTH, 11);
            cal3.set(Calendar.DAY_OF_MONTH, 31);
            return cal3.get(Calendar.DAY_OF_YEAR) - cal2.get(Calendar.DAY_OF_YEAR) + cal1.get(Calendar.DAY_OF_YEAR);
        } else {
            return cal1.get(Calendar.DAY_OF_YEAR) - cal2.get(Calendar.DAY_OF_YEAR);
        }
    }

}
*/
