/**
 * This is the position class of the Robot Simulator program.
 * @author Olivia Harlin
 * @date 24-04-03
 * @version 1.0
 */

public class Position {
    private int yPos;
    private int xPos;

    /**
     * Class constructor. Creates a new position.
     * @param xPos The x coordinate.
     * @param yPos The y coordinate.
     */
    public Position(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * @return y coordinate
     */
    public int getY(){
        return yPos;
    }

    /**
     * @return x coordinate
     */
    public int getX(){
        return xPos;
    }

}
