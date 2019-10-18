
CREATE DATABASE `personal_master` DEFAULT CHARACTER SET utf8;

-- ----------------------------
-- user 用户
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `account` varchar(50) DEFAULT NULL COMMENT '登陆名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- user_role 用户角色
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- role 角色
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `remarks` varchar(255) DEFAULT NULL COMMENT '角色备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- role_permission 角色权限
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- menu 菜单
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` int(11) NOT NULL COMMENT '父节点id',
  `path` varchar(50) DEFAULT NULL COMMENT '菜单路劲',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单英文名称',
  `title` varchar(50) DEFAULT NULL COMMENT '菜单中文名称',
  `view` varchar(255) DEFAULT NULL COMMENT '菜单对应前端组件',
  `type` varchar(50) DEFAULT NULL COMMENT '菜单类型: menu btn',
  `hideInMenu` tinyint(4) DEFAULT NULL COMMENT '是否隐藏菜单',
  `notCache` tinyint(4) DEFAULT NULL COMMENT '是否缓存',
  `access` varchar(50) DEFAULT NULL COMMENT '可访问页面的权限数组',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- menu_role 菜单角色
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;


-- ----------------------------
-- permission 权限
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  `code` varchar(255) NOT NULL COMMENT '权限标识(唯一)',
  `type` tinyint(1) NOT NULL COMMENT '权限类型(备用扩展字段) 1: 内部接口',
  `desp` varchar(255) DEFAULT NULL COMMENT '描述信息',
  `status` tinyint(1) NOT NULL COMMENT '1有效 0无效',
  `creator` varchar(255) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- sqldataback 数据备份记录
-- ----------------------------
DROP TABLE IF EXISTS `sqldataback`;
CREATE TABLE `sqldataback` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`bak_name` VARCHAR ( 30 ) NOT NULL COMMENT '备份名称',
	`database_name` VARCHAR(64) NOT NULL COMMENT '备份库名',
	`table_name` VARCHAR(64) NOT NULL COMMENT '备份表名',
	`path` VARCHAR(64) NOT NULL COMMENT '备份地址',
	`node_ip` VARCHAR(15) NOT NULL COMMENT '主机IP',
	`node_port` INT(5) DEFAULT NULL COMMENT '主机端口',
	`node_user` VARCHAR(30) DEFAULT NULL COMMENT '主机用户',
	`node_password` VARCHAR(30) DEFAULT NULL COMMENT '主机密码',
	`mysql_user` VARCHAR(30) DEFAULT NULL COMMENT '数据库用户',
	`mysql_password` VARCHAR(30) DEFAULT NULL COMMENT '数据库密码',
	`mysql_port` INT(5) DEFAULT NULL COMMENT '数据库端口',
	`hr_id` int(11) NOT NULL COMMENT  '操作人id',
  `operateDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '备份时间',
	`update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY ( `id` ) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- ----------------------------
-- education 学历信息
-- ----------------------------
DROP TABLE IF EXISTS `education`;
CREATE TABLE `education` (
	`id` INT ( 11 ) NOT NULL COMMENT '主键',
	`name` VARCHAR ( 64 ) DEFAULT NULL COMMENT '姓名',
	`sex` VARCHAR ( 32 ) DEFAULT NULL COMMENT '性别',
	`school` VARCHAR ( 64 ) DEFAULT NULL COMMENT '学校',
	`major` VARCHAR ( 64 ) DEFAULT NULL COMMENT '专业',
	`education_category` VARCHAR ( 255 ) DEFAULT NULL COMMENT '学历类别',
	`educational_system` VARCHAR ( 255 ) DEFAULT NULL COMMENT '学制',
	`level` VARCHAR ( 255 ) DEFAULT NULL COMMENT '层次',
	`graduate` INT ( 1 ) DEFAULT NULL COMMENT '学历',
	`modality` VARCHAR ( 255 ) DEFAULT NULL COMMENT '学习形式',
	`schoolmaster` VARCHAR ( 255 ) DEFAULT NULL COMMENT '校长',
	`certificate` VARCHAR ( 255 ) DEFAULT NULL COMMENT '证书编号',
	`start_time` date DEFAULT NULL COMMENT '开始时间',
	`end_time` date DEFAULT NULL COMMENT '结束时间',
	`birthday` date DEFAULT NULL COMMENT '出生日期',
	`create_time` TIMESTAMP NULL DEFAULT NULL COMMENT '创建时间',
	`nation` VARCHAR ( 255 ) DEFAULT NULL COMMENT '名族',
	`college` VARCHAR ( 255 ) DEFAULT NULL COMMENT '学院',
PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT=0 DEFAULT CHARSET = utf8;