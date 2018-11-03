/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : crm4bos2cxf

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 03/11/2018 12:55:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `station` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `decidedzone_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES (1, '张三', '百度', '13811111111', '北京市西城区长安街100号', 'dq001');
INSERT INTO `t_customer` VALUES (2, '李四', '哇哈哈', '13822222222', '上海市虹桥区南京路250号', 'dq001');
INSERT INTO `t_customer` VALUES (3, '王五', '搜狗', '13533333333', '天津市河北区中山路30号', 'dq001');
INSERT INTO `t_customer` VALUES (4, '赵六', '联想', '18633333333', '石家庄市桥西区和平路10号', 'dq001');
INSERT INTO `t_customer` VALUES (5, '小白', '测试空间', '18511111111', '内蒙古自治区呼和浩特市和平路100号', NULL);
INSERT INTO `t_customer` VALUES (6, '小黑', '联想', '13722222222', '天津市南开区红旗路20号', 'dq002');
INSERT INTO `t_customer` VALUES (7, '小花', '百度', '13733333333', '北京市东城区王府井大街20号', NULL);
INSERT INTO `t_customer` VALUES (8, '小李', '长城', '13788888888', '北京市昌平区建材城西路100号', NULL);

SET FOREIGN_KEY_CHECKS = 1;
