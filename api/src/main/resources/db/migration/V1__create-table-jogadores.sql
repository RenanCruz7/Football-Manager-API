create table jogadores (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    idade integer not null,
    posicao varchar(100) not null,
    pe varchar(50) not null,

    primary key (id)
);