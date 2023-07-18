CREATE UNIQUE INDEX index_username
    ON public.usr USING btree (username ASC);