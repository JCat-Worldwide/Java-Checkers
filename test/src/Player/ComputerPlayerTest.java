package Player;

import model.ComputerPlayer;
import model.Game;
import model.HumanPlayer;
import model.Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ComputerPlayerTest {
    @Test
    public void testIsHuman(){
        // Computer Player
        Player c = new ComputerPlayer();
        assertFalse(c.isHuman());

        // Human become a Computer player
        Player h = new HumanPlayer();
        assertTrue(h.isHuman());
        h = new ComputerPlayer();
        assertFalse(h.isHuman());
    }

    @Test
    public void testUpdateGame(){
        // Computer vs Computer
        Game g = new Game();
        Player c1 = new ComputerPlayer();   // Player 1
        Player c2 = new ComputerPlayer();   // Player 2

        c1.updateGame(g);
        assertFalse(g.isP1Turn());  // c2's turn
        g.move(25,17);  // Invalid move
        assertFalse(g.isP1Turn());  // still c2's turn
        c2.updateGame(g);
        assertTrue(g.isP1Turn());   // c1's turn

        // Computer vs Human
        Game g2 = new Game();
        Player c3 = new ComputerPlayer();   // Player 1
        Player h4 = new HumanPlayer();  // Player 2
        assertTrue(g2.isP1Turn());  // Computer's turn
        c3.updateGame(g2);
        assertFalse(g2.isP1Turn()); // Human's turn
        h4.updateGame(g2);  // Since this does nothing
        g2.move(20, 16);    // We have to move our human
        assertTrue(g2.isP1Turn());  // Computer's turn
    }

    @Test
    public void testToString(){
        Player c = new ComputerPlayer();
        assertEquals("ComputerPlayer[isHuman=false]", c.toString());

        Player h = new HumanPlayer();
        assertNotEquals("ComputerPlayer[isHuman=false]", h.toString());
    }

}

