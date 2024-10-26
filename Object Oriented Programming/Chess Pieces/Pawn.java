package chess;

/**
 * Vijay Venkatesan
 * This class represents the Pawn chess piece
 */

public class Pawn extends Chess{


    /**
     * Constructs a Pawn chess piece and initializes
     * its moved attribute to zero
     */


    public Pawn(int row, int column, Color color) {
        super(row, column, color);
        if((row < 1 || row > 6)) throw new IllegalArgumentException("row must be between 1 and 6 inclusive");

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

        //considering the color here (black or white)
        if(this.getColor() == Color.WHITE){

            if(this.getRow() == 1){
                return (this.getRow() + 1 == row || this.getRow() + 2 == row)
                        && this.getColumn() == col;
            }
            else {
                return (this.getRow() + 1 == row)
                        && this.getColumn() == col;
            }


        }
        else{

            if(this.getRow() == 6){
                return (this.getRow() - 1 == row || this.getRow() - 2 == row)
                        && this.getColumn() == col;

            }
            else {
                return (this.getRow() - 1 == row)
                        && this.getColumn() == col;
            }

        }

    }

    @Override
    public boolean canKill(ChessPiece piece){
        //we can only kill pieces of the opposite color

        if(this.getColor() == Color.WHITE){
            return this.getRow()+1 == piece.getRow()
                    && (this.getColumn() -1 == piece.getColumn() || this.getColumn()+1 == piece.getColumn());

        }
        else{
            return this.getRow()-1 == piece.getRow()
                    && (this.getColumn() -1 == piece.getColumn() || this.getColumn()+1 == piece.getColumn());

        }


    }

}
