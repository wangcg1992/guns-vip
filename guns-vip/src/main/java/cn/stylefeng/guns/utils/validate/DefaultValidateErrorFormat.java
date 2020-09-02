package cn.stylefeng.guns.utils.validate;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Set;

/**
 * 默认的校验错误消息格式化器
 * @author trekxu
 */
public class DefaultValidateErrorFormat implements ValidateErrorFormat {

	@Override
	public String format(Set<ValidateErrorHolder> errors) {
		if(Objects.isNull(errors)) {
			return StringUtils.EMPTY;
		}
		
		final StringBuilder sb = new StringBuilder();
		errors.forEach(e->{
			sb.append(e.getErrorMsg()).append(StringUtils.LF);
		});
		
		return sb.toString();
	}

}
