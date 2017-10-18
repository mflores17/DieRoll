//Marcos Flores
//Java 112

import java.util.Scanner;

public class DieRoll
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);

		int randRoll; //will be used for all rolls
		String guess, userChoice = "y", evenOrOdd; //guess is the player's choice between odd or even, userChoice is used for yes/no options and is initialized as y to start the game. See lines 20-29 for evenOrOdd variable
		double wins =0, losses = 0, totalGames=0,totalOdd=0,totalEven=0; //we deal with fractions later on, so double is used. These variables need to be initialized because they are incrementally increased as the game plays out
		
		System.out.print("The computer rolled a 6-sided die. Guess if it landed odd or even.\nEnter odd or even: ");
		guess = input.nextLine();
		
		randRoll = 1 + (int) ( Math.random() * 6); //since the choices end up being odd or even a coin flip would achieve the same goal, but i still went with a die roll
		if (randRoll==1||randRoll==3||randRoll==5)
		{
			++totalOdd;
			evenOrOdd="odd";//evenOrOdd is odd if the die lands on an odd number. Pretty self explanatory. 
		}
		else 
		{
			++totalEven;
			evenOrOdd="even";//otherwise evenOrOdd is even 
		}		
		if (!guess.equalsIgnoreCase("even")&&!guess.equalsIgnoreCase("odd")) //confines the player guesses odd and even. IgnoreCase is added to ignore case sensitivity
		{
			System.out.println("Your choice was neither odd or even.\nGame terminated. Please follow instructions.");
		}
		else 
		{
			do //the do{} while() was necessary to loop the game under the while conditions (in this case the player selects y to keep playing
			{
				if (userChoice.equalsIgnoreCase("y"))
				{
					if (!guess.equalsIgnoreCase("even")&&!guess.equalsIgnoreCase("odd")) //encapsulates all inputs other than "even" or "odd"
					{
						userChoice.equalsIgnoreCase("n");
						System.out.println("Your choice was neither odd or even.\nGame terminated. Please follow instructions.");
						break; //in the case that anything other than even or odd are typed by the user, the game terminates
					}
					else if (!guess.equalsIgnoreCase(evenOrOdd)) //when the player's guess isn't the same as the computer's this will run
					{
						++losses; //increases the losses counter by one
						System.out.println("You guessed wrong.");
					}
					else //the only other possible outcome after the if and else if statements is if the player's guess and the computer's guess are the same
					{
						System.out.println("Correct. You win.");
						++wins; //increases the wins counter by one
					}
					System.out.print("Would you like to play again? Type y for yes and n for no: ");
					userChoice = input.nextLine();
					
					if (userChoice.equalsIgnoreCase("y")) //I wrote in lines 20-29 into the loop to make the computer keep guessing new numbers/oddeven choices after each game
					{
						randRoll = 1 + (int) ( Math.random() * 6);
						if (randRoll==1||randRoll==3||randRoll==5)
						{
							++totalOdd;
							evenOrOdd="odd";
						}
						else 
						{
							++totalEven;
							evenOrOdd="even";
						}
						System.out.print("The computer rolled the die again. Guess whether it's odd or even: ");
						guess = input.nextLine(); //see line 20
					}
				}
				if (!userChoice.equalsIgnoreCase("y") && !userChoice.equalsIgnoreCase("n")) //if at any point during the game any option other than y or n is chosen for continuing to play the game will terminate. Results are still printed, unlike with lines 27-31
				{
					System.out.println("Command not recognized. Game terminated. Please follow instructions.");
					userChoice.equalsIgnoreCase("n"); //in order to print out the results, the computer chooses n as the player input to the option to keep playing
				}
				++totalGames; //after every loop, the number of guesses (totalGames) is increased by one
			} while (userChoice.equalsIgnoreCase("y")); //the while condition of the do{} while() loop. As long as the player wants to keep playing (selecting y) the game will loop
			
			double winPercent = wins/totalGames*100; //the reason I used double instead of int. 
			double results[]= {wins,losses,totalGames,totalOdd,totalEven,winPercent}; //all numbers are saved into this array
			System.out.println("RESULTS:\nNumber of wins: " + results[0]);
			System.out.println("Number of losses: " + results[1]);
			System.out.println("Number of total games: " + results[2]);
			System.out.println("Number of total odd: " + results[3]);
			System.out.println("Number of total even: " + results[4]);
			System.out.println("Your win percent: " + results[5] + "%");
		}
	}
}

// Good job, Marcos 
