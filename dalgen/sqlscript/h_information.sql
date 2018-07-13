DROP TABLE IF EXISTS `h_information`;
CREATE TABLE `h_information` (
  `id` varchar(128) NOT NULL COMMENT 'id',
  `info_title` varchar(128) DEFAULT NULL COMMENT '资讯标题',
  `info_type` int(1) DEFAULT NULL COMMENT '资讯类型',
  `info_url` varchar(512) DEFAULT NULL COMMENT '资讯图片',
  `report_time` datetime DEFAULT NULL COMMENT '发布时间',
  `down_time` datetime DEFAULT NULL COMMENT '下架时间',
  `report_sts` int(1) DEFAULT NULL COMMENT '发布状态(0待发布 1已发布)',
  `orders` int(4) DEFAULT NULL COMMENT '排序',
  `delete_flag` char(1) DEFAULT 'N' COMMENT '删除标记(N正常 Y删除)',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(255) DEFAULT NULL COMMENT '更新人',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资讯表';

DROP TABLE IF EXISTS `h_information_file`;
CREATE TABLE `h_information_file` (
  `id` varchar(128) NOT NULL COMMENT 'id',
  `info_id` varchar(128) DEFAULT NULL COMMENT '资讯id',
  `file_type` varchar(32) DEFAULT NULL COMMENT '附件类型（图片-pic）',
  `pic_url` varchar(512) DEFAULT NULL COMMENT '附件url',
  `orders` int(4) DEFAULT NULL COMMENT '排序',
  `delete_flag` char(1) DEFAULT NULL COMMENT '删除标记(N正常 Y删除)',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(255) DEFAULT NULL COMMENT '更新人',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资讯附件表';
