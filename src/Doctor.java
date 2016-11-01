
/**
 *
 * @author brayden
 */
public class Doctor {

    private int row; //create a private int for the row
    private int col; //create a private int for the col
    private boolean crash; //create a private boolean for the value of the state of the doc
    
    /**
     * creates the object of the doctor with the a value for row and colum
     * @param row value for the row
     * @param col value for the colum
     */
    public Doctor(int row, int col) {
        this.row = row;
        this.col = col;

    }

    /**
     * moves the dalek that is currently selected in relation to the mouse click coordinates
     * @param clickRow the row value of the mouse click
     * @param clickCol the colum value of the mouse click
     */
    public void move(int clickRow, int clickCol) {

        //find out if the value of the mouse click is within one square, or intop of the doctor
        if ((clickRow == this.row + 1 || clickRow == this.row - 1 || clickRow == this.row) && (clickCol == this.col + 1 || clickCol == this.col - 1 || clickCol == this.col)) {
            {
                this.row = clickRow; //make the current value of the row of the doctor to the value of the mouse click row
                this.col = clickCol;//also make the current value of the col of the doctor equal the value of the mouse click col
            }
        } else { //otherwise
            this.row = (int) (Math.random() * 12); //randomly generate a row for the doc to be placed
            this.col = (int) (Math.random() * 12); //rendomly generate a col for the doc to be placed
        }
    }

    /**
     * return the value of the row of the doc
     * @return the row of the doc
     */
    public int getRow() {
        return this.row;
    }

    /**
     * return the value of the col of the doc
     * @return the col of the doc
     */
    public int getCol() {
        return this.col;
    }
    
    /**
     * return the boolean of if the doc has crashed or not 
     * @return the value of crash
     */
    public boolean hasCrashed(){
        return this.crash;
    }
    
    /**
     * make the value of the boolean crash true, this is mean the end of the game
     */
    public void crashed(){
        this.crash = true;
    }

}
