# Proyecto Farmacia

Este proyecto tiene como objetivo gestionar el registro de chips en medicamentos proporcionados a los pacientes, con un control realizado por los médicos a través de estos chips. El proyecto está construido con un frontend utilizando HTML, CSS y JavaScript, y un backend con Java, Servlets y Tomcat. MySQL es la base de datos utilizada.

## Requisitos

- Java SDK (preferiblemente JDK 8 o superior)
- Servidor Apache Tomcat
- MySQL

## Instalación

1. Clona este repositorio en tu máquina local.
2. Importa el proyecto en tu IDE (Eclipse, VSCode).
3. Asegúrate de tener MySQL ejecutándose y crea una base de datos para este proyecto.
4. Configura el servidor Tomcat en tu IDE y despliega el proyecto.

## Frontend

El frontend de la aplicación consta de tres partes principales:

#### Página de Login

Permite al usuario iniciar sesión en la aplicación.

#### Página de Gestión

Permite al usuario visualizar una lista de todas las asignaciones de chips. Desde esta página, el usuario puede registrar un nuevo chip o cerrar sesión.

#### Página de Alta

Permite al usuario registrar un nuevo chip. El usuario debe ingresar el identificador físico del chip, seleccionar un paciente, seleccionar un medicamento y establecer una fecha límite de uso.


## Backend

La aplicación tiene varios servicios de backend:

### Login

Este servicio verifica si un usuario (doctor) está registrado en la base de datos y devuelve un código de sesión para identificar sus conexiones con el backend. Debe enviar un mensaje GET HTTP con los parámetros:

- email: el identificador único del usuario (doctor)
- pass: contraseña ingresada por el usuario (hash de la contraseña).


### ServXips

Este servicio proporciona una tabla con todas las asignaciones de chips relacionadas con el doctor. Debe enviar un mensaje GET HTTP con los parámetros:

- mail: correo electrónico del usuario (doctor) activo.
- session: código de sesión.


### ServePatients

Este servicio proporciona una lista de todos los pacientes en formato JSON. Debe enviar un mensaje GET HTTP con los parámetros:

- mail: correo electrónico del usuario (doctor) activo.
- session: código de sesión.


### ServeMedicines

Este servicio proporciona una lista de todos los medicamentos en formato JSON. Debe enviar un mensaje GET HTTP con los parámetros:

- mail: correo electrónico del usuario (doctor) activo.
- session: código de sesión.


### Release

Este servicio permite al usuario (doctor) registrar un nuevo chip con su medicamento asociado, paciente y fecha límite de uso. Debe enviar un mensaje POST HTTP con los parámetros:

- mail: correo electrónico del usuario (doctor) activo.
- session: código de sesión.
- idXip: identificador físico del chip.
- idMed: identificador del medicamento.
- date: fecha límite para tomar el medicamento.
- mailP: correo electrónico del paciente.

## Base de Datos

La base de datos utilizada en este proyecto es MySQL. 

La base de datos del proyecto se llama "farmacia". La estructura de las tablas son las siguientes:

### doctor

- mail: primary key varchar(50).
- pass: varchar(100)
- name: varchar(100) nom complet del doctor
- last_log: date (yyyy-mm-dd)
- session: int(10)

### xip

- id: primary key int(10)
- doctor_mail: doctor.mail
- id_medicine: medicine.id
- id_patient: patient.mail
- date: date (yyyy-mm-dd). Data de finalització del ús del xip

### patient

- mail: primary key varchar(50)
- name: varchar (100) nom complet del pacient

### medicine

- id: primary key serial
- name: varchar(50)
- tmax: float (50) Temperatura máxima que soporta el medicament
- tmin: float (50) Temperatura mínima que soporta el medicament

Para crear la base de datos y las tablas necesarias, puedes encontrar los scripts DDL y DML en la carpeta "sql" del proyecto.

## Configuración de la Base de Datos

El proyecto se conecta a la base de datos utilizando las siguientes credenciales:

- nombre de la base de datos: "farmacia"
- nombre de usuario: "root"
- contraseña: ""


