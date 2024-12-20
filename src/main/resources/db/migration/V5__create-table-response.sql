
create table response(
        
        id bigint not null auto_increment,
        message TEXT,
        -- topic varchar(100) not null,
        create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
        autor varchar(100) not null,
        solution varchar(100) not null,

        primary key(id)

);