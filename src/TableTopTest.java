/**
 * This is the JUnit test for the tabletop class of the Robot Simulator program.
 * @author Olivia Harlin
 * @date 24-04-03
 * @version 1.0
 */

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TableTopTest {

    @Test
    void withinLimits() {
        TableTop testTableTop = new TableTop();
        Assert.assertTrue(testTableTop.withinLimits(new Position(0,0)));
        Assert.assertTrue(testTableTop.withinLimits(new Position(4,4)));
        Assert.assertFalse(testTableTop.withinLimits(new Position(-1,0)));
        Assert.assertFalse(testTableTop.withinLimits(new Position(3,5)));
    }
}