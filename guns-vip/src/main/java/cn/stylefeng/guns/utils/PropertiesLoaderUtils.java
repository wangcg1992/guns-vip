package cn.stylefeng.guns.utils;


import cn.stylefeng.guns.core.exception.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * 属性文件加载器
 * @author trekxu
 */
@Slf4j
public class PropertiesLoaderUtils {
	
	private PropertiesLoaderUtils() {}
	
	/**
	 * 加载属性文件的内容
	 * 参数为path,可以按照spring的资源加载规则使用
	 * @return
	 */
	public static Properties load(String path) {
		DefaultResourceLoader loader = new DefaultResourceLoader();
		
		Resource resource = loader.getResource(path);
		
		if(!resource.exists()) {
			throw new ParamException("加载的资源不存在");
		}
		
		Properties properties = new Properties();
		try {
			properties.load(resource.getInputStream());
			
			return  properties;
			
		} catch (IOException e) {
			log.error("加载资源文件的内容失败",e);
		}
		
		return null;
	}
}
