/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2017-08-05 17:15:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` int(10) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(40) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '人力资源部');
INSERT INTO `dept` VALUES ('2', '市场开发部');
INSERT INTO `dept` VALUES ('3', '运营管理部');
INSERT INTO `dept` VALUES ('4', '财务部');
INSERT INTO `dept` VALUES ('5', '投资发展部');
INSERT INTO `dept` VALUES ('6', '市场营销部');
INSERT INTO `dept` VALUES ('7', '客服部');

-- ----------------------------
-- Table structure for encrypted
-- ----------------------------
DROP TABLE IF EXISTS `encrypted`;
CREATE TABLE `encrypted` (
  `encr_id` int(10) NOT NULL AUTO_INCREMENT,
  `encr_name` varchar(40) NOT NULL,
  PRIMARY KEY (`encr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of encrypted
-- ----------------------------
INSERT INTO `encrypted` VALUES ('1', '您的电话号码是？');
INSERT INTO `encrypted` VALUES ('2', '您母亲的姓名是？');
INSERT INTO `encrypted` VALUES ('3', '您父亲的姓名是？');
INSERT INTO `encrypted` VALUES ('4', '您配偶的姓名是？');
INSERT INTO `encrypted` VALUES ('5', '您的出生地是？');
INSERT INTO `encrypted` VALUES ('6', '您父亲的生日是？');
INSERT INTO `encrypted` VALUES ('7', '您母亲的生日是？');
INSERT INTO `encrypted` VALUES ('8', '您配偶的生日是？');
INSERT INTO `encrypted` VALUES ('9', '您的生日是？');

-- ----------------------------
-- Table structure for inboxanddustbin
-- ----------------------------
DROP TABLE IF EXISTS `inboxanddustbin`;
CREATE TABLE `inboxanddustbin` (
  `inbdus_id` int(10) NOT NULL AUTO_INCREMENT,
  `inbdus_user_mail` varchar(30) NOT NULL,
  `inbdus_addresser` varchar(30) NOT NULL,
  `inbdus_date` varchar(30) NOT NULL,
  `inbdus_subject` varchar(40) NOT NULL,
  `inbdus_recipients` varchar(100) DEFAULT NULL,
  `inbdus_peopleWhoCopied` varchar(100) DEFAULT NULL,
  `inbdus_blindCarbon` varchar(100) DEFAULT NULL,
  `inbdus_content` varchar(5000) NOT NULL,
  `inbdus_accessory` varchar(100) DEFAULT NULL,
  `inbdus_dept_id` int(10) DEFAULT NULL,
  `inbdus_type` varchar(10) NOT NULL,
  `user_Fid` int(10) NOT NULL,
  `inbdus_isnewtype` varchar(2) NOT NULL,
  PRIMARY KEY (`inbdus_id`),
  KEY `FK_user_idi` (`user_Fid`),
  CONSTRAINT `FK_user_idi` FOREIGN KEY (`user_Fid`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of inboxanddustbin
-- ----------------------------
INSERT INTO `inboxanddustbin` VALUES ('1', '894276548@qq.com', '向阳光', '2016-10-23', '放假通知', 'xiangjunzhong@qq.com', '1245421245@qq.com', '', '放假时间：2016-05-10到2016-05-13', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', '2', '收', '1', '新');
INSERT INTO `inboxanddustbin` VALUES ('2', '894276548@qq.com', '向阳光', '2016-10-23', '放假通知', 'xiangjunzhong@qq.com', '1245421245@qq.com', '', '放假时间：2016-05-10到2016-05-13', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', '2', '垃', '1', '旧');
INSERT INTO `inboxanddustbin` VALUES ('3', 'xiangjunzhong@qq.com', 'File a vacancy', '2016-10-23', '放假通知', '894276548@qq.com', '1245421245@qq.com', '', '放假时间：2016-05-10到2016-05-13', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', null, '收', '2', '新');
INSERT INTO `inboxanddustbin` VALUES ('4', 'xiangjunzhong@qq.com', 'File a vacancy', '2016-10-23', '放假通知', '894276548@qq.com', '1245421245@qq.com', '', '放假时间：2016-05-10到2016-05-13', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', null, '垃', '2', '旧');
INSERT INTO `inboxanddustbin` VALUES ('5', '1245421245@qq.com', '497', '2016-10-23', '放假通知', '894276548@qq.com', 'xiangjunzhong@qq.com', '', '放假时间：2016-05-10到2016-05-13', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', '2', '收', '3', '新');
INSERT INTO `inboxanddustbin` VALUES ('6', '1245421245@qq.com', '497', '2016-10-23', '放假通知', '894276548@qq.com', 'xiangjunzhong@qq.com', '', '放假时间：2016-05-10到2016-05-13', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', '2', '垃', '3', '旧');

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `label_id` int(10) NOT NULL AUTO_INCREMENT,
  `label_type` varchar(10) NOT NULL DEFAULT 'false',
  `label_content` varchar(1000) DEFAULT NULL,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`label_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('1', 'false', '你好!', '1');
INSERT INTO `label` VALUES ('2', 'false', '他好!', '2');
INSERT INTO `label` VALUES ('3', 'false', '她好!', '3');

-- ----------------------------
-- Table structure for outboxanddrafts
-- ----------------------------
DROP TABLE IF EXISTS `outboxanddrafts`;
CREATE TABLE `outboxanddrafts` (
  `outdra_id` int(10) NOT NULL AUTO_INCREMENT,
  `outdra_user_mail` varchar(30) NOT NULL,
  `outdra_recipients` varchar(100) DEFAULT NULL,
  `outdra_peopleWhoCopied` varchar(100) DEFAULT NULL,
  `outdra_blindCarbon` varchar(100) DEFAULT NULL,
  `outdra_subject` varchar(40) DEFAULT NULL,
  `outdra_accessory` varchar(100) DEFAULT NULL,
  `outdra_content` varchar(5000) DEFAULT NULL,
  `outdra_date` varchar(20) NOT NULL,
  `outdra_type` varchar(10) NOT NULL,
  `user_Fid` int(10) NOT NULL,
  PRIMARY KEY (`outdra_id`),
  KEY `FK_user_id` (`user_Fid`),
  CONSTRAINT `FK_user_id` FOREIGN KEY (`user_Fid`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of outboxanddrafts
-- ----------------------------
INSERT INTO `outboxanddrafts` VALUES ('1', '894276548@qq.com', 'xiangjunzhong@qq.com', '1245421245@qq.com', null, '放假通知', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', '放假时间：2016-10-01到2016-10-07', '2016-09-31', '发', '1');
INSERT INTO `outboxanddrafts` VALUES ('2', '894276548@qq.com', 'xiangjunzhong@qq.com', '1245421245@qq.com', null, '放假通知', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', '放假时间：2016-10-01-07', '2016-09-31', '草', '1');
INSERT INTO `outboxanddrafts` VALUES ('3', 'xiangjunzhong@qq.com', '894276548@qq.com', '1245421245@qq.com', null, '放假通知', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', '放假时间：2016-10-01-07', '2016-09-31', '发', '2');
INSERT INTO `outboxanddrafts` VALUES ('4', 'xiangjunzhong@qq.com', '894276548@qq.com', '1245421245@qq.com', null, '放假通知', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', '放假时间：2016-10-01-07', '2016-09-31', '草', '2');
INSERT INTO `outboxanddrafts` VALUES ('5', '1245421245@qq.com', '894276548@qq.com', 'xiangjunzhong@qq.com', null, '放假通知', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', '放假时间：2016-10-01-07', '2016-09-31', '发', '3');
INSERT INTO `outboxanddrafts` VALUES ('6', '1245421245@qq.com', '894276548@qq.com', 'xiangjunzhong@qq.com', null, '放假通知', 'D:老张\\OA开发文档\\THOA办公自动化系统.doc', '放假时间：2016-10-01-07', '2016-09-31', '草', '3');
INSERT INTO `outboxanddrafts` VALUES ('7', 'xiangjunzhong@qq.com', '向阳光', '497', '向阳光,497', '放假通知', 'C:\\fakepath\\devcon.exe', '的jfk时间空手道解放', '2016-11-01', '草', '2');

-- ----------------------------
-- Table structure for personalbook
-- ----------------------------
DROP TABLE IF EXISTS `personalbook`;
CREATE TABLE `personalbook` (
  `perbook_id` int(10) NOT NULL AUTO_INCREMENT,
  `friend_id` int(10) NOT NULL,
  `perbook_usename` varchar(20) NOT NULL,
  `perbook_phone` varchar(11) DEFAULT NULL,
  `perbook_mail` varchar(30) NOT NULL,
  `perbook_date` varchar(20) NOT NULL,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`perbook_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of personalbook
-- ----------------------------
INSERT INTO `personalbook` VALUES ('1', '2', 'File a vacancy', '18228096986', 'xiangjunzhong@qq.com', '2016-10-23', '1');
INSERT INTO `personalbook` VALUES ('3', '1', '向阳光', '15245263523', '894276548@qq.com', '2016-10-23', '2');
INSERT INTO `personalbook` VALUES ('5', '1', '向阳光', '15245263523', '894276548@qq.com', '2016-10-23', '3');
INSERT INTO `personalbook` VALUES ('10', '2', 'File a vacancy', '18228096986', 'xiangjunzhong@qq.com', '2016-10-30', '3');
INSERT INTO `personalbook` VALUES ('13', '3', '497', '13525462535', '1245421245@qq.com', '2016-10-31', '2');
INSERT INTO `personalbook` VALUES ('15', '3', '497', '13525462535', '1245421245@qq.com', '2016-11-17', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `user_pwd` varchar(40) CHARACTER SET utf8 NOT NULL,
  `user_real_name` varchar(40) NOT NULL,
  `user_sex` char(2) DEFAULT NULL,
  `user_age` int(3) DEFAULT NULL,
  `user_identity` varchar(18) CHARACTER SET utf8 NOT NULL,
  `user_phone` varchar(11) CHARACTER SET utf8 NOT NULL,
  `utype_Fid` int(10) NOT NULL,
  `dept_Fid` int(10) DEFAULT NULL,
  `encr_Fid` int(10) NOT NULL,
  `user_content` varchar(40) NOT NULL,
  `user_birthday` varchar(20) DEFAULT NULL,
  `user_state` varchar(20) DEFAULT NULL,
  `user_homeaddress` varchar(40) DEFAULT NULL,
  `user_companyaddress` varchar(40) DEFAULT NULL,
  `user_mail` varchar(30) NOT NULL,
  `user_lock` varchar(10) DEFAULT '否',
  PRIMARY KEY (`user_id`),
  KEY `FK_utype_id` (`utype_Fid`),
  KEY `FK_dept_id` (`dept_Fid`),
  KEY `FK_encr_id` (`encr_Fid`),
  CONSTRAINT `FK_dept_id` FOREIGN KEY (`dept_Fid`) REFERENCES `dept` (`dept_id`),
  CONSTRAINT `FK_encr_id` FOREIGN KEY (`encr_Fid`) REFERENCES `encrypted` (`encr_id`),
  CONSTRAINT `FK_utype_id` FOREIGN KEY (`utype_Fid`) REFERENCES `user_type` (`utype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '向阳光', '11873ed99feaacc340a185e29badc53c', '向阳', '男', '28', '544124512452141235', '15245263523', '2', '2', '1', '15245263523', '1992-10-12', '中国', null, null, '894276548@qq.com', '否');
INSERT INTO `user` VALUES ('2', 'File a vacancy', '56575964c4a52c99b4ed5605532ad3ef', '向俊忠', '男', '18', '51102519981129281X', '18228096986', '3', null, '1', '18228096986', '1998-11-29', '中国', null, null, 'xiangjunzhong@qq.com', '否');
INSERT INTO `user` VALUES ('3', '497', '28ab31c208e80dfa007b79987bdd4841', '吴玉玲', '女', '18', '511425162512488521', '13525462535', '1', '2', '1', '13525462535', '1998-11-25', '中国', null, null, '1245421245@qq.com', '否');

-- ----------------------------
-- Table structure for user_type
-- ----------------------------
DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type` (
  `utype_id` int(10) NOT NULL AUTO_INCREMENT,
  `utype_name` varchar(40) NOT NULL,
  PRIMARY KEY (`utype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user_type
-- ----------------------------
INSERT INTO `user_type` VALUES ('1', '员工');
INSERT INTO `user_type` VALUES ('2', '经理');
INSERT INTO `user_type` VALUES ('3', '总经理');
