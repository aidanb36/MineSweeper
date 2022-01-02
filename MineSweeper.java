# MineSweeper
Recreation of the MineSweeper game. Guess numbers and avoid the bomb.
//Aidan Brown
//CS 110

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

//Class MineSweeper implements the game using the other classes
public class MineSweeper
{
   //final ints height width and mines
   final int HEIGHT = 10;
   final int WIDTH = 12;
   final int MINES = 10;
   
   //instance variables
   int width = 12;
   int height = 10;
   int numMines = 10;
   
   //privates, Grid display and Status results
   private Grid display;
   private Status results = Status.OK;
   
   /**Constructor MineSweeper creates game, displays the width height and numMines*/
   public MineSweeper()
   {
      System.out.println("Welcome");
      display = new Grid(height, width, numMines);
      displayGrid();
   }
   
   /** displayGrid displays the playing board*/
   public void displayGrid()
   {
      System.out.println(display);
   }
   
   /**input returns a string for user input
   @return keyboard.nextLine(), the users input U F Q
   */
   public String input()
   {
      System.out.println("What next?");
      System.out.println("Options: (U)ncover r c, (F)lag r c, (Q)uit");
      Scanner keyboard = new Scanner(System.in);
      return keyboard.nextLine();
   }
   
   /**next implements the following play by the player
   @param play a String for what they want to do
   */
   public void next(String play)
   {
      //chnge will be the change that occurs on the board
      String chnge;
      //r and c are row and column
      int r;
      int c;
      
      //parts is the [] string
      String [] parts;
      
      if(play.toUpperCase().charAt(0)=='U')
      {
         //split the parts
         parts = play.split("\\s+");
         //change is the index 0
         chnge = parts[0];
         
         //r and c are the 1 and 2 index
         r = Integer.parseInt(parts[1]);
         c = Integer.parseInt(parts[2]);
         display.flagSquare(r,c);
         //results are the display of the uncover square
         results = display.uncoverSquare(r,c);
         performChange(results);
      }
      
      //if the play is F...
      else if(play.toUpperCase().charAt(0) == 'F')
      {
         //repeat the previous process, except status OK and display the flag
         parts = play.split("\\s+");
         chnge = parts[0];
         r = Integer.parseInt(parts[1]);
         c = Integer.parseInt(parts[2]);
         display.flagSquare(r,c);
         results = Status.OK;
         performChange(results);
      }
      
      //else if play is Q, quit the game and say goodbye
      else if (play.toUpperCase().charAt(0) == 'Q')
      {
         System.out.println("Goodbye");
         System.exit(1);
      }
      
      //anything else possible, results are the ok status and perform the change
      else
      {
         results = Status.OK;
         performChange(results);
      }
  }
  
 //totalExposure uses the display to show the mines, and updates the board
  public void totalExposure()
   {
      display.exposeMines();
      displayGrid();
   }
 
  /**getResults gets the results
  @return results the Status of the game
  */
  public Status getResults()
  {
      return results;
  }
  
    
   /**performChange takes in status and displays results based off of it*/
   public void performChange(Status status)
   {
      //if the results are OK, display board
      if(results == Status.OK)
      {
         displayGrid();
      }
      //mine-> expose all the mines and say you lost
      if(results==Status.MINE)
      {
         totalExposure();
         System.out.println("You lost:(");
         System.exit(1);
      }
      
      //win-> display the board and say you won
      if(results==Status.WIN)
      {  
         displayGrid();
         System.out.println("Congrats, you won!");
         System.exit(1);
      }
   }
  //  public void getDifficulty()
//    {
//       System.out.println("Select Difficulty: ");
//       System.out.println("(B)eginner/(I)ntermediate/(E)xpert");
//       Scanner keyboard = new Scanner(System.in);
//       String option = keyboard.nextLine();
      
}
         



   
      
      
      
  
         

      

         
   
