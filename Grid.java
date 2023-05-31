public class Grid
{
    // Copy over your Grid class into here
    private Location[][] grid = new Location[NUM_ROWS][NUM_COLS];
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    public static final String ROW_NAMES[] = {"A","B","C","D","E","F","G","H","I","J"};
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    
    public Grid()
    {
        for(int i = 0; i < NUM_ROWS; i++)
        {
            for(int e = 0; e < NUM_COLS; e++)
            {
                grid[i][e] = new Location();
            }
        }
    }
    
    public void markHit(int row, int col)
    {
        grid[row][col].markHit();
    }
    
    public void markMiss(int row, int col)
    {
        grid[row][col].markMiss();
    }
    
    public void setStatus(int row, int col, int status)
    {
        grid[row][col].setStatus(status);
    }
    
    public int getStatus(int row, int col)
    {
        return grid[row][col].getStatus();
    }
    
    public boolean alreadyGuessed(int row, int col)    
    {
        return !grid[row][col].isUnguessed();
    }
    
    public void setShip(int row, int col, boolean val)
    {
        grid[row][col].setShip(val);
    }
    
    public boolean hasShip(int row, int col)
    {
        return grid[row][col].hasShip();
    }
    
    public Location get(int row, int col)
    {
        return grid[row][col];
    }
    
    public int numRows()
    {
        return NUM_ROWS;
    }
    
    public int numCols()
    {
        return NUM_COLS;
    }
    
    public void addShip(Ship s)
    {
        int row = s.getRow();
        int col = s.getCol();
        int length = s.getLength();
        int direction = s.getDirection();
        if(direction == VERTICAL)
        {
            for(int r = row; r < row + length; r++)
            {
                setShip(r, col , true);
            }
        }
        else
        {
            for(int c = col; c < col + length; c++)
            {
                setShip(row, c, true);
            }
        }
    }
    
    public void printStatus()
    {
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for(int i = 0; i < NUM_ROWS; i++)
        {
            System.out.println();
            System.out.print(ROW_NAMES[i] + "  ");
            for(int e = 0; e < NUM_COLS; e++)
            {
                if(!alreadyGuessed(i,e))
                {
                System.out.print("- ");
                }
                if(getStatus(i, e) == HIT)
                {
                    System.out.print("X ");
                }
                if(getStatus(i,e) == MISSED)
                {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
    
    public void printShips()
    {
         System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for(int i = 0; i < NUM_ROWS; i++)
        {
            System.out.println();
            System.out.print(ROW_NAMES[i] + "  ");
            for(int e = 0; e < NUM_COLS; e++)
            {
                if(hasShip(i,e))
                {
                    System.out.print("X ");
                }
                else
                {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
