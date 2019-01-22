package devices;

public class Device implements IDevice, Runnable {
    private String deviceName;
    private boolean powerSwitch;

    public Device(String deviceName){
        this.deviceName = deviceName;
        this.powerSwitch = false;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean powerSwitch() {
        return powerSwitch;
    }

    public void setPowerSwitch() {
        if(this.powerSwitch == true){
            this.powerSwitch = false;
        }
        else{
            System.out.println("Device already off.");
        }
    }

    public void run() {

    }

    public boolean isDeviceOn() {
        return this.powerSwitch();
    }

    public String showState() {
        return null;
    }
}
