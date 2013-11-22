/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package education4sudanschoolclient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.TableModel;
import sun.misc.IOUtils;

/**
 *
 * @author Hugh
 */
public final class ResourcesForm extends javax.swing.JFrame {
    
    public static final String INVENTORY_FILE_NAME = "inventory";
    public static final String REQUESTS_FILE_NAME = "requests";
    
    private class InventoryTableModel extends SchoolData<InventoryItem> implements TableModel {
        
        private ArrayList<TableModelListener> tableModelListeners;
        //private ArrayList<InventoryItem> inventory;
        private static final String NAME_COLUMN_TITLE = "Name";
        private static final String COUNT_COLUMN_TITLE = "Count";
        private static final int NAME_COLUMN_INDEX = 0;
        private static final int COUNT_COLUMN_INDEX = 1;
        private static final int COLUMN_COUNT = 2;

        public InventoryTableModel() {
            super(INVENTORY_FILE_NAME, new TypeToken<ArrayList<InventoryItem>>(){}.getType());
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
            else if (columnIndex == COUNT_COLUMN_INDEX) return COUNT_COLUMN_TITLE;
            else throw new IllegalArgumentException("Column index out of range");
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == NAME_COLUMN_INDEX) {
                return String.class;
            }
            else if (columnIndex == COUNT_COLUMN_INDEX) {
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
            InventoryItem rowItem = getItem(rowIndex);
            if (columnIndex == NAME_COLUMN_INDEX) {
                return rowItem.getName();
            }
            else if (columnIndex == COUNT_COLUMN_INDEX) {
                return rowItem.getCount();
            }
            else {
                throw new IllegalArgumentException("Column index out of range");
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            InventoryItem item = getItem(rowIndex);
            if (columnIndex == NAME_COLUMN_INDEX) {
                item.setName((String) aValue);
            }
            else if (columnIndex == COUNT_COLUMN_INDEX) {
                item.setCount((int) aValue);
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
            addItem(new InventoryItem());
            // TODO Investigate slowness (removeRow refreshes instantly)
            inventoryTable.revalidate();
            //repaint();
        }
        
        public void removeRow(int index) {
            removeItem(index);
            inventoryTable.revalidate();
            //repaint();
        }
        
    }
    
    private class RequestsTableModel extends SchoolData<RequestsItem> implements TableModel {
        
        private ArrayList<TableModelListener> tableModelListeners;
        //private ArrayList<InventoryItem> inventory;
        private static final String REQUEST_COLUMN_TITLE = "Request";
        private static final String DESCRIPTION_COLUMN_TITLE = "Description";
        private static final String RESPONSE_COLUMN_TITLE = "Response";
        private static final int TITLE_COLUMN_INDEX = 0;
        private static final int DESCRIPTION_COLUMN_INDEX = 1;
        private static final int RESPONSE_COLUMN_INDEX = 2;
        private static final int COLUMN_COUNT = 3;
        

        public RequestsTableModel() {
            super(REQUESTS_FILE_NAME, new TypeToken<ArrayList<RequestsItem>>(){}.getType());
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
            if (columnIndex == TITLE_COLUMN_INDEX) return REQUEST_COLUMN_TITLE;
            else if (columnIndex == DESCRIPTION_COLUMN_INDEX) return DESCRIPTION_COLUMN_TITLE;
            else if (columnIndex == RESPONSE_COLUMN_INDEX) return RESPONSE_COLUMN_TITLE;
            else throw new IllegalArgumentException("Column index out of range");
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == TITLE_COLUMN_INDEX || columnIndex == DESCRIPTION_COLUMN_INDEX || columnIndex == RESPONSE_COLUMN_INDEX) {
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
            RequestsItem rowItem = getItem(rowIndex);
            if (columnIndex == TITLE_COLUMN_INDEX) {
                return rowItem.getTitle();
            }
            else if (columnIndex == DESCRIPTION_COLUMN_INDEX) {
                return rowItem.getDescription();
            }
            else if (columnIndex == RESPONSE_COLUMN_INDEX) {
                return rowItem.getResponse();
            }
            else {
                throw new IllegalArgumentException("Column index out of range");
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            throw new UnsupportedOperationException("Request table values are read only");
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
            tableModelListeners.add(l);
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
            tableModelListeners.remove(l);
        }
        
        public void addRow(RequestsItem item) {
            addItem(item);
            requestsTable.revalidate();
        }
        
        public void removeRow(int index) {
            removeItem(index);
            requestsTable.revalidate();
        }
        
    }
    
    public static class InventoryItem {
        private String name;
        private int count;
        
        public String getName() {
            return this.name;
        }
        
        public int getCount() {
            return this.count;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public void setCount(int count) {
            this.count = count;
        }
        
        public InventoryItem() {
            this.name = "";
            this.count = 0;
        }
        
        public InventoryItem(String resource, int count) {
            this.name = resource;
            this.count = count;
        }
    }
    
    public static class RequestsItem {
        private final String title;
        private final String description;
        private final String response;
        
        public String getTitle() {
            return this.title;
        }
        
        public String getDescription() {
            return this.description;
        }
        
        public String getResponse() {
            return this.response;
        }
        
        public RequestsItem(String request, String description, String response) {
            this.title = request;
            this.description = description;
            this.response = response;
    
        }
    }
    
    InventoryTableModel inventoryTableModel;
    RequestsTableModel requestsTableModel;
    
    /**
     * Creates new form ResourcesForm
     */
    public ResourcesForm() {
        super();
        initComponents();
        inventoryTableModel = new InventoryTableModel();
        inventoryTable.setModel(inventoryTableModel);
        requestsTableModel = new RequestsTableModel();
        requestsTable.setModel(requestsTableModel);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        inventoryLabel = new javax.swing.JLabel();
        resourcesSeparator = new javax.swing.JSeparator();
        requestsLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        requestsTable = new javax.swing.JTable();
        newRequestButton = new javax.swing.JButton();
        addResourceButton = new javax.swing.JButton();
        removeResourceButton = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        inventoryTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Resource", "Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        inventoryTable.setName("inventoryTable"); // NOI18N
        jScrollPane1.setViewportView(inventoryTable);

        inventoryLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        inventoryLabel.setText("Current Inventory");
        inventoryLabel.setName("inventoryLabel"); // NOI18N

        requestsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        requestsLabel.setText("Requests");
        requestsLabel.setName("requestsLabel"); // NOI18N

        requestsTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        requestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Request", "Response"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        requestsTable.setName("requestsTable"); // NOI18N
        jScrollPane3.setViewportView(requestsTable);

        newRequestButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        newRequestButton.setText("New Request");
        newRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRequestButtonActionPerformed(evt);
            }
        });

        addResourceButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addResourceButton.setText("Add Resource");
        addResourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addResourceButtonActionPerformed(evt);
            }
        });

        removeResourceButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        removeResourceButton.setText("Remove Resource");
        removeResourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeResourceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
            .addComponent(resourcesSeparator)
            .addComponent(jScrollPane3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(requestsLabel)
                        .addGap(18, 18, 18)
                        .addComponent(newRequestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inventoryLabel)
                        .addGap(18, 18, 18)
                        .addComponent(addResourceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(removeResourceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inventoryLabel)
                    .addComponent(addResourceButton)
                    .addComponent(removeResourceButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resourcesSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestsLabel)
                    .addComponent(newRequestButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRequestButtonActionPerformed
        RequestsItem newRequest = new NewRequestDialog(this, true).showDialog();
        if (newRequest != null) {
            requestsTableModel.addRow(newRequest);
        }
    }//GEN-LAST:event_newRequestButtonActionPerformed

    private void addResourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addResourceButtonActionPerformed
        inventoryTableModel.addRow();
    }//GEN-LAST:event_addResourceButtonActionPerformed

    private void removeResourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeResourceButtonActionPerformed
        int selectedRow = inventoryTable.getSelectedRow();
        if (selectedRow >= 0) {
            inventoryTableModel.removeRow(inventoryTable.getSelectedRow());
        }
    }//GEN-LAST:event_removeResourceButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ResourcesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResourcesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResourcesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResourcesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ResourcesForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addResourceButton;
    private javax.swing.JLabel inventoryLabel;
    private javax.swing.JTable inventoryTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton newRequestButton;
    private javax.swing.JButton removeResourceButton;
    private javax.swing.JLabel requestsLabel;
    private javax.swing.JTable requestsTable;
    private javax.swing.JSeparator resourcesSeparator;
    // End of variables declaration//GEN-END:variables
}
