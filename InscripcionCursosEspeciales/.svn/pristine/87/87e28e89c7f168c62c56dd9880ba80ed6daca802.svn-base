create table periodos
(
    consecutivo     varchar2(4),
    codigo          varchar2(10),
    desde           date,
    hasta           date,
    institution     varchar2(5),
    acad_career     varchar2(4)
);

COMMENT ON COLUMN periodos.consecutivo IS 'Consecutivo del periodo en PeopleSoft';    
COMMENT ON COLUMN periodos.codigo IS 'Descripción';         
COMMENT ON COLUMN periodos.desde IS 'Fecha de inicio';          
COMMENT ON COLUMN periodos.hasta IS 'Fecha de fin';          
COMMENT ON COLUMN periodos.institution IS 'Código de la institución';    
COMMENT ON COLUMN periodos.acad_career IS 'Grado académico';

insert into PERIODOS values('0920', '20131', to_date('2013-01-01','YYYY-MM-DD'), to_date('2013-06-30','YYYY-MM-DD'),'PUJCL','UGRD');
insert into PERIODOS values('0925', '20132', to_date('2013-07-01','YYYY-MM-DD'), to_date('2013-12-30','YYYY-MM-DD'),'PUJCL','UGRD');

CREATE  TABLE CARRERAS 
(
  CODIGO                           NUMBER NOT NULL,
  DESCRIPCION                      VARCHAR2(500) NOT NULL,
  CONSTRAINT CARRERAS_PK PRIMARY KEY ( CODIGO ) 
);

COMMENT ON COLUMN CARRERAS.CODIGO IS 'Código de la carrera';
COMMENT ON COLUMN CARRERAS.DESCRIPCION IS 'Descripción de la carrera.';

INSERT INTO CARRERAS  VALUES(70,'Administración de Empresas');
INSERT INTO CARRERAS  VALUES(10001,'Matemáticas Aplicadas');
INSERT INTO CARRERAS  VALUES(12004,'Arquitectura');
INSERT INTO CARRERAS  VALUES(71,'Economía');
INSERT INTO CARRERAS  VALUES(20,'Ingeniería Civil');
INSERT INTO CARRERAS  VALUES(40,'Ingeniería de Sistemas');
INSERT INTO CARRERAS  VALUES(30,'Ingeniería Electrónica');
INSERT INTO CARRERAS  VALUES(10,'Ingeniería Industrial');
INSERT INTO CARRERAS VALUES(13000,'Medicina');
INSERT INTO CARRERAS  VALUES(11001,'Negocios Internacionales');


CREATE  TABLE ESTUDIANTES 
(
  NOMBRE                           VARCHAR2(500) NOT NULL,
  APELLIDO                         VARCHAR2(500) NOT NULL,
  CEDULA                           VARCHAR2(500) NOT NULL,
  FECHA_NACIMIENTO                 DATE,
  CARRERA_CODIGO                   NUMBER,
  ACTIVO                           NUMBER,
  CONSTRAINT EST_CAR_FK FOREIGN KEY (CARRERA_CODIGO) REFERENCES CARRERAS(CODIGO)
);

COMMENT ON COLUMN ESTUDIANTES.APELLIDO IS 'Apellido del estudiante.';
COMMENT ON COLUMN ESTUDIANTES.CARRERA IS 'Carrera del estudiante.';
COMMENT ON COLUMN ESTUDIANTES.CEDULA IS 'Identificación del estudiante.';
COMMENT ON COLUMN ESTUDIANTES.FECHA_NACIMIENTO IS 'Fecha de nacimiento del estudiante.';
COMMENT ON COLUMN ESTUDIANTES.NOMBRE IS 'Nombre del estudiante.';

insert into ESTUDIANTES values ('Andrés', 'Meza Escallón', '94410847', to_date('1980-02-24','YYYY-MM-DD'), 40, 1);
insert into ESTUDIANTES values ('Fred', 'Flintstone', '8754326', to_date('1960-08-20','YYYY-MM-DD'), 71, 1);
insert into ESTUDIANTES values ('Homer', 'Simpson', '482513', to_date('1970-03-14','YYYY-MM-DD'), 13000, 1);
commit;
