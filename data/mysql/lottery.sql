create database lottery;

ALTER DATABASE lottery CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


use lottery;

-- auto-generated definition
create table activity
(
    id            bigint auto_increment comment '自增ID',
    activityId    bigint       null comment '活动ID',
    strategyId    bigint       null comment '策略ID',
    activityName  varchar(64)  not null comment '活动名称',
    activityDesc  varchar(128) null comment '活动描述',
    beginDateTime datetime     not null comment '开始时间',
    endDateTime   datetime     not null comment '结束时间',
    stockCount    int          not null comment '库存',
    takeCount     int          null comment '每人可参与次数',
    state         int          null comment '活动状态：编辑、提审、撤审、通过、运行、拒绝、关闭、开启',
    creator       varchar(64)  not null comment '创建人',
    createTime    datetime     not null comment '创建时间',
    updateTime    datetime     not null comment '修改时间',
    constraint activity_id_uindex
        unique (id)
)
    comment '活动配置';

alter table activity
    add primary key (id);

-- auto-generated definition
create table award
(
    id           bigint(11) auto_increment comment '自增ID'
        primary key,
    awardId      bigint                             null comment '奖品ID',
    awardType    int(4)                             null comment '奖品类型（文字描述、兑换码、优惠券、实物奖品暂无）',
    awardCount   int                                null comment '奖品数量',
    awardName    varchar(64)                        null comment '奖品名称',
    awardContent varchar(128)                       null comment '奖品内容「文字描述、Key、码」',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null comment 'updateTime'
)
    comment '奖品配置';

-- auto-generated definition
create table strategy
(
    id           bigint(11) auto_increment comment '自增ID'
        primary key,
    strategyId   bigint(11)   not null comment '策略ID',
    strategyDesc varchar(128) null comment '策略描述',
    strategyMode int(4)       null comment '策略方式「1:单项概率、2:总体概率」',
    grantType    int(4)       null comment '发放奖品方式「1:即时、2:定时[含活动结束]、3:人工」',
    grantDate    datetime     null comment '发放奖品时间',
    extInfo      varchar(128) null comment '扩展信息',
    createTime   datetime     null comment '创建时间',
    updateTime   datetime     null comment '修改时间',
    constraint strategy_strategyId_uindex
        unique (strategyId)
)
    comment '策略配置';

-- auto-generated definition
create table strategy_detail
(
    id         bigint(11) auto_increment comment '自增ID'
        primary key,
    strategyId bigint(11)    not null comment '策略ID',
    awardId    bigint(11)    null comment '奖品ID',
    awardCount int           null comment '奖品数量',
    awardRate  decimal(5, 2) null comment '中奖概率',
    createTime datetime      null comment '创建时间',
    updateTime datetime      null comment '修改时间'
)
    comment '策略明细';
alter table strategy_detail
    add awardSurplusCount int default 0 null comment '奖品剩余库存';
alter table strategy_detail
    add awardDesc varchar(128) null comment '奖品剩余库存';


INSERT INTO strategy_detail (strategyId, awardId, awardCount, awardRate, createTime, updateTime, awardSurplusCount, awardDesc)
VALUES
    (10001, 1, 10, 0.05, NOW(), NOW(), 10, 'A'),
    (10001, 2, 20, 0.1, NOW(), NOW(), 20, 'B'),
    (10001, 3, 15, 0.15, NOW(), NOW(), 15, 'C'),
    (10001, 4, 5, 0.02, NOW(), NOW(), 5, 'C'),
    (10001, 5, 25, 0.25, NOW(), NOW(), 25, 'C'),
    (10001, 6, 8, 0.08, NOW(), NOW(), 8, 'C'),
    (10001, 7, 12, 0.12, NOW(), NOW(), 12, 'C'),
    (10001, 8, 18, 0.18, NOW(), NOW(), 18, 'C'),
    (10001, 9, 30, 0.3, NOW(), NOW(), 30, 'C'),
    (10001, 10, 7, 0.07, NOW(), NOW(), 7, 'C');


INSERT INTO activity (activityId, activityName, activityDesc, beginDateTime, endDateTime, stockCount, takeCount, state, creator, createTime, updateTime)
VALUES
    (10001, 'activity1', 'activity1', '2024-05-15 08:00:00', '2024-05-20 18:00:00', 100, 1, 0, 'user1', NOW(), NOW()),
    (10001, 'activity2', 'activity2', '2024-05-16 09:00:00', '2024-05-21 19:00:00', 150, 2, 1, 'user2', NOW(), NOW());

INSERT INTO strategy (strategyId, strategyDesc, strategyMode, grantType, grantDate, extInfo, createTime, updateTime)
VALUES
    (10001, 'Strategy Description 1', 1,  1, '2024-05-15', 'Extended Information 1', NOW(), NOW())
;


INSERT INTO award (awardId, awardType, awardCount, awardName, awardContent, createTime, updateTime)
VALUES
    (1, 1, 10, 'Award 1', 'Award content 1', NOW(), NOW()),
    (2, 2, 20, 'Award 2', 'Award content 2', NOW(), NOW()),
    (3, 3, 15, 'Award 3', 'Award content 3', NOW(), NOW()),
    (4, 1, 5, 'Award 4', 'Award content 4', NOW(), NOW()),
    (5, 2, 25, 'Award 5', 'Award content 5', NOW(), NOW()),
    (6, 3, 8, 'Award 6', 'Award content 6', NOW(), NOW()),
    (7, 1, 12, 'Award 7', 'Award content 7', NOW(), NOW()),
    (8, 2, 18, 'Award 8', 'Award content 8', NOW(), NOW()),
    (9, 3, 30, 'Award 9', 'Award content 9', NOW(), NOW()),
    (10, 1, 7, 'Award 10', 'Award content 10', NOW(), NOW());


CREATE TABLE `rule_tree` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                             `tree_name` varchar(64) DEFAULT NULL COMMENT '规则树NAME',
                             `tree_desc` varchar(128) DEFAULT NULL COMMENT '规则树描述',
                             `tree_root_node_id` bigint(20) DEFAULT NULL COMMENT '规则树根ID',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8;


CREATE TABLE `rule_tree_node` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                  `tree_id` int(2) DEFAULT NULL COMMENT '规则树ID',
                                  `node_type` int(2) DEFAULT NULL COMMENT '节点类型；1子叶、2果实',
                                  `node_value` varchar(32) DEFAULT NULL COMMENT '节点值[nodeType=2]；果实值',
                                  `rule_key` varchar(16) DEFAULT NULL COMMENT '规则Key',
                                  `rule_desc` varchar(32) DEFAULT NULL COMMENT '规则描述',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

CREATE TABLE `rule_tree_node_line` (
                                       `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                       `tree_id` bigint(20) DEFAULT NULL COMMENT '规则树ID',
                                       `node_id_from` bigint(20) DEFAULT NULL COMMENT '节点From',
                                       `node_id_to` bigint(20) DEFAULT NULL COMMENT '节点To',
                                       `rule_limit_type` int(2) DEFAULT NULL COMMENT '限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围];7:果实',
                                       `rule_limit_value` varchar(32) DEFAULT NULL COMMENT '限定值',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

BEGIN;
INSERT INTO `rule_tree` VALUES (2110081902, '抽奖活动规则树', '用于决策不同用户可参与的活动', 1, '2021-10-08 15:38:05', '2021-10-08 15:38:05');
COMMIT;

BEGIN;
INSERT INTO `rule_tree_node` VALUES (1, 2110081902, 1, NULL, 'userGender', '用户性别[男/女]');
INSERT INTO `rule_tree_node` VALUES (11, 2110081902, 1, NULL, 'userAge', '用户年龄');
INSERT INTO `rule_tree_node` VALUES (12, 2110081902, 1, NULL, 'userAge', '用户年龄');
INSERT INTO `rule_tree_node` VALUES (111, 2110081902, 2, '100001', NULL, NULL);
INSERT INTO `rule_tree_node` VALUES (112, 2110081902, 2, '100002', NULL, NULL);
INSERT INTO `rule_tree_node` VALUES (121, 2110081902, 2, '100003', NULL, NULL);
INSERT INTO `rule_tree_node` VALUES (122, 2110081902, 2, '100004', NULL, NULL);
COMMIT;


BEGIN;
INSERT INTO `rule_tree_node_line` VALUES (1, 2110081902, 1, 11, 1, 'man');
INSERT INTO `rule_tree_node_line` VALUES (2, 2110081902, 1, 12, 1, 'woman');
INSERT INTO `rule_tree_node_line` VALUES (3, 2110081902, 11, 111, 3, '25');
INSERT INTO `rule_tree_node_line` VALUES (4, 2110081902, 11, 112, 4, '25');
INSERT INTO `rule_tree_node_line` VALUES (5, 2110081902, 12, 121, 3, '25');
INSERT INTO `rule_tree_node_line` VALUES (6, 2110081902, 12, 122, 4, '25');
COMMIT;

