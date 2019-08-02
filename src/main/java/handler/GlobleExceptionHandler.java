package handler;


import enmu.ErrorEnum;
import exception.MoviesException;
import exception.ParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pojo.VO.ResultVO;
import pojo.entity.Movie;
import util.ResultVOUtil;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {

    @ExceptionHandler(value = {ParameterException.class})
    @ResponseBody
    public ResultVO parameterHandler(HttpServletRequest request, Exception exception) {

        log.info("参数检测异常");
        ResultVO errorInfo = ResultVOUtil.error(ErrorEnum.E_90003);
        errorInfo.setUrl(request.getRequestURI());
        log.info("异常信息:{}", errorInfo.toString());
        return errorInfo;
    }


//    @ExceptionHandler(value = {Exception.class})
//    public ResultVO defaultExceptionHandler(HttpServletRequest request, Exception exception) {
//
//        log.info("默认异常处理");
//        ResultVO errorInfo = ResultVOUtil.error(-1, exception.getMessage());
//        errorInfo.setUrl(request.getRequestURI());
//        log.info("默认异常处理信息：{}", errorInfo.toString());
//        return errorInfo;
//    }

    /**
     * 本系统自定义错误的拦截器
     * 拦截到此错误之后,就返回这个类里面的json给前端
     * 常见使用场景是参数校验失败,抛出此错,返回错误信息给前端
     */
    @ExceptionHandler(MoviesException.class)
    public ResultVO commonJsonExceptionHandler(MoviesException myException) {
        return myException.getResultVO();
    }

}
