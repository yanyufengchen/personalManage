package com.person.master.vo;

import com.person.master.constant.PatternConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class AddDBBakQueryVo {

    /**
     * 数据备份操作人
     */
    @NotNull(message = "操作人不能为空")
    private String hr_name;

    /**
     * 远程主机ip
     */
    @NotNull(message = "远程主机ip不能为空")
    @Size(max = 15,message = "主机IP长度不能超过15")
    @Pattern(regexp = PatternConstant.ENDPOINTS_IP,message = "主机IP不合法")
    private String node_ip;

    /**
     * 远程主机端口
     */
    @NotNull(message = "远程主机端口不能为空")
    @Size(max = 5,message = "主机端口长度不能超过15")
    @Pattern(regexp = PatternConstant.PORT,message = "主机端口必须全为数字")
    @Range(min=1, max=65535,message = "端口范围1~65535整数")
    private String node_port;

    /**
     * 远程主机用户名
     */
    @NotNull(message = "主机用户不能为空")
    private String node_user;

    /*
     *远程主机用户密码
     */
    @NotNull(message = "主机密码不能为空")
    private String node_password;

    /**
     * 数据库用户
     */
    @NotNull(message = "数据库用户名不能为空")
    private String mysql_user;

    /**
     * 数据库密码
     */
    @NotNull(message = "备份密码不能为空")
    private String mysql_password;

    /**
     * 数据库端口
     */
    @NotNull(message = "数据库端口不能为空")
    @Size(max = 5,message = "数据库端口长度不能超过15")
    @Pattern(regexp = PatternConstant.PORT,message = "主数据库端口必须全为数字")
    @Range(min=1, max=65535,message = "端口范围1~65535整数")
    private String mysql_port;

    /**
     * 备份库名
     */
    @NotNull(message = "备份库名不能为空")
    @Size(max = 64,message = "表名长度不能超过64")
    private String database_name;

    /**
     * 备份数据库表名
     */
    @NotNull(message = "备份表名不能为空")
    @Size(max = 64,message = "表名长度不能超过64")
    private String table_name;

    /**
     * 备份名
     */
    @NotNull(message = "备份名不能为空")
    @Size(max = 30,message = "备份名长度不能超过30")
    //@Pattern(regexp = PatternConstant.BAK_NAME_EMPTY, message = "备份名不合法")
    private String bak_name;

    /**
     * 备份数据存储地址
     */
    @NotNull(message = "备份地址不能为空")
    @Pattern(regexp = PatternConstant.COMM_LINUX_PATH, message = "备份路径不合法")
    private String path;
}
