package chess;

/**
 * Vijay Venkatesan
 * This class represents the Bishop chess piece
 */
public class Bishop extends Chess{

    public Bishop(int row, int column, Color color){
        super(row, column, color);

    }

    public boolean canMove(int row, int col){

        if(row < 0 || row > 7){
            throw new IllegalArgumentException("row must be between 0 and 7 inclusive");
        }
        if(col < 0 || col > 7) {
            throw new IllegalArgumentException("column must be between 0 and 7 inclusive");
        }

        if(this.getRow() == row && this.getColumn() == col){
            return false;
        }


        if(Math.abs(row - this.getRow()) == Math.abs(col - this.getColumn())) {
            return true;
        }

        return false;
    }



}
