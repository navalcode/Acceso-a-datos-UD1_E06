package com.salesianos.triana.ejercicio1;
import com.salesianos.triana.ejercicio1.models.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class RelationshipOwnershipTest {
    @Test void movingAProductDetachesItsPreviousCategory() {
        Producto product = new Producto(); Categoria first = new Categoria(); Categoria second = new Categoria();
        product.addCategoria(first); product.addCategoria(second);
        assertTrue(first.getProductos().isEmpty()); assertEquals(1, second.getProductos().size());
        assertSame(product, second.getProductos().get(0)); assertSame(second, product.getCategoria());
    }
    @Test void repeatedAttachmentDoesNotDuplicateTheInverseCollection() {
        Producto product = new Producto(); Categoria category = new Categoria();
        product.addCategoria(category); product.addCategoria(category);
        assertEquals(1, category.getProductos().size());
    }
    @Test void removingAnUnrelatedCategoryDoesNotDetachTheCurrentOwner() {
        Producto product = new Producto(); Categoria owner = new Categoria(); Categoria other = new Categoria();
        product.addCategoria(owner); product.removeCategoria(other);
        assertSame(owner, product.getCategoria()); assertEquals(1, owner.getProductos().size());
        product.removeCategoria(owner); product.removeCategoria(owner);
        assertNull(product.getCategoria()); assertTrue(owner.getProductos().isEmpty());
    }
}
