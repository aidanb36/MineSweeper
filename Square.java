# MineSweeper
Recreation of the MineSweeper game. Guess numbers and avoid the bomb.
//Aidan Brown
//CS 110
//Square is an abstract class that creates the individual squares
   //which are marked
abstract class Square
{
   //declare the variables
   public String element;
   public boolean flagged;
   public boolean uncovered;
   
   //Squares all have an x initially, with false and false booleans to start
   public Square()
   {
      this("x", false, false);
   }
   
   /**Square constructor
   @param element string element
   @param flagged boolean value for whether the location is flagged
   @param uncovered boolean for uncovered
   */
   public Square(String element, boolean flagged, boolean uncovered)
   {
      this.element = element;
      this.flagged = flagged;
      this.uncovered = uncovered;
   }
   
   /**isFlagged getter
   @return flagged boolean for true if flagged, false otherwise
   */
   public boolean isFlagged()
   {
      if(flagged)
         return true;
      return false;
   }
   
   /**isUncovered
   @return uncovered true or false
   */
   public boolean isUncovered()
   {
     //  if (uncovered)
//          return true;
//       return false;
      return uncovered;
   }
   
   /**flagSquare setter
   */
   public void flagSquare()
   {
      if (flagged)
      {
         element ="x";
         flagged = false;
      }
      
      else
      {
         element = "f";
         flagged = true;
      }
   }
      
   
   /**setUncovered
   */
   public void setUncovered()
   {
      uncovered = true;
   }
   
   
   public void setElement(String element)
   {
      this.element = element;
   }
   
   /**to String, return the square string
   @return element, in string format
   */
   @Override
   public String toString()
   {
      return String.format(element);
   }
   
   public abstract boolean uncover();

    
   public abstract boolean isMine();

}
