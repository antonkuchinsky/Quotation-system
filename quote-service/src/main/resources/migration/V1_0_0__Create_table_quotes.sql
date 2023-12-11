create table if not exists users
(
    id           uuid primary key,
    content    varchar (500) not null,
    creation_date     timestamptz,
    update_date timestamptz,
    username varchar(30)
    );