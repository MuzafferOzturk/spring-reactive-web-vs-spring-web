create table if not exists demo_user
(
    id       serial not null
        constraint users_pk
            primary key,
    identity text,
    name     text
);