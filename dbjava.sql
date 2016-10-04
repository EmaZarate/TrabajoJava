use dbjava;
create table personaje(
id int not null auto_increment,
vida varchar(50) not null,
energia varchar(50)not null,
ataque varchar(50)not null,
defensa varchar(50)not null,
evasion varchar(50)not null,
primary key(id)
) engine=InnoDB;
