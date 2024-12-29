
create table topic(
        
        id bigint not null auto_increment,
        id_login bigint,
        id_topic bigint,
        title varchar(100) not null,
        message text,
        create_date datetime default current_timestamp,
        active boolean default true,
        name_course varchar(100),
        course_id bigint not null,
        primary key (id),

        INDEX idx_id_login (id_login),
        INDEX idx_id_login_id (id_login, id),
        UNIQUE INDEX uk_user_sequential (id_login, id_topic),


        constraint fk_topic_course_id foreign key (course_id) references course(id)


);