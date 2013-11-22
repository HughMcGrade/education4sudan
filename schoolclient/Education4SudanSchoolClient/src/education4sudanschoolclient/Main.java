/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package education4sudanschoolclient;

import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hugh
 */
public final class Main extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pushAttendance = new javax.swing.JButton();
        pushResourcesButton = new javax.swing.JButton();
        fetchNotificationsButton = new javax.swing.JButton();
        pushTeachersButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Attendance");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Resources");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Notifications");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Teachers");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        pushAttendance.setText("Push Attendance");
        pushAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pushAttendanceActionPerformed(evt);
            }
        });

        pushResourcesButton.setText("Push Resources");
        pushResourcesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pushResourcesButtonActionPerformed(evt);
            }
        });

        fetchNotificationsButton.setText("Fetch Notifications");
        fetchNotificationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchNotificationsButtonActionPerformed(evt);
            }
        });

        pushTeachersButton.setText("Push Teachers");
        pushTeachersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pushTeachersButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pushAttendance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(fetchNotificationsButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pushResourcesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pushTeachersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pushAttendance)
                    .addComponent(pushResourcesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fetchNotificationsButton)
                    .addComponent(pushTeachersButton))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new AttendanceForm().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ResourcesForm().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new TeachersForm().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private static String readFile(String fileName) throws FileNotFoundException {
        StringBuilder builder = new StringBuilder();    
        try (BufferedReader fileReader = new BufferedReader (new FileReader(SchoolData.getDataFileLocation(fileName)))) {
            while (fileReader.ready()) {
                builder.append(fileReader.readLine());
                builder.append(System.getProperty("line.separator"));
            }
        }
        catch (IOException e) {
            // TODO handle
            return "";
        }
        return builder.toString();
    }
    
    private static void writeFile(String fileName, String content) throws IOException {
        File file = new File(SchoolData.getDataFileLocation(fileName));
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
        catch (FileNotFoundException e) {
            file.createNewFile();
        }
        catch (IOException e) {
            // TODO handle
            throw e;
        }
    }
    
    private void pushAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pushAttendanceActionPerformed
        try {
            JSONCommunicator.sendJson(JSONCommunicator.TEACHERS_ADDRESS, readFile(TeachersForm.TEACHERS_FILE_NAME));
        }
        catch (ConnectException e) {
           JOptionPane.showMessageDialog(rootPane, e.getMessage() + " Could not send teachers list.");
        }
        catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(rootPane, "Internal error. Could not send teachers list.");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Requests list not found.");
        }
        
        try {
            JSONCommunicator.sendJson(JSONCommunicator.ATTENDANCE_ADDRESS, readFile(AttendanceForm.PUPILS_FILE_NAME));
        }
        catch (ConnectException e) {
           JOptionPane.showMessageDialog(rootPane, e.getMessage() + " Could not send attendance list.");
        }
        catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(rootPane, "Internal error. Could not send attendance list.");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Attendance file not found.");
        }
        
    }//GEN-LAST:event_pushAttendanceActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new NotificationForm().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pushResourcesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pushResourcesButtonActionPerformed
        try {
            JSONCommunicator.sendJson(JSONCommunicator.REQUEST_ADDRESS, readFile(ResourcesForm.REQUESTS_FILE_NAME));
        }
        catch (ConnectException e) {
           JOptionPane.showMessageDialog(rootPane, e.getMessage() + " Could not send requests list.");
        }
        catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(rootPane, "Internal error. Could not send requests list.");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Requests file not found");
        }
    }//GEN-LAST:event_pushResourcesButtonActionPerformed

    private void pushTeachersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pushTeachersButtonActionPerformed
        try {
            JSONCommunicator.sendJson(JSONCommunicator.TEACHERS_ADDRESS, readFile(TeachersForm.TEACHERS_FILE_NAME));
        }
        catch (ConnectException e) {
           JOptionPane.showMessageDialog(rootPane, e.getMessage() + " Could not send teachers list.");
        }
        catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(rootPane, "Internal error. Could not send teachers list.");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Requests list not found.");
        }
    }//GEN-LAST:event_pushTeachersButtonActionPerformed

    
    private void fetchNotificationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fetchNotificationsButtonActionPerformed
        try {
            String notificationsJSON = JSONCommunicator.requestJson(JSONCommunicator.NOTIFICATIONS_ADDRESS);
            writeFile(NotificationForm.NOTIFICATIONS_FILE_NAME, notificationsJSON);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Internal error. Could not access notifications.");
        } catch (ConnectException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " Could not get notifications.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Could not write to notifications file.");
        }
    }//GEN-LAST:event_fetchNotificationsButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fetchNotificationsButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton pushAttendance;
    private javax.swing.JButton pushResourcesButton;
    private javax.swing.JButton pushTeachersButton;
    // End of variables declaration//GEN-END:variables
}
