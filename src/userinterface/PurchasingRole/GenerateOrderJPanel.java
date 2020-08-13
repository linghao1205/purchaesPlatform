/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PurchasingRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.SupplierEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.SalesDepartment;
import Business.Organization.Warehouse;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ProductionTestWorkRequest;
import Business.WorkQueue.PurchasingWorkRequest;
import Business.WorkQueue.Storage;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author linghaodu
 */
public class GenerateOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form GenerateOrderJPanel
     */
    private JPanel container;
    private ProductionTestWorkRequest request;
    private Network network;
    private int minQuantity;
    private UserAccount account;
    private Enterprise enterprise;
    private String oldSupplierName;
    
    public GenerateOrderJPanel(JPanel container, ProductionTestWorkRequest request, Network network, UserAccount account,Enterprise enterprise) {
        initComponents();
        this.container = container;
        this.request = request;
        this.network = network;
        this.account = account;
        this.enterprise=enterprise;
        minQuantity = request.getQuantity();
        
        populateSupplier();
        productModelTxt.setText(request.getMaterial().getProductionModel());
        quantityTxt.setText(String.valueOf(request.getQuantity()));
    }
    
    public GenerateOrderJPanel(JPanel container, ProductionTestWorkRequest request, Network network, UserAccount account,Enterprise enterprise, String oldSupplierName) {
        initComponents();
        this.container = container;
        this.request = request;
        this.network = network;
        this.account = account;
        this.enterprise=enterprise;
        this.oldSupplierName = oldSupplierName;
        minQuantity = request.getQuantity();
        
        populateSupplier();
        productModelTxt.setText(request.getMaterial().getProductionModel());
        quantityTxt.setText(String.valueOf(request.getQuantity()));
    }
    
    private void populateSupplier(){
        DefaultTableModel model = (DefaultTableModel)supplierTbl.getModel();
        
        model.setRowCount(0);
        for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
            if (e.getEnterpriseType().getValue().equals("Supplier")){
                for (Organization g : e.getOrganizationDirectory().getOrganizationList()){
                    if (g instanceof Warehouse){
                        for (Storage s : ((Warehouse) g).getInventory()){
                            if (request.getMaterial().getProductionModel().equals(s.getMaterial().getProductionModel())){
                                Object[] row = new Object[3];
                                row[0] = e;
                                row[1] = s.getMaterial().getProductionModel();
                                row[2] = s.getMaterial().getUnitPrice();
                                model.addRow(row);
                                break;
                            }
                        }
                        break;
                    }
                }                
            }
        }
        
        RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);  
        supplierTbl.setRowSorter(sorter); 
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
        supplierTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productModelTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        supplierTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        priseTxt = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));

        supplierTbl.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N
        supplierTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Supplier Name", "Product Model", "Unit Prise"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        supplierTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(supplierTbl);
        if (supplierTbl.getColumnModel().getColumnCount() > 0) {
            supplierTbl.getColumnModel().getColumn(0).setResizable(false);
            supplierTbl.getColumnModel().getColumn(1).setResizable(false);
            supplierTbl.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N
        jLabel1.setText("Supplier LIst");

        jLabel2.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N
        jLabel2.setText("Product Model:");

        productModelTxt.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N
        productModelTxt.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N
        jLabel3.setText("Quantity:");

        quantityTxt.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N
        jLabel4.setText("Supplier:");

        supplierTxt.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N
        supplierTxt.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N
        jLabel5.setText("Unit Prise:");

        priseTxt.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N
        priseTxt.setEnabled(false);

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        confirmBtn.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N
        confirmBtn.setText("Confirm");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(confirmBtn)
                .addGap(420, 420, 420))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(productModelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(supplierTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(priseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn)))
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(403, 403, 403))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(productModelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(priseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(confirmBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PurchasingWorkPlaceJPanel panel = (PurchasingWorkPlaceJPanel) component;
        panel.populateRequest();
        panel.populateOrder();

        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed

    private void supplierTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierTblMouseClicked
        // TODO add your handling code here:
        int selectedRow = supplierTbl.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        Enterprise enterprise = (SupplierEnterprise)supplierTbl.getValueAt(selectedRow, 0);
        int prise = (int)supplierTbl.getValueAt(selectedRow, 2);
        
        supplierTxt.setText(enterprise.getName());
        priseTxt.setText(String.valueOf(prise));
    }//GEN-LAST:event_supplierTblMouseClicked

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = supplierTbl.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        int quantity = Integer.parseInt(quantityTxt.getText());
        if (quantity < minQuantity){
            JOptionPane.showMessageDialog(null, "Order quantity must larger than " + minQuantity);
            return;
        }
        
        Enterprise enterprise1 = (SupplierEnterprise)supplierTbl.getValueAt(selectedRow, 0);
        int prise = (int)supplierTbl.getValueAt(selectedRow, 2);
        if (enterprise1.getName().equals(oldSupplierName)){
            JOptionPane.showMessageDialog(null, "You can not send this order to supplier how canceled it");
            return;
        }
        
        PurchasingWorkRequest newrequest = new PurchasingWorkRequest();
        newrequest.setDeliveryNumber(request.getDeliveryNumber());
        newrequest.setCompanyName(enterprise.getName());
        newrequest.setMaterial(request.getMaterial());
        newrequest.setSupplierName(enterprise1.getName());
        newrequest.setOrderStatus("Waiting");
        newrequest.setQuantity(quantity);
        newrequest.getMaterial().setUnitPrice(prise);
        
        //update request status
        request.setStatus("Processing");
         
         //add request to work queue
        Organization org = null;
        for (Organization o : enterprise1.getOrganizationDirectory().getOrganizationList()){
            if (o instanceof SalesDepartment){
                org = o;
                break;
            }
        }
         
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(newrequest);
            account.getWorkQueue().getWorkRequestList().add(newrequest);
            JOptionPane.showMessageDialog(null, "Order Create Successful!");
        }
        
    }//GEN-LAST:event_confirmBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField priseTxt;
    private javax.swing.JTextField productModelTxt;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JTable supplierTbl;
    private javax.swing.JTextField supplierTxt;
    // End of variables declaration//GEN-END:variables
}
