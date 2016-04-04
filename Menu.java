package bingo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
private Hopper hopper;
private Announcer announcer;
Scanner scanner;

	public Menu(){
		hopper = new Hopper();
		scanner = new Scanner(System.in);
		announcer = new Announcer();
	}
	
	public void displayMenu(){
		int playerResponse = 0;
		do{
			System.out.println("Make make a selection:\n(1)Draw a New Number\n(2)Show All Numbers Drawn\n(3)Show All Numbers Sorted by Letter\n(4)Print a New Card\n(5)Quit");
			playerResponse = getPlayerResponse();
			switch(playerResponse){
			case 1:
				drawNewNumber();
				break;
			case 2:
				showAllDrawnBalls();
				break;
			case 3:
				showAllDrawnBallsSorted();
				break;
			case 4:
				printANewCard();
				break;
			default:
				System.out.println("Thanks for playing.");
				System.exit(0);
			}
		}while(playerResponse<5);
		
	}
	
	private void printANewCard(){
		ArrayList<Integer> numbers = new ArrayList<>();//The list of all the numbers.
		ArrayList<Integer> subNumbersB = new ArrayList<>();//The list of the numbers which changes for each letter.
		ArrayList<Integer> subNumbersI = new ArrayList<>();
		ArrayList<Integer> subNumbersN = new ArrayList<>();
		ArrayList<Integer> subNumbersG = new ArrayList<>();
		ArrayList<Integer> subNumbersO = new ArrayList<>();
		
		for(int i=1; i<76; i++){
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		 for (Integer integer : numbers) {
				if(integer<16){//The B numbers
					subNumbersB.add(integer);
				}else if(integer<31){
					subNumbersI.add(integer);
				}else if(integer<46){
					subNumbersN.add(integer);
				}else if(integer < 61){
					subNumbersG.add(integer);
				}else{
					subNumbersO.add(integer);
				}
	           }
		
		  try {
	            FileWriter fw = new FileWriter("card.txt");
	            PrintWriter pw = new PrintWriter(fw);
	            pw.println("B\tI\tN\tG\tO");
	         
	           pw.println(subNumbersB.get(0) + "\t" + subNumbersI.get(0) + "\t" + subNumbersN.get(0) + "\t" + subNumbersG.get(0) + "\t" + subNumbersO.get(0)+"\n");
	           pw.println(subNumbersB.get(1) + "\t" + subNumbersI.get(1) + "\t" + subNumbersN.get(1) + "\t" + subNumbersG.get(1) + "\t" + subNumbersO.get(1)+"\n");
	           pw.println(subNumbersB.get(2) + "\t" + subNumbersI.get(2) + "\t\b\b" + "FREE\t" + subNumbersG.get(2) + "\t" + subNumbersO.get(2)+"\n");
	           pw.println(subNumbersB.get(3) + "\t" + subNumbersI.get(3) + "\t" + subNumbersN.get(3) + "\t" + subNumbersG.get(3) + "\t" + subNumbersO.get(3)+"\n");
	           pw.println(subNumbersB.get(4) + "\t" + subNumbersI.get(4) + "\t" + subNumbersN.get(4) + "\t" + subNumbersG.get(4) + "\t" + subNumbersO.get(4)+"\n");

	            pw.close();
	            FileReader fr = new FileReader("card.txt");
	            BufferedReader br = new BufferedReader(fr);
	            String line = "";
	            while((line=br.readLine()) != null){
	            	System.out.println(line);
	            }
	            br.close();
	        }
	        catch (IOException e) {
	            System.err.println(e.getMessage());
	        }
		 
	}
	private void showAllDrawnBallsSorted(){
		char desiredBall = getDesiredBallLetter();//Get the letter ball desired
		
		announcer.announceAllBallsSorted(desiredBall);
		
}
		
	private void showAllDrawnBalls(){
		announcer.announceAllBalls();
	}
	
	private char getDesiredBallLetter(){
		boolean loop = true;
		char responseChar;
		do{
			System.out.println("Please enter the letter of the ball desired: ");
			//scanner.next(); //clear out the junk
			String response = scanner.next();  //Get the response as a string.
			System.out.println(response);
			responseChar = response.toUpperCase().charAt(0); //Capture the string and get the first char
			if(responseChar =='B' || responseChar == 'I' || responseChar == 'N' || responseChar == 'G' || responseChar == 'O'){
				loop = false;
			}else{
				System.out.println("Please enter 'B', 'I', 'N', 'G', or 'O'");
			}
			
		}while(loop);
		return responseChar;
	}
	private void drawNewNumber(){
		if (hopper.getBalls().size()>0){
			Ball currentBall = hopper.getBalls().get(0);//Get the first ball in the list;
			
			announcer.addBall(currentBall);//Add the current ball to the list of all drawn balls
			announcer.announceBall(currentBall);
			hopper.removeBall(currentBall); //remove that ball from the hopper
		}else{
			hopper = new Hopper();
			Ball currentBall = hopper.getBalls().get(0);//Get the first ball in the list;
			System.out.println("Adding more balls");
			
			announcer.addBall(currentBall);//Add the current ball to the list of all drawn balls
			announcer.announceBall(currentBall);
			hopper.removeBall(currentBall); //remove that ball from the hopper
		}
			
		}
	private int getPlayerResponse(){
		boolean loop = true;
		int response = 0;
		while(loop){
			try{
			 response = scanner.nextInt();
			 if(response > 0 && response < 6){
					loop = false;
				}else{
					System.out.println("I'm sorry, please enter a number between 1 and 4.");
					
				}
			}catch(InputMismatchException e){
				System.out.println("I'm sorry, please enter a number between 1 and 4.");
				scanner.next();
			}
			
		}
		return response;
	}
	
	
}
