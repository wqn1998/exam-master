/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : ltt_test

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 24/02/2024 23:06:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for publish_content
-- ----------------------------
DROP TABLE IF EXISTS `publish_content`;
CREATE TABLE `publish_content`  (
  `id` bigint(20) NOT NULL,
  `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_flag` int(10) NULL DEFAULT NULL COMMENT '删除状态 0正常 -1删除',
  `title` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `classify` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类',
  `publish_date` datetime(0) NULL DEFAULT NULL COMMENT '上架时间',
  `publish_delay_date` datetime(0) NULL DEFAULT NULL COMMENT '延迟发布时间',
  `effective_date` datetime(0) NULL DEFAULT NULL COMMENT '有效时间',
  `share_flag` int(10) NULL DEFAULT NULL COMMENT '分享状态 0分享 -1 不分享',
  `content` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '正文内容',
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `content_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容编号',
  `publish_flag` int(10) NULL DEFAULT NULL COMMENT '上架状态 0上架 -1下架',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of publish_content
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
