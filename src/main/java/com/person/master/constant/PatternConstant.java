package com.person.master.constant;

public class PatternConstant {
    /**
     * 通用: 数字以逗号隔开
     */
    public static final String COMM_NUMBER_POINT = "^([0-9]*[,]?)+$";

    /**
     * 通用: 验证路径合法性
     */
    public static final String COMM_LINUX_PATH = "^\\/?$|(\\/([-_.:0-9a-zA-Z]+)\\/?)+$";

    /**
     * 通用: 验证路径合法性, 可以为空
     */
    public static final String COMM_LINUX_PATH_EMPTY = "^$|^\\/?$|(\\/([-_.:0-9a-zA-Z]+)\\/?)+$";

    /**
     * 部署: 环境变量名称规则 必须以字母、点、连字符、下划线开头，后面可以接数字
     */
    public static final String DEPLOY_ENV_NAME = "^[a-zA-Z][-._a-zA-Z0-9]*$";

    /**
     * 部署: 服务名称规则 起始必须是小写字母，中间可以有数字和中横线,不支持大写字母和全数字
     */
    public static final String DEPLOY_SERVICE_NAME = "^[a-z]([-a-z0-9]*[a-z0-9])?$";

    /**
     * 备份名称规则 起始必须是小写字母，中间可以有数字和中横线,不支持大写字母和全数字
     */
    public static final String BAK_NAME = "^$|[a-z]([.-a-z0-9]*[.a-z0-9])?$";
    /**
     * 部署: host规则(可以为空)
     */
    public static final String DEPLOY_HOST_EMPTY = "^$|(?=^.{3,255}$)[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+$";

    /**
     * 菜单路径校验：必须以/开头,后面可跟-_.:数字英文大小写
     */
    public static final String MENU_PATH_PATTERN = "^(\\/([-_.:$0-9a-zA-Z]*)\\/?)+$";

    /**
     * 菜单路径校验(可为空)：必须以/开头,后面可跟-_.:数字英文大小写
     */
    public static final String MENU_PATH_PATTERN_EMPTY = "^$|(\\/([-_.:$0-9a-zA-Z]*)\\/?)+$";

    /**
     * 菜单英文名称校验：必须输入-_英文大小写
     */
    public static final String MENU_NAME_PATTERN = "^[-_a-zA-Z]+$";

    /**
     * 菜单中文名称校验：必须输入中文字符
     */
    public static final String MENU_TITLE_PATTERN = "^[\\u4E00-\\u9FA5]+$";

    /**
     * 菜单中文名称校验(可为空)：必须输入中文字符
     */
    public static final String MENU_TITLE_PATTERN_EMPTY = "^$|[\\u4E00-\\u9FA5]+$";

    /**
     * 角色名称校验：必须输入小写字符
     */
    public static final String ROLE_LOW_NAME_PATTERN = "^[a-z]*$";

    /**
     * 项目名称校验：起始为字母大小写 中间可以有数字和中横线 且不以中横线结尾
     */
    public static final String PRO_NAME_PATTERN = "^[a-zA-Z]([-a-zA-Z0-9]*[a-zA-Z0-9])$";

    /**
     * 项目包名校验
     */
    public static final String PRO_PACKAGE_PATTERN = "$|^[a-z][0-9a-z]*(\\.[a-z][0-9a-z]*)+$";

    /**
     * 资源名称校验：必须是中英文数字，可加斜线、中横线
     */
    public static final String SOURCE_NAME = "^[\\u4e00-\\u9fa5a-zA-Z0-9-/]+$";

    /**
     * 资源名称校验(可为空)：必须是中英文数字，可加斜线、中横线
     */
    public static final String SOURCE_NAME_EMPTY = "^$|[\\u4e00-\\u9fa5a-zA-Z0-9-/]+$";
    /**
     * 团队名称校验
     */
    public static final String GROUP_NAME_PATTERN = "^[-_.a-zA-Z0-9]+$";

    public static final String ENDPOINTS_IP = "^((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}" +
            "(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))$";

    /**
     * 主机端口必须为全数字
     */
    public static final String PORT = "^[0-9]*$";

    /**
     * ip地址校验
     */
    public static final String IPS = "^((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|" +
            "((1\\d{2})|([1-9]?\\d))))$";

    /**
     * 报警规则名称只能包含大小写英文字母和下划线
     */
    public static final String ALERT_NAME_PATTERN = "\\w+";
    /**
     * 报警规则时间
     */
    public static final String ALERT_DURATION_PATTERN = "^\\d+m$";

    /**
     * 项目空间名称规则 起始必须是小写字母，中间可以有数字和中横线,不支持大写字母和全数字
     */
    public static final String PROJECT_SPACE_NAME = "^[a-z]([-a-z0-9]*[a-z0-9])?$";

    /**
     * 项目空间名称规则(可为空)： 起始必须是小写字母，中间可以有数字和中横线,不支持大写字母和全数字
     */
    public static final String PROJECT_SPACE_NAME_EMPTY = "^$|[a-z]([-a-z0-9]*[a-z0-9])?$";

    /**
     * 团队仓库用户密码规则：密码长度在8到20之间且需包含至少一个大写字符、一个小写字符和一个数字,不允许特殊字符
     */
    public static final String GROUP_REGISTRY_USER_PASS = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$";

    /**
     * 自动化测试上传文件名称格式规则：只可以数字和字母，不能包含特殊字符
     */
    public static final String AUTO_TEST_FILE = "^([\\u4E00-\\u9FA5A-Za-z0-9][\\u4E00-\\u9FA5A-Za-z0-9_-]*[\\u4E00-\\u9FA5A-Za-z0-9]{1,30})+$";

    /**
     * ftp镜像名称验证: 只能是字符数字中横线下划线
     */
    public static final String IMG_NAME = "^[A-Za-z0-9-_]+$";

    /**
     *镜像版本验证: 必须以小写字母或数字开头、结尾，中间可以是.-小写字母数字
     */
    public static final String IMG_VERSION = "^[a-z\\d]*[a-z\\d.-]+[a-z\\d]+$";

    /**
     * 内存大小校验
     */
    public static final String MEMORY = "^[+-]?\\d+(\\.\\d+)?$|^$|^(\\d+|\\-){7,}$";
}
