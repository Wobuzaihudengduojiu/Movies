package convert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import pojo.VO.ResultVO;
import util.ResultVOUtil;

@Slf4j
@RestControllerAdvice(basePackages = {"controller","extra.controller"})
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
    /**
     * 判断支持的类型
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    /**
     * 对结果进行封装，或者进行加密处理
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof String){
            return ResultVOUtil.success(body);
        }
        if(body instanceof ResultVO){
            return body;
        }
        return ResultVOUtil.success(body);
    }
}
