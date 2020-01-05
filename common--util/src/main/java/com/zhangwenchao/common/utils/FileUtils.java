package com.zhangwenchao.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 作者 Your-Name: zhangwenchao
 * 
 * @version 创建时间：2019年12月5日 下午1:57:27
 * 
 *          类说明
 * 
 */
public class FileUtils {

	public static String getExName(String fileName) {
		// 处理空异常
		if (fileName == null || "".equals(fileName)) {
			throw new RuntimeException("文件名为空的异常");
		}
		if (fileName.indexOf(".") <= -1) {
			throw new RuntimeException(fileName + "该文件没有扩展名");

		}

		String endName = fileName.substring(fileName.lastIndexOf("."));
		return endName;
	}

	/**
	 * 
	 * @Title: getSystemUserHome @Description: TODO 系统获取当前用户的目录 @param @return
	 *         参数 @return String 返回类型 @throws
	 */
	public static String getSystemUserHome() {
		return System.getProperty("user.home");

	}

	/**
	 * 
	 * @Title: getSystemTempDirectory @Description: 操作系统的临时目录 @param @return
	 * 参数 @return String 返回类型 @throws
	 */

	public static String getSystemTempDirectory() {
		return System.getProperty("java.io.tmpdir");

	}

	/**
	 * 
	 * @Title: readTextFieByLine @Description: 读取文件 的内容 @param @param
	 * pathname @param @return 参数 @return String 返回类型 @throws
	 */

	public static String readTextFieByLine(String pathname) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(new File(pathname)));
			do {
				sb.append(br.readLine());
				sb.append("\r\n");

			} while (br.readLine()!=null);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			StreamUtils.closeAll(br);
		}
		return sb.toString();

	}

	/**
	 * 
	 * @Title: readTextFileOflist @Description: 按行读取文件的内容到list集合中 @param @param
	 * pathname @param @return 参数 @return List<String> 返回类型 @throws
	 */

	public static List<String> readTextFileOflist(String pathname) {
		BufferedReader br=null;
		List<String> strList=new ArrayList<String>();
		String str=null;
		try {
			br=new BufferedReader(new FileReader(new File(pathname)));
			while((str=br.readLine())!=null) {
				strList.add(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			StreamUtils.closeAll(br);
		}
		return strList;
	}

	/**
	 * 
	 * @Title: deleteFile @Description: 递归删除文件 @param @param file 参数 @return void
	 * 返回类型 @throws
	 */

	public static void deleteFile(File file) {

		if (file.isDirectory()) {

			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				deleteFile(file2);

			}
			file.delete();
		} else {
			file.delete();
		}
	}

	/**
	 * 
	 * @Title: deleteFile @Description: 递归删除文件 @param @param filePath 参数 @return
	 * void 返回类型 @throws
	 */
	public static void deleteFile(String filePath) {

		deleteFile(new File(filePath));
	}

	/**
	 * 
	 * @Title: getFileSize @Description:获得文件大小 @param @param
	 * fileFullname @param @return 参数 @return String 返回类型 @throws
	 */

	public static String getFileSize(File file) {

		long length = file.length();
		double len = length / 1024.0;
		return String.format("%.2f", len) + "kb";
	}

	/**
	 * 测试
	 */

	public static void main(String[] args) {

		// System.out.println(getExName("ass.txt"));
		String property = System.getenv("MAVEN_HOME");
		// String getenv = System.getenv("JAVA_HOME");
		// System.out.println(property);
		System.out.println(getSystemTempDirectory());

	}

}
