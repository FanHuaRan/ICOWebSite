package com.fhr.icoweb.services;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.fhr.icoweb.services.impl.PropertiesUtil;
/**
 * 附件存储配置对象
 * @author fhr
 * @date 2017/05/23
 */
public class IcoConfig {
	/**
	 * 配置文件相对路径
	 */
	public static final String CONFIG_PATH="imagefilesconfig.properties";
	/**
	 * ico保存的根路径 缺省为网站根目录
	 */
	public  static final String ICO_ROOT;
	/**
	 * 用户下载ico后是否删除ico文件 缺省为true
	 */
	public  static final boolean DELETEICO; 
	static{
		 WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
		 ServletContext servletContext=wac.getBean(ServletContext.class);
		 String rootPath=servletContext.getRealPath("/");
		Properties properties=getProperties();
		if(properties!=null){
			ICO_ROOT=properties.getProperty("ico.root");
			DELETEICO=Boolean.valueOf(properties.getProperty("deleteico"));
		}else{
			ICO_ROOT=rootPath;
			DELETEICO=true;
		}

	 }
	/**
	 * 获取配置文件对象
	 * @return
	 */
	public static Properties getProperties() {
		try {
			Properties properties = PropertiesUtil.getPropertiesObj(CONFIG_PATH);
			return properties;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
 
	
	
	
}
