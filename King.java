package chess;

/**
 * Vijay Venkatesan
 * This class represents the King chess piece
 */


public class King extends Chess{

    public King(int row, int column, Color color) {
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

        //Find a pattern here
        if(this.getRow()+1 == row && this.getColumn() == col){
            return true;
        }
        else if(this.getRow()+1 == row && this.getColumn()-1 == col){
            return true;
        }
        else if(this.getRow()+1 == row && this.getColumn()+1 == col){
            return true;
        }
        else if(this.getRow() == row && this.getColumn()-1 == col){
            return true;
        }
        else if(this.getRow() == row && this.getColumn()+1 == col){
            return true;
        }
        else if(this.getRow()-1 == row && this.getColumn() == col){
            return true;
        }
        else if(this.getRow()-1 == row && this.getColumn()-1 == col){
            return true;
        }
        else if(this.getRow()-1 == row && this.getColumn()+1 == col){
            return true;
        }
        else{
            return false;
        }
    }

}
