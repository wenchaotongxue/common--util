package com.zhangwenchao.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/** 

* @author 作者 Your-Name: zhangwenchao

* @version 创建时间：2019年12月5日 下午1:57:27 

* 类说明 

*/
public class StreamUtils {
	/**
	 * 
	* @Title: closeAll
	* @Description: 关闭流的方法
	* @param @param autoCloseables    参数
	* @return void    返回类型
	* @throws
	 */
	 public static void closeAll(AutoCloseable ...autoCloseables) {
		 if(autoCloseables!=null) {
			 for (AutoCloseable autoCloseable : autoCloseables) {
				
				 try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
			 
			 
		 }
		 
	 }
	 /**
	  * 
	 * @Title: readTextFile
	 * @Description: 以流的方法读取文件的内容
	 * @param @param file
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	  */
	 
	  public static String readTextFile(File file) {
		  FileInputStream fileInputStream =null;
		    try {
			 fileInputStream = new FileInputStream(file);
			byte[] b=  new byte[1024];
			String str =null;
			
				while(fileInputStream.read(b)!=-1) {
					str += new String(b);
				}
				return str;
			 
			 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally {
				closeAll(fileInputStream);
			}
	
			
			
		  
	  }
	 
	  /**
	   * 根据文件名读取文件的内容
	   */

	    public static String getFileContent(String fileName) {
			return readTextFile(new File(fileName));
	    	
	    }
	    
	    
	    public static void writeTextFile(String content,boolean append,File file) {
	    	BufferedWriter writer =null;
	    	try {
	    	//判断文件夹是否存在
	    	String parent = file.getParent();
	    	File parentfile = new File(parent);
	    	if(!parentfile.exists()) {
	    		parentfile.mkdir();
	    	}
	    	
	    	//写文件
	    	 
				 writer = new BufferedWriter(new FileWriter(file,append));
			   writer.write(content);
			   writer.flush();
	    	
	    	
	    	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeAll(writer);
			}
	    }
	    
	    
	    public static void writeTextFile(String content,boolean append,String fileFullName) {
	    
	    	writeTextFile(content, append, new File(fileFullName));
	    	
	    }
	    
	    
	    
	    /**
	     * 测试
	     */
	    
	     public static void main(String[] args) {
			System.out.println(getFileContent("C:\\Users\\张文超\\Desktop\\web.xml"));
		}
	    
}
