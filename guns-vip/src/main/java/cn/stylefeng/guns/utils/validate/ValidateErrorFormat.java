package cn.stylefeng.guns.utils.validate;

import java.util.Set;

/**
 * 校验错误格式化器
 *  主要是为了帮助将错误的消息进行格式化处理的
 * @author trekxu
 */
public interface ValidateErrorFormat {
	
	/**
	 * 将错误消息进行格式化
	 * @param errors
	 * @return
	 */
	String format(Set<ValidateErrorHolder> errors);
}
