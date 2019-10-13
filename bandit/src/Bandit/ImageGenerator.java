package Bandit;


import java.util.Timer;
import java.util.TimerTask;

public class ImageGenerator {
	
    private Timer timer = new Timer();

    public static void main(String[] args) {
    	ImageGenerator manager = new ImageGenerator();
        manager.startTask();
    }

    public void startTask() {
        timer.schedule(new PeriodicTask(), 0);
    }

    private class PeriodicTask extends TimerTask {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + " Running");

            /* replace with the actual task */
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            /* end task processing */

            timer.stop();
            timer.schedule(new PeriodicTask(), 10 * 1000);
        }
    }
    
}
