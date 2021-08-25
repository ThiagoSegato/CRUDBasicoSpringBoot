create table banda(
	id identity not null,
	nome varchar(100) not null,
	genero varchar(50),
	primary key(id)
);
--
create table musico(
	id identity not null,
	nome varchar(100),
	apelido varchar(50),
	primary key(id)
);
--
create table banda_integrantes(
	id identity not null,
	banda_id bigint,
	musico_id bigint,
	instrumento varchar(20),
	primary key(id),
	foreign key (banda_id) references banda(id),
	foreign key (musico_id) references musico(id)
);