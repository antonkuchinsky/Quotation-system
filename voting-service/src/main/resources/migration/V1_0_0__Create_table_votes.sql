create table if not exists votes
(
    id           uuid,
    quote_id   uuid not null,
    username      varchar(30) not null unique ,
    in_favor  boolean not null,
    primary key (id)
    );