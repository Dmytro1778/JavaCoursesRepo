drop table if exists tickets;

create table if not exists tickets
(
    place varchar(255) primary key,
    price varchar(255),
    currency varchar(255),
    name varchar(255),
    isFree boolean
);

insert into tickets values (1, 80, 'UAH', null, true),
                           (2, 80, 'UAH', null, true),
                           (3, 80, 'UAH', null, true),
                           (4, 80, 'UAH', null, true),
                           (5, 80, 'UAH', null, true),
                           (6, 80, 'UAH', null, true),
                           (7, 120, 'UAH', null, true),
                           (8, 120, 'UAH', null, true),
                           (9, 120, 'UAH', null, true),
                           (10, 120, 'UAH', null, true),
                           (11, 120, 'UAH', null, true),
                           (12, 120, 'UAH', null, true),
                           (13, 120, 'UAH', null, true),
                           (14, 120, 'UAH', null, true),
                           (15, 120, 'UAH', null, true),
                           (16, 120, 'UAH', null, true),
                           (17, 120, 'UAH', null, true),
                           (18, 120, 'UAH', null, true),
                           (19, 120, 'UAH', null, true),
                           (20, 120, 'UAH', null, true),
                           (21, 120, 'UAH', null, true),
                           (22, 120, 'UAH', null, true),
                           (23, 80, 'UAH', null, true),
                           (24, 80, 'UAH', null, true),
                           (25, 80, 'UAH', null, true),
                           (26, 80, 'UAH', null, true),
                           (27, 80, 'UAH', null, true),
                           (28, 80, 'UAH', null, true);


drop table if exists administrators;

create table if not exists administrators
(
    adminName varchar(255) primary key,
    password varchar(255)
);

insert into administrators values ('admin', 'admin');