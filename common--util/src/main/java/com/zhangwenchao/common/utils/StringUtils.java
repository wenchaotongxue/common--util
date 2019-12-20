package com.zhangwenchao.common.utils;
/** 

* @author 作者 Your-Name: zhangwenchao

* @version 创建时间：2019年12月5日 下午1:57:27 

* 类说明  字符串的工具类

*/
public class StringUtils {
/**
 * 
* @Title: isBlank
* @Description: TODO 验证字符串是否为空
* @param @param str
* @param @return    参数
* @return boolean    返回类型
* @throws
 */
  public static boolean isBlank(String str) {
	
	  if(str==null) {
		  
		  return true;
	  }
	  //去除空格
	  str = str.trim();
	  
	  if(str.length()==0) {
		  return true;
	  }
	  
	  return false;
  }	
	
	/**
	 * 
	* @Title: isNotBlank
	* 不为空的字符串
	* @param @param str
	* @param @return    参数
	* @return boolean    返回类型
	
	 */
  public static boolean isNotBlank(String str) {
	return !isBlank(str);  
	  
  }
  /**
   * 判断字符串是否为手机号
   * 
   */
   public static boolean isPhone(String str) {
	   
	   String regex ="1[3578]\\d{9}";
	   return str.matches(regex);
   }
  
   
    /**
     * 判断是否是数字
     */
   
   public static boolean isNumber(String str) {
	   
	   String regex = "\\d+";
	   return str.matches(regex);
   }
   
   
   
   /**
    * 
   * @Title: isEmail
   * @Description: 验证是否是邮箱
   * @param @param str
   * @param @return    参数
   * @return boolean    返回类型
   * @throws
    */
   
   public static boolean isEmail(String str) {
	   
	   String regex = "[A-Za-z0-9]+@[A-Za-z0-9]+.(com|cn|com.cn|net)";
		return str.matches(regex);
	   
   }
   /**
    * 
   * @Title: isLetter
   * @Description:判断是否是字母
   * @param @param str
   * @param @return    参数
   * @return boolean    返回类型
   * @throws
    */
   
   public static boolean isLetter(String str) {
	   if(isNotBlank(str)) {
		   str = str.toLowerCase();
		   String regex ="[a-z]+";
		   return str.matches(regex);
		   
	   }
	return false;
	   
	   
   }
   
   
   
   public static void main(String[] args) {
	   System.out.println(isNumber("1"));
	
}
   
}
