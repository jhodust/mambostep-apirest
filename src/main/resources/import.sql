insert into sedes(nombre,direccion) values ('principal','caobos');

insert into paquetes(nombre, precio, cant_clases_semana, status) values ('regular', '90000', '2',true);
insert into paquetes(nombre, precio, cant_clases_semana, status) values ('special pass', '120000', '3',true);
insert into paquetes(nombre, precio, cant_clases_semana, status) values ('full pass', '150000', '10',true);

insert into clases(nombre, status) values ('danza contemporanea multinivel', true);
insert into clases(nombre, status) values ('urbano introductorio', true);
insert into clases(nombre, status) values ('bachata básico-intermedio', true);
insert into clases(nombre, status) values ('men style', true);
insert into clases(nombre, status) values ('babby ballet', true);
insert into clases(nombre, status) values ('ballet clasico', true);
insert into clases(nombre, status) values ('kizomba introductorio', true);
insert into clases(nombre, status) values ('salsa en line on 1 multinivel', true);
insert into clases(nombre, status) values ('samba', true);
insert into clases(nombre, status) values ('babys', true);
insert into clases(nombre, status) values ('junior', true);
insert into clases(nombre, status) values ('teens', true);
insert into clases(nombre, status) values ('bachata introductorio', true);
insert into clases(nombre, status) values ('salsa casino basico 1', true);
insert into clases(nombre, status) values ('salsa casino basico 2', true);
insert into clases(nombre, status) values ('k-pop multinivel', true);
insert into clases(nombre, status) values ('lady style multinivel', true);
insert into clases(nombre, status) values ('champeta multinivel', true);
insert into clases(nombre, status) values ('salsa introductorio', true);
insert into clases(nombre, status) values ('twerk', true);

insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('lunes', '18:00','19:00', true, '1');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('viernes', '16:00','17:00', true, '1');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('lunes', '19:00','20:00', true, '2');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('lunes', '20:00','21:00', true, '3');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('lunes', '21:00','22:00', true, '4');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('martes', '15:00','16:00', true, '5');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('jueves', '15:00','16:00', true, '5');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('martes', '16:00','17:00', true, '6');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('jueves', '16:00','17:00', true, '6');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('martes', '19:00','20:00', true, '7');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('martes', '20:00','21:00', true, '8');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('martes', '21:00','22:00', true, '9');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('miercoles', '15:00','16:00', true, '10');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('viernes', '15:00','16:00', true, '10');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('miercoles', '17:00','18:00', true, '11');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('viernes', '17:00','18:00', true, '11');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('miercoles', '18:00','19:00', true, '12');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('viernes', '18:00','19:00', true, '12');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('miercoles', '19:00','20:00', true, '13');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('miercoles', '20:00','21:00', true, '14');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('miercoles', '21:00','22:00', true, '15');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('jueves', '17:00','18:00', true, '16');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('jueves', '19:00','20:00', true, '17');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('jueves', '20:00','21:00', true, '18');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('viernes', '19:00','20:00', true, '19');
insert into horario_clase(dia,hora_inicio, hora_fin,status,id_clase) values ('viernes', '20:00','21:00', true, '20');


insert into personas (nombre, identificacion, fecha_nacimiento, fecha_ingreso, instagram, email, telefono, nombre_acudiente, telefono_acudiente, parentesco_acudiente, id_sede, enabled) values ('JHOCEL SUESCUN', '109050', '1997-01-03','2019-07-08','@jhocelsuescun','jhocel@gmail.com','320422','IRGEN TORRES','320312', 'madre','1',true);
insert into personas (nombre, identificacion, fecha_nacimiento, fecha_ingreso, instagram, email, telefono, nombre_acudiente, telefono_acudiente, parentesco_acudiente, id_sede, enabled) values ('JUAN PEREZ', '1111', '1995-04-23','2021-05-08','@jUanperez4','juan_perez@gmail.com','31646','SOFIA DURAN','31646', 'tia','1',true);  
insert into personas (nombre, identificacion, fecha_nacimiento, fecha_ingreso, instagram, email, telefono, id_sede, username, password, enabled ) values ('DANIEL RUDESS', '0000','1993-06-02','2019-09-15','@drudess','drudess@gmail.com','301467',  '1', 'drudess', '$2a$10$6vhsS.4nJcWdIESuwSzoQeOPNJIvkcoTQPV/qTHHVfSJQ3O/22mGq', true); 

insert into mensualidades(nombre_paquete, fecha_inicio, fecha_fin, precio_paquete, precio_pactado, id_persona) values ('regular','2021-08-16','2021-08-25','90000','75000', '1');
insert into mensualidades(nombre_paquete, fecha_inicio, fecha_fin, precio_paquete, precio_pactado, id_persona) values ('regular','2021-09-16','2021-09-25','90000','75000', '1');
insert into mensualidades(nombre_paquete, fecha_inicio, fecha_fin, precio_paquete, precio_pactado, id_persona) values ('full pass','2021-07-16','2021-08-08','150000','120000', '2');


insert into mensualidad_clases (id_clase, id_mensualidad) values ('8','1');
insert into mensualidad_clases (id_clase, id_mensualidad) values ('9','1');

insert into mensualidad_clases (id_clase, id_mensualidad) values ('14','2');
insert into mensualidad_clases (id_clase, id_mensualidad) values ('15','2');

insert into mensualidad_clases (id_clase, id_mensualidad) values ('2','3');
insert into mensualidad_clases (id_clase, id_mensualidad) values ('3','3');
insert into mensualidad_clases (id_clase, id_mensualidad) values ('4','3');
insert into mensualidad_clases (id_clase, id_mensualidad) values ('7','3');
insert into mensualidad_clases (id_clase, id_mensualidad) values ('8','3');

insert into roles (authority) values ('ROLE_ADMIN');

insert into personas_roles (id_persona,id_role) values ('2','1');