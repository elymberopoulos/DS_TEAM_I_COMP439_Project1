package main;

import deviceManager.DeviceManager;
import devices.Device;
import timer.Timer;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        //TESTING VALUES FOR DEVELOPER//

        DeviceManager deviceManager = new DeviceManager();
        Map lights = deviceManager.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = deviceManager.getDeviceMap().put("power strips", new TreeMap<>());
        Device light = new Device("ceiling lights");
        Device light2 = new Device("ceiling lights");
        Device powerStrip = new Device("power strip");

        deviceManager.addDevice("lights", light, "lights");
        deviceManager.addDevice("lighter", light2, "lights");
        deviceManager.addDevice("power strip", powerStrip, "power strips");
        deviceManager.moveDevice("power strip", "power strips", "lights");
        deviceManager.moveDevice("lighter", "lights", "power strips");

        System.out.println(deviceManager.getDeviceName("lights", "lights"));
        deviceManager.setDeviceName("lights", "Ceiling Lights", "lights");
        System.out.println(deviceManager.getDeviceName("lights", "lights"));
        System.out.println("TESTING TIMER PAUSE");
        //light.startTimer();
        //END OF TESTING VALUES FOR DEVELOPER//

        Scanner scanner = new Scanner(System.in);
        do {

            deviceManager.showDevices();

            System.out.println("Please enter a command");
            System.out.println("Valid commands are: exit, add device, dim device, turn on, turn off");
            String commandInput = scanner.nextLine().toLowerCase();

            switch(commandInput) {

                case "add device" :
                    System.out.println("ADD DEVICE TRIGGERED");
                    break;

                case "remove device" :

                case "update device" :

                case "move device" :

                case "set timer" :
                    System.out.print("<<<<<\t ENTER DEVICE INFORMATION\t>>>>>>\n" +
                                    "\tDEVICE KEY: ");
                    String deviceKey = scanner.nextLine();
                    System.out.print("\tDEVICE COLLECTION NAME: ");
                    String deviceCollection = scanner.nextLine();
                    Device targetDevice = deviceManager.getDevice(deviceKey, deviceCollection);
                    Timer targetTimer = targetDevice.getTimer();
                    Thread thread = new Thread(targetTimer);
                    thread.start();
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
                    System.out.println("\n\n<<<<<<<    Invalid command try again.    >>>>>>>>>" +
                            "\n---------------------------------------------------\n\n");
            }

        }while(true);

    }
}
