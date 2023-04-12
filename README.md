# Market Place Viveros

[![N|Solid](https://cldup.com/dTxpPi9lDf.thumb.png)](https://nodesource.com/products/nsolid)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Aplicación de E-commerce donde agricultores y comerciantes locales puedan ofrecer sus productos a todos.

- Plataforma Web
- ✨Magic ✨

## Features

- Listado de productos   
- Creación de productos
- Registro de Usuarios
- Inicio de sesión


## Instalación y puesta en marcha!

Market place viveros requiere [Java](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html/) v 11+ y maven para correr.

De preferencia abrir el proyecto en tu editor de preferencia para ejecutar y construir!

### Instalar las dependencias.

```sh
mvn --version
mvn clean install 
```



### Docker
Puesta en marcha de la base de datos. Requiere tener instalado [Docker]()

Usamos docker compose para levantar la base de datos y un administrador que nos permita manejar la base de datos de manera visual

Por defecto postgres viene en el puerto 5432 si desea lo puede cambiar en el archivo docker-compose.yml

```sh
cd MarketPlace
docker compose up
```

Esto creará la imagen y los dos contenedores

El administrador de base de datos pgAdmin por defecto estará expuesto en el puerto 8080

> Note: `credenciales` se encuentran en el archivo docker-compose.yml


### Iniciar.

```sh
mvn spring-boot:run
```


Verificar el despliegue y navegabilidad del servidor en la dirección
your preferred browser.

```sh
127.0.0.1:9081
```

## Example Request:

```http request
curl --location 'localhost:9081/api/product' \
--header 'Authorization: any_token' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "planta",
    "category" : "Plantas de Flor",
    "subCategory" : "para la oficina",
    "price" : 60000,
    "discount" : 15,
    "url" : "../img/product1.jpg"
}
```



##
<h3 align="left">Lenguajes y Herramientas:</h3>
<p align="left"> <a href="https://www.w3schools.com/css/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="40" height="40"/> </a> <a href="https://www.docker.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="40" height="40"/> </a> <a href="https://www.w3.org/html/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="40" height="40"/> </a> <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>