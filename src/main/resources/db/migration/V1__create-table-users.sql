create table users(
        id bigint not null auto_increment,
        firstName varchar(100) not null,
        lastName varchar(100) not null,
        phone varchar(100) not null,
        email varchar(100) not null unique,
        document varchar(100) not null unique,
        roleUser varchar(100) not null,
   
        primary key(id)

);