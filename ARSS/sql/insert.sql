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

insert into booking(clerkid, customerid, carid, bookingDate, problem, status ) values (2001, 4000, "aaa", CURDATE(), "No engine found", "CLOSED");

insert into repair(bookingid, partid) values (null, 8000);