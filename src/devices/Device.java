package devices;
import timer.Timer;
import java.util.Date;
import java.util.Scanner;

public class Device implements IDevice {
    private String deviceName;
    private boolean powerSwitch;
    private Timer timer;

    public Device(String deviceName){
        this.deviceName = deviceName;
        this.powerSwitch = false;
        this.timer = new Timer();
    }
    public Timer getTimer(){
        return timer;
    }

    public void startTimer(){
        timer.run();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setPowerSwitch() {
        if(this.powerSwitch == true){
            this.powerSwitch = false;
        }
        else{
            this.powerSwitch = true;
        }
    }

    public boolean isDeviceOn() {
        return powerSwitch;
    }

    public String showState() {
        return null;
    }
}
