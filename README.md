# RetoKataFullStackSofkaC3
En este repositorio se cuentra alojado el codigo correspondiente a la solución del Reto Kata Full Stack del Training de desarrollo de Software de Sofka C3.

# Perspectiva Backend
Para descargar el proyecto y correr el backend es necesario que el proyecto se construya mediante Maven y SpringBoot, para esto se tiene que realizar la ejecucion de un comando desde la terminar parado sobre la carpeta 'crudBakc':

- mvn spring-boot:run

Una vez creado el proyecto mediante Maven, es necesario confirgurar en el archivo application.properties el acceso a la base de datos local, con la ruta relativa de:

- crudBack\src\main\resources\application.properties


Esta configuracion es para las bases de datos SQL cuyo usuario es root y no se tiene una contraseña:

> spring.jpa.hibernate.ddl-auto= update
spring.datasource.url= jdbc:mysql://localhost:3306/todolistdb?user=root

Si se tiene un usuario y contraseña esta es la configuracion recomendada:

>spring.jpa.hibernate.ddl-auto= update
spring.datasource.url= jdbc:mysql://localhost:3306/todolistdb
spring.datasource.username={suUsername}
spring.datasource.password={suPassword}

Si anteriormente el levantamiento del servidor fallo, vuelva a ejecutar el comando despues de configurar las propiedades de la aplicacion:

- mvn spring-boot:run

Por defecto spring boot levanta el servidor en el localhost en el puerto 8080, alli vamos a realizar las peticiones desde el front

# Perspectiva Frontend
La perspectiva del front para el proyecto ya esta construida, para que el cliente funcione es necesario levantar un servidor desde la extension Liver Server de Visual Studio Code, ya que las peticiones del backend estan configuradas par que el CORS acepte este origen para dichas peticiones.

Si va a utilizar un puerto de origen diferente al de Live Server (5500) para realizar las peticiones, es necesario cambiar los valores del @CrossOrigin en el backend


