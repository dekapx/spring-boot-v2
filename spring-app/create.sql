create sequence hibernate_sequence start 1 increment 1
create table author (id int8 not null, first_name varchar(255), last_name varchar(255), primary key (id))
create table author_book (book_id int8 not null, author_id int8 not null, primary key (book_id, author_id))
create table book (id int8 not null, isbn varchar(255), title varchar(255), primary key (id))
create table status (id int8 not null, status_key varchar(255), status_value varchar(255), primary key (id))
alter table author_book add constraint FKg7j6ud9d32ll232o9mgo90s57 foreign key (author_id) references author
alter table author_book add constraint FKn8665s8lv781v4eojs8jo3jao foreign key (book_id) references book
