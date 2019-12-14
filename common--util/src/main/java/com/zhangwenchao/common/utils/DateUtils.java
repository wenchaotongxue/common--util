package com.zhangwenchao.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author 作者 Your-Name: zhangwenchao
 * 
 * @version 创建时间：2019年12月5日 下午1:57:27
 * 
 *          类说明
 * 
 */
public class DateUtils {
	// 日期格式化年月日
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	// 加时分秒
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	/**
	 * 
	 * @Title: getAge @Description: TODO根据生日查看年龄 @param @param
	 *         birthDay @param @return 参数 @return int 返回类型 @throws
	 */

	public static int getAge(Date birthDay) {

		// 获取日历插件
		Calendar calendar = Calendar.getInstance();
		// 当前的年份
		int nowYear = calendar.get(Calendar.YEAR);
		// 当前的月份
		int nowMonth = calendar.get(Calendar.MONTH);
		// 当前日
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);

		// 设置生日
		calendar.setTime(birthDay);

		// 生日的年份
		int birYear = calendar.get(Calendar.YEAR);
		// 生日的月份
		int birMonth = calendar.get(Calendar.MONTH);
		// 生日
		int birDay = calendar.get(Calendar.DAY_OF_MONTH);

		// 年龄
		int age = nowYear - birYear;

		// 判断 如果生日的月份大于当前月份，年龄-1
		if (nowMonth < birMonth) {
			age--;
		}
		// 如果月份相等 判断日期
		if (nowMonth == birMonth && nowDay < birDay) {
			age--;
		}

		return age;
	}

	/**
	 * 根据出生的日期计算年龄
	 */
	public static int getAge(String birthDateStr) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date parse = null;
		try {
			parse = simpleDateFormat.parse(birthDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAge(parse);

	}

	/**
	 * 
	 * @Title: getDayNum @Description: TODO获取开始日期和结束日期间有多少天 @param @return
	 *         参数 @return int 返回类型 @throws
	 */

	public static int getDayNum(Date date1, Date date2) {
		// 一天有多少毫秒
		Long dayTime = 1000 * 60 * 60 * 24L;
		// 开始和结束时间
		Long startTime = date1.getTime();
		Long endTime = date1.getTime();
		// 计算
		Double dayNum = Math.abs((endTime - startTime) / dayTime * 1.0);
		System.out.println(dayNum + "");

		dayNum = Math.ceil(dayNum);
		System.out.println(dayNum + "//");
		return dayNum.intValue() + 1;
	}

	/**
	 * 
	 * @Title: getDayNum @Description: 计算指定日期距离今天,过去了多少天 或者患有多少天 @param @param
	 *         date @param @return 参数 @return int 返回类型 @throws
	 */
	public static int getDayNum(Date date) {

		Date date2 = new Date();
		return getDayNum(date, date2);

	}

	/**
	 * 
	 * @Title: isToday @Description: TODO 验证传入的日期是否是今天 @param @param
	 *         theDate @param @return 参数 @return boolean 返回类型 @throws
	 */

	public static boolean isToday(Date theDate) {
		// 创建当前的日期
		Date nowDate = new Date();
		// 日期的格式化
		String nowDateS = dateFormat.format(nowDate);
		String theDateS = dateFormat.format(theDate);

		return nowDateS.equals(theDateS);
	}

	public static boolean isToday(String theDateS) {

		try {
			Date theDate = dateFormat.parse(theDateS);
			return isToday(theDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * 
	 * @Title: isInweek @Description: TODO判断输入日期是否在本周 @param @param
	 *         theDate @param @return 参数 @return boolean 返回类型 @throws
	 */

	public static boolean isInweek(Date theDate) {
		// 日期插件
		Calendar c = Calendar.getInstance();
		// 当前的年份
		int nowYear = c.get(Calendar.YEAR);
		// 获取当前周
		int nowWeek = c.get(Calendar.WEEK_OF_YEAR);
		// 把日历设置成为输入的时间
		c.setTime(theDate);
		int theYear = c.get(Calendar.YEAR);
		int theWeek = c.get(Calendar.WEEK_OF_YEAR);
		return nowYear == theYear && nowWeek == theWeek;

	}

	/**
	 * 
	 * @Title: getFirstDateMonth @Description: 获取指定日期的月的第一天 @param @param
	 *         theDate @param @return 参数 @return Date 返回类型 @throws
	 */
	public static Date getFirstDateMonth(Date theDate) {
		// 日期插件
		Calendar c = Calendar.getInstance();
		// 输入的时间
		c.setTime(theDate);
		// 月的第1天
		c.set(Calendar.DAY_OF_MONTH, 1);
		// 时间
		c.set(Calendar.HOUR_OF_DAY, 0);
		// 分
		c.set(Calendar.MINUTE, 0);
		// 秒
		c.set(Calendar.SECOND, 0);
		return c.getTime();

	}

	/**
	 * 
	 * @Title: getlastDateMonth @Description: 获取指定日期的最后一天 @param @param
	 *         theDate @param @return 参数 @return Date 返回类型 @throws
	 */

	public static Date getlastDateMonth(Date theDate) {

		Calendar c = Calendar.getInstance();
		c.setTime(theDate);
		c.add(Calendar.MONTH, 1);
		Date firstDateMonth = getFirstDateMonth(c.getTime());
		c.setTime(firstDateMonth);
		c.add(Calendar.SECOND, -1);
		return c.getTime();

	}

	public static int conpareTime(Date date1, Date date2) {

		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if (time1 == time2) {
			return 0;
		}

		if (time1 > time2) {
			return 1;
		}
		return -1;

	}

	/**
	 * 测试
	 * 
	 * @throws ParseException
	 */

	public static void main(String[] args) throws ParseException {
		Date date1 = dateTimeFormat.parse("2019-12-05 13:34:33");
		String format = dateTimeFormat.format(getlastDateMonth(date1));
		System.out.println(format);

	}

}
