package org.ykj.ex00.sample;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTests {
  @Test
  public void testConnection() throws Exception{
    //DB Driver Class
    Class.forName("org.mariadb.jdbc.Driver");
    //URL
    Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3307/bootex", "bootuser", "sys123");
    System.out.println("connection = " + connection);
    //username/password
    connection.close();
  }
}
