/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.MCQApplication;

/**
 *
 * @author ashra
 */
class Marks
{
    private String marks, setName, subject;

    public Marks(String marks, String setName, String subject)
    {
        this.marks = marks;
        this.setName = setName;
        this.subject = subject;
    }

    public String getMarks()
    {
        return marks;
    }

    public void setMarks(String marks)
    {
        this.marks = marks;
    }

    public String getSetName()
    {
        return setName;
    }

    public void setSetName(String setName)
    {
        this.setName = setName;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
}
