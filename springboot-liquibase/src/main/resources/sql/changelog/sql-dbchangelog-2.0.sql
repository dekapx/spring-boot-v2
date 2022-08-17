-- liquibase formatted sql

-- changeset kapil:2
insert into status (status_key, status_value) values('STATUS.1', 'AUTHORISED');
insert into status (status_key, status_value) values('STATUS.2', 'PENDING_NEW_AUTHORISED');
insert into status (status_key, status_value) values('STATUS.3', 'PENDING_UPDATE_AUTHORISED');
insert into status (status_key, status_value) values('STATUS.4', 'PENDING_DELETE_AUTHORISED');
insert into status (status_key, status_value) values('STATUS.5', 'DELETE');