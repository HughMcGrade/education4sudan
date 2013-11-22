/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package education4sudanschoolclient;

import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Hugh
 */
public final class AttendanceForm extends javax.swing.JFrame {

    public class Pupil {
        private boolean isPresent;
        private String name;
        private String gender;
        private String location;
        private int yearOfBirth;
        
        public boolean getIsPresent() {
            return this.isPresent;
        }
        
        public String getName() {
            return this.name;
        }
        
        public String getGender() {
            return this.gender;
        }
        
        public String getLocation() {
            return this.location;
        }
        
        public int getYearOfBirth() {
            return this.yearOfBirth;
        }
        
        public void setIsPresent(boolean isPresent) {
            this.isPresent = isPresent;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public void setGender(String gender) {
            this.gender = gender;
        }
        
        public void setLocation(String location) {
            this.location = location;
        }
        
        public void setYearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
        }

        public Pupil() {
            this.isPresent = true;
            this.name = "";
            this.gender = "";
            this.location = "";
            this.yearOfBirth = 2000;
        }
        
        
    }
    
    private class AttendanceTableModel extends SchoolData<Pupil> implements TableModel {
        
        private final ArrayList<TableModelListener> tableModelListeners;
        
        private static final String PRESENT_COLUMN_TITLE = "Present";
        private static final String NAME_COLUMN_TITLE = "Name";
        private static final String GENDER_COLUMN_TITLE = "Gender";
        private static final String LOCATION_COLUMN_TITLE = "Location";
        private static final String BIRTH_COLUMN_TITLE = "Year of Birth";
        private static final int PRESENT_COLUMN_INDEX = 0;
        private static final int NAME_COLUMN_INDEX = 1;
        private static final int GENDER_COLUMN_INDEX = 2;
        private static final int LOCATION_COLUMN_INDEX = 3;
        private static final int BIRTH_COLUMN_INDEX = 4;
        private static final int COLUMN_COUNT = 5;
        private static final String PUPILS_FILE_NAME = "pupils";

        public AttendanceTableModel() {
            super(PUPILS_FILE_NAME, new TypeToken<ArrayList<Pupil>>(){}.getType());
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
            if (columnIndex == PRESENT_COLUMN_INDEX) return PRESENT_COLUMN_TITLE;
            else if (columnIndex == NAME_COLUMN_INDEX) return NAME_COLUMN_TITLE;
            else if (columnIndex == GENDER_COLUMN_INDEX) return GENDER_COLUMN_TITLE;
            else if (columnIndex == LOCATION_COLUMN_INDEX) return LOCATION_COLUMN_TITLE;
            else if (columnIndex == BIRTH_COLUMN_INDEX) return BIRTH_COLUMN_TITLE;
            else throw new IllegalArgumentException("Column index out of range");
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == PRESENT_COLUMN_INDEX) {
                return Boolean.class;
            }
            if (columnIndex == NAME_COLUMN_INDEX) {
                return String.class;
            }
            else if (columnIndex == GENDER_COLUMN_INDEX) {
                return String.class;
            }
            else if (columnIndex == LOCATION_COLUMN_INDEX) {
                return String.class;
            }
            else if (columnIndex == BIRTH_COLUMN_INDEX) {
                return Integer.class;
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
            Pupil rowItem = getItem(rowIndex);
            if (columnIndex == PRESENT_COLUMN_INDEX) {
                return rowItem.getIsPresent();
            }
            else if (columnIndex == NAME_COLUMN_INDEX) {
                return rowItem.getName();
            }
            else if (columnIndex == GENDER_COLUMN_INDEX) {
                return rowItem.getGender();
            }
            else if (columnIndex == LOCATION_COLUMN_INDEX) {
                return rowItem.getLocation();
            }
            else if (columnIndex == BIRTH_COLUMN_INDEX) {
                return rowItem.getYearOfBirth();
            }
            else {
                throw new IllegalArgumentException("Column index out of range");
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Pupil item = getItem(rowIndex);
            if (columnIndex == PRESENT_COLUMN_INDEX) {
                item.setIsPresent((boolean) aValue);
            }
            else if (columnIndex == NAME_COLUMN_INDEX) {
                item.setName((String) aValue);
            }
            else if (columnIndex == GENDER_COLUMN_INDEX) {
                item.setGender((String) aValue);
            }
            else if (columnIndex == LOCATION_COLUMN_INDEX) {
                item.setLocation((String) aValue);
            }
            else if (columnIndex == BIRTH_COLUMN_INDEX) {
                item.setYearOfBirth((int) aValue);
            }
            else {
                throw new IllegalArgumentException("Column index out of editable range");
            }
            setItem(rowIndex, item);
            
            for (TableModelListener listener : tableModelListeners) {
                listener.tableChanged(new TableModelEvent(this, rowIndex, rowIndex, columnIndex));
            }
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
            tableModelListeners.add(l);
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
            tableModelListeners.remove(l);
        }
        
        public void addRow() {
            addItem(new Pupil());
            // TODO Investigate slowness (removeRow refreshes instantly)
            attendanceTable.revalidate();
            //repaint();
        }
        
        public void removeRow(int index) {
            removeItem(index);
            attendanceTable.revalidate();
            //repaint();
        }
        
    }
    
    final AttendanceTableModel attendanceTableModel;
    
    /**
     * Creates new form AttendanceForm
     */
    public AttendanceForm() {
        super();
        initComponents();
        attendanceTableModel = new AttendanceTableModel();
        attendanceTable.setModel(attendanceTableModel);
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
        attendanceTable = new javax.swing.JTable();
        addStudentButton = new javax.swing.JButton();
        removeStudentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        attendanceTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Present", "Name", "Gender", "Location", "Year of Birth"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        attendanceTable.setGridColor(new java.awt.Color(0, 0, 0));
        attendanceTable.setName("attendanceTable"); // NOI18N
        jScrollPane1.setViewportView(attendanceTable);

        addStudentButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addStudentButton.setText("Add Student");
        addStudentButton.setName("addStudentButton"); // NOI18N
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        removeStudentButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        removeStudentButton.setText("Remove Student");
        removeStudentButton.setName("removeStudentButton"); // NOI18N
        removeStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStudentButton)
                    .addComponent(removeStudentButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
        attendanceTableModel.addRow();
    }//GEN-LAST:event_addStudentButtonActionPerformed

    private void removeStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeStudentButtonActionPerformed
        int selectedRow = attendanceTable.getSelectedRow();
        if (selectedRow >= 0) {
            attendanceTableModel.removeRow(selectedRow);
        }
    }//GEN-LAST:event_removeStudentButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AttendanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudentButton;
    private javax.swing.JTable attendanceTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeStudentButton;
    // End of variables declaration//GEN-END:variables
}
