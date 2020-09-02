package cn.stylefeng.guns.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @author ThinkGem
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	* @Description: 获取固定日期格式的当前时间
	* @param formatterStr:日期格式
	* @Return: java.util.Date
	* @Author: lyy
	* @Date: 2018/9/7 9:58
	*/
	public static Date getNowDate(String formatterStr) {
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat(formatterStr);
		String strDate= df.format(now);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return now;
	}

    /**
     * 增加年
     */
	public static Date addYears(Integer len ){
	    return DateUtils.addYears(new Date(),len);
    }
    /**
     * 增加月
     */
    public static Date addMonths(Integer len ){
        return DateUtils.addMonths(new Date(),len);
    }
    /**
     * 增加周
     */
    public static Date addWeeks(Integer len ){
        return DateUtils.addWeeks(new Date(),len);
    }
    /**
     * 增加天
     */
    public static Date addDays(Integer len){
        return DateUtils.addDays(new Date(),len);
    }

	public static Date addDays(Integer len,Date date){
		return DateUtils.addDays(date,len);
	}
    /**
     * 增加小时
     */
    public static Date addHours(Integer len ){
        return DateUtils.addHours(new Date(),len);
    }
    /**
     * 增加分钟
     */
    public static Date addMinutes(Integer len ){
        return DateUtils.addMinutes(new Date(),len);
    }
    /**
     * 增加秒
     */
    public static Date addSeconds(Integer len ){
        return DateUtils.addSeconds(new Date(),len);
    }
    /**
     * 增加毫秒
     */
    public static Date addMilliseconds(Integer len ){
        return DateUtils.addMilliseconds(new Date(),len);
    }

    /**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60.0 * 60.0 * 24);
	}
	/**
	 * 获取两个日期之间的小时数
	 *
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDateHour(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		double ccc=(1000.00 * 60.00 * 60.00);
		return (afterTime - beforeTime) / ccc;
	}
	/**
	 * 获取两个日期之间的秒数
	 *
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDateSecond(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 );
	}
	/**
	 * 获取两个日期之间的秒数
	 *
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDateSecond(String before, String after) {
		Calendar calendar = Calendar.getInstance();
		Date start=parseDate(before);
		Date end=parseDate(after);
		long beforeTime = start.getTime();
		long afterTime = end.getTime();
		return (afterTime - beforeTime) / (1000 );
	}

	/**
	 * 获取某个日期之前或之后几天的日期
	 * 
	 * @param date 基准日期
	 * @param days 相隔天数
	 * @return Date 日期
	 */
	public static Date getDistanceDate(Date date,int days) {				
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 根据某日期格式，获取之前或之后几天的特定格式的日期
	 * 
	 * @param date 基准日期
	 * @param days 相隔天数
	 * @return String 特定格式的日期
	 */
	public static String getDistanceDate(String formatStr,Date date,int days) {
		
		SimpleDateFormat sdf=new SimpleDateFormat(formatStr);		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		date = calendar.getTime();
		return  sdf.format(date);
	}
	/**
	 * 获取今天
	 * @return String
	 * */
	public static String getToday(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	/**
	 * 获取当天0点
	 * @return String
	 */
	public static String getTodayZero(){
		return DateFormatUtils.format(new Date(), "yyyy-MM-dd 00:00:00");
	}
	/**
	 * 获取当天0点
	 * @return Date
	 */
	public static Date getTodayZeroDate() throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String date= DateFormatUtils.format(new Date(), "yyyy-MM-dd 00:00:00");
		return sdf.parse(date);
	}
	/**
	 * 获取昨天
	 * @return String
	 * */
	public static String getYestoday(){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		Date time=cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time);
	}
	/**
	 * 获取本月开始日期
	 * @return String
	 * **/
	public static String getMonthStart(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date time=cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time)+" 00:00:00";
	}
	/**
	 * 获取本月开始日期
	 * @return Date
	 * **/
	public static Date getMonthStartDate(){
		Date time=parseDate(getMonthStart());
		return time;
	}
	/**
	 * 获取本月最后一天
	 * @return String
	 * **/
	public static String getMonthEnd(){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date time=cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time)+" 00:00:00";
	}
	/**
	 * 获取本月最后一天
	 * @return Date
	 * **/
	public static Date getMonthEndDate(){

		Date time=parseDate(getMonthEnd());
		return time;
	}
	/**
	 * 获取本周的第一天
	 * @return String
	 * **/
	public static String getWeekStart(){
		Calendar cal=Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar. DAY_OF_WEEK, Calendar.MONDAY);
		Date time=cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time)+" 00:00:00";
	}
	/**
	 * 获取本周的第一天
	 * @return Date
	 * **/
	public static Date getWeekStartDate(){
		Date time=parseDate(getWeekStart());
		return time;
	}
	/**
	 * 获取本周的最后一天
	 * @return String
	 * **/
	public static String getWeekEnd(){
		Calendar cal=Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar. DAY_OF_WEEK, Calendar.SUNDAY);
		Date time=cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time)+" 23:59:59";
	}
	/**
	 * 获取本周的最后一天
	 * @return Date
	 * **/
	public static Date getWeekEndDate(){
		Date time=parseDate(getWeekEnd());
		return time;
	}
	/**
	 * 获取本年的第一天
	 * @return String
	 * **/
	public static String getYearStart(){
		return new SimpleDateFormat("yyyy").format(new Date())+"-01-01";
	}
	/**
	 * 获取本年的第一天
	 * @return Date
	 * **/
	public static Date getYearStartDate(){

		return parseDate(getYearStart());
	}
	/**
	 * 获取本年的最后一天
	 * @return String
	 * **/
	public static String getYearEnd(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR,1);
		calendar.add(Calendar.DAY_OF_YEAR,-1);
		calendar.add(Calendar.YEAR,1);

		Date currYearLast = calendar.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(currYearLast)+" 00:00:00";
	}
	/**
	 * 获取本年的最后一天
	 * @return Date
	 * **/
	public static Date getYearEndDate(){

		Date currYearLast =parseDate(getYearEnd());
		return currYearLast;
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

	}
}
