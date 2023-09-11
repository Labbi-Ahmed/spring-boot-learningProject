insert into user_details(id,name,birth_Day)
values(1001,'Labib Ahmed', CURRENT_DATE()-7000);

insert into user_details(id,name,birth_Day)
values(1002,'Habib Ahmed', CURRENT_DATE()-3650);

insert into user_details(id,name,birth_Day)
values(1003,'Rakib Ahmed', CURRENT_DATE()-2000);

insert into user_details(id,name,birth_Day)
values(1004,'Nahid Ahmed', CURRENT_DATE()-1000);

insert into post(id,description,user_id)
values(2001,'I am now in dhaka', 1001);

insert into post(id,description,user_id)
values(2002,'I am hungry to learn new tech', 1002);


insert into post(id,description,user_id)
values(2003,'Learning is easy but consistency is not', 1001);

insert into post(id,description,user_id)
values(2004,'I am now in dhaka', 1004);