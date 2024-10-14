import chess.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Vijay Venkatesan
 * This class tests the methods in the King class with
 * normal, edge, and invalid cases
 */

public class TestKing {

    King king1;
    King king2;
    ChessPiece piece1;
    ChessPiece piece2;
    ChessPiece piece3;

    /**
     * Initializing the King chess pieces
     */
    @BeforeEach
    public void setUp() {
        king1 = new King(0,4,Color.WHITE);
        king2 = new King(7,4,Color.BLACK);
        piece1 = new King(1,4,Color.BLACK);
        piece2 = new King(6,4,Color.BLACK);
        piece3 = new King(7,6,Color.WHITE);

    }

    /**
     * Tests to see if the row of the chess piece is correct
     */
    @Test
    public void testGetRow(){

        //normal cases
        assertEquals(0,king1.getRow());
        assertEquals(7,king2.getRow());
    }

    /**
     * Tests to see if the column of the chess piece is correct
     */
    @Test
    public void testGetColumn(){

        //normal cases
        assertEquals(4,king1.getColumn());
        assertEquals(4,king2.getColumn());
    }

    /**
     * Tests to see if the color of the chess piece is correct
     */
    @Test
    public void testGetColor(){

        //normal cases
        assertEquals(Color.WHITE,king1.getColor());
        assertEquals(Color.BLACK,king2.getColor());

    }

    /**
     * Tests to see if the chess piece moves to the correct location
     */
    @Test
    public void testCanMove(){
        //normal cases
        assertTrue(king1.canMove(1,4));
        assertTrue(king1.canMove(1,3));
        assertTrue(king1.canMove(1,5));
        assertTrue(king1.canMove(0,3));
        assertTrue(king1.canMove(0,5));

        assertTrue(king2.canMove(6,4));
        assertTrue(king2.canMove(6,3));
        assertTrue(king2.canMove(6,5));


        assertFalse(king2.canMove(5,4));

        //edge case
        assertTrue(piece3.canMove(7,7));
        assertFalse(piece3.canMove(7,6));

        //invalid cases
        assertThrows(IllegalArgumentException.class,
                ()->piece3.canMove(8,6),"Expected canMove() to throw, but it didn't");
        assertThrows(IllegalArgumentException.class,
                ()->piece3.canMove(4,-6),"Expected canMove() to throw, but it didn't");
    }

    /**
     * Tests to see if the chess piece kills the correct pieces
     */
    @Test
    public void testCanKill(){
        //normal cases
        assertTrue(king1.canKill(piece1));
        assertFalse(king2.canKill(piece2));

    }




}