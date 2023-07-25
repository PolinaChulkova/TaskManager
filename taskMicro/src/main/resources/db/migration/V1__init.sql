CREATE TABLE public.task
(
    task_id bigserial NOT NULL,
    title character varying(100),
    description character varying(255),
    status boolean,
    completion_date timestamp(6) without time zone,
    user_id bigint,
    CONSTRAINT task_pkey PRIMARY KEY (task_id)
)
