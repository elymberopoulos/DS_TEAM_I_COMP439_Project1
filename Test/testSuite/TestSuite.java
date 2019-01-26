package testSuite;

import deviceManager.DeviceManagerTest;
import devices.DeviceTest;
import devices.SmartLightTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import timer.TimerTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        DeviceManagerTest.class,
        DeviceTest.class,
        SmartLightTest.class,
        TimerTest.class
})

public class TestSuite {
}
