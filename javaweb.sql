/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : javaweb

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 22/04/2018 10:28:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `money` double(11, 0) DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '//转账表-----事务操作' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '张三', 9900);
INSERT INTO `account` VALUES (2, '李四', 10200);
INSERT INTO `account` VALUES (3, 'tom', 5000);
INSERT INTO `account` VALUES (4, 'jerry', 5100);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `sex` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `birthday` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '刘俊杰', '男', '1997-04-21', 'hotcosmos@126.com');

-- ----------------------------
-- Table structure for jdbc_user
-- ----------------------------
DROP TABLE IF EXISTS `jdbc_user`;
CREATE TABLE `jdbc_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jdbc_user
-- ----------------------------
INSERT INTO `jdbc_user` VALUES (1, 'zhangsan', '123456');
INSERT INTO `jdbc_user` VALUES (2, '张三', '123456');
INSERT INTO `jdbc_user` VALUES (3, 'lisi', '123456');
INSERT INTO `jdbc_user` VALUES (5, 'wangwu', '123456');
INSERT INTO `jdbc_user` VALUES (7, '??', '111111');

-- ----------------------------
-- Table structure for servlet_user
-- ----------------------------
DROP TABLE IF EXISTS `servlet_user`;
CREATE TABLE `servlet_user`  (
  `uid` char(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `sex` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of servlet_user
-- ----------------------------
INSERT INTO `servlet_user` VALUES ('d044076f-9f16-4e05-a229-5f32165084e6', 'zhangsan', '123456', '张三', 'zhangsan@123.com', 'male', '2018-04-09');

SET FOREIGN_KEY_CHECKS = 1;
