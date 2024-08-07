﻿#  challengue_foro_hub
# Challengue Foro Hub

## Descripción

Challengue Foro Hub es una aplicación web que permite a los usuarios crear y gestionar hilos de discusión en un foro. Los usuarios pueden registrarse, iniciar sesión, crear nuevos temas, comentar en hilos existentes y editar sus publicaciones.

## Características

- **Registro y autenticación de usuarios**: Los usuarios pueden crear cuentas y autenticarse para acceder a funcionalidades adicionales.
- **Gestión de hilos**: Crear, editar y eliminar hilos de discusión.
- **Comentarios**: Comentar en hilos existentes.
- **Búsqueda y filtrado**: Buscar hilos por título o contenido y filtrar por categorías.

## Tecnologías Utilizadas

- **Backend**: Java con Spring Boot.
- **Base de Datos**: MySQL.
- **Gestión de Dependencias**: Maven.
- **Control de Versiones**: Git y GitHub.
- **Pruebas**: JUnit y Mockito.

## Instalación

Sigue estos pasos para instalar y ejecutar el proyecto localmente:

1. Clona el repositorio:
    ```sh
    git clone https://github.com/LuisPumajulca/challengue_foro_hub.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd challengue_foro_hub
    ```
3. Configura la base de datos MySQL:
    - Crea una base de datos llamada `foro_hub`.
    - Configura las credenciales de la base de datos en el archivo `application.properties`.

4. Instala las dependencias:
    ```sh
    ./mvnw install
    ```

5. Ejecuta la aplicación:
    ```sh
    ./mvnw spring-boot:run
    ```

6. Abre tu navegador web y navega a `http://localhost:8080` para ver la aplicación en funcionamiento.

## Uso

Una vez que la aplicación esté en funcionamiento, puedes:

- Registrarte como nuevo usuario.
- Iniciar sesión con tu cuenta.
- Crear nuevos hilos de discusión.
- Comentar en hilos existentes.
- Editar tus publicaciones.

## Contribución

¡Las contribuciones son bienvenidas! Sigue estos pasos para contribuir al proyecto:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz un commit (`git commit -am 'Añadir nueva funcionalidad'`).
4. Empuja tus cambios a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Contacto

Para cualquier pregunta o comentario, puedes contactar al autor:
- **Nombre**: Luis Fernando Pumajulca Urbano
- **Email**: [tu-email@example.com]

