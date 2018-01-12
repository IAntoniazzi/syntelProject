CREATE TABLE Availability (
  availability_id raw(16) default sys_guid() Primary Key,
  zip_code Number,
  time timestamp,
  begin_date Date,
  end_date Date
); 


CREATE TABLE Food_item (
  food_item_id raw(16) default sys_guid() Primary Key,
  name varchar2(10),
  description varchar2(60),
  price Number,
  type varchar2(8),
  is_veg varchar(3),
  image blob,
  Availability_id Number
);

CREATE TABLE Address (
  address_id raw(16) default sys_guid() Primary Key,
  street varchar2(50),
  city varchar2(15),
  zip_code Number not null,
  state varchar2(2)
);

CREATE TABLE Orders(
  order_id raw(16) default sys_guid() Primary Key,
  user_id Number,
  address_id Number,
  payment_type varchar2(20),
  order_date Date default sysdate not null,
  price Number,
  delivery_date Date,
  delivery_time timestamp
);



CREATE TABLE Online_user(
  user_id raw(16) default sys_guid() Primary Key,
  first_name varchar2(10),
  last_name varchar2(16),
  is_admin varchar2(3),
  password varchar2(50) not null,
  email varchar(35) not null,
  address_id Number,
  status varchar2(10) not null
);

Alter Table Order_Items ADD  CONSTRAINT Order_items_fk FOREIGN KEY (order_id) REFERENCES Orders (order_id);
Alter Table Order_Items ADD  CONSTRAINT Food_item_fk FOREIGN KEY (food_item_id) REFERENCES Food_item (food_item_id);
Alter Table Food_item ADD  CONSTRAINT Availability_fk FOREIGN KEY (availability_id) REFERENCES Availability (Availability_id);
Alter Table Availability ADD  CONSTRAINT zip_code_fk FOREIGN KEY (zip_code) REFERENCES Service_areas (zip_code);
Alter Table Orders ADD  CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES Online_User (user_id);
Alter Table Orders ADD  CONSTRAINT order_address_id_fk FOREIGN KEY (address_id) REFERENCES Address (address_id);
Alter Table Online_User ADD  CONSTRAINT user_address_id_fk FOREIGN KEY (address_id) REFERENCES Address (address_id);


CREATE TABLE Service_areas (
    zip_code Number not null,
    CONSTRAINT zip_code_pk PRIMARY KEY (zip_code)
);

CREATE TABLE Order_Items (
   order_id Number,
   food_item_id Number,
   quantity Number(4),
   CONSTRAINT order_items_pk PRIMARY KEY (order_id, food_item_id)
);

Insert into Service_areas values (40201);
Insert into Service_areas values (30201);
Insert into Service_areas values (25301);
Insert into Service_areas values (10001);

Insert into Availability (zip_code, time, begin_date, end_date) values --(40201, Current_timestamp, sysdate, '09-DEC-18');

Insert into Availability (zip_code, time, begin_date, end_date) values (30201, Current_timestamp, sysdate, '09-DEC-18');

Insert into Availability (zip_code, time, begin_date, end_date) values (25301, Current_timestamp, sysdate, '11-MAY-18');

Insert into Availability (zip_code, time, begin_date, end_date) values (10001, Current_timestamp, sysdate, '22-MAR-18');

Insert Into Address (address_id,street, city, zip_code, state) values (10,'125 Main rd.', 'Houston',40201,'TX');

Insert Into Address (address_id,street, city, zip_code, state) values (11,'34 Grand Ave.','New York',30201, 'NY');

Insert Into Address (address_id,street, city, zip_code, state) values (12,'1001 Walkers Ct.', 'Atlanta',25301,'GA');

Insert Into Address (address_id, street, city, zip_code, state) values (13,'N 50th St.','Miami', 10001,'FL');

Insert into Online_user(first_name,last_name,is_admin, password, email, address_id, status) values ('Jane', 'Broom', 'No', 'Bit2','JBroom@ymail.com',(Select Address_id from Address where state='TX') ,'Enabled');

Insert into Online_user(first_name,last_name,is_admin, password, email, address_id, status) values ('Dan', 'Bay', 'No', '2Gj','dbay@ymail.com',(Select Address_id from Address where state='NY') ,'Enabled');

Insert into Online_user(first_name,last_name,is_admin, password, email, address_id, status) values ('Joel', 'Moss', 'No', 'jmo34','Jmo@ymail.com',(Select Address_id from Address where state='GA') ,'Enabled');

Insert into Online_user(first_name,last_name,is_admin, password, email, address_id, status) values ('Geel', 'Dak', 'No', 'seeme4','JBroom@ymail.com',(Select Address_id from Address where state='FL') ,'Disabled');

INSERT into FOOD_ITEM (name, description, price, type, is_veg, availability_id)values('Boons','Rice, peas, and Corn',8.99, 'Lunch', 'Yes',(Select Availability_id from Availability where zip_code=10001));

INSERT into FOOD_ITEM (name, description, price, type, is_veg, availability_id)values('Lunch','Kiwi, onions, and honey',7.99, 'Dinner', 'Yes',(Select Availability_id from Availability where zip_code=40201));

INSERT into FOOD_ITEM (name, description, price, type, is_veg, availability_id)values('Corn','corn',2.99, 'Side', 'Yes',(Select Availability_id from Availability where zip_code=30201));

INSERT into ORDERS (user_id,address_id,payment_type,order_date, price, delivery_date, delivery_time)values((Select user_id from online_user where First_name='Jane'),(Select Address_id from Address where state='TX'),'Card',sysdate, 20.00, last_day(sysdate), to_timestamp(last_day(sysdate)));

INSERT into ORDERS (user_id,address_id,payment_type,order_date, price, delivery_date, delivery_time)values((Select user_id from online_user where First_name='Dan'),(Select Address_id from Address where state='NY'),'Cash',sysdate, 10.00, last_day(sysdate), to_timestamp(last_day(sysdate)));

INSERT into ORDER_ITEMS (order_id, food_item_id, quantity)values((Select order_id from orders where price=20.00),(Select food_item_id from food_item where type='Lunch'),1);

INSERT into ORDER_ITEMS (order_id, food_item_id, quantity)values((Select order_id from orders where price=10.00),(Select food_item_id from food_item where type='Dinner'),2);


