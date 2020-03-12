CREATE TABLE IF NOT EXISTS public.books
(
  id bigint NOT NULL,
  name character varying(255),
  createddatetime timestamp with time zone,
  CONSTRAINT books_pkey PRIMARY KEY (id)
);
