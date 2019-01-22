package main;

import deviceManager.DeviceManager;
import devices.Device;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        DeviceManager deviceManager = new DeviceManager();
        Map lights = deviceManager.getDeviceMap().put("Lights", new TreeMap<>());
        Map powerStrips = deviceManager.getDeviceMap().put("Power Strips", new TreeMap<>());
        Device light = new Device("ceiling lights");
        Device light2 = new Device("ceiling lights");
        Device powerStrip = new Device("power strip");

        deviceManager.addDevice("lights", light, "Lights");
        deviceManager.addDevice("lighter", light2, "Lights");
        deviceManager.addDevice("power strip", powerStrip, "Power Strips");
        deviceManager.moveDevice("power strip", "Power Strips", "Lights");

        Scanner scanner = new Scanner(System.in);
        do {

            deviceManager.showDevices();

            System.out.println("Please enter a command");
            System.out.println("Valid commands are: exit, add device, dim device, turn on, turn off");
            String commandInput = scanner.nextLine().toLowerCase();
            //System.out.println("The command input is: " + commandInput);

            switch(commandInput) {

                case "add device" :
                    System.out.println("ADD DEVICE TRIGGERED");
                    break;

                case "select device" :
                    System.out.println("Supported devices: light and power strip");
                    System.out.println("Name the device");
                    String deviceName = scanner.nextLine();
                    System.out.println(deviceName);
                    if(deviceName.equalsIgnoreCase("light")){
                        System.out.println("Light if statement");
                    }
                    if(deviceName.equalsIgnoreCase("power strip")){
                        System.out.println("Power strip if statement");
                    }
                    break;
                case "exit" :
                    System.exit(0);

                default :
                    System.out.println("Invalid command try again.\n");
            }
            if (commandInput.contentEquals("exit")) {
                break;
            }

        }while(true);
        System.exit(0);
    }
}
