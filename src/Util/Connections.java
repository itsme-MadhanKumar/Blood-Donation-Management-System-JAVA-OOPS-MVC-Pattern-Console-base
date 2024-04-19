package Util;

import java.sql.*;
public class Connections
{
    private static final String URL = "jdbc:mysql://localhost:3306/BD";
    private static final String USER = "root";
    private static final String PSW = "Universe9952@";
    protected static Connection conn = null;
    public Connection connect() throws SQLException
    {
        if(conn==null)
        {
            return conn  = (Connection) DriverManager.getConnection(URL,USER,PSW);
        }
        return conn;
    }
}
