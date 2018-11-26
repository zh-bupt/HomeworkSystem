package com.bupt.se.homework.exception;

/**
 * @description: service层异常
 * @author: zh
 * @create: 2018-11-26 16:02
 **/
public class ServiceException extends RuntimeException {

    protected Long errorCode;
    protected Object data;

    public ServiceException(Long errorCode,String message,Object data,Throwable e){
        super(message,e);
        this.errorCode = errorCode ;
        this.data = data ;
    }

    public ServiceException(Long errorCode,String message,Object data){
        this(errorCode,message,data,null);
    }

    public ServiceException(Long errorCode,String message){
        this(errorCode,message,null,null);
    }

    public ServiceException(String message,Throwable e){
        this(null,message,null,e);
    }

    public ServiceException(){

    }

    public ServiceException(Throwable e){
        super(e);
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
