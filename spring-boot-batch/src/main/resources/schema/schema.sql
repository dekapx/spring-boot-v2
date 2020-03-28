-- status table --
create sequence status_id_seq;
create table status (
	id integer not null default nextval('status_id_seq'::regclass),
	status_name varchar(25) not null,
	primary key (id)
);
alter sequence status_id_seq owned by status.id;

-- contact table --
create sequence contact_id_seq;
create table contacts(
    id integer not null default nextval('contact_id_seq'::regclass),
    first_name varchar(55) not null,
    last_name varchar(55) not null,
    phone varchar(50) not null,
    email varchar(75) not null,
    status_id integer not null,
    created_date timestamp,
    created_by varchar(55),
    last_modified_date timestamp,
    last_modified_by varchar(55),
    primary key (id),
    foreign key (status_id) references status (ID)
);
alter sequence contact_id_seq owned by contacts.id;

insert into contacts (first_name, last_name, email)
values ('de', 'kapx', 'dekapx@kapxinc.com');

insert into status (status_name) values('AUTHORISED');
insert into status (status_name) values('PENDING_NEW_AUTHORISED');
insert into status (status_name) values('PENDING_UPDATE_AUTHORISED');