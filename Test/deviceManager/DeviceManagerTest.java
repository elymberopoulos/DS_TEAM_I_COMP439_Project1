package deviceManager;

import devices.Device;
import devices.SmartLight;
import devices.SmartPowerStrip;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class DeviceManagerTest {

    @Test
    void addDevice() {
        DeviceManager dm = new DeviceManager();

        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        Device d = new Device();

        dm.addDevice("testKey", d, "lights");
        Device testResult = dm.getDeviceMap().get("lights").get("testKey");
        System.out.println(testResult);
        assertNotNull(testResult);
    }

    @Test
    void removeDevice() {
        DeviceManager dm = new DeviceManager();
        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        Device d = new Device();

        dm.addDevice("testKey", d, "lights");
        Device testResult = dm.getDeviceMap().get("lights").get("testKey");
        assertNotNull(testResult);

        dm.removeDevice("testKey", "Lights");
        assertTrue(!dm.getDeviceMap().get("lights").containsKey("testKey"));
    }

    @Test
    void moveDevice() {
        DeviceManager dm = new DeviceManager();
        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        Device d = new Device();

        dm.addDevice("testKey", d, "lights");
        Device testResult = dm.getDeviceMap().get("lights").get("testKey");
        assertNotNull(testResult);

        dm.moveDevice("testKey", "lights", "power strips");
        assertFalse(dm.getDeviceMap().get("lights").containsKey("testKey"));
        assertTrue(dm.getDeviceMap().get("power strips").containsKey("testKey"));
    }

    @Test
    void generateSmartBulb() {
        DeviceManager d = new DeviceManager();
        SmartLight light = d.generateSmartBulb();
        assertNotNull(light);
        assertTrue(light instanceof SmartLight);
    }

    @Test
    void generateSmartPowerStrip() {
        DeviceManager d = new DeviceManager();
        SmartPowerStrip powerStrip = d.generateSmartPowerStrip();
        assertNotNull(powerStrip);
        assertTrue(powerStrip instanceof SmartPowerStrip);
    }

    @Test
    void getDeviceMap() {
        DeviceManager d = new DeviceManager();
        Map t = d.getDeviceMap();
        assertNotNull(t);
        assertTrue(t instanceof TreeMap);
    }

    @Test
    void getDeviceName() {
        DeviceManager dm = new DeviceManager();

        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        SmartLight smartLight = new SmartLight();
        SmartPowerStrip powerStrip = new SmartPowerStrip();


        dm.addDevice("light", smartLight, "lights");
        dm.addDevice("power", powerStrip, "power strips");
        Device lightResult = dm.getDeviceMap().get("lights").get("light");
        Device powerStripResult = dm.getDeviceMap().get("power strips").get("power");
        assertNotNull(lightResult);
        assertNotNull(powerStripResult);
        assertEquals("light", lightResult.getDeviceName());
        assertEquals("power", powerStripResult.getDeviceName());
    }

    @Test
    void setDeviceName() {
        DeviceManager dm = new DeviceManager();

        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        SmartLight smartLight = new SmartLight();
        SmartPowerStrip powerStrip = new SmartPowerStrip();


        dm.addDevice("light", smartLight, "lights");
        dm.addDevice("power", powerStrip, "power strips");
        Device lightResult = dm.getDeviceMap().get("lights").get("light");
        Device powerStripResult = dm.getDeviceMap().get("power strips").get("power");
        assertNotNull(lightResult);
        assertNotNull(powerStripResult);
        assertEquals("light", lightResult.getDeviceName());
        assertEquals("power", powerStripResult.getDeviceName());
        dm.setDeviceName("light", "newName", "lights");
        dm.setDeviceName("power", "newerName", "power strips");
        Device newLightResult = dm.getDeviceMap().get("lights").get("light");
        Device newPowerStripResult = dm.getDeviceMap().get("power strips").get("power");
        assertEquals("newName", newLightResult.getDeviceName());
        assertEquals("newerName", newPowerStripResult.getDeviceName());
    }

    @Test
    void getDevice() {
        DeviceManager dm = new DeviceManager();

        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        SmartLight smartLight = new SmartLight();
        SmartPowerStrip powerStrip = new SmartPowerStrip();


        dm.addDevice("light", smartLight, "lights");
        dm.addDevice("power", powerStrip, "power strips");
        assertEquals(smartLight, dm.getDevice("light", "lights"));
        assertEquals(powerStrip, dm.getDevice("power", "power strips"));
    }

}