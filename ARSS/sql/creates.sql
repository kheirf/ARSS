drop table repair;
drop table Booking;
drop table orders;
drop table parts;
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
	FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
	# FOREIGN KEY (CarID) REFERENCES Car(CarRegno)
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
	userRole varchar(20) NOT NULL,
	op varchar(20) NOT NULL,
	tablename varchar(30) NOT NULL
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
	mechanicID int(10) NOT NULL,
	bookingID int(10) NULL,
	carID varchar(50) NULL,
	partID int(10) NULL,
	totalCharge decimal(5, 2) NULL DEFAULT '0.0',
	status varchar(20) DEFAULT 'IN PROGRESS',
	repairLength decimal(10, 2) NULL,
	StartDate TIMESTAMP NOT NULL DEFAULT NOW(),
	EndDate TIMESTAMP NULL,
	FOREIGN KEY (bookingID) REFERENCES booking(id),
	FOREIGN KEY (partID) REFERENCES parts(id),
	FOREIGN KEY (mechanicID) REFERENCES mechanic(id)
);
