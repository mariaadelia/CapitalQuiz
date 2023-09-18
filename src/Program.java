import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * You are tasked with creating a Java program that simulates a simple quiz game. 
 * The program should prompt the user with a series of questions and allow them to enter their answers. 
 * After the user has answered all the questions, the program should compute and display the final score based on the number of correct answers.

Make sure the following requirements are met:
	- The program should include five multiple-choice questions with four options.
	- The four options should be labeled A, B, C, and D.
	- The program should prompt the user to enter their answer by typing the corresponding letter (A, B, C, or D).
	- After the user has entered their answer for each question, the program should compare it to the correct answer and keep track of the number of correct responses.
	- The program should compute and display the final score as a percentage of the total number of questions.
	- Use if and switch case statements to handle user input and compare it to the correct answers.
	- Include comments to explain the purpose of each section of code and enhance code readability.
 * 
 * */


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CapitalQuiz();

	}
	
	public static void CapitalQuiz() {
		ArrayList<String> capitals = new ArrayList<>();		
	
		capitals.add("Sanaa");
		capitals.add("Hanoi");
		capitals.add("Algiers");
		capitals.add("Luanda");
		capitals.add("Avarua");
		capitals.add("Yaren");
		capitals.add("Cairo");
		capitals.add("Ashgabat");
		capitals.add("Manila");
		capitals.add("Beirut");
		capitals.add("Kingston");
		capitals.add("Willemstad");
		capitals.add("Ottawa");
		capitals.add("Oslo");
		capitals.add("Havana");
		capitals.add("Lima");
		capitals.add("Dublin");
		capitals.add("Reykjavík");
		capitals.add("San Juan");
		capitals.add("Caracas");
		capitals.add("Doha");
		capitals.add("Singapore");
		capitals.add("Tripoli");
		capitals.add("Hong Kong");
		capitals.add("Beijing");
		capitals.add("Mexico City");
		
		Questions(capitals);
		
	}
	public static void Questions(ArrayList<String> randomCapitals) {
		
		int count = 1;
		boolean usersChoice = false;
		int score = 0;
		
		// Go through all the questions
		while(count <= 5) {
			
			switch(count) {
				case 1 -> {
					
					System.out.println(count + " - What is the capital of Taiwan?");
					//Calling the options and changing the correct name of the Capital to String (as it is an enum)
					usersChoice = OptionsCapitals(randomCapitals,CorrectCapitals.Taipei.toString());
				}
				case 2 -> {
					System.out.println("\n" + count + " - What is the capital of Liechtenstein?");
					//Calling the options and changing the correct name of the Capital to String (as it is an enum)
					usersChoice = OptionsCapitals(randomCapitals,CorrectCapitals.Vaduz.toString());
				}
				case 3 ->{
					System.out.println("\n" + count + " - What is the capital of Brazil?");
					//Calling the options and changing the correct name of the Capital to String (as it is an enum)
					usersChoice = OptionsCapitals(randomCapitals,CorrectCapitals.Brasilia.toString());
				}
				case 4 ->{
					System.out.println("\n" + count + " - What is the capital of Tanzania?");
					//Calling the options and changing the correct name of the Capital to String (as it is an enum)
					usersChoice = OptionsCapitals(randomCapitals,CorrectCapitals.Dodoma.toString());
				}
				case 5 ->{
					System.out.println("\n" + count + " - What is the capital of New Zealand?");
					//Calling the options and changing the correct name of the Capital to String (as it is an enum)
					usersChoice = OptionsCapitals(randomCapitals,CorrectCapitals.Wellington.toString());
				}
			}
			
			//To score the points
			if(usersChoice == true) {
				score += 20;				
			}
			
			count++;
			
		}
		
		FinalScore(score);	
	}
	
	//List with the right capitals for the questions
	public enum CorrectCapitals{
		
		Taipei,
		Vaduz,
		Brasilia,
		Dodoma,
		Wellington				
	}
	
	
	//Creating the options to the question
	public static boolean OptionsCapitals(ArrayList<String> listOfCapitals, String correctCapital) {
				
		boolean rightChoice = false;
		//Letter of the option A, B. C.D
		char letter = 'A';
		//Shuffling all the Capitals
		Collections.shuffle(listOfCapitals);
		//New array to the capital options
		ArrayList<String> capitalsOptions = new ArrayList<>();		
		
		//Adding 3 shuffled capitals in the list of capital options
		for(int i = 0; i < 3; i++) {
			capitalsOptions.add(listOfCapitals.get(i));			
		}
		
		//Adding the correct capital
		capitalsOptions.add(correctCapital);
		//Shuffling the options of the Capitals so it's not always the same option
		Collections.shuffle(capitalsOptions);	
		
		//Showing the options
		for(int i = 0; i < 4; i++) {						
			System.out.println("\t" + letter + " - " + capitalsOptions.get(i));
			letter ++;
		}
		
		//Calling the input of the user
		char userChoice = UserInput();
		
		if(userChoice != 'Z') {
			//Getting the right choice
			rightChoice = CorrectChoice(userChoice, correctCapital, capitalsOptions);
		}
		else {
			System.out.print("Option not allowed");
		}
		
		return rightChoice;
		
	}
	
	public static char UserInput() {
		//Starting the scanner so I can read the user input
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Type the letter of the correct choice: ");
		//To any letter that the user type, to be an upper case letter
		char option = Character.toUpperCase(sc.next().charAt(0));
		
		
		//Checking if the input of the user is a letter
		if((option != 'A') && (option != 'B') && (option != 'C') && (option != 'D')) {
			//Letter to identify the incorrect option
			option = 'Z';
		}
		
		//Returning the letter option of the choice of the user
		return option;		
	}
	
	public static boolean CorrectChoice(char userOption, String correctCapitalChoice, ArrayList<String> listOfCapitals) {
		
		int indexChoice = 0;
		
		//Finding in each index is the correct answer
		for(int i = 0; i < listOfCapitals.size();i++) {
			
			if(listOfCapitals.get(i) == correctCapitalChoice) {
				//Finding out the index number of the correct answer
				indexChoice = i;
			}
		}
		
		char correctLetter = CorrectLetter(indexChoice);
		
		//If the user got it right
		if(userOption == correctLetter) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//Method to find the letter of the correct option
	public static char CorrectLetter(int letterIndex) {
		char letterChoice;
		
		switch(letterIndex) {
			case 0 -> letterChoice = 'A';
			case 1 -> letterChoice = 'B';
			case 2 -> letterChoice = 'C';
			default -> letterChoice = 'D';
			
		}
		return letterChoice;
		
	}
	
	public static void FinalScore(int score) {
		
		System.out.println("\n ------------------------------ ");
		
		//Different messages depending on the score
		if(score == 100) {
			System.out.println("\nCongratulations!!! You got " + score + "% right");
		}
		else if(score < 100 && score >= 80) {
			System.out.println("\nGreat job!!! You got " + score + "% right");
		}
		else if (score < 80 && score > 0){
			System.out.println("\nKeep up the good work!!! You got " + score + "% right");
		}
		else {
			System.out.println("\nSorry, you got " + score + "% right. Good luck next time");
		}
		
		System.out.println("\n ------------------------------ ");
	}
}

