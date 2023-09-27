create table times
(
    id      bigint       not null auto_increment,
    nome    varchar(200) not null,
    estadio varchar(50) not null,
    fundacao date not null,
    patrocinador  varchar(50)  not null,
    mascote  varchar(50)  not null,

    primary key (id)
);