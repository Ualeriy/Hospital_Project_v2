CREATE TABLE hospitals (
       id SERIAL NOT NULL CONSTRAINT hospital_id PRIMARY KEY,
       name VARCHAR (255) NOT NULL,
       address VARCHAR (255),
       phone VARCHAR (255),
       type VARCHAR (255),
       use_of_insurance BOOLEAN,
       number_of_doctors INTEGER
);

CREATE TABLE services (
       id SERIAL NOT NULL CONSTRAINT service_id PRIMARY KEY,
       name VARCHAR(255),
       price MONEY,
       percent_insurance INTEGER,
       time INTERVAL,
       hospital_id BIGINT NOT NULL,
       CONSTRAINT fk_hospitals_services_id FOREIGN KEY (hospital_id) REFERENCES hospitals (id)
);


insert into hospitals (name, address, phone, type, use_of_insurance, number_of_doctors)
    values ('St. Patrick Hospital', 'Washington', '455-55-55', 'municipal', true, 500);

insert into hospitals (name, address, phone, type, use_of_insurance, number_of_doctors)
    values ('St. Angel Hospital', 'Los Angeles', '791-77-77', 'private', true, 200);

insert into hospitals (name, address, phone, type, use_of_insurance, number_of_doctors)
    values ('Mayo Clinic', 'Rochester', '245-95-95', 'municipal', true, 400);


select * from hospitals;
select * from hospitals
    where name like '%St%';


update hospitals set name = 'Washington Municipal Hospital' where name = 'St. Patrick Hospital';


delete from hospitals where name like '%Clinic%';



insert into services (name, price, percent_insurance, time, hospital_id)
    values ('Doctor visit', '100', '0', '30 minute', 1);
insert into services (name, price, percent_insurance, time, hospital_id)
    values ('Doctor visit', '80', '50', '30 minute', 2);

insert into services (name, price, percent_insurance, time, hospital_id)
values ('Online consultation', '50', '0', '20 minute', 1);
insert into services (name, price, percent_insurance, time, hospital_id)
values ('Online consultation', '40', '30', '20 minute', 2);

insert into services (name, price, percent_insurance, time, hospital_id)
    values ('X-ray', '200', '100', '5 minute', 1);
insert into services (name, price, percent_insurance, time, hospital_id)
    values ('X-ray', '250', '50', '5 minute', 2);

insert into services (name, price, percent_insurance, time, hospital_id)
values ('Kidney replacement', '25000', '50', '90 minute', 1);

insert into services (name, price, percent_insurance, time, hospital_id)
    values ('Heart transplant', '75000', '30', '180 minute', 1);


select * from services;
select * from services
    where price > '1000';

update services set price = '30000' where price = '25000';

delete from services where price = '300';

