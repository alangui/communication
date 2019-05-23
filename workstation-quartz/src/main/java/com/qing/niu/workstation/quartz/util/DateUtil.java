package com.qing.niu.workstation.quartz.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/11
 */
public class DateUtil {

    /**
     * 时间格式：HHmmss
     */
    public static final String timePattern = "HHmmss";

    /**
     * 时间格式：yyyy/MM/ddHH:mm:ss
     */
    public static final String timesPattern = "yyyy/MM/ddHH:mm:ss";

    /**
     * 日期格式：yyyyMMdd
     */
    public static final String datePattern = "yyyyMMdd";
    /**
     * 日期格式：yyMMdd
     */
    public static final String shortDatePattern = "yyMMdd";

    /**
     * 日期时间格式：yyyyMMddHHmmss
     */
    public static final String fullPattern = "yyyyMMddHHmmss";

    /**
     * 日期时间格式：yyyyMMddHHmmssSS
     */
    public static final String fullPatterns = "yyyyMMddHHmmssSS";

    /**
     * 日期时间格式：yyMMddHHmmss
     */
    public static final String partPattern = "yyMMddHHmmss";

    /**
     * 日期时间格式：yyyy.MM.dd HH:mm:ss
     */
    public static final String settlePattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间式：HHmm
     */
    public static final String hour_of_minute = "HHmm";

    /**
     * 时间式：yyyyMM
     */
    public static final String yyyyMM = "yyyyMM";

    /**
     * 日期时间格式：yyyyMMdd HH:mm:ss
     */
    public static final String datefullPattern = "yyyyMMdd HH:mm:ss";

    /**
     * 日期时间格式：yyyyMMddHHmm
     */
    public static final String year_of_minute = "yyyyMMddHHmm";
    /**
     * 日期时间格式：yyyy-MM-dd HH:mm
     */
    public static final String ymdhm = "yyyy-MM-dd HH:mm";

    /**
     * 获取当前时间（yyyy-MM-dd HH：mm：ss）（返回Date类型）
     *
     * @return Date
     */
    public static Date getCurrentDate() {
        return DateTime.now().toDate();
    }

    /**
     * 获取当前时间 格式：yyyyMMddHHmmss  （返回String类型）
     *
     * @return String
     */
    public static String getCurrent() {
        return getCurrent(fullPattern);
    }

    /**
     * 获取当前时间 格式：yyyyMMdd （返回String类型）
     *
     * @return String
     */
    public static String getCurrentStr() {
        return getCurrent(datePattern);
    }

    /**
     * 根据格式规范返回当前时间 （返回String类型）
     *
     * @param pattern 格式规范
     * @return String
     */
    public static String getCurrent(String pattern) {
        return DateTime.now().toString(pattern);
    }

    /**
     * 将String【格式：yyyyMMddHHmiss】类型转换成Date类型
     *
     * @param date 格式：yyyyMMddHHmiss
     * @return Date
     */
    public static Date parse(String date) {
        if (!StringUtils.isBlank(date) && date.length() > 14) {
            return parse(date, fullPatterns);
        }
        return parse(date, fullPattern);
    }

    /**
     * 将String 【yyyyMMddHHmiss】类型转换成Date类型
     *
     * @param date    格式：yyyyMMdd
     * @param pattern 格式：yyyyMMdd
     * @return Date
     */
    public static Date parse(String date, String pattern) {
        DateTime dateTime = parseTime(date, pattern);
        if (dateTime == null) {return null;}
        return dateTime.toDate();
    }

    /**
     * 将String 【yyyyMMddHHmiss】类型转换成DateTime类型
     *
     * @param date    格式：yyyyMMddHHmiss
     * @param pattern yyyyMMddHHmiss
     * @return DateTime
     */
    public static DateTime parseTime(String date, String pattern) {
        if (StringUtils.isBlank(date)) return null;
        if (fullPattern.equals(pattern)) { // 这段逻辑整合自 gateway-bank 中的 DateUtil
            date = StringUtils.rightPad(date, 14, '0');
        }

        return DateTimeFormat.forPattern(pattern).parseDateTime(date);
    }

    /**
     * 将Date类型转换成 String 【yyyyMMddHHmiss】
     *
     * @param date 时间
     * @return String
     */
    public static String format(Date date) {
        return format(date, fullPattern);
    }

    /**
     * 将String类型按照固定的模式转换 Date类型
     *
     * @param date 会计日
     * @return 会计日字符串
     */
    public static String formatDate(Date date) {
        if (null == date) {
            return null;
        }
        return format(date, datePattern);
    }

    /**
     * 将Date类型按照固定的模式转换 String类型
     *
     * @param date    时间
     * @param pattern 格式
     * @return String
     */
    public static String format(Date date, String pattern) {
        if (date == null) return null;
        return new DateTime(date).toString(pattern);
    }

    /**
     * 日期计算
     *
     * @param date       需要计算的日期
     * @param day        需要往前(负数)或往后(正数)的天数
     * @param inPattern  输入时间的格式
     * @param outPattern 输出时间的格式
     * @return 按照输出时间格式进行格式化后的时间
     */
    public static String computeDate(String date, int day, String inPattern, String outPattern) {
        try {
            DateTime dateTime = parseTime(date, inPattern);
            dateTime = dateTime.minusDays(0 - day);
            return format(dateTime.toDate(), outPattern);
            //输入时间转换错误时返回空值 避免因时间转换错误而导致原流程无法继续执行
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 增加时间
     *
     * @param date          时间
     * @param calendarField 增加的类型，请参照Calendar类
     * @param amount        增加参数信息
     * @return 返回增加之后时间
     */
    private static Date addDate(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date could not be null!");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    /**
     * 按秒偏移,根据{@code source}得到{@code seconds}秒之后的日期
     *
     * @param source  , 要求非空
     * @param seconds , 秒数,可以为负
     * @return 新创建的Date对象
     */
    public static Date addSeconds(Date source, int seconds) {
        return addDate(source, Calendar.SECOND, seconds);
    }

    /**
     * 当前日期移动天数
     *
     * @param source  日期
     * @param addDays 新增天数
     * @return 移动之后时间
     */
    public static Date addDays(Date source, int addDays) {
        return addDate(source, Calendar.DAY_OF_MONTH, addDays);
    }

    /**
     * 增加/减少年数
     *
     * @param date 日期
     * @param year +/- 加/减
     * @return 日期
     */
    public static Date addYear(Date date, int year) {
        if (date == null) {
            throw new IllegalArgumentException("The date could not be null!");
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(year).toDate();
    }

    /**
     * 增加/减少天数
     *
     * @param date 日期
     * @param day  +/- 加/减
     * @return 日期
     */
    public static Date addDay(Date date, int day) {
        if (date == null) {
            throw new IllegalArgumentException("The date could not be null!");
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(day).toDate();
    }

    /**
     * 当前月份月底
     *
     * @param date 日期
     * @return DateTime
     */
    public static DateTime thisMonthEnd(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfMonth().withMaximumValue();
    }

    /**
     * 当前月份月初
     *
     * @param date 日期
     * @return DateTime
     */
    public static DateTime thisMonthBegin(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfMonth().withMinimumValue();
    }

    /**
     * 是否为月初
     *
     * @param date 日期
     * @return DateTime
     */
    public static boolean isMonthBegin(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime beginDT = dateTime.dayOfMonth().withMinimumValue();
        return (beginDT.equals(dateTime));
    }

    /**
     * 是否为月末
     *
     * @param date 日期
     * @return DateTime
     */
    public static boolean isMonthEnd(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime beginDT = dateTime.dayOfMonth().withMaximumValue();
        return (beginDT.equals(dateTime));
    }

    /**
     * 获取年份
     *
     * @param date 日期
     * @return YEAR
     */
    public static String getYear(Date date) {
        DateTime dateTime = new DateTime(date);
        return String.valueOf(dateTime.getYear());
    }

    /**
     * 获取月份
     *
     * @param date 日期
     * @return MONTH
     */
    public static String getMonth(Date date) {
        DateTime dateTime = new DateTime(date);
        return String.valueOf(dateTime.getMonthOfYear());
    }

    /**
     * 获取当前时间
     *
     * @return Date
     */
    public static Date getCurrentDate(String pattern) {
        DateTimeFormatter format = DateTimeFormat.forPattern(pattern);
        return DateTime.parse(new DateTime().toString(pattern), format).toDate();
    }

    /**
     * 计算两个日期的间隔天数
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return long     间隔天数(long)
     */
    public static long getBetweenDays(Date startDate, Date endDate) {
        if (endDate == null || startDate == null) {
            return -1;
        }
        Long days = endDate.getTime() - startDate.getTime();
        return days / (1000 * 60 * 60 * 24);
    }
}
