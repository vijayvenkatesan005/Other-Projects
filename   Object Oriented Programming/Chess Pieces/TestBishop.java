import chess.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Vijay Venkatesan
 * This class tests the methods in the Bishop class with
 * normal, edge, and invalid cases
 */

public class TestBishop {

    //add more tests to your test classes

    Bishop bishop1;
    Bishop bishop2;
    ChessPiece piece1;
    ChessPiece piece2;
    ChessPiece piece3;

    /**
     * Initializing the Bishop chess pieces
     */
    @BeforeEach
    public void setUp() {
        bishop1 = new Bishop(0,2,Color.WHITE);
        bishop2 = new Bishop(0,5,Color.BLACK);
        piece1 = new Bishop(3,5,Color.BLACK);
        piece2 = new Bishop(3,2,Color.BLACK);
        piece3 = new Bishop(5,7,Color.WHITE);
    }

    /**
     * Tests to see if the row of the chess piece is correct
     */
    @Test
    public void testGetRow(){

        //normal case
        assertEquals(0,bishop1.getRow());
    }

    /**
     * Tests to see if the column of the chess piece is correct
     */
    @Test
    public void testGetColumn(){

        //normal case
        assertEquals(2,bishop1.getColumn());
    }

    /**
     * Tests to see if the color of the chess piece is correct
     */
    @Test
    public void testGetColor(){

        //normal case
        assertEquals(Color.WHITE,bishop1.getColor());
    }

    /**
     * Tests to see if the chess piece moves to the correct location
     */
    @Test
    public void testCanMove(){

        //normal cases
        assertTrue(bishop1.canMove(1,3));
        assertTrue(bishop2.canMove(1,6));
        assertFalse(bishop1.canMove(1,2));
        assertFalse(bishop2.canMove(1,5));

        //edge case
        assertTrue(bishop1.canMove(5,7));
        assertFalse(bishop1.canMove(0,2));

        //invalid case
        assertThrows(IllegalArgumentException.class,
                ()->bishop1.canMove(9,9),"Expected canMove() to throw, but it didn't");
        assertThrows(IllegalArgumentException.class,
                ()->bishop1.canMove(2,-10),"Expected canMove() to throw, but it didn't");

    }

    /**
     * Tests to see if the chess piece kills the correct pieces
     */
    @Test
    public void testCanKill(){

        //normal cases
        assertTrue(bishop1.canKill(piece1));
        assertFalse(bishop2.canKill(piece2));
        assertFalse(bishop1.canKill(piece2));
        assertFalse(bishop2.canKill(piece1));

        //edge case
        assertFalse(bishop1.canKill(piece3));

    }
}
