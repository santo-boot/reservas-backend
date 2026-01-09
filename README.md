# reservas-backend

# Sistema de Reservas – Backend (Quarkus)

**Realizado por:** Santiago Chicaiza

Backend REST desarrollado con **Quarkus** para la gestión de reservas entre clientes y profesionales, cumpliendo reglas de negocio como disponibilidad de horarios y validación de solapamientos.

---

## Consideraciones cumplidas

- Uso de base de datos relacional (PostgreSQL)
- Validación de requests con `@Valid`
- Control de excepciones
- Excepciones de negocio personalizadas
- Documentación con OpenAPI / Swagger
- Arquitectura Domain / Application / Infrastructure (DDD ligero)
- Uso de Hibernate ORM + Panache
- No se utiliza JWT
- No se incluye Kafka ni despliegue en la nube

---

## Reglas de negocio

- Un profesional no puede tener reservas solapadas
- Solo se consideran reservas en estado **ACTIVA**
- Validaciones de fecha y hora
- Manejo de errores mediante excepciones de negocio

---

## Tecnologías utilizadas

- Java 21+
- Quarkus 3.x
- Hibernate ORM + Panache
- PostgreSQL
- RESTEasy Reactive (JAX-RS)
- Swagger / OpenAPI
- Maven
- Visual Studio Code

---

## Arquitectura del proyecto

```
domain
 ├─ model        -> Entidades del dominio
 └─ exception    -> Excepciones de negocio

application
 └─ service      -> Lógica de negocio

infrastructure
 ├─ rest         -> Endpoints REST
 └─ repository   -> Acceso a datos
```

---

## Configuración de base de datos

El proyecto utiliza **PostgreSQL**.

### application.properties

```properties
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=reservas_user
quarkus.datasource.password=reservas123
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/reservas

quarkus.hibernate-orm.database.generation=drop-and-create
quarkus.hibernate-orm.log.sql=true

quarkus.swagger-ui.always-include=true
quarkus.swagger-ui.path=/swagger-ui
```

---

## Inicialización de datos

- Las tablas se crean automáticamente al iniciar la aplicación
- Los datos de prueba se cargan desde:

```
src/main/resources/import.sql
```

Incluye:
- Profesionales
- Clientes
- Horarios disponibles
- Reservas de ejemplo

---

##  Ejecución del proyecto

### 1. Crear base de datos

```sql
CREATE DATABASE reservas;
CREATE USER reservas_user WITH PASSWORD 'reservas123';
GRANT ALL PRIVILEGES ON DATABASE reservas TO reservas_user;
```

### 2. Ejecutar la aplicación

```bash
mvn quarkus:dev
```

---

## Documentación de la API

Swagger UI:

```
http://localhost:8080/swagger-ui
```

---

## Endpoints principales

### Profesionales
- `POST   /profesionales`
- `GET    /profesionales`
- `PUT    /profesionales/{id}`

### Clientes
- `POST   /clientes`
- `GET    /clientes`

### Horarios disponibles
- `POST   /horarios`
- `GET    /horarios`
- `PUT    /horarios/{id}`

### Reservas
- `POST   /reservas`
- `GET    /reservas`
- `PUT    /reservas/{id}/cancelar`

---

## Estado del proyecto

Proyecto **funcional**, con reglas de negocio implementadas, validaciones activas y datos de prueba cargados correctamente.