create role kaan password 'zaRcJwhsh2kvWVQYdFtm' superuser login;

create table member (
  id serial primary key,
  email varchar(100) not null unique,
  password varchar(100) not null,
  name varchar(100) not null,
  create_date timestamptz not null default now(),
  active boolean not null default true
);

create table member_report (
  id serial primary key,
  reporter_id integer references member(id),
  reported_id integer references member(id),
  message text not null
);

create table product_category (
  id integer primary key,
  name text not null unique
);

create table product (
  id serial primary key,
  product_category_id integer references product_category(id),
  name text not null,
  description text not null,
  price integer not null check(price > 0)
);

create table product_objects (
  id serial primary key,
  product_id integer not null references product(id),
  object_id uuid not null --minio id 
);

create table product_request (
  id serial primary key,
  requester_id integer references member(id),
  product_id integer not null references product(id),
  create_date timestamptz not null default now(),
  active boolean not null default true
);

create table product_response_type (
  id integer primary key,
  name text not null unique
);

create table product_response (
  id serial primary key,
  product_request_id integer references product_request(id),
  create_date timestamptz not null default now(),
  response_type_id integer not null  references product_response_type(id),
  deadline timestamptz not null
);

create table member_message (
  id serial primary key,
  product_request_id integer references product_request(id),
  create_date timestamptz not null default now(),
  sender_member_id integer not null references member(id),
  receiver_member_id integer not null references member(id),
  message text not null
);

create table product_demand (
  id serial primary key,
  requester_id integer references member(id),
  product_description text not null,
  min_price integer not null,
  max_price integer not null,  
  create_date timestamptz not null default now(),
  active boolean not null default true,
  check(min_price > 0 and max_price > min_price)
);


