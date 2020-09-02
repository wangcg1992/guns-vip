package cn.stylefeng.guns.utils.validate;


import cn.stylefeng.guns.core.exception.ParamException;
import com.google.common.collect.Sets;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 校验工具类 帮助业务层完成数据的校验操作
 * 
 * @author trekxu
 */
public abstract class ValidateUtils {

	/* validate 本身就是线程安全的 */
	private static Validator validator;

	/*校验的错误消息的格式化器*/
	private static ValidateErrorFormat errorFarmat = new DefaultValidateErrorFormat();

	static {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	/**
	 * 获取校验器
	 * 
	 * @return
	 */
	public static Validator getValidator() {
		return validator;
	}

	/**
	 * 校验对象是否为空 如果为空,则抛出参数异常的错误
	 * 
	 * @param target
	 */
	public static final void notNull(Object target) throws ParamException {
		notNull(target, null);
	}

	/**
	 * 参数校验,如果对象为空 则抛出一个自定义消息的参数异常
	 * 
	 * @param target
	 * @param msg
	 */
	public static final void notNull(Object target, String msg) throws ParamException {
		if (Objects.isNull(target)) {
			throw new ParamException(msg);
		}
	}

	/**
	 * 使用BeanValidate完成Bean的校验 如果出现错误,则抛出异常信息. 可以从异常中的msg获取校验的问题.
	 * 
	 * @param target
	 */
	public static void validate(Object target, Class<?>... groups) {
		Set<ConstraintViolation<Object>> ConstraintViolations = getValidator().validate(target, groups);

		if (ConstraintViolations.isEmpty()) {
			return;
		}

		HashSet<ValidateErrorHolder> errorsSet = Sets.newHashSet();
		for (ConstraintViolation<Object> constraintViolation : ConstraintViolations) {
			String errorMsg = constraintViolation.getMessage();
			String fieldName = constraintViolation.getPropertyPath().toString();
			errorsSet.add(new ValidateErrorHolder(errorMsg, fieldName));
		}

		throw new ParamException(errorFarmat.format(errorsSet));
	}

	/**
	 * 设置错误消息格式化器
	 * 
	 * @param errorFarmat
	 */
	public static void setErrorFarmat(ValidateErrorFormat errorFarmat) {
		ValidateUtils.errorFarmat = errorFarmat;
	}

}
