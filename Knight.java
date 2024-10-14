package chess;

/**
 * Vijay Venkatesan
 * This class represents the Knight chess piece
 */

public class Knight extends Chess{

    public Knight(int row, int column, Color color){
        super(row, column, color);
    }

    @Override
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

        if(Math.abs(row - this.getRow()) == 2 && Math.abs(col - this.getColumn()) == 1
                || Math.abs(row - this.getRow()) == 1 && Math.abs(col - this.getColumn()) == 2){
            return true;
        }

        return false;

    }


}
