package devices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {
    Device device = new Device();

    @Test
    void setPowerSwitch() {
        Device d = new Device();
        assertFalse(d.isDeviceOn());
        d.setPowerSwitch();
        assertTrue(d.isDeviceOn());
    }

    @Test
    void isDeviceOn() {
        boolean result = device.isDeviceOn();
        assertFalse(result);
        device.setPowerSwitch();
        assertTrue(device.isDeviceOn());
    }

    @Test
    void getTimer() {
    }

    @Test
    void checkTimer() {
    }

    @Test
    void startTimer() {
    }

    @Test
    void getDeviceName() {
    }

    @Test
    void setDeviceName() {
    }

    @Test
    void showState() {
    }
}