create table users
(
    id int(8) auto_increment primary key,
    fname varchar(20) not null,
    login varchar(20) not null,
    password varchar(20) not null
);
create table games
(
    id int(8) auto_increment primary key ,
    id_user int(8) not null,
    random int(4) not null ,
    foreign key (id_user) references users(id) on delete cascade
);
create table results
(
    id int(8) auto_increment primary key ,
    id_game int(8) not null ,
    userint int(4) not null ,
    foreign key (id_game) references games(id) on delete cascade
)
