/**
 * This is the JUnit test for the robot class of the Robot Simulator program.
 * @author Olivia Harlin
 * @date 24-04-03
 * @version 1.0
 */

import org.junit.Assert;

class RobotTest {

    @org.junit.jupiter.api.Test
    void place() {
        Robot testRobot = new Robot();
        Assert.assertFalse(testRobot.isPlaced());
        testRobot.place(new Position(1,2), Direction.EAST);
        Assert.assertTrue(testRobot.isPlaced());
    }

    @org.junit.jupiter.api.Test
    void canMove() {
        Robot testRobot = new Robot();
        testRobot.place(new Position(0,0), Direction.SOUTH);
        Assert.assertFalse(testRobot.canMove());
        testRobot.place(new Position(0,0), Direction.NORTH);
        Assert.assertTrue(testRobot.canMove());

    }

    @org.junit.jupiter.api.Test
    void nextPos() {
        Robot testRobot = new Robot();
        testRobot.place(new Position(0,0), Direction.NORTH);
        Assert.assertSame(1, testRobot.nextPos().getY());
        Assert.assertSame(0, testRobot.nextPos().getX());
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        Robot testRobot = new Robot();
        testRobot.place(new Position(0,0), Direction.NORTH);
        testRobot.turnLeft();
        Assert.assertSame(Direction.WEST, testRobot.getDirection());
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        Robot testRobot = new Robot();
        testRobot.place(new Position(0,0), Direction.NORTH);
        testRobot.turnRight();
        Assert.assertSame(Direction.EAST, testRobot.getDirection());
    }
}