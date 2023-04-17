CREATE DATABASE mustache ENCODING 'UTF8';
\c mustache;
create table tb_user(
    user_id serial not null primary key ,
    firstname varchar(20) not null,
    lastname varchar(20) not null,
    phone varchar(10) not null unique,
    email varchar(100) not null unique
);

insert into tb_user (firstname, lastname, phone, email) values ('may', 'huang', '0988888888', '1dfojosdij@gmail.com');
insert into tb_user (firstname, lastname, phone, email) values ('may', 'huang', '0977777777', 'ijsdskldfisf@gmail.com');




