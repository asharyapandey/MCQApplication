/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.MCQApplication;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ashra
 */
public class StudentDashboardTest
{
    
    public StudentDashboardTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }


    /**
     * Test of listMarks method, of class StudentDashboard.
     */
    @Test
    public void testListMarks()
    {
        System.out.println("listMarks");
        StudentDashboard student = new StudentDashboard("Ashraya Pandey", 1);
        boolean expResult = true;
        ArrayList<Marks> demo = student.listMarks();
        boolean result;
        if (demo.isEmpty())
        {
            result = false;
        }
        else
        {
            result = true;
        }
        assertEquals(expResult, result);
    }

  
}
