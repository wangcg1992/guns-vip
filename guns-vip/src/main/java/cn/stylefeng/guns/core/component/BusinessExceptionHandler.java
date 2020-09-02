package cn.stylefeng.guns.core.component;

import cn.stylefeng.guns.core.exception.BusinessException;
import cn.stylefeng.roses.kernel.model.response.ErrorResponseData;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(-200)
@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.OK)
    public ResponseData notFount(BusinessException e) {
        String errorMsg = null;
        if(StringUtils.isEmpty(e.getMessage())){
            errorMsg = "服务器出现错误";
        }else{
            errorMsg = e.getMessage();
        }
        return new ErrorResponseData(200, errorMsg);
    }
}
