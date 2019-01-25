package timer;

import devices.Device;

import java.util.Date;

public class Timer implements ITimer {

    private int time;
    private boolean running;
    private Device attachedDevice;
    private long schedule;


    public Timer(int time, Device attachedDevice) {
        this.time = time;
        this.running = false;
        this.attachedDevice = attachedDevice;
        this.schedule = 0;
    }
    public long getSchedule(){
        return this.schedule;
    }

    public void setSchedule(long waitTime){
        this.schedule = waitTime;
    }

    public boolean isRunning() {
        return running;
    }

    public int getTime() {
        return time;
    }

    public Device getAttachedDevice() {
        return attachedDevice;
    }

    public void setTime(int time) {
        this.time = time * 1000;
    }

    public int completeTask() {
        return 0;
    }

    public void run() {
        System.out.println("Schedule wait STARTED at: " + new Date());
        try{
            Thread.sleep(this.getSchedule());
            System.out.println("Schedule wait ENDED at: " + new Date());
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Device timer started at:" + new Date());
        this.running = true;
        try {
            Thread.sleep(this.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setTime(0);
        this.setSchedule(0);
        this.running = false;
        System.out.println("Device timer finished at:" + new Date());
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



//    public boolean timerAlarm(){
//        if(this.getTime() == 0){
//            return true;
//        }
//        return false;
//    }

//    public int completeTask() {
//        if(this.getTime() == 0){
//            System.out.println("NO TIMER VALUE");
//            return 0;
//        }
//        this.running = true;
//        return this.getTime();
//    }
//
//    public void run() {
//        try{
//            System.out.println("Device timer started at:" + new Date());
//            int time = this.completeTask();
//            Thread.sleep(time);
//            this.setTime(0);
//            this.running = false;
//            System.out.println("Device timer finished at:" + new Date());
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//    }



}
