package Bandit;
//imports
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

import java.awt.Font;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;



public class BanditWindow {
//setting up variables 
	private static final String String = null;
	private JFrame frmSinToWin;
	private String[] images = { "0.jpg", "1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg"};
	private JLabel Pos1;
	private JLabel Pos2;
	private JLabel Pos3;
	private JLabel lblcredits;
	private JButton btnadd; 
	private static DecimalFormat round = new DecimalFormat(".##");
	public  int zcount;
	public 	double currency = 0.00; 
	public int image1;
	public int image2;
	public int image3;
	public int imageOld1;
	public int imageOld2;
	public int imageOld3;
	public boolean hold1 = false;
	public boolean hold2 = false;
	public boolean hold3 = false;
	private JTextField addmoney;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { //running the application
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanditWindow window = new BanditWindow();
					window.frmSinToWin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BanditWindow() { //initialising window
		initialize();
		System.out.println("Started new game.");
		
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {

		frmSinToWin = new JFrame();
		frmSinToWin.setResizable(false);
		frmSinToWin.setTitle("SIN TO WIN");
		frmSinToWin.setBounds(100, 100, 438, 402);
		frmSinToWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSinToWin.getContentPane().setLayout(null);
		
		
		//Setting up buttons and giving them an icon image.
		JButton btnHold = new JButton("");
		btnHold.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\hold.jpg"));
		btnHold.setForeground(Color.BLACK);
		btnHold.setBounds(44, 148, 45, 45);
		frmSinToWin.getContentPane().add(btnHold);
		
		JButton btnHold2 = new JButton("");
		btnHold2.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\hold.jpg"));
		btnHold2.setForeground(Color.BLACK);
		btnHold2.setBounds(163, 148, 45, 45);
		frmSinToWin.getContentPane().add(btnHold2);
		
		JButton btnHold3 = new JButton("");
		btnHold3.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\hold.jpg"));
		btnHold3.setForeground(Color.BLACK);
		btnHold3.setBounds(282, 148, 45, 45);
		frmSinToWin.getContentPane().add(btnHold3);
		
		JButton BtnNudge = new JButton("");
		BtnNudge.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\nudge.jpg"));
		BtnNudge.setForeground(Color.BLACK);
		BtnNudge.setBounds(99, 148, 45, 45);
		frmSinToWin.getContentPane().add(BtnNudge);
		
		JButton BtnNudge2 = new JButton("");
		BtnNudge2.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\nudge.jpg"));
		BtnNudge2.setForeground(Color.BLACK);
		BtnNudge2.setBounds(218, 148, 45, 45);
		frmSinToWin.getContentPane().add(BtnNudge2);
		
		JButton BtnNudge3 = new JButton("");
		BtnNudge3.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\nudge.jpg"));
		BtnNudge3.setForeground(Color.BLACK);
		BtnNudge3.setBounds(338, 148, 45, 45);
		frmSinToWin.getContentPane().add(BtnNudge3);
		
		addmoney = new JTextField();
		addmoney.setForeground(new Color(255, 255, 255));
		addmoney.setBackground(new Color(0, 0, 0));
		addmoney.setBounds(299, 291, 125, 20);
		frmSinToWin.getContentPane().add(addmoney);
		addmoney.setColumns(10);
		
		
		JButton btnadd = new JButton("");
		btnadd.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\add.jpg"));
		btnadd.setBounds(198, 291, 89, 23);
		frmSinToWin.getContentPane().add(btnadd);
		
		JButton btncashout = new JButton("");
		btncashout.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\cashout.jpg"));
		btncashout.setBounds(335, 339, 89, 23);
		frmSinToWin.getContentPane().add(btncashout);
		
		JLabel lbldatetime = new JLabel("10/04/2018");
		lbldatetime.setFont(new Font("Tahoma", Font.BOLD, 26));
		lbldatetime.setForeground(Color.WHITE);
		lbldatetime.setBounds(0, 0, 258, 37);
		frmSinToWin.getContentPane().add(lbldatetime);
		
		// DYNAMIC TEXT FIELDS. These can be changed by the players input
		JLabel lblwinlose = new JLabel("");
		lblwinlose.setBackground(Color.PINK);
		lblwinlose.setHorizontalAlignment(SwingConstants.RIGHT);
		lblwinlose.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblwinlose.setForeground(Color.WHITE);
		lblwinlose.setBounds(67, 243, 367, 37);
		frmSinToWin.getContentPane().add(lblwinlose);
		
		
		JLabel lblcredits = new JLabel("CREDITS: \u00A3 "+round.format(currency), SwingConstants.RIGHT); 
		//implements rounding to 2 decimal places
		lblcredits.setForeground(Color.WHITE);
		lblcredits.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblcredits.setBounds(0, 0, 422, 42);
		

		frmSinToWin.getContentPane().add(lblcredits);
		JButton btnspin = new JButton("");
		btnspin.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\spin.jpg"));
		btnspin.setBounds(334, 219, 90, 23);
		btnspin.setVisible(true);
		frmSinToWin.getContentPane().add(btnspin);

		btnadd.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
		if (e.getSource() ==btnadd) {
			currency += Double.parseDouble(addmoney.getText());
			lblcredits.setText( "CREDITS: £ "+round.format(currency));
			btnspin.setEnabled(true);
			
			
		}
				
			}
		});
		
		// button hold 1
		btnHold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hold1 = true;
				imageOld1 = image1;
				System.out.println("Hold button 1 pressed");
			}
		});
		
		// button hold 2
		btnHold2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hold2 = true;
				imageOld2 = image2;
				System.out.println("Hold button 2 pressed");
			}
		});
	
		// button hold 3
		btnHold3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hold3 = true;
				imageOld3 = image3;
				System.out.println("Hold button 3 pressed");
			}
		});
		
		// button spin
		btnspin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Spin button pressed");
			System.out.println(round.format(currency));
			lblwinlose.setText( "" );
			currency -= 0.50;
			lblcredits.setText( "CREDITS: £ "+round.format(currency));
			int delay = 40; // delay for 1 sec. 
		    int period = 100; // repeat every sec. 
		    Timer timer = new Timer(); 
			playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\spin.wav"); //plays this sound on spin button press.
		
	    
		    timer.scheduleAtFixedRate(new TimerTask() //setting up timer for random image generator
	        {
		        public void run() {
					int n = (int) Math.floor(Math.random() *8); // 1 
					int n1 = (int) Math.floor(Math.random() *8); // 2 
					int n2 = (int) Math.floor(Math.random() *8); // 3
					
					image1 = n;
					image2 = n1;
					image3 = n2;
					
					//needed for the hold buttons.
					if ( hold1 == true ) { 
						n = imageOld1;
					}
					if ( hold2 == true ) {
						n1 = imageOld2;
					}
					if ( hold3 == true ) {
						n2 = imageOld3;
					} 
					
					String image1 = images[n];
					Pos1.setIcon(new ImageIcon ("src\\images\\" + image1));
					
					String image2 = images[n1];
					Pos2.setIcon(new ImageIcon ("src\\images\\" + image2));
					
					String image3 = images[n2];
					Pos3.setIcon(new ImageIcon ("src\\images\\" + image3));
					zcount=zcount+1;
					//stops the images spinning 
					if (zcount == 8) {
						timer.cancel();
						hold1 = false;
						hold2 = false;
						hold3 = false;
						zcount = 0;
						//setting up matches
						// The devil wins
						if ( n == 0 && n1 == 0 && n2 == 0 ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\your_soul_is_mine.wav");
							currency = 0;
							lblwinlose.setText("HE TAKES YOUR MONEY AND YOUR SOUL!");
							frmSinToWin.setVisible(false);
							System.out.println("You matched 3 devil tokens, you lose all your money and the game is over!");
							 
						}
						// If 2 Devils then half money
						else if ( (n == 0 && n1 == 0) || (n1 == 0 && n2 == 0) || (n2 == 0 && n == 0) ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\mwhaha.wav");
							currency -= currency / 2;
							lblwinlose.setText( "HE TAKES HALF!" );
							System.out.println("You matched 2 devil tokens, you lose half your money");
						}
						//lust 3
						else if ( n == 4 && n1 == 4 && n2 == 4 ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\lust.wav");
							currency += 15;
							lblwinlose.setText("YOU LUSTY LADY! You win £15");
							System.out.println("You matched 3 lust tokens, you won £15");
						}
						// lust 2
						else if ( (n == 4 && n1 == 4) || (n1 == 4 && n2 == 4) || (n2 == 4 && n == 4) ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\lust.wav");
							currency += 1.5;
							lblwinlose.setText( "LUSTY BUSTY! You win £1.50" );
							System.out.println("You matched 2 lust tokens, you won £1.50");
						}
						
						//greed 3
						else if ( n == 5 && n1 == 5 && n2 == 5 ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\greed.wav");
							currency += 20;
							lblwinlose.setText("GREEDY BOY! You win £20");
							System.out.println("You matched 3 greed tokens, you won £20");
						}
						// greed 2
						else if ( (n == 5 && n1 == 5) || (n1 == 5 && n2 == 5) || (n2 == 5 && n == 5) ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\greed.wav");
							currency += 2;
							lblwinlose.setText( "GREED! You win £2" );
							System.out.println("You matched 2 greed tokens, you won £2");
						}
						
						//Sloth 3
						else if ( n == 2 && n1 == 2 && n2 == 2 ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\sloth.wav");
							currency += 7.50;
							lblwinlose.setText("Is that even worth? £7.50");
							System.out.println("You matched 3 sloth tokens, you won £7.50");
						}
						// sloth 2
						else if ( (n == 2 && n1 == 2) || (n1 == 2 && n2 == 2) || (n2 == 2 && n == 2) ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\sloth.wav");
							currency += 0.20;
							lblwinlose.setText( "I mean you won, but it was only 20p" );
							System.out.println("You matched 2 sloth tokens, you only won 20p");
						}
						//wrath 3
						else if ( n == 1 && n1 == 1 && n2 == 1 ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\wrath.wav");
							currency += 5;
							lblwinlose.setText("Wrath! £5");
							System.out.println("You matched 3 Wrath tokens, you won £5");
						}
						// wrath 2
						else if ( (n == 1 && n1 == 1) || (n1 == 1 && n2 == 1) || (n2 == 1 && n == 1) ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\wrath.wav");
							currency += 1;
							lblwinlose.setText( "Wrath! £1" );
							System.out.println("You matched 2 Wrath tokens, you won £1");
						}
						//pride 3
						else if ( n == 3 && n1 == 3 && n2 == 3 ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\pride.wav");
							currency += 5;
							lblwinlose.setText("Pride! £5");
							System.out.println("You matched 3 Pride tokens, you won £5");
						}
						// pride 2
						else if ( (n == 3 && n1 == 3) || (n1 == 3 && n2 == 3) || (n2 == 3 && n == 3) ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\pride.wav");
							currency += 1;
							lblwinlose.setText( "Pride! £1" );
							System.out.println("You matched 2 Pride tokens, you won £1");
						}
						//gluttony 3
						else if ( n == 6 && n1 == 6 && n2 == 6 ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\gluttony.wav");
							currency += 5;
							lblwinlose.setText("Gluttony! £5");
							System.out.println("You matched 3 Gluttony tokens, you won £5");
						}
						// gluttony 2
						else if ( (n == 6 && n1 == 6) || (n1 == 6 && n2 == 6) || (n2 == 6 && n == 6) ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\gluttony.wav");
							currency += 1;
							lblwinlose.setText( "Gluttony! £1" );
							System.out.println("You matched 2 Gluttony tokens, you won £1");
						}
						//envy 3
						else if ( n == 7 && n1 == 7 && n2 == 7 ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\envy.wav");
							currency += 5;
							lblwinlose.setText("Envy! £5");
							System.out.println("You matched 3 Envy tokens, you won £5");
						}
						// envy 2
						else if ( (n == 7 && n1 == 7) || (n1 == 7 && n2 == 7) || (n2 == 7 && n == 7) ) {
							playSound("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\src\\audio\\envy.wav");
							currency += 1;
							lblwinlose.setText( "Envy! £1" );
							System.out.println("You matched 2 envy tokens, you won £1");
						}
			
						else if 
						(currency < 0.5) {
							Component frame = null;
							JOptionPane.showMessageDialog(frame,
								    "You are out of money! Add money to continue.");
							btnspin.setEnabled(false);
							System.out.println("Ran out of money");
						}
						
						else {
							lblwinlose.setText( "TRY AGAIN!");
							System.out.println("Not a win.");
							System.out.println("   ");
						}
						lblcredits.setText( "CREDITS: £ "+round.format(currency));
						{
	 
						
							}
					}
				
		        }

			
	        }, delay, period);
		}
//handler for playing sounds
		private void playSound(String string) {
			   try 
			   {
			    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(string).getAbsoluteFile( ));
			    Clip clip = AudioSystem.getClip( );
			    clip.open(audioInputStream);
			    clip.start( );
			   }
			   catch(Exception ex)
			   {
			     System.out.println("Error with playing sound.");
			     ex.printStackTrace( );
			   }
			
		}


		
	});

		
	//setting up nudge buttons	
		BtnNudge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int) Math.floor(Math.random() *8);
				
				String image1 = images[n];
				Pos1.setIcon(new ImageIcon ("src\\images\\" + image1));
				
				System.out.println("Nudge Button 1 pressed");
				currency -= 0.50;
				lblcredits.setText( "CREDITS: £ "+round.format(currency));
				
			}
		});
		
		
		BtnNudge2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n1 = (int) Math.floor(Math.random() *8);
				
				String image1 = images[n1];
				Pos2.setIcon(new ImageIcon ("src\\images\\" + image1));
				
				System.out.println("Nudge Button 2 pressed");
				currency -= 0.50;
				lblcredits.setText( "CREDITS: £ "+round.format(currency));
			}
		});
		
		
		BtnNudge3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n2 = (int) Math.floor(Math.random() *8);
				
				String image1 = images[n2];
				Pos3.setIcon(new ImageIcon ("src\\images\\" + image1));
				
				System.out.println("Nudge Button 3 pressed");
				currency -= 0.50;
				lblcredits.setText( "CREDITS: £ "+round.format(currency));
			}
		});
		
		btncashout.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
					    "Cashing out with £ "+round.format(currency) );
				System.out.println("You cashed out with "+round.format(currency) );
				frmSinToWin.setVisible(false);
			}
			});
		
			
		
	
		Pos1 = new JLabel("");
		Pos1.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\default.jpg"));
		Pos1.setBounds(44, 42, 101, 101);
		frmSinToWin.getContentPane().add(Pos1);
		
		Pos2 = new JLabel("");
		Pos2.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\default.jpg"));
		Pos2.setBounds(163, 42, 101, 101);
		frmSinToWin.getContentPane().add(Pos2);
		
		Pos3 = new JLabel("");
		Pos3.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\default.jpg"));
		Pos3.setBounds(282, 42, 101, 101);
		frmSinToWin.getContentPane().add(Pos3);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\images\\background.jpg"));
		background.setBounds(0, 0, 434, 374);
		frmSinToWin.getContentPane().add(background);
		
		//Writes all the code written in to the console to an out put file
		PrintStream out = null;
		try {
			out = new PrintStream(new FileOutputStream("I:\\year 2\\Programming and systems\\Assignment 2\\bandit\\gamelog\\output_"+System.currentTimeMillis()+".txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.setOut(out);

		
		
	}


	}
	

	
