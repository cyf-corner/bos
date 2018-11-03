/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : bos

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 03/11/2018 12:55:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_function
-- ----------------------------
DROP TABLE IF EXISTS `auth_function`;
CREATE TABLE `auth_function`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `page` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `generatemenu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zindex` int(11) NULL DEFAULT NULL,
  `pid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `AK_Key_2`(`name`) USING BTREE,
  INDEX `FK33r6np87v1p6gge7t6rpcao5h`(`pid`) USING BTREE,
  CONSTRAINT `FK33r6np87v1p6gge7t6rpcao5h` FOREIGN KEY (`pid`) REFERENCES `auth_function` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`pid`) REFERENCES `auth_function` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of auth_function
-- ----------------------------
INSERT INTO `auth_function` VALUES ('11', '基础档案', 'jichudangan', NULL, NULL, '1', 0, NULL);
INSERT INTO `auth_function` VALUES ('112', '收派标准', 'standard', NULL, 'page_base_standard.action', '1', 1, '11');
INSERT INTO `auth_function` VALUES ('113', '取派员设置', 'staff', NULL, 'page_base_staff.action', '1', 2, '11');
INSERT INTO `auth_function` VALUES ('114', '区域设置', 'region', NULL, 'page_base_region.action', '1', 3, '11');
INSERT INTO `auth_function` VALUES ('115', '管理分区', 'subarea', NULL, 'page_base_subarea.action', '1', 4, '11');
INSERT INTO `auth_function` VALUES ('116', '管理定区/调度排班', 'decidedzone', NULL, 'page_base_decidedzone.action', '1', 5, '11');
INSERT INTO `auth_function` VALUES ('12', '受理', 'shouli', NULL, NULL, '1', 1, NULL);
INSERT INTO `auth_function` VALUES ('121', '业务受理', 'noticebill', NULL, 'page_qupai_noticebill_add.action', '1', 0, '12');
INSERT INTO `auth_function` VALUES ('122', '工作单快速录入', 'quickworkordermanage', NULL, 'page_qupai_quickworkorder.action', '1', 1, '12');
INSERT INTO `auth_function` VALUES ('124', '工作单导入', 'workordermanageimport', NULL, 'page_qupai_workorderimport.action', '1', 3, '12');
INSERT INTO `auth_function` VALUES ('13', '调度', 'diaodu', NULL, NULL, '1', 2, NULL);
INSERT INTO `auth_function` VALUES ('131', '查台转单', 'changestaff', NULL, NULL, '1', 0, '13');
INSERT INTO `auth_function` VALUES ('132', '人工调度', 'personalassign', NULL, 'page_qupai_diaodu.action', '1', 1, '13');
INSERT INTO `auth_function` VALUES ('14', '物流配送流程管理', 'zhongzhuan', NULL, NULL, '1', 3, NULL);
INSERT INTO `auth_function` VALUES ('141', '启动配送流程', 'start', NULL, 'workOrderManageAction_list.action', '1', 0, '14');
INSERT INTO `auth_function` VALUES ('142', '查看个人任务', 'personaltask', NULL, 'taskAction_findPersonalTask.action', '1', 1, '14');
INSERT INTO `auth_function` VALUES ('143', '查看我的组任务', 'grouptask', NULL, 'taskAction_findGroupTask.action', '1', 2, '14');
INSERT INTO `auth_function` VALUES ('8a7e843355a4392d0155a43aa7150000', '删除取派员', 'staff.delete', 'xxx', 'staffAction_delete.action', '0', 1, '113');

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `AK_Key_2`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES ('2c91b28266cf435e0166cf4a659c0001', '超级管理员', '超级管理员', '超级管理员');

-- ----------------------------
-- Table structure for bc_decidedzone
-- ----------------------------
DROP TABLE IF EXISTS `bc_decidedzone`;
CREATE TABLE `bc_decidedzone`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKh0xplk12o52a6eryw4hcqnfwt`(`staff_id`) USING BTREE,
  CONSTRAINT `FKh0xplk12o52a6eryw4hcqnfwt` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_decidedzone_staff` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bc_decidedzone
-- ----------------------------
INSERT INTO `bc_decidedzone` VALUES ('dq001', '北京石景山定区', '2c91b28266cf435e0166cf521f9d0003');
INSERT INTO `bc_decidedzone` VALUES ('dq002', '石家庄和太原市二合一定区', '2c91b28266cf435e0166cf5163c90002');

-- ----------------------------
-- Table structure for bc_region
-- ----------------------------
DROP TABLE IF EXISTS `bc_region`;
CREATE TABLE `bc_region`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `district` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `postcode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shortcode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `citycode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bc_region
-- ----------------------------
INSERT INTO `bc_region` VALUES ('QY001', '北京市', '北京市', '东城区', '110101', 'BJBJDC', 'beijing');
INSERT INTO `bc_region` VALUES ('QY002', '北京市', '北京市', '西城区', '110102', 'BJBJXC', 'beijing');
INSERT INTO `bc_region` VALUES ('QY003', '北京市', '北京市', '朝阳区', '110105', 'BJBJCY', 'beijing');
INSERT INTO `bc_region` VALUES ('QY004', '北京市', '北京市', '丰台区', '110106', 'BJBJFT', 'beijing');
INSERT INTO `bc_region` VALUES ('QY005', '北京市', '北京市', '石景山区', '110107', 'BJBJSJS', 'beijing');
INSERT INTO `bc_region` VALUES ('QY006', '北京市', '北京市', '海淀区', '110108', 'BJBJHD', 'beijing');
INSERT INTO `bc_region` VALUES ('QY007', '北京市', '北京市', '门头沟区', '110109', 'BJBJMTG', 'beijing');
INSERT INTO `bc_region` VALUES ('QY008', '北京市', '北京市', '房山区', '110111', 'BJBJFS', 'beijing');
INSERT INTO `bc_region` VALUES ('QY009', '北京市', '北京市', '通州区', '110112', 'BJBJTZ', 'beijing');
INSERT INTO `bc_region` VALUES ('QY010', '北京市', '北京市', '顺义区', '110113', 'BJBJSY', 'beijing');
INSERT INTO `bc_region` VALUES ('QY011', '北京市', '北京市', '昌平区', '110114', 'BJBJCP', 'beijing');
INSERT INTO `bc_region` VALUES ('QY012', '北京市', '北京市', '大兴区', '110115', 'BJBJDX', 'beijing');
INSERT INTO `bc_region` VALUES ('QY013', '北京市', '北京市', '怀柔区', '110116', 'BJBJHR', 'beijing');
INSERT INTO `bc_region` VALUES ('QY014', '北京市', '北京市', '平谷区', '110117', 'BJBJPG', 'beijing');
INSERT INTO `bc_region` VALUES ('QY015', '北京市', '北京市', '密云县', '110228', 'BJBJMY', 'beijing');
INSERT INTO `bc_region` VALUES ('QY016', '北京市', '北京市', '延庆县', '110229', 'BJBJYQ', 'beijing');
INSERT INTO `bc_region` VALUES ('QY017', '河北省', '石家庄市', '长安区', '130102', 'HBSJZZA', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY018', '河北省', '石家庄市', '桥东区', '130103', 'HBSJZQD', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY019', '河北省', '石家庄市', '桥西区', '130104', 'HBSJZQX', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY020', '河北省', '石家庄市', '新华区', '130105', 'HBSJZXH', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY021', '河北省', '石家庄市', '井陉矿区', '130107', 'HBSJZJXK', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY022', '河北省', '石家庄市', '裕华区', '130108', 'HBSJZYH', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY023', '河北省', '石家庄市', '井陉县', '130121', 'HBSJZJX', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY024', '河北省', '石家庄市', '正定县', '130123', 'HBSJZZD', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY025', '河北省', '石家庄市', '栾城县', '130124', 'HBSJZLC', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY026', '河北省', '石家庄市', '行唐县', '130125', 'HBSJZXT', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY027', '河北省', '石家庄市', '灵寿县', '130126', 'HBSJZLS', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY028', '河北省', '石家庄市', '高邑县', '130127', 'HBSJZGY', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY029', '河北省', '石家庄市', '深泽县', '130128', 'HBSJZSZ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY030', '河北省', '石家庄市', '赞皇县', '130129', 'HBSJZZH', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY031', '河北省', '石家庄市', '无极县', '130130', 'HBSJZWJ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY032', '河北省', '石家庄市', '平山县', '130131', 'HBSJZPS', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY033', '河北省', '石家庄市', '元氏县', '130132', 'HBSJZYS', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY034', '河北省', '石家庄市', '赵县', '130133', 'HBSJZZ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY035', '河北省', '石家庄市', '辛集市', '130181', 'HBSJZXJ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY036', '河北省', '石家庄市', '藁城市', '130182', 'HBSJZGC', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY037', '河北省', '石家庄市', '晋州市', '130183', 'HBSJZJZ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY038', '河北省', '石家庄市', '新乐市', '130184', 'HBSJZXL', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY039', '河北省', '石家庄市', '鹿泉市', '130185', 'HBSJZLQ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY040', '天津市', '天津市', '和平区', '120101', 'TJTJHP', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY041', '天津市', '天津市', '河东区', '120102', 'TJTJHD', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY042', '天津市', '天津市', '河西区', '120103', 'TJTJHX', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY043', '天津市', '天津市', '南开区', '120104', 'TJTJNK', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY044', '天津市', '天津市', '河北区', '120105', 'TJTJHB', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY045', '天津市', '天津市', '红桥区', '120106', 'TJTJHQ', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY046', '天津市', '天津市', '滨海新区', '120116', 'TJTJBHX', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY047', '天津市', '天津市', '东丽区', '120110', 'TJTJDL', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY048', '天津市', '天津市', '西青区', '120111', 'TJTJXQ', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY049', '天津市', '天津市', '津南区', '120112', 'TJTJJN', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY050', '天津市', '天津市', '北辰区', '120113', 'TJTJBC', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY051', '天津市', '天津市', '武清区', '120114', 'TJTJWQ', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY052', '天津市', '天津市', '宝坻区', '120115', 'TJTJBC', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY053', '天津市', '天津市', '宁河县', '120221', 'TJTJNH', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY054', '天津市', '天津市', '静海县', '120223', 'TJTJJH', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY055', '天津市', '天津市', '蓟县', '120225', 'TJTJJ', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY056', '山西省', '太原市', '小店区', '140105', 'SXTYXD', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY057', '山西省', '太原市', '迎泽区', '140106', 'SXTYYZ', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY058', '山西省', '太原市', '杏花岭区', '140107', 'SXTYXHL', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY059', '山西省', '太原市', '尖草坪区', '140108', 'SXTYJCP', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY060', '山西省', '太原市', '万柏林区', '140109', 'SXTYWBL', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY061', '山西省', '太原市', '晋源区', '140110', 'SXTYJY', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY062', '山西省', '太原市', '清徐县', '140121', 'SXTYQX', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY063', '山西省', '太原市', '阳曲县', '140122', 'SXTYYQ', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY064', '山西省', '太原市', '娄烦县', '140123', 'SXTYLF', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY065', '山西省', '太原市', '古交市', '140181', 'SXTYGJ', 'taiyuan');

-- ----------------------------
-- Table structure for bc_staff
-- ----------------------------
DROP TABLE IF EXISTS `bc_staff`;
CREATE TABLE `bc_staff`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `haspda` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deltag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `station` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `standard` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bc_staff
-- ----------------------------
INSERT INTO `bc_staff` VALUES ('2c91b28266cf435e0166cf5163c90002', '程怡飞', '17720839636', '1', '0', '饿了么公司', '外卖式配送');
INSERT INTO `bc_staff` VALUES ('2c91b28266cf435e0166cf521f9d0003', 'staffA', '13533333333', '1', '0', 'XX公司', '外卖式配送');
INSERT INTO `bc_staff` VALUES ('2c91b28266cf435e0166cf52592b0004', 'staffB', '13811111111', '0', '0', 'XX公司', '外卖式配送');
INSERT INTO `bc_staff` VALUES ('2c91b28266cf435e0166cf5282b40005', 'staffC', '17720839636', '0', '0', 'XX公司', '外卖式配送');
INSERT INTO `bc_staff` VALUES ('2c91b28266cf435e0166cf52b6c20006', 'staffD', '13811111111', '1', '0', 'XX公司', '外卖式配送');
INSERT INTO `bc_staff` VALUES ('2c91b28266cf435e0166cf52e9720007', 'staffE', '13811111111', '0', '0', 'XX公司', '外卖式配送');

-- ----------------------------
-- Table structure for bc_subarea
-- ----------------------------
DROP TABLE IF EXISTS `bc_subarea`;
CREATE TABLE `bc_subarea`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `decidedzone_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `region_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addresskey` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startnum` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endnum` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `single` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKlndbc8oldgbg3k1x63n3n6t7n`(`decidedzone_id`) USING BTREE,
  INDEX `FKcjwxm19mx5njn3xyqgqp431mb`(`region_id`) USING BTREE,
  CONSTRAINT `FKcjwxm19mx5njn3xyqgqp431mb` FOREIGN KEY (`region_id`) REFERENCES `bc_region` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKlndbc8oldgbg3k1x63n3n6t7n` FOREIGN KEY (`decidedzone_id`) REFERENCES `bc_decidedzone` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_area_decidedzone` FOREIGN KEY (`decidedzone_id`) REFERENCES `bc_decidedzone` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_area_region` FOREIGN KEY (`region_id`) REFERENCES `bc_region` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bc_subarea
-- ----------------------------
INSERT INTO `bc_subarea` VALUES ('fq001', 'dq001', 'QY005', '北京石景山区分区', '25', '30', '1', '北京市石景山区a社区2301');
INSERT INTO `bc_subarea` VALUES ('fq002', 'dq002', 'QY017', '石家庄市长安区分区', '0', '100', '2', '石家庄市长安区社区2120间');
INSERT INTO `bc_subarea` VALUES ('fq003', 'dq002', 'QY056', '太原市小店区分区', '0', '200', '0', '太原市小店区爱情公寓3602');

-- ----------------------------
-- Table structure for qp_noticebill
-- ----------------------------
DROP TABLE IF EXISTS `qp_noticebill`;
CREATE TABLE `qp_noticebill`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `staff_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `delegater` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pickaddress` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `arrivecity` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pickdate` date NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `weight` double NULL DEFAULT NULL,
  `volume` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ordertype` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKl5j3pm969oy1qdc1318jrmbgt`(`user_id`) USING BTREE,
  INDEX `FKhmbqr6qlg0uets978w5xshler`(`staff_id`) USING BTREE,
  CONSTRAINT `FKhmbqr6qlg0uets978w5xshler` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKl5j3pm969oy1qdc1318jrmbgt` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qp_noticebill
-- ----------------------------
INSERT INTO `qp_noticebill` VALUES ('2c91b28266cf435e0166cf5b6aca0009', '2c91b28266cf435e0166cf521f9d0003', '1', '张三', '张三', '13811111111', '北京市西城区长安街100号', '', '', NULL, NULL, NULL, '', '', '自动分单', '001');
INSERT INTO `qp_noticebill` VALUES ('2c91b28266cf435e0166cf5b9d19000b', '2c91b28266cf435e0166cf521f9d0003', '2', '李四', '李四', '13822222222', '上海市虹桥区南京路250号', '', '', NULL, NULL, NULL, '', '', '自动分单', '001');

-- ----------------------------
-- Table structure for qp_workbill
-- ----------------------------
DROP TABLE IF EXISTS `qp_workbill`;
CREATE TABLE `qp_workbill`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `noticebill_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pickstate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buildtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `attachbilltimes` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKggojlcovnpimuukxcueb18apt`(`noticebill_id`) USING BTREE,
  INDEX `FK55ckcnjyvwinnnniu5jpelg7y`(`staff_id`) USING BTREE,
  CONSTRAINT `FK55ckcnjyvwinnnniu5jpelg7y` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKggojlcovnpimuukxcueb18apt` FOREIGN KEY (`noticebill_id`) REFERENCES `qp_noticebill` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qp_workbill
-- ----------------------------
INSERT INTO `qp_workbill` VALUES ('2c91b28266cf435e0166cf5b6aca0008', '2c91b28266cf435e0166cf5b6aca0009', '新单', '未取件', '2018-11-01 20:59:26', 0, '', '2c91b28266cf435e0166cf521f9d0003');
INSERT INTO `qp_workbill` VALUES ('2c91b28266cf435e0166cf5b9d19000a', '2c91b28266cf435e0166cf5b9d19000b', '新单', '未取件', '2018-11-01 20:59:39', 0, '', '2c91b28266cf435e0166cf521f9d0003');

-- ----------------------------
-- Table structure for qp_workordermanage
-- ----------------------------
DROP TABLE IF EXISTS `qp_workordermanage`;
CREATE TABLE `qp_workordermanage`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `arrivecity` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `weight` double NULL DEFAULT NULL,
  `floadreqr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prodtimelimit` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prodtype` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sendername` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `senderphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `senderaddr` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receivername` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiverphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiveraddr` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `feeitemnum` int(11) NULL DEFAULT NULL,
  `actlweit` double NULL DEFAULT NULL,
  `vol` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `managerCheck` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updatetime` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role_function
-- ----------------------------
DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function`  (
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `function_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`role_id`, `function_id`) USING BTREE,
  INDEX `FK5f8riddotqjpm9vly0b8c5nmf`(`function_id`) USING BTREE,
  CONSTRAINT `FK10qo908yd9evkyb40vf88og85` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK5f8riddotqjpm9vly0b8c5nmf` FOREIGN KEY (`function_id`) REFERENCES `auth_function` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`function_id`) REFERENCES `auth_function` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_function
-- ----------------------------
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '11');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '112');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '113');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '114');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '115');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '116');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '12');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '121');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '122');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '124');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '13');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '131');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '132');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '14');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '141');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '142');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '143');
INSERT INTO `role_function` VALUES ('2c91b28266cf435e0166cf4a659c0001', '8a7e843355a4392d0155a43aa7150000');

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
INSERT INTO `t_customer` VALUES (1, '张三', '百度', '13811111111', '北京市西城区长安街100号', NULL);
INSERT INTO `t_customer` VALUES (2, '李四', '哇哈哈', '13822222222', '上海市虹桥区南京路250号', NULL);
INSERT INTO `t_customer` VALUES (3, '王五', '搜狗', '13533333333', '天津市河北区中山路30号', NULL);
INSERT INTO `t_customer` VALUES (4, '赵六', '联想', '18633333333', '石家庄市桥西区和平路10号', NULL);
INSERT INTO `t_customer` VALUES (5, '小白', '测试空间', '18511111111', '内蒙古自治区呼和浩特市和平路100号', NULL);
INSERT INTO `t_customer` VALUES (6, '小黑', '联想', '13722222222', '天津市南开区红旗路20号', NULL);
INSERT INTO `t_customer` VALUES (7, '小花', '百度', '13733333333', '北京市东城区王府井大街20号', NULL);
INSERT INTO `t_customer` VALUES (8, '小李', '长城', '13788888888', '北京市昌平区建材城西路100号', NULL);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salary` double NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `station` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('001', 'cyf', '96e79218965eb72c92a549dd5a330112', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `t_user` VALUES ('2c91b28266cf435e0166cf49a9420000', '小黑', '96e79218965eb72c92a549dd5a330112', NULL, NULL, '男', '', '13533333333', NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `FKqqlqhas35obkljn18mrh6mmms`(`role_id`) USING BTREE,
  CONSTRAINT `FKeqon9sx5vssprq67dxm3s7ump` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKqqlqhas35obkljn18mrh6mmms` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('001', '2c91b28266cf435e0166cf4a659c0001');

SET FOREIGN_KEY_CHECKS = 1;
