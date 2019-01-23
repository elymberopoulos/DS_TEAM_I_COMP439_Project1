package timer;

import java.util.Date;
import java.util.Scanner;

public class Timer implements ITimer {

    private int time;

    public Timer(){
        this.time = 0;
    }
    private Thread threadGenerator(){
        return new Thread();
    }

    public int completeTask() {
        System.out.println("Please enter a timer time in seconds.");
        Scanner scanner = new Scanner(System.in);
        int timeInput = Integer.parseInt(scanner.nextLine());
        int convertedTime = timeInput * 1000;
        this.setTime(convertedTime);
        return convertedTime;
    }

    public void run() {
        try{
            System.out.println("Device timer started at:" + new Date());
            Thread.sleep(this.completeTask());
            System.out.println("Device timer finished at:" + new Date());
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
