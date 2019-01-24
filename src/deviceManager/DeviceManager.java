package deviceManager;

import devices.Device;
import devices.SmartLight;
import devices.SmartPowerStrip;

import java.util.*;

public class DeviceManager implements IDeviceManager {
    private TreeMap<String, Map<String, Device>> deviceMap;


    public DeviceManager() {
        //this.deviceMap = new TreeMap<String, Map<String, Map<String, Device>>>();
        this.deviceMap = new TreeMap<String, Map<String, Device>>();
    }

    public SmartLight generateSmartBulb() {
        return new SmartLight("default smart light");
    }

    public SmartPowerStrip generateSmartPowerStrip() {
        return new SmartPowerStrip("default power strip");
    }

    public Map<String, Map<String, Device>> getDeviceMap() {

        return deviceMap;
    }

    public void showDevices() {
        System.out.println("\t\t\t\t<<<<<<<< CURRENT DEVICES >>>>>>>>>");
        System.out.println("______________________________________________________________________");
        for (String key : this.getDeviceMap().keySet()) {
            System.out.println("CATEGORY: " + "'" + key + "'" + ": " + this.getDeviceMap().get(key));
        }
        System.out.println("----------------------------------------------------------------------");

    }

    public void addDevice(String newKey, Device device, String targetCollection) {
        for (Map.Entry<String, Map<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase(targetCollection) && !entry.getValue().containsKey(newKey)) {
                entry.getValue().put(newKey, device);
            }
        }
    }

    public void removeDevice(String removeKey, String targetCollection) {
        for (Map.Entry<String, Map<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase(targetCollection) && entry.getValue().containsKey(removeKey)) {
                entry.getValue().remove(removeKey);
            }
        }
    }

    public String getDeviceName(String key, String targetCollection) {
        for (Map.Entry<String, Map<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey() == targetCollection) {
                return entry.getValue().get(key).getDeviceName();
            }
        }
        System.out.println("The device was not found.");
        return null;
    }

    public void setDeviceName(String key, String newName, String targetCollection) {
        for (Map.Entry<String, Map<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase(targetCollection) && entry.getValue().containsKey(key)) {
                entry.getValue().get(key).setDeviceName(newName);
                System.out.println("The device name was changed to: " + newName);
            }
        }
    }


    public Device getDevice(String key, String targetCollection) {
        for (Map.Entry<String, Map<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase(targetCollection) && entry.getValue().containsKey(key)) {
                return entry.getValue().get(key);
            }
        }
        return null;
    }

    public void updateDevice(String updateKey, String newName, String targetCollection) {
        for (Map.Entry<String, Map<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase(targetCollection) && entry.getValue().containsKey(updateKey)) {
                entry.getValue().get(updateKey).setDeviceName(newName);
            }
        }
    }

    public void moveDevice(String moveKey, String targetCollection, String destinationCollection) {
        Device placeHolder;
        for (Map.Entry<String, Map<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase(targetCollection) && entry.getValue().containsKey(moveKey)) {
                placeHolder = entry.getValue().remove(moveKey);
                this.addDevice(moveKey, placeHolder, destinationCollection);
            }
        }
    }
}
