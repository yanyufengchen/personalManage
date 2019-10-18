package com.person.master.dto.bak;

import lombok.Data;

@Data
public class DBBakDto {
    /*
     * 主键
     */
    private int id;

    /*
     * 备份名
     */
    private String bak_name;


    /*
     * 数据库名
     */
    private String database_name;

    /*
     * 数据库表名
     */
    private String table_name;

    /*
     * 操作人员id
     */
    private int hr_id;

    /**
     * 操作人
     */
    private String hr_name;

    /**
     * 远程主机ip
     */
    private String node_ip;

    /**
     * 远程主机端口
     */
    private int node_port;

    /**
     * 远程主机密码
     */
    private String node_password;

    /**
     * 远程主机用户名
     */
    private String node_user;

    /**
     * 数据库用户
     */
    private String mysql_user;

    /**
     * 数据库密码
     */
    private String mysql_password;

    /**
     * 备份数据存储地址
     */
    private String path;

    /*
     * 操作时间
     */
    private String operateDate;


    /*
     * 数据库端口
     */
    private int mysql_port;
}
