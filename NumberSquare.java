# MineSweeper
Recreation of the MineSweeper game. Guess numbers and avoid the bomb.
//Aidan Brown
//CS 110

public class NumberSquare extends Square
{
   private int neighborMines;
   private int mRow;
   private int mCol;
   
   /**NumberSquare creates a square using values below
   @param neighborMines
   @param mRow
   @param mCol
   */
   public NumberSquare(int neighborMines, int mRow, int mCol)
   {
      this.mRow = mRow;
      this.mCol = mCol;
      this.neighborMines = neighborMines;
   }
   
   //uncovers the square to show underneath
   @Override
   public boolean uncover()
   {
      
      if (isUncovered()|| isFlagged())
         return false;
      else
      {
         setUncovered();
         if (neighborMines ==0)
            setElement("_");
         else
            setElement(neighborMines + "");
         return true;
      }
  }
      
   /**getNeighborMines gets the neighboring mines
   @return neighborMines
   */
   public int getNeighborMines()
   {
      return neighborMines;
   }
   
   /**isMine returns a boolean value for if theres a mine
   @return false if there's a mine
   */
   @Override
   public boolean isMine()
   {
      return false;
   }
}
