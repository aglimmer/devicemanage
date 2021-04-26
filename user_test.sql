use devicemanage;

DROP TABLE IF EXISTS `user_test`;
CREATE TABLE `user_test`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
`nickname` varchar(48) default '人间四月天' comment '昵称',
`username` varchar(48) default 'bluesky' COMMENT '用户名',
`password` varchar(48) default 'bluesky' COMMENT '密码',
`mailbox` varchar(48) default '1234567890@qq.com' comment '电子邮箱',
`phone` char(11) default '12345678901' comment '手机号',
`create_time` datetime default CURRENT_TIMESTAMP() COMMENT '创建时间',
`avatar_url` varchar(128) default 'https://cdn.pixabay.com/photo/2020/01/17/07/47/cat-4772436_1280.png' comment '头像链接',
`birth` date default '2000-1-1' comment '出生年月日',
`sex` char(10) default 'FEMALE' COMMENT '性别：FEMALE|MALE',
`state` char(10) default 'NORMAL' comment '状态：NORMAL|BAN',
`salt` varchar(64) default 'abc123'comment '加密盐',
`level` int default 0 comment '用户级别：0-10',
`deleted` tinyint	default 0 comment '是否注销：0|1',
PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '仅仅只是用于测试的用户表' ROW_FORMAT = Dynamic;

insert into user_test(username, password,sex,level) values ("user01","pw666666","FEMALE",2);
insert into user_test(username, password,sex,level) values ("user02","pw666666","MALE",3);
insert into user_test(username, password,sex,level) values ("user03","pw666666","FEMALE",2);
insert into user_test(username, password,sex,level) values ("user04","pw666666","MALE",5);
insert into user_test(username, password,sex,level) values ("user05","pw666666","FEMALE",5);
insert into user_test(username, password,sex,level) values ("user06","pw666666","MALE",5);

#测试存储过程
# 测试查询用户账号
delimiter $$
drop procedure if exists pro_user_test_find;
create procedure pro_user_test_find(pusername varchar(48),ppassword varchar(48))
BEGIN
select * from user_test where username=pusername and password=ppassword limit 0,1;
end
$$
delimiter ;

# 测试插入用户账号
delimiter $$
drop procedure if exists pro_user_test_insert;
create procedure pro_user_test_insert(pusername varchar(48),ppassword varchar(48))
BEGIN
insert into user_test(username,password)values(pusername,ppassword);
end
$$
delimiter ;

# 测试删除用户
delimiter $$
drop procedure if exists pro_user_test_delete;
create procedure pro_user_test_delete(pusername varchar(48),ppassword varchar(48))
BEGIN
delete from user_test where username=pusername and password=ppassword;
end
$$
delimiter ;

#测试更新用户密码,注入的参数名要与字段区分
delimiter $$
drop procedure if exists pro_user_test_update_password;
create procedure pro_user_test_update_password(pusername varchar(48),ppassword varchar(48))
BEGIN
update user_test set password=ppassword where username=pusername;
end
$$
delimiter ;



