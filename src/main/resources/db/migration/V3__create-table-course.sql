create table course(
        id bigint not null auto_increment,
        id_login bigint,
        user_sequential_id bigint,
        name varchar(100) not null,
        category varchar(100) not null,
        active boolean default true,

        primary key(id),
        INDEX idx_id_login (id_login),
        INDEX idx_id_login_id (id_login, id),
        UNIQUE INDEX uk_user_sequential (id_login, user_sequential_id)

);