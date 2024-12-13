create table users(
        
        id bigint not null auto_increment,
        first_name varchar(100) not null,
        last_name varchar(100) not null,
        phone varchar(100) not null,
        email varchar(100) not null unique,
        password varchar(100) not null,
        document varchar(100) not null,
        role_user varchar(100) not null,
        active boolean default true,
   
        primary key(id)

);