CREATE DATABASE travelmanagmentsystem;
show databases;
use travelmanagmentsystem;
CREATE table account(username varchar(20), name varchar(20), password varchar(20), security varchar(100), answer varchar(50) );
 show tables;
 select* from account;
 delete from account where username = '__devashish45__';
CREATE table customer(username varchar(20), id varchar(30), number varchar(30), name varchar(30), gender varchar (20), country varchar(30), adress varchar(50), phone varchar(15), email varchar(50) );
 select* from customer;
 CREATE table bookedpackages(username varchar(20), package varchar(30), persons varchar(30), id varchar(30), number varchar (30), phone varchar(20), price varchar(20) );
 select* from bookedpackages;
 CREATE table hotel(name varchar(20), costperperson varchar(20), acroom varchar(10), foodincluded varchar(10));
 insert into hotel values("Raddison Blue Hotel", "3400", "1000", "1700");
insert into hotel values("JW Mariot Hotel", "2400", "1300", "1000");
insert into hotel values("The Oberoi hotel", "4000", "1300", "1500");
insert into hotel values("Taj Lake Palace", "1200", "1000", "1500");
 select* from hotel;
 CREATE table bookedhotel(username varchar(20), name varchar(30), persons varchar(30), days varchar(10), ac varchar(10) , food varchar(10) ,id varchar(30), number varchar (30), phone varchar(20), price varchar(20) );
 select* from bookedhotel;