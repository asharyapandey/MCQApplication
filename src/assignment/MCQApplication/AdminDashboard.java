/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.MCQApplication;

import java.sql.ResultSet;
import javax.swing.*;
/**
 *
 * @author ashra
 */
public class AdminDashboard extends javax.swing.JFrame
{
    JTextField txt;
    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard()
    {
        initComponents();
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

        jLabel2 = new javax.swing.JLabel();
        btnLoginToken = new javax.swing.JButton();
        btnAddQuestion = new javax.swing.JButton();
        btnAddSubject = new javax.swing.JButton();
        btnAddSet = new javax.swing.JButton();
        btnRegisterStudent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Welcome to the Admin Dashboard");

        btnLoginToken.setText("Generate Login Token For Students");
        btnLoginToken.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLoginTokenActionPerformed(evt);
            }
        });

        btnAddQuestion.setText("Add Questions");
        btnAddQuestion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddQuestionActionPerformed(evt);
            }
        });

        btnAddSubject.setText("Add Subject");
        btnAddSubject.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddSubjectActionPerformed(evt);
            }
        });

        btnAddSet.setText("Add Set");
        btnAddSet.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddSetActionPerformed(evt);
            }
        });

        btnRegisterStudent.setText("Register Students");
        btnRegisterStudent.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRegisterStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegisterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLoginToken, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegisterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoginToken, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(btnAddSet, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(695, 486));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginTokenActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLoginTokenActionPerformed
    {//GEN-HEADEREND:event_btnLoginTokenActionPerformed
        new GenerateLoginToken().show();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnLoginTokenActionPerformed

    private void btnAddSubjectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddSubjectActionPerformed
    {//GEN-HEADEREND:event_btnAddSubjectActionPerformed
        new AddSubject().setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnAddSubjectActionPerformed

    private void btnAddSetActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddSetActionPerformed
    {//GEN-HEADEREND:event_btnAddSetActionPerformed
        new AddSet().setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnAddSetActionPerformed

    private void btnAddQuestionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddQuestionActionPerformed
    {//GEN-HEADEREND:event_btnAddQuestionActionPerformed
        new AddQuestions().setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnAddQuestionActionPerformed

    private void btnRegisterStudentActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRegisterStudentActionPerformed
    {//GEN-HEADEREND:event_btnRegisterStudentActionPerformed
        new RegisterStudents().setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnRegisterStudentActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddQuestion;
    private javax.swing.JButton btnAddSet;
    private javax.swing.JButton btnAddSubject;
    private javax.swing.JButton btnLoginToken;
    private javax.swing.JButton btnRegisterStudent;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
