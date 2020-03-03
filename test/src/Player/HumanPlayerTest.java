package Player;

import model.ComputerPlayer;
import model.Game;
import model.HumanPlayer;
import model.Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class HumanPlayerTest {
    @Test
    public void testIsHuman() {
        // Human Player
        Player h = new HumanPlayer();
        assertTrue(h.isHuman());

        // Computer player turned into human player
        Player c = new ComputerPlayer();
        assertFalse(c.isHuman());
        c = new HumanPlayer();
        assertTrue(c.isHuman());
    }

    @Test
    public void testUpdateGame() {
        // Human against human
        Game g = new Game();
        Player h1 = new HumanPlayer();  //player 1
        Player h2 = new HumanPlayer();  //player 2

        h1.updateGame(g);   // does nothing
        g.move(8, 12);    // We have to move our human h1
        assertFalse(g.isP1Turn());  // h2's turn
        g.move(9,13);  // try to move h1, should be rejected
        assertFalse(g.isP1Turn());  // still h2's turn
        h2.updateGame(g);   //does nothing
        g.move(22, 18);     // We have to move our human h2
        assertTrue(g.isP1Turn());   // h1 turn
        h1.updateGame(g);   // does nothing
        g.move(1, 8);   // Let's give our human h1 invalid move
        assertTrue(g.isP1Turn());   // should still be h1 turn
        g.move(9,13); // move our human h1
        assertFalse(g.isP1Turn());  // h2's turn

        // Human against computer
        Game g2 = new Game();
        Player h3 = new HumanPlayer();  // Player 1
        Player c4 = new ComputerPlayer();   //Player 2
        h3.updateGame(g2);   // does nothing
        g2.move(8, 12);    // We have to move our human h3
        assertFalse(g2.isP1Turn()); // computer's turn
        g2.move(9, 13);     // Try to move our human h3, should be rejected
        assertFalse(g2.isP1Turn()); // still computer's turn
        c4.updateGame(g2);  // Computer makes a move
        assertTrue(g2.isP1Turn()); // human's turn
        g2.move(1,8);   // Let's give our human h1 invalid move
        assertTrue(g2.isP1Turn()); // still should be human's turn
    }

    @Test
    public void testToString() {
        Player h = new HumanPlayer();
        assertEquals("HumanPlayer[isHuman=true]", h.toString());

        Player c = new ComputerPlayer();
        assertNotEquals("HumanPlayer[isHuman=true]", c.toString());
    }

}
