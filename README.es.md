# Relaciones JPA y acceso a datos

[English](README.md) · [Más proyectos](https://github.com/navalcode)

## Resumen

Dos módulos formativos hacen observable la propiedad de relaciones. `ejercicio1` contiene productos/categorías; `ejercicio2`, cursos, profesores y vídeos. La revisión corrige colecciones inversas antiguas, asociaciones repetidas y retiradas desde el propietario equivocado, conservando los métodos públicos y mappings existentes.

## Ejecutar

Requiere JDK 17 y conserva Maven 3.8.3/Spring Boot 2.5.6. Desde la raíz, en una shell Unix:

```sh
cd ejercicio1
sh ./mvnw verify
cd ../ejercicio2
sh ./mvnw verify
```

Los módulos pasan cinco y ocho comprobaciones locales: siete regresiones del grafo de objetos, cuatro pruebas JPA con flush/recarga y los dos tests originales de contexto.

## Seguir un cambio de propietario

Empieza por `RelationshipOwnershipTest` y `RelationshipPersistenceTest` de cada módulo. Mover un producto a otra categoría retira su entrada inversa anterior; cambiar un curso de profesor hace lo mismo. Repetir una asociación no duplica; retirar desde otro propietario conserva la relación actual.

La suite de persistencia limpia el contexto y recarga ambos extremos para verificar claves y colecciones almacenadas. Se comprueban por separado traslado de vídeo y eliminación de huérfanos con Hibernate/H2 fijados: el vídeo retirado se elimina y el curso permanece.

Modelos y helpers conservan la estructura original. `MainPrueba` sigue como material de arranque y sus mensajes formativos originales están en español. Los módulos no contienen controlador HTTP o interfaz gráfica. Las [decisiones de diseño](DESIGN.md) explican la frontera entre estado y persistencia.

## Validación

El 29 de octubre de 2026 pasan 13 tests y ambos builds Maven `verify` con JDK 17/macOS. Las siete regresiones nuevas del grafo fallaban inicialmente. Un fixture JPA leía el ID del hijo anterior al merge; ahora inspecciona el hijo gestionado antes de comprobar el comportamiento. Los [resultados locales](docs/verification.json) distinguen estas pruebas de CI alojada u otro proveedor de persistencia, no validados aquí.

Se conservan paquetes, recursos, atribución e historial del ejercicio original.
