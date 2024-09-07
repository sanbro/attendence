CREATE TABLE if not exists users(
id integer,
name varchar(250),
password varchar(250),
profile_url varchar(250),
otp integer,
created_at timestamp,
updated_at timestamp,
PRIMARY KEY (id)
);