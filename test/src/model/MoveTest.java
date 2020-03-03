package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
    /**
     * test to check if two moves are equal
     */
    @Test
    void TestMoveConstructor() {
        //test if the two moves are equal
        Move m = new Move(9, 13);
        Move m1 = new Move(9, 14);
        assertNotEquals(m, m1);

        //mutation test
        Move m2 = new Move(13, 9);
        Move m3 = new Move(14, 9);
        assertNotEquals(m2, m3);

        //test if moving two different pieces are equal (should be not equal)
        Move m4 = new Move(9, 13);
        Move m5 = new Move(9, 13);
        assertNotEquals(m4, m5);

        //test if the same move is equal
        assertEquals(m4, m4);

    }

    /**
     * check if it gets the correct start index
     */
    @Test
    void getStartIndex() {
        Move m = new Move(1, 3);
        assertEquals(m.getStartIndex(), 1);
        assertNotEquals(m.getStartIndex(), 3);

        //mutation testing
        Move m1 = new Move(3, 1);
        assertEquals(m1.getStartIndex(), 3);
        assertNotEquals(m1.getStartIndex(), 1);


    }

    /**
     * check the end index of the move
     */
    @Test
    void getEndIndex() {
        Move m = new Move(9, 12);
        assertEquals(m.getEndIndex(), 12);
        assertNotEquals(m.getEndIndex(), 9);

        //mutation test
        Move m1 = new Move(12, 9);
        assertEquals(m1.getEndIndex(), 9);
        assertNotEquals(m1.getEndIndex(), 12);
    }

    /**
     * check by setting a new start index
     */
    @Test
    void setStartIndex() {
        Move m = new Move(9, 13);
        assertEquals(m.getStartIndex(), 9);
        m.setStartIndex(10);
        assertEquals(m.getStartIndex(), 10);
        assertNotEquals(m.getStartIndex(), 9);

        //mutation test
        Move m1 = new Move(13, 9);
        assertEquals(m1.getStartIndex(), 9);

        m.setStartIndex(11);
        assertEquals(m1.getStartIndex(), 11);
        assertNotEquals(m1.getStartIndex(), 9);

    }


    /**
     * check by setting a new end index
     */
    @Test
    void setEndIndex() {

        Move m = new Move(9, 13);
        assertEquals(m.getEndIndex(), 13);

        m.setEndIndex(10);
        assertEquals(m.getEndIndex(), 10);
        assertNotEquals(m.getEndIndex(), 13);

        //mutation test
        Move m1 = new Move(13, 9);
        assertEquals(m1.getEndIndex(), 9);

        m.setEndIndex(11);
        assertEquals(m1.getEndIndex(), 11);
        assertNotEquals(m1.getEndIndex(), 9);


    }
}