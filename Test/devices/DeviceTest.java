package devices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {
    //Device device = new Device("test");
    @Test
    void isOn() {
        boolean result = device.isOn();
        assertFalse(result);
    }

    @Test
    void setOn() {
    }

    @Test
    void moveDevice() {
    }

    @Test
    void setTimer() {
    }
}