CREATE INDEX index_user_id
    ON public.task USING btree
        (user_id ASC NULLS LAST);