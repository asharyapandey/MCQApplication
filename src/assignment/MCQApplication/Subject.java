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
class Subject
{
    private int id;
    private String subjectName;

    public Subject(int id, String subjectName)
    {
        this.id = id;
        this.subjectName = subjectName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSubjectName()
    {
        return subjectName;
    }

    public void setSubjectName(String subjectName)
    {
        this.subjectName = subjectName;
    }
    
}
