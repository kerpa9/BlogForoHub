
create table response(
        
        id bigint not null auto_increment,
        message TEXT,
        id_login bigint,
        id_response bigint,
        topic_id bigint not null,
        users_id bigint not null,
        create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
        -- autor varchar(100) not null,
        active boolean default true,
        solution varchar(100) not null,
        primary key(id),
         INDEX idx_id_login (id_login),
        INDEX idx_id_login_id (id_login, id),
        UNIQUE INDEX uk_user_sequential (id_login, id_response),


           constraint fk_response_topic_id foreign key (topic_id) references topic (id),
           constraint fk_response_users_id foreign key (users_id) references users (id)

);