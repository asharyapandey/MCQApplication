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
public class RegisterStudentsTest
{
    
    public RegisterStudentsTest()
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
     * Test of studentList method, of class RegisterStudents.
     */
    @Test
    public void testStudentList()
    {
        System.out.println("studentList");
        RegisterStudents instance = new RegisterStudents();
        boolean expResult = true;
        ArrayList<Student> demo = instance.studentList();
        boolean result;
        if (demo.isEmpty())
            result = false;
        else
            result = true;
        assertEquals(expResult, result);
    }

}
