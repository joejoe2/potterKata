import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotterKataTest {
    PotterKata potterKata = new PotterKata();

    @Test
    void calculatePrice_Zero() {
        assertEquals(0, potterKata.calculatePrice(new int[]{0, 0, 0, 0, 0}));
    }

    @Test
    void calculatePrice_OneType() {
        assertEquals(8*5, potterKata.calculatePrice(new int[]{5, 0, 0, 0, 0}));
        assertEquals(8*5, potterKata.calculatePrice(new int[]{0, 5, 0, 0, 0}));
        assertEquals(8*5, potterKata.calculatePrice(new int[]{0, 0, 5, 0, 0}));
        assertEquals(8*5, potterKata.calculatePrice(new int[]{0, 0, 0, 5, 0}));
        assertEquals(8*5, potterKata.calculatePrice(new int[]{0, 0, 0, 0, 5}));
    }

    @Test
    void calculatePrice_SimpleDiscounts() {
        assertEquals(16*0.95, potterKata.calculatePrice(new int[]{1, 1, 0, 0, 0}));
        assertEquals(8 * 3 * 0.9, potterKata.calculatePrice(new int[]{1, 0, 1, 0, 1}));
        assertEquals(8 * 4 * 0.8, potterKata.calculatePrice(new int[]{1, 1, 1, 0, 1}));
        assertEquals(8 * 5 * 0.75, potterKata.calculatePrice(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    void calculatePrice_SeveralDiscounts(){
        assertEquals(8 + (8 * 2 * 0.95), potterKata.calculatePrice(new int[]{2, 1, 0, 0, 0}));
        assertEquals(2 * (8 * 2 * 0.95), potterKata.calculatePrice(new int[]{2, 2, 0, 0, 0}));
        assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), potterKata.calculatePrice(new int[]{2, 1, 2, 1, 0}));
        assertEquals(8 + (8 * 5 * 0.75), potterKata.calculatePrice(new int[]{1, 2, 1, 1, 1}));
    }

    @Test
    void calculatePrice_EdgeCases(){
        assertEquals(2 * (8 * 4 * 0.8), potterKata.calculatePrice(new int[]{2, 2, 2, 1, 1}));
        assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), potterKata.calculatePrice(new int[]{5, 5, 4, 5, 4}));
    }
}