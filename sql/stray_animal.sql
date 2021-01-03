/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 127.0.0.1:3306
 Source Schema         : stray_animal

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 19/12/2020 15:34:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pet
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(30) DEFAULT NULL COMMENT '宠物名',
  `img` varchar(255) DEFAULT NULL COMMENT '宠物图片',
  `isJY` int(1) DEFAULT NULL COMMENT '是否绝育 1、是；2否',
  `character` varchar(30) DEFAULT NULL COMMENT '性格',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `fid` int(11) DEFAULT NULL COMMENT '饲主id',
  `oid` int(11) DEFAULT NULL COMMENT '机构id',
  `sid` int(11) DEFAULT NULL COMMENT '种类id',
  `detail` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '内容详情',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pet
-- ----------------------------
BEGIN;
INSERT INTO `pet` VALUES (1, '小花', 'assets/petImg/test.jpg', 2, '自闭', '2020-12-11 13:59:29', 54, 47, 2, '<p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43); text-align: center;\"><font style=\"font-size: 16pt;\"><strong><br>思想之光照亮世界经济航程</strong></font></p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43); text-align: center;\">《求是》杂志编辑部</p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43);\">　　“经济全球化是社会生产力发展的客观要求和科技进步的必然结果”；“让世界经济的大海退回到一个一个孤立的小湖泊、小河流，是不可能的，也是不符合历史潮流的”；“中国的发展是世界的机遇，中国是经济全球化的受益者，更是贡献者”；“中国人民张开双臂欢迎各国人民搭乘中国发展的‘快车’、‘便车’”……</p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43);\">　　2017年1月17日，雪峰皑皑的“欧洲屋脊”瑞士，见证历史性一刻——中国最高领导人首次出席世界经济论坛年会并发表主旨演讲。在题为《共担时代责任，共促全球发展》的历史性演讲中，习近平总书记洞察历史规律、把握时代潮流、着眼全球未来，提出一系列世界经济怎么看、怎么办的中国主张、中国方案，凝聚起经济全球化的新共识，深刻回答了“世界怎么了，我们怎么办”的世界之问、时代之问。这篇激荡世界的历史性演讲，充分彰显中国应势而为、勇于担当的大国引领作用，为处在十字路口的经济全球化进程指明了方向，被国际社会誉为“冬日里的阳光”，照亮了颠簸起伏的世界经济航程，具有超越时空的思想穿透力。</p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43);\">　　思想的光芒在逆风逆水中愈发耀眼。环顾当今世界，世纪疫情和百年变局交织，开放融通的潮流滚滚向前，但经济全球化逆流涌动，保护主义、单边主义持续蔓延。陷入严重衰退的世界经济，如何才能尽快复苏？世界纷纷把目光投向中国，寻求中国智慧、中国方案。在世界经济进入新的十字路口的特殊历史时期，再次重温习近平总书记这篇历史性演讲，深刻感悟其强大的思想引领力、感召力，对人们进一步认清大势、把握规律，坚定开放合作信心，推动经济全球化朝着开放、包容、普惠、平衡、共赢的方向发展，具有十分重要的意义。</p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43); text-align: center;\"><strong>经济全球化是大势所趋</strong></p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43);\">　　这是一幅经济全球化时代的现实图景——</p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43);\">　　一部汽车的组装，需要四大洲20多个国家提供部件；一架客机的零部件，来自70多个国家的数百家供应商；18000公里之外的里约热内卢，用着产自中国的小小自拍杆……今天的每一秒钟，都是马克思所说“世界历史”中的全球性时刻，都在为“你中有我、我中有你”的地球村写下生动注脚。</p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43);\">　　在这篇演讲中，习近平总书记深刻阐明：“经济全球化是社会生产力发展的客观要求和科技进步的必然结果，不是哪些人、哪些国家人为造出来的。”15世纪以降，地理大发现开拓了新的市场，促进了资本主义经济的发展，促成了工业革命。商品的输出和对原材料的需求，迅速将世界市场连结在一起，打破了生产和要素流动的地域界限，开启了浩浩荡荡的经济全球化进程。19世纪末20世纪初，以科学和技术相结合为特征、以电力为核心标志的第二次工业革命勃兴，催生了第一次经济全球化浪潮。第二次世界大战以后，第三次工业革命应运而生，日新月异的科学技术井喷式涌现出来。特别是20世纪70年代末80年代初以来，和平与发展成为时代主题，社会生产力迎来又一轮革命性变革，信息、资本和商品在国际间流动加快，促进了贸易大繁荣、投资大便利、人员大流动、技术大发展，经济全球化深入发展，成为不可逆转的时代潮流。</p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43);\"><img alt=\"\" src=\"http://www.qstheory.cn/dukan/qs/2020-12/15/1126857266_16079152966831n.jpg\" style=\"border: 0px; vertical-align: middle; max-width: 100%;\"></p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43);\">　　2001年11月10日，在卡塔尔首都多哈，世界贸易组织第四届部长级会议全体协商一致，审议并通过了中国加入世贸组织的决定。左图为大会现场（新华社记者 王建华/摄）；右图为当时受到众多用户欢迎的手机短信图片（新华社记者 侯俊/摄）。</p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43);\">　　“一个国家、一个民族要振兴，就必须在历史前进的逻辑中前进、在时代发展的潮流中发展。”40多年前，面对浩浩荡荡的时代潮流，中国作出正确战略抉择，开放春风激荡山河。从深圳“001号”引资协议，到开发浦东，沿海、沿江、内陆、沿边开发开放，再到加入世界贸易组织，实行高水平对外开放……40多年来，中国抓住经济全球化机遇，不断融入国际大循环，经济社会发展日新月异，人民生活水平不断提升。同时中国也在对外开放中展现大国担当，为应对亚洲金融危机和国际金融危机等作出重大贡献，连续多年对世界经济增长贡献率超过30%。“世界好，中国才能好；中国好，世界才更好”，越来越成为中国和世界的共识。</p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43);\">　　党的十八大以来，习近平总书记以深谋远虑的战略眼光、海纳百川的宽广胸怀、勇立潮头的非凡勇气、层层推进的扎实作为，统筹国内国际两个大局，主持召开一系列会议，多次深入地方考察调研，出席一系列主场外交活动和多边峰会，系统提出深入实施新一轮对外开放战略的目标、方向、路径，引领中国同世界经济和国际体系深度融合，与全球同频共振，形成我国东西南北中各区域与亚、非、欧、拉美等广袤区域的国家联动发展的开放格局。从共建“一带一路”、建设自由贸易试验区，到推进中国特色自由贸易港建设；从广交会的“中国制造”，到进博会的“中国市场”，再到服贸会的“中国服务”……习近平总书记亲自谋划一系列高水平对外开放重大战略举措，领航掌舵中国号巨轮在经济全球化的大海中乘风破浪，为建设开放型世界经济提供强劲动力。</p><p style=\"margin: 28px 10px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: 2; font-family: &quot;PingFang SC&quot;, &quot;Lantinghei SC&quot;, simsun, &quot;Microsoft YaHei&quot;, Helvetica, Arial, sans-serif; color: rgb(43, 43, 43);\">　　历史和现实深刻证明：推动经济全球化有利于促进国际分工和世界市场向纵深发展，实现全球资源优化配置，为世界经济发展提供强劲动力，符合经济发展规律，符合各国人民的共同利益。面对经济全球化大势，像鸵鸟一样把头埋在沙里假装视而不见，或像堂吉诃德一样挥</p>');
INSERT INTO `pet` VALUES (22, '二哈', 'assets/petImg/1608305969596_614下载.jpeg', 2, '沙雕', '2020-12-18 23:39:30', NULL, 53, 2, NULL);
INSERT INTO `pet` VALUES (23, '小黄', 'assets/petImg/1608306018117_985u=425874985,4078726407&fm=26&gp=0.jpg', 1, '自闭', '2020-12-18 23:40:18', NULL, 53, 1, NULL);
INSERT INTO `pet` VALUES (24, '小白', 'assets/petImg/1608306081926_43u=382216933,234046333&fm=26&gp=0.jpg', 2, '沙雕', '2020-12-18 23:41:22', NULL, 53, 1, NULL);
INSERT INTO `pet` VALUES (25, '拉拉', 'assets/petImg/1608306137689_379u=3879304179,1749848533&fm=26&gp=0.jpg', 2, '活泼，调皮', '2020-12-18 23:42:18', NULL, 53, 3, NULL);
INSERT INTO `pet` VALUES (26, '小灰灰', 'assets/petImg/1608306198154_955u=2178280483,3471074978&fm=26&gp=0.jpg', 2, '胆小', '2020-12-18 23:43:18', NULL, 53, 3, NULL);
INSERT INTO `pet` VALUES (27, '布丁', 'assets/petImg/1608306291412_788u=2864103952,2494636614&fm=26&gp=0.jpg', 2, '活泼，可爱', '2020-12-18 23:44:51', NULL, 53, 2, NULL);
COMMIT;

-- ----------------------------
-- Table structure for species
-- ----------------------------
DROP TABLE IF EXISTS `species`;
CREATE TABLE `species` (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '动物种类名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of species
-- ----------------------------
BEGIN;
INSERT INTO `species` VALUES (1, '猫');
INSERT INTO `species` VALUES (2, '狗');
INSERT INTO `species` VALUES (3, '兔子');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `role` int(1) NOT NULL COMMENT '角色  1、管理员；2、爱心机构；3、饲主',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'admin', 'admin', '2020-12-11 00:00:00', 1);
INSERT INTO `user` VALUES (17, 'test1', '123456', '2020-12-11 16:05:43', 2);
INSERT INTO `user` VALUES (36, 'test2', '111111', '2020-12-11 22:04:38', 2);
INSERT INTO `user` VALUES (39, 'enen', '666666', '2020-12-12 00:30:35', 2);
INSERT INTO `user` VALUES (40, 'test12', '111111', '2020-12-13 16:01:00', 3);
INSERT INTO `user` VALUES (41, 'test13', '111111', '2020-12-13 16:01:06', 2);
INSERT INTO `user` VALUES (42, 'test14', '111111', '2020-12-13 16:01:06', 2);
INSERT INTO `user` VALUES (43, 'test15', '111111', '2020-12-13 16:01:48', 3);
INSERT INTO `user` VALUES (44, 'test16', '111111', '2020-12-13 16:02:02', 3);
INSERT INTO `user` VALUES (45, 'test17', '111111', '2020-12-13 16:02:16', 3);
INSERT INTO `user` VALUES (46, 'test', '111111', '2020-12-15 15:26:13', 2);
INSERT INTO `user` VALUES (47, 'test66', '11111', '2020-12-15 15:26:27', 3);
INSERT INTO `user` VALUES (48, 'tet', '111', '2020-12-15 15:51:45', 2);
INSERT INTO `user` VALUES (49, 't', '1', '2020-12-15 15:54:53', 2);
INSERT INTO `user` VALUES (50, 'test54', '1', '2020-12-15 15:55:23', 2);
INSERT INTO `user` VALUES (51, 'test55', '111111', '2020-12-15 16:22:47', 2);
INSERT INTO `user` VALUES (53, '爱心机构1', '111111', '2020-12-17 18:19:32', 2);
INSERT INTO `user` VALUES (54, '饲主1', '111111', '2020-12-17 18:22:58', 3);
INSERT INTO `user` VALUES (55, '饲主2', '111111', '2020-12-17 19:00:00', 3);
INSERT INTO `user` VALUES (56, '爱心机构2', '111111', '2020-12-18 19:32:35', 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
