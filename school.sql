/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : school

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-07 21:16:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_classroom
-- ----------------------------
DROP TABLE IF EXISTS `s_classroom`;
CREATE TABLE `s_classroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `empty` tinyint(4) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `write_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_classroom
-- ----------------------------
INSERT INTO `s_classroom` VALUES ('1', 'A-3', '1', '2017-08-05 21:28:18', null);
INSERT INTO `s_classroom` VALUES ('2', 'B-2b', '1', '2017-08-05 21:28:25', '2017-08-06 10:49:00');
INSERT INTO `s_classroom` VALUES ('3', 'C-24', '11', '2017-08-05 21:28:33', null);
INSERT INTO `s_classroom` VALUES ('5', 'E-24', '1', '2017-08-05 21:28:51', '2017-08-07 21:02:02');
INSERT INTO `s_classroom` VALUES ('6', 'F-28', '1', '2017-08-06 10:48:39', null);
INSERT INTO `s_classroom` VALUES ('7', 'E-22', '1', '2017-08-05 21:28:51', '2017-08-07 21:00:45');

-- ----------------------------
-- Table structure for s_course
-- ----------------------------
DROP TABLE IF EXISTS `s_course`;
CREATE TABLE `s_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `classroom_id` int(11) DEFAULT NULL,
  `schooltime_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `write_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_course
-- ----------------------------
INSERT INTO `s_course` VALUES ('5', '地理', '3', '2', '2', '2017-08-06 17:11:55', '2017-08-06 17:19:16');
INSERT INTO `s_course` VALUES ('7', '语文', '1', '1', '2', '2017-08-06 17:23:15', null);
INSERT INTO `s_course` VALUES ('8', '外语', '1', '1', '2', '2017-08-06 19:22:22', null);
INSERT INTO `s_course` VALUES ('9', '数学', '4', '4', '2', '2017-08-06 19:22:37', null);
INSERT INTO `s_course` VALUES ('10', '生物', '4', '4', '2', '2017-08-06 19:22:50', null);
INSERT INTO `s_course` VALUES ('11', '哲学', '5', '4', '2', '2017-08-07 21:10:33', null);

-- ----------------------------
-- Table structure for s_schedule
-- ----------------------------
DROP TABLE IF EXISTS `s_schedule`;
CREATE TABLE `s_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `write_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_schedule
-- ----------------------------
INSERT INTO `s_schedule` VALUES ('5', '5', '9', '2017-08-06 19:23:21', null);

-- ----------------------------
-- Table structure for s_schooltime
-- ----------------------------
DROP TABLE IF EXISTS `s_schooltime`;
CREATE TABLE `s_schooltime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` tinyint(4) DEFAULT NULL COMMENT '星期',
  `time` tinyint(4) DEFAULT NULL COMMENT '上课时间',
  `week_start` tinyint(4) DEFAULT NULL COMMENT '上课开始周',
  `week_end` tinyint(4) DEFAULT NULL COMMENT '上课结束周',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` varchar(20) DEFAULT NULL,
  `write_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_schooltime
-- ----------------------------
INSERT INTO `s_schooltime` VALUES ('1', '1', '1', '1', '8', '1 -- 8 星期一 8:00 - 9:40', '2017-08-05 18:51:42', null);
INSERT INTO `s_schooltime` VALUES ('2', '1', '2', '1', '8', '1 -- 8 星期一 10:00 - 11:40', '2017-08-05 18:51:50', null);
INSERT INTO `s_schooltime` VALUES ('3', '2', '2', '1', '8', '1 -- 8 星期二 10:00 - 11:40', '2017-08-05 18:51:58', null);
INSERT INTO `s_schooltime` VALUES ('4', '3', '4', '1', '8', '1 -- 8 星期三 16:00 - 17:40', '2017-08-05 18:52:07', '2017-08-05 20:30:54');
INSERT INTO `s_schooltime` VALUES ('5', '1', '4', '2', '3', '1 -- 8 星期一 8:00 - 9:40 ', '2017-08-05 20:17:03', '2017-08-05 20:25:54');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '新用户' COMMENT '姓名',
  `sex` tinyint(4) DEFAULT '0' COMMENT '0 未知， 1男， 2女， 3保密',
  `address` varchar(60) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `grade` int(4) NOT NULL DEFAULT '0' COMMENT '管理员9， 学生1， 教师2',
  `phone` varchar(60) DEFAULT NULL,
  `avactor` varchar(60) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `write_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'xu', '1', 'csu', '215656226399674922704324606688809822252050151671', '9', '13272408807', null, '2017-08-06 11:03:12', '2017-08-06 16:28:00');
INSERT INTO `s_user` VALUES ('2', 'wq', '2', 'ww', '272874517023827102959669599430568608046907545193', '2', '13272408808', null, '2017-08-06 15:09:41', null);
INSERT INTO `s_user` VALUES ('5', 'aaa', '0', 'dsda', '272874517023827102959669599430568608046907545193', '1', 'admin', 'bbb', '2017-08-06 18:50:31', '2017-08-07 17:51:14');
INSERT INTO `s_user` VALUES ('7', 'haha', '2', 'zzz', '272874517023827102959669599430568608046907545193', '1', '123456', 'fd', null, '2017-08-07 19:54:42');
INSERT INTO `s_user` VALUES ('11', '新用户', '0', 'dsda', '272874517023827102959669599430568608046907545193', '0', '1234567', 'qwq', null, '2017-08-07 20:10:05');
INSERT INTO `s_user` VALUES ('12', '新用户', '0', null, '272874517023827102959669599430568608046907545193', '0', '1234567', null, null, '2017-08-07 17:37:53');
