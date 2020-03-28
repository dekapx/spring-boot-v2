create sequence contact_id_seq;

create table contacts(
    id integer not null default nextval('contact_id_seq'::regclass),
    first_name varchar(55) not null,
    last_name varchar(55) not null,
    email varchar(75) not null,
    created_date timestamp,
    last_modified_date timestamp,
    constraint contact_pkey primary key (id)
);

alter sequence contact_id_seq owned by contacts.id;