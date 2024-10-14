import chess.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Vijay Venkatesan
 * This class tests the methods in the Rook class with
 * normal, edge, and invalid cases
 */

public class TestRook {
    Rook rook1;
    Rook rook2;
    Rook rook3;
    Rook rook4;
    ChessPiece piece1;
    ChessPiece piece2;
    ChessPiece piece3;
    ChessPiece piece4;
    ChessPiece piece5;

    @BeforeEach
    public void setUp() {
        rook1 = new Rook(0,0,Color.WHITE);
        rook2 = new Rook(0,7,Color.WHITE);
        rook3 = new Rook(7,0,Color.BLACK);
        rook4 = new Rook(7,7,Color.BLACK);
        piece1 = new Rook(2,0,Color.WHITE);
        //change the values for pieces 2-4
        piece2 = new Rook(0,4,Color.WHITE);
        piece3 = new Rook(7,4,Color.BLACK);
        piece4 = new Rook(3,7,Color.BLACK);
        piece5 = new Rook(0,7, Color.WHITE);
    }

    @Test
    public void testGetRow(){

        //normal cases
        assertEquals(0,rook1.getRow());
        assertEquals(0,rook2.getRow());
        assertEquals(7,rook3.getRow());
        assertEquals(7,rook4.getRow());

    }

    @Test
    public void testGetColumn(){

        //normal cases
        assertEquals(0,rook1.getColumn());
        assertEquals(7,rook2.getColumn());
        assertEquals(0,rook3.getColumn());
        assertEquals(7,rook4.getColumn());

    }

    @Test
    public void testGetColor(){

        //normal cases
        assertEquals(Color.WHITE,rook1.getColor());
        assertEquals(Color.WHITE,rook2.getColor());
        assertEquals(Color.BLACK,rook3.getColor());
        assertEquals(Color.BLACK,rook4.getColor());
    }

    @Test
    public void testCanMove(){

        //normal cases
        assertTrue(rook1.canMove(2,0));
        assertTrue(rook2.canMove(0,6));
        assertTrue(rook3.canMove(7,5));
        assertTrue(rook4.canMove(4,7));

        //edge case

        //invalid case
        assertThrows(IllegalArgumentException.class,
                ()->rook1.canMove(9,9),"Expected canMove() to throw, but it didn't");

    }

    @Test
    public void testCanKill(){

        //normal cases
        assertFalse(rook1.canKill(piece1));
        assertFalse(rook2.canKill(piece2));
        assertFalse(rook3.canKill(piece3));
        assertFalse(rook4.canKill(piece4));

        //edge case
        assertTrue(rook4.canKill(piece5));

    }
}