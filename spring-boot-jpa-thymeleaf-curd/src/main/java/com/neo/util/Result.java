package com.neo.util;

/**
 * 定义Json数据的数据类型
 */
public class Result {
    private Integer code; // 状态码
    private Boolean isSuccess; // 状态
    private String message; // 消息
    private Object result; // 数据对象

    public Result(){
        super();
    }

    // 只返回状态，状态码和消息
    public Result(Boolean isSuccess, Integer code, String message){
        super();
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    // 只返回状态，状态码，和数据对象
    public Result(Boolean isSuccess, Integer code, Object result){
        super();
        this.isSuccess = isSuccess;
        this.code = code;
        this.result = result;
    }

    public Result(Boolean isSuccess, Integer code, String message, Object result){
        super();
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
