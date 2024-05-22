/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashier;

import admin.*;
import static admin.adminMain.checkData;
import static admin.adminMain.getData;
import static admin.admin_staffAdd.getId;
import config.dbConnector;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author w10
 */
public class cashier_profile_changePass extends javax.swing.JFrame {
    
    public int id;
    public String currentPassword;
    
    public cashier_profile_changePass(int adminID,String currentPass) {
        setUndecorated(true);
        initComponents();
        this.id = adminID;
        this.currentPassword = currentPass;
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
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        currentpass = new enhance.CustomTF();
        newpass = new enhance.CustomTF();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        confirmpass = new enhance.CustomTF();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(44, 88, 110));
        jPanel1.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(44, 88, 110));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(44, 88, 110));
        jLabel9.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("New Password");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, -1));

        jPanel1.add(jPanel5);
        jPanel5.setBounds(50, 120, 80, 14);

        jPanel6.setBackground(new java.awt.Color(44, 88, 110));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(44, 88, 110));
        jLabel10.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Current Password");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, -1));

        jPanel1.add(jPanel6);
        jPanel6.setBounds(50, 70, 80, 14);

        currentpass.setBackground(new java.awt.Color(44, 88, 110));
        currentpass.setForeground(new java.awt.Color(255, 255, 204));
        currentpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                currentpassMouseReleased(evt);
            }
        });
        currentpass.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                currentpassPropertyChange(evt);
            }
        });
        jPanel1.add(currentpass);
        currentpass.setBounds(40, 80, 220, 33);

        newpass.setBackground(new java.awt.Color(44, 88, 110));
        newpass.setForeground(new java.awt.Color(255, 255, 204));
        newpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                newpassMouseReleased(evt);
            }
        });
        newpass.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                newpassPropertyChange(evt);
            }
        });
        jPanel1.add(newpass);
        newpass.setBounds(40, 130, 220, 33);

        jPanel7.setBackground(new java.awt.Color(44, 88, 110));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(44, 88, 110));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Confirm Password");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, -1));

        jPanel1.add(jPanel7);
        jPanel7.setBounds(50, 170, 90, 14);

        confirmpass.setBackground(new java.awt.Color(44, 88, 110));
        confirmpass.setForeground(new java.awt.Color(255, 255, 204));
        confirmpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmpassMouseReleased(evt);
            }
        });
        confirmpass.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                confirmpassPropertyChange(evt);
            }
        });
        jPanel1.add(confirmpass);
        confirmpass.setBounds(40, 180, 220, 33);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_edit.png"))); // NOI18N
        jLabel1.setText("Change Password");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 20, 190, 50);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(40, 60, 220, 10);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon-check-35.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(230, 230, 32, 40);

        error.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        error.setForeground(new java.awt.Color(255, 153, 153));
        error.setText(".");
        jPanel1.add(error);
        error.setBounds(40, 330, 190, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void currentpassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentpassMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_currentpassMouseReleased

    private void currentpassPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_currentpassPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_currentpassPropertyChange

    private void newpassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newpassMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_newpassMouseReleased

    private void newpassPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_newpassPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_newpassPropertyChange

    private void confirmpassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmpassMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpassMouseReleased

    private void confirmpassPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_confirmpassPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpassPropertyChange

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
        try{
            boolean proceed = false;
            if(currentpass.getText().isEmpty() ||newpass.getText().isEmpty()||confirmpass.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Fill-out necessary information!");
            }else{
                if(!currentpass.equals(getData("u_password","users","u_id", String.valueOf(this.currentPassword)))){
                    JOptionPane.showMessageDialog(null, "Wrong current password inputted!");
                }else if(!newpass.equals(confirmpass.getText())){
                    JOptionPane.showMessageDialog(null, "Password does not match!");
                }else{
                    proceed = true;
                }
            }
            
            if(proceed){
                String hash = passwordHasher.hashPassword(confirmpass.getText());
                dbConnector connector = new dbConnector();
                String insertQuery = "UPDATE users SET u_password = '"+hash+"' WHERE u_id = '"+id+"'";
                connector.updateData(insertQuery);
            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(""+ex);
        }


//        boolean proceed = false;
//        if(fname.getText().isEmpty()|| lname.getText().isEmpty()|| username.getText().isEmpty()|| pass.getText().isEmpty()){
//            error.setText("*Please fill-out necessary information!");
//        }else{
//            if(checkData("*","users","u_username", username.getText())){
//                if(username.getText().equals(current_username)){
//                    proceed = true;
//                }else{
//                    error.setText("*Username already taken!");
//                }
//            }else if(!(pass.getText().length()==8)){
//                error.setText("*Password must have 8 characters!");
//            }else{
//                proceed = true;
//            }
//        }
//        
//        if(proceed){
//            updateData(id,fname.getText(), lname.getText(), username.getText(), pass.getText(), (String)type.getSelectedItem());
//            JOptionPane.showMessageDialog(null, "Staff Updated Successfully!\nStaff ID: "+id+"\nStaff Code: "+((lname.getText().toLowerCase()) + id)+"");
//            this.dispose();
//        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(cashier_profile_changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashier_profile_changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashier_profile_changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashier_profile_changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashier_profile_changePass(1001,"oha").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField confirmpass;
    private javax.swing.JTextField currentpass;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField newpass;
    // End of variables declaration//GEN-END:variables
}