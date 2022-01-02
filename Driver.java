# MineSweeper
Recreation of the MineSweeper game. Guess numbers and avoid the bomb.
//Aidan Brown
//CS 110

public class Driver
{
   //this driver uses the minesweeper class to command the game and get results
   public static void main(String[] args)
   {
      MineSweeper game = new MineSweeper();
      while (game.getResults() == Status.OK)
      {
         game.next(game.input());
      }
      
   }
}
