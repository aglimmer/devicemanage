/*
 Navicat Premium Data Transfer

 Source Server         : mysql8-localhost-root
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : devicemanage

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 24/09/2021 21:28:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admequ
-- ----------------------------
DROP TABLE IF EXISTS `tb_admequ`;
CREATE TABLE `tb_admequ`  (
  `equ_id` int(11) NOT NULL,
  `adm_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`equ_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admequ
-- ----------------------------
INSERT INTO `tb_admequ` VALUES (1, 'G0001');
INSERT INTO `tb_admequ` VALUES (2, 'G0001');
INSERT INTO `tb_admequ` VALUES (3, 'G0001');
INSERT INTO `tb_admequ` VALUES (4, 'G0001');
INSERT INTO `tb_admequ` VALUES (5, 'G0001');
INSERT INTO `tb_admequ` VALUES (6, 'G0001');
INSERT INTO `tb_admequ` VALUES (7, 'G0001');
INSERT INTO `tb_admequ` VALUES (8, 'G0001');
INSERT INTO `tb_admequ` VALUES (9, 'G0001');
INSERT INTO `tb_admequ` VALUES (10, 'G0001');
INSERT INTO `tb_admequ` VALUES (11, 'G0001');
INSERT INTO `tb_admequ` VALUES (12, 'G0001');
INSERT INTO `tb_admequ` VALUES (13, 'G0001');
INSERT INTO `tb_admequ` VALUES (14, 'G0001');
INSERT INTO `tb_admequ` VALUES (15, 'G0001');
INSERT INTO `tb_admequ` VALUES (16, 'G0001');
INSERT INTO `tb_admequ` VALUES (17, 'G0001');
INSERT INTO `tb_admequ` VALUES (18, 'G0001');
INSERT INTO `tb_admequ` VALUES (19, 'G0001');
INSERT INTO `tb_admequ` VALUES (20, 'G0001');
INSERT INTO `tb_admequ` VALUES (21, 'G0001');
INSERT INTO `tb_admequ` VALUES (22, 'G0001');
INSERT INTO `tb_admequ` VALUES (23, 'G0001');
INSERT INTO `tb_admequ` VALUES (24, 'G0001');
INSERT INTO `tb_admequ` VALUES (25, 'G0001');
INSERT INTO `tb_admequ` VALUES (99, 'OK-del');
INSERT INTO `tb_admequ` VALUES (100, 'G0001');

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `adm_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adm_passwd` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adm_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `adm_phone` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `adm_addr` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  PRIMARY KEY (`adm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('G0001', 'ZQY_56', '詹菁英', '2363-07953005', '工A104');
INSERT INTO `tb_admin` VALUES ('G0003', 'Ms. W', '万煜城', '400-24773948', '工A204');
INSERT INTO `tb_admin` VALUES ('G0004', '孟.name', '高伟祺', '311-27896677', '工C214');
INSERT INTO `tb_admin` VALUES ('G0005', ' 杨.biz', '田怡丞', '311-27896676', '工C510');
INSERT INTO `tb_admin` VALUES ('G0006', ' JsK_v', '薛 明', '311-27995676', '工C411');
INSERT INTO `tb_admin` VALUES ('G0007', ' 林.org', '谭天翊', '6088-87771368', '工B611');
INSERT INTO `tb_admin` VALUES ('G0008', ' 萧.net', '白 伟祺', '6088-87672367', '工B612');
INSERT INTO `tb_admin` VALUES ('G0009', ' 烨华 Group', ' 孙 果', '6088-87672367', '工B612');
INSERT INTO `tb_admin` VALUES ('G0010', ' 刘.net', '  熊 泽洋', '56419391324', '3B212');
INSERT INTO `tb_admin` VALUES ('G0011', 'pwd666', '张晓', '19959372281', '福建福州');

-- ----------------------------
-- Table structure for tb_equipment
-- ----------------------------
DROP TABLE IF EXISTS `tb_equipment`;
CREATE TABLE `tb_equipment`  (
  `equ_id` int(11) NOT NULL AUTO_INCREMENT,
  `fac_id` int(11) NULL DEFAULT 0,
  `equ_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `equ_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `equ_purchasedate` date NULL DEFAULT NULL,
  `equ_purchaser` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `equ_singleprice` float NULL DEFAULT NULL,
  `equ_unit` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `equ_spec` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `equ_total` int(11) NULL DEFAULT 1,
  `equ_curr` int(11) NULL DEFAULT 1,
  `equ_position` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `del` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`equ_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_equipment
-- ----------------------------
INSERT INTO `tb_equipment` VALUES (1, 1, '多媒体教师主控台', '多媒体', '2018-08-01', '张喜', 2300, '套', '屏幕、控制盒', 9, 9, '工科楼A207', 0);
INSERT INTO `tb_equipment` VALUES (2, 2, '学生实验桌', '桌子、凳子', '2020-05-02', '范新宇', 135, '张', '桌椅整套', 19, 3, '工科楼B309', 0);
INSERT INTO `tb_equipment` VALUES (3, 2, '教室椅把', '椅子', '2020-05-02', '范新宇', 149, '张', '椅子', 10, 9, '实验楼库房101', 0);
INSERT INTO `tb_equipment` VALUES (4, 2, '教室椅把', '椅子', '2020-05-02', '范新宇', 149, '张', '椅子', 10, 10, '实验楼库房101', 0);
INSERT INTO `tb_equipment` VALUES (5, 1, '教室椅把', '椅子', '2020-05-02', '范新宇', 149, '张', '椅子', 10, 10, '实验楼库房101', 0);
INSERT INTO `tb_equipment` VALUES (6, 1, '温度传感器特性及人体温度测量实验仪', '医学物理/物理演示仪器', '2015-01-02', '王寻巧', 21.9, '个', '体温的测量及温度的误差的判断', 1, 0, '工A104', 0);
INSERT INTO `tb_equipment` VALUES (7, 2, '人耳听觉听阈测量实验仪', '医学物理/物理演示仪器', '2015-02-02', '张扬', 35.9, '台', '适合医学专业本科生、研究生作听阈曲线的测量', 1, 1, '工A104', 0);
INSERT INTO `tb_equipment` VALUES (8, 3, '压力传感器特性及人体心律与血压测量实验仪', '医学物理/物理演示仪器', '2015-02-02', '张扬', 720, '台', '人体心律、血压测量,添加', 1, 1, '工A104', 0);
INSERT INTO `tb_equipment` VALUES (9, 4, '毛细管液体粘滞系数测试实验仪', '医学物理/物理演示仪器', '2015-04-02', '张扬', 300, '台', '测量液体粘滞系数', 1, 1, '工A104', 0);
INSERT INTO `tb_equipment` VALUES (10, 5, '教学模型', '透明电动机模型', '2017-04-02', '李刚', 170, '个', '整台模型透明直观、玲珑精致、形象逼真，并且能够通电转动演示', 1, 1, '工A105', 0);
INSERT INTO `tb_equipment` VALUES (11, 5, '电工电子九孔板、电子元器件', '通用电工', '2017-03-02', '李刚', 200, '件', '根据实验电路在其上任意拼插元件盒成实验电路', 2, 3, '工A105', 0);
INSERT INTO `tb_equipment` VALUES (12, 6, '通用电工电子电拖实验室设备', '通用电工', '2017-03-02', '李刚', 6800, '台', '柜中存放元器件及贮存板，中间抽屉存放工具、万用表、导线等', 1, 1, '工A105', 0);
INSERT INTO `tb_equipment` VALUES (13, 8, '带直流电机', '通用电工', '2017-05-02', '李刚', 12000, '台', '该设备增加了直流电机调速环节，0～220Ｖ直流电机实验电源，直流实验电机，实验单元板等', 1, 1, '工A105', 0);
INSERT INTO `tb_equipment` VALUES (14, 9, '高温超导转变温度测量仪', '近代物理和综合性物理', '2017-06-02', '李刚、张玉', 32000, '台', '测量超导体零电阻基本特性的专用实验设备', 1, 1, '工A204', 0);
INSERT INTO `tb_equipment` VALUES (15, 10, '夫兰克－赫兹仪', '近代物理和综合性物理', '2018-06-02', '张玉', 12960, '台', '观察受激原子所发出的辐射', 1, 1, '工A204', 0);
INSERT INTO `tb_equipment` VALUES (16, 11, '微机型弗兰克－赫兹实验仪', '近代物理和综合性物理', '2018-06-02', '张玉', 28600, '台', '重现 1914 年夫兰克和赫兹进行的低能电子轰击原子的实验设备', 1, 1, '工A204', 0);
INSERT INTO `tb_equipment` VALUES (17, 12, '电子顺磁共振仪', '近代物理和综合性物理', '2019-06-02', '张玉、李刚', 88910, '台', '重现1914年夫兰克和赫兹进行的低能电子轰击原子的实验设备', 1, 1, '工A204', 0);
INSERT INTO `tb_equipment` VALUES (18, 13, ' 雷诺实验装置', '化工原理实验装置', '2019-06-02', '张玉', 12300, '台', '观察流体在圆直管内作层流、过渡及湍流流动现象', 1, 1, '工C214', 0);
INSERT INTO `tb_equipment` VALUES (19, 14, ' 伯努利实验装置 ', '化工原理实验装置', '2019-03-02', '张玉', 16500, '台', '可定性验证流体在流动过程中的机械能转化', 1, 1, '工C214', 0);
INSERT INTO `tb_equipment` VALUES (20, 15, ' 固体流态化演示实验装置', '化工原理实验装置', '2017-03-02', '张玉', 41000, '套', '聚式和散式流态化现象直观、稳定，具有良好的实验效果', 1, 1, '工C214', 0);
INSERT INTO `tb_equipment` VALUES (21, 16, ' 流体流动阻力实验装置', '化工原理实验装置', '2017-08-02', '李刚', 48500, '套', '进行化工原理实验，过程自动化及化工检测仪表实验', 1, 1, '工C214', 0);
INSERT INTO `tb_equipment` VALUES (22, 17, ' 自由沉降实验装置', '环境工程实验装置', '2017-07-04', '董杰、张玉', 24800, '套', 'a颗粒自由沉降，b絮凝沉降', 1, 1, '工C510', 0);
INSERT INTO `tb_equipment` VALUES (23, 18, ' ​固体废物有害成分处理及测定装置', '环境工程实验装置', '2017-07-04', '董杰、李刚', 66000, '套', '固体废物有害成分处理及测定', 1, 1, '工C510', 0);
INSERT INTO `tb_equipment` VALUES (24, 19, '环境工程实验装置', ' ​​好氧堆肥实验装置', '2017-07-04', '董杰', 41400, '套', '了解好氧堆肥化过程的各种影响因素和控制措施', 1, 1, '工C510', 0);
INSERT INTO `tb_equipment` VALUES (25, 20, ' ​​水力循环澄清池', '环境工程实验装置', '2017-07-04', '董杰', 13800, '套', '了解水力循环澄清池的构造和工作原理', 1, 1, '工C510', 0);
INSERT INTO `tb_equipment` VALUES (26, 21, '​​模拟银行实验设备', '金融/银行模拟实验室', '2019-07-04', '蒋杰、徐世明', 61000, '套', '银行模拟实验室使学生得到实际训练从而激发自我的探究意识和创新动机', 2, 2, '工C411', 0);
INSERT INTO `tb_equipment` VALUES (27, 17, '电力电子技术实验室', ' ​​电力电子技术及电气传动实训装置', '2019-07-04', '何旭宇、吴玉峰', 87000, '套', '满足各类学校相应课程的实验教学,深度和广度可根据需要作灵活调整', 1, 1, '工C411', 0);
INSERT INTO `tb_equipment` VALUES (28, 20, '电力电子技术实验室', ' 电力自动化及继电保护实验装置', '2019-07-04', '何旭宇、吴玉峰', 87000, '台', '电工实训装置适用于电力、电气自动化类专业相关课程的教学实验,也可作为学生毕业设计和教学科研项目的硬件开发平台。', 1, 1, '工C411', 0);
INSERT INTO `tb_equipment` VALUES (29, 14, ' 电力电子技术实训台', '电力电子技术实验室', '2019-07-04', '何旭宇、吴玉峰', 48000, '台', '实验线路选择典型,完全配合教学内容,满足教学大纲要求。交、直流调速系统均能实现正、反转切换,以便正确研究系统动态过程', 1, 1, '工C411', 0);
INSERT INTO `tb_equipment` VALUES (30, 13, '风光互补发电教学实验实训平台', '新能源', '2019-08-04', '何旭宇、吴玉峰', 87000, '套', '实可完成风力发电和太阳能发电及基站的供电及并网逆变电源系统集成的相关实验及教学演示。', 1, 1, '工B611', 0);
INSERT INTO `tb_equipment` VALUES (31, 12, '制氢系统', '新能源', '2019-08-04', '何旭宇、吴玉峰', 600000, '套', '制氢', 1, 1, '工B611', 0);
INSERT INTO `tb_equipment` VALUES (32, 11, '太阳能光热教学实验平台', '新能源', '2019-08-04', '何旭宇、吴玉峰、董杰', 180000, '套', '掌握太阳能系统的基本原理,使学生理解各个部件的用途', 1, 1, '工B611', 0);
INSERT INTO `tb_equipment` VALUES (33, 11, '风光氢混合系统实验台', '新能源', '2019-08-04', '何旭宇、吴玉峰、董杰', 235000, '套', '可模拟不同风速情况下风速变化引起的风力发电机发电效率变化', 1, 1, '工B611', 0);
INSERT INTO `tb_equipment` VALUES (34, 19, '药材粉碎实验装置 ', '制药工程实验装置', '2015-05-04', '吴玉峰、董杰', 46800, '台', '药材粉碎', 1, 1, '工B612', 0);
INSERT INTO `tb_equipment` VALUES (35, 15, '药材制粒实验装置  ', '制药工程实验装置', '2015-05-04', '吴玉峰', 42000, '台', '药材制粒', 5, 5, '工B612', 0);
INSERT INTO `tb_equipment` VALUES (37, 15, '中药提取实验装置', '制药工程实验装置', '2015-05-04', '张志东', 42000, '套', '中药提取', 1, 1, '工B612', 0);
INSERT INTO `tb_equipment` VALUES (48, 5, '联想电脑', '未分类', '2020-06-10', '张晓晓', 2399, '台', '办公电脑', 5, 5, '', 0);
INSERT INTO `tb_equipment` VALUES (49, 5, '联想h350', '未分类', '2020-06-10', '张静', 2399, '台', '鼠标、显示屏、主机', 1, 1, '工科楼A205', 0);
INSERT INTO `tb_equipment` VALUES (50, 0, '笔记本电脑', NULL, '2021-03-14', '张三', 10000, '台', '', 1, 1, '', 0);
INSERT INTO `tb_equipment` VALUES (51, 0, '笔记本电脑', NULL, '2021-03-16', '张三', 10000, '台', '测试', 1, 1, '', 0);
INSERT INTO `tb_equipment` VALUES (52, 0, '电脑h300', NULL, '2021-03-16', 'zhangxiao', 10000, '个', '', 1, 1, '', 0);

-- ----------------------------
-- Table structure for tb_factory
-- ----------------------------
DROP TABLE IF EXISTS `tb_factory`;
CREATE TABLE `tb_factory`  (
  `fac_id` int(11) NOT NULL AUTO_INCREMENT,
  `fac_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `fac_addr` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `fac_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  PRIMARY KEY (`fac_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_factory
-- ----------------------------
INSERT INTO `tb_factory` VALUES (1, '元市科技', '福建省巴中市乌马河区宝通路24号东新大厦', '528-80079754');
INSERT INTO `tb_factory` VALUES (2, '章港科技', '福建省安庆市带岭区宝山路153号协通公寓', '390-69598890');
INSERT INTO `tb_factory` VALUES (3, '正运医疗', '河南省白城市翠峦区白渡桥18号博泰新苑', ' 47097053625');
INSERT INTO `tb_factory` VALUES (4, '广记科技', '广东省安阳市金山屯区安图路10号耀江花园', '027-80185755');
INSERT INTO `tb_factory` VALUES (5, '太和工业', '黑龙江省宝鸡市汤旺河区安福路182号住友嘉馨名园', ' 830-65345512');
INSERT INTO `tb_factory` VALUES (6, '章亨生物', '吉林省白银市新青区鞍山路135号耀江花园', ' 09791727505');
INSERT INTO `tb_factory` VALUES (7, '正地生物', '甘肃省包头市红星区白城南路16号博泰新苑', '77157167079');
INSERT INTO `tb_factory` VALUES (8, '泰福生物', '台湾省白城市翠峦区安化路199号真新六街坊', '303-71692720');
INSERT INTO `tb_factory` VALUES (9, '显定化工', '海南省安阳市金山屯区爱国路100号金色家园', '493-82074484');
INSERT INTO `tb_factory` VALUES (10, '天平公司', '湖南省巴中市乌马河区百色路195号阳光翠竹苑', '993-67735083');
INSERT INTO `tb_factory` VALUES (11, '元河化工', '台湾省保山市榆次区北艾路62号复华城市花园', ' 07108659057');
INSERT INTO `tb_factory` VALUES (12, '天和电子', '四川省保定市乌伊岭区宝祁路25号住友嘉馨名园', '895-91043788');
INSERT INTO `tb_factory` VALUES (13, '同兴重工', '湖北省鞍山市西林区安仁路176号爱里舍花园', '110-38777085');
INSERT INTO `tb_factory` VALUES (14, '初城公司', '山东省白山市友好区安国路66号协通公寓', '  8608-63830238');
INSERT INTO `tb_factory` VALUES (15, '广方公司', '江苏省宝鸡市汤旺河区宝杨路8号和亭佳苑', ' 21275857114');
INSERT INTO `tb_factory` VALUES (16, '永康建材', '江西省百色市上甘岭区白城路6号住友嘉馨名园', ' 37017666669');
INSERT INTO `tb_factory` VALUES (17, '景耀电信', '山西省安康市伊春区宝安公路15号菊园五街坊', '  8974-66711705');
INSERT INTO `tb_factory` VALUES (18, '初鑫工程', '甘肃省巴彦淖尔市美溪区保屯路178号', '  7352-33450847');
INSERT INTO `tb_factory` VALUES (19, '景光工程', '云南省蚌埠市五营区白渡路99号和亭佳苑', ' 704-22464579');
INSERT INTO `tb_factory` VALUES (20, '开山生物', '浙江省白山市友好区巴林路52号东新大厦', '604-61073136');
INSERT INTO `tb_factory` VALUES (21, '联想', '', '878-23453');

-- ----------------------------
-- Table structure for tb_faultrecord
-- ----------------------------
DROP TABLE IF EXISTS `tb_faultrecord`;
CREATE TABLE `tb_faultrecord`  (
  `fau_id` int(11) NOT NULL AUTO_INCREMENT,
  `adm_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `equ_id` int(11) NOT NULL,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fau_occurdate` date NULL DEFAULT NULL,
  `fau_occurposition` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `fau_detail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `fau_img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `adm_answer` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `adm_del` tinyint(4) NULL DEFAULT 0,
  `user_del` tinyint(4) NULL DEFAULT 0,
  `adm_message` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '无处理项',
  PRIMARY KEY (`fau_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_faultrecord
-- ----------------------------
INSERT INTO `tb_faultrecord` VALUES (1, 'G0001', 2, '3182701101', '2020-06-12', '未知', '该设备在使用过程', '200614223230193.jpg', '123', 0, 1, '待处理');
INSERT INTO `tb_faultrecord` VALUES (6, 'G0001', 2, '3182701101', '2020-06-19', '教室B207', '教学楼B203有7张桌椅磨损，螺丝松动不稳固', '200614223230194.jpg', '', 0, 1, '待处理');
INSERT INTO `tb_faultrecord` VALUES (7, 'G0001', 2, '3182701101', '2020-06-20', '未知', '测试', '200614223230195.jpg', '', 0, 0, '待处理');
INSERT INTO `tb_faultrecord` VALUES (8, 'G0001', 6, '3182701101', '2021-09-24', '当前位置测试', '设备需要修理', '200614223230196.jpg', '', 0, 0, '待处理');

-- ----------------------------
-- Table structure for tb_feedback
-- ----------------------------
DROP TABLE IF EXISTS `tb_feedback`;
CREATE TABLE `tb_feedback`  (
  `fee_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fee_question` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `fee_detail` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `adm_message` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `adm_answer` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `del` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`fee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_feedback
-- ----------------------------
INSERT INTO `tb_feedback` VALUES (2, '3182701101', '设备故障问题', '借不到设备问题', '已发送', '测试', 0);
INSERT INTO `tb_feedback` VALUES (3, 'G0001', '借用设备问题', 'xxx问题', '已发送', '暂无消息', 0);
INSERT INTO `tb_feedback` VALUES (4, 'G0001', '设备故障问题', '故障问题描述。。。', '已发送', '暂无消息', 0);

-- ----------------------------
-- Table structure for tb_purchase
-- ----------------------------
DROP TABLE IF EXISTS `tb_purchase`;
CREATE TABLE `tb_purchase`  (
  `pur_id` int(11) NOT NULL,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `equ_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pur_applyreason` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pur_purchasenumber` int(11) NULL DEFAULT NULL,
  `pur_price` float NULL DEFAULT NULL,
  `pur_applydate` date NULL DEFAULT NULL,
  `adm_dealstatus` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '无处理项',
  `adm_reply` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  PRIMARY KEY (`pur_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_purchase
-- ----------------------------
INSERT INTO `tb_purchase` VALUES (4, '3182701101', '教学投影仪', '教学设备补充', 1, 2300, '2020-06-01', '未通过', '无');
INSERT INTO `tb_purchase` VALUES (5, 'sky666', '板凳', '教师桌椅配套', 1, 100, '2020-06-14', '通过', '');
INSERT INTO `tb_purchase` VALUES (6, 'G0001', '设备1测试', '测试1', 1, 121, '2020-06-17', '待处理', '');
INSERT INTO `tb_purchase` VALUES (7, 'G0001', '设备2测试', '测试2', 1, 2, '2020-06-17', '待处理', '');

-- ----------------------------
-- Table structure for tb_repairrecord
-- ----------------------------
DROP TABLE IF EXISTS `tb_repairrecord`;
CREATE TABLE `tb_repairrecord`  (
  `rep_id` int(11) NOT NULL AUTO_INCREMENT,
  `equ_id` int(11) NOT NULL,
  `adm_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rep_reason` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `rep_person` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `rep_cost` float NULL DEFAULT NULL,
  `rep_date` date NULL DEFAULT NULL,
  `rep_result` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  PRIMARY KEY (`rep_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_repairrecord
-- ----------------------------
INSERT INTO `tb_repairrecord` VALUES (1, 2, 'G0001', '功能损坏', '孙烨', 87, '2020-06-09', '已报废');

-- ----------------------------
-- Table structure for tb_scraprecord
-- ----------------------------
DROP TABLE IF EXISTS `tb_scraprecord`;
CREATE TABLE `tb_scraprecord`  (
  `scr_id` int(11) NOT NULL AUTO_INCREMENT,
  `adm_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `equ_id` int(11) NOT NULL,
  `scr_reason` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `scr_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`scr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_scraprecord
-- ----------------------------
INSERT INTO `tb_scraprecord` VALUES (1, 'G0001', 1, '设备出现故障', '2020-05-20');
INSERT INTO `tb_scraprecord` VALUES (2, 'G0001', 1, '设备出现故障', '2020-05-20');
INSERT INTO `tb_scraprecord` VALUES (3, 'G0001', 2, '无法解决异常', '2020-06-03');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_passwd` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_type` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_academy` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `user_email` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `user_phone` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1112223334', '823693', '张玉', '老师', '计算机与控制工程学院', '873411000@qq.com', ' 18649823693');
INSERT INTO `tb_user` VALUES ('1112223335', '390782', '胡峰', '老师', '计算机与控制工程学院', '34539000@qq.com', ' 18647323593');
INSERT INTO `tb_user` VALUES ('1112223336', '823693', '徐翔', '老师', '计算机与控制工程学院', '449013123@qq.com', ' 18649523643');
INSERT INTO `tb_user` VALUES ('1112223337', '509200', '范方', '老师', '数学与数据科学学院', '1070509234@qq.com', ' 18643823673');
INSERT INTO `tb_user` VALUES ('1112223338', '427841', '陈亮', '老师', '经济与管理学院', '54278456@qq.com', ' 18649823693');
INSERT INTO `tb_user` VALUES ('1112223339', '593012', '古天乐', '老师', '体育学院', '675593678@qq.com', ' 18649823693');
INSERT INTO `tb_user` VALUES ('3182701101', '640086', '林心怡', '学生', '人文学院', '1254640567@qq.com', ' 13110769123');
INSERT INTO `tb_user` VALUES ('3182703137', '945067', '翁上官人', '学生', '计算机与控制工程学院', '180945000@qq.com', ' 13799326123');
INSERT INTO `tb_user` VALUES ('3182703158', '921127', '张玉', '学生', '计算机与控制工程学院', '2636558000@qq.com', ' 18748757023');
INSERT INTO `tb_user` VALUES ('3182703160', '524400', '何宇', '学生', '计算机与控制工程学院', '3249652000@qq.com', ' 13110769111');
INSERT INTO `tb_user` VALUES ('sky666', 'skypw666', '汪峰', '学生', '计算机系', '2220940999@qq.com', '178234577333');

-- ----------------------------
-- Table structure for tb_usingrecord
-- ----------------------------
DROP TABLE IF EXISTS `tb_usingrecord`;
CREATE TABLE `tb_usingrecord`  (
  `usi_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `equ_id` int(11) NOT NULL,
  `adm_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `usi_reason` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `usi_number` int(11) NULL DEFAULT 1,
  `usi_date` date NULL DEFAULT NULL,
  `usi_returndate` date NULL DEFAULT NULL,
  `usi_applystatus` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '无处理项',
  `adm_feedbackapply` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `usi_returnstatus` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '无处理项',
  `adm_feedbackreturn` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `user_del` tinyint(4) NULL DEFAULT 0,
  `adm_del` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`usi_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_usingrecord
-- ----------------------------
INSERT INTO `tb_usingrecord` VALUES (4, '3182701101', 2, 'G0001', '', 3, '2020-06-12', '2020-06-13', '通过', ' ', '无处理项', '', 0, 0);
INSERT INTO `tb_usingrecord` VALUES (5, '3182701101', 2, 'G0001', '学习', 1, '2020-06-22', '2020-06-23', '通过', ' ', '待处理', ' ', 0, 0);
INSERT INTO `tb_usingrecord` VALUES (6, '3182701101', 5, 'G0001', '测试数据', 1, '2020-06-17', '2020-06-18', '待处理', '', '无处理项', '', 0, 0);
INSERT INTO `tb_usingrecord` VALUES (7, '3182701101', 6, 'G0001', '测试数据', 1, '2020-06-23', '2020-06-24', '通过', NULL, '无处理项', NULL, 0, 0);
INSERT INTO `tb_usingrecord` VALUES (8, '3182701101', 5, 'G0001', 'xxx', 1, '2020-09-13', '2020-09-14', '待处理', '', '无处理项', '', 0, 0);
INSERT INTO `tb_usingrecord` VALUES (9, '3182701101', 3, 'G0001', 'xxx', 1, '2020-09-13', '2020-09-14', '待处理', '', '无处理项', '', 0, 0);

-- ----------------------------
-- Procedure structure for my_test
-- ----------------------------
DROP PROCEDURE IF EXISTS `my_test`;
delimiter ;;
CREATE PROCEDURE `my_test`(in param int)
begin 
declare var int default 0;
declare userid varchar(20) default "know";
if var=0 then 
set var=20;
end if;
if userid="know" then 
set userid="ok";
end if;
select var,userid;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for proc3
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc3`;
delimiter ;;
CREATE PROCEDURE `proc3`()
begin 
declare x1 varchar(10) default "outer";
begin
declare x1 varchar(10) default "inner";
select x1;
end;
select x1;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_admdealusi
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_admdealusi`;
delimiter ;;
CREATE PROCEDURE `pro_admdealusi`(usiid int,equid int,usinumber int,usiapplystatus char(10),admfeedbackapply varchar(100),
usireturnstatus char(10),admfeedbackreturn varchar(100),out result int)
begin 
if usiapplystatus='通过' then 
		update tb_equipment set equ_curr=equ_curr-usinumber where equ_id=equid;
end if;
if usireturnstatus='通过' then 
		update tb_equipment set equ_curr=equ_curr+usinumber where equ_id=equid;
end if;
update tb_usingrecord set usi_applystatus=usiapplystatus,adm_feedbackapply=admfeedbackapply,
usi_returnstatus=usireturnstatus,adm_feedbackreturn=admfeedbackreturn where usi_id=usiid;
select ROW_COUNT() into result;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_borrowequ
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_borrowequ`;
delimiter ;;
CREATE PROCEDURE `pro_borrowequ`(user_id varchar(20),
equid int,
usi_reason varchar(100),
usinumber int,
usi_date date,
borrowdays int,
out result int)
begin 
declare admid varchar(20) default '';
declare equcurr int default -1;
set result=0;
select equ_curr into equcurr from tb_equipment where equ_id=equid;
if equcurr>0 and usinumber<=equcurr then 
	select adm_id into admid from tb_admequ where equ_id=equid;
end if;
if admid!='' then 
	insert into tb_usingrecord(user_id,equ_id,adm_id,usi_reason,usi_number,usi_date,usi_returndate,usi_applystatus)
	values(user_id,equid,admid,usi_reason,usinumber,usi_date,adddate(usi_date,interval borrowdays day),'待处理');
	select ROW_COUNT() into result;
end if;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_count
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_count`;
delimiter ;;
CREATE PROCEDURE `pro_count`()
BEGIN
declare i int default 0;
while i<=10 do 
set i = i+1;
end while;
select i;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_count1
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_count1`;
delimiter ;;
CREATE PROCEDURE `pro_count1`()
BEGIN
set @p = 100;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_delequip
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_delequip`;
delimiter ;;
CREATE PROCEDURE `pro_delequip`(usertype int,admid varchar(20),equid int,out result int)
BEGIN
declare cnt int default 0;
select count(*) into cnt from tb_usingrecord where equ_id=equid and usi_returnstatus!='通过';
if cnt>0 then 
set result = 0;
else 
update tb_equipment set del=1 where equ_id=equid;
set result = 1;
end if;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_delfaultrecord
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_delfaultrecord`;
delimiter ;;
CREATE PROCEDURE `pro_delfaultrecord`(fauid varchar(20),usertype int)
begin
	if usertype=1 then 
		update tb_faultrecord set user_del=1 where fau_id=fauid;
	else 
		update tb_faultrecord set adm_del=1 where fau_id=fauid;
	end if;
	delete from tb_faultrecord where fau_id=fauid and user_id=1 and adm_id=1; 
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_delusingrecord
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_delusingrecord`;
delimiter ;;
CREATE PROCEDURE `pro_delusingrecord`(deltype int,usiid int,out result int)
begin 
declare status1 char(10) default '';
declare status2 char(10) default '';
set result = 0;
select usi_applystatus,usi_returnstatus into status1,status2 from tb_usingrecord where usi_id=usiid;
if status1='待处理' or status1='未通过' or status2='通过' then 
	if deltype=1 then
		update tb_usingrecord set user_del=1 where usi_id=usiid;
	else 
		update tb_usingrecord set adm_del=1 where usi_id=usiid;
	end if;
	select ROW_COUNT() into result;
end if;
delete from tb_usingrecord where usi_id=usiid and user_del=1 and adm_del=1;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_insertadmequ
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_insertadmequ`;
delimiter ;;
CREATE PROCEDURE `pro_insertadmequ`(p1 int,p2 varchar(20))
begin 
insert into tb_admequ(equ_id,adm_id) values (
p1,p2);
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_insertequip
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_insertequip`;
delimiter ;;
CREATE PROCEDURE `pro_insertequip`(equ_name varchar(20),
equ_type varchar(20),
equ_purchasedate date,
equ_purchaser char(20),
equ_singleprice float,
equ_unit varchar(20),
equ_spec varchar(100),
equ_total int,
equ_curr int,
equ_position varchar(20),
fac_name varchar(20),
fac_addr varchar(20),
fac_phone varchar(20),
out result int)
begin 
set result = 0;
if fac_name!="" then 
insert into tb_factory(fac_name,fac_addr,fac_phone) values (
fac_name,fac_addr,fac_phone);
end if;
insert into tb_equipment(
fac_id,equ_name,equ_type,
equ_purchasedate,equ_purchaser,equ_singleprice,equ_unit,
equ_spec,equ_total,equ_curr,equ_position)values (
LAST_INSERT_ID(),equ_name,equ_type,
equ_purchasedate,equ_purchaser,equ_singleprice,equ_unit,
equ_spec,equ_total,equ_curr,equ_position);
select ROW_COUNT() into result;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_queryequ
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_queryequ`;
delimiter ;;
CREATE PROCEDURE `pro_queryequ`(equtype varchar(20),out snt int)
begin
select count(*) into snt from tb_equipment;
select * from tb_equipment where equ_type like equtype limit 0,5;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_scrap
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_scrap`;
delimiter ;;
CREATE PROCEDURE `pro_scrap`(admid varchar(20),equid int,scrreason varchar(100),scrdate date,out result int)
begin 
declare equtotal int default 0;
declare equcurr int default 0;
set result=0;
select equ_total,equ_curr into equtotal,equcurr from tb_equipment where equ_id=equid;
if equtotal>0 and equcurr>0 then 
update tb_equipment set equ_total=equ_total-1,equ_curr=equ_curr-1 where equ_id=equid;
set result=1;
end if;
insert into tb_scraprecord(adm_id,equ_id,scr_reason,scr_date) values (admid,equid,scrreason,scrdate);
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_temp
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_temp`;
delimiter ;;
CREATE PROCEDURE `pro_temp`(tname varchar(20))
begin 
insert into tb_temp(tname)values(tname);
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_test1
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_test1`;
delimiter ;;
CREATE PROCEDURE `pro_test1`()
select concat(@param,' world')
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_test2
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_test2`;
delimiter ;;
CREATE PROCEDURE `pro_test2`()
BEGIN
declare i int default 0;
label:loop 
set i=i+1;
if i>20 then 
leave label;
end if;
end loop;
select i;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pro_usingrecord
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_usingrecord`;
delimiter ;;
CREATE PROCEDURE `pro_usingrecord`(usertype int,userid varchar(20),rpos1 int,rpos2 int)
begin
if usertype=1 then 
	select A.usi_id,A.user_id,A.equ_id,A.adm_id,
	A.usi_reason,A.usi_number,A.usi_date,A.usi_returndate,
	A.usi_applystatus,A.adm_feedbackapply,A.usi_returnstatus,
	A.adm_feedbackreturn,B.equ_name from tb_usingrecord A join tb_equipment B on A.equ_id=B.equ_id where  
A.user_id=userid and A.user_del=0 limit rpos1,rpos2;
end if;
if usertype=2 then 
	select A.usi_id,A.user_id,A.equ_id,A.adm_id,
	A.usi_reason,A.usi_number,A.usi_date,A.usi_returndate,
	A.usi_applystatus,A.adm_feedbackapply,A.usi_returnstatus,
	A.adm_feedbackreturn,B.equ_name from tb_usingrecord A join tb_equipment B on A.equ_id=B.equ_id where 
(A.usi_applystatus='待处理' or A.usi_returnstatus='待处理') and A.adm_id=userid and A.adm_del=0 limit rpos1,rpos2;
end if;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
