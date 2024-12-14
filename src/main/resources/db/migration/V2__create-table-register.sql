create table register_user(
        id bigint not null auto_increment,
        email varchar(100) not null,
        password varchar(100) not null,
    

        primary key(id)

);