package com.bupt.se.homework.bo;

/**
 * @description: 返回代码
 * @author: zh
 * @create: 2018-11-10 14:08
 **/
public class ReturnCode {
    public static final String FIRST_LOGIN = "user first login";
    public static final String USER_NOT_FOUNT = "user doesn't exist";
    public static final String WRONG_PASSWORD = "password is wrong";
    public static final String LOGIN_SUCCESS = "login succeed";

    public static final int HOMEWORK_PERCENTAGE_EXCEEDED = 0xAAA;
    public static final int ASSIGN_HOMEWORK_SUCCESS = 0xAAB;
    public static final int DATABASE_ERROR = 0xAAC;
}
