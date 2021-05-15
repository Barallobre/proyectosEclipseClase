-- drop database comics;
create database comics;
use comics;
create table autores(
autor varchar (50) primary key
);
create table editoriales(
editorial varchar(50) primary key
);
create table colecciones(
coleccion varchar(50) primary key
);
create table subtipos(
id_subtipo char(100) primary key,
nombre varchar(20)
);
create table tipos(
tipo varchar(10) primary key,
id_subtipo char(100),
foreign key (id_subtipo) references subtipos(id_subtipo)
);
create table leidos(
id_leido char(100) primary key,
leido boolean,
fecha date
);
 create table comics(
isbn char(13) primary key,
autor char(100),
editorial char(100),
tipo char(100),
coleccion char(100),

foreign key (autor) references autores(autor),
foreign key (editorial) references editoriales(editorial),
foreign key (tipo) references tipos(tipo),
foreign key (coleccion) references colecciones(coleccion)

);