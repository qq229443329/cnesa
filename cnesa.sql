/*
 Navicat MySQL Data Transfer

 Source Server         : 121.42.42.69
 Source Server Version : 50627
 Source Host           : 121.42.42.69
 Source Database       : cnesa

 Target Server Version : 50627
 File Encoding         : utf-8

 Date: 07/03/2017 17:45:09 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `AUTH_ORGANIZATION`
-- ----------------------------
DROP TABLE IF EXISTS `AUTH_ORGANIZATION`;
CREATE TABLE `AUTH_ORGANIZATION` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(45) NOT NULL COMMENT '组织名称',
  `code` varchar(45) DEFAULT NULL COMMENT '组织编码',
  `address` varchar(100) DEFAULT NULL COMMENT '组织地址',
  `description` varchar(200) DEFAULT NULL COMMENT '组织描述',
  `icon` varchar(45) DEFAULT NULL COMMENT '组织图标',
  `seq` int(11) DEFAULT NULL COMMENT '显示优先级',
  `parent_id` varchar(45) DEFAULT NULL COMMENT '所属父类',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织表';

-- ----------------------------
--  Records of `AUTH_ORGANIZATION`
-- ----------------------------
BEGIN;
INSERT INTO `AUTH_ORGANIZATION` VALUES ('29c969f05663460a9a4e52cffbf186e5', '部门DEMO', 'DEPARTMENT', '', null, '', '0', '', '2017-07-03 17:25:40');
COMMIT;

-- ----------------------------
--  Table structure for `AUTH_ROLE`
-- ----------------------------
DROP TABLE IF EXISTS `AUTH_ROLE`;
CREATE TABLE `AUTH_ROLE` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `role_name` varchar(45) DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `description` varchar(45) DEFAULT NULL COMMENT '描述',
  `seq` int(11) NOT NULL DEFAULT '0' COMMENT '排序序号',
  `status` int(11) DEFAULT NULL COMMENT '角色状态, 0:未激活,1:已激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
--  Records of `AUTH_ROLE`
-- ----------------------------
BEGIN;
INSERT INTO `AUTH_ROLE` VALUES ('18b03ccceb3f4b79b35060900259a039', '超级管理员', '2016-12-08 13:49:16', '2016-12-08 13:49:18', '超级管理员', '0', '1');
COMMIT;

-- ----------------------------
--  Table structure for `AUTH_ROLE_MENU`
-- ----------------------------
DROP TABLE IF EXISTS `AUTH_ROLE_MENU`;
CREATE TABLE `AUTH_ROLE_MENU` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `role_id` varchar(36) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(36) NOT NULL COMMENT '资源菜单ID',
  PRIMARY KEY (`id`),
  KEY `AUTH_ROLE_MENU_ROLE_FK_idx` (`role_id`),
  KEY `AUTH_ROLE_MENU_MENU_FK_idx` (`menu_id`),
  CONSTRAINT `AUTH_ROLE_MENU_MENU_FK` FOREIGN KEY (`menu_id`) REFERENCES `MG_MENU` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `AUTH_ROLE_MENU_ROLE_FK` FOREIGN KEY (`role_id`) REFERENCES `AUTH_ROLE` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';

-- ----------------------------
--  Records of `AUTH_ROLE_MENU`
-- ----------------------------
BEGIN;
INSERT INTO `AUTH_ROLE_MENU` VALUES ('c3d8bc64-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '0348992e6294490c9a648a5773fc38b8'), ('c3e11ede-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '4e7e3c47ec784242957ea711439457a2'), ('c3e97d19-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '0309b6b506e148588775b01a1b5644e7'), ('c3f1d5c7-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '83df1f179145414d8498af883e7b8604'), ('c3fa8063-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', 'd8f3f7838dd643ada0a9f9ac590dcc40'), ('c402da73-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '56661972de2443c5a75242ed65be7944'), ('c40b96f5-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '5981ad9e9096491b92f6c7b8514f5d79'), ('c41415b1-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '33037db8-5e2b-11e7-87b2-00163e04d0f8'), ('c41c6e6d-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', 'abad9f60bd3311e68c6c6aee6c504e95'), ('c424c97d-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '139ec3c0bd3311e68c6c6aee6c504e95'), ('c42d2e21-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', 'f96e0790bd3211e68c6c6aee6c504e95'), ('c4357335-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', 'acfdff5913c14e87bbf6c6fabfc15e7e'), ('c43ddbe0-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '6b0b0024-be00-11e6-9e92-da84058bacbb'), ('c4462b0d-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', 'a89420f6-be00-11e6-9e92-da84058bacbb'), ('c44eb413-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', 'bbc61774-be00-11e6-9e92-da84058bacbb'), ('c456cee9-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', 'dd6d44ba-be00-11e6-9e92-da84058bacbb'), ('c45f6003-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '69e223ec-5e3a-11e7-87b2-00163e04d0f8'), ('c467c29b-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', 'ffde417cc7dc495f833387683b446704'), ('c472cf6d-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '0c551de8-be01-11e6-9e92-da84058bacbb'), ('c47b63ac-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '2806a796-be01-11e6-9e92-da84058bacbb'), ('c483bdf2-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '34209e98-be00-11e6-9e92-da84058bacbb'), ('c48c0d0b-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', 'f8234480-be00-11e6-9e92-da84058bacbb'), ('c4946224-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', 'e4492d7f-0959-11e7-a94e-00163e04e6dc'), ('c49ca6a1-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '620815f4-095a-11e7-a94e-00163e04e6dc'), ('c4a5038d-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '9e2bda60-095b-11e7-a94e-00163e04e6dc'), ('c4ad20ab-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', 'f0dbe80d-095b-11e7-a94e-00163e04e6dc'), ('c4b57f7c-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '92dc7508-5fd0-11e7-87b2-00163e04d0f8'), ('c4bde38c-5fd0-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '1cc8783e-c124-11e6-aafc-406436e2cb53');
COMMIT;

-- ----------------------------
--  Table structure for `AUTH_USER`
-- ----------------------------
DROP TABLE IF EXISTS `AUTH_USER`;
CREATE TABLE `AUTH_USER` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `username` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `real_name` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(12) DEFAULT NULL COMMENT '移动电话',
  `icon` varchar(60) DEFAULT NULL COMMENT '头像',
  `fax_number` varchar(45) DEFAULT NULL COMMENT '传真',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '用户登录状态, 100:表示超级管理员;0:未激活,1:已激活,2:已登录',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型 0:普通用户, 1:管理员, 2:超级管理员',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `org_id` varchar(36) NOT NULL COMMENT '所属组织',
  `com_id` varchar(36) DEFAULT NULL COMMENT '所属企业',
  `token` varchar(1000) DEFAULT NULL COMMENT '用户登录token',
  `region` varchar(50) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL COMMENT '职位',
  `prestore_a` varchar(50) DEFAULT NULL COMMENT '预留字段1',
  `prestore_b` varchar(50) DEFAULT NULL COMMENT '预留字段2',
  `prestore_c` varchar(50) DEFAULT NULL COMMENT '预留字段3',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `AUTH_USER_ORGANIZATION_FK_idx` (`org_id`),
  KEY `com_id` (`com_id`),
  CONSTRAINT `AUTH_USER_COMPANY_FK` FOREIGN KEY (`com_id`) REFERENCES `MG_COMPANY` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `AUTH_USER_ORGANIZATION_FK` FOREIGN KEY (`org_id`) REFERENCES `AUTH_ORGANIZATION` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Records of `AUTH_USER`
-- ----------------------------
BEGIN;
INSERT INTO `AUTH_USER` VALUES ('667a413ac794471196db49080a070a11', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 'esonline@esonline.cn', '123', null, null, '1', '2', '0', '2016-12-13 16:22:35', '29c969f05663460a9a4e52cffbf186e5', '80573862bdce11e69e92da84058bacbb', null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `AUTH_USER_ROLE`
-- ----------------------------
DROP TABLE IF EXISTS `AUTH_USER_ROLE`;
CREATE TABLE `AUTH_USER_ROLE` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `role_id` varchar(36) NOT NULL COMMENT '角色ID',
  `user_id` varchar(36) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`),
  KEY `AUTH_ROLE_USER_ROLE_FK_idx` (`role_id`),
  KEY `AUTH_ROLE_USER_USER_FK_idx` (`user_id`),
  CONSTRAINT `AUTH_ROLE_USER_ROLE_FK` FOREIGN KEY (`role_id`) REFERENCES `AUTH_ROLE` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `AUTH_ROLE_USER_USER_FK` FOREIGN KEY (`user_id`) REFERENCES `AUTH_USER` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
--  Records of `AUTH_USER_ROLE`
-- ----------------------------
BEGIN;
INSERT INTO `AUTH_USER_ROLE` VALUES ('5bf3e6ac-5fcf-11e7-87b2-00163e04d0f8', '18b03ccceb3f4b79b35060900259a039', '667a413ac794471196db49080a070a11');
COMMIT;

-- ----------------------------
--  Table structure for `MG_COMPANY`
-- ----------------------------
DROP TABLE IF EXISTS `MG_COMPANY`;
CREATE TABLE `MG_COMPANY` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `code` varchar(45) DEFAULT NULL COMMENT '企业编码',
  `name` varchar(45) DEFAULT NULL COMMENT '企业名称',
  `description` varchar(100) DEFAULT NULL COMMENT '企业描述',
  `industry` varchar(45) DEFAULT NULL COMMENT '所属行业',
  `people_size` varchar(45) DEFAULT NULL COMMENT '企业规模',
  `working_time` varchar(45) DEFAULT NULL COMMENT '工作时间',
  `legal_people` varchar(45) DEFAULT NULL COMMENT '企业法人',
  `legal_mobile` varchar(45) DEFAULT NULL COMMENT '法人电话',
  `contact_people` varchar(45) DEFAULT NULL COMMENT '企业联系人',
  `contact_mobile` varchar(45) DEFAULT NULL COMMENT '联系人电话',
  `busniess_num` varchar(45) DEFAULT NULL COMMENT '企业许可编号',
  `busniess_license` varchar(100) DEFAULT NULL COMMENT '企业营业执照',
  `icon_logo` varchar(100) DEFAULT NULL COMMENT '企业logo',
  `region` varchar(50) DEFAULT NULL COMMENT '所在地区',
  `location` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业表';

-- ----------------------------
--  Records of `MG_COMPANY`
-- ----------------------------
BEGIN;
INSERT INTO `MG_COMPANY` VALUES ('80573862bdce11e69e92da84058bacbb', 'DEMO', '北京XXXX有限公司', '北京XXXX有限公司', '房地产', '20', '', '', '', 'XXX', '', '', '', '', '', '', '2016-12-09 13:16:05');
COMMIT;

-- ----------------------------
--  Table structure for `MG_MENU`
-- ----------------------------
DROP TABLE IF EXISTS `MG_MENU`;
CREATE TABLE `MG_MENU` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(45) DEFAULT NULL COMMENT '菜单名称',
  `description` varchar(45) DEFAULT NULL COMMENT '菜单描述',
  `status` int(11) DEFAULT '1' COMMENT '是否显示，默认1显示',
  `seq` int(11) DEFAULT '1' COMMENT '显示序号',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `state` varchar(6) NOT NULL COMMENT 'closed',
  `url` varchar(45) DEFAULT NULL COMMENT '请求URL',
  `resource_type` int(11) NOT NULL DEFAULT '0' COMMENT '资源类型，0:菜单，1:按钮, 2:权限资源',
  `function_type` int(11) NOT NULL DEFAULT '0' COMMENT '功能类型；0配置用途，1权限用途，2菜单用途',
  `parent_id` varchar(36) DEFAULT NULL COMMENT '所属父类',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源菜单表';

-- ----------------------------
--  Records of `MG_MENU`
-- ----------------------------
BEGIN;
INSERT INTO `MG_MENU` VALUES ('0309b6b506e148588775b01a1b5644e7', '添加', '资源添加', '1', '0', 'icon-add', 'open', '/resource/add', '1', '1', '4e7e3c47ec784242957ea711439457a2', '2017-03-15 16:59:19'), ('0348992e6294490c9a648a5773fc38b8', '权限管理', '权限管理', '1', '0', 'icon-company', 'open', '', '0', '1', null, '2017-07-03 15:57:31'), ('0c551de8-be01-11e6-9e92-da84058bacbb', '编辑', '部门编辑', '1', '0', 'icon-edit', 'open', '/organization/edit', '1', '1', 'ffde417cc7dc495f833387683b446704', '2017-03-15 17:00:16'), ('139ec3c0bd3311e68c6c6aee6c504e95', '编辑', '角色编辑', '1', '2', 'icon-edit', 'open', '/role/edit', '1', '1', '5981ad9e9096491b92f6c7b8514f5d79', '2017-03-15 16:59:41'), ('1cc8783e-c124-11e6-aafc-406436e2cb53', '修改密码', '', '1', '30', 'icon-edit', 'open', '/user/editPwdPage', '1', '0', null, '2017-06-09 10:11:33'), ('2806a796-be01-11e6-9e92-da84058bacbb', '列表', '部门列表', '1', '0', 'icon-list', 'open', '/organization/treeGrid', '1', '1', 'ffde417cc7dc495f833387683b446704', '2017-03-15 17:00:11'), ('33037db8-5e2b-11e7-87b2-00163e04d0f8', '添加', '添加角色', '1', '0', 'icon-add', 'open', '/role/add', '1', '0', '5981ad9e9096491b92f6c7b8514f5d79', '2017-07-01 15:02:09'), ('34209e98-be00-11e6-9e92-da84058bacbb', '添加', '部门添加', '1', '0', 'icon-add', 'open', '/organization/add', '1', '1', 'ffde417cc7dc495f833387683b446704', '2017-03-15 17:00:13'), ('4e7e3c47ec784242957ea711439457a2', '资源管理', '资源管理', '1', '1', 'menu_icon_datadeal', 'open', '/resource/manager', '0', '1', '0348992e6294490c9a648a5773fc38b8', '2017-03-15 16:59:13'), ('56661972de2443c5a75242ed65be7944', '列表', '资源列表', '1', '3', 'icon-list', 'open', '/resource/treeGrid', '1', '1', '4e7e3c47ec784242957ea711439457a2', '2017-03-15 16:59:28'), ('5981ad9e9096491b92f6c7b8514f5d79', '角色管理', '角色管理', '1', '2', 'menu_icon_datadeal', 'open', '/role/manager', '0', '1', '0348992e6294490c9a648a5773fc38b8', '2017-03-15 16:59:32'), ('620815f4-095a-11e7-a94e-00163e04e6dc', '企业管理', '企业管理', '1', '0', 'menu_icon_datadeal', 'open', '/company/manager', '0', '0', 'e4492d7f-0959-11e7-a94e-00163e04e6dc', '2017-03-15 16:35:45'), ('69e223ec-5e3a-11e7-87b2-00163e04d0f8', '重置密码', '重置密码', '1', '10', 'icon-lock', 'open', '/user/reset', '1', '0', 'acfdff5913c14e87bbf6c6fabfc15e7e', '2017-07-01 16:51:04'), ('6b0b0024-be00-11e6-9e92-da84058bacbb', '添加', '用户添加', '1', '0', 'icon-add', 'open', '/user/addUser', '1', '1', 'acfdff5913c14e87bbf6c6fabfc15e7e', '2017-03-15 16:59:52'), ('83df1f179145414d8498af883e7b8604', '删除', '资源删除', '1', '1', 'icon-del', 'open', '/resource/delete', '1', '1', '4e7e3c47ec784242957ea711439457a2', '2017-03-15 16:59:22'), ('92dc7508-5fd0-11e7-87b2-00163e04d0f8', '删除', '删除企业', '1', '5', 'icon-del', 'open', '/company/delete', '1', '0', '620815f4-095a-11e7-a94e-00163e04e6dc', '2017-07-03 17:19:13'), ('9e2bda60-095b-11e7-a94e-00163e04e6dc', '编辑', '编辑企业', '1', '2', 'icon-edit', 'open', '/company/edit', '1', '0', '620815f4-095a-11e7-a94e-00163e04e6dc', '2017-03-15 16:54:55'), ('a89420f6-be00-11e6-9e92-da84058bacbb', '删除', '用户删除', '1', '1', 'icon-del', 'open', '/user/delete', '1', '1', 'acfdff5913c14e87bbf6c6fabfc15e7e', '2017-03-15 16:59:55'), ('abad9f60bd3311e68c6c6aee6c504e95', '删除', '角色删除', '1', '1', 'icon-del', 'open', '/role/delete', '1', '1', '5981ad9e9096491b92f6c7b8514f5d79', '2017-03-15 16:59:38'), ('acfdff5913c14e87bbf6c6fabfc15e7e', '用户管理', '', '1', '3', 'menu_icon_datadeal', 'open', '/user/manager', '0', '1', '0348992e6294490c9a648a5773fc38b8', '2017-03-15 16:59:48'), ('bbc61774-be00-11e6-9e92-da84058bacbb', '编辑', '用户编辑', '1', '2', 'icon-edit', 'open', '/user/edit', '1', '1', 'acfdff5913c14e87bbf6c6fabfc15e7e', '2017-03-15 17:00:00'), ('d8f3f7838dd643ada0a9f9ac590dcc40', '编辑', '资源编辑', '1', '2', 'icon-edit', 'open', '/resource/edit', '1', '1', '4e7e3c47ec784242957ea711439457a2', '2017-03-15 16:59:25'), ('dd6d44ba-be00-11e6-9e92-da84058bacbb', '列表', '用户列表', '1', '3', 'icon-list', 'open', '/user/dataGrid', '1', '1', 'acfdff5913c14e87bbf6c6fabfc15e7e', '2017-03-15 17:00:03'), ('e4492d7f-0959-11e7-a94e-00163e04e6dc', '项目管理', '', '1', '1', 'icon-company', 'open', '', '0', '0', null, '2017-03-15 16:47:24'), ('f0dbe80d-095b-11e7-a94e-00163e04e6dc', '列表', '企业列表', '1', '3', 'icon-list', 'open', '/company/list', '1', '0', '620815f4-095a-11e7-a94e-00163e04e6dc', '2017-03-15 16:54:59'), ('f8234480-be00-11e6-9e92-da84058bacbb', '删除', '部门删除', '1', '0', 'icon-del', 'open', '/organization/delete', '1', '1', 'ffde417cc7dc495f833387683b446704', '2017-03-15 17:00:22'), ('f96e0790bd3211e68c6c6aee6c504e95', '授权', '角色授权', '1', '3', 'icon-ok', 'open', '/role/grant', '1', '1', '5981ad9e9096491b92f6c7b8514f5d79', '2017-03-15 16:59:44'), ('ffde417cc7dc495f833387683b446704', '部门管理', '部门管理', '1', '4', 'menu_icon_datadeal', 'open', '/organization/manager', '0', '1', '0348992e6294490c9a648a5773fc38b8', '2017-03-15 17:00:06');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
