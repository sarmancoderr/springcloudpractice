# Prueba técnica spring boot

Desarrollar, utilizando Spring Boot 2 y Java 11, una API que permita hacer un mantenimiento de súper
héroes.

Setup inicial
 * Tener configurada una base de datos h2

Orden en el que hacer las cosas:
 * Crear entidad y DTO
 * Crear repositorio JPA e interfaz para implementar posteriormente
 * Crear excepciones personalizadas de tipo Runtime Exception
 * Crear un test que testee todos los métodos correspondientes a la interfaz
 * Realizar la implementación de la interfaz y comprobar que funcione bien
 * Crear un controlador que exponga todos los métodos de la interfaz
 * Swagger

Endpoints que tiene que haber:
 * Listar heroes
 * Mostrar un único heroe a partir de un id
 * Listar todos los heroes coincidentes con el parámetro que se envíe en la petición, por ejemplo: “man” devolverá “Spiderman”, “Superman”, “Manolito el fuerte”, etc.
 * Actualizar heroe
 * Eliminar heroe
