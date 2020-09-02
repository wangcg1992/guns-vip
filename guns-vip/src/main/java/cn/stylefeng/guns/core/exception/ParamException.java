package cn.stylefeng.guns.core.exception;

import cn.stylefeng.roses.kernel.model.exception.ServiceException;

/**
 * 参数异常
 * 
 * @author xulu
 *
 */
@SuppressWarnings("serial")
public class ParamException extends ServiceException {

	public ParamException(String message) {
		super(500,message);
	}
}
