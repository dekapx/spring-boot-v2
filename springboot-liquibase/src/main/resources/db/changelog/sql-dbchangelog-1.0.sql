-- liquibase formatted sql

-- changeset kapil:1.0
create sequence status_id_seq;
create table status (
	id integer not null default nextval('status_id_seq'::regclass),
	status_key varchar(25) not null,
	status_value varchar(25) not null,
	primary key (id)
);
alter sequence status_id_seq owned by status.id;