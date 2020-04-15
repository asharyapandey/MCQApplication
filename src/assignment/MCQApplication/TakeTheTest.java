/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.MCQApplication;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author ashra
 */
public class TakeTheTest extends javax.swing.JFrame
{
    DatabaseConnection databaseConnection = new DatabaseConnection();
    String Category, setID, studentName;
    int studentID, score = 0;
    JRadioButton[] correctAnswers = new JRadioButton[5];
    
    public TakeTheTest(String studentName, int studentID, String Category)
    {
        this.Category = Category;
        this.studentID = studentID;
        this.studentName = studentName;
        initComponents();
        checkSets();
        loadComponent();
        insertAttempt();
    }
    public void loadComponent()
    {
        JLabel[] questionLabel = {lblQuestionOne,lblQuestionTwo,lblQuestionThree,lblQuestionFour,lblQuestionFive};
        JRadioButton[] option1 = {rdoOptionOne4, rdoOptionTwo1, rdoOptionThree3, rdoOptionFour1, rdoOptionFive2};
        JRadioButton[] option2 = {rdoOptionOne3, rdoOptionTwo2, rdoOptionThree4, rdoOptionFour2, rdoOptionFive1};
        JRadioButton[] option3 = {rdoOptionOne2, rdoOptionTwo3, rdoOptionThree2, rdoOptionFour3, rdoOptionFive3};
        JRadioButton[] option4 = {rdoOptionOne1, rdoOptionTwo4, rdoOptionThree1, rdoOptionFour4, rdoOptionFive4};
        correctAnswers = option1;
        ArrayList<Question> questionList = listQuestions();
        for (int i = 0; i < 5; i++)
        {
            questionLabel[i].setText(questionList.get(i).getQuestion());
            option1[i].setText(questionList.get(i).getOption1());//adding correct answers to option 1
            option2[i].setText(questionList.get(i).getOption2());
            option3[i].setText(questionList.get(i).getOption3());
            option4[i].setText(questionList.get(i).getOption4());
        }
    }
    public void checkSets()
    {
        //checks all the attempted set
        ArrayList<String> notAttemptedSetList = new ArrayList<>();
        ArrayList<String> studentSetList = loadStudentSet();
        ArrayList<String> setList = loadSets();
        for (int i = 0; i < setList.size(); i++)
        {
            if (studentSetList.contains(setList.get(i)))
            {
                continue;
            }
            else
            {
                notAttemptedSetList.add(setList.get(i));
                break;
            }
        }
        if (notAttemptedSetList.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "You have Attempted All the sets in this Subject");
            setVisible(false);
            dispose();
        }
        else
        {
            setID = notAttemptedSetList.get(0);
        }
    }
    public ArrayList<String> loadSets()
    {
        //load the list of sets
        ArrayList<String> setList = new ArrayList<>();
        try
        {
            String query = "SELECT s.set_id FROM sets as s, category as c where c.subject = '" + 
                    Category + "' AND s.category_id = c.category_id";
            ResultSet rs = databaseConnection.s.executeQuery(query);
            while(rs.next())
            {
                setList.add(rs.getString("set_id"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return setList;
    }
    public ArrayList<String> loadStudentSet()
    {
        //load the list of sets
        ArrayList<String> setStudentList = new ArrayList<>();
        try
        {
            String query = "SELECT set_id FROM set_student where student_id=" + studentID;
            ResultSet rs = databaseConnection.s.executeQuery(query);
            while(rs.next())
            {
                setStudentList.add(rs.getString("set_id"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return setStudentList;
    }
    public ArrayList<Question> listQuestions()
    {
        //load the list of sets
        ArrayList<Question> questionList = new ArrayList<>();
        try
        {
            String query = "SELECT question, option1, option2, option3, option4 FROM question where set_id=" + setID + " LIMIT 5";
            ResultSet rs = databaseConnection.s.executeQuery(query);
            Question question;
            while(rs.next())
            {
                question = new Question(rs.getString("question"), rs.getString("option1"), rs.getString("option2"), rs.getString("option3"), rs.getString("option4"));
                questionList.add(question);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return questionList;
    }
    public void insertAttempt()
    {//insert data of student attempting the test
        try
        {
            String query = "insert into set_student(set_student_id, student_id, set_id) values(null, '" +
                    studentID + "', '" + setID + "');";
            databaseConnection.s.executeUpdate(query);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void insertMarks()
    {//updating matks into the table
        try
        {
            String query = "update set_student set marks=" + score + " where student_id=" + studentID + " and set_id=" + setID;
            databaseConnection.s.executeUpdate(query);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        tabbedPane = new javax.swing.JTabbedPane();
        pnlOne = new javax.swing.JPanel();
        lblQuestionOne = new javax.swing.JLabel();
        rdoOptionOne1 = new javax.swing.JRadioButton();
        rdoOptionOne2 = new javax.swing.JRadioButton();
        rdoOptionOne3 = new javax.swing.JRadioButton();
        rdoOptionOne4 = new javax.swing.JRadioButton();
        pnlTwo = new javax.swing.JPanel();
        lblQuestionTwo = new javax.swing.JLabel();
        rdoOptionTwo1 = new javax.swing.JRadioButton();
        rdoOptionTwo2 = new javax.swing.JRadioButton();
        rdoOptionTwo3 = new javax.swing.JRadioButton();
        rdoOptionTwo4 = new javax.swing.JRadioButton();
        pnlThree = new javax.swing.JPanel();
        lblQuestionThree = new javax.swing.JLabel();
        rdoOptionThree1 = new javax.swing.JRadioButton();
        rdoOptionThree2 = new javax.swing.JRadioButton();
        rdoOptionThree3 = new javax.swing.JRadioButton();
        rdoOptionThree4 = new javax.swing.JRadioButton();
        pnlFour = new javax.swing.JPanel();
        lblQuestionFour = new javax.swing.JLabel();
        rdoOptionFour1 = new javax.swing.JRadioButton();
        rdoOptionFour2 = new javax.swing.JRadioButton();
        rdoOptionFour3 = new javax.swing.JRadioButton();
        rdoOptionFour4 = new javax.swing.JRadioButton();
        pnlFive = new javax.swing.JPanel();
        lblQuestionFive = new javax.swing.JLabel();
        rdoOptionFive1 = new javax.swing.JRadioButton();
        rdoOptionFive2 = new javax.swing.JRadioButton();
        rdoOptionFive3 = new javax.swing.JRadioButton();
        rdoOptionFive4 = new javax.swing.JRadioButton();
        btnFinish = new javax.swing.JButton();
        btnDashboard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblQuestionOne.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQuestionOne.setText("What is your name?");

        buttonGroup2.add(rdoOptionOne1);
        rdoOptionOne1.setText("jRadioButton1");

        buttonGroup2.add(rdoOptionOne2);
        rdoOptionOne2.setText("jRadioButton1");

        buttonGroup2.add(rdoOptionOne3);
        rdoOptionOne3.setText("jRadioButton1");

        buttonGroup2.add(rdoOptionOne4);
        rdoOptionOne4.setText("jRadioButton1");

        javax.swing.GroupLayout pnlOneLayout = new javax.swing.GroupLayout(pnlOne);
        pnlOne.setLayout(pnlOneLayout);
        pnlOneLayout.setHorizontalGroup(
            pnlOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOneLayout.createSequentialGroup()
                .addGroup(pnlOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOneLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(pnlOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rdoOptionOne1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addComponent(rdoOptionOne2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoOptionOne3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(rdoOptionOne4, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlOneLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblQuestionOne, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        pnlOneLayout.setVerticalGroup(
            pnlOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOneLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblQuestionOne)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionOne1)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionOne2)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionOne3)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionOne4)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Question 1", pnlOne);

        lblQuestionTwo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQuestionTwo.setText("What is your name?");

        buttonGroup1.add(rdoOptionTwo1);
        rdoOptionTwo1.setText("jRadioButton1");

        buttonGroup1.add(rdoOptionTwo2);
        rdoOptionTwo2.setText("jRadioButton1");

        buttonGroup1.add(rdoOptionTwo3);
        rdoOptionTwo3.setText("jRadioButton1");

        buttonGroup1.add(rdoOptionTwo4);
        rdoOptionTwo4.setText("jRadioButton1");

        javax.swing.GroupLayout pnlTwoLayout = new javax.swing.GroupLayout(pnlTwo);
        pnlTwo.setLayout(pnlTwoLayout);
        pnlTwoLayout.setHorizontalGroup(
            pnlTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTwoLayout.createSequentialGroup()
                .addGroup(pnlTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTwoLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(pnlTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rdoOptionTwo1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                            .addComponent(rdoOptionTwo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdoOptionTwo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdoOptionTwo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlTwoLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(lblQuestionTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        pnlTwoLayout.setVerticalGroup(
            pnlTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTwoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblQuestionTwo)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionTwo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoOptionTwo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoOptionTwo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoOptionTwo4)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Question 2", pnlTwo);

        lblQuestionThree.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQuestionThree.setText("What is your name?");

        buttonGroup3.add(rdoOptionThree1);
        rdoOptionThree1.setText("jRadioButton1");

        buttonGroup3.add(rdoOptionThree2);
        rdoOptionThree2.setText("jRadioButton1");

        buttonGroup3.add(rdoOptionThree3);
        rdoOptionThree3.setText("jRadioButton1");

        buttonGroup3.add(rdoOptionThree4);
        rdoOptionThree4.setText("jRadioButton1");

        javax.swing.GroupLayout pnlThreeLayout = new javax.swing.GroupLayout(pnlThree);
        pnlThree.setLayout(pnlThreeLayout);
        pnlThreeLayout.setHorizontalGroup(
            pnlThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThreeLayout.createSequentialGroup()
                .addGroup(pnlThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rdoOptionThree4, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoOptionThree3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoOptionThree2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlThreeLayout.createSequentialGroup()
                            .addGap(109, 109, 109)
                            .addComponent(rdoOptionThree1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlThreeLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lblQuestionThree, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlThreeLayout.setVerticalGroup(
            pnlThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThreeLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblQuestionThree)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionThree1)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionThree2)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionThree3)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionThree4)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Question 3", pnlThree);

        lblQuestionFour.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQuestionFour.setText("What is your name?");

        buttonGroup4.add(rdoOptionFour1);
        rdoOptionFour1.setText("jRadioButton1");

        buttonGroup4.add(rdoOptionFour2);
        rdoOptionFour2.setText("jRadioButton1");

        buttonGroup4.add(rdoOptionFour3);
        rdoOptionFour3.setText("jRadioButton1");

        buttonGroup4.add(rdoOptionFour4);
        rdoOptionFour4.setText("jRadioButton1");

        javax.swing.GroupLayout pnlFourLayout = new javax.swing.GroupLayout(pnlFour);
        pnlFour.setLayout(pnlFourLayout);
        pnlFourLayout.setHorizontalGroup(
            pnlFourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFourLayout.createSequentialGroup()
                .addGroup(pnlFourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFourLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(pnlFourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rdoOptionFour1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                            .addComponent(rdoOptionFour2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdoOptionFour3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdoOptionFour4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlFourLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblQuestionFour, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        pnlFourLayout.setVerticalGroup(
            pnlFourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFourLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblQuestionFour)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionFour1)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionFour2)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionFour3)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionFour4)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Question 4", pnlFour);

        lblQuestionFive.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQuestionFive.setText("What is your name?");

        buttonGroup5.add(rdoOptionFive1);
        rdoOptionFive1.setText("jRadioButton1");

        buttonGroup5.add(rdoOptionFive2);
        rdoOptionFive2.setText("jRadioButton1");

        buttonGroup5.add(rdoOptionFive3);
        rdoOptionFive3.setText("jRadioButton1");

        buttonGroup5.add(rdoOptionFive4);
        rdoOptionFive4.setText("jRadioButton1");

        btnFinish.setText("Finish");
        btnFinish.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFinishActionPerformed(evt);
            }
        });

        btnDashboard.setText("Dashboard");
        btnDashboard.setEnabled(false);
        btnDashboard.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDashboardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiveLayout = new javax.swing.GroupLayout(pnlFive);
        pnlFive.setLayout(pnlFiveLayout);
        pnlFiveLayout.setHorizontalGroup(
            pnlFiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiveLayout.createSequentialGroup()
                .addGroup(pnlFiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFiveLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(pnlFiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoOptionFive1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoOptionFive2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoOptionFive3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoOptionFive4, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFiveLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(lblQuestionFive, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFiveLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        pnlFiveLayout.setVerticalGroup(
            pnlFiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiveLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblQuestionFive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoOptionFive1)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionFive2)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionFive3)
                .addGap(18, 18, 18)
                .addComponent(rdoOptionFive4)
                .addGap(36, 36, 36)
                .addGroup(pnlFiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Question 5", pnlFive);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnFinishActionPerformed
    {//GEN-HEADEREND:event_btnFinishActionPerformed
        
        for (int i = 0; i < correctAnswers.length; i++)
        {
            if (correctAnswers[i].isSelected())
            {
                score++;
            }
        }
        JOptionPane.showMessageDialog(null, "You Have Scored " + score + " points");
        insertMarks();
        btnFinish.setEnabled(false);
        btnDashboard.setEnabled(true);
    }//GEN-LAST:event_btnFinishActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDashboardActionPerformed
    {//GEN-HEADEREND:event_btnDashboardActionPerformed
        new StudentDashboard(studentName, studentID).setVisible(true);
    }//GEN-LAST:event_btnDashboardActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(TakeTheTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TakeTheTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TakeTheTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TakeTheTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new TakeTheTest("Ashraya Pandey", 2, "Modern Web Development").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnFinish;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JLabel lblQuestionFive;
    private javax.swing.JLabel lblQuestionFour;
    private javax.swing.JLabel lblQuestionOne;
    private javax.swing.JLabel lblQuestionThree;
    private javax.swing.JLabel lblQuestionTwo;
    private javax.swing.JPanel pnlFive;
    private javax.swing.JPanel pnlFour;
    private javax.swing.JPanel pnlOne;
    private javax.swing.JPanel pnlThree;
    private javax.swing.JPanel pnlTwo;
    private javax.swing.JRadioButton rdoOptionFive1;
    private javax.swing.JRadioButton rdoOptionFive2;
    private javax.swing.JRadioButton rdoOptionFive3;
    private javax.swing.JRadioButton rdoOptionFive4;
    private javax.swing.JRadioButton rdoOptionFour1;
    private javax.swing.JRadioButton rdoOptionFour2;
    private javax.swing.JRadioButton rdoOptionFour3;
    private javax.swing.JRadioButton rdoOptionFour4;
    private javax.swing.JRadioButton rdoOptionOne1;
    private javax.swing.JRadioButton rdoOptionOne2;
    private javax.swing.JRadioButton rdoOptionOne3;
    private javax.swing.JRadioButton rdoOptionOne4;
    private javax.swing.JRadioButton rdoOptionThree1;
    private javax.swing.JRadioButton rdoOptionThree2;
    private javax.swing.JRadioButton rdoOptionThree3;
    private javax.swing.JRadioButton rdoOptionThree4;
    private javax.swing.JRadioButton rdoOptionTwo1;
    private javax.swing.JRadioButton rdoOptionTwo2;
    private javax.swing.JRadioButton rdoOptionTwo3;
    private javax.swing.JRadioButton rdoOptionTwo4;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
