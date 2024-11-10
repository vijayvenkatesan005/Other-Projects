import chess.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Vijay Venkatesan
 * This class tests the methods in the Knight class with
 * normal, edge, and invalid cases
 */

public class TestKnight {

    Knight knight1;
    Knight knight2;
    Knight knight3;
    Knight knight4;
    ChessPiece piece1;
    ChessPiece piece2;

    /**
     * Initializing the Knight chess pieces
     */
    @BeforeEach
    public void setUp() {
        knight1 = new Knight(0,1,Color.WHITE);
        knight2 = new Knight(0,6,Color.WHITE);
        knight3 = new Knight(7,1,Color.BLACK);
        knight4 = new Knight(7,6,Color.BLACK);
        piece1 = new King(2,2,Color.BLACK);
        piece2 = new King(2,5,Color.BLACK);
    }

    /**
     * Tests to see if the row of the chess piece is correct
     */
    @Test
    public void testGetRow(){

        //normal cases
        assertEquals(0,knight1.getRow());
        assertEquals(0,knight2.getRow());
        assertEquals(7,knight3.getRow());
        assertEquals(7,knight4.getRow());
    }

    /**
     * Tests to see if the column of the chess piece is correct
     */
    @Test
    public void testGetColumn(){

        //normal cases
        assertEquals(1,knight1.getColumn());
        assertEquals(6,knight2.getColumn());
        assertEquals(1,knight3.getColumn());
        assertEquals(6,knight4.getColumn());
    }

    /**
     * Tests to see if the color of the chess piece is correct
     */
    @Test
    public void testGetColor(){

        //normal cases
        assertEquals(Color.WHITE,knight1.getColor());
        assertEquals(Color.WHITE,knight2.getColor());
        assertEquals(Color.BLACK,knight3.getColor());
        assertEquals(Color.BLACK,knight4.getColor());

    }

    /**
     * Tests to see if the chess piece moves to the correct location
     */
    @Test
    public void testCanMove(){

        //normal cases
        assertTrue(knight1.canMove(1,3));
        assertTrue(knight1.canMove(2,2));
        assertTrue(knight2.canMove(1,4));
        assertTrue(knight2.canMove(2,5));
        assertTrue(knight3.canMove(6,3));
        assertTrue(knight3.canMove(5,2));
        assertTrue(knight4.canMove(6,4));
        assertTrue(knight4.canMove(5,5));

        //edge case
        assertTrue(knight4.canMove(5,7));
        assertFalse(knight4.canMove(7,6));

        //invalid cases
        assertThrows(IllegalArgumentException.class,
                ()->knight4.canMove(8,6),"Expected canMove() to throw, but it didn't");
        assertThrows(IllegalArgumentException.class,
                ()->knight4.canMove(3,-6),"Expected canMove() to throw, but it didn't");


    }

    /**
     * Tests to see if the chess piece kills the correct pieces
     */
    @Test
    public void testCanKill(){

        //normal cases
        assertTrue(knight1.canKill(piece1));
        assertTrue(knight2.canKill(piece2));

    }
}
