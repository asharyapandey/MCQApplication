/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.MCQApplication;

import java.sql.*;

/**
 *
 * @author ashra
 */
public class DatabaseConnection
{
    Connection c;
    Statement s;
    public DatabaseConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///mcqapplicationdb", "root", "");
            s = c.createStatement();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
