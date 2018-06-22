package code.heitao.exception;

import constant.ErrorEnum;
import lombok.Data;

@Data
public class BaseException extends RuntimeException{
    private String code;
    private String msg;

    public BaseException(ErrorEnum errorConst){
        this.msg = errorConst.getMsg();
        this.code = errorConst.getCode();
    }
}
