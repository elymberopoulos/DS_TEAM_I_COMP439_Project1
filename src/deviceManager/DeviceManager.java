package deviceManager;

import devices.Device;

import java.util.*;

public class DeviceManager implements IDeviceManager {
    private TreeMap<String, Map<String, Device>> deviceMap;



    public DeviceManager(){
        //this.deviceMap = new TreeMap<String, Map<String, Map<String, Device>>>();
        this.deviceMap = new TreeMap<String, Map<String, Device>>();
    }

    public Map<String, Map<String, Device>> getDeviceMap() {

        return deviceMap;
    }

    public void showDevices(){
        System.out.println("CURRENT DEVICES");
        System.out.println("_______________________________________________");
        for (String key : this.getDeviceMap().keySet()){
            System.out.println(key + " " + this.getDeviceMap().get(key));
        }
        System.out.println("_______________________________________________");

    }

    public void addDevice(String newKey, Device device, String targetCollection) {
        for(Map.Entry<String, Map<String, Device>> entry : this.getDeviceMap().entrySet()){
            if (entry.getKey() == targetCollection){
                entry.getValue().put(newKey, device);
            }
        }
    }

    public void removeDevice(String removeKey, Device device, String targetCollection) {
        for(Map.Entry<String, Map<String, Device>> entry : this.getDeviceMap().entrySet()){
            if (entry.getKey() == targetCollection){
                entry.getValue().remove(removeKey);
            }
        }
    }

    public void updateDevice(String updateKey, Device device, String targetCollection) {
        for(Map.Entry<String, Map<String, Device>> entry : this.getDeviceMap().entrySet()){
            if (entry.getKey() == targetCollection){
                entry.getValue().forEach((key, value) -> {

                });
            }
        }
    }

    public void moveDevice(String moveKey, String targetCollection, String destinationCollection) {
        Device placeHolder;
        for(Map.Entry<String, Map<String, Device>> entry : this.getDeviceMap().entrySet()){
            if (entry.getKey() == targetCollection && entry.getValue().containsKey(moveKey)){
                placeHolder = entry.getValue().get(moveKey);
                entry.getValue().remove(moveKey);
                this.addDevice(moveKey, placeHolder, destinationCollection);
            }
        }
    }
}
