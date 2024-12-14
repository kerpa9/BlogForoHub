create table users(
        
        id bigint not null auto_increment,
        first_name varchar(100) not null,
        last_name varchar(100) not null,
        phone varchar(100) not null,
        email varchar(100) not null unique,
        password varchar(100) not null,
        document varchar(100) not null,
        role_user VARCHAR(50) NOT NULL CHECK (role_user IN ('ADMIN', 'USER')) DEFAULT 'USER',
        active boolean default true,
   
        primary key(id)

);