create table course(
        
        id bigint not null auto_increment,
        id_login bigint,
        name varchar(100) not null,
        category varchar(100) not null,
        active boolean default true,

        primary key(id)

);