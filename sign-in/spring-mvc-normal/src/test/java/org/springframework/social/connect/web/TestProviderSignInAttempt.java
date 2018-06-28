package org.springframework.social.connect.web;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Petri Kainulainen
 */
public class TestProviderSignInAttempt extends ProviderSignInAttempt {

    private Connection<?> connection;

    private Set<String> connections = new HashSet<>();

    private boolean usersConnectionRepositorySet = false;

    public TestProviderSignInAttempt(Connection<?> connection, UsersConnectionRepository usersConnectionRepository) {
        super(connection);
        this.connection = connection;

        if (usersConnectionRepository != null) {
            this.usersConnectionRepositorySet = true;
        }
    }

    @Override
    public Connection<?> getConnection(ConnectionFactoryLocator connectionFactoryLocator) {
        return connection;
    }

    @Override
    void addConnection(String userId, ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository connectionRepository) {
        if (usersConnectionRepositorySet) {
            super.addConnection(userId, connectionFactoryLocator, connectionRepository);

        }
    }

    /*@Override
    public Connection<?> getConnection() {
        return connection;
    }

    @Override
    void addConnection(String userId) {
        connections.add(userId);
        if (usersConnectionRepositorySet) {
            super.addConnection(userId);
        }
    }*/

    public Set<String> getConnections() {
        return connections;
    }
}
