-- status table --
create sequence STATUS_ID_SEQ;

create table STATUS (
	ID integer not null default nextval('STATUS_ID_SEQ'::regclass),
	STATUS varchar(25) not null,
	primary key (ID)
);

alter sequence STATUS_ID_SEQ owned by STATUS.id;

-- contact table --
create sequence CONTACT_ID_SEQ;

create table CONTACT (
ID integer not null default nextval('CONTACT_ID_SEQ'::regclass),
	FIRST_NAME varchar(50) not null,
	LAST_NAME varchar(50) not null,
	PHONE varchar(50) not null,
	EMAIL varchar(50) not null,
	STATUS_ID integer not null,
	primary key (ID),
	foreign key (STATUS_ID) references STATUS (ID)
);

alter sequence CONTACT_ID_SEQ owned by CONTACT.id;