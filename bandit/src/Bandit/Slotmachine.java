package Bandit;

import javax.swing.JOptionPane;
import java.util.Random;

public class Slotmachine {
	public static void main( String [ ] args) {
		
		String userStringInput;
		double userAmountEntered;
		Random random = new Random();
		int wordIndex;
		String word ="" ;
		String outputString="";
		String word1="";
		String word2="";
		String word3="";
	
		
		
		
		
			userStringInput = JOptionPane.showInputDialog("Insert money: ");
			userAmountEntered = Double.parseDouble( userStringInput);
			
			for( int wordCount  =1; wordCount <=3; wordCount++ ) {
				
				wordIndex = random.nextInt( 8 );
				
				if( wordIndex == 0 ) {
					word ="Devil ";
				} 
				
				else if ( wordIndex == 1 ) {
					word = "Wrath ";
				}
				else if ( wordIndex == 2 ) {
					word = "Sloth ";
				}
				else if ( wordIndex == 3 ) {
					word = "Pride ";
				}
				else if ( wordIndex == 4 ) {
					word = "Lust ";
				}
				else if ( wordIndex == 5 ) {
					word = "Greed ";
				}
				else if ( wordIndex == 6 ) {
					word = "Gluttony ";
				}
				else if ( wordIndex == 7 ) {
					word = "Envy ";
				}
				
				if (wordCount ==1 ) {
					word1 = word;	
				} 
				else if (wordCount ==2) {
					word2= word;
				}
				else if (wordCount ==3) {
					word3= word;
				}
				
			}
			outputString = outputString + "[ " + word1 + "]\t[ " + word2 + "]\t[ " + word3 +" ]" ;
			
			if((word1 != word2) && (word1 != word3) && (word2 != word3)) {
				outputString = outputString + "\n You have won £0";
			}
			
			JOptionPane.showMessageDialog(null, outputString);
			

			

			System.exit(0);
		}
		
	}
	
