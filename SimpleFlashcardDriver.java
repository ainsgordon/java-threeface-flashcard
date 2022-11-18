import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleFlashcardDriver implements Comparable<String>  {
	public static void main(String[] args) throws IOException {
		
		FlashCardSet userSet = new FlashCardSet();
		boolean cont = true;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println(System.currentTimeMillis());
		
		System.out.println("Would you like to open a previous set of flashcards? (Y/N)");
		String userInput = keyboard.nextLine();
		if(userInput.toUpperCase().compareTo("Y") == 0) {
			System.out.println("Enter the name of your set.");
			userInput = keyboard.nextLine();
			userSet.openSet(userInput);
			userSet.setTimeElapsed(System.currentTimeMillis());
		} else {
		
		System.out.println("Name your set of flashcards:");
		userInput = keyboard.nextLine();
		userSet.setName(userInput);
		
		System.out.println("Would you like to enter a flashcard? (Y/N)");
		userInput = keyboard.nextLine();
		
//		userInput.compareTo("Y");
		
		if(userInput.toUpperCase().compareTo("Y") == 0) {
			while(cont == true) {
			System.out.println("Enter the first side of your flashcard: ");
			userInput = keyboard.nextLine();
			Flashcard userCard = new Flashcard();
			userCard.setSide1(userInput);
			System.out.println("Enter the second side of your flashcard: ");
			userInput = keyboard.nextLine();
			userCard.setSide2(userInput);
			System.out.println("Enter the third side of your flashcard: ");
			userInput = keyboard.nextLine();
			userCard.setSide3(userInput);
			
			userCard.setFlashcardStar("+");
			
			userSet.addFlashcard(userCard);
			
			System.out.println("Enter (Y/N) to create another flashcard.");
			userInput = keyboard.nextLine();
			if(userInput.toUpperCase().equals("Y")) {
				cont = true;
			} else {
				cont = false;
			}
			}
//			userSet.saveSet();
			
		} else {
			System.out.println("Flashcard creator terminated.");
		}
		}
		userSet.setTimeOriginallyOpened(System.currentTimeMillis());
		System.out.println(userSet.getTimeOriginallyOpened());
		System.out.println("Would you like to shuffle the deck? Y/N");
		userInput = keyboard.nextLine();
		if(userInput.contains("Y")) {
			userSet.shuffleDeck();
			for(int i = 0; i < 5; i++) {
//				System.out.println(userSet.getCard(i));
				userSet.shuffleDeck();
			}
		}
		
		
		System.out.println("How would you like your flashcards displayed?");
		System.out.println("Enter 1 for sides 1 and 2");
		System.out.println("Enter 2 for sides 2 and 3");
		System.out.println("Enter 3 for sides 1 and 3");
		System.out.println("Enter 4 for sides 2 and 1");
		System.out.println("Enter 5 for sides 3 and 1");
		System.out.println("Enter 6 for sides 3 and 2");
		System.out.println("Enter 7 to show sides 1, 2, and 3");
		System.out.println("Enter 8 to show sides 2, 3, and 1");
		System.out.println("Enter 9 to show sides 3, 2, and 1");
		userInput = keyboard.nextLine();
		
		
		System.out.println("Type the correct answer for the side displayed.");
		
		if(userInput.compareTo("1") == 0) {
			userSet.setOrder(1);
			for(int i = 0; i < userSet.getSize(); i++) {
				System.out.println(userSet.getCard(i).getSide1());
				userSet.getCard(i).setTimesSeen();
				userInput = keyboard.nextLine();
				if(userInput.contains(userSet.getCard(i).getSide2())) {
					System.out.println("correct!");
					
				} else {
					System.out.println("incorrect!");
					userSet.setMark(userSet.getCard(i), 1);
					userSet.getCard(i).setInorrectFrequency();
					
					
				}
			}
		}
		else if (userInput.compareTo("2") == 0) {
			userSet.setOrder(2);
			for(int i = 0; i < userSet.getSize(); i++) {
				System.out.println(userSet.getCard(i).getSide2());
				userSet.getCard(i).setTimesSeen();
				userInput = keyboard.nextLine();
				if(userInput.contains(userSet.getCard(i).getSide3())) {
					System.out.println("correct!");
					
				} else {
					System.out.println("incorrect!");
					userSet.setMark(userSet.getCard(i), 1);
					userSet.getCard(i).setInorrectFrequency();
					
					
				}
			}
			
		}
		else if (userInput.compareTo("3") == 0) {
			userSet.setOrder(3);
			for(int i = 0; i < userSet.getSize(); i++) {
				System.out.println(userSet.getCard(i).getSide1());
				userSet.getCard(i).setTimesSeen();
				userInput = keyboard.nextLine();
				if(userInput.contains(userSet.getCard(i).getSide3())) {
					System.out.println("correct!");
					
				} else {
					System.out.println("incorrect!");
					userSet.setMark(userSet.getCard(i), 1);
					userSet.getCard(i).setInorrectFrequency();
					
				}
			}
			
		} else if (userInput.compareTo("4") == 0) {
			userSet.setOrder(4);
			for(int i = 0; i < userSet.getSize(); i++) {
				System.out.println(userSet.getCard(i).getSide2());
				userSet.getCard(i).setTimesSeen();
				userInput = keyboard.nextLine();
				if(userInput.contains(userSet.getCard(i).getSide1())) {
					System.out.println("correct!");
					
				} else {
					System.out.println("incorrect!");
					userSet.setMark(userSet.getCard(i), 1);
					userSet.getCard(i).setInorrectFrequency();
					
				}
			}
		} else if (userInput.compareTo("5") == 0) {
			userSet.setOrder(5);
			for(int i = 0; i < userSet.getSize(); i++) {
				System.out.println(userSet.getCard(i).getSide3());
				userSet.getCard(i).setTimesSeen();
				userInput = keyboard.nextLine();
				if(userInput.contains(userSet.getCard(i).getSide1())) {
					System.out.println("correct!");
					
				} else {
					System.out.println("incorrect!");
					userSet.setMark(userSet.getCard(i), 1);
					userSet.getCard(i).setInorrectFrequency();
					
				}
			}
		} else if (userInput.compareTo("6") == 0) {
			userSet.setOrder(6);
			for(int i = 0; i < userSet.getSize(); i++) {
				System.out.println(userSet.getCard(i).getSide3());
				userSet.getCard(i).setTimesSeen();
				userInput = keyboard.nextLine();
				if(userInput.contains(userSet.getCard(i).getSide2())) {
					System.out.println("correct!");
	
				} else {
					System.out.println("incorrect!");
					userSet.setMark(userSet.getCard(i), 1);
					userSet.getCard(i).setInorrectFrequency();
					
				}
			}
		} else if (userInput.compareTo("7") == 0) {
			userSet.setOrder(7);
			for(int i = 0; i < userSet.getSize(); i++) {
				System.out.println(userSet.getCard(i).getSide1());
				userSet.getCard(i).setTimesSeen();
				userInput = keyboard.nextLine();
				if(userInput.contains(userSet.getCard(i).getSide2())) {
					System.out.println("correct!");
					System.out.println("What is side 3?");
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getCard(i).getSide3())) {
						System.out.println("correct!");
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				} else {
					System.out.println("incorrect!");
					userSet.setMark(userSet.getCard(i), 1);
					userSet.getCard(i).setInorrectFrequency();
				}
			}
		} else if (userInput.compareTo("8") == 0) {
			userSet.setOrder(8);
			for(int i = 0; i < userSet.getSize(); i++) {
				System.out.println(userSet.getCard(i).getSide2());
				userSet.getCard(i).setTimesSeen();
				userInput = keyboard.nextLine();
				if(userInput.contains(userSet.getCard(i).getSide3())) {
					System.out.println("correct!");
					System.out.println("What is side 1?");
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getCard(i).getSide1())) {
						System.out.println("correct!");
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				} else {
					System.out.println("incorrect!");
					userSet.setMark(userSet.getCard(i), 1);
					userSet.getCard(i).setInorrectFrequency();
				}
			}
		}
		else if (userInput.compareTo("9") == 0) {
			userSet.setOrder(9);
			for(int i = 0; i < userSet.getSize(); i++) {
				System.out.println(userSet.getCard(i).getSide3());
				userSet.getCard(i).setTimesSeen();
				userInput = keyboard.nextLine();
				if(userInput.contains(userSet.getCard(i).getSide2())) {
					System.out.println("correct!");
					System.out.println("What is side 1?");
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getCard(i).getSide1())) {
						System.out.println("correct!");
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				} else {
					System.out.println("incorrect!");
					userSet.setMark(userSet.getCard(i), 1);
					userSet.getCard(i).setInorrectFrequency();
				}
			}
		}
			else {
			System.out.println("Invalid input.");
		}
		if(userSet.incorrectSetSize() == 0) {
			System.out.println("Well done! You got all the cards right.");
		} else {
			boolean incorrect = false;
//			if(userSet.incorrectSetSize() == 0) {
//				incorrect = true;
//			}
//			while(incorrect != true) {
			System.out.println("How would you like the incorrect set displayed? (1,2,3,4,5,6,7,8,9)");
			userInput = keyboard.nextLine();
			if(userInput.compareTo("1") == 0) {
				for(int i = 0; i < userSet.incorrectSetSize(); i++) {
					System.out.println(userSet.getIncorrectCard(i).getSide1());
					userSet.getCard(i).setTimesSeen();
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getIncorrectCard(i).getSide2())) {
						System.out.println("correct!");
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getIncorrectCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				}
			} else if (userInput.compareTo("2") == 0) {
				for(int i = 0; i < userSet.incorrectSetSize(); i++) {
					System.out.println(userSet.getIncorrectCard(i).getSide2());
					userSet.getCard(i).setTimesSeen();
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getIncorrectCard(i).getSide3())) {
						System.out.println("correct!");
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getIncorrectCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				}
			} else if (userInput.compareTo("3") == 0) {
				for(int i = 0; i < userSet.incorrectSetSize(); i++) {
					System.out.println(userSet.getIncorrectCard(i).getSide1());
					userSet.getCard(i).setTimesSeen();
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getIncorrectCard(i).getSide3())) {
						System.out.println("correct!");
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getIncorrectCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				}
			} else if (userInput.compareTo("4") == 0) {
				for(int i = 0; i < userSet.incorrectSetSize(); i++) {
					System.out.println(userSet.getIncorrectCard(i).getSide2());
					userSet.getCard(i).setTimesSeen();
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getIncorrectCard(i).getSide1())) {
						System.out.println("correct!");
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getIncorrectCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				}
			} else if (userInput.compareTo("5") == 0) {
				for(int i = 0; i < userSet.incorrectSetSize(); i++) {
					System.out.println(userSet.getIncorrectCard(i).getSide3());
					userSet.getCard(i).setTimesSeen();
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getIncorrectCard(i).getSide1())) {
						System.out.println("correct!");
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getIncorrectCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				}
			} else if (userInput.compareTo("6") == 0) {
				for(int i = 0; i < userSet.incorrectSetSize(); i++) {
					System.out.println(userSet.getIncorrectCard(i).getSide3());
					userSet.getCard(i).setTimesSeen();
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getIncorrectCard(i).getSide2())) {
						System.out.println("correct!");
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getIncorrectCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				}
			} else if (userInput.compareTo("7") == 0) {
				for(int i = 0; i < userSet.incorrectSetSize(); i++) {
					System.out.println(userSet.getIncorrectCard(i).getSide1());
					userSet.getCard(i).setTimesSeen();
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getIncorrectCard(i).getSide2())) {
						System.out.println("correct!");
						System.out.println("What is side 3?");
						userInput = keyboard.nextLine();
						if(userInput.contains(userSet.getIncorrectCard(i).getSide3())) {
							System.out.println("correct!");
						} else {
							System.out.println("incorrect!");
							userSet.setMark(userSet.getIncorrectCard(i), 1);
							userSet.getCard(i).setInorrectFrequency();
						}
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getIncorrectCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				}
			} else if (userInput.compareTo("8") == 0) {
				for(int i = 0; i < userSet.incorrectSetSize(); i++) {
					System.out.println(userSet.getIncorrectCard(i).getSide2());
					userSet.getCard(i).setTimesSeen();
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getIncorrectCard(i).getSide3())) {
						System.out.println("correct!");
						System.out.println("What is side 1?");
						userInput = keyboard.nextLine();
						if(userInput.contains(userSet.getIncorrectCard(i).getSide1())) {
							System.out.println("correct!");
						} else {
							System.out.println("incorrect!");
							userSet.setMark(userSet.getIncorrectCard(i), 1);
							userSet.getCard(i).setInorrectFrequency();
						}
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getIncorrectCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				}
			} else if (userInput.compareTo("9") == 0) {
				for(int i = 0; i < userSet.incorrectSetSize(); i++) {
					System.out.println(userSet.getIncorrectCard(i).getSide3());
					userSet.getCard(i).setTimesSeen();
					userInput = keyboard.nextLine();
					if(userInput.contains(userSet.getIncorrectCard(i).getSide2())) {
						System.out.println("correct!");
						System.out.println("What is side 1?");
						userInput = keyboard.nextLine();
						if(userInput.contains(userSet.getIncorrectCard(i).getSide1())) {
							System.out.println("correct!");
						} else {
							System.out.println("incorrect!");
							userSet.setMark(userSet.getIncorrectCard(i), 1);
							userSet.getCard(i).setInorrectFrequency();
						}
					} else {
						System.out.println("incorrect!");
						userSet.setMark(userSet.getIncorrectCard(i), 1);
						userSet.getCard(i).setInorrectFrequency();
					}
				}
			}
//			}
		}
		
		System.out.println("Would you like to select any cards?(Y/N)");
		userInput = keyboard.nextLine();
		if(userInput.compareTo("Y") == 0) {
			System.out.println("Here are available cards: ");
			for(int i = 0; i < userSet.getSize(); i++) {
				System.out.println(i + ": " + userSet.getCard(i).basicString());
			}
//		System.out.println("Enter a card you would like to select: ");
//		userInput = keyboard.nextLine();
		while(cont == true) {
		System.out.println("Enter a card you would like to select: ");
		userInput = keyboard.nextLine();
		for(int i = 0; i < userSet.getSize(); i++) {
			if(userInput.contains("i")) {
				userSet.getCard(i).setFlashcardStar("*");
			}
		}
		System.out.println("Would you like to star another card? (Y/N)");
		userInput = keyboard.nextLine();
		if(userInput.contains("Y")) {
			cont = true;
		} else {
			cont = false;
		}
		
		}
		
		
		}
		
		userSet.saveSet();
		
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
