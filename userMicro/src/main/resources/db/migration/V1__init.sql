CREATE TABLE public.usr
(
    user_id bigserial NOT NULL,
    username character varying(40) NOT NULL,
    name character varying(100) NOT NULL,
    password "char"[] NOT NULL,
    PRIMARY KEY (user_id),
    CONSTRAINT uk_constraint_username UNIQUE (username)
);