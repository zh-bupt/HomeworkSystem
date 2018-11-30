package com.bupt.se.homework.exception;

/**
 * @description: ServiceException的错误代码
 * @author: zh
 * @create: 2018-11-26 16:07
 **/
public class ServiceExceptionErrorCode {
    public static final long GROUP_STUDENT_NOT_FOUND = 0xACE332;
    public static final long STUDENT_NOT_FOUND = 0xACE333;
    public static final long TEACHER_NOT_FOUND = 0xACE334;
    public static final long HOMEWORK_NOT_FOUND = 0xACE337;
    public static final long ASSIGN_HOMEWORK_ERROR = 0xACE338;
    public static final long TEACHER_DUPLICATED = 0xACE339;
    public static final long GROUP_STUDENT_CONTRIBUTION_ERROR = 0xACE340;
    public static final long HOMEWORK_GROUP_NOT_FOUND = 0xACE341;
    public static final long HOMEWORK_GROUP_SCORE_ERROR = 0xACE342;
    public static final long STUDENT_DUPLICATED = 0xACE343;
    public static final long HOMEWORK_PERCENTAGE_EXCEED = 0xACE344;
    public static final long HOMEWORK_PERCENTAGE_ERROR = 0xACE345;

    public static final long GROUP_NOT_FOUND = 0xBEE211;
    public static final long GROUP_NUM_ERROR = 0xBEE212;

    public static final long ADMIN_NOT_FOUND = 0xBEEF336;
    public static final long ADMIN_DUPLICATED = 0xBEEF336;

    public static final long COURSE_NOT_FOUND = 0xFEE432;
    public static final long COURSE_DUPLICATED = 0xFEE433;
    public static final long NOT_IN_GROUP = 0xACE344;
}
