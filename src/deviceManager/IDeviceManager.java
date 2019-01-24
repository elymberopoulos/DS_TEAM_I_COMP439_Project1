package deviceManager;

import devices.Device;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IDeviceManager {
    public Map<String, Map<String, Device>> getDeviceMap();
    public void showDevices();
    public void addDevice(String newKey, Device device, String targetCollection);
    public void removeDevice(String removeKey, String targetCollection);
    public void updateDevice(String updateKey, String newName, String targetCollection);
    public void moveDevice(String moveKey, String targetCollection, String destinationCollection);
}
