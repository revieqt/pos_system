package cashier;

import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reciept.*;

public class cashier_checkout extends javax.swing.JFrame {
    static DefaultTableModel dummymodel;
    static String dummytotal;
    public DefaultTableModel mdl;
    public String sub;
    public double vat;
    public boolean applyDiscount = false;
    public double dis;
    public double grandtotal;
    public double payment;
    public double change;
    
    public cashier_checkout(DefaultTableModel model, String total) {
        initComponents();
        this.mdl = model;
        this.sub = total;
        setCheckout(mdl,sub);
    }
    
    public void updateQuantity(DefaultTableModel model){
        dbConnector connect = new dbConnector();
        for (int i = 0; i < model.getRowCount(); i++) {
            String query =  "UPDATE products SET p_qty = p_qty - "+ model.getValueAt(i, 3)+" WHERE p_barcode = '"+ model.getValueAt(i, 0)+"'";
            connect.updateData(query);
        }
}

    public void setCheckout(DefaultTableModel model, String total){
        dbConnector connect = new dbConnector();
        this.vat = Double.parseDouble(this.sub) * 0.12;
        this.sub = String.format("%.2f", (Double.parseDouble(this.sub) - this.vat));
        subtotal_disp.setText(this.sub);
        vat_disp.setText(String.format("%.2f", this.vat));
        try {
            transactionid_disp.setText(String.valueOf(connect.getLastId("t_id", "transactions")));
        } catch (SQLException ex) {
            System.out.println("Invalid");
        }
        if(!applyDiscount){
            discount_disp.setText("- 0.00");
        }
        this.grandtotal = Double.parseDouble(this.sub) + this.vat + this.dis;
        grandtotal_disp.setText(String.format("%.2f", this.grandtotal));
        
    }
    
    public void displayChange(){
        if(this.change <= -1){
            change_disp.setForeground(new Color(255,0,0));
        }else{
            change_disp.setForeground(new Color(255,255,255));
        }
        change_disp.setText(String.format("%.2f", this.change));
    }
    
    public void checkout(DefaultTableModel model){
        dbConnector connect = new dbConnector();
        Session sess = Session.getInstance();
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        try {
            String query = "INSERT INTO transactions (t_staff, t_customer, t_total, t_datetime) VALUES ("+sess.getId() +", 3001, "+grandtotal+", '"+currentDateTime+"')";
            connect.insertData(query);
        } catch (SQLException ex) {
            System.out.println("Error inserting data: " + ex.getMessage());
        }
        
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                String itemQuery = "INSERT INTO transactions_items (ti_transaction, ti_barcode, ti_name, ti_price, ti_qty, ti_subtotal) "
                    + "VALUES ("+transactionid_disp.getText()+", '"+model.getValueAt(i, 0)+"', '"+model.getValueAt(i, 1)+"', "+model.getValueAt(i, 2)+","+model.getValueAt(i, 3)+","+model.getValueAt(i, 4)+")";                int rowsInserted = connect.insertData(itemQuery);
                connect.insertData(itemQuery);
            } catch (SQLException ex) {
                System.out.println("Error inserting data: " + ex.getMessage());
            }
    }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new enhance.RoundBorder_w();
        grandtotal_disp = new javax.swing.JLabel();
        vat_disp = new javax.swing.JLabel();
        discount_disp = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        subtotal_disp = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        cash = new enhance.CustomTF();
        proceed = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new enhance.RoundBorder_g();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new enhance.RoundPanel_lb();
        jLabel4 = new javax.swing.JLabel();
        change_disp = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        transactionid_disp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(80, 114, 123));
        jPanel1.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(80, 114, 123));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grandtotal_disp.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        grandtotal_disp.setForeground(new java.awt.Color(255, 255, 255));
        grandtotal_disp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        grandtotal_disp.setText("00.00");
        jPanel4.add(grandtotal_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 180, 60));

        vat_disp.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        vat_disp.setForeground(new java.awt.Color(255, 255, 255));
        vat_disp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel4.add(vat_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 100, 30));

        discount_disp.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        discount_disp.setForeground(new java.awt.Color(255, 255, 255));
        discount_disp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel4.add(discount_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 90, 30));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sub-Total:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        subtotal_disp.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        subtotal_disp.setForeground(new java.awt.Color(255, 255, 255));
        subtotal_disp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel4.add(subtotal_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, 30));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("VAT Tax:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 30));

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Discounts/Coupons:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 30));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 230, 20));

        jPanel1.add(jPanel4);
        jPanel4.setBounds(20, 110, 250, 170);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_back.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 40, 40);

        cash.setBackground(new java.awt.Color(80, 114, 123));
        cash.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        cash.setForeground(new java.awt.Color(255, 255, 255));
        cash.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cashKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cashKeyTyped(evt);
            }
        });
        jPanel1.add(cash);
        cash.setBounds(20, 290, 250, 50);

        proceed.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        proceed.setText("Add Discount");
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });
        jPanel1.add(proceed);
        proceed.setBounds(170, 70, 100, 30);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Checkout");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 20, 160, 40);

        jPanel2.setBackground(new java.awt.Color(80, 114, 123));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Proceed w/o Reciept");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 380, 120, 40);

        jPanel3.setBackground(new java.awt.Color(80, 114, 123));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Print Reciept");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(150, 380, 120, 40);

        change_disp.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        change_disp.setForeground(new java.awt.Color(255, 255, 255));
        change_disp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        change_disp.setText("00.00");
        jPanel1.add(change_disp);
        change_disp.setBounds(180, 350, 90, 19);

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Change:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(20, 350, 90, 19);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(20, 60, 250, 2);

        transactionid_disp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        transactionid_disp.setForeground(new java.awt.Color(255, 255, 255));
        transactionid_disp.setText("#TR-00000001");
        jPanel1.add(transactionid_disp);
        transactionid_disp.setBounds(20, 70, 130, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed
        
    }//GEN-LAST:event_proceedActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        if(cash.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Invalid Action! Please input payment!");
    }else{
            this.payment = Double.parseDouble(cash.getText());
        updateQuantity(mdl);
        ReceiptPrinter print = new ReceiptPrinter(mdl, String.format("%.2f", grandtotal), payment , change);
        print.printReceipt();
        }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void cashKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashKeyTyped
double payment = 0.0;
        try {
            if(cash.getText().length() > 0){
            
            payment = Double.parseDouble(cash.getText());
            
        }
        } catch (NumberFormatException ex) {
            return;
        }
        
        this.change = payment - this.grandtotal;
        displayChange();
    }//GEN-LAST:event_cashKeyTyped

    private void cashKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashKeyPressed
double payment = 0.0;
        try {
            if(cash.getText().length() > 0){
            
            payment = Double.parseDouble(cash.getText());
            
        }
        } catch (NumberFormatException ex) {
            return;
        }
        
        this.change = payment - this.grandtotal;
        displayChange();
    }//GEN-LAST:event_cashKeyPressed

    private void cashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashKeyReleased
double payment = 0.0;
        try {
            if(cash.getText().length() > 0){
            
            payment = Double.parseDouble(cash.getText());
            
        }
        } catch (NumberFormatException ex) {
            return;
        }
        
        this.change = payment - this.grandtotal;
        displayChange();
    }//GEN-LAST:event_cashKeyReleased

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        updateQuantity(mdl);
        checkout(mdl);
    }//GEN-LAST:event_jPanel2MouseClicked

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
            java.util.logging.Logger.getLogger(cashier_checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashier_checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashier_checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashier_checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashier_checkout(dummymodel, dummytotal).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cash;
    private javax.swing.JLabel change_disp;
    private javax.swing.JLabel discount_disp;
    private javax.swing.JLabel grandtotal_disp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton proceed;
    private javax.swing.JLabel subtotal_disp;
    private javax.swing.JLabel transactionid_disp;
    private javax.swing.JLabel vat_disp;
    // End of variables declaration//GEN-END:variables
}