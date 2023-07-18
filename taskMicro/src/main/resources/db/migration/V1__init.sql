CREATE TABLE public.task
(
    task_id bigserial NOT NULL,
    title character varying(40) NOT NULL,
    description character varying(300),
    status boolean NOT NULL,
    completion_date time without time zone NOT NULL,
    user_id bigint NOT NULL,
    PRIMARY KEY (task_id)
);