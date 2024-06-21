/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : car_battery_warn

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 18/06/2024 12:34:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `vid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '16位随机字符串车辆识别码，每辆车唯一',
  `car_id` int(11) NOT NULL COMMENT '车架编号',
  `battery_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电池类型（三元电池/铁锂电池）',
  `total_mileage` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '总里程(km)',
  `health_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '健康状态',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES (1, 'H7tVwXcYqK3sGp6u', 1, '三元电池', '100', '100', '2024-06-15 13:48:38', 'admin', '2024-06-15 13:48:38', 'admin');
INSERT INTO `car` VALUES (2, 'rT2q3gYf5z9mNkJh', 2, '铁锂电池', '600', '95', '2024-06-15 13:48:38', 'admin', '2024-06-15 13:48:38', 'admin');
INSERT INTO `car` VALUES (3, 'ZcVuG9kJb6yH5tD3', 3, '三元电池', '300', '98', '2024-06-15 13:48:38', 'admin', '2024-06-15 13:48:38', 'admin');

-- ----------------------------
-- Table structure for rules
-- ----------------------------
DROP TABLE IF EXISTS `rules`;
CREATE TABLE `rules`  (
  `id` int(11) NOT NULL COMMENT 'id',
  `rule_id` int(11) NULL DEFAULT NULL COMMENT '规则编号',
  `rule_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '规则名称',
  `battery_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电池类型（三元电池/铁锂电池）',
  `warn_rule` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '预警规则',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rules
-- ----------------------------
INSERT INTO `rules` VALUES (1, 1, '电压差报警', '三元电池', '5<=(Ｍx－Mi),报警等级：0\r\n3<=(Ｍx－Mi)<5,报警等级：1\r\n1<=(Ｍx－Mi)<3,报警等级：2\r\n0.6<=(Ｍx－Mi)<1,报警等级：3\r\n0.2<=(Ｍx－Mi)<0.6,报警等级：4\r\n(Ｍx－Mi)<0.2，不报警5<=(Ｍx－Mi),报警等级：0\r\n3<=(Ｍx－Mi)<5,报警等级：1\r\n1<=(Ｍx－Mi)<3,报警等级：2\r\n0.6<=(Ｍx－Mi)<1,报警等级：3\r\n0.2<=(Ｍx－Mi)<0.6,报警等级：4\r\n(Ｍx－Mi)<0.2，不报警\r\n', '2024-06-15 13:48:38', 'admin', '2024-06-15 13:48:38', 'admin');
INSERT INTO `rules` VALUES (2, 1, '电压差报警', '铁锂电池', '2<=(Ｍx－Mi),报警等级：0\r\n1<=(Ｍx－Mi)<2,报警等级：1\r\n0.7<=(Ｍx－Mi)<1,报警等级：2\r\n0.4<=(Ｍx－Mi)<0.7,报警等级：3\r\n0.2<=(Ｍx－Mi)<0.4,报警等级：4\r\n(Ｍx－Mi)<0.2，不报警\r\n', '2024-06-15 13:48:38', 'admin', '2024-06-15 13:48:38', 'admin');
INSERT INTO `rules` VALUES (3, 2, '电流差报警', '三元电池', '3<=(Ix－Ii),报警等级：0\r\n1<=(Ix－Ii)<3,报警等级：1\r\n0.2<=(Ix－Ii)<1,报警等级：2\r\n(Ix－Ii)<0.2，不报警\r\n3<=(Ix－Ii),报警等级：0\r\n1<=(Ix－Ii)<3,报警等级：1\r\n0.2<=(Ix－Ii)<1,报警等级：2\r\n(Ix－Ii)<0.2，不报警\r\n', '2024-06-15 13:48:38', 'admin', '2024-06-15 13:48:38', 'admin');
INSERT INTO `rules` VALUES (4, 2, '电流差报警', '铁锂电池', '1<=(Ix－Ii),报警等级：0\r\n0.5<=(Ix－Ii)<1,报警等级：1\r\n0.2<=(Ix－Ii)<0.5,报警等级：2\r\n(Ix－Ii)<0.2，不报警\r\n', '2024-06-15 13:48:38', 'admin', '2024-06-15 13:48:38', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
