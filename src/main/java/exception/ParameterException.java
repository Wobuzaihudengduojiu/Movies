package exception;

import lombok.Getter;

@Getter
public class ParameterException extends RuntimeException {

    private Integer code;

    private String msg;

    public ParameterException(String msg){

        super(msg);
    }

    public ParameterException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
