package bingo;

public class Ball {
private String ballLetter;
private int ballNumber;

public Ball(String ballName, int ballNumber){
	this.ballLetter = ballName;
	this.ballNumber = ballNumber;
}

@Override
public String toString() {
	return "Ball [ballLetter=" + ballLetter + ", ballNumber=" + ballNumber + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ballLetter == null) ? 0 : ballLetter.hashCode());
	result = prime * result + ballNumber;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Ball other = (Ball) obj;
	if (ballLetter == null) {
		if (other.ballLetter != null)
			return false;
	} else if (!ballLetter.equals(other.ballLetter))
		return false;
	if (ballNumber != other.ballNumber)
		return false;
	return true;
}

public int getBallNumber() {
	return ballNumber;
}

public void setBallNumber(int ballNumber) {
	this.ballNumber = ballNumber;
}

public String getBallLetter() {
	return ballLetter;
}

public void setBallLetter(String ballLetter) {
	this.ballLetter = ballLetter;
}
}
