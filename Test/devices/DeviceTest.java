package devices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {
    Device device = new Device("test");
    @Test
    void isOn() {
        boolean result = device.powerSwitch();
        assertFalse(result);
        device.setPowerSwitch();
        assertTrue(device.powerSwitch());

    }

    @Test
    void setOn() {
        Device d = new Device("test");
        assertFalse(d.powerSwitch());
        d.setPowerSwitch();
        assertTrue(d.powerSwitch());
    }


    @Test
    void moveDevice() {
    }


    @Test
    void setTimer() {
    }
}