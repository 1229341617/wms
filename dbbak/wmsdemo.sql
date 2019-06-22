/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : wmsdemo

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-06-22 13:15:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for complepaper
-- ----------------------------
DROP TABLE IF EXISTS `complepaper`;
CREATE TABLE `complepaper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `totalscore` int(11) DEFAULT NULL,
  `objscore` int(11) DEFAULT NULL,
  `cutnum` int(11) DEFAULT NULL,
  `reviewednum` int(11) DEFAULT NULL,
  `imagePath` varchar(255) DEFAULT NULL,
  `iscutted` bit(1) DEFAULT NULL,
  `isreviewd` bit(1) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  `exam_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_noinhgfl0n2diu0o3vq881uao` (`student_id`),
  KEY `FK_k29neqv2er54pvd1v1xlo2552` (`subject_id`),
  KEY `FK_kw2v0pyokch9sct4d5fwut9w4` (`teacher_id`),
  KEY `FK_1eu90f2oa7lk5mkp9muiyvnoo` (`exam_id`),
  CONSTRAINT `FK_1eu90f2oa7lk5mkp9muiyvnoo` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`),
  CONSTRAINT `FK_k29neqv2er54pvd1v1xlo2552` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `FK_kw2v0pyokch9sct4d5fwut9w4` FOREIGN KEY (`teacher_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_noinhgfl0n2diu0o3vq881uao` FOREIGN KEY (`student_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of complepaper
-- ----------------------------
INSERT INTO `complepaper` VALUES ('1', '0', '63', '4', '4', 'upload/75e473a2-11a8-4bec-8518-a52b4614b2f3.png', '', '', '39', '2', null, '5');
INSERT INTO `complepaper` VALUES ('2', '0', '80', '4', '4', 'upload/2bbdfd8e-4073-4f56-ae34-a55dcf6c080f.png', '', '', '41', '2', null, '5');
INSERT INTO `complepaper` VALUES ('3', '0', '0', '4', '0', 'upload/a26726c3-685b-4129-8e52-4c8f8f0a009e.png', '', null, '39', '2', null, '5');

-- ----------------------------
-- Table structure for cutpaper
-- ----------------------------
DROP TABLE IF EXISTS `cutpaper`;
CREATE TABLE `cutpaper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `totalscore` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `imagePath1` varchar(255) DEFAULT NULL,
  `imagePath2` varchar(255) DEFAULT NULL,
  `isfinished` bit(1) DEFAULT NULL,
  `titlenum_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `complepaper_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_66mnp77ywvc2bfld9a6vh5ppp` (`titlenum_id`),
  KEY `FK_l75s45520r44t7k7qsqo9w0hk` (`parent_id`),
  KEY `FK_9qthkt8xpsx4u2m2wtd1cuuln` (`teacher_id`),
  KEY `FK_tqnakcvf2642vbe56nj2nm1th` (`student_id`),
  KEY `FK_6ascbvwd7t4bbcelgt0k35uef` (`complepaper_id`),
  CONSTRAINT `FK_66mnp77ywvc2bfld9a6vh5ppp` FOREIGN KEY (`titlenum_id`) REFERENCES `titlenum` (`id`),
  CONSTRAINT `FK_6ascbvwd7t4bbcelgt0k35uef` FOREIGN KEY (`complepaper_id`) REFERENCES `complepaper` (`id`),
  CONSTRAINT `FK_9qthkt8xpsx4u2m2wtd1cuuln` FOREIGN KEY (`teacher_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_l75s45520r44t7k7qsqo9w0hk` FOREIGN KEY (`parent_id`) REFERENCES `cutpaper` (`id`),
  CONSTRAINT `FK_tqnakcvf2642vbe56nj2nm1th` FOREIGN KEY (`student_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cutpaper
-- ----------------------------
INSERT INTO `cutpaper` VALUES ('1', '0', '0', null, null, null, null, null, null, null, '1');
INSERT INTO `cutpaper` VALUES ('2', '35', '22', 'cutimg/75e473a2-11a8-4bec-8518-a52b4614b2f3_00763f8a-f51f-45b4-8164-0604da6418d4_cut_1.jpg', null, '', '1', '1', null, '39', '1');
INSERT INTO `cutpaper` VALUES ('3', '40', '33', 'cutimg/75e473a2-11a8-4bec-8518-a52b4614b2f3_1258c0bd-df89-429f-b5fb-73baa508c45a_cut_2-1.jpg', 'cutimg/75e473a2-11a8-4bec-8518-a52b4614b2f3_c4b40d8f-4556-4878-9a8c-cf9fa60fdcb2_cut_2-2.jpg', '', '2', '1', null, '39', '1');
INSERT INTO `cutpaper` VALUES ('4', '10', '4', 'cutimg/75e473a2-11a8-4bec-8518-a52b4614b2f3_1b5d4151-72c0-4175-926a-fe46654df9e2_cut_3.jpg', null, '', '3', '1', null, '39', '1');
INSERT INTO `cutpaper` VALUES ('5', '15', '4', 'cutimg/75e473a2-11a8-4bec-8518-a52b4614b2f3_5b03669a-f985-4270-9114-f9122380e3ec_cut_4-1.jpg', 'cutimg/75e473a2-11a8-4bec-8518-a52b4614b2f3_7e672fed-d916-4573-8cae-e1156ae9c737_cut_4-2.jpg', '', '4', '1', null, '39', '1');
INSERT INTO `cutpaper` VALUES ('6', '35', '33', 'cutimg/2bbdfd8e-4073-4f56-ae34-a55dcf6c080f_d1267e59-f5f6-4afb-a2c2-d5a433bf05f4_cut_1.jpg', null, '', '1', '1', null, '41', '2');
INSERT INTO `cutpaper` VALUES ('7', '40', '33', 'cutimg/2bbdfd8e-4073-4f56-ae34-a55dcf6c080f_107cdab8-5bbb-4529-b9ec-6722864715a9_cut_2-1.jpg', 'cutimg/2bbdfd8e-4073-4f56-ae34-a55dcf6c080f_5342f87e-f5d4-45e9-ab67-301f11009883_cut_2-2.jpg', '', '2', '1', null, '41', '2');
INSERT INTO `cutpaper` VALUES ('8', '10', '8', 'cutimg/2bbdfd8e-4073-4f56-ae34-a55dcf6c080f_eb0a267e-ecd3-4e9e-a146-20137fdb294c_cut_3.jpg', null, '', '3', '1', null, '41', '2');
INSERT INTO `cutpaper` VALUES ('9', '15', '6', 'cutimg/2bbdfd8e-4073-4f56-ae34-a55dcf6c080f_22066702-8569-4483-bc82-ff3040e9b546_cut_4-1.jpg', 'cutimg/2bbdfd8e-4073-4f56-ae34-a55dcf6c080f_7f206963-a354-45c1-8dbc-119a2aad9b15_cut_4-2.jpg', '', '4', '1', null, '41', '2');
INSERT INTO `cutpaper` VALUES ('10', '35', '0', 'cutimg/a26726c3-685b-4129-8e52-4c8f8f0a009e_18c27934-c462-46e0-b76e-a81422e104f3_cut_1.jpg', null, null, '1', '1', null, '39', '3');
INSERT INTO `cutpaper` VALUES ('11', '40', '0', 'cutimg/a26726c3-685b-4129-8e52-4c8f8f0a009e_f91edb37-30fa-4607-8e89-85d955e543c1_cut_2-1.jpg', 'cutimg/a26726c3-685b-4129-8e52-4c8f8f0a009e_0bf91b88-61f7-450e-8772-bae337ed7c83_cut_2-2.jpg', null, '2', '1', null, '39', '3');
INSERT INTO `cutpaper` VALUES ('12', '10', '0', 'cutimg/a26726c3-685b-4129-8e52-4c8f8f0a009e_3251886d-cc5c-48dd-a07b-277c6499944e_cut_3.jpg', null, null, '3', '1', null, '39', '3');
INSERT INTO `cutpaper` VALUES ('13', '15', '0', 'cutimg/a26726c3-685b-4129-8e52-4c8f8f0a009e_7d6c411f-fc0b-457b-9b22-0cfb8a79a9d7_cut_4-1.jpg', 'cutimg/a26726c3-685b-4129-8e52-4c8f8f0a009e_619f386e-6992-49a1-a02b-2c4c0351cea9_cut_4-2.jpg', null, '4', '1', null, '39', '3');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('8', '专业1', 'major1');
INSERT INTO `department` VALUES ('9', '专业2', 'major2');
INSERT INTO `department` VALUES ('10', '专业3', 'major3');

-- ----------------------------
-- Table structure for distribution
-- ----------------------------
DROP TABLE IF EXISTS `distribution`;
CREATE TABLE `distribution` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dlaei2nbm6u7njbdwgj0xn7pa` (`subject_id`),
  KEY `FK_ev6d5gjrdjh6xxy1orv5le3hw` (`teacher_id`),
  CONSTRAINT `FK_dlaei2nbm6u7njbdwgj0xn7pa` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `FK_ev6d5gjrdjh6xxy1orv5le3hw` FOREIGN KEY (`teacher_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of distribution
-- ----------------------------
INSERT INTO `distribution` VALUES ('6', null, '2', '38');
INSERT INTO `distribution` VALUES ('7', null, '2', '42');

-- ----------------------------
-- Table structure for distributions_titlenums
-- ----------------------------
DROP TABLE IF EXISTS `distributions_titlenums`;
CREATE TABLE `distributions_titlenums` (
  `distribution_id` bigint(20) NOT NULL,
  `titlenum_id` bigint(20) NOT NULL,
  KEY `FK_r2wrffaicj3ctf4pv9a3j8cdd` (`titlenum_id`),
  KEY `FK_5b88rswljtadwynm2vglomxxq` (`distribution_id`),
  CONSTRAINT `FK_5b88rswljtadwynm2vglomxxq` FOREIGN KEY (`distribution_id`) REFERENCES `distribution` (`id`),
  CONSTRAINT `FK_r2wrffaicj3ctf4pv9a3j8cdd` FOREIGN KEY (`titlenum_id`) REFERENCES `titlenum` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of distributions_titlenums
-- ----------------------------
INSERT INTO `distributions_titlenums` VALUES ('6', '1');
INSERT INTO `distributions_titlenums` VALUES ('6', '2');
INSERT INTO `distributions_titlenums` VALUES ('7', '3');
INSERT INTO `distributions_titlenums` VALUES ('7', '4');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `admin` bit(1) DEFAULT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  `dept` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jupc981pvryfs7lbgtpoy6mmh` (`dept_id`),
  KEY `FK_cd4cc17twq5tei29lpm6ta5cb` (`dept`),
  CONSTRAINT `FK_cd4cc17twq5tei29lpm6ta5cb` FOREIGN KEY (`dept`) REFERENCES `department` (`id`),
  CONSTRAINT `FK_jupc981pvryfs7lbgtpoy6mmh` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('37', 'admin', '81dc9bdb52d04dc20036dbd8313ed055', '123@qq.com', '22', '', null, '8');
INSERT INTO `employee` VALUES ('38', 'teacher1', '81dc9bdb52d04dc20036dbd8313ed055', 'teacher1@qq.com', '33', '\0', null, '9');
INSERT INTO `employee` VALUES ('39', 'stu1', '81dc9bdb52d04dc20036dbd8313ed055', 'stu1@qq.com', '24', '\0', null, '10');
INSERT INTO `employee` VALUES ('41', 'stu2', '81dc9bdb52d04dc20036dbd8313ed055', 'stu2@qq.com', '22', '\0', null, '9');
INSERT INTO `employee` VALUES ('42', 'teacher2', '81dc9bdb52d04dc20036dbd8313ed055', 'teacher2@qq.com', '35', '\0', null, '10');

-- ----------------------------
-- Table structure for employee_roles
-- ----------------------------
DROP TABLE IF EXISTS `employee_roles`;
CREATE TABLE `employee_roles` (
  `employee_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FK_3ene23nq9uvnj1cktmk8ydhah` (`role_id`),
  KEY `FK_3f8wqxdumr93k2hevf7cuwqxg` (`employee_id`),
  CONSTRAINT `FK_3ene23nq9uvnj1cktmk8ydhah` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_3f8wqxdumr93k2hevf7cuwqxg` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_roles
-- ----------------------------
INSERT INTO `employee_roles` VALUES ('41', '8');
INSERT INTO `employee_roles` VALUES ('39', '8');
INSERT INTO `employee_roles` VALUES ('38', '9');
INSERT INTO `employee_roles` VALUES ('42', '9');
INSERT INTO `employee_roles` VALUES ('37', '10');

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `totaltimes` int(11) DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4e17fscxei9hwwu6wyo1nxbd3` (`subject_id`),
  CONSTRAINT `FK_4e17fscxei9hwwu6wyo1nxbd3` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('4', '语文期末考试', '45', '2019-05-16 19:40:43', '2019-05-16 19:40:46', '3');
INSERT INTO `exam` VALUES ('5', '英语期末考试', '150', '2019-05-23 19:57:36', '2019-05-24 19:57:36', '2');
INSERT INTO `exam` VALUES ('6', '数学期末考试', '150', '2019-05-24 19:58:10', '2019-05-25 19:58:10', '4');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `expression` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('148', '用户删除', 'com._520it.wms.web.action.EmployeeAction:delete');
INSERT INTO `permission` VALUES ('149', '用户列表', 'com._520it.wms.web.action.EmployeeAction:execute');
INSERT INTO `permission` VALUES ('150', '用户编辑', 'com._520it.wms.web.action.EmployeeAction:input');
INSERT INTO `permission` VALUES ('151', '用户保存或更新', 'com._520it.wms.web.action.EmployeeAction:saveOrUpdate');
INSERT INTO `permission` VALUES ('152', '用户批量删除', 'com._520it.wms.web.action.EmployeeAction:batchDelete');
INSERT INTO `permission` VALUES ('153', '部门删除', 'com._520it.wms.web.action.DepartmentAction:delete');
INSERT INTO `permission` VALUES ('154', '部门列表', 'com._520it.wms.web.action.DepartmentAction:execute');
INSERT INTO `permission` VALUES ('155', '部门编辑', 'com._520it.wms.web.action.DepartmentAction:input');
INSERT INTO `permission` VALUES ('156', '部门保存或更新', 'com._520it.wms.web.action.DepartmentAction:saveOrUpdate');
INSERT INTO `permission` VALUES ('157', '权限删除', 'com._520it.wms.web.action.PermissionAction:delete');
INSERT INTO `permission` VALUES ('158', '权限列表', 'com._520it.wms.web.action.PermissionAction:execute');
INSERT INTO `permission` VALUES ('159', '权限加载', 'com._520it.wms.web.action.PermissionAction:reload');
INSERT INTO `permission` VALUES ('160', '角色删除', 'com._520it.wms.web.action.RoleAction:delete');
INSERT INTO `permission` VALUES ('161', '角色列表', 'com._520it.wms.web.action.RoleAction:execute');
INSERT INTO `permission` VALUES ('162', '角色编辑', 'com._520it.wms.web.action.RoleAction:input');
INSERT INTO `permission` VALUES ('163', '角色保存或更新', 'com._520it.wms.web.action.RoleAction:saveOrUpdate');
INSERT INTO `permission` VALUES ('164', '系统菜单删除', 'com._520it.wms.web.action.SystemMenuAction:delete');
INSERT INTO `permission` VALUES ('165', '系统菜单列表', 'com._520it.wms.web.action.SystemMenuAction:execute');
INSERT INTO `permission` VALUES ('166', '系统菜单编辑', 'com._520it.wms.web.action.SystemMenuAction:input');
INSERT INTO `permission` VALUES ('167', '系统菜单保存或更新', 'com._520it.wms.web.action.SystemMenuAction:saveOrUpdate');
INSERT INTO `permission` VALUES ('168', '试卷删除', 'com._520it.wms.web.action.ComplePaperAction:delete');
INSERT INTO `permission` VALUES ('169', '试卷列表', 'com._520it.wms.web.action.ComplePaperAction:execute');
INSERT INTO `permission` VALUES ('170', '试卷编辑', 'com._520it.wms.web.action.ComplePaperAction:input');
INSERT INTO `permission` VALUES ('171', '试卷保存或更新', 'com._520it.wms.web.action.ComplePaperAction:saveOrUpdate');
INSERT INTO `permission` VALUES ('172', '科目删除', 'com._520it.wms.web.action.SubjectAction:delete');
INSERT INTO `permission` VALUES ('173', '科目列表', 'com._520it.wms.web.action.SubjectAction:execute');
INSERT INTO `permission` VALUES ('174', '科目编辑', 'com._520it.wms.web.action.SubjectAction:input');
INSERT INTO `permission` VALUES ('175', '科目保存或更新', 'com._520it.wms.web.action.SubjectAction:saveOrUpdate');
INSERT INTO `permission` VALUES ('176', '试题删除', 'com._520it.wms.web.action.CutPaperAction:delete');
INSERT INTO `permission` VALUES ('177', '试题列表', 'com._520it.wms.web.action.CutPaperAction:execute');
INSERT INTO `permission` VALUES ('178', '试题编辑', 'com._520it.wms.web.action.CutPaperAction:input');
INSERT INTO `permission` VALUES ('179', '试题保存或更新', 'com._520it.wms.web.action.CutPaperAction:saveOrUpdate');
INSERT INTO `permission` VALUES ('180', '试卷批量切割', 'com._520it.wms.web.action.ComplePaperAction:batchCutPaper');
INSERT INTO `permission` VALUES ('181', '试题分配删除', 'com._520it.wms.web.action.DistributionAction:delete');
INSERT INTO `permission` VALUES ('182', '试题分配编辑', 'com._520it.wms.web.action.DistributionAction:input');
INSERT INTO `permission` VALUES ('183', '试题分配列表', 'com._520it.wms.web.action.DistributionAction:execute');
INSERT INTO `permission` VALUES ('184', '试题分配保存或更新', 'com._520it.wms.web.action.DistributionAction:saveOrUpdate');
INSERT INTO `permission` VALUES ('185', '考试删除', 'com._520it.wms.web.action.ExamAction:delete');
INSERT INTO `permission` VALUES ('186', '考试列表', 'com._520it.wms.web.action.ExamAction:execute');
INSERT INTO `permission` VALUES ('187', '考试编辑', 'com._520it.wms.web.action.ExamAction:input');
INSERT INTO `permission` VALUES ('188', '考试保存或更新', 'com._520it.wms.web.action.ExamAction:saveOrUpdate');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('8', '学生', 'stu');
INSERT INTO `role` VALUES ('9', '教师', 'tea');
INSERT INTO `role` VALUES ('10', '超级管理员', 'admin');

-- ----------------------------
-- Table structure for role_menus
-- ----------------------------
DROP TABLE IF EXISTS `role_menus`;
CREATE TABLE `role_menus` (
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  KEY `FK_n9rxuwvg9qeaxqfchovifd9hw` (`menu_id`),
  KEY `FK_fiaxn00niduy5wvs9jyk661f1` (`role_id`),
  CONSTRAINT `FK_fiaxn00niduy5wvs9jyk661f1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_n9rxuwvg9qeaxqfchovifd9hw` FOREIGN KEY (`menu_id`) REFERENCES `systemmenu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menus
-- ----------------------------
INSERT INTO `role_menus` VALUES ('9', '38');
INSERT INTO `role_menus` VALUES ('8', '40');
INSERT INTO `role_menus` VALUES ('10', '35');
INSERT INTO `role_menus` VALUES ('10', '37');
INSERT INTO `role_menus` VALUES ('10', '38');
INSERT INTO `role_menus` VALUES ('10', '40');
INSERT INTO `role_menus` VALUES ('10', '43');
INSERT INTO `role_menus` VALUES ('10', '4');
INSERT INTO `role_menus` VALUES ('10', '5');
INSERT INTO `role_menus` VALUES ('10', '6');
INSERT INTO `role_menus` VALUES ('10', '7');
INSERT INTO `role_menus` VALUES ('10', '8');
INSERT INTO `role_menus` VALUES ('10', '44');

-- ----------------------------
-- Table structure for role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `role_permissions`;
CREATE TABLE `role_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  KEY `FK_qfkbccnh2c5o4tc7akq5x11wv` (`permission_id`),
  KEY `FK_d4atqq8ege1sij0316vh2mxfu` (`role_id`),
  CONSTRAINT `FK_d4atqq8ege1sij0316vh2mxfu` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_qfkbccnh2c5o4tc7akq5x11wv` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permissions
-- ----------------------------
INSERT INTO `role_permissions` VALUES ('9', '178');
INSERT INTO `role_permissions` VALUES ('9', '177');
INSERT INTO `role_permissions` VALUES ('9', '176');
INSERT INTO `role_permissions` VALUES ('9', '179');
INSERT INTO `role_permissions` VALUES ('8', '169');
INSERT INTO `role_permissions` VALUES ('10', '168');
INSERT INTO `role_permissions` VALUES ('10', '169');
INSERT INTO `role_permissions` VALUES ('10', '170');
INSERT INTO `role_permissions` VALUES ('10', '171');
INSERT INTO `role_permissions` VALUES ('10', '172');
INSERT INTO `role_permissions` VALUES ('10', '173');
INSERT INTO `role_permissions` VALUES ('10', '174');
INSERT INTO `role_permissions` VALUES ('10', '175');
INSERT INTO `role_permissions` VALUES ('10', '176');
INSERT INTO `role_permissions` VALUES ('10', '177');
INSERT INTO `role_permissions` VALUES ('10', '178');
INSERT INTO `role_permissions` VALUES ('10', '179');
INSERT INTO `role_permissions` VALUES ('10', '180');
INSERT INTO `role_permissions` VALUES ('10', '181');
INSERT INTO `role_permissions` VALUES ('10', '182');
INSERT INTO `role_permissions` VALUES ('10', '183');
INSERT INTO `role_permissions` VALUES ('10', '184');
INSERT INTO `role_permissions` VALUES ('10', '148');
INSERT INTO `role_permissions` VALUES ('10', '149');
INSERT INTO `role_permissions` VALUES ('10', '150');
INSERT INTO `role_permissions` VALUES ('10', '151');
INSERT INTO `role_permissions` VALUES ('10', '152');
INSERT INTO `role_permissions` VALUES ('10', '153');
INSERT INTO `role_permissions` VALUES ('10', '154');
INSERT INTO `role_permissions` VALUES ('10', '155');
INSERT INTO `role_permissions` VALUES ('10', '156');
INSERT INTO `role_permissions` VALUES ('10', '157');
INSERT INTO `role_permissions` VALUES ('10', '158');
INSERT INTO `role_permissions` VALUES ('10', '159');
INSERT INTO `role_permissions` VALUES ('10', '160');
INSERT INTO `role_permissions` VALUES ('10', '161');
INSERT INTO `role_permissions` VALUES ('10', '162');
INSERT INTO `role_permissions` VALUES ('10', '163');
INSERT INTO `role_permissions` VALUES ('10', '164');
INSERT INTO `role_permissions` VALUES ('10', '165');
INSERT INTO `role_permissions` VALUES ('10', '166');
INSERT INTO `role_permissions` VALUES ('10', '167');
INSERT INTO `role_permissions` VALUES ('10', '185');
INSERT INTO `role_permissions` VALUES ('10', '186');
INSERT INTO `role_permissions` VALUES ('10', '187');
INSERT INTO `role_permissions` VALUES ('10', '188');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('2', '英语', 'english');
INSERT INTO `subject` VALUES ('3', '语文', 'chinese');
INSERT INTO `subject` VALUES ('4', '数学', 'math');

-- ----------------------------
-- Table structure for systemmenu
-- ----------------------------
DROP TABLE IF EXISTS `systemmenu`;
CREATE TABLE `systemmenu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_oufx29snoe4anqhc8qhl48t90` (`parent_id`),
  CONSTRAINT `FK_oufx29snoe4anqhc8qhl48t90` FOREIGN KEY (`parent_id`) REFERENCES `systemmenu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemmenu
-- ----------------------------
INSERT INTO `systemmenu` VALUES ('1', '系统中心', '', 'system', null);
INSERT INTO `systemmenu` VALUES ('2', '业务中心', '', 'business', null);
INSERT INTO `systemmenu` VALUES ('3', '查询中心', '', 'show', null);
INSERT INTO `systemmenu` VALUES ('4', '专业管理', 'department', 'department', '1');
INSERT INTO `systemmenu` VALUES ('5', '用户管理', 'employee', 'employee', '1');
INSERT INTO `systemmenu` VALUES ('6', '权限管理', 'permission', 'permission', '1');
INSERT INTO `systemmenu` VALUES ('7', '角色管理', 'role', 'role', '1');
INSERT INTO `systemmenu` VALUES ('8', '菜单管理', 'systemMenu', 'systemMenu', '1');
INSERT INTO `systemmenu` VALUES ('35', '试卷管理', 'complePaper', 'split', '2');
INSERT INTO `systemmenu` VALUES ('37', '分配阅卷', 'distribution', 'distribution', '2');
INSERT INTO `systemmenu` VALUES ('38', '阅卷管理', 'cutPaper', 'making', '2');
INSERT INTO `systemmenu` VALUES ('40', '成绩查询', 'showGrade', 'querygrade', '3');
INSERT INTO `systemmenu` VALUES ('43', '科目管理', 'subject', 'subject', '1');
INSERT INTO `systemmenu` VALUES ('44', '考试管理', 'exam', 'exam', '2');

-- ----------------------------
-- Table structure for titlenum
-- ----------------------------
DROP TABLE IF EXISTS `titlenum`;
CREATE TABLE `titlenum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `titlenum` int(11) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_h4yo93gn9248wbuc6vj0xnsk4` (`subject_id`),
  CONSTRAINT `FK_h4yo93gn9248wbuc6vj0xnsk4` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of titlenum
-- ----------------------------
INSERT INTO `titlenum` VALUES ('1', '1', '2');
INSERT INTO `titlenum` VALUES ('2', '2', '2');
INSERT INTO `titlenum` VALUES ('3', '3', '2');
INSERT INTO `titlenum` VALUES ('4', '4', '2');
