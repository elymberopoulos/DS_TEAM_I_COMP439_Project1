package main;

import deviceManager.DeviceManager;
import deviceManager.UserInterfaceHelper;
import devices.Device;
import devices.SmartLight;
import devices.SmartPowerStrip;
import timer.Timer;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("timers");
        DeviceManager deviceManager = new DeviceManager();
        Map lights = deviceManager.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = deviceManager.getDeviceMap().put("power strips", new TreeMap<>());
        UserInterfaceHelper ui = new UserInterfaceHelper();
//        //TESTING VALUES FOR DEVELOPER//

//        Device light = new Device("ceiling lights");
//        Device light2 = new Device("ceiling lights");
//        Device powerStrip = new Device("power strip");
//
//        deviceManager.addDevice("lights", light, "lights");
//        deviceManager.addDevice("lighter", light2, "lights");
//        deviceManager.addDevice("power strip", powerStrip, "power strips");
//        deviceManager.moveDevice("power strip", "power strips", "lights");
//        deviceManager.moveDevice("lighter", "lights", "power strips");
//
//        System.out.println(deviceManager.getDeviceName("lights", "lights"));
//        deviceManager.setDeviceName("lights", "Ceiling Lights", "lights");
//        System.out.println(deviceManager.getDeviceName("lights", "lights"));
//        System.out.println("TESTING LIGHT");
//        SmartLight lightTest = new SmartLight("living room");
//        deviceManager.addDevice("smartlight", lightTest, "lights");
//        //light.startTimer();
//        //END OF TESTING VALUES FOR DEVELOPER//
        System.out.println("Please enter a command");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Type 'help' if needed.");
            String commandInput = scanner.nextLine().toLowerCase();

            switch (commandInput) {

                case "add device":
                    System.out.println("What type of device?\n\t < smart light >\n\t < smart power strip >");
                    String input = scanner.nextLine().toLowerCase();
                    if (input.contentEquals("smart light")) {
                        SmartLight newLight = deviceManager.generateSmartBulb();
                        System.out.print("<<<<<\t ENTER DEVICE INFORMATION\t>>>>>>\n" +
                                "\tDEVICE KEY: ");
                        String deviceKey = scanner.nextLine().toLowerCase();
                        System.out.print("\tDEVICE COLLECTION NAME: ");
                        String deviceCollection = scanner.nextLine().toLowerCase();
                        deviceManager.addDevice(deviceKey, newLight, deviceCollection);
                    } else if (input.contentEquals("smart power strip")) {
                        SmartPowerStrip newPower = deviceManager.generateSmartPowerStrip();
                        System.out.print("<<<<<\t ENTER DEVICE INFORMATION\t>>>>>>\n" +
                                "\tDEVICE KEY: ");
                        String deviceKey = scanner.nextLine().toLowerCase();
                        System.out.print("\tDEVICE COLLECTION NAME: ");
                        String deviceCollection = scanner.nextLine().toLowerCase();
                        deviceManager.addDevice(deviceKey, newPower, deviceCollection);
                    }
                    break;
                case "remove device":
                    System.out.print("\tEnter key of device to remove:");
                    String removeKey = scanner.nextLine().toLowerCase();
                    System.out.print("\tEnter name of the device's collection:");
                    String collection = scanner.nextLine().toLowerCase();
                    deviceManager.removeDevice(removeKey, collection);
                    break;
                case "update device":
                    break;
                case "move device":
                    deviceManager.showDevices();
                    System.out.println("This option allows for the moving of a device from its original collection to a new collection.");
                    System.out.print("What is the original collection name:");
                    String originalCollection = scanner.nextLine().toLowerCase();
                    System.out.print("What is the key name of the device to be moved:");
                    String key = scanner.nextLine().toLowerCase();
                    System.out.print("Enter destination collection name:");
                    String destinationCollection = scanner.nextLine().toLowerCase();
                    deviceManager.moveDevice(key, originalCollection, destinationCollection);
                    break;
                case "set timer":
                    System.out.print("<<<<<\t ENTER DEVICE INFORMATION\t>>>>>>\n" +
                            "\tDEVICE KEY: ");
                    String deviceKey = scanner.nextLine().toLowerCase();
                    System.out.print("\tDEVICE COLLECTION NAME: ");
                    String deviceCollection = scanner.nextLine().toLowerCase();
                    Device targetDevice = deviceManager.getDevice(deviceKey, deviceCollection);
                    Timer targetTimer = targetDevice.getTimer();
                    System.out.println("Please enter a timer time in seconds.");
                    int timeInput = Integer.parseInt(scanner.nextLine());
                    targetTimer.setTime(timeInput);
                    Thread thread = new Thread(targetTimer);
                    thread.start();
                    break;
                case "select device":
                    System.out.println("Supported devices: light and power strip");
                    System.out.println("Name the device");
                    String deviceName = scanner.nextLine();
                    System.out.println(deviceName);
                    if (deviceName.equalsIgnoreCase("light")) {
                        System.out.println("Light if statement");
                    }
                    if (deviceName.equalsIgnoreCase("power strip")) {
                        System.out.println("Power strip if statement");
                    }
                    break;
                case "show devices":
                    deviceManager.showDevices();
                    break;
                case "cls":
                    ui.cls();
                    break;
                case "help":
                    ui.help();
                    break;
                case "exit":
                    System.exit(0);

                default:
                    System.out.println("\n\n<<<<<<<    Invalid command try again.    >>>>>>>>>" +
                            "\n---------------------------------------------------\n\n");
            }

        } while (true);

    }
}
