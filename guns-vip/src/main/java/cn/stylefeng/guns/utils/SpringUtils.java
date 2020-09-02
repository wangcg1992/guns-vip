package cn.stylefeng.guns.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * spring的工具类 当发现该类无效的时候,请检查该类是否被注入到IOC容器之中
 *  主要的功能就是从容器之中获取指定的Bean对象.
 * @author trekxu
 *
 */
@Component
@Slf4j
public class SpringUtils implements ApplicationContextAware {

	private static ApplicationContext context;

	/**
	 * 获取IOC容器的引用
	 * 
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		checkContext();
		return context;
	}

	/**
	 * 根据Bean的类型获取Bean.当指定类型的Bean数量不止一个的时候,会抛出BeansException异常. 获取容器对象
	 * @param type
	 * @param <T>
	 * @return
	 */
	public static <T> T getBean(Class<T> type) throws BeansException {
		checkContext();
		return context.getBean(type);
	}
	
	/**
	 * 根据Bean的名称获取Bean.
	 * 当指定类型的Bean数量不止一个的时候,会抛出BeansException异常. 获取容器对象
	 * @param beanName
	 */
	public static Object getBean(String beanName) {
		checkContext();
		return context.getBean(beanName);
	}

	/**
	 * 设置spring上下文
	 * 当组件注册到IOC容器的时候,该方法自动回调,帮助初始化工具类.
	 * @param applicationContext
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.debug("springUtils工具类初始化成功-->{}", applicationContext);
		context = applicationContext;
	}
	
	/**
	 * 检测SpringUtils是否被成功初始化
	 */
	private static void checkContext() {
		if(context ==null) {
			throw new IllegalStateException("该Spring工具类没有被初始化,无法使用!!");
		}
	}
	
	/**
	 * 发布容器事件
	 * @param event
	 */
	public static void publishEvent(ApplicationEvent event) {
		getApplicationContext().publishEvent(event);
	}
	
}