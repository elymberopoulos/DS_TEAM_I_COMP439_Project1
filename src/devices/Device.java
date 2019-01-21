package devices;

public class Device implements IDevice {
    private String deviceName;
    private boolean deviceOn;

    public Device(String deviceName){
        this.deviceName = deviceName;
        this.deviceOn = false;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isDeviceOn() {
        return deviceOn;
    }

    public void setDeviceOn(boolean deviceOn) {
        this.deviceOn = deviceOn;
    }

    @Override
    public boolean isOn() {
        return false;
    }

    @Override
    public void setOn() {
    }

    @Override
    public void moveDevice() {

    }

    @Override
    public void setTimer() {

    }
}
