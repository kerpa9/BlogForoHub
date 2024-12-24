
create table topic(
        
        id bigint not null auto_increment,
        title varchar(100) not null,
        message text,
        create_date datetime default current_timestamp,
        active boolean default true,
        name_course varchar(100),
        course_id bigint not null,
        primary key (id),

        constraint fk_topic_course_id foreign key (course_id) references course(id)
);