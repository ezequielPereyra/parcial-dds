CREATE TABLE Tramitante (
	id DECIMAL(8,0) AUTO_INCREMENT,
	nombre VARCHAR(20),
	apellido VARCHAR(20),
	fecha_nacimiento DATE,
	id_estado DECIMAL(8,0),
	fecha_registro DATE,
	telefono VARCHAR(30),
	apellido VARCHAR(30),
	id_provincia DECIMAL(8,0),
	id_usuario DECIMAL(8,0),
	PRIMARY KEY (id),
	FOREIGN KEY (id_estado) REFERENCES Estado_Tramitante,
	FOREIGN KEY (id_provincia) REFERENCES Provincia,
	FOREIGN KEY (id_usuario) REFERENCES Usuario
);

CREATE TABLE Estado_Tramitante(
	id DECIMAL(8,0) AUTO_INCREMENT,
	nombre VARCHAR(20),
	cantidad_aprobados DECIMAL(3,0),
	cantidad_rechazados DECIMAL(3,0),
	PRIMARY KEY (id)
);

CREATE TABLE Usuario(
	id DECIMAL(8,0) AUTO_INCREMENT,
	nombre_usuario VARCHAR(20),
	password_hash VARCHAR(50),
	es_admin BOOL,
	PRIMARY KEY (id)
);

CREATE TABLE Tramite(
	id DECIMAL(8,0) AUTO_INCREMENT,
	codigo_tramite VARCHAR(10),
	nombre VARCHAR(20),
	id_tramitante DECIMAL(8,0),
	fecha_inicializacion DATE,
	estado VARCHAR(20),
	complejidad_tramite VARCHAR(15),
	PRIMARY KEY (id),
	FOREIGN KEY (id_tramitante) REFERENCES Tramitante
);

CREATE TABLE TramitexTramite(
	id DECIMAL(8,0) AUTO_INCREMENT,
	id_tramite_requerido DECIMAL(8,0),
	id_tramite_superior DECIMAL(8,0),
	PRIMARY KEY (id),
	FOREIGN KEY (id_tramite_requerido) REFERENCES Tramite,
	FOREIGN KEY (id_tramite_superior) REFERENCES Tramite
);

CREATE TABLE TramitexValidacion(
	id DECIMAL(8,0) AUTO_INCREMENT,
	id_tramite DECIMAL(8,0),
	id_validacion DECIMAL(8,0),
	PRIMARY KEY (id),
	FOREIGN KEY (id_tramite) REFERENCES Tramite,
	FOREIGN KEY (id_validacion) REFERENCES Validacion
);

CREATE TABLE Validacion(
	id DECIMAL(8,0) AUTO_INCREMENT,
	tipo_validacion VARCHAR(20),
	antiguedad_minima DECIMAL (8,0),
	edad_minima DECIMAL(8,0),
	edad_maxima DECIMAL(8,0),
	id_provincia_requerida DECIMAL(8,0),
	PRIMARY KEY(id),
	FOREIGN KEY (id_provincia_requerida) REFERENCES Provincia
);

CREATE TABLE Provincia(
	id DECIMAL(8,0) AUTO_INCREMENT,
	nombre VARCHAR(40),
	zona_horaria VARCHAR(10),
	latitud DECIMAL(30,16),
	longitud DECIMAL(30,16),
	PRIMARY KEY(id)
);
 