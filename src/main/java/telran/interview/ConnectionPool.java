package telran.interview;

import java.util.*;

public class ConnectionPool {
   LinkedHashMap<String, Connection> connPool;

    public ConnectionPool(int size) {
        connPool = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Connection> eldest) {
                return size() > size;
            }
        };
    }

public void addConnection(Connection connection) {
    if (connPool.containsKey(connection.connectionId())) {
        throw new IllegalStateException();
    }
    connPool.put(connection.connectionId(), connection);
}

public Connection getConnection(String connectionId) {
    if (!connPool.containsKey(connectionId)) {
        throw new NoSuchElementException();
    }

    return connPool.get(connectionId);
}
}