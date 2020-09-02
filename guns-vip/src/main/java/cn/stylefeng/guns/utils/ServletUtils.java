package cn.stylefeng.guns.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于处理标准的Servlet API
 * @author trek
 * 
 * 使用了RequestContextHolder对象,该对象在Springmvc的前端控制器之中绑定了
 * 	当前用户的请求和响应.
 *
 */
public abstract class ServletUtils {
	
	
	/**
	 * 获取请求的上下文的属性对象
	 */
	private static  ServletRequestAttributes getRequestAttributes() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		// 实际上这个在
		if(requestAttributes instanceof ServletRequestAttributes) {
			return (ServletRequestAttributes)requestAttributes;
		}
		throw new IllegalStateException("当前的请求上下文不是标准的Servlet环境!");
	}
	
	/**
	 * 获取请求对象
	 */
	public static HttpServletRequest getRequest() {
		return getRequestAttributes().getRequest();
	}
	
	/**
	 * 获取响应对象
	 */
	public static HttpServletResponse getResponse() {
		return getRequestAttributes().getResponse();
	}
}
