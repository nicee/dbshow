
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(100) NOT NULL COMMENT '导航栏名称',
  `parent_id` INT(11) DEFAULT NULL COMMENT '父导航栏ID',
  `url` VARCHAR(255) DEFAULT NULL COMMENT '导航栏请求地址',
  `sort_num` INT(11) NOT NULL DEFAULT '10' COMMENT '排序ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='导航栏';

DROP TABLE IF EXISTS `sys_query_tables`;
CREATE TABLE `sys_query_tables` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(100) NOT NULL COMMENT '表名称',
  `active` BIT(1) DEFAULT b'1' COMMENT '查询状态, 1=激活, 0=未激活, 默认激活',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='记录数据查询的表';

DROP TABLE IF EXISTS `sys_query_options`;
CREATE TABLE `sys_query_options` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `table_name` VARCHAR(100) NOT NULL COMMENT '表名称',
  `column_name` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '列名称, 在数据库中的列字段',
  `label_name` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '列显示名称, 未设置则使用column_name填充',
  `active` BIT(1) DEFAULT b'1' COMMENT '查询状态, 1=激活, 0=未激活, 默认激活',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='列字段查询配置';


DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(100) NOT NULL COMMENT '用户名',
  `password` VARCHAR(32) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

###--- 默认初始化数据 ---
INSERT INTO `sys_menu` VALUES (1, '系统管理', NULL, '',0);
INSERT INTO `sys_menu` VALUES (2, '数据查询', 1, NULL, 0);
INSERT INTO `sys_menu` VALUES (3, '系统设置', 1, NULL, 1);
INSERT INTO `sys_menu` VALUES (4, '新增库表', 3, '/table/tables.do', 0);
INSERT INTO `sys_menu` VALUES (5, '新增导航', 3, NULL, 1);
INSERT INTO `sys_menu` VALUES (6, '查询配置', 3, '/column/config.do', 2);

INSERT INTO `sys_user` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3');

###--- 唯一索引
CREATE UNIQUE INDEX idx_table_name ON `sys_query_tables`(`name`);
