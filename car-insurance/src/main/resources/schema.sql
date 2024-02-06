create table car(
    id int not null ,
    property_model varchar(50),
    property_make varchar(50),
    year int,
    millage  varchar(50),
    primary key (id)
);

create table person(
    id int not null,
    name varchar(50),
    dob timestamp,
    primary key(id)
);
create table company(
    id int not null ,
    name varchar(50),
    address varchar(50),
    primary key (id)
);