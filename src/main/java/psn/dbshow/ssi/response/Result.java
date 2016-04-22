package psn.dbshow.ssi.response;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = -1221344864752080759L;

    private Integer code;

    private Object result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
