drop table Booking;
drop table Administrator;
drop table Clerk;
drop table Mechanic;
drop table Car;
drop table Customer;

create table Administrator
(
	AdminID int(10) PRIMARY KEY,
	AdminFname varchar(50),
	AdminSname varchar(50),
	AdminContactNo varchar(30),
	password varchar(10)
);

create table Clerk
(
   ClerkID int(10) PRIMARY KEY,
   ClerkFname varchar(50),
   ClerkSname varchar(50),
   ClerkContactNo varchar(30),
   password varchar(10)
);

create table Mechanic
(
   MechanicID int(10) PRIMARY KEY,
   MechanicFname varchar(50),
   MechanicSname varchar(50),
   MechanicContactNo varchar(30),
   password varchar(10)
);

create table Customer
(
	CustomerID int(10) PRIMARY KEY,
	CustomerFname varchar(50),
	CustomerSname varchar(50),
	CustomerPhone varchar(30),
	CustomerAddress varchar(100)
);

create table Car
(
	CarID int(10) PRIMARY KEY,
	CarRegNo varchar(50) UNIQUE KEY,
	Make varchar(50),
	Model varchar(50),
	Year varchar(5)
);

create table Booking
(
	BookingID int(10) PRIMARY KEY,
	ClerkID int(10) NOT NULL,
	CustomerID int(10) NOT NULL,
	CarID int(10) NOT NULL,
	Date date NOT NULL,
	Problem varchar(100),
	FOREIGN KEY (ClerkID) REFERENCES Clerk(ClerkID),
	FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
	FOREIGN KEY (CarID) REFERENCES Car(CarID)
);


insert into administrator values (1000, "Garry", "Hickey", "086123456","1234");
insert into administrator values (1010, "Gerry", "Mickey", "086123456","1234");

insert into clerk values (2000, "Seamus", "Barcoe", "086123456", "4321");
insert into clerk values (2001, "Rivermus", "Barc", "086123456", "4312");

insert into mechanic values(3000, "Kheir", "Fernandez", "086123456", "1234");
insert into mechanic values(3001, "Khan", "Fernandes", "086123456", "1234");

insert into customer values (4000, "Imen", "Syed", "086123456", "50 Southgate, Cork Street, Dublin 8");
insert into customer values (4001, "Himan", "Sayad", "086123456", "50 Southgate, Cork Street, Dublin 8");

insert into car values (5000, "04D1234", "Toyota", "Vios", "2004" );
insert into car values (5001, "0501D12", "Nissan", "Primera", "2005");

insert into booking values (7000, 2000, 4000, 5000, CURDATE(), "No engine found");

select * from administrator;
select * from clerk;
select * from mechanic;
select * from customer;
select * from car;
select * from booking;