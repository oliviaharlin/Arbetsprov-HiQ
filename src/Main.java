/**
 * This is the main class of the Robot Simulator program.
 * @author Olivia Harlin
 * @date 24-04-03
 * @version 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Robot robot = new Robot();

        try{
            File file = new File("test6.txt"); // <--- EDIT INPUT FILE HERE!
            Scanner scanner = new Scanner(file);

            // as long as there is something to read from the file...
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if(line.startsWith("PLACE") && !(robot.isPlaced())){ // only place robot if it hasn't already been placed

                    // split line by comma sign
                    String[] stringSplit = line.split(",");

                    if(stringSplit.length == 4){ // if we have all info needed...
                        String dir = stringSplit[3];
                        int x = Integer.parseInt(stringSplit[1]);
                        int y = Integer.parseInt(stringSplit[2]);

                        // place according to pos and dir retrieved from splitting the string
                        robot.place(new Position(x,y), Direction.valueOf(dir));
                    }

                } else if (line.equals("MOVE") && robot.isPlaced()){
                    if(robot.canMove()){ // move if robot can move
                        robot.move();
                    }

                } else if (line.equals("LEFT") && robot.isPlaced()){
                    robot.turnLeft();
                } else if (line.equals("RIGHT") && robot.isPlaced()){
                    robot.turnRight();
                } else if (line.equals("REPORT") && robot.isPlaced()){
                    robot.report();
                } else {
                    // not a valid command, ignore
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("The entered file was not found.");
            e.printStackTrace();
        }
    }
}