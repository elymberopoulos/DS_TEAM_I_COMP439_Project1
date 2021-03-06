package timer;

import devices.Device;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimerTest {

    @Test
    void getSchedule() {
        Device d = new Device();
        Timer t = d.getTimer();
        assertEquals(0, t.getSchedule());
        assertNotEquals(1000, t.getSchedule());
        t.setSchedule(1000);
        assertEquals(1000, t.getSchedule());
        assertNotEquals(2000, t.getSchedule());
    }

    @Test
    void setSchedule() {
        Device d = new Device();
        Timer t = d.getTimer();
        assertEquals(0, t.getSchedule());
        assertNotEquals(1000, t.getSchedule());
        t.setSchedule(1000);
        assertEquals(1000, t.getSchedule());
        assertNotEquals(2000, t.getSchedule());
    }

    @Test
    void isRunning() {
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
    void getTime() {
        Device d = new Device();
        d.getTimer().setTime(2);
        assertEquals(2000, d.getTimer().getTime()); //2000 because it is converted in the timer method
    }

    @Test
    void getAttachedDevice() {
        Device d = new Device();
        Timer t = d.getTimer();
        assertEquals(d, t.getAttachedDevice());
        assertNotNull(d.getTimer());
        assertNotNull(t.getAttachedDevice());

    }

    @Test
    void setTime() {
        Device d = new Device();
        d.getTimer().setTime(1);
        assertEquals(1000,d.getTimer().getTime());
        assertNotEquals(3, d.getTimer().getTime());
    }
}