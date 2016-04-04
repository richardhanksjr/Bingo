package bingo;

import java.util.ArrayList;
import java.util.Collections;

public class Hopper {
private ArrayList<Ball> balls;

public Hopper(){
	balls = new ArrayList<>();
	for (int i = 1; i<76; i++){
		if(i<16){
			balls.add(new Ball("B", i));
		}
		else if(i<31){
			balls.add(new Ball("I", i));
		}
		else if(i<46){
			balls.add(new Ball("N", i));
		}else if(i<60){
			balls.add(new Ball("G", i));
		}else{
			balls.add(new Ball("O", i));
		}
	}

}

public void addBall(Ball ball){
	balls.add(ball);
}

public void removeBall(Ball ball){
	balls.remove(ball);
}

public ArrayList<Ball> returnShuffledBalls(){
	Collections.shuffle(balls);
	return balls;
}
public ArrayList<Ball> getBalls() {
	Collections.shuffle(balls);
	return balls;
}
public void setBalls(ArrayList<Ball> balls) {
	this.balls = balls;
}

//public static void main(String[] args){
//	Hopper hopper = new Hopper();
//	
//}
}
