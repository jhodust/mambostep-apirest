insert into sedes(nombre,direccion) values ('principal','caobos');
insert into sedes(nombre,direccion) values ('alterna','villa del rosario');

insert into tipo_persona(id, tipo_persona) values (1,'alumno');
insert into tipo_persona(id, tipo_persona) values (2,'profesor');

insert into paquetes(nombre, precio, cant_clases_estandar_semana, status, has_clases_crew_latina, has_clases_crew_urbana, is_venta_publico, has_clases_ilimitadas, dias_duracion) values ('regular', '90000', '2',true, false, false, true,false,20);
insert into paquetes(nombre, precio, cant_clases_estandar_semana, status, has_clases_crew_latina, has_clases_crew_urbana, is_venta_publico, has_clases_ilimitadas, dias_duracion) values ('special pass', '120000', '3',true, false, false, true,false,10);
insert into paquetes(nombre, precio, cant_clases_estandar_semana, status, has_clases_crew_latina, has_clases_crew_urbana, is_venta_publico, has_clases_ilimitadas, dias_duracion) values ('full pass', '150000', '10',true, false, false, true, true,30);
insert into paquetes(nombre, precio, cant_clases_estandar_semana, status, has_clases_crew_latina, has_clases_crew_urbana, is_venta_publico, has_clases_ilimitadas, dias_duracion) values ('regular + crew latina', '60000', '2',true, true, false, false,false,25);
insert into paquetes(nombre, precio, cant_clases_estandar_semana, status, has_clases_crew_latina, has_clases_crew_urbana, is_venta_publico, has_clases_ilimitadas, dias_duracion) values ('regular + crew urbana', '60000', '2',true, false, true, false,false,20);
insert into paquetes(nombre, precio, cant_clases_estandar_semana, status, has_clases_crew_latina, has_clases_crew_urbana, is_venta_publico, has_clases_ilimitadas, dias_duracion) values ('full pass + crew latina + crew urbana', '150000', '10',true, true, true, false,false, 15);


insert into personas (nombre, identificacion, fecha_nacimiento, fecha_ingreso, instagram, email, telefono, nombre_acudiente, telefono_acudiente, parentesco_acudiente, id_sede, enabled, id_tipo_persona) values ('JHOCEL SUESCUN', '109050', '1997-01-03','2019-07-08','@jhocelsuescun','jhocel@gmail.com','320422','IRGEN TORRES','320312', 'madre','1',true,1);
insert into personas (nombre, identificacion, fecha_nacimiento, fecha_ingreso, instagram, email, telefono, nombre_acudiente, telefono_acudiente, parentesco_acudiente, id_sede, enabled, id_tipo_persona) values ('JUAN PEREZ', '1111', '1995-04-23','2021-05-08','@jUanperez4','juan_perez@gmail.com','31646','SOFIA DURAN','31646', 'tia','1',true,1);  
insert into personas (nombre, identificacion, fecha_nacimiento, fecha_ingreso, instagram, email, telefono, id_sede, username, password, enabled, id_tipo_persona ) values ('DANIEL RUDESS', '0000','1993-06-02','2019-09-15','@drudess','drudess@gmail.com','301467',  '1', 'drudess', '$2a$10$6vhsS.4nJcWdIESuwSzoQeOPNJIvkcoTQPV/qTHHVfSJQ3O/22mGq', true,2); 

insert into personas (nombre, identificacion, fecha_nacimiento, fecha_ingreso, instagram, email, telefono, id_sede, username, password, enabled, id_tipo_persona ) values ('JOHN SOLEDAD', '2222','1991-04-21','2019-10-12','@casso_the1','johnsoledad@gmail.com','3003464',  '1', null, null, false,2);
insert into personas (nombre, identificacion, fecha_nacimiento, fecha_ingreso, instagram, email, telefono, id_sede, username, password, enabled, id_tipo_persona ) values ('YIYI', '3333','1997-03-11','2019-03-21','@yiyi','yiyi@gmail.com','3156789',  '1', null, null, false,2);
insert into personas (nombre, identificacion, fecha_nacimiento, fecha_ingreso, instagram, email, telefono, id_sede, username, password, enabled, id_tipo_persona ) values ('GERAL ORDOÑEZ', '2222','1996-08-12','2018-06-04','@geral','geral@gmail.com','316597',  '1', null, null, false,2); 

insert into profesores (id_persona, valor_clase, pago_clases_mes) values ('4',45000,30000);
insert into profesores (id_persona, valor_clase, pago_clases_mes) values ('5',45000,30000);
insert into profesores (id_persona, valor_clase, pago_clases_mes) values ('6',25000,30000);


insert into alumnos(id_persona) values ('1');


insert into clases(nombre, status, id_profesor, id_sede) values ('danza contemporanea multinivel', true,5,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('urbano introductorio', true,4,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('bachata básico-intermedio', true,6,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('men style', true,5,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('babby ballet', true,4,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('ballet clasico', true,6,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('kizomba introductorio', true,5,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('salsa en line on 1 multinivel', true,4,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('samba', true,6,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('babys', true,5,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('junior', true,4,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('teens', true,6,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('bachata introductorio', true,5,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('salsa casino basico 1', true,4,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('salsa casino basico 2', true,6,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('k-pop multinivel', true,5,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('lady style multinivel', true,4,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('champeta multinivel', true,6,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('salsa introductorio', true,5,1);
insert into clases(nombre, status, id_profesor, id_sede) values ('twerk', true,4,1);

insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('lunes', '18:00','19:00', '1');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('viernes', '16:00','17:00', '1');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('lunes', '19:00','20:00', '2');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('lunes', '20:00','21:00', '3');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('lunes', '21:00','22:00', '4');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('martes', '15:00','16:00','5');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('jueves', '15:00','16:00', '5');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('martes', '16:00','17:00', '6');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('jueves', '16:00','17:00', '6');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('martes', '19:00','20:00', '7');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('martes', '20:00','21:00', '8');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('martes', '21:00','22:00', '9');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('miercoles', '15:00','16:00', '10');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('viernes', '15:00','16:00', '10');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('miercoles', '17:00','18:00', '11');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('viernes', '17:00','18:00', '11');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('miercoles', '18:00','19:00', '12');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('viernes', '18:00','19:00', '12');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('miercoles', '19:00','20:00', '13');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('miercoles', '20:00','21:00', '14');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('miercoles', '21:00','22:00', '15');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('jueves', '17:00','18:00', '16');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('jueves', '19:00','20:00', '17');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('jueves', '20:00','21:00', '18');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('viernes', '19:00','20:00', '19');
insert into horario_clase(dia,hora_inicio, hora_fin,id_clase) values ('viernes', '20:00','21:00', '20');




insert into mensualidades(nombre_paquete, fecha_inicio, fecha_fin, precio_paquete, precio_pactado, id_persona, has_clases_ilimitadas) values ('regular','2021-08-16','2021-08-25','90000','75000', '1', false);
insert into mensualidades(nombre_paquete, fecha_inicio, fecha_fin, precio_paquete, precio_pactado, id_persona, has_clases_ilimitadas) values ('regular','2021-09-16','2022-09-25','90000','75000', '1', false);
insert into mensualidades(nombre_paquete, fecha_inicio, fecha_fin, precio_paquete, precio_pactado, id_persona, has_clases_ilimitadas) values ('full pass','2021-07-16','2021-08-08','150000','120000', '2', true);


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