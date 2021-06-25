DROP DATABASE IF EXISTS hospital;
CREATE DATABASE hospital;
USE hospital;

CREATE TABLE tipo_usuario (
    id_tipo_usuario                 INT                 NOT NULL PRIMARY KEY,
    descripcion                     VARCHAR(15)         NULL
);

CREATE TABLE usuario (
    id_usuario                      VARCHAR(5)          NOT NULL PRIMARY KEY,
    contrasena_usuario              VARCHAR(100)        NULL,
    id_tipo_usuario                 INT                 NULL,
    fecha_hora_creacion             DATETIME            NULL,
    fecha_hora_edicion              DATETIME            NULL,
    FOREIGN KEY(id_tipo_usuario)        REFERENCES tipo_usuario(id_tipo_usuario)
);

CREATE TABLE diagnostico(
    id_diagnostico                  CHAR(5)             NOT NULL    PRIMARY KEY,
    nombre_diagnostico              VARCHAR(80)         NULL,
    descripcion_diagnostico         VARCHAR(80)         NULL
);

CREATE TABLE distrito(
    id_distrito                     INT                 NOT NULL    PRIMARY KEY,
    iso_distrito                    VARCHAR(3)          NULL,
    descripcion_distrito            VARCHAR(80)         NULL
);

CREATE TABLE estado_cita (
    id_estado_cita                  INT             	NOT NULL    PRIMARY KEY auto_increment,
    descripcion_estado_cita         VARCHAR(80)         NULL
);

CREATE TABLE tipo_cita (
    id_tipo_cita                    INT		            NOT NULL    PRIMARY KEY auto_increment,
    descripcion_tipo_cita           VARCHAR(80)         NULL
);

CREATE TABLE estado_consultorio (
    id_estado_consultorio           INT		            NOT NULL    PRIMARY KEY auto_increment,
    descripcion_estado_consultorio  VARCHAR(80)         NULL
);

CREATE TABLE consultorio (
    id_consultorio                  CHAR(5)             NOT NULL    PRIMARY KEY,
    descripcion_consultorio         VARCHAR(80)         NULL,
    id_estado_consultorio           INT             	NULL,
    FOREIGN KEY(id_estado_consultorio)  REFERENCES estado_consultorio(id_estado_consultorio)
);

CREATE TABLE especialidad (
    id_especialidad                 INT             	NOT NULL    PRIMARY KEY auto_increment,
    descripcion_especialidad        VARCHAR(80)         NULL
);

CREATE TABLE estado_personal (
    id_estado_personal              INT		            NOT NULL    PRIMARY KEY auto_increment,
    descripcion_estado_personal     VARCHAR(80)         NULL
);

CREATE TABLE personal (
    id_personal                     CHAR(5)             NOT NULL    PRIMARY KEY,
    nombre_personal                 VARCHAR(80)         NULL,
    telefono_personal               VARCHAR(20)         NULL,
    direccion_personal              VARCHAR(80)         NULL,
    email_personal                  VARCHAR(80)         NULL,
    telefono_emergencia             VARCHAR(20)         NULL,
    fecha_nacimiento                VARCHAR(20)			NULL,
    id_usuario                  	VARCHAR(5)          NULL,
    id_especialidad                 INT           		NULL,
    id_estado_personal              INT		            NULL,
    FOREIGN KEY (id_especialidad)       REFERENCES especialidad (id_especialidad),
    FOREIGN KEY (id_estado_personal)    REFERENCES estado_personal (id_estado_personal),
    FOREIGN KEY (id_usuario)            REFERENCES usuario (id_usuario)
);

CREATE TABLE paciente (
    id_paciente                     CHAR(5)             NOT NULL    PRIMARY KEY,
    nombre_paciente                 VARCHAR(80)         NULL,
    apellidos_paciente              VARCHAR(80)         NULL,
    direccion_paciente              VARCHAR(80)         NULL,
    fecha_cumpleanos                DATE                NULL,
    fecha_muerte                    DATE                NULL        DEFAULT NULL,
    telefono_paciente               VARCHAR(20)         NULL,
    sexo_paciente                   VARCHAR(20)         NULL,
    talla_paciente                  FLOAT               NULL,
    peso_paciente                   FLOAT               NULL,
    clave_paciente                  VARCHAR(100)        NULL,
    id_distrito                     INT                 NULL,
    FOREIGN KEY (id_distrito)           REFERENCES distrito (id_distrito)
);

CREATE TABLE cita (
    id_cita                         CHAR(5)             NOT NULL    PRIMARY KEY,
    fecha_creacion                  DATETIME            NULL,
    id_paciente                     CHAR(5)             NULL,
    id_tipo_cita                    INT             	NULL,
    id_estado_cita                  INT             	NULL,
    id_consultorio                  CHAR(5)             NULL,
    id_personal                     CHAR(5)             NULL,
    FOREIGN KEY(id_paciente)            REFERENCES paciente(id_paciente),
    FOREIGN KEY(id_tipo_cita)           REFERENCES tipo_cita(id_tipo_cita),
    FOREIGN KEY(id_estado_cita)         REFERENCES estado_cita(id_estado_cita),
    FOREIGN KEY(id_consultorio)         REFERENCES consultorio(id_consultorio),
    FOREIGN KEY(id_personal)            REFERENCES personal(id_personal)
);

CREATE TABLE entrada_personal (
    id_entrada_personal             CHAR(5)             NOT NULL    PRIMARY KEY,
    hora_entrada                    VARCHAR(45)         NULL,
    fecha_entrada                   DATETIME            NULL,
    id_personal                     CHAR(5)             NULL,
    FOREIGN KEY(id_personal)            REFERENCES personal(id_personal)
);

CREATE TABLE estado_medicamento (
    id_estado_medicamento           INT             	NOT NULL    PRIMARY KEY auto_increment,
    descripcion_estado_medicamento  VARCHAR(80)         NULL
);

CREATE TABLE excusa (
    id_excusa                       CHAR(5)             NOT NULL    PRIMARY KEY,
    descripcion_excusa              VARCHAR(80)         NULL,
    fecha_creacion                  DATETIME            NULL,
    id_paciente                     CHAR(5)             NULL,
    id_personal                     CHAR(5)             NULL,
    FOREIGN KEY(id_paciente)            REFERENCES paciente(id_paciente),
    FOREIGN KEY(id_personal)            REFERENCES personal(id_personal)
);

CREATE TABLE excusa_diagnostico (
    id_excusa                       CHAR(5)             NULL,
    id_diagnostico                  CHAR(5)             NULL,
    FOREIGN KEY (id_excusa)             REFERENCES excusa (id_excusa),
    FOREIGN KEY (id_diagnostico)        REFERENCES diagnostico (id_diagnostico)
);

CREATE TABLE formula (
    id_formula                      CHAR(5)             NOT NULL    PRIMARY KEY,
    id_paciente                     CHAR(5)             NULL,
    id_personal                     CHAR(5)             NULL,
    FOREIGN KEY (id_paciente)           REFERENCES paciente (id_paciente),
    FOREIGN KEY (id_personal)           REFERENCES personal (id_personal)
);

CREATE TABLE medicamento (
    id_medicamento                  CHAR(5)             NOT NULL    PRIMARY KEY,
    nombre_medicamento              VARCHAR(80)         NULL,
    marca_medicamento               VARCHAR(80)         NULL,
    id_estado_medicamento           INT             	NULL,
    FOREIGN KEY (id_estado_medicamento) REFERENCES estado_medicamento (id_estado_medicamento)
);


CREATE TABLE formula_medicamento (
    id_formula                      CHAR(5)             NULL,
    id_medicamento                  CHAR(5)             NULL,
    cantidad_medicamento_formula    INT                 NULL,
    FOREIGN KEY (id_formula)            REFERENCES formula (id_formula),
    FOREIGN KEY (id_medicamento)        REFERENCES medicamento (id_medicamento)
);

CREATE TABLE historia (
    id_historia                     CHAR(5)             NOT NULL    PRIMARY KEY,
    id_cita                         CHAR(5)             NULL,
    FOREIGN KEY (id_cita) REFERENCES cita (id_cita)
);

CREATE TABLE historia_diagnostico (
    id_historia                     CHAR(5)             NULL,
    id_diagnostico                  CHAR(5)             NULL,
    FOREIGN KEY (id_historia)           REFERENCES historia (id_historia),
    FOREIGN KEY (id_diagnostico)        REFERENCES diagnostico (id_diagnostico)
);

CREATE TABLE historia_personal (
    id_historia                     CHAR(5)             NULL,
    id_personal                     CHAR(5)             NULL,
    FOREIGN KEY (id_historia)           REFERENCES historia (id_historia),
    FOREIGN KEY (id_personal)           REFERENCES personal (id_personal)
);

CREATE TABLE presentacion (
    id_presentacion                 CHAR(5)             NOT NULL    PRIMARY KEY,
    nombre_presentacion             VARCHAR(80)         NULL,
    cantidad_presentacion           VARCHAR(80)         NULL
);


CREATE TABLE medicamento_presentacion (
    id_medicamento                  CHAR(5)             NULL,
    id_presentacion                 CHAR(5)             NULL,
    FOREIGN KEY (id_medicamento)        REFERENCES medicamento (id_medicamento),
    FOREIGN KEY (id_presentacion)       REFERENCES presentacion (id_presentacion)
);

CREATE TABLE proveedor (
    id_proveedor                    CHAR(5)             NOT NULL    PRIMARY KEY,
    nombre_proveedor                VARCHAR(80)         NULL,
    contacto_proveedor              VARCHAR(80)         NULL,
    direccion_proveedor             VARCHAR(80)         NULL,
    telefono_proveedor              VARCHAR(20)         NULL,
    email_proveedor                 VARCHAR(80)         NULL
);

CREATE TABLE medicamento_proveedor (
    id_medicamento_proveedor        CHAR(5)             NOT NULL    PRIMARY KEY,
    cantidad_medicamento            INT                 NULL,
    lote_medicamento                VARCHAR(80)         NULL,
    fecha_vencimiento               DATE                NULL,
    id_medicamento                  CHAR(5)             NULL,
    id_proveedor                    CHAR(5)             NULL,
    FOREIGN KEY (id_medicamento)        REFERENCES medicamento (id_medicamento),
    FOREIGN KEY (id_proveedor)          REFERENCES proveedor (id_proveedor)
);

CREATE TABLE salida_personal (
    id_salida_personal              CHAR(5)             NOT NULL    PRIMARY KEY,
    hora_salida                     VARCHAR(45)         NULL,
    fecha_salida                    DATETIME            NULL,
    id_personal                     CHAR(5)             NULL,
    FOREIGN KEY(id_personal)            REFERENCES personal (id_personal)
);


/* --------------------- INSERT DATA --------------------- */

-- INSERT DATA - distrito
INSERT INTO distrito VALUES(1,'LIM', 'Cercado de Lima');
INSERT INTO distrito VALUES(2,'ATE', 'Ate');
INSERT INTO distrito VALUES(3,'BAR', 'Barranco');
INSERT INTO distrito VALUES(4,'BRE', 'Breña');
INSERT INTO distrito VALUES(5,'COM', 'Comas');
INSERT INTO distrito VALUES(6,'CHO', 'Chorrillos');
INSERT INTO distrito VALUES(7,'AGU', 'El Agustino');
INSERT INTO distrito VALUES(8,'JMA', 'Jesús María');
INSERT INTO distrito VALUES(9,'MOL', 'La Molina');
INSERT INTO distrito VALUES(10,'VIC', 'La Victoria');
INSERT INTO distrito VALUES(11,'LIN', 'Lince');
INSERT INTO distrito VALUES(12,'MAG', 'Magdalena del Mar');
INSERT INTO distrito VALUES(13,'MIR', 'Miraflores');
INSERT INTO distrito VALUES(14,'PLI', 'Pueblo Libre');
INSERT INTO distrito VALUES(15,'PPI', 'Puente Piedra');
INSERT INTO distrito VALUES(16,'RIM', 'Rimac');
INSERT INTO distrito VALUES(17,'ISI', 'San Isidro');
INSERT INTO distrito VALUES(18,'IND', 'Independencia');
INSERT INTO distrito VALUES(19,'SJM', 'San Juan de Miraflores');
INSERT INTO distrito VALUES(20,'SLU', 'San Luis');
INSERT INTO distrito VALUES(21,'SMP', 'San Martin de Porres');
INSERT INTO distrito VALUES(22,'SMI', 'San Miguel');
INSERT INTO distrito VALUES(23,'SDS', 'Santiago de Surco');
INSERT INTO distrito VALUES(24,'SUR', 'Surquillo');
INSERT INTO distrito VALUES(25,'VMT', 'Villa María del Triunfo');
INSERT INTO distrito VALUES(26,'SJL', 'San Juan de Lurigancho');
INSERT INTO distrito VALUES(27,'SRO', 'Santa Rosa');
INSERT INTO distrito VALUES(28,'OLI', 'Los Olivos');
INSERT INTO distrito VALUES(29,'SBO', 'San Borja');
INSERT INTO distrito VALUES(30,'VES', 'Villa El Savador');
INSERT INTO distrito VALUES(31,'SAN', 'Santa Anita');

-- INSERT DATA - estado_cita
INSERT INTO estado_cita VALUES(1,'creada');
INSERT INTO estado_cita VALUES(2,'confirmada');
INSERT INTO estado_cita VALUES(3,'atendida');
INSERT INTO estado_cita VALUES(5,'cancelada');
INSERT INTO estado_cita VALUES(4,'expirada');

-- INSERT DATA - proveedor

INSERT INTO proveedor VALUES ('PRO01','Pepe','Medicamentos LULU','Petituars KM10.5','983123567','Pepe@gmail.com');
INSERT INTO proveedor VALUES ('PRO02','Luis','Centro de Medicina Forense',' Avenida V�ctor Andr�s Bela�nde., 147','923523522','Luis@gmail.com');
INSERT INTO proveedor VALUES ('PRO03','Jose','Alibaba','Jir�n Washington, 1080','098312312','Jose@gmail.com');
INSERT INTO proveedor VALUES ('PRO04','Ana','Medicamentos Importados SAC'     ,'psje cesar vallejo moche','984091724','Ana@gmail.com');
INSERT INTO proveedor VALUES ('PRO05','Patricio'  ,'Lulu Tons Pastillas A','Avenida Grimaldo Del Solar, 236, Tda.103','980918321','Patricio@gmail.com');
INSERT INTO proveedor VALUES ('PRO06','Maricarmen','Phone Town Past','Calle Donatello, 206','901832181','Maricarmen@gmail.com');
INSERT INTO proveedor VALUES ('PRO07','Jazmin','DirecX ','Gral. Prado N 869-873','909001293','Jazmin@gmail.com');
INSERT INTO proveedor VALUES ('PRO08','Erika','John and Jhonson','Calle Castilla La Vieja, 734, Of. 101','903812081','Erika@gmail.com');
INSERT INTO proveedor VALUES ('PRO09','Raul','Sinofarm','Avenida Intihuatana, 707','954964645','Raul@gmail.com');
INSERT INTO proveedor VALUES ('PRO10','Ubaldo','PepeCox Tomorw','Avenida Guardia Civil Sur, 1053, Edif. A Dpto.504','983012830','Ubaldo@gmail.com');



-- CREATING USER STORE PROCEDURES
-- INSERT DATA - tipo_usuario
INSERT INTO tipo_usuario VALUES(1,'Administrador');
INSERT INTO tipo_usuario VALUES(2,'Doctor/a');
INSERT INTO tipo_usuario VALUES(3,'Enfermera/o');

-- INSERT DATA - especialidad
INSERT INTO especialidad(descripcion_especialidad) VALUES('CARDIÓLOGO');

-- INSERT DATA - estado_personal
-- INSERT INTO estado_personal(descripcion_estado_personal) VALUES('contratado');

-- INSERT DATA - usuario
INSERT INTO usuario VALUES('U0001','a4a97ffc170ec7ab32b85b2129c69c50',2, '1990-09-15 17:14:12',NULL);

-- INSERT DATA - personal
/*INSERT INTO personal VALUES('P0001', 'Dennis Villagaray','999999999', 'Av. simpre viva','dennis@demo.com',null,'1999/12/12','U0001', 1 ,1);
INSERT INTO personal VALUES('P0002', 'Demo ','999999999', 'Av. simpre viva','demo@demo.com',null,'1999/12/12',null, 1,1);
INSERT INTO personal VALUES('P0003', 'Dennis Villagaray','999999999', 'Av. simpre viva','dennis@consultaexterna.com',null,'1999/12/12','U0001', 1,1);
*/

/* --------------------- PROCEDURES --------------------- */

-- <BEGIN> PERSONAL STORE PROCEDURES
DROP PROCEDURE IF EXISTS usp_listByPersonalState;
DELIMITER $$
CREATE PROCEDURE usp_listByPersonalState(id CHAR(5)) BEGIN
SELECT 	p.id_personal,
		p.nombre_personal,
        p.telefono_personal,
        p.direccion_personal,
        p.email_personal,
        p.telefono_emergencia,
        p.fecha_nacimiento,
        p.clave_personal,
        e.descripcion_especialidad,
        ep.descripcion_estado_personal
FROM personal p
INNER JOIN estado_personal ep
ON p.id_estado_personal = ep.id_estado_personal
INNER JOIN especialidad e
ON p.id_especialidad = e.id_especialidad
WHERE ep.id_estado_personal = id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_listPersonal;
DELIMITER $$
CREATE PROCEDURE usp_listPersonal() BEGIN
SELECT 	p.id_personal,
		p.nombre_personal,
        p.telefono_personal,
        p.direccion_personal,
        p.email_personal,
        p.telefono_emergencia,
        p.fecha_nacimiento,
        u.id_usuario,
        e.descripcion_especialidad,
        ep.descripcion_estado_personal
FROM personal p
LEFT JOIN estado_personal ep
ON p.id_estado_personal = ep.id_estado_personal
LEFT JOIN especialidad e
ON p.id_especialidad = e.id_especialidad
LEFT JOIN usuario u
ON p.id_usuario = u.id_usuario;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_listBySpeciality;
DELIMITER $$
CREATE PROCEDURE usp_listBySpeciality(id CHAR(5)) BEGIN
SELECT 	p.id_personal,
		p.nombre_personal,
        p.telefono_personal,
        p.direccion_personal,
        p.email_personal,
        p.telefono_emergencia,
        p.fecha_nacimiento,
        u.id_usuario,
        e.descripcion_especialidad,
        ep.descripcion_estado_personal
FROM personal p
INNER JOIN estado_personal ep
ON p.id_estado_personal = ep.id_estado_personal
INNER JOIN especialidad e
ON p.id_especialidad = e.id_especialidad
WHERE ep.id_especialidad = id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_addPersonal;
DELIMITER $$
CREATE PROCEDURE usp_addPersonal(idP CHAR(5),
nameP VARCHAR(80), phoneP VARCHAR(20),
directionP VARCHAR(80), emailP VARCHAR(80),
emergencyPhoneP VARCHAR(20), birthP VARCHAR(20),
idUserP VARCHAR(100), descEspP VARCHAR(80),
descStateP VARCHAR(80))
BEGIN
INSERT INTO personal VALUES (idP,
nameP, phoneP,
directionP, emailP,
emergencyPhoneP, birthP,
idUserP, (SELECT id_especialidad FROM especialidad WHERE descripcion_especialidad = descEspP),
(SELECT id_estado_personal FROM estado_personal WHERE descripcion_estado_personal = descStateP));
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_updatePersonal;
DELIMITER $$
CREATE PROCEDURE usp_updatePersonal(idP CHAR(5),
nameP VARCHAR(80), phoneP VARCHAR(20),
directionP VARCHAR(80), emailP VARCHAR(80),
emergencyPhoneP VARCHAR(20), birthP VARCHAR(80),
idUserP VARCHAR(100), descEspP VARCHAR(80),
descStateP VARCHAR(80))
BEGIN
UPDATE personal SET nombre_personal = nameP, telefono_personal = phoneP,
direccion_personal = directionP, email_personal = emailP,
telefono_emergencia = emergencyPhoneP, fecha_nacimiento = birthP,
id_usuario = idUserP,
id_especialidad = (SELECT id_especialidad FROM especialidad WHERE descripcion_especialidad = descEspP),
id_estado_personal = (SELECT id_estado_personal FROM estado_personal WHERE descripcion_estado_personal = descStateP)
WHERE id_personal = idP;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_listByPersonalName;
DELIMITER $$
CREATE PROCEDURE usp_listByPersonalName(personal_name VARCHAR(100)) BEGIN
SELECT 	p.id_personal,
		p.nombre_personal,
        p.telefono_personal,
        p.direccion_personal,
        p.email_personal,
        p.telefono_emergencia,
        p.fecha_nacimiento,
        u.id_usuario,
        e.descripcion_especialidad,
        ep.descripcion_estado_personal
FROM personal p
LEFT JOIN estado_personal ep
ON p.id_estado_personal = ep.id_estado_personal
LEFT JOIN especialidad e
ON p.id_especialidad = e.id_especialidad
LEFT JOIN usuario u
ON p.id_usuario = u.id_usuario
WHERE p.nombre_personal LIKE CONCAT('%',personal_name,'%');
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_getPersonalIdAutomatically;
DELIMITER $$
CREATE PROCEDURE usp_getPersonalIdAutomatically() BEGIN
	IF((SELECT COUNT(*) FROM personal) = 0) THEN
		SELECT 'P0001';
    ELSE
		SELECT CONCAT('P', LPAD(SUBSTRING((SELECT MAX(id_personal) FROM personal), 4) + 1, 4, '0')) FROM personal;
	END IF;
END $$
DELIMITER ;
-- <END> PERSONAL STORE PROCEDURES

-- <BEGIN> USER STORE PROCEDURES
DROP PROCEDURE IF EXISTS sp_register_usuario;
DELIMITER $$
CREATE PROCEDURE sp_register_usuario(personalCode VARCHAR(5),userId VARCHAR(5),userPassword VARCHAR(100), userType INT, userCreationDate DATETIME)
BEGIN
INSERT INTO usuario VALUES(userId,userPassword,userType,userCreationDate, NULL);
UPDATE personal
	SET
    id_usuario = userId
    WHERE id_personal = personalCode;    
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_validate_usuario;
DELIMITER $$
CREATE PROCEDURE sp_validate_usuario(userCode VARCHAR(5), userPas VARCHAR(100)) BEGIN
    SELECT * FROM usuario WHERE id_usuario = userCode AND contrasena_usuario = userPas;
END $$
DELIMITER ;
-- <END> USER STORE PROCEDURES

-- <BEGIN> SPECIALITY STORE PROCEDURES
DROP PROCEDURE IF EXISTS usp_listSpeciality;
DELIMITER $$
CREATE PROCEDURE usp_listSpeciality() BEGIN
	SELECT id_especialidad, descripcion_especialidad
	FROM especialidad;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_addSpeciality;
DELIMITER $$
CREATE PROCEDURE usp_addSpeciality(descriptionS VARCHAR(80)) BEGIN
	INSERT INTO especialidad(descripcion_especialidad)
	VALUES (descriptionS);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_generatePersonalIndex;
DELIMITER $$
CREATE PROCEDURE usp_generatePersonalIndex() BEGIN
	SELECT CONCAT(SUBSTRING('P0000', 3), COUNT(*)) FROM personal;
END $$
DELIMITER ;
-- <END> SPECIALITY STORE PROCEDURES

-- <BEGIN> PERSONAL STATE STORE PROCEDURES
DROP PROCEDURE IF EXISTS usp_listPersonalState;
DELIMITER $$
CREATE PROCEDURE usp_listPersonalState() BEGIN
	SELECT id_estado_personal, descripcion_estado_personal
	FROM estado_personal;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_addPersonalState;
DELIMITER $$
CREATE PROCEDURE usp_addPersonalState(descriptionP VARCHAR(80)) BEGIN
	INSERT INTO estado_personal(descripcion_estado_personal)
	VALUES (descriptionP);
END $$
DELIMITER ;
-- <END> PERSONAL STATE STORE PROCEDURES

-- <BEGIN> APPOINTMENT STATE STORE PROCEDURES
DROP PROCEDURE IF EXISTS usp_listAppointmentState;
DELIMITER $$
CREATE PROCEDURE usp_listAppointmentState() BEGIN
	SELECT id_estado_cita, descripcion_estado_cita
	FROM estado_cita;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_addAppointmentState;
DELIMITER $$
CREATE PROCEDURE usp_addAppointmentState(descriptionA VARCHAR(80)) BEGIN
	INSERT INTO estado_cita(descripcion_estado_cita)
	VALUES (descriptionA);
END $$
DELIMITER ;
-- <END> APPOINTMENT STATE STORE PROCEDURES

-- <BEGIN> APPOINTMENT TYPE STORE PROCEDURES
DROP PROCEDURE IF EXISTS usp_listAppointmentType;
DELIMITER $$
CREATE PROCEDURE usp_listAppointmentType() BEGIN
	SELECT id_tipo_cita, descripcion_tipo_cita
	FROM tipo_cita;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_addAppointmentType;
DELIMITER $$
CREATE PROCEDURE usp_addAppointmentType(descriptionA VARCHAR(80)) BEGIN
	INSERT INTO tipo_cita(descripcion_tipo_cita)
	VALUES (descriptionA);
END $$
DELIMITER ;
-- <END> APPOINTMENT TYPE STORE PROCEDURES

-- <BEGIN> ROOM STATE STORE PROCEDURES
DROP PROCEDURE IF EXISTS usp_listRoomState;
DELIMITER $$
CREATE PROCEDURE usp_listRoomState() BEGIN
	SELECT id_estado_consultorio, descripcion_estado_consultorio
	FROM estado_consultorio;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_addRoomState;
DELIMITER $$
CREATE PROCEDURE usp_addRoomState(descriptionR VARCHAR(80)) BEGIN
	INSERT INTO estado_consultorio(descripcion_estado_consultorio)
	VALUES (descriptionR);
END $$
DELIMITER ;
-- <END> ROOM STATE STORE PROCEDURES

-- <BEGIN> MEDICATION STATE STORE PROCEDURES
DROP PROCEDURE IF EXISTS usp_listMedicationState;
DELIMITER $$
CREATE PROCEDURE usp_listMedicationState() BEGIN
	SELECT id_estado_medicamento, descripcion_estado_medicamento
	FROM estado_medicamento;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_addMedicationState;
DELIMITER $$
CREATE PROCEDURE usp_addMedicationState(descriptionM VARCHAR(80)) BEGIN
	INSERT INTO estado_medicamento(descripcion_estado_medicamento)
	VALUES (descriptionM);
END $$
DELIMITER ;
-- <END> MEDICATION STATE STORE PROCEDURES

-- QUERIES

SELECT SUBSTRING(MAX(id_usuario),2) FROM usuario;
CALL sp_validate_usuario('U0001','a4a97ffc170ec7ab32b85b2129c69c50');

-- PROCEDURE proveedor

CREATE PROCEDURE usp_listsupplier()
select  p.id_proveedor,
p.nombre_proveedor,
p.contacto_proveedor,
p.direccion_proveedor,
p.telefono_proveedor,
p.email_proveedor
 from proveedor p;
 call usp_listsupplier();

 
select * from proveedor where nombre_proveedor like "%P%" ; -- EDITAR
-- INSERT DATA - proveedor
INSERT INTO proveedor VALUES ('PRO11','AAAAA','BBBBBBBBB','CCCCCCCCCCC','908109328','FFFFFFFF@gmail.com');
-- DELETE DATA - proveedor
delete from proveedor where id_proveedor= 'PRO11';
-- SEARCH DATA- proveedor
select  * from proveedor where id_proveedor = 'PRO01';
-- UPDATE DATA -proveedor
CREATE PROCEDURE usp_update(idp CHAR(5),namep VARCHAR(80),contactp VARCHAR(80),directp VARCHAR(80),phonep VARCHAR(20),emailp VARCHAR(80))
update proveedor set   nombre_proveedor= namep,contacto_proveedor=contactp,direccion_proveedor=directp,telefono_proveedor=phonep,email_proveedor=emailp
where id_proveedor= idp ;


