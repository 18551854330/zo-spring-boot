--导入数据后删除文件
insert into example(id,name,desc) values (1,'example1','desc1');
insert into role(id,role_name) values (1,'product_manager');
insert into user(id,username,password) values (1,'admin','11111');
insert into user_role(user_id,role_id) values(1,1);