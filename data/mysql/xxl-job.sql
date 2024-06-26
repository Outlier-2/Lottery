/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50639
 Source Host           : localhost:3306
 Source Schema         : xxl_job

 Target Server Type    : MySQL
 Target Server Version : 50639
 File Encoding         : 65001

 Date: 04/12/2021 16:28:12
*/

create database xxl_job;

USE xxl_job;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xxl_job_group
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_group`;
CREATE TABLE `xxl_job_group` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `app_name` varchar(64) NOT NULL COMMENT '执行器AppName',
                                 `title` varchar(12) NOT NULL COMMENT '执行器名称',
                                 `address_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '执行器地址类型：0=自动注册、1=手动录入',
                                 `address_list` text COMMENT '执行器地址列表，多地址逗号分隔',
                                 `update_time` datetime DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_group
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_group` VALUES (1, 'xxl-job-executor-sample', '示例执行器', 0, NULL, '2021-11-20 20:28:29');
INSERT INTO `xxl_job_group` VALUES (2, 'lottery-job', '抽奖系统任务调度', 0, NULL, '2021-11-20 20:28:29');
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_info
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_info`;
CREATE TABLE `xxl_job_info` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `job_group` int(11) NOT NULL COMMENT '执行器主键ID',
                                `job_desc` varchar(255) NOT NULL,
                                `add_time` datetime DEFAULT NULL,
                                `update_time` datetime DEFAULT NULL,
                                `author` varchar(64) DEFAULT NULL COMMENT '作者',
                                `alarm_email` varchar(255) DEFAULT NULL COMMENT '报警邮件',
                                `schedule_type` varchar(50) NOT NULL DEFAULT 'NONE' COMMENT '调度类型',
                                `schedule_conf` varchar(128) DEFAULT NULL COMMENT '调度配置，值含义取决于调度类型',
                                `misfire_strategy` varchar(50) NOT NULL DEFAULT 'DO_NOTHING' COMMENT '调度过期策略',
                                `executor_route_strategy` varchar(50) DEFAULT NULL COMMENT '执行器路由策略',
                                `executor_handler` varchar(255) DEFAULT NULL COMMENT '执行器任务handler',
                                `executor_param` varchar(512) DEFAULT NULL COMMENT '执行器任务参数',
                                `executor_block_strategy` varchar(50) DEFAULT NULL COMMENT '阻塞处理策略',
                                `executor_timeout` int(11) NOT NULL DEFAULT '0' COMMENT '任务执行超时时间，单位秒',
                                `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
                                `glue_type` varchar(50) NOT NULL COMMENT 'GLUE类型',
                                `glue_source` mediumtext COMMENT 'GLUE源代码',
                                `glue_remark` varchar(128) DEFAULT NULL COMMENT 'GLUE备注',
                                `glue_updatetime` datetime DEFAULT NULL COMMENT 'GLUE更新时间',
                                `child_jobid` varchar(255) DEFAULT NULL COMMENT '子任务ID，多个逗号分隔',
                                `trigger_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '调度状态：0-停止，1-运行',
                                `trigger_last_time` bigint(13) NOT NULL DEFAULT '0' COMMENT '上次调度时间',
                                `trigger_next_time` bigint(13) NOT NULL DEFAULT '0' COMMENT '下次调度时间',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_info
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_info` VALUES (1, 1, '测试任务1', '2018-11-03 22:21:31', '2021-11-06 14:54:29', 'XXL', '', 'CRON', '0/1 * * * * ?', 'DO_NOTHING', 'FIRST', 'demoJobHandler', '', 'SERIAL_EXECUTION', 0, 0, 'BEAN', '', 'GLUE代码初始化', '2018-11-03 22:21:31', '', 1, 1637411338000, 1637411339000);
INSERT INTO `xxl_job_info` VALUES (2, 2, '活动状态扫描', '2021-11-06 11:43:49', '2021-11-13 10:19:56', '小傅哥', '', 'CRON', '0/1 * * * * ?', 'DO_NOTHING', 'FIRST', 'lotteryActivityStateJobHandler', '', 'SERIAL_EXECUTION', 0, 0, 'BEAN', '', 'GLUE代码初始化', '2021-11-06 11:43:49', '', 0, 0, 0);
INSERT INTO `xxl_job_info` VALUES (3, 2, '扫描用户抽奖奖品发放MQ状态补偿', '2021-11-13 10:23:59', '2021-11-13 13:47:26', '小傅哥', '', 'CRON', '0/5 * * * * ?', 'DO_NOTHING', 'FIRST', 'lotteryOrderMQStateJobHandler', '1', 'SERIAL_EXECUTION', 0, 0, 'BEAN', '', 'GLUE代码初始化', '2021-11-13 10:23:59', '', 0, 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_lock
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_lock`;
CREATE TABLE `xxl_job_lock` (
                                `lock_name` varchar(50) NOT NULL COMMENT '锁名称',
                                PRIMARY KEY (`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_lock
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_lock` VALUES ('schedule_lock');
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_log
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_log`;
CREATE TABLE `xxl_job_log` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `job_group` int(11) NOT NULL COMMENT '执行器主键ID',
                               `job_id` int(11) NOT NULL COMMENT '任务，主键ID',
                               `executor_address` varchar(255) DEFAULT NULL COMMENT '执行器地址，本次执行的地址',
                               `executor_handler` varchar(255) DEFAULT NULL COMMENT '执行器任务handler',
                               `executor_param` varchar(512) DEFAULT NULL COMMENT '执行器任务参数',
                               `executor_sharding_param` varchar(20) DEFAULT NULL COMMENT '执行器任务分片参数，格式如 1/2',
                               `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
                               `trigger_time` datetime DEFAULT NULL COMMENT '调度-时间',
                               `trigger_code` int(11) NOT NULL COMMENT '调度-结果',
                               `trigger_msg` text COMMENT '调度-日志',
                               `handle_time` datetime DEFAULT NULL COMMENT '执行-时间',
                               `handle_code` int(11) NOT NULL COMMENT '执行-状态',
                               `handle_msg` text COMMENT '执行-日志',
                               `alarm_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败',
                               PRIMARY KEY (`id`),
                               KEY `I_trigger_time` (`trigger_time`),
                               KEY `I_handle_code` (`handle_code`)
) ENGINE=InnoDB AUTO_INCREMENT=56303 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_log_report
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_log_report`;
CREATE TABLE `xxl_job_log_report` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `trigger_day` datetime DEFAULT NULL COMMENT '调度-时间',
                                      `running_count` int(11) NOT NULL DEFAULT '0' COMMENT '运行中-日志数量',
                                      `suc_count` int(11) NOT NULL DEFAULT '0' COMMENT '执行成功-日志数量',
                                      `fail_count` int(11) NOT NULL DEFAULT '0' COMMENT '执行失败-日志数量',
                                      `update_time` datetime DEFAULT NULL,
                                      PRIMARY KEY (`id`),
                                      UNIQUE KEY `i_trigger_day` (`trigger_day`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_log_report
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_log_report` VALUES (1, '2021-11-06 00:00:00', 0, 133, 17686, NULL);
INSERT INTO `xxl_job_log_report` VALUES (2, '2021-11-05 00:00:00', 0, 0, 0, NULL);
INSERT INTO `xxl_job_log_report` VALUES (3, '2021-11-04 00:00:00', 0, 0, 0, NULL);
INSERT INTO `xxl_job_log_report` VALUES (4, '2021-11-13 00:00:00', 0, 6, 13177, NULL);
INSERT INTO `xxl_job_log_report` VALUES (5, '2021-11-12 00:00:00', 0, 0, 0, NULL);
INSERT INTO `xxl_job_log_report` VALUES (6, '2021-11-11 00:00:00', 0, 0, 0, NULL);
INSERT INTO `xxl_job_log_report` VALUES (7, '2021-11-20 00:00:00', 0, 0, 25195, NULL);
INSERT INTO `xxl_job_log_report` VALUES (8, '2021-11-19 00:00:00', 0, 0, 0, NULL);
INSERT INTO `xxl_job_log_report` VALUES (9, '2021-11-18 00:00:00', 0, 0, 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_logglue
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_logglue`;
CREATE TABLE `xxl_job_logglue` (
                                   `id` int(11) NOT NULL AUTO_INCREMENT,
                                   `job_id` int(11) NOT NULL COMMENT '任务，主键ID',
                                   `glue_type` varchar(50) DEFAULT NULL COMMENT 'GLUE类型',
                                   `glue_source` mediumtext COMMENT 'GLUE源代码',
                                   `glue_remark` varchar(128) NOT NULL COMMENT 'GLUE备注',
                                   `add_time` datetime DEFAULT NULL,
                                   `update_time` datetime DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_logglue
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_registry
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_registry`;
CREATE TABLE `xxl_job_registry` (
                                    `id` int(11) NOT NULL AUTO_INCREMENT,
                                    `registry_group` varchar(50) NOT NULL,
                                    `registry_key` varchar(255) NOT NULL,
                                    `registry_value` varchar(255) NOT NULL,
                                    `update_time` datetime DEFAULT NULL,
                                    PRIMARY KEY (`id`),
                                    KEY `i_g_k_v` (`registry_group`,`registry_key`(191),`registry_value`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_registry
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_user
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_user`;
CREATE TABLE `xxl_job_user` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `username` varchar(50) NOT NULL COMMENT '账号',
                                `password` varchar(50) NOT NULL COMMENT '密码',
                                `role` tinyint(4) NOT NULL COMMENT '角色：0-普通用户、1-管理员',
                                `permission` varchar(255) DEFAULT NULL COMMENT '权限：执行器ID列表，多个逗号分割',
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `i_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_user
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
