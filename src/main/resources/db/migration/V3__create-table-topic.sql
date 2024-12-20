
create table topic(
        
        id bigint not null auto_increment,
        title varchar(100) not null,
        message TEXT,
        create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
        active boolean default true,


        primary key(id)

);