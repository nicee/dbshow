
##-- 一些文件为测试文件, 随意创建的一些表

DROP TABLE IF EXISTS `dbshow_table`;
CREATE TABLE `dbshow_table` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `table_name` VARCHAR(100) NOT NULL COMMENT '桌子名称',
  `area_name` VARCHAR(32) NOT NULL COMMENT '区域名称',
  `creator` VARCHAR(32) NOT NULL COMMENT '创建者',
  `telphone` VARCHAR(11) NOT NULL COMMENT '联系电话',
  `comment` VARCHAR(50) NOT NULL COMMENT '备注',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='桌子表';

DROP TABLE IF EXISTS `dbshow_order`;
CREATE TABLE `dbshow_order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_number` VARCHAR(100) NOT NULL COMMENT '订单号',
  `address` VARCHAR(255) COMMENT '订单地址',
  `owner` VARCHAR(32) NOT NULL COMMENT '下单者电话',
  `owner_telphone` VARCHAR(32) NOT NULL COMMENT '创建者',
  `deliver` VARCHAR(255) COMMENT '配送员',
  `deliver_telphone` VARCHAR(11) NOT NULL COMMENT '配送员电话',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='桌子表';

##-- 数据

INSERT INTO dbshow_table(`table_name`, `area_name`, `creator`, `telphone`, `comment`) VALUES ('大红阁', '广州', '周琳', '15425751236', '测试数据');
INSERT INTO dbshow_table(`table_name`, `area_name`, `creator`, `telphone`, `comment`) VALUES ('英雄厅', '北京', '王红', '17985281235', '测试数据');
INSERT INTO dbshow_table(`table_name`, `area_name`, `creator`, `telphone`, `comment`) VALUES ('大牌屋', '上海', '陈达', '1365263253', '测试数据');
INSERT INTO dbshow_table(`table_name`, `area_name`, `creator`, `telphone`, `comment`) VALUES ('星辰楼', '深圳', '沈辉', '17523651235', '测试数据');
INSERT INTO dbshow_table(`table_name`, `area_name`, `creator`, `telphone`, `comment`) VALUES ('烟雨坊', '杭州', '晓敏', '15956365236', '测试数据');

INSERT INTO dbshow_order(`order_number`, `address`, `owner`, `owner_telphone`, `deliver`, `deliver_telphone`) VALUES ('asvyh9dzi1kyb9', '北京市东花市北里20号楼', '王浩', '17865332654', '李飒', '15648789623');
INSERT INTO dbshow_order(`order_number`, `address`, `owner`, `owner_telphone`, `deliver`, `deliver_telphone`) VALUES ('9dz5nqf2ttgtx1or', '南昌市红谷滩市政府大楼北四楼', '赵梦', '15426785632', '珍珍', '16535478963');
INSERT INTO dbshow_order(`order_number`, `address`, `owner`, `owner_telphone`, `deliver`, `deliver_telphone`) VALUES ('tbiajlgnzttvs4i', '重庆市北碚区天生路2号', '孟辰', '16258743652', '孙达', '16235487123');
INSERT INTO dbshow_order(`order_number`, `address`, `owner`, `owner_telphone`, `deliver`, `deliver_telphone`) VALUES ('40azes71bphqia4i', '上海市杨浦区邯郸路220号', '李自强', '13657489625', '钱峰', '17236548962');
INSERT INTO dbshow_order(`order_number`, `address`, `owner`, `owner_telphone`, `deliver`, `deliver_telphone`) VALUES ('qtvh07pjgw0icnmi', '北京市海淀区颐和园路5号', '习大达', '13789561542', '妮子', '18236547895');


