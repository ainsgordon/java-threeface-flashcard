
public class Flashcard {
	
	private String side1;
	private String side2;
	private String side3;
	private boolean incorrect = true;
	private int incorrectCount = 0;
	private int timesSeen = 0;
	private double incorrectPercent;
	private String starred;
	private long time;
	
	
	public Flashcard() {
		side1 = null;
		side2 = null;
		side3 = null;
	}
	
	public Flashcard(String side1, String side2, String side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public String getSide1() {
		return side1;
	}

	public void setSide1(String side1) {
		this.side1 = side1;
	}

	public String getSide2() {
		return side2;
	}

	public void setSide2(String side2) {
		this.side2 = side2;
	}

	public String getSide3() {
		return side3;
	}

	public void setSide3(String side3) {
		this.side3 = side3;
	}
	
	public void setIncorrect() {
		incorrect = false;
	}
	
	public boolean getIncorrect() {
		return incorrect;
	}
	
	public void setTimesSeen() {
		timesSeen = timesSeen + 1;
	}
	
	public int getTimesSeen() {
		return timesSeen;
	}
	
	public void setInorrectFrequency() {
		incorrectCount = incorrectCount + 1;
	}
	
	public int getIncorrectFrequency() {
		return incorrectCount;
	}
	
	public void setIncorrectPercent() {
		incorrectPercent = ((double) incorrectCount) / timesSeen;
	}
	
	public double getIncorrectPercent() {
		return (((double) incorrectCount) / timesSeen);
	}
	
	public void setFlashcardStar(String starOrNot) {
		starred = starOrNot;
	}
	
	public String getFlashcardStar() {
		return starred;
	}
	
	public void setTime(long setTime) {
		time = setTime;
	}
	
	public long getTime() {
		return time;
	}
	
	
	public String toString() {
		String str = side1 + "," + side2 + "," + side3 + "," + getIncorrect() + "," + getIncorrectPercent() + "," + starred + "," + time;
		return str;
	}
	
	public String basicString() {
		String str = side1 + ", " + side2 + ", " + side3;
		return str;
	}
	
	

}
