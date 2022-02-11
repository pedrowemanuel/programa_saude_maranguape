create database programa_saude_maranguape;

use programa_saude_maranguape ;

drop table if exists usuarios;
create table usuarios(
	id_usuario int primary key auto_increment,
	email varchar(100) not null unique,
	senha varchar(50) not null
) ENGINE=innoDB;

drop table if exists unidades;
create table unidades(
	id_unidade int primary key auto_increment,
	nome varchar(200) not null,
	regiao varchar(100) not null
) ENGINE=innoDB;

drop table if exists administradores;
create table administradores(
	id_administrador int primary key auto_increment,
	nome varchar(100) not null,
	id_usuario_fk int not null
) ENGINE=innoDB;

alter table `administradores` add constraint `fk_administrador_usuario` foreign key ( `id_usuario_fk` ) references `usuarios` ( `id_usuario` ) ;

drop table if exists funcionarios;
create table funcionarios(
	id_funcionario int primary key auto_increment,
	nome varchar(100) not null,
	cpf varchar(14) not null,
	cargo varchar(100),
	funcionario_admin tinyint default 1,
	id_unidade_fk int not null,
	id_usuario_fk int not null
) ENGINE=innoDB;

alter table `funcionarios` add constraint `fk_funcionario_unidade` foreign key ( `id_unidade_fk` ) references `unidades` ( `id_unidade` ) ;
alter table `funcionarios` add constraint `fk_funcionario_usuario` foreign key ( `id_usuario_fk` ) references `usuarios` ( `id_usuario` ) ;

drop table if exists postagens;
create table postagens(
	id_postagem int primary key auto_increment,
	mensagem text,
	data datetime not null,
	link_imagem varchar(255),
	id_funcionario_fk int not null
) ENGINE=innoDB;

alter table `postagens` add constraint `fk_postagem_funcionario` foreign key ( `id_funcionario_fk` ) references `funcionarios` ( `id_funcionario` ) ;

drop table if exists comentarios;
create table comentarios(
	id_comentario int primary key auto_increment,
	mensagem text,
	data datetime not null,
	id_postagem_fk int not null,
	id_usuario_fk int,
	id_comentario_resp_fk int COMMENT 'Autorelacionamento: serve para referenciar o comentário pai, caso o registro seja uma resposta de comentário'
) ENGINE=innoDB;

alter table `comentarios` add constraint `fk_comentario_postagem` foreign key ( `id_postagem_fk` ) references `postagens` ( `id_postagem` ) ;
alter table `comentarios` add constraint `fk_comentario_comentario` foreign key ( `id_comentario_resp_fk` ) references `comentarios` ( `id_comentario` ) ;
alter table `comentarios` add constraint `fk_comentario_usuario` foreign key ( `id_usuario_fk` ) references `usuarios` ( `id_usuario` ) ;
