/*
MySQL Data Transfer
Source Host: localhost
Source Database: car
Target Host: localhost
Target Database: car
Date: 2016/10/17 18:50:37
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for car
-- ----------------------------
CREATE TABLE `car` (
  `carid` int(100) NOT NULL auto_increment,
  `carname` varchar(30) default NULL,
  `type` varchar(30) default NULL,
  `price` double default NULL,
  `intro` text,
  `carcount` int(20) default NULL,
  PRIMARY KEY  (`carid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for caranduser
-- ----------------------------
CREATE TABLE `caranduser` (
  `userid` int(100) NOT NULL auto_increment,
  `username` varchar(30) default NULL,
  `carid` int(100) NOT NULL default '0',
  `carname` varchar(30) default NULL,
  PRIMARY KEY  (`userid`,`carid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fixcar
-- ----------------------------
CREATE TABLE `fixcar` (
  `carid` int(100) NOT NULL auto_increment,
  `username` varchar(30) default NULL,
  `carname` varchar(30) default NULL,
  `type` varchar(30) default NULL,
  `fixreason` text,
  `indate` date default NULL,
  PRIMARY KEY  (`carid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
CREATE TABLE `manager` (
  `managerid` int(11) NOT NULL auto_increment,
  `name` varchar(10) NOT NULL,
  `password` varchar(11) NOT NULL,
  PRIMARY KEY  (`managerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for news
-- ----------------------------
CREATE TABLE `news` (
  `ID` int(11) NOT NULL auto_increment,
  `TITLE` varchar(255) default NULL,
  `AUTHOR` varchar(255) default NULL,
  `DATE` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ordercar
-- ----------------------------
CREATE TABLE `ordercar` (
  `id` int(11) NOT NULL auto_increment,
  `carname` varchar(30) default NULL,
  `type` varchar(30) default NULL,
  `username` varchar(30) default NULL,
  `price` double(30,0) default NULL,
  `indate` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
CREATE TABLE `student` (
  `id` int(10) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `date` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `userid` int(100) NOT NULL auto_increment,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `pnumber` varchar(20) default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `car` VALUES ('1', 'BMW', 'M3', '2000', 'sfasfsfsfsfs', '3');
INSERT INTO `car` VALUES ('2', '1', 'X5', '20000', '这是宝马X5案例', '3');
INSERT INTO `car` VALUES ('3', '宝马', 'X1', '30000', '爱是飞洒法师法萨芬撒测试宝马X1', '59');
INSERT INTO `car` VALUES ('4', '大众', '高尔夫', '30000', '这是大众高尔夫的测试', '101');
INSERT INTO `car` VALUES ('5', '大众', '速腾', '2333', '', '2');
INSERT INTO `car` VALUES ('6', '奔驰', 'GLA', '300001', '奔驰GLA', '15');
INSERT INTO `car` VALUES ('7', '宝马', 'X6', '200000', '这是宝马X6', '100');
INSERT INTO `car` VALUES ('8', '宝马', 'M2', '100000', 'zheshi me', '10');
INSERT INTO `car` VALUES ('9', '宝马', 'M1', '200000', 'afsfsafasfass', '110');
INSERT INTO `fixcar` VALUES ('1', null, '宝马', 'M3', '爆炸', '2016-05-25');
INSERT INTO `fixcar` VALUES ('2', null, '奔驰', '600', '爆炸', '2016-01-30');
INSERT INTO `fixcar` VALUES ('3', null, 'asdsaf', 'asdfasf', 'sadfsafs', '2016-05-29');
INSERT INTO `fixcar` VALUES ('4', null, '宝马', 'M2', '车胎爆炸\r\n', '2016-06-10');
INSERT INTO `fixcar` VALUES ('5', 'qwer', '宝马', 'i3', 'afasd', '2016-06-10');
INSERT INTO `fixcar` VALUES ('6', 'qwer', '凯迪拉克', 'ATS-L', 'adfafsfsafsaf', '2016-06-10');
INSERT INTO `fixcar` VALUES ('7', 'qwer', '奔驰', 'GLC', 'afsasfsafsfsfs', '2016-06-11');
INSERT INTO `manager` VALUES ('1', 'liyang', 'liyangadmin');
INSERT INTO `manager` VALUES ('2', 'admin', 'admin');
INSERT INTO `news` VALUES ('1', 'Java', 'G2C', '2016-09-18 14:51:40');
INSERT INTO `ordercar` VALUES ('1', '宝马', 'X1', 'qwer', '30000', '2016-06-11');
INSERT INTO `ordercar` VALUES ('2', '奔驰', 'GLA', 'qwer', '300001', '2016-06-11');
INSERT INTO `ordercar` VALUES ('3', '宝马', 'M1', 'liyang', '200000', '2016-06-11');
INSERT INTO `student` VALUES ('2', 'roxlee', '123', '2016-10-01');
INSERT INTO `student` VALUES ('3', 'jack', '123', '2016-10-01');
INSERT INTO `student` VALUES ('4', 'gaming', '123', '2016-09-30');
INSERT INTO `student` VALUES ('5', 'aaaa', '123', null);
INSERT INTO `student` VALUES ('6', 'root', 'root', null);
INSERT INTO `user` VALUES ('29', 'admin', 'asd', '1', '12345678912');
INSERT INTO `user` VALUES ('30', 'liyang', 'asd', '男', '13888888888');
INSERT INTO `user` VALUES ('31', 'qwer', 'qwer', '男', '13903959653');
