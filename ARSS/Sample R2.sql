drop table Booking;
drop table Administrator;
drop table Clerk;
drop table Mechanic;
drop table Car;
drop table Customer;
drop table SessionLog;
drop table ActivityLog;

create table Administrator
(
	ID int(10) PRIMARY KEY AUTO_INCREMENT, #starts at 1000
	Fname varchar(50)NOT NULL,
	Sname varchar(50) NOT NULL,
	ContactNo varchar(30) NULL,
	EmailAddress varchar(30) NULL,
	HomeAddress varchar(50) NULL,
	password varchar(10) NOT NULL
);

create table Clerk
(
   	ID int(10) PRIMARY KEY AUTO_INCREMENT, #starts at 2000
   	Fname varchar(50)NOT NULL,
   	Sname varchar(50) NOT NULL,
   	ContactNo varchar(30) NULL,
   	EmailAddress varchar(30) NULL,
   	HomeAddress varchar(50) NULL,
   	password varchar(10) NOT NULL
);

create table Mechanic
(
   	ID int(10) PRIMARY KEY AUTO_INCREMENT, #starts at 3000
   	Fname varchar(50)NOT NULL,
   	Sname varchar(50) NOT NULL,
   	ContactNo varchar(30) NULL,
   	EmailAddress varchar(30) NULL,
   	HomeAddress varchar(50) NULL,
   	password varchar(10) NOT NULL
);

create table Customer
(
	CustomerID int(10) PRIMARY KEY AUTO_INCREMENT, #starts at 4000
	Fname varchar(50) NOT NULL,
	Sname varchar(50) NOT NULL,
	ContactNo varchar(30) NOT NULL,
	EmailAddress varchar(30) NULL,
	HomeAddress varchar(50) NOT NULL,
	DateRegistered DATE NOT NULL #use curdate()
);

create table Car
(
	CarRegNo varchar(50) PRIMARY KEY,
	Make varchar(50) NOT NULL,
	Model varchar(50) NULL,
	owner int(10),
	Year varchar(5) NULL,
	Date_Registered DATE NOT NULL #use curdate()
);

create table Booking
(
	ID int(10) PRIMARY KEY AUTO_INCREMENT, #starts at 6000
	ClerkID int(10) NOT NULL,
	CustomerID int(10) NOT NULL,
	CarID varchar(50) NOT NULL,
	bookingDate TIMESTAMP NOT NULL,
	Problem varchar(100),
	status varchar(50) DEFAULT 'OPEN',
	FOREIGN KEY (ClerkID) REFERENCES Clerk(ID),
	FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
	FOREIGN KEY (CarID) REFERENCES Car(CarRegno)
);

create table SessionLog
(
	logtime TIMESTAMP PRIMARY KEY,
	userID int(10) NOT NULL,
	userRole varchar(15) NOT NULL,
	description varchar(30)
);

create table ActivityLog
(
	activitytime TIMESTAMP NOT NULL,
	userID int(10) NOT NULL,
	userRole varchar(15) NOT NULL,
	op varchar(8) NOT NULL,
	tablename varchar(15) NOT NULL
);


create table orders
(
	ID int(10) PRIMARY KEY AUTO_INCREMENT, #starts at 9000
	partID int(10) NOT NULL,
	quantity int(5) NOT NULL,
	price decimal(5,2) NOT NULL,
	description varchar(100),
	FOREIGN KEY (partID) REFERENCES parts(id)
);

create table parts
(
	ID int(10) PRIMARY KEY AUTO_INCREMENT, #8000
	classification varchar(50) NOT NULL, #body parts, brake parts, cooling/heating, electrical, exhaust, engine, hydraulics, transmission, fluids
	productNumber varchar(30) NOT NULL,
	description varchar(100),
	price decimal(5,2) DEFAULT '0.0',
	quantity int(5) DEFAULT '0'
);


create table Repair
(
	repairID int(10) PRIMARY KEY AUTO_INCREMENT, #starts at 10000
	bookingID int(10) NULL,
	carID varchar(50) NULL,
	partID int(10) NULL,
	totalCharge decimal(5, 2) NULL,
	status varchar(20) DEFAULT 'IN PROGRESS',
	repairLength decimal(4,2) DEFAULT '0.0',
	FOREIGN KEY (bookingID) REFERENCES booking(id),
	FOREIGN KEY (carID) REFERENCES car(carregno),
	FOREIGN KEY (partID) REFERENCES parts(id)
);


insert into administrator(fname, sname, contactno, emailaddress, homeaddress, password) values ("Garry", "Hickey", "086123456", "ghickey@gmail.com", "Somewhere Down The Road", "1234");
insert into administrator(fname, sname, contactno, emailaddress, homeaddress, password) values ("Gerry", "Mickey", "086123456","gmickey@gmail.com", "Middle of Himalayas", "1234");

insert into clerk(fname, sname, contactno, emailaddress, homeaddress, password) values ("Seamus", "Barcoe", "086123456", "sb@yahoo.com", "Giddie Yap Road", "4321");
insert into clerk(fname, sname, contactno, emailaddress, homeaddress, password) values ("Rivermus", "Barc", "086123456", "rb@yahoo.com", "Uptown Valley", "4312");

insert into mechanic(fname, sname, contactno, emailaddress, homeaddress, password) values("Kheir", "Fernandez", "086123456", "kf@hotmail.com", "Fake Street", "1234");
insert into mechanic(fname, sname, contactno, emailaddress, homeaddress, password) values("Khan", "Fernandes", "086123456", "khan@hotmail.com", "Genuine Street", "1234");

insert into customer(fname, sname, contactno, emailaddress, dateregistered, homeaddress) values ("Imen", "Syed", "086123456", "is@bs.com", CURDATE(), "50 Northgate, Cork Street, Dublin 8");
insert into customer(fname, sname, contactno, emailaddress, dateregistered, homeaddress) values ("Himan", "Sayad", "086123456", "hs@bs.com", CURDATE(), "50 Birmingham, Naas Street, Dublin 10");

insert into car(carregno, make, model, year) values ("04D1234", "Toyota", "Vios", "2004" );
insert into car(carregno, make, model, year) values ("0501D12", "Nissan", "Primera", "2005");

insert into booking(clerkid, customerid, carid, bookingDate, problem ) values (2000, 4000, 6000, CURDATE(), "No engine found");

select * from administrator;
select * from clerk;
select * from mechanic;
select * from customer;
select * from car;
select * from booking;
select * from sessionlog;

select * from administrator
union
select * from clerk
union
select * from mechanic;

drop * from customer where customerID = 1;

select fname from booking
join customer using (CustomerID);




create table test
(
	d decimal(5,2) DEFAULT '50.20'
);
insert into test values();
select * from test;