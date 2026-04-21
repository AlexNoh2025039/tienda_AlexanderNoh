drop database if exists tienda1db_in5bm;
create database tienda1db_in5bm;
use tienda1db_in5bm;

create table categoria (
id_categoria int auto_increment primary key,
nombre_categoria varchar(100) not null,
descripcion_categoria varchar(255) not null
);

create table producto (
id_producto int auto_increment primary key,
nombre_producto varchar(100) not null,
precio_producto double not null,
stock int not null,
id_categoria int,
foreign key (id_categoria) references categoria(id_categoria)
);

create table usuario (
id_usuario int auto_increment primary key,
nombre_usuario varchar(100) not null,
apellido_usuario varchar(100) not null,
edad_usuario int not null
);

create table pedido (
id_pedido int auto_increment primary key,
fecha_pedido varchar(50) not null,
total_pedido double not null,
id_usuario int,
foreign key (id_usuario) references usuario(id_usuario)
);

create table detalle_pedido (
id_detalle int auto_increment primary key,
cantidad int not null,
precio_unitario double not null,
id_pedido int,
id_producto int,
foreign key (id_pedido) references pedido(id_pedido),
foreign key (id_producto) references producto(id_producto)
);

insert into categoria (nombre_categoria, descripcion_categoria) values
('electronicos', 'dispositivos tecnologicos'),
('ropa', 'vestimenta para hombres y mujeres'),
('hogar', 'articulos para el hogar');

insert into usuario (nombre_usuario, apellido_usuario, edad_usuario) values
('Alex', 'Noh', 17),
('Maria', 'Lopez', 22);

insert into producto (nombre_producto, precio_producto, stock, id_categoria) values
('celular samsung', 2500.00, 10, 1),
('laptop hp', 5500.00, 5, 1),
('camisa polo', 150.00, 20, 2),
('pantalon jeans', 300.00, 15, 2),
('licuadora', 800.00, 8, 3);

insert into pedido (fecha_pedido, total_pedido, id_usuario) values
('2026-04-01', 2650.00, 1),
('2026-04-02', 6000.00, 2);

insert into detalle_pedido (cantidad, precio_unitario, id_pedido, id_producto) values
(1, 2500.00, 1, 1),
(1, 150.00, 1, 3),
(1, 5500.00, 2, 2),
(2, 300.00, 2, 4);