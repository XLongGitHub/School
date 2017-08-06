/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : school

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-06 15:29:35
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_classroom
-- ----------------------------
INSERT INTO `s_classroom` VALUES ('1', 'A-3', null, '2017-08-05 21:28:18', null);
INSERT INTO `s_classroom` VALUES ('2', 'B-2b', null, '2017-08-05 21:28:25', '2017-08-06 10:49:00');
INSERT INTO `s_classroom` VALUES ('3', 'C-24', null, '2017-08-05 21:28:33', null);
INSERT INTO `s_classroom` VALUES ('4', 'D-9', null, '2017-08-05 21:28:41', null);
INSERT INTO `s_classroom` VALUES ('5', 'E-23', null, '2017-08-05 21:28:51', null);
INSERT INTO `s_classroom` VALUES ('6', 'F-28', null, '2017-08-06 10:48:39', null);

-- ----------------------------
-- Table structure for s_course
-- ----------------------------
DROP TABLE IF EXISTS `s_course`;
CREATE TABLE `s_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `classroom_id` int(11) DEFAULT NULL,
  `schooltime_id` int(11) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `write_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_course
-- ----------------------------
INSERT INTO `s_course` VALUES ('1', '语文', '3', '4', '2017-08-05 21:36:42', '2017-08-06 10:35:17');
INSERT INTO `s_course` VALUES ('2', '英语', '3', '4', '2017-08-06 10:38:54', null);
INSERT INTO `s_course` VALUES ('3', '物理', '3', '4', '2017-08-06 10:39:09', null);
INSERT INTO `s_course` VALUES ('4', '化学', '3', '4', '2017-08-06 10:39:16', null);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_schedule
-- ----------------------------

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
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
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
  `sex` tinyint(4)  DEFAULT 0 COMMENT '0 未知， 1男， 2女， 3保密',
  `address` varchar(60) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `grade` int(4) NOT NULL DEFAULT 0 COMMENT '管理员9， 学生1， 教师2',
  `phone` varchar(60) DEFAULT NULL,
  `avactor` varchar(60) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `write_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', '用户', null, null, '215656226399674922704324606688809822252050151671', '0', '13272408807', null, '2017-08-06 11:03:12', null);
INSERT INTO `s_user` VALUES ('2', '用户', null, null, '272874517023827102959669599430568608046907545193', '0', '13272408808', null, '2017-08-06 15:09:41', null);
