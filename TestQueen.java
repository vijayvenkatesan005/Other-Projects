import chess.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Vijay Venkatesan
 * This class tests the methods in the Queen class with
 * normal, edge, and invalid cases
 */

public class TestQueen {

    Queen queen1;
    Queen queen2;
    ChessPiece piece1;
    ChessPiece piece2;
    ChessPiece piece3;
    ChessPiece piece4;
    ChessPiece piece5;
    ChessPiece piece6;

    @BeforeEach
    public void setUp() {
        queen1 = new Queen(0,3,Color.WHITE);
        queen2 = new Queen(7,3,Color.BLACK);
        piece1 = new Queen(4,7,Color.WHITE);
        piece2 = new Queen(4,0,Color.BLACK);
        piece3 = new Queen(4,6,Color.WHITE);
        piece4 = new Queen(2,7,Color.BLACK);
        piece5 = new Queen(7,7,Color.BLACK);
        //piece6 = new Queen(9,9,Color.BLACK);

    }

    @Test
    public void testGetRow(){

        //normal cases
        assertEquals(0,queen1.getRow());
        assertEquals(7,queen2.getRow());
    }

    @Test
    public void testGetColumn(){

        //normal cases
        assertEquals(3,queen1.getColumn());
        assertEquals(3,queen2.getColumn());
    }

    @Test
    public void testGetColor(){

        //normal cases
        assertEquals(Color.WHITE,queen1.getColor());
        assertEquals(Color.BLACK,queen2.getColor());
    }

    @Test
    public void testCanMove(){

        //normal cases
        assertTrue(queen1.canMove(5,3));
        assertTrue(queen2.canMove(3,7));
        assertFalse(queen1.canMove(1,1));
        assertFalse(queen2.canMove(6,5));

        //edge case
        assertTrue(queen2.canMove(7,7));

        //invalid case
        assertThrows(IllegalArgumentException.class,
                ()->queen1.canMove(9,9),"row must be between 0 and 7 inclusive");

    }

    @Test
    public void testCanKill(){

        //normal cases
        assertFalse(queen1.canKill(piece1));
        assertFalse(queen2.canKill(piece2));
        assertFalse(queen1.canKill(piece3));
        assertFalse(queen2.canKill(piece4));

        //edge case
        assertFalse(queen2.canKill(piece5));

        //invalid case


    }

}