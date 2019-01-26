package devices;

import deviceManager.DeviceManager;
import org.junit.jupiter.api.Test;
import timer.Timer;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class DeviceTest {

    @Test
    void setPowerSwitch() {
        Device d = new Device();
        assertFalse(d.isDeviceOn());
        d.setPowerSwitch();
        assertTrue(d.isDeviceOn());
    }

    @Test
    void isDeviceOn() {
        Device device = new Device();
        boolean result = device.isDeviceOn();
        assertFalse(result);
        device.setPowerSwitch();
        assertTrue(device.isDeviceOn());
    }

    @Test
    void getTimer() {
        Device d = new Device();
        Timer timer = d.getTimer();
        assertEquals(timer, d.getTimer());
    }

    @Test
    void checkTimer() { // checks if timer is running
        Device d = new Device();
        Timer timer = d.getTimer();
        timer.setTime(2);
        Thread thread = new Thread(timer);

        assertFalse(d.getTimer().isRunning());
        thread.start();
        Thread t = new Thread();

        try { // delay so that run method has time to change timer boolean value of running
            t.run();
            t.sleep(50);
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(d.getTimer().isRunning());
    }

    @Test
    void getDeviceName() {
        SmartLight l = new SmartLight();
        DeviceManager dm = new DeviceManager();
        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        dm.addDevice("name", l, "lights");
        assertNotEquals("nam", l.getDeviceName());
        assertEquals("name", l.getDeviceName());
    }

    @Test
    void setDeviceName() {
        SmartLight l = new SmartLight();
        assertNotEquals("name", l.getDeviceName());
        l.setDeviceName("name");
        assertEquals("name", l.getDeviceName());
    }

    @Test
    void showState() { //already tested with is on, tested running thread
    }
}