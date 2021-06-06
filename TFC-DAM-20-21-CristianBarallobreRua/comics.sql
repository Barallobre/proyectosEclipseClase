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
create table tipos(
tipo varchar(20) primary key
);
create table subtipos(
tipo varchar(20),
subtipo varchar(20)  primary key,
foreign key (tipo) references tipos(tipo)
);
create table comics(
isbn char(13) primary key,
autor varchar(100),
editorial varchar(100),
tipo varchar(20),
coleccion varchar(100),
Nombre varchar(100),
subtipo varchar(20),
foreign key (autor) references autores(autor),
foreign key (editorial) references editoriales(editorial),
foreign key (tipo) references tipos(tipo),
foreign key (subtipo) references subtipos(subtipo),
foreign key (coleccion) references colecciones(coleccion)
);
create table leidos(
isbn char(13) primary key,
leido boolean,
fecha date,
foreign key (isbn) references comics(isbn)
);