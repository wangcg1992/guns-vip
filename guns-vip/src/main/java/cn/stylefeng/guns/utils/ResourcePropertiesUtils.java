package cn.stylefeng.guns.utils;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


/**
 * 读取资源文件的工具类
 * 所有的内容其实都是applicaition.yml之中的内容
 * @author trekxu
 *
 */
@Component
public class ResourcePropertiesUtils implements EnvironmentAware{
	
	private static Environment environment;
	
	@Override
	public void setEnvironment(Environment environment) {
		ResourcePropertiesUtils.environment = environment;
	}
	
	/**
	 * 检测环境是否可用
	 */
	private static void checkEnvironment() {
		if(environment == null) {
			throw new IllegalStateException("该工具类没有注册到IOC容器之中!!");
		}
	}
	
	/**
	 * 通过key来读取value
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		checkEnvironment();
		return  environment.getProperty(key);
	}

	/**
	 * 通过键获取int值
	 * @param key
	 * @return
	 */
	public static Integer getIntValue(String key){
		return Integer.parseInt(getValue(key));
	}

	/**
	 * 通过键获取long值
	 * @param key
	 * @return
	 */
	public static Long getLongValue(String key){
		return Long.parseLong(getValue(key));
	}

	/**
	 *
	 * @param key
	 * @return
	 */
	public static boolean getBooleanValue(String key){
		return Boolean.parseBoolean(getValue(key));
	}

}
