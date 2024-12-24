
create table profile(
        
        id bigint not null auto_increment,
        name_profile varchar(100) not null,
        user_id bigint not null,
        primary key(id),
        active boolean default true,


        constraint fk_profile_user_id foreign key (user_id) references users (id)


);