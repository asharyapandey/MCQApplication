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
public class AddQuestionsTest
{
    
    public AddQuestionsTest()
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
     * Test of questionList method, of class AddQuestions.
     */
    @Test
    public void testQuestionList()
    {
        System.out.println("questionList");
        AddQuestions instance = new AddQuestions();
        boolean expResult = true;
        ArrayList<Question> demo = instance.questionList();
        boolean result;
        if (demo.isEmpty())
            result = false;
        else
            result = true;
        assertEquals(expResult, result);
    }

}
