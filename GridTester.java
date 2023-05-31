public class GridTester extends ConsoleProgram
{
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public void run()
    {
        // Start here!
        Grid grid = new Grid();
        Ship s1 = new Ship(5);
        s1.setLocation(3, 3);
        s1.setDirection(VERTICAL);
        grid.addShip(s1);
        
        Ship s2 = new Ship(3);
        s2.setLocation(7, 5);
        s2.setDirection(HORIZONTAL);
        grid.addShip(s2);
        
        grid.printShips();
    }
}
