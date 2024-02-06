create table if not exists Country(
    id int auto_increment,
    name varchar(250) not null,
    emoji varchar(100),
    currency varchar(100),
    code varchar(100),
    capital varchar(100),
    primary key(id)
);