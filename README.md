# Libro de Clases Digital - Colegio Bernardo O'Higgins

## Descripción
Sistema de libro de clases digital que permite registrar estudiantes, notas, asistencia y anotaciones de conducta.

## Requisitos previos
- Java 17
- Maven
- XAMPP (MySQL)
- MySQL Workbench

## Configuración de base de datos
1. Inicia XAMPP y activa MySQL
2. Abre MySQL Workbench y ejecuta:
```sql
CREATE DATABASE libro_clases;
```
3. Verifica que `application.properties` tenga:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/libro_clases
spring.datasource.username=root
spring.datasource.password=
```

## Instalación y ejecución
```bash
git clone https://github.com/TU_USUARIO/libro-de-clases.git
cd libro-de-clases
./mvnw spring-boot:run
```

## Ejecutar pruebas
```bash
./mvnw test
```

## Módulos
| Módulo | Descripción | Puerto |
|--------|-------------|--------|
| students | Gestión de estudiantes | 8080 |
| grades | Registro de notas | 8080 |
| attendance | Control de asistencia | 8080 |
| annotations | Anotaciones de conducta | 8080 |
| bff | Resumen completo por estudiante | 8080 |

## Endpoints principales
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/students | Listar estudiantes |
| POST | /api/students | Crear estudiante |
| GET | /api/grades/{rut} | Notas por estudiante |
| POST | /api/grades | Registrar nota |
| GET | /api/attendance/{rut} | Asistencia por estudiante |
| POST | /api/attendance | Registrar asistencia |
| GET | /api/annotations/{rut} | Anotaciones por estudiante |
| POST | /api/annotations | Crear anotación |
| GET | /api/bff/student/{rut} | Resumen completo del estudiante |

## Estrategia de branching
- `main` — rama de producción
- `develop` — rama de integración
- `feature/xxx` — una rama por módulo