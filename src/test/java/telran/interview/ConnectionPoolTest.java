package telran.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ConnectionPoolTest {
 @Test
    void addConnectionTest() {
        ConnectionPool pool = new ConnectionPool(10);
        Connection connection = new Connection("String");
        pool.addConnection(connection);
        assertThrows(IllegalStateException.class, () -> pool.addConnection(connection));
    }

    @Test
    void getConnectionTest() {
        ConnectionPool pool = new ConnectionPool(10);
        Connection connection = new Connection("String");
        pool.addConnection(connection);
        assertEquals(connection, pool.getConnection("String"));
        assertThrows(NoSuchElementException.class, () -> pool.getConnection("NextString"));
    }

    @Test
    void overlapTest() {
        ConnectionPool pool = new ConnectionPool(3);
        Connection connection1 = new Connection("String");
        Connection connection2 = new Connection("NextString");
        Connection connection3 = new Connection("ThirdString");
        Connection connection4 = new Connection("ForthString");
        Connection connection5 = new Connection("FifthString");

        pool.addConnection(connection1);
        pool.addConnection(connection2);
        pool.addConnection(connection3);
        pool.addConnection(connection4);
        pool.addConnection(connection5);

        assertThrows(NoSuchElementException.class, () -> pool.getConnection("String"));
        assertThrows(NoSuchElementException.class, () -> pool.getConnection("NextString"));
        assertEquals(connection3, pool.getConnection("ThirdString"));
        assertEquals(connection4, pool.getConnection("ForthString"));
        assertEquals(connection5, pool.getConnection("FifthString"));
    }
}