public class Player
{
    // Write your Player class here
    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    private static final int NUM_SHIPS = 5;
    private static final int UNSET = -1;
    
    private Grid myGrid; //🤬🤬💀
    private Grid oppGrid;
    private Ship[] myShips;
    private int shipCount;
    
    public Player()
    {
        myGrid = new Grid();
        oppGrid = new Grid();
        myShips = new Ship[NUM_SHIPS];
        shipCount = 0;
    }
    
    public void chooseShipLocation(Ship s, int row, int col, int direction)
    {
        if(shipCount < NUM_SHIPS)
        {
            s.setLocation(row, col);
            s.setDirection(direction);
            myGrid.addShip(s);
            myGrid.printShips();
            myShips[shipCount] = s;
            shipCount++;
        }
    }
    
    public void printMyShips()
    {
        myGrid.printShips();
    }
    
    public void printMyGuesses()
    {
        oppGrid.printStatus();
    }
    
    public void printOpponentGuesses()
    {
        myGrid.printStatus();
    }
    
    public boolean opponentGuesses(int row, int col)
    {
        boolean hitOrMiss = myGrid.hasShip(row, col);
        if(hitOrMiss)
        {
            myGrid.markHit(row, col);
        }
        else
        {
            myGrid.markMiss(row, col);
        }
        return hitOrMiss;
    }
}
