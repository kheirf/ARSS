drop table Administrator;
drop table Clerk;
drop table Mechanic;

create table Administrator
(
	AdminID int(10),
	AdminFname varchar(100),
	AdminSname varchar(100),
	password varchar(10)
);

create table Clerk
(
   ClerkID int(10),
   ClerkFname varchar(100),
   ClerkSname varchar(100),
   password varchar(10)
);

create table Mechanic
(
   MechanicID int(10),
   MechanicFname varchar(100),
   MechanicSname varchar(100),
   password varchar(10)
);

delete from administrator where adminID = 1010;

insert into administrator values (1000, "Garry", "Hickey", "1234");
insert into administrator values (1010, "Gerry", "Mickey", "1234");

insert into clerk values (2000, "Seamus", "Barcoe", "4321");
insert into clerk values (2001, "Rivermus", "Barc", "4312");

select * from administrator;
select * from clerk;