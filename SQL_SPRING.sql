CREATE DATABASE SpringBoot
USE SpringBoot
create table Nhan_Vien
(
  ID        BIGINT not null,
  FULL_NAME VARCHAR(128) not null,
  AGE   INT not null
) ;
--  
alter table Nhan_Vien
  add constraint Nhan_Vien_PK primary key (ID);


Insert into Nhan_Vien(ID, Full_Name, AGE) values (1, 'Tom', 1000);
Insert into Nhan_Vien(ID, Full_Name, AGE) values (2, 'Jerry', 2000);
Insert into Nhan_Vien(ID, Full_Name, AGE) values (3, 'Donald', 3000);