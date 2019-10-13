package Bandit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.Timer;




public class TimeInSeconds extends JFrame implements Runnable
{
	public static void main(String... args) throws InterruptedException {
		Thread.currentThread().join();
	}

	@Override
	public void run() {


	}
	
	public String timer() {
		// TODO Auto-generated method stub
		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		int interval = 1000; // 1000 ms

		new Timer(interval, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					Calendar now = Calendar.getInstance();
            		System.out.println(dateFormat.format(now.getTime()));
			}
		}).start(); 
		return "Time";
	}
	
}