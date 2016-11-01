
import java.awt.Color;

/**
 *
 * @author brayden
 */
public class Dalek {

    private int row; //create private int for the row
    private int col; //create private int for the col
    private boolean crash = false; //create private boolean for the state of the dalek

    /**
     * create an object for the dalek
     *
     * @param row the value of the row of the dalek
     * @param col the value of the col of the dalek
     */
    public Dalek(int row, int col) {
        this.row = row;
        this.col = col;

    }

    /**
     * move the respective dalek towards the doc using the current docs
     * coordinates
     *
     * @param docRow the row that the dalek is trying to move towards
     * @param docCol the col that the dalek is trying to move towards
     */
    public void move(int docRow, int docCol) {
        if (crash) { //if the dalek has crashed, it will not make any movement
        } else { //otherwise
            if (this.row > docRow) { //if the row of the dalek is more than that of the desired space
                this.row -= 1; //take away one from the value of the row
            } else if (this.row < docRow) { //otherwis if the row is less than that of the desired space
                this.row += 1; //add one to the value of the row
            } else { //if neither do nothing
            }
            if (this.col > docCol) { //if the col of the dalek is more than that of the desired space
                this.col -= 1; //remove one from the value of the col
            } else if (this.col < docCol) { //otherwise if the value is less than that of the desired space
                this.col += 1; //add one to the value of the col
            } else { //otherwise do nothing

            }
        }
    }

    /**
     * return the value of the row
     * @return the value of the row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * return the value of the col
     * @return the value of the col
     */
    public int getCol() {
        return this.col;
    }

    /**
     * return the value of the boolean crash
     * @return the value of the boolean crash
     */
    public boolean hasCrash() {
        return crash;
    }

    /**
     * make the value of the boolean crash true
     */
    public void crashed() {
        this.crash = true;
    }

    /**
     * check with all the daleks to see if there are any crashes 
     * @param dalek the current dalek being checked
     * @param board the game board with the coordinates
     */
    public void checkOthers(Dalek dalek[], Board board) {
        if (dalek[0].getCol() == dalek[1].getCol() //if the value of col of 2 daleks equal eachother
                && dalek[0].getRow() == dalek[1].getRow()) { //and the value of the row of the 2 daleks equal eachother
            dalek[0].crashed(); //the dalek 0 has crashed
            dalek[1].crashed(); //the dalek 1 has crashed
            board.putPeg(Color.RED, dalek[0].getRow(), dalek[0].getCol()); //put down a red peg on the crash site
        }

        //repeat the check steps between 2 more daleks
        if (dalek[1].getCol() == dalek[2].getCol() 
                && dalek[1].getRow() == dalek[2].getRow()) {
            dalek[1].crashed();
            dalek[2].crashed();
            board.putPeg(Color.RED, dalek[1].getRow(), dalek[1].getCol());
        }

        //repeat the check steps between the final 2 daleks
        if (dalek[0].getCol() == dalek[2].getCol()
                && dalek[0].getRow() == dalek[2].getRow()) {
            dalek[0].crashed();
            dalek[2].crashed();
            board.putPeg(Color.RED, dalek[0].getRow(), dalek[0].getCol());
        }
    }
}
