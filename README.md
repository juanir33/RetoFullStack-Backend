
# Reto final del curso desarrollo web 2.1 - Realizar una aplicacion Fullstack - Backend
El programa consta de una TODOLIST, que puede gener varias listas con subtareas cada una,
en el Backend se utilizo Springboot, para realizar una api REST. Se uso MySQL coomo servidor de base de datos.
Del lado cliente, se desarrollo el consumo de la api en javascript vanilla. 








## Correr el programa

Clonar el repo

```bash
  git clone https://github.com/juanir33/RetoFullStack-Backend
```



Iniciar el proyecto Java, e instalar dependencias de maven si asi lo requiera.
```bash
  
src/main/java/com/sofka/todolist/todolist/ListaDeTareasApplication.java

```

Para la base de datos en MySQl, en el servidor que use, generar las siguientes sentencias SQL.
``` bash
CREATE SCHEMA IF NOT EXISTS dbtareas DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE dbtareas ;


CREATE TABLE IF NOT EXISTS dbtareas.tarea (
  id INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(100) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS dbtareas.subtarea (
  sub_id INT NOT NULL AUTO_INCREMENT,
  sub_titulo VARCHAR(100) NOT NULL,
  sub_is_done BOOLEAN NOT NULL,
  tarea_id INT NOT NULL,
  PRIMARY KEY (sub_id),
  INDEX fk_subtarea_tarea_idx (tarea_id ASC) VISIBLE,
  CONSTRAINT fk_subtarea_tarea
    FOREIGN KEY (tarea_id)
    REFERENCES dbtareas.tarea (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
```

Conectar la base de datos, e iniciar ListaDeTareasApplication.java
## Authors

- [@juanir33](https://www.github.com/juanir33)


## License

[MIT](https://choosealicense.com/licenses/mit/)


## Links
Link al respositorio del front

https://github.com/juanir33/RetoFullstack-Front

Link de video en youtube, con la demostracion del programa y el codigo.

https://youtube.com/playlist?list=PLs5G8vTWRwtvvrEqAZcGezxQzLa2yYs06

