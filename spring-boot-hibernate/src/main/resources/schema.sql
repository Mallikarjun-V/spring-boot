CREATE TABLE public.books
(
  id bigint NOT NULL,
  name character varying(255),
  createddatetime timestamp with time zone,
  CONSTRAINT books_pkey PRIMARY KEY (id)
)
