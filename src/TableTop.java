/**
 * This is the tabletop class of the Robot Simulator program.
 * @author Olivia Harlin
 * @date 24-04-03
 * @version 1.0
 */

public class TableTop {
    private int width;
    private int height;

    /**
     * Class constructor.
     * Creates a 5x5 tabletop.
     */
    public TableTop(){
        this.width = 5;
        this.height = 5;
    }

    /**
     * Checks if a position is within the limits of the tabletop.
     * @param position The position to be checked.
     * @return true if it's within the limits, otherwise false
     */
    public Boolean withinLimits(Position position){
        if(position.getX() < width && position.getY() < height && position.getX() >= 0 && position.getY() >= 0){
            return true;
        }
        return false;
    }
}
