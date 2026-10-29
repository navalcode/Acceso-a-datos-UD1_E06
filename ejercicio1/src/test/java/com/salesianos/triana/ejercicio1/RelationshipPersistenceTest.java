package com.salesianos.triana.ejercicio1;
import com.salesianos.triana.ejercicio1.models.*;
import com.salesianos.triana.ejercicio1.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import javax.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest(properties={"spring.sql.init.mode=never","spring.jpa.hibernate.ddl-auto=create-drop"})
class RelationshipPersistenceTest {
    @Autowired CategoriaRepository categories;
    @Autowired ProductoRepository products;
    @Autowired EntityManager entities;
    @Test void productTransferIsConsistentAfterFlushAndReload() {
        Categoria first=categories.save(new Categoria()); Categoria second=categories.save(new Categoria()); Producto product=new Producto();
        product.addCategoria(first); products.saveAndFlush(product); product.addCategoria(second); products.saveAndFlush(product); entities.clear();
        assertTrue(categories.findById(first.getId()).orElseThrow().getProductos().isEmpty());
        assertEquals(1,categories.findById(second.getId()).orElseThrow().getProductos().size());
        assertEquals(second.getId(),products.findById(product.getId()).orElseThrow().getCategoria().getId());
    }
}
