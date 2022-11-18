import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FlashCardSet {
	private String name;
	private ArrayList<Flashcard> flashcards = new ArrayList<>();
	private ArrayList<Flashcard> incorrectFlashcards = new ArrayList<>();
	private ArrayList<Flashcard> starredFlashcards = new ArrayList<>();
	private long timeOriginallyOpened;
	private long timeElapsed;
	
	
	public FlashCardSet () {
		name = "";
	}
	
	public FlashCardSet (String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addFlashcard(Flashcard flashcard) {
		flashcards.add(flashcard);
	}
	
	public void saveSet() throws IOException {
		FileWriter file = new FileWriter(name + ".txt", true);
		for(int i = 0; i < flashcards.size(); i++) {
			file.write(flashcards.get(i).toString() + "\n");
		}
		file.close();
	}
	
	public void openSet(String name) throws FileNotFoundException {
		File file = new File(name);
		Scanner scanFile = new Scanner(file);
		System.out.println("About to Scan File");
		while(scanFile.hasNextLine()) {
			System.out.println("Scanning...");
			String[] temp = new String[3];
			String scannedFile = scanFile.nextLine();
			System.out.println(scannedFile);
			//temp = scanFile.next().split(",");
			temp = scannedFile.split(",");
			System.out.println(temp[0]);
			System.out.println(temp.length);
			Flashcard flashcard = new Flashcard(temp[0], temp[1], temp[2]);
			if(temp[3].contains("false")) {
				setMark(flashcard, 1);
			}
			if(temp[5].contains("*")) {
				starredFlashcards.add(flashcard);
			}
			addFlashcard(flashcard);
		}
		scanFile.close();
		
	}
	
	public int getSize() {
		int count = 0;
		for(int i = 0; i < flashcards.size(); i++) {
			count++;
		}
		
		return count;
	}
	
	public Flashcard getCard(int i) {
		Flashcard temp = new Flashcard();
		for(int j = 0; j < flashcards.size(); j++) {
			if(i == j) {
				temp = flashcards.get(j);
			} 
	}
		return temp;
	}
	
	public void shuffleDeck() {
		Collections.shuffle(flashcards);
	}
	
	public void setMark(Flashcard flashcard, int mark) {
		if(mark == 1) {
			incorrectFlashcards.add(flashcard);
			flashcard.setIncorrect();
		}
	}
	
	public Flashcard getIncorrectCard(int i) {
		Flashcard temp = new Flashcard();
		for(int j = 0; j < incorrectFlashcards.size(); j++) {
			if(i == j) {
				temp = incorrectFlashcards.get(j);
			} 
	}
		return temp;
	}
	
	public Flashcard getStarredCard(int i) {
		Flashcard temp = new Flashcard();
		for(int j = 0; j < starredFlashcards.size(); j++) {
			if(i == j) {
				temp = starredFlashcards.get(j);
			} 
	}
		return temp;
	}
	
	public int incorrectSetSize() {
		return incorrectFlashcards.size();
	}
	
	public void setStar(Flashcard flashcard, String starOrNot) {
		flashcard.setFlashcardStar(starOrNot);
	}
	
	public void setOrder(int order) {
		if (order == 1) {
			
		} else if (order == 2) {
			
		} else if (order == 3) {
			
		} else if (order == 4) {
			
		} else if (order == 5) {
			
		} else if (order == 6) {
			
		} else if (order == 7) {
			
		} else if (order == 8) {
			
		} else if (order == 9) {
			
		}
	}
	
	public void setTimeOriginallyOpened(long time) {
		timeOriginallyOpened = time;
	}
	
	public double getTimeOriginallyOpened() {
		return timeOriginallyOpened;
	}
	
	public void setTimeElapsed(long time) {
		timeElapsed = time - timeOriginallyOpened;
	}
	
	public long getTimeElapsed() {
		return timeElapsed;
	}
	
	public void addTimeToFlashcards() {
		for(int i = 0; i < flashcards.size(); i++) {
			flashcards.get(i).setTime(timeOriginallyOpened);
		}
	}
	
	
	

}
