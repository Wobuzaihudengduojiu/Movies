package handler;


import enmu.ErrorEnum;
import exception.ParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pojo.VO.ResultVO;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {

    @ExceptionHandler(value = {ParameterException.class})
    @ResponseBody
    public ResultVO<Object> parameterHandler(HttpServletRequest request, Exception exception) {

        log.info("参数检测异常");
        ResultVO<Object> errorInfo = new ResultVO<>();
        errorInfo.setCode(ErrorEnum.E_90003.getCode());
        errorInfo.setMsg(ErrorEnum.E_90003.getMsg());
        errorInfo.setUrl(request.getRequestURI());
        log.info("异常信息:{}", errorInfo.toString());
        return errorInfo;
    }




}
