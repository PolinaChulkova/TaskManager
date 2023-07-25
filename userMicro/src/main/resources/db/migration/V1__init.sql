CREATE TABLE public.usr
(
    user_id bigserial NOT NULL,
    email character varying(40) NOT NULL,
    name character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    PRIMARY KEY (user_id),
    CONSTRAINT uk_constraint_username UNIQUE (email)
);

CREATE TABLE public.user_tasks
(
    user_id  bigint NOT NULL,
    task_ids bigint NOT NULL,
    CONSTRAINT fk_user_tasks_on_user FOREIGN KEY (user_id) REFERENCES usr (user_id)
);