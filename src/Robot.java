/**
 * This is the robot class of the Robot Simulator program.
 * @author Olivia Harlin
 * @date 24-04-03
 * @version 1.0
 */

public class Robot {
    private Direction dir;
    private Position pos;
    private Boolean placed;
    private TableTop tableTop;

    /**
     * Class constructor.
     * Creates a robot and the tabletop it's intended to be used on
     */
    public Robot() {
        tableTop = new TableTop();
        this.placed = false;
    }

    /**
     * Returns the robot's direction.
     * @return the direction
     */
    public Direction getDirection(){
        return dir;
    }

    /**
     *
     * @param pos
     * @param dir
     */
    public void place(Position pos, Direction dir){
        this.pos = pos;
        this.dir = dir;
        placed = true;
    }

    /**
     * Checks if the robot can move forward without falling from the tabletop
     * @return true if the robot can move, otherwise false
     */
    public Boolean canMove(){
        if(tableTop.withinLimits(nextPos())){
            return true;
        }
        return false;
    }

    /**
     * Checks the next position from where the robot is currently standing
     * @return the next position as a Position object
     */
    public Position nextPos(){
        int nextX = pos.getX();
        int nextY = pos.getY();

        switch (dir){
            case EAST -> nextX = pos.getX() + 1;
            case NORTH -> nextY = pos.getY() + 1;
            case SOUTH -> nextY = pos.getY() - 1;
            case WEST -> nextX = pos.getX() - 1;
        }

        return (new Position(nextX, nextY));
    }

    /**
     * Moves the robot one step forward in the direction it's pointing
     */
    public void move(){
        pos = nextPos();
    }


    /**
     * Turns the robot 90 degrees to the left
     */
    public void turnLeft(){
        switch (dir){
            case EAST -> dir = Direction.NORTH;
            case WEST -> dir = Direction.SOUTH;
            case NORTH -> dir = Direction.WEST;
            case SOUTH -> dir = Direction.EAST;
        }
    }

    /**
     * Turns the robot 90 degrees to the right
     */
    public void turnRight(){
        switch (dir){
            case EAST -> dir = Direction.SOUTH;
            case WEST -> dir = Direction.NORTH;
            case NORTH -> dir = Direction.EAST;
            case SOUTH -> dir = Direction.WEST;
        }
    }


    /**
     * Checks if the robot has been placed on the tabletop
     * @return true if placed, otherwise false
     */
    public Boolean isPlaced(){
        return placed;
    }

    /**
     * Makes the log message of where the robot is standing and in which direction it's pointing
     */
    public void report(){
        System.out.println(pos.getX() + "," +pos.getY() + "," + dir);
    }
}
