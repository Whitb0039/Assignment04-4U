
import java.awt.Color;

/**
 *
 * @author brayden
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean outcome = false; //create a boolean of the outcome that defaults to false

        Board board = new Board(12, 12); //create the board that the game will be played on(12 by 12 squares)

        Dalek[] dalek = new Dalek[3]; //create an array of daleks that has 3 spaces

        for (int i = 0; i <= 2; i++) { //while the value of i is less than or equal to 2
            int randRow = (int) (Math.random() * 12); //create a random number between 0 and 11 and make it the row value
            int randCol = (int) (Math.random() * 12); //create a random number between 0 and 11 and make it the col value
            board.putPeg(Color.BLACK, randRow, randCol); //put a black peg on the space with the value 
            dalek[i] = new Dalek(randRow, randCol); //create a new Dalek that has the properties of the row and col
        }

        int docRow = (int) (Math.random() * 12); //make a row for the doc between 0 and 11
        int docCol = (int) (Math.random() * 12); //make a col for the doc between 0 and 11

        Doctor doc = new Doctor(docRow, docCol); //create a doc with the properties of the doc row and col

        board.putPeg(Color.GREEN, docRow, docCol); //put a green peg where the doc is

        board.displayMessage("please click the board in order to move"); //ask the user to click somewhere on the board to issue a move command

        while (true) { //loop until game ends
            
            dalek[0].checkOthers(dalek, board); //check all the daleks for any crashes

            if (dalek[0].hasCrash() //if the first dalek crashed
                    && dalek[1].hasCrash() //and the second crashed
                    && dalek[2].hasCrash()) { //and the third
                outcome = true; //the outcome of the game is true
                break; //break the loop
            }

            if (!doc.hasCrashed()) { //if the doc has not crashed yet
                Coordinate click = board.getClick(); //get the value of the click on the board

                board.removePeg(doc.getRow(), doc.getCol()); //remove the current peg that the doc is occupying

                doc.move(click.getRow(), click.getCol()); //move the doc in relation to the command of the click

                board.putPeg(Color.GREEN, doc.getRow(), doc.getCol()); //put a new peg down in the new space the doc is on

            } else { //otherwise
                board.putPeg(Color.yellow, doc.getRow(), doc.getCol()); //put down a yellow peg on the doc if it has crashed
                outcome = false; //the outcome of the game is false
                break; //break the loop
            }

            for (int i = 0; i <= 2; i++) { //while the value of i is less than or equal to 2

                if (dalek[i].hasCrash() == false) { //if the dalek has not crashed
                    board.removePeg(dalek[i].getRow(), dalek[i].getCol()); //remove the peg

                }

                if (dalek[i].hasCrash() == false) { //if the dalek has crashed
                    dalek[i].move(doc.getRow(), doc.getCol()); //move the dalek towards the doc
                    board.putPeg(Color.black, dalek[i].getRow(), dalek[i].getCol()); //place a new peg on the location
                } else { //otherwise
                    board.putPeg(Color.red, dalek[i].getRow(), dalek[i].getCol()); //put down a red peg if it has crashed
                }
            }

            for (int i = 0; i <= 2; i++) { //while the value of i is less than or equal to 2
                if (dalek[i].getRow() == doc.getRow() //if the daleks row is the same as the docs row
                        && dalek[i].getCol() == doc.getCol()) { //and the daleks col is the same as the docs col
                    doc.crashed(); //the doc crashes
                }
            }

        }
        if (outcome == true) { //check to see with the state of the outcome is
            board.displayMessage("YOU WIN!"); //output win if it's true
        } else {
            board.displayMessage("YOU LOSE!"); //output lose if it's false
        }
    }
}
