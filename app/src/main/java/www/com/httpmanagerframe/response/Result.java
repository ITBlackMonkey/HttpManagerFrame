package www.com.httpmanagerframe.response;

import java.io.Serializable;


/**
 * @author: WANGWEI
 *
 * response 结果处理
 */

public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T BODY;

    public T getBODY() {
        return BODY;

    }

    public void setBODY(T bODY) {
        BODY = bODY;
    }



    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
