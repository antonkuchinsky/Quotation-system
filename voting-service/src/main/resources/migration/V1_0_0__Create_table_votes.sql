create table if not exists votes
(
    id           uuid,
    quote_id   uuid not null,
    username      varchar(30) not null ,
    in_favor  boolean not null,
    primary key (id)
    );