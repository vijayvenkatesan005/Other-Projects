package chess;

/**
 * Vijay Venkatesan
 * This class represents the Rook chess piece
 */

public class Rook extends Chess{

    public Rook(int row, int column, Color color) {
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

        if(this.getRow() == row || this.getColumn() == col){
            return true;
        }

        return false;

    }

}


