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
class Set
{
    private int id;
    private String subjectName, setName;

    public Set(int id, String subjectName, String setName)
    {
        this.id = id;
        this.subjectName = subjectName;
        this.setName = setName;
    }

    public String getSetName()
    {
        return setName;
    }

    public void setSetName(String setName)
    {
        this.setName = setName;
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
