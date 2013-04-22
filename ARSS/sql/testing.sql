



select * from administrator                        
union
select * from clerk
union
select * from mechanic;

drop * from customer where customerID = 1;

select fname from booking
join customer using (CustomerID);

select booking.id, customer.fname from booking
join customer using(customerID);

select booking.id, car.make, car.model 
from booking join car 
on booking.carid = car.carregno 
where booking.carid = car.carregno 
and booking.status = 'OPEN'
order by booking.id;






select parts.id, orders.id from parts, orders where parts.id = orders.partid;

delimiter $$
create trigger ai_test
after insert on test
for each row
begin
	insert into dummy values(0.0);
end $$

drop trigger ai_test;


select TIME_FORMAT(TIMEDIFF('2013-02-02 14:00:00.00', '2013-02-02 13:00:00.11'), '%H.%i');
select TIME_FORMAT(NOW(), '%H.%i');

select 

update dummy, dummy2 
join test on (dummy.testid = test.id)
join dummy2 on ()dummy.id = dummy2.dummyid)
set dummy.price = test.d, dummy2.price = test.d;


drop table dummy3;
create table dummy3
(
	t timestamp
);
insert into dummy3 values(2.1);
insert into dummy3 values(now());
select * from dummy3;
select timestampdiff(MINUTE, '2013-04-21 14:52:00', now()) from dummy3;

select price from parts join 
repair on parts.id = repair.partid;

drop table dummy2;
create table dummy2
(
	id int(3) PRIMARY KEY,
	dummyid int(3),
	price decimal(5,2),
	FOREIGN KEY (dummyid) REFERENCES dummy(id)
);
drop table dummy;
create table dummy
(
	id int(3) PRIMARY KEY,
	testID int(3),
	price decimal(5,2),
	FOREIGN KEY (testid) REFERENCES test(id)
);
drop table test;
create table test
(
	id int(3) PRIMARY KEY,
	d decimal(5,2) DEFAULT '50.20'
);

insert into test values(101, 5);
insert into dummy values(200, 100, 2.2);
insert into dummy2 values(300, 200, 30.30)
select * from test;
select * from dummy;

select * from activitylog where userid = 1000
union
select * from sessionlog where userid = 1000;

SELECT carregno, make FROM CAR where owner = 1;