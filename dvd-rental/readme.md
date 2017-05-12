CREATE SEQUENCE user_id_seq;

create table users(
id integer NOT NULL DEFAULT nextval('user_id_seq'::regclass),
first_name character varying(45) COLLATE pg_catalog."default" NOT NULL,
last_name character varying(45) COLLATE pg_catalog."default" NOT NULL,
email character varying(50) COLLATE pg_catalog."default",
active boolean NOT NULL DEFAULT true,
create_date date NOT NULL DEFAULT ('now'::text)::date,
last_update timestamp without time zone DEFAULT now(),
CONSTRAINT user_pkey PRIMARY KEY (id)
);

ALTER SEQUENCE user_id_seq OWNED BY users.id;