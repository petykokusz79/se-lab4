package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void empty() {
        TorpedoStore store = new TorpedoStore(0);
        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }

    @Test
    void notEmpty() {
        TorpedoStore store = new TorpedoStore(1);
        assertEquals(1, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }
    
    @Test
    void failure() {
        TorpedoStore store = new TorpedoStore(1, 1);
        assertFalse(store.fire(1));
    }
    
    @Test
    void numberOutOfBound() {
        TorpedoStore store = new TorpedoStore(1);
        assertThrows(IllegalArgumentException.class, () -> store.fire(0));
        assertThrows(IllegalArgumentException.class, () -> store.fire(2));
    }
}
