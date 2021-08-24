CREATE TABLE IF NOT EXISTS Provincia(
	id INT AUTO_INCREMENT,
	nombre VARCHAR(40),
	zona_horaria VARCHAR(10),
	latitud DECIMAL(30,16),
	longitud DECIMAL(30,16),
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Estado_Tramitante(
	id INT AUTO_INCREMENT,
	nombre VARCHAR(20),
	cantidad_aprobados DECIMAL(3,0),
	cantidad_rechazados DECIMAL(3,0),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Usuario(
	id INT AUTO_INCREMENT,
	nombre_usuario VARCHAR(20),
	password_hash VARCHAR(50),
	es_admin BOOL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Tramitante (
	id INT AUTO_INCREMENT,
	nombre VARCHAR(20),
	fecha_nacimiento DATE,
	id_estado INT,
	fecha_registro DATE,
	telefono VARCHAR(30),
	apellido VARCHAR(30),
	id_provincia INT,
	id_usuario INT,
	PRIMARY KEY (id),
	FOREIGN KEY (id_estado) REFERENCES Estado_Tramitante (id),
	FOREIGN KEY (id_provincia) REFERENCES Provincia (id),
	FOREIGN KEY (id_usuario) REFERENCES Usuario (id)
);


CREATE TABLE IF NOT EXISTS Tramite(
	id INT AUTO_INCREMENT,
	codigo_tramite VARCHAR(10),
	nombre VARCHAR(20),
	id_tramitante INT,
	fecha_inicializacion DATE,
	estado VARCHAR(20),
	complejidad_tramite VARCHAR(15),
	PRIMARY KEY (id),
	FOREIGN KEY (id_tramitante) REFERENCES Tramitante (id)
);

CREATE TABLE IF NOT EXISTS Validacion(
	id INT AUTO_INCREMENT,
	tipo_validacion VARCHAR(20),
	antiguedad_minima DECIMAL (8,0),
	edad_minima DECIMAL(8,0),
	edad_maxima DECIMAL(8,0),
	id_provincia_requerida INT,
	PRIMARY KEY(id),
	FOREIGN KEY (id_provincia_requerida) REFERENCES Provincia (id)
);

CREATE TABLE IF NOT EXISTS TramitexTramite(
	id INT AUTO_INCREMENT,
	id_tramite_requerido INT,
	id_tramite_superior INT,
	PRIMARY KEY (id),
	FOREIGN KEY (id_tramite_requerido) REFERENCES Tramite (id),
	FOREIGN KEY (id_tramite_superior) REFERENCES Tramite (id)
);

CREATE TABLE IF NOT EXISTS TramitexValidacion(
	id INT AUTO_INCREMENT,
	id_tramite INT,
	id_validacion INT,
	PRIMARY KEY (id),
	FOREIGN KEY (id_tramite) REFERENCES Tramite (id),
	FOREIGN KEY (id_validacion) REFERENCES Validacion (id)
);