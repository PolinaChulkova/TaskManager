CREATE UNIQUE INDEX index_username
    ON public.usr USING btree (emailDto ASC);