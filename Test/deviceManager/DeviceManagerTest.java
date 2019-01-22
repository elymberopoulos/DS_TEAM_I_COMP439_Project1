package deviceManager;

import devices.Device;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceManagerTest {

    @Test
    void showDevices() {
    }

    @Test
    void addDevice() {
        DeviceManager dm = new DeviceManager();
        Device d = new Device("light");
    }

    @Test
    void removeDevice() {
        DeviceManager dm = new DeviceManager();
    }

    @Test
    void moveDevice() {
    }
}