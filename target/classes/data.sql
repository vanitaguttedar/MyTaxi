insert into car(id, convertible, date_created, engine_type, license_plate, rating, seat_count, deleted)
values(1, true, now(),  'BMW B58', 'A01', 5.0, 4, false);

insert into car(id, convertible, date_created, engine_type, license_plate, rating, seat_count, deleted)
values(2, true, now(),  'BMW B38', 'B01', 4.0, 6, false);

insert into car(id, convertible, date_created, engine_type, license_plate, rating, seat_count, deleted)
values(3, false, now(),  'BMW N57', 'C01', 4.0, 6, false);

insert into driver (id, date_created, deleted, online_status, password, username) values (3, now(), false, 'ONLINE', 'dri03pw', 'driver03')