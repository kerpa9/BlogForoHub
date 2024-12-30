
create table profile(
        
        id bigint not null auto_increment,
        id_login bigint,
        id_profile bigint,
        name_profile varchar(100) not null,
        user_id bigint not null,
        primary key(id),
        active boolean default true,
        INDEX idx_id_login (id_login),
        INDEX idx_id_login_id (id_login, id),
        UNIQUE INDEX uk_user_sequential (id_login, id_profile),



        constraint fk_profile_user_id foreign key (user_id) references users (id)


);