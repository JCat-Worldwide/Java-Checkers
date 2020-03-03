package logic;

import model.Board;
import model.Game;

import java.awt.Point;

import model.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveLogicTest {

    @Test
    void isValidMove() {
        Game g = new Game();
        //case 1: test first move
        boolean valid = MoveLogic.isValidMove(g, 8, 12);
        assertTrue(valid);

        boolean valid4 = MoveLogic.isValidMove(g, 10, 14);
        assertTrue(valid4);

        //mutation test (move two steps)
        boolean valid8 = MoveLogic.isValidMove(g, 10, 17);
        assertFalse(valid8);


        //case 2: no piece to move
        boolean valid3 = MoveLogic.isValidMove(g, 14, 18);
        assertFalse(valid3);
        //mutation
        boolean valid2 = MoveLogic.isValidMove(g, 18, 14);
        assertFalse(valid2);

        //case 3: test move to a spot with a piece
        boolean valid5 = MoveLogic.isValidMove(g, 4, 8);
        assertFalse(valid5);
        //mutation
        boolean valid9 = MoveLogic.isValidMove(g, 8, 13);
        assertTrue(valid9);

        //restart the board
        g.restart();
        //move the black piece from index 8 to 12
        g.move(10, 14);
        g.move(9, 13);
        //case 4: test invalid move (going back)
        boolean valid1 = MoveLogic.isValidMove(g, 14, 10);
        assertFalse(valid1);
        //mutation
        boolean valid7 = MoveLogic.isValidMove(g, 14, 9);
        assertFalse(valid7);

    }

    @Test
    void testIsValidMove() {

        //case 1: test if there is any board
        Board b = new Board();
        boolean isP1Turn = true;
        boolean valid = MoveLogic.isValidMove(b, isP1Turn, 8, 12, 33);
        assertTrue(valid);

        //mutation test if the move is valid
        Board b1 = null;
        isP1Turn = true;
        valid = MoveLogic.isValidMove(b1, isP1Turn, 8, 12, 33);
        assertFalse(valid);


        //case2: when it is not p1's turn
        Board b2 = new Board();
        isP1Turn = false;
        valid = MoveLogic.isValidMove(b2, isP1Turn, 8, 12, 33);
        assertFalse(valid);

        Board b4 = new Board();
        isP1Turn = false;
        valid = MoveLogic.isValidMove(b4, isP1Turn, 8, 13, 33);
        assertFalse(valid);

        //case3: when the move is invalid (moving to invalid spot)
        Board b5 = new Board();
        isP1Turn = true;
        valid = MoveLogic.isValidMove(b5, isP1Turn, 8, 12, 33);
        assertTrue(valid);

        //mutation
        Board b3 = new Board();
        isP1Turn = true;
        valid = MoveLogic.isValidMove(b3, isP1Turn, 8, 9, 33);
        assertFalse(valid);

    }

}