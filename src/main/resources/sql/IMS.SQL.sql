/*
Navicat MySQL Data Transfer

Source Server         : 192.168.30.180
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : ims

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2016-08-25 11:33:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `application`
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '应用Id',
  `name` varchar(150) NOT NULL COMMENT '应用名称',
  `code` varchar(50) NOT NULL COMMENT '应用代码',
  `description` varchar(255) DEFAULT NULL COMMENT '应用描述',
  `basePath` varchar(100) NOT NULL COMMENT '应用服务路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用';

-- ----------------------------
-- Records of application
-- ----------------------------

-- ----------------------------
-- Table structure for `caze`
-- ----------------------------
DROP TABLE IF EXISTS `caze`;
CREATE TABLE `caze` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL COMMENT '组名称',
  `description` varchar(255) DEFAULT '',
  `expectation` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `urlId` int(11) NOT NULL,
  `params` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_GROUP_NAME` (`name`),
  KEY `fk_Caze_Url_1` (`urlId`),
  CONSTRAINT `fk_Caze_Url_1` FOREIGN KEY (`urlId`) REFERENCES `url` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用例';

-- ----------------------------
-- Records of caze
-- ----------------------------

-- ----------------------------
-- Table structure for `caze_function`
-- ----------------------------
DROP TABLE IF EXISTS `caze_function`;
CREATE TABLE `caze_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cazeId` int(11) NOT NULL,
  `functionId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_caze_function_caze_1` (`cazeId`),
  KEY `fk_caze_function_function_1` (`functionId`),
  CONSTRAINT `fk_caze_function_function_1` FOREIGN KEY (`functionId`) REFERENCES `function` (`id`),
  CONSTRAINT `fk_caze_function_caze_1` FOREIGN KEY (`cazeId`) REFERENCES `caze` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of caze_function
-- ----------------------------

-- ----------------------------
-- Table structure for `caze_param`
-- ----------------------------
DROP TABLE IF EXISTS `caze_param`;
CREATE TABLE `caze_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参数值',
  `cazeId` int(11) NOT NULL COMMENT '用例',
  `paramDefId` int(11) NOT NULL COMMENT '参数定义',
  `value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_CazeParam_Caze_1` (`cazeId`),
  KEY `fk_CazeParam_Param_Definetion_1` (`paramDefId`),
  CONSTRAINT `fk_CazeParam_Caze_1` FOREIGN KEY (`cazeId`) REFERENCES `caze` (`id`),
  CONSTRAINT `fk_CazeParam_Param_Definetion_1` FOREIGN KEY (`paramDefId`) REFERENCES `param_definetion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of caze_param
-- ----------------------------

-- ----------------------------
-- Table structure for `function`
-- ----------------------------
DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '名称',
  `content` text NOT NULL COMMENT 'js函数体',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='js函数';

-- ----------------------------
-- Records of function
-- ----------------------------

-- ----------------------------
-- Table structure for `group`
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL COMMENT '组名称',
  `description` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_GROUP_NAME` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能组';

-- ----------------------------
-- Records of group
-- ----------------------------

-- ----------------------------
-- Table structure for `group_url`
-- ----------------------------
DROP TABLE IF EXISTS `group_url`;
CREATE TABLE `group_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupId` int(11) NOT NULL,
  `urlId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_GroupUrl_Group_1` (`groupId`),
  KEY `fk_GroupUrl_Url_1` (`urlId`),
  CONSTRAINT `fk_GroupUrl_Group_1` FOREIGN KEY (`groupId`) REFERENCES `group` (`id`),
  CONSTRAINT `fk_GroupUrl_Url_1` FOREIGN KEY (`urlId`) REFERENCES `url` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能组';

-- ----------------------------
-- Records of group_url
-- ----------------------------

-- ----------------------------
-- Table structure for `param_definetion`
-- ----------------------------
DROP TABLE IF EXISTS `param_definetion`;
CREATE TABLE `param_definetion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL COMMENT '参数名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `type` varchar(50) DEFAULT NULL COMMENT '参数类型',
  `urlId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_PARAM_DEFINETION` (`name`),
  KEY `fk_Param_Definetion_Url_1` (`urlId`),
  CONSTRAINT `fk_Param_Definetion_Url_1` FOREIGN KEY (`urlId`) REFERENCES `url` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参数定义';

-- ----------------------------
-- Records of param_definetion
-- ----------------------------

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `params` text,
  `status` varchar(100) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `expectation` varchar(255) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `serverId` int(11) NOT NULL,
  `cazeName` varchar(150) DEFAULT NULL,
  `cazeId` int(11) NOT NULL,
  `groupName` varchar(150) DEFAULT NULL,
  `groupId` int(11) NOT NULL,
  `urlName` varchar(150) DEFAULT NULL,
  `urlId` int(11) NOT NULL,
  `applicationName` varchar(150) DEFAULT NULL,
  `applicationId` int(11) DEFAULT NULL,
  `result` text,
  PRIMARY KEY (`id`),
  KEY `fk_Result_Caze_1` (`cazeId`),
  CONSTRAINT `fk_Result_Caze_1` FOREIGN KEY (`cazeId`) REFERENCES `caze` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结果';

-- ----------------------------
-- Records of result
-- ----------------------------

-- ----------------------------
-- Table structure for `server`
-- ----------------------------
DROP TABLE IF EXISTS `server`;
CREATE TABLE `server` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(30) DEFAULT NULL,
  `port` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务器';

-- ----------------------------
-- Records of server
-- ----------------------------

-- ----------------------------
-- Table structure for `url`
-- ----------------------------
DROP TABLE IF EXISTS `url`;
CREATE TABLE `url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL COMMENT '组名称',
  `description` varchar(255) DEFAULT '',
  `path` varchar(150) NOT NULL,
  `method` varchar(20) NOT NULL COMMENT '请求方式.GET/PUT/POST',
  `contentType` varchar(100) DEFAULT NULL,
  `applicationId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_GROUP_NAME` (`name`),
  KEY `fk_Url_Application_1` (`applicationId`),
  CONSTRAINT `fk_Url_Application_1` FOREIGN KEY (`applicationId`) REFERENCES `application` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能';

-- ----------------------------
-- Records of url
-- ----------------------------
