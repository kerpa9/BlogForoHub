
create table topic(
        
        id bigint not null auto_increment,
        title varchar(100) not null,
        message TEXT,
        create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
        active boolean default true,
        -- course_id bigint not null,
        primary key(id)

        -- constraint fk_topic_course_id foreign key (course_id) references course (id)


);