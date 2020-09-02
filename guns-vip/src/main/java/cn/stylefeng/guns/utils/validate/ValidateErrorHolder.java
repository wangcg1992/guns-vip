package cn.stylefeng.guns.utils.validate;

import lombok.Data;

/**
 * 错误消息存储
 * @author trekxu
 *
 */
@Data
public class ValidateErrorHolder {
	
	/*错误消息*/
	private String errorMsg;
	
	/*错误的字段的名称*/
	private Object fieldName;

	public ValidateErrorHolder(String errorMsg, Object fieldName) {
		this.errorMsg = errorMsg;
		this.fieldName = fieldName;
	}
	
}
