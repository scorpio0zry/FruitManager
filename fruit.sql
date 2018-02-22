/*
Navicat MySQL Data Transfer

Source Server         : scoprio0zry
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : fruit

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-02-23 06:21:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buyfruit
-- ----------------------------
DROP TABLE IF EXISTS `buyfruit`;
CREATE TABLE `buyfruit` (
`bid`  int(11) NOT NULL AUTO_INCREMENT ,
`brand`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`num`  int(11) NULL DEFAULT NULL ,
`id`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`bid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=16

;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`money`  double NULL DEFAULT NULL ,
`time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=6

;

-- ----------------------------
-- Table structure for fruit
-- ----------------------------
DROP TABLE IF EXISTS `fruit`;
CREATE TABLE `fruit` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`brand`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`price`  double NOT NULL ,
`stock`  int(11) NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=8

;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`username`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Auto increment value for buyfruit
-- ----------------------------
ALTER TABLE `buyfruit` AUTO_INCREMENT=16;

-- ----------------------------
-- Auto increment value for customer
-- ----------------------------
ALTER TABLE `customer` AUTO_INCREMENT=6;

-- ----------------------------
-- Auto increment value for fruit
-- ----------------------------
ALTER TABLE `fruit` AUTO_INCREMENT=8;

-- ----------------------------
-- Auto increment value for manager
-- ----------------------------
ALTER TABLE `manager` AUTO_INCREMENT=4;
