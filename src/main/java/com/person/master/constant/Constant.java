package com.person.master.constant;

public class Constant {

    /**
     * SessionKey-用户
     */
    public static final String ADMIN = "admin";

    public static final Integer MERGE_ERROR_CODE_405 = 405;

    /**
     * 用户权限列表 SessionKey
     */
    public static final String SESSION_USER_PERMISSION = "user_permissions";

    /**
     * 用户信息 SessionKey
     */
    public static final String SESSION_USER_INFO = "user_info";

    /**
     * 用户密码
     */
    public static final String SESSION_USER_PASSWORD = "user_info_password";

    /**
     * 超级管理员账号
     */
    public static final String ADMIN_ACCOUNT = "admin";


    /**
     * excel限制后缀名称
     */
    public static final String[] EXCEL_TYPES = {"xls","xlsx"};

    /**
     * 逻辑删除: 有效
     */
    public static final int STATUS_YES = 1;

    /**
     * 逻辑删除: 已删除
     */
    public static final int STATUS_NO = 0;

    /**
     *
     */
    public static final String BRANCH_MATCHER = "^([\\u4E00-\\u9FA5A-Za-z0-9][\\u4E00-\\u9FA5A-Za-z0-9_-]*[\\u4E00-\\u9FA5A-Za-z0-9]{1,30})+$";

    public static final String CANNOT_BE_MERGED = "cannot_be_merged";
    public static final String BRANCH_CANNOT_BE_MERGED = "Branch cannot be merged";
    public static final String METHOD_NOT_ALLOWED = "405 Method Not Allowed";

}
