/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Out:
Attendance
Curriculum
Requests
Teachers
Inventory

In:
Notifications
Request status
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
public final class NotificationForm extends javax.swing.JFrame {

    class Notification {
        final String subject;
        final String sender;
        final String body;
        final String date;

        public Notification(String subject, String sender, String body, String date) {
            this.subject = subject;
            this.sender = sender;
            this.body = body;
            this.date = date;
        }
        
        public String getSubject() {
            return this.subject;
        }

        public String getSender() {
            return this.sender;
        }

        public String getBody() {
            return this.body;
        }
        
        public String getDate() {
            return this.date;
        }
    }
    
    private class NotificationsTableModel extends SchoolData<Notification> implements TableModel {
        
        private ArrayList<TableModelListener> tableModelListeners;
        //private ArrayList<InventoryItem> inventory;
        private static final String SENDER_COLUMN_TITLE = "Sender";
        private static final String SUBJECT_COLUMN_TITLE = "Subject";
        private static final String DATE_COLUMN_TITLE = "Date";
        private static final int SENDER_COLUMN_INDEX = 0;
        private static final int SUBJECT_COLUMN_INDEX = 1;
        private static final int DATE_COLUMN_INDEX = 2;
        private static final int COLUMN_COUNT = 3;
        private static final String REQUESTS_FILE_NAME = "notifications";
        

        public NotificationsTableModel() {
            super(REQUESTS_FILE_NAME, new TypeToken<ArrayList<ResourcesForm.RequestsItem>>(){}.getType());
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
            if (columnIndex == SENDER_COLUMN_INDEX) return SENDER_COLUMN_TITLE;
            else if (columnIndex == SUBJECT_COLUMN_INDEX) return SUBJECT_COLUMN_TITLE;
            else if (columnIndex == DATE_COLUMN_INDEX) return DATE_COLUMN_TITLE;
            else throw new IllegalArgumentException("Column index out of range");
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == SENDER_COLUMN_INDEX || columnIndex == SUBJECT_COLUMN_INDEX || columnIndex == DATE_COLUMN_INDEX) {
                return String.class;
            }
            else {
                throw new IllegalArgumentException("Column index out of range");
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Notification rowItem = getItem(rowIndex);
            if (columnIndex == SENDER_COLUMN_INDEX) {
                return rowItem.getSender();
            }
            else if (columnIndex == SUBJECT_COLUMN_INDEX) {
                return rowItem.getSubject();
            }
            else if (columnIndex == DATE_COLUMN_INDEX) {
                return rowItem.getDate();
            }
            else {
                throw new IllegalArgumentException("Column index out of range");
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            throw new UnsupportedOperationException("Notification table values are read only");
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
            tableModelListeners.add(l);
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
            tableModelListeners.remove(l);
        }
        
        public void addRow(Notification item) {
            addItem(item);
            notificationsTable.revalidate();
        }
        
        public void removeRow(int index) {
            removeItem(index);
            notificationsTable.revalidate();
        }
        
        public String getMessage(int index) {
            return getItem(index).getBody();
        }
        
    }
    
    NotificationsTableModel notificationsTableModel;
    
    /**
     * Creates new form MessagingForm
     */
    public NotificationForm() {
        super();
        initComponents();
        notificationsTableModel = new NotificationsTableModel();
        notificationsTable.setModel(notificationsTableModel);
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
        messageTextArea = new javax.swing.JTextArea();
        senderLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notificationsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        jScrollPane1.setViewportView(messageTextArea);

        senderLabel.setText("Sender");

        notificationsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        notificationsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(notificationsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(senderLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void notificationsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationsTableMouseClicked
        int selectedRow = notificationsTable.getSelectedRow();
        if (selectedRow >= 0) {
            messageTextArea.setText(notificationsTableModel.getMessage(selectedRow));
        }
    }//GEN-LAST:event_notificationsTableMouseClicked

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
            java.util.logging.Logger.getLogger(NotificationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotificationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotificationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotificationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotificationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JTable notificationsTable;
    private javax.swing.JLabel senderLabel;
    // End of variables declaration//GEN-END:variables
}
