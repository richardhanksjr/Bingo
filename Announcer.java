package bingo;

import java.util.ArrayList;

public class Announcer {
private ArrayList<Ball> currentBalls;

public static void main(String[] args){
	Menu menu = new Menu();
	menu.displayMenu();
	
}
	public Announcer(){
		this.currentBalls = new ArrayList<>();
	}
	
	public void announceAllBalls(){
		System.out.println("The following balls have been drawn so far: ");
		for (Ball ball : currentBalls) {
			System.out.println(ball.getBallLetter() + " " + ball.getBallNumber());
		}
	}
	
	public void announceAllBallsSorted(char ballLetter){
		String ballString = ballLetter + "";
		System.out.println("The following numbers have been drawn for letter " + ballLetter + ": ");
		
		if(ballString.equals("B")){
			for (Ball ball : currentBalls) {
				if(ball.getBallLetter().equals(ballString)){
					System.out.println(ball.getBallNumber());
				}
			}
		}else if(ballString.equals("I")){
			for (Ball ball : currentBalls) {
				if(ball.getBallLetter().equals(ballString)){
					System.out.println(ball.getBallNumber());
				}
			}
		}else if(ballString.equals("N")){
			for (Ball ball : currentBalls) {
				if(ball.getBallLetter().equals(ballString)){
					System.out.println(ball.getBallNumber());
				}
			}
		}else if(ballString.equals("G")){
			for (Ball ball : currentBalls) {
				if(ball.getBallLetter().equals(ballString)){
					System.out.println(ball.getBallNumber());
				}
			}
		}else if(ballString.equals("O")){
			for (Ball ball : currentBalls) {
				if(ball.getBallLetter().equals(ballString)){
					System.out.println(ball.getBallNumber());
				}
			}
		}
	}
	public void addBall(Ball ball){
		currentBalls.add(ball);
		
	}
		public ArrayList<Ball> getCurrentBalls() {
		return currentBalls;
	}
	
	public void setCurrentBalls(ArrayList<Ball> currentBalls) {
		this.currentBalls = currentBalls;
	}
	
		public void announceBall(Ball ball){
			System.out.println("The next ball is " + ball.getBallLetter()+ "" + ball.getBallNumber());
		}
}
