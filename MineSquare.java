# MineSweeper
Recreation of the MineSweeper game. Guess numbers and avoid the bomb.
//Aidan Brown
//CS 110

public class MineSquare extends Square
{
  /**isMine returns true if there is a mine present
   @return true
   */
   public boolean isMine()
   {
      return true;
   }

   /**uncover uncovers the square and returns a boolean
   @return false if is unvovered or is flagged
   @return true otherwise
   */
   public boolean uncover()
   {
      if (isUncovered() || isFlagged())
         return false;
      else
      {
         setElement("");
         setUncovered();
         return true;
      }
   }
   
 
}
