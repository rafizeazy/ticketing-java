/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package praktikum9;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class menuFeedback extends javax.swing.JPanel {

    public final void loadData() {
    String SUrl = "jdbc:MySQL://localhost:3306/java_db";
    String SUser = "root";
    String SPass = "";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
        Statement st = con.createStatement();
        DefaultTableModel model = new DefaultTableModel(new String[]{"No", "Kritik", "Saran"}, 0);
        tblkr.setModel(model);
        String sql = "SELECT * FROM feedback";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String Masukan = rs.getString("masukan");
            String Kritik = rs.getString("kritik");
            model.addRow(new Object[]{id, Masukan, Kritik});
        }
        con.close();
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

    /**
     * Creates new form menuMatkul1
     */
    public menuFeedback() {
        initComponents();
        loadData();
    
    // Menambahkan Mouse Listener ke tabel
    tblkr.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent evt) {
            int row = tblkr.getSelectedRow();
            if (row != -1) {
                showDetails(row);
            }
        }   
    });
    }
    
    private void showDetails(int row) {
    DefaultTableModel model = (DefaultTableModel) tblkr.getModel();
    String id = model.getValueAt(row, 0).toString();
    String Komen = model.getValueAt(row, 1).toString();
    String Masukan = model.getValueAt(row, 2).toString();
    
    String message = "No : " + id + "\n"
                   + "Kritik : " + Komen + "\n"
                   + "Saran : " + Masukan;
    
    JOptionPane.showMessageDialog(this, message, "Detail Feedback", JOptionPane.INFORMATION_MESSAGE);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kritik = new javax.swing.JTextField();
        saran = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkr = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(1046, 688));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("FEEDBACK");

        jLabel2.setText("Kritik");

        kritik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kritikActionPerformed(evt);
            }
        });

        saran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saranActionPerformed(evt);
            }
        });

        jLabel3.setText("Saran");

        tblkr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Kritik", "Saran"
            }
        ));
        jScrollPane1.setViewportView(tblkr);

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Kirim");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(kritik, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                            .addComponent(saran))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 916, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kritik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(343, 343, 343)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1046, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kritikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kritikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kritikActionPerformed

    private void saranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saranActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
String Komen = kritik.getText(); 
String Masukan = saran.getText();
String SUrl = "jdbc:MySQL://localhost:3306/java_db";
    String SUser = "root";
    String SPass = "";
try {
        Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
                Statement st = con.createStatement();
                String query = "INSERT INTO feedback(masukan, kritik) VALUES('" + Komen + "', '" + Masukan + "')";
                st.executeUpdate(query);
                showMessageDialog(null, "Terimakasih atas Masukan nya!");
                loadData();
            }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kritik;
    private javax.swing.JTextField saran;
    private javax.swing.JTable tblkr;
    // End of variables declaration//GEN-END:variables
}
