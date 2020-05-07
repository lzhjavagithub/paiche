package com.qdyd.vehicle.po.entity;

public enum StatusCode {

    ERR,
    SUCCESS;

    public static final int OK=20000;//成功
    public static final int fail=20001;//失败
    public static final int ERROR=20007;//错误
    public static final int LOGINERROR=20002;// 用户名不存在
    public static final int PASSFAIL=20006;//密码错误
    public static final int ACCESSERROR = 20003;// 权限不足
    public static final int REMOTEERROR=20004;// 远程调用失败
    public static final int REPERROR = 20005;// 重复操作
    public static final int SESSIONFAIL=20008;//session失效，请你重新登陆
    public static final int USER_DATA_STATUS_SUCCESS=0;//用户有效
    public static final int USER_DATA_STATUS_FAIL=1;//用户失效
    public static final int USER_PER_GUANLI=1;
    public static final int USER_PER_CAOZUO=2;


}
