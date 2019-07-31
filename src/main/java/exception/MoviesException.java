package exception;

import enmu.ErrorEnum;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import pojo.VO.ResultVO;

@Getter
public class MoviesException extends RuntimeException {
    private ResultVO resultVO;

    /**
     * 调用时可以在任何代码处直接throws这个Exception,
     * 都会统一被拦截,并封装好json返回给前台
     *
     * @param errorEnum 以错误的ErrorEnum做参数
     */
    public MoviesException(ErrorEnum errorEnum) {
        this.resultVO = new ResultVO();
        this.resultVO.setCode(errorEnum.getCode());
        this.resultVO.setMsg(errorEnum.getMsg());
    }

    public MoviesException() {
    }
}
