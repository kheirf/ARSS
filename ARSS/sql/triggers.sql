create trigger orders_ai
after insert on orders
for each row
begin
update parts join orders 
on parts.id = orders.partid 
set parts.quantity = parts.quantity + new.quantity 
where parts.id = orders.partID;
end;


create trigger repairs_ai
after insert on repair
for each row
begin
	update parts join repair
	on parts.id = repair.partid
	set parts.quantity = parts. quantity - 1
	where parts.id = new.partid
	
	update booking join repair
	on booking.id = repair.bookingid
	set booking.status = 'PROCESSED'
	where booking.id = new.bookingid;
end;