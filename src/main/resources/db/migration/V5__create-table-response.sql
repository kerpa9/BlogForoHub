
create table response(
        
        id bigint not null auto_increment,
        message TEXT,
        topic_id bigint not null,
        users_id bigint not null,
        create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
        -- autor varchar(100) not null,
        active boolean default true,
        solution varchar(100) not null,
        primary key(id),

           constraint fk_response_topic_id foreign key (topic_id) references topic (id),
           constraint fk_response_users_id foreign key (users_id) references users (id)

);