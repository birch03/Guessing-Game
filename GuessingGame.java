// Name: Quinn Stone
// Class: CSCI 145
// Teacher: Proffessor Darrell Criss
// Assignment: Lab1 Guessing Game
// User will guess a number and the program will record how many attempts it takes them to get it right

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

   static void gameStart(){
      System.out.println("Welcome to my Guessing Game!");
      System.out.println("I have generated a random number between\n1 and 100 and it is your job to guess it!");
   }
   
   static void gaming(int gameTotal, int guessTotal) {
      Scanner input = new Scanner(System.in);
      Random random = new Random();
      int randomNum = random.nextInt(100); // Generate random number for game
      //System.out.println("Random number is: " + randomNum);
      int guess = -1;
      
      int guessNum = 0;
      
      
      while (guess != randomNum) {
         System.out.print("Enter a number: ");
         guess = input.nextInt();
         
         guessNum = guessNum + 1;
         guessTotal = guessTotal + 1;
         
         if (guess == randomNum) {
            System.out.println("Correct!");
            System.out.printf("It took you: %d%s", guessNum, " guesses\n");
            playAgain(gameTotal, guessTotal);
            
         } else if (guess < randomNum) {
            System.out.println("Higher");
            
         } else {
            System.out.println("Lower");
         
         }
      }
   }
   
   
   static void playAgain(int gameTotal, int guessTotal) {
      Scanner input = new Scanner(System.in);
      String answer = "y";
      while (answer == "y" || answer == "Y") {
         System.out.println("Would you like to play again? (y/n) ");
         answer = input.nextLine();
         
         
         
         if (answer.equals("y") || answer.equals("Y")) {
            gameTotal = gameTotal + 1;
            gaming(gameTotal, guessTotal);
         } else {
            report(gameTotal, guessTotal);
         }
      }
   }
   
   
   static void report(int gameTotal, int guessTotal) {
      
      double guessPer = (double)guessTotal/gameTotal;
   
      System.out.println("Overall results");
      System.out.println("   Total games = " + gameTotal);
      System.out.println("   Total guesses = " + guessTotal);
      System.out.printf("   guess/game = %.2f%n", guessPer);
      System.out.println("   Best game = ");
   }

   public static void main(String[] args) {
      // Create a Scanner to obtain input from the command window
      Scanner input = new Scanner(System.in);
      
      int gameTotal = 1;
      int guessTotal = 0;
      
      gameStart(); // Introduce Game
      gaming(gameTotal, guessTotal); // Play Game  
      
   
   }
}