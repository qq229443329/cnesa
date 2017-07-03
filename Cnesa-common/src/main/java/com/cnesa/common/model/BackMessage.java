package com.cnesa.common.model;

/**
 * Created by shangpeibao on 16/11/24.
 *
 * Controller 返回对象
 */
public class BackMessage implements java.io.Serializable {

    private static final long serialVersionUID = 7305964992612204731L;
    private boolean success = false;
    private Object data;
    private String msg;
    private String error;
    private String token;
    private Exception exception;

    public BackMessage() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "BackMessage{" +
                "success=" + success +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", error='" + error + '\'' +
                ", token='" + token + '\'' +
                ", exception=" + exception +
                '}';
    }
}
