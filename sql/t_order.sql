/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50643
Source Host           : localhost:3306
Source Database       : tx-lcn

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-12-27 14:55:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(128) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('5', '9d33cc6a-e214-40a3-b397-29387c175819:1001', '1', '2019-12-27 14:34:30');
INSERT INTO `t_order` VALUES ('6', '95fa42f1-9426-4066-aae9-2743a4a0f403:1001', '1', '2019-12-27 14:36:20');
INSERT INTO `t_order` VALUES ('7', 'fd7041e9-f2dd-4a99-8380-3168d628a7a5:1001', '1', '2019-12-27 14:51:12');
