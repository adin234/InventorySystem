
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author intel
 */
public class SignupAs3position extends javax.swing.JFrame {
    static Connection connection;
    static String url;
    static Statement st;
    static ResultSet rs;
    String dbtbl;
    //static Connection connection;
    //static String url;
    static Statement st1;
    static Statement st2;
    static ResultSet rs22;
    int count = 0;
    Connection Conn = null;
    //ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs4 = null;
    PreparedStatement pst5 = null;
    PreparedStatement pst4 = null;
    PreparedStatement pst3 = null;
    PreparedStatement pst2 = null;
    PreparedStatement pst1 = null;
    PreparedStatement pst = null;
    //PreparedStatement st = null;
    private ImageIcon format = null;
    String id = "";
    
    public int search(String id, String name) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        url = "jdbc:mysql://localhost:3306/pos";
        connection = DriverManager.getConnection(url, "root", "");
        st = connection.createStatement();
        st2 = connection.createStatement();
        rs = st.executeQuery("Select * From admin Where adminID= '" + id + "'  " + "and fname = '" + name + "'");
        if (rs != null)
            return 1;
        else
            return 0;
    }
    
    public static class javaconnect{
        Connection Conn = null;
        
        public static Connection ConnecrDB(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
                return Conn;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "error");
            }
            return null;
        }
    }
    
        public SignupAs3position(){
        initComponents();
        Conn = SignupAs3position.javaconnect.ConnecrDB(); 
        getId();
    }
    
    private void getId(){
    String sum;
    try{
        String sql = "SELECT max(adminID) FROM admin";
        pst = Conn.prepareStatement(sql);
        rs= pst.executeQuery();
        while(rs.next()){
            sum = rs.getString("max(adminID)");
            int identification = Integer.parseInt(sum)+1;
            userId.setText(Integer.toString(identification));
        }
    }
    catch (Exception e){
        int identification = Integer.parseInt(userId.getText())+1;
        userId.setText(Integer.toString(identification));
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        namelbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        userId = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        userPassword2 = new javax.swing.JPasswordField();
        userPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        comboPosition = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setBackground(new java.awt.Color(0, 102, 255));

        namelbl.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        namelbl.setForeground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.add(namelbl);
        namelbl.setBounds(170, 10, 220, 0);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setText("Id:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(230, 370, 20, 23);

        userId.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        userId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userId.setEnabled(false);
        jPanel1.add(userId);
        userId.setBounds(400, 370, 170, 23);

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel14.setText("Username:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(230, 400, 82, 23);

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel16.setText("Password:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(230, 430, 77, 23);

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel17.setText("Re-enter Password:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(230, 460, 146, 23);

        userName.setText(" ");
        jPanel1.add(userName);
        userName.setBounds(400, 400, 170, 20);
        jPanel1.add(userPassword2);
        userPassword2.setBounds(400, 460, 170, 20);
        jPanel1.add(userPassword);
        userPassword.setBounds(400, 430, 170, 20);

        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(410, 560, 170, 25);

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel18.setText("Position:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(230, 490, 66, 23);

        comboPosition.setBackground(new java.awt.Color(204, 255, 204));
        comboPosition.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        comboPosition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "SalesPerson", "WarehouseManager" }));
        comboPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPositionActionPerformed(evt);
            }
        });
        jPanel1.add(comboPosition);
        comboPosition.setBounds(400, 490, 170, 23);

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(210, 10, 350, 360);

        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(210, 560, 170, 25);

        jDesktopPane1.add(jPanel1);
        jPanel1.setBounds(40, 40, 760, 600);

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 700));

        setSize(new java.awt.Dimension(842, 680));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
      
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(comboPosition.getSelectedItem().equals("Admin")){
            int check = 0;
            try{
                check = search(userName.getText(), userName.getText());
            }
            catch (SQLException ex) {/*Logger.getLogger(trial.class.getName()).log(Level.SEVERE, null, ex);*/}
            catch (ClassNotFoundException ex) {/*Logger.getLogger(trial.class.getName()).log(Level.SEVERE, null, ex);*/}

            if (check == 1){
                try{
                    if (userPassword.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Password must contain value", "System Message", JOptionPane.INFORMATION_MESSAGE);
                        userName.setText(null);
                        //userAge.setText(null);
                        userPassword.setText(null);
                    }
                    if ((userName.getText().equals("")))
                        JOptionPane.showMessageDialog(null, "Username is Required", "System Message", JOptionPane.ERROR_MESSAGE);

                    else if(!(userPassword.getText().equals(userPassword2.getText()))){
                        JOptionPane.showMessageDialog(null, "Password not matched", "Systemwatch Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        st.executeUpdate("Insert into admin(" + "adminID, fname," + "Password" + "userPosition" + ") VALUES ('" + userId.getText() + "','" + userName.getText() + "','" + userPassword.getText() + "','"+comboPosition.getSelectedItem()+"')");
                        //st2.executeUpdate("Insert into history(" + "Id,username," + "date" + ") VALUES ('" + userId.getText() + "','" + userName.getText() + "','" + userName.getText() + "')");
                        JOptionPane.showMessageDialog(null, "Account Created", "System Message", JOptionPane.INFORMATION_MESSAGE);
                        CustomerAcc.namelbl.setText(userName.getText());
                        //st.executeUpdate("Insert into history(" + "Id,username," + "date" + ") VALUES ('" + userId.getText() + "','" + userName.getText() + "','" + userName.getText() + "')");
                    }   
                }
                catch (SQLException ex){
                    //Logger.getLogger(trial.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Record Already Exist", "System Message", JOptionPane.ERROR_MESSAGE);
                    userName.setText(null);
                    //userAge.setText(null);
                    userPassword.setText(null);
                }
            }
        }
        
        
        else if(comboPosition.getSelectedItem().equals("SalesPerson"))
        {
            int check = 0;
            try{
                check = search(userName.getText(), userName.getText());
            }
            catch (SQLException ex) {/*Logger.getLogger(trial.class.getName()).log(Level.SEVERE, null, ex);*/}
            catch (ClassNotFoundException ex) {/*Logger.getLogger(trial.class.getName()).log(Level.SEVERE, null, ex);*/}

            if (check == 1){
                try{
                    if (userPassword.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Password must contain value", "System Message", JOptionPane.INFORMATION_MESSAGE);
                        userName.setText(null);
                        //userAge.setText(null);
                        userPassword.setText(null);
                    }
                    if ((userName.getText().equals("")))
                        JOptionPane.showMessageDialog(null, "Username is Required", "System Message", JOptionPane.ERROR_MESSAGE);

                    else if(!(userPassword.getText().equals(userPassword2.getText()))){
                        JOptionPane.showMessageDialog(null, "Password not matched", "Systemwatch Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        st.executeUpdate("Insert into admin(" + "adminID, fname," + "Password" + "userPosition" + ") VALUES ('" + userId.getText() + "','" + userName.getText() + "','" + userPassword.getText() + "','"+comboPosition.getSelectedItem()+"')");
                        //st2.executeUpdate("Insert into history(" + "Id,username," + "date" + ") VALUES ('" + userId.getText() + "','" + userName.getText() + "','" + userName.getText() + "')");
                        JOptionPane.showMessageDialog(null, "Account Created", "System Message", JOptionPane.INFORMATION_MESSAGE);
                        CustomerAcc.namelbl.setText(userName.getText());
                        //st.executeUpdate("Insert into history(" + "Id,username," + "date" + ") VALUES ('" + userId.getText() + "','" + userName.getText() + "','" + userName.getText() + "')");
                    }   
                }
                catch (SQLException ex){
                    //Logger.getLogger(trial.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Record Already Exist", "System Message", JOptionPane.ERROR_MESSAGE);
                    userId.setText(null);
                    userName.setText(null);
                    //userAge.setText(null);
                    userPassword.setText(null);
                }
            }
        }
        
        else if(comboPosition.getSelectedItem().equals("WarehouseManager"))
        {
            int check = 0;
            try{
                check = search(userName.getText(), userName.getText());
            }
            catch (SQLException ex) {/*Logger.getLogger(trial.class.getName()).log(Level.SEVERE, null, ex);*/}
            catch (ClassNotFoundException ex) {/*Logger.getLogger(trial.class.getName()).log(Level.SEVERE, null, ex);*/}

            if (check == 1){
                try{
                    if (userPassword.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Password must contain value", "System Message", JOptionPane.INFORMATION_MESSAGE);
                        userName.setText(null);
                        //userAge.setText(null);
                        userPassword.setText(null);
                    }
                    if ((userName.getText().equals("")))
                        JOptionPane.showMessageDialog(null, "Username is Required", "System Message", JOptionPane.ERROR_MESSAGE);

                    else if(!(userPassword.getText().equals(userPassword2.getText()))){
                        JOptionPane.showMessageDialog(null, "Password not matched", "Systemwatch Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        st.executeUpdate("Insert into admin(" + "adminID, fname," + "Password" + "userPosition" + ") VALUES ('" + userId.getText() + "','" + userName.getText() + "','" + userPassword.getText() + "','"+comboPosition.getSelectedItem()+"')");
                        //st2.executeUpdate("Insert into history(" + "Id,username," + "date" + ") VALUES ('" + userId.getText() + "','" + userName.getText() + "','" + userName.getText() + "')");
                        JOptionPane.showMessageDialog(null, "Account Created", "System Message", JOptionPane.INFORMATION_MESSAGE);
                        CustomerAcc.namelbl.setText(userName.getText());
                        //st.executeUpdate("Insert into history(" + "Id,username," + "date" + ") VALUES ('" + userId.getText() + "','" + userName.getText() + "','" + userName.getText() + "')");
                    }   
                }
                catch (SQLException ex){
                    //Logger.getLogger(trial.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Record Already Exist", "System Message", JOptionPane.ERROR_MESSAGE);
                    userId.setText(null);
                    userName.setText(null);
                    //userAge.setText(null);
                    userPassword.setText(null);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPositionActionPerformed

    }//GEN-LAST:event_comboPositionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LoginLogin pag = new LoginLogin();
        pag.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SignupAs3position.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupAs3position.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupAs3position.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupAs3position.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new SignupAs3position().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboPosition;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel namelbl;
    public javax.swing.JTextField userId;
    private javax.swing.JTextField userName;
    private javax.swing.JPasswordField userPassword;
    private javax.swing.JPasswordField userPassword2;
    // End of variables declaration//GEN-END:variables
}