package devices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartLightTest {

    @Test
    void setBrightness() {
        SmartLight sl = new SmartLight();
        assertNotEquals(1, sl.getBrightness());
        sl.setBrightness(2);
        assertEquals(2, sl.getBrightness());
    }

    @Test
    void getBrightness() {
        SmartLight sl = new SmartLight();
        assertEquals(0, sl.getBrightness());
        assertNotEquals(2, sl.getBrightness());
        sl.setBrightness(3);
        assertEquals(3, sl.getBrightness());
    }
}