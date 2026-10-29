# JPA relationships and data access

[Español](README.es.md) · [More work](https://github.com/navalcode)

## Overview

Two coursework modules make relationship ownership observable. `ejercicio1` covers products/categories; `ejercicio2` covers courses, teachers and videos. The review fixes stale inverse collections, repeated attachments and removal through the wrong owner while preserving the existing public helper methods and mappings.

## Run

Requires JDK 17, with the original Maven 3.8.3/Spring Boot 2.5.6 pins. From the repository root in a Unix shell:

```sh
cd ejercicio1
sh ./mvnw verify
cd ../ejercicio2
sh ./mvnw verify
```

The modules pass five and eight local checks respectively: seven pure object-graph regressions, four JPA flush/reload tests and the two original context smoke tests.

## Follow one change of owner

Start with `RelationshipOwnershipTest` and `RelationshipPersistenceTest` in each module. Moving a product to another category removes its old inverse entry. Moving a course to another teacher does the same. Repeating an attachment adds no duplicate; removing through an unrelated owner leaves the current relationship intact.

The persistence suite clears the context and reloads both sides, so it checks stored foreign keys and collections rather than the same Java objects. Video transfer and orphan deletion are checked separately with the pinned Hibernate/H2 provider: a removed video is deleted while its course remains.

The models and helper names keep the original coursework structure. `MainPrueba` remains as bootstrap teaching material; its original console messages are Spanish. There is no HTTP controller or graphical interface in these modules. [Design decisions](DESIGN.md) explain the state and persistence boundary.

## Validation

On 29 October 2026, JDK 17/macOS passed all 13 tests and both Maven `verify` builds. Seven new object-graph cases initially failed and are retained as regression coverage. A persistence-test fixture initially read an ID from the pre-merge child; it now inspects the managed child before asserting behavior. [Local results](docs/verification.json) distinguish those checks from hosted CI or another persistence provider, which were not validated here.

## Resumen

La [versión española](README.es.md) explica los mismos comandos, relaciones, pruebas y límites. Se conservan paquetes, recursos, atribución e historial del ejercicio original.
