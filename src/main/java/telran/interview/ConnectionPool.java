package telran.interview;

public class ConnectionPool {
//TODO work out data structure
//Connection pool comprises of some number of connections
//It canot contains more than the predefined number of connection
//You should define some Connection Pool policy so that if number of connections 
//is going to exceed the limit a connection should be removed from the connection
//Policy should take in consideration the order of adding connections in pool
// and using connection
public ConnectionPool(int size) {
    //TODO
}
public void addConnection(Connection connection) {
    //TODO
    // if the connection already exists in the pool the IllegalStateException should be thrown
}
public Connection getConnection(String connectionId) {
    //TODO
    //If connection with a given ID doesn't exist the NoSuchElementException should be thrown
    return null;
}
}