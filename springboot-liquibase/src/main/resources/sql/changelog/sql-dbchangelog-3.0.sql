-- liquibase formatted sql

-- changeset kapil:3
create sequence todos_id_seq;
create table todos (
    id integer not null default nextval('todos_id_seq'::regclass),
    task varchar(15) not null,
    description varchar(25) not null,
    completed boolean not null,
    created_date timestamp,
    last_modified_date timestamp,
    primary key (id)
);
alter sequence todos_id_seq owned by todos.id;