import chess.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Vijay Venkatesan
 * This class tests the methods in the Pawn class with
 * normal, edge, and invalid cases
 */

public class TestPawn {

    Pawn pawn1;
    Pawn pawn2;
    Pawn pawn3;
    Pawn pawn4;
    ChessPiece piece1;
    ChessPiece piece2;
    ChessPiece piece3;
    ChessPiece piece4;

    @BeforeEach
    public void setUp() {
        pawn1 = new Pawn(1,0,Color.WHITE);
        pawn2 = new Pawn(1,7,Color.WHITE);
        pawn3 = new Pawn(6,0,Color.BLACK);
        pawn4 = new Pawn(6,7,Color.BLACK);
        piece1 = new Pawn(2,1,Color.BLACK);
        piece2 = new Pawn(2,6,Color.BLACK);
        piece3 = new Pawn(5,1,Color.BLACK);
        piece4 = new Pawn(5,6,Color.BLACK);

    }

    @Test
    public void testGetRow(){

        //normal cases
        assertEquals(1,pawn1.getRow());
        assertEquals(1,pawn2.getRow());
        assertEquals(6,pawn3.getRow());
        assertEquals(6,pawn4.getRow());
    }

    @Test
    public void testGetColumn(){

        //normal cases
        assertEquals(0,pawn1.getColumn());
        assertEquals(7,pawn2.getColumn());
        assertEquals(0,pawn3.getColumn());
        assertEquals(7,pawn4.getColumn());
    }

    @Test
    public void testGetColor(){

        //normal cases
        assertEquals(Color.WHITE,pawn1.getColor());
        assertEquals(Color.WHITE,pawn2.getColor());
        assertEquals(Color.BLACK,pawn3.getColor());
        assertEquals(Color.BLACK,pawn4.getColor());
    }

    @Test
    public void testCanMove(){

        //normal cases
        assertTrue(pawn1.canMove(3,0));
        assertFalse(pawn1.canMove(5,0));
        assertTrue(pawn2.canMove(3,7));
        assertFalse(pawn2.canMove(5,7));
        assertTrue(pawn3.canMove(4,0));
        assertFalse(pawn3.canMove(2,0));
        assertTrue(pawn4.canMove(4,7));
        assertFalse(pawn4.canMove(2,7));

        //edge case



        //invalid case
        assertThrows(IllegalArgumentException.class,
                ()->pawn1.canMove(9,9),"Expected canMove() to throw, but it didn't");

    }

    @Test
    public void testCanKill(){

        //normal cases
        assertTrue(pawn1.canKill(piece1));
        assertTrue(pawn2.canKill(piece2));
        assertTrue(pawn3.canKill(piece3));
        assertTrue(pawn4.canKill(piece4));

        //edge case

    }
}
