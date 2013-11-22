/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package education4sudanschoolclient;

import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Hugh
 */
public class TeachersForm extends javax.swing.JFrame {

    public static final String TEACHERS_FILE_NAME = "teachers";
    
    private class TeachersTableModel extends SchoolData<Teacher> implements TableModel {
        
        private ArrayList<TableModelListener> tableModelListeners;
        //private ArrayList<InventoryItem> inventory;
        private static final String NAME_COLUMN_TITLE = "Name";
        private static final String ROLE_COLUMN_TITLE = "Role";
        private static final String GRADES_COLUMN_TITLE = "Grade Taught";
        public static final int NAME_COLUMN_INDEX = 0;
        public static final int ROLE_COLUMN_INDEX = 1;
        public static final int GRADES_COLUMN_INDEX = 2;
        public static final int COLUMN_COUNT = 3;
        private static final String REQUESTS_FILE_NAME = "teachers";
        

        public TeachersTableModel() {
            super(TEACHERS_FILE_NAME, new TypeToken<ArrayList<Teacher>>(){}.getType());
            tableModelListeners = new ArrayList<>();
        }
        
        @Override
        public int getRowCount() {
            return getSize();
        }

        @Override
        public int getColumnCount() {
            return COLUMN_COUNT;
        }

        @Override
        public String getColumnName(int columnIndex) {
            if (columnIndex == NAME_COLUMN_INDEX) return NAME_COLUMN_TITLE;
            else if (columnIndex == ROLE_COLUMN_INDEX) return ROLE_COLUMN_TITLE;
            else if (columnIndex == GRADES_COLUMN_INDEX) return GRADES_COLUMN_TITLE;
            else throw new IllegalArgumentException("Column index out of range");
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == NAME_COLUMN_INDEX || columnIndex == ROLE_COLUMN_INDEX || columnIndex == GRADES_COLUMN_INDEX) {
                return String.class;
            }
            else {
                throw new IllegalArgumentException("Column index out of range");
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Teacher rowItem = getItem(rowIndex);
            if (columnIndex == NAME_COLUMN_INDEX) {
                return rowItem.getName();
            }
            else if (columnIndex == ROLE_COLUMN_INDEX) {
                return rowItem.getRole();
            }
            else if (columnIndex == GRADES_COLUMN_INDEX) {
                return rowItem.getGradesTaught();
            }
            else {
                throw new IllegalArgumentException("Column index out of range");
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Teacher rowItem = getItem(rowIndex);
            if (columnIndex == NAME_COLUMN_INDEX) {
                rowItem.setName((String) aValue);
            }
            else if (columnIndex == ROLE_COLUMN_INDEX) {
                rowItem.setRole((String) aValue);
            }
            else if (columnIndex == GRADES_COLUMN_INDEX) {
                String newValue = (String) aValue;
                //if (newValue.matches("(\\d|,)*")) {
                    rowItem.setGradesTaught(newValue);// + ",");
                //}
                
            }
            else {
                throw new IllegalArgumentException("Column index out of range");
            }
            setItem(rowIndex, rowItem);
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
            tableModelListeners.add(l);
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
            tableModelListeners.remove(l);
        }
        
        public void addRow(Teacher item) {
            addItem(item);
            teachersTable.revalidate();
        }
        
        public void removeRow(int index) {
            removeItem(index);
            teachersTable.revalidate();
        }
        
    }
    
    public static class Teacher {
        private String name;
        private String role;
        private String gradesTaught;
        
        public String getName() {
            return this.name;
        }
        
        public String getRole() {
            return this.role;
        }
        
        public String getGradesTaught() {
            return this.gradesTaught;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public void setRole(String role) {
            this.role = role;
        }
        
        public void setGradesTaught(String gradesTaught) {
            this.gradesTaught = gradesTaught;
        }
    }
    
    TeachersTableModel teachersTableModel;
    
    /**
     * Creates new form TeachersForm
     */
    public TeachersForm() {
        initComponents();
        teachersTableModel = new TeachersTableModel();
        teachersTable.setModel(teachersTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        teachersTable = new javax.swing.JTable();
        addTeacherButton = new javax.swing.JButton();
        removeTeacherButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        teachersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(teachersTable);

        addTeacherButton.setText("Add Teacher");
        addTeacherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeacherButtonActionPerformed(evt);
            }
        });

        removeTeacherButton.setText("Remove Teacher");
        removeTeacherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTeacherButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addTeacherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeTeacherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addTeacherButton, removeTeacherButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTeacherButton)
                    .addComponent(removeTeacherButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeTeacherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTeacherButtonActionPerformed
        int selectedRow = teachersTable.getSelectedRow();
        if (selectedRow >= 0) {
            teachersTableModel.removeRow(selectedRow);
        }
    }//GEN-LAST:event_removeTeacherButtonActionPerformed

    private void addTeacherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeacherButtonActionPerformed
        teachersTableModel.addRow(new Teacher());
    }//GEN-LAST:event_addTeacherButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TeachersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeachersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeachersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeachersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeachersForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTeacherButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeTeacherButton;
    private javax.swing.JTable teachersTable;
    // End of variables declaration//GEN-END:variables
}
