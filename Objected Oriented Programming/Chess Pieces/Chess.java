package chess;

/**
 * This abstract class represents the common attributes and actions
 * of all six chess pieces
 */
public abstract class Chess implements ChessPiece {
    private int row;
    private int column;
    private Color color;

    /**
     * Constructs a chess piece object and initializes it
     * to the given row, column and color
     * Throws an exception if the row or column is less than zero or greater than seven
     * @param row the row in which the chess piece is located
     * @param column the column in which the chess piece is located
     * @param color the color of the chess piece
     */
    public Chess(int row, int column, Color color){
        if((row < 0 || row > 7)) throw new IllegalArgumentException("row must be between 0 and 7 inclusive");
        if((column < 0 || column > 7)) throw new IllegalArgumentException("column must be between 0 and 7 inclusive");
        this.row = row;
        this.column = column;
        this.color = color;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    public Color getColor(){
        return this.color;
    }

    /**
     * Throws an exception if the row or column is less than zero or greater than seven
     */
    public abstract boolean canMove(int row, int col);

    public boolean canKill(ChessPiece piece){
        //we can only kill pieces of opposite color

        if(this.getColor() != piece.getColor()){
            return this.canMove(piece.getRow(),piece.getColumn());
        }

        return false;
    }
}
