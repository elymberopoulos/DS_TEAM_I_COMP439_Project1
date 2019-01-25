package devices;

import timer.Timer;

public interface IDevice {
    public boolean isDeviceOn();
    public String showState();
    public Timer getTimer();
    public void setPowerSwitch();
}
