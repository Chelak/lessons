package org.example.dao.impl.ex2;

import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;

@JdbcTest
@ComponentScan(value = "org.example")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public abstract class AbstractDAOTestConfiguration {
}
