CREATE TABLE users
(
  id bigint NOT NULL,
  created_on timestamp without time zone,
  email character varying(100),
  first_name character varying(50),
  last_name character varying(50),
  password character varying(255),
  role character varying(10),
  status character varying(10),
  CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE users_seq INCREMENT 1 MINVALUE 1 NO MAXVALUE START 1 CACHE 1;


