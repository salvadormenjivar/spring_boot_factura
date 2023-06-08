insert into clientes(nombre,apellido,email,create_at,foto) values('Salvador', 'Peña', 'salvador@correo.com', '2023-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Ivan', 'Ramirez', 'ivan@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Monico', 'Alvarado', 'monico@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Cristian', 'Colocho', 'cristian@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Amadeo', 'Medina', 'amadeo@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Daniela', 'Amaya', 'daniela@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Maria', 'Rodriguez', 'maria@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Dora', 'Perez', 'dora@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Karina', 'Galdamez', 'karina@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Carlos', 'Lemus', 'carlos@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Marlon', 'Garrizano', 'marlon@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Oscar', 'Arevalo', 'oscar@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Giovani', 'Cruz', 'gio@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Oscar', 'Moran', 'oscar@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Dennis', 'Pereira', 'dennis@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Sofia', 'Martinez', 'sofia@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Corina', 'Pelaez', 'corina@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Ceci', 'Fuentes', 'ceci@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Jorge', 'Gonzalez', 'jorge@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Mauricio', 'Caravantes', 'mau@correo.com', '2024-06-01','');
insert into clientes(nombre,apellido,email,create_at,foto) values('Renato', 'Melendez', 'renato@correo.com', '2024-06-01','');

--Creación de productos
insert into productos(nombre, precio, create_at) values('celular', 200, '2023-06-05');
insert into productos(nombre, precio, create_at) values('computadora', 700, '2023-06-05');
insert into productos(nombre, precio, create_at) values('smartwatch', 150, '2023-06-05');
insert into productos(nombre, precio, create_at) values('tablet', 225.50, '2023-06-05');
insert into productos(nombre, precio, create_at) values('televisor', 710.10, '2023-06-05');
insert into productos(nombre, precio, create_at) values('parlantes', 20.99, '2023-06-05');

--Creación de facturas
insert into facturas(descripcion, observaciones, cliente_id, create_at) values('Factura equipo oficina', null, 1, '2023-06-11');
insert into items_facturas(cantidad, factura_id, producto_id) values(1,1,1);
insert into items_facturas(cantidad, factura_id, producto_id) values(2,1,3);
insert into items_facturas(cantidad, factura_id, producto_id) values(3,1,2);
insert into items_facturas(cantidad, factura_id, producto_id) values(4,1,4);

insert into facturas(descripcion, observaciones, cliente_id, create_at) values('Factura equipo hogar', 'Equipo electrónico', 1, '2023-06-11');
insert into items_facturas(cantidad, factura_id, producto_id) values(1,2,1);
insert into items_facturas(cantidad, factura_id, producto_id) values(2,2,2);
insert into items_facturas(cantidad, factura_id, producto_id) values(3,2,4); 



