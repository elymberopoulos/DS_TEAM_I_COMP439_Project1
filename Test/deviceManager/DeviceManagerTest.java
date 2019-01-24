package deviceManager;

import devices.Device;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class DeviceManagerTest {

    @Test
    void addDevice() {
        DeviceManager dm = new DeviceManager();

        Map lights = dm.getDeviceMap().put("Lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("Power Strips", new TreeMap<>());
        Device d = new Device("light");

        dm.addDevice("testKey", d, "Lights");
        Device testResult = dm.getDeviceMap().get("Lights").get("testKey");
        System.out.println(testResult);
        assertNotNull(testResult);
    }

    @Test
    void removeDevice() {
        DeviceManager dm = new DeviceManager();
        Map lights = dm.getDeviceMap().put("Lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("Power Strips", new TreeMap<>());
        Device d = new Device("light");

        dm.addDevice("testKey", d, "Lights");
        Device testResult = dm.getDeviceMap().get("Lights").get("testKey");
        assertNotNull(testResult);

        dm.removeDevice("testKey", "Lights");
        assertTrue(!dm.getDeviceMap().get("Lights").containsKey("testKey"));
    }

    @Test
    void moveDevice() {
        DeviceManager dm = new DeviceManager();
        Map lights = dm.getDeviceMap().put("Lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("Power Strips", new TreeMap<>());
        Device d = new Device("light");

        dm.addDevice("testKey", d, "Lights");
        Device testResult = dm.getDeviceMap().get("Lights").get("testKey");
        assertNotNull(testResult);

        dm.moveDevice("testKey", "Lights", "Power Strips");
        assertFalse(dm.getDeviceMap().get("Lights").containsKey("testKey"));
        assertTrue(dm.getDeviceMap().get("Power Strips").containsKey("testKey"));
    }

    @Test
    void setDeviceName(){

    }

    @Test
    void getDeviceName(){

    }
}