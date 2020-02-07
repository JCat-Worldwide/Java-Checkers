package network;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

    @Test
    void send() {
        String response = "";
        Command c = new Command(Command.COMMAND_CONNECT, "connect");
        try {
            response = c.send("127.0.0.1", 8080);
        } finally {
            assertEquals("java.net.ConnectException: Connection refused: connect", response);
        }
    }

    @Test
    void getCommand() {
        Command c = new Command(Command.COMMAND_UPDATE, "TESTING");
        String command = c.getCommand();
        assertEquals("UPDATE", command);
    }

    @Test
    void setCommand() {
        Command c = new Command(Command.COMMAND_UPDATE, "TESTING");
        c.setCommand(Command.COMMAND_CONNECT);
        String command = c.getCommand();
        assertEquals("CONNECT", command);
    }

    @Test
    void getData() {
        Command c = new Command(Command.COMMAND_UPDATE, "TESTING");
        String[] data = c.getData();
        assertEquals(1, data.length);
    }

    @Test
    void setData() {
        Command c = new Command(Command.COMMAND_UPDATE, "TESTING");
        String[] foo = {"foo", "bar"};
        c.setData(foo);
        String[] data = c.getData();
        assertEquals(2, data.length);
    }

}
