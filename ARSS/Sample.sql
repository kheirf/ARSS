create table Administrator
(
	AdminID int(10),
	AdminFname varchar(100),
	AdminSname varchar(100),
	password varchar(10)
);

delete from administrator where adminID = 1010;

insert into administrator values (1000, "Garry", "Hickey", "1234");
insert into administrator values (1010, "Gerry", "Mickey", "1234");

select * from administrator;