DROP DATABASE IF EXISTS `school`;
CREATE  DATABASE `school`;
USE `school`;
# 用户
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user`(
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  #   `student_number` int(11) NOT NULL ,
  `name` VARCHAR(20) COMMENT '姓名' NOT NULL ,
  `sex` TINYINT,
  `address` VARCHAR(60),
  `password` VARCHAR(60) NOT NULL ,
  `grade` INT(4) COMMENT '管理员9， 学生1， 教师2' NOT NULL,
  `phone` VARCHAR(60),
  `avactor` VARCHAR(60),
  `create_time` VARCHAR(20),
  `write_time` VARCHAR(20)
);

#课表
DROP TABLE IF EXISTS `s_course`;
CREATE TABLE `s_course` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20),
  `classroom_id` INT(11),
  `schooltime_id` int(11),
  `create_time` VARCHAR(20),
  `write_time` VARCHAR(20)
);

#课程安排
DROP TABLE IF EXISTS `s_schedule`;
CREATE TABLE `s_schedule` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `user_id` int(11),
  `course_id` int(11),
  `create_time` VARCHAR(20),
  `write_time` VARCHAR(20)
);

# 教室
DROP TABLE IF EXISTS `s_classroom`;
CREATE TABLE `s_classroom` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20),
  `create_time` VARCHAR(20),
  `write_time` VARCHAR(20)
);

# 上课时间
DROP TABLE IF EXISTS `s_schooltime`;
CREATE TABLE `s_schooltime` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `time` VARCHAR(40),
  `create_time` VARCHAR(20),
  `write_time` VARCHAR(20)
);