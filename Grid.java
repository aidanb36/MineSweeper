# MineSweeper
Recreation of the MineSweeper game. Guess numbers and avoid the bomb.
//Aidan Brown
//CS 110

import java.util.Random;
import java.util.Arrays;

//class Grid creates the 10x12 grid for the minesweeper game
public class Grid
{
   //variables and constants
   private Square [] [] grid;
   private int width = 12;
   private int height = 10;
   private int numMines = 10;
   private int numSquaresUncovered = 0;
   private int neighborMines;
   
   /**grid constructor
   @param width the width of 12
   @param height the height of 10
   @param numMines 10 mines
   */
   public Grid(int height, int width, int numMines)
   {
      this.width = width;
      this.height = height;
      this.numMines = numMines;
      //grid is a square of height and width
      Random rand = new Random();
      grid = new Square[height][width];

      for(int j = 0; j<numMines; j++)
      {
         int r = rand.nextInt(height);
         int c = rand.nextInt(width);
         if( grid[r][c]==null)
         {
            grid[r][c]=new MineSquare();
         }
      }
      for(int a=0; a<height; a++)
      {
         for(int b=0; b<width; b++)
         {
            if(grid[a][b]==null);
            {
               grid[a][b]=new NumberSquare(a,b,getNeighbors(a,b));
            }
         }
      }
   }
      
   /**getNeighbors
   @param r the row
   @parm c the column
   @ return neighborMines the neighboring mines
   */
   public int getNeighbors(int r, int c)
   {
      for(int i = -1; i<2; i++)
      {
         if(r+i>=0 &&r+i<= this.height-1)
         {
            for(int j=-1; j<2; j++)
            {
               if(c+j>=0 && c+j <= this.width-1 && (j!= 0 || i != 0))
               {
                  if(grid[r+i][c+j] != null && grid[r+i][c+j].isMine()==true)
                  {
                     neighborMines++;
                  }
               }
            }
         }
      }
      return neighborMines;
    }             
             
   /**uncoverSquare uncovers squares
   @param r the row
   @param c the column
   @return Status.OK the ok status
   */
   public Status uncoverSquare(int r, int c)
   {
      //no mine, oneedge, edge, onemine
      final int NOMINE = 2;
      final int ONEEDGE = 1;
      final int EDGE = 0;
      final int ONEMINE = 1;
      //up down left right
      int left;
      int right;
      int up;
      int down;
      
      //if the grid of r and c is mine, return status mine
      if(grid[r][c].isMine()==true)
      {
         exposeMines();
         return Status.MINE;
      }
           
      else
      {
         //avoid edge, no neighbors
         if(getNeighbors(r,c)==0)
         {
            left = NOMINE;
            right = NOMINE;
            up = NOMINE;
            down = NOMINE;
          
            //exposing the area around the specific square
            int row = (r-up);
            while (row<(r+1+down))
            {
               for(int col = (-2); col<(3);col++)
               {
                  if(grid[row][col].isMine() == false && grid[row][col].isUncovered()==false)
                  {
                     grid[row][col].uncover();
                     numSquaresUncovered++;
                  }
               }
               row++;
            }
        }
        else if(getNeighbors(r,c)==1)
        {
            left = ONEMINE;
            right = ONEMINE;
            up = ONEMINE;
            down = ONEMINE;
            
            //for the change in the base
            if (r-ONEEDGE==-1)
               up = EDGE;
                            
            if (r+ONEEDGE==height)
               down = EDGE;
                             
            if (c-ONEEDGE==-1)
               left = EDGE;
                             
            if (c+ONEEDGE==width)
               right = EDGE;
           
           //similar to the last exposure
           int row = (r-up);
           while (row<(r+1+down))
            {
               int col = (c-left);
               while(col<(c+1+right))
               {
                  if(grid[row][col].isMine() == false && grid[row][col].isUncovered()==false)
                  {
                     grid[row][col].uncover();
                     numSquaresUncovered++;
                  }
                  col++;
               }
               row++;
            }
        }
         
         else
         {
            if(grid[r][c].isUncovered() == false)
            {
               grid[r][c].uncover();
               numSquaresUncovered++;
            }
         }
         //victory
         if (numSquaresUncovered==(height*width)-numMines)
            return Status.WIN;
            
         //otherwise return ok
         return Status.OK;
      }
  }
     
   /** exposeMines exposes all mines on the board*/
   
   public void exposeMines()
   {
      int r = 0;
      while (r<height)
      {
         for(int c=0;c<width;c++)
         {
            if(grid[r][c].isMine())
               grid[r][c].uncover();
         }
         r++;
      }
   }
   
   /**flagSquare implements flags on the grid
   @param r the row
   @param c the column
   */
   public void flagSquare(int r, int c)
   {
      //grid r c
      grid[r][c].flagSquare();
   }
   
   /**to string, to return the grid
   @return grid the grid of the game
   */
   @Override
   public String toString()
   {
      String grid = "";
      
      int i = 0;
      while (i<width)
      {
         String val = i+"";
         grid += String.format("%3s",val);
         i++;
      }
      grid += "\n";
      
      int r = 0;
      while (r<height)
      {
         grid+=String.format("%2d", r);
         
         int c = 0;
         while (c<width)
         { 
            grid += String.format("%3s", this.grid[r][c].toString());
            c++;
         }
         grid+= "\n";
         r++;
      }
         return grid;
   }
}   

   
   
