package devices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {
    Device device = new Device();
    @Test
    void isOn() {
        boolean result = device.isDeviceOn();
        assertFalse(result);
        device.setPowerSwitch();
        assertTrue(device.isDeviceOn());

    }

    @Test
    void setOn() {
        Device d = new Device();
        assertFalse(d.isDeviceOn());
        d.setPowerSwitch();
        assertTrue(d.isDeviceOn());
    }


    @Test
    void moveDevice() {
    }


    @Test
    void setTimer() {
    }
}