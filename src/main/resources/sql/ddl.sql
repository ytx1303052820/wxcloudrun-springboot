CREATE TABLE public.social_event (
	id varchar(128) NULL,
	tag varchar(255) NOT NULL,
	start_time timestamptz NOT NULL,
	end_time timestamptz NOT NULL,
	district varchar(255) NOT NULL,
	address varchar(255) NOT NULL,
	image_paths text NULL,
	title varchar(255) NOT NULL,
	contact varchar(255) NOT NULL,
	description text NULL,
	expired bool NULL,
	organizable bool NULL,
	latitude numeric NULL,
	longitude numeric NULL
);

CREATE TABLE public.Venue (
	id SERIAL PRIMARY KEY,
	address varchar(255) NOT NULL,
	latitude numeric NULL,
	longitude numeric NULL
);