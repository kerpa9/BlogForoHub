
create table topic(
        
        id bigint not null auto_increment,
        title varchar(100) not null,
        message TEXT,
        create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
        status boolean default true,
        course varchar(100) not null,
        response varchar(100) not null,

        primary key(id)

);