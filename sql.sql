CREATE TABLE `employee` (
  `empid` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
	 `lastname` varchar(255) DEFAULT NULL,
	 `gender` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
	 `department` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`empid`)
)

drop table employee
INSERT INTO `employee` VALUES (1,"李四", "李", "男","1988-5-5","人事部");
INSERT INTO `employee` VALUES (2,"张三", "张", "女","1998-4-7","销售部");
select * from employee

create table users(
uid int  auto_increment primary key,
name varchar(20),
Password varchar(20)
)
drop table users
insert into users VALUES(1,'zx','123')
select * from users