/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quan_ly_bai_giu_xe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HoaDon extends javax.swing.JFrame {
    DefaultTableModel dtModel;
    /**
     * Creates new form HoaDon
     */
    public HoaDon() {
         
        initComponents();
        dtModel = (DefaultTableModel)tbHD.getModel();
        ShowTable();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnExxit = new javax.swing.JButton();
        txtBienso = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();
        btnX = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("Hóa Đơn Thanh Toán");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Tìm hóa đơn theo biển số");

        btnExxit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnExxit.setText("Thoát");
        btnExxit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExxitActionPerformed(evt);
            }
        });

        txtBienso.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tbHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Thẻ", "Tên Chủ Xe", "Biển Số", "SĐT", "Số Ngày Gửi", "Loai Xe", "Thành Tiền"
            }
        ));
        jScrollPane1.setViewportView(tbHD);

        btnX.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnX.setText("Làm Mới");
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBienso, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExxit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBienso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExxit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public int Dem() {
        int dem = 0;
        try {
          Conect pt = new Conect();
            ResultSet rs = pt.getdata("thanhtoan");
            while (rs.next()) {
                dem++;
            }

            pt.Close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
     public void ShowTable() {
        dtModel.setRowCount(Dem());//Thiết lập số dòng của jtable = số dòng của bảng của DataBase
        try {
           Conect pt = new Conect();
            ResultSet rs = pt.getdata("thanhtoan");
            int i = 0;
            while (rs.next()) {
                tbHD.setValueAt(rs.getString("mathe"), i, 0);
                 tbHD.setValueAt(rs.getString("tenchuxe"), i, 1);
                 tbHD.setValueAt(rs.getString("bienso"), i, 2);
                 tbHD.setValueAt(rs.getString("sodt"), i, 3);
                 tbHD.setValueAt(rs.getString("songay_gui"), i, 4);
                 tbHD.setValueAt(rs.getString("loaixe"), i, 5);
                   tbHD.setValueAt(rs.getString("total"), i, 6);
                i++;
            }
            pt.Close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void Exit(){
        int kq = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?","Thoát?",JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(kq==JOptionPane.CANCEL_OPTION)
            return;
        this.dispose();
         FormMenu form = new FormMenu();
         form.setLocationRelativeTo(null);
         form.setVisible(true);
        }
    private void btnExxitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExxitActionPerformed
        Exit();
    }//GEN-LAST:event_btnExxitActionPerformed

    public void Clear_Table() {
        DefaultTableModel model = (DefaultTableModel) tbHD.getModel();
        model.setRowCount(0);
        model.setRowCount(Dem());
    }
    public int Dem1() {
        int dem = 0;
        String s1 = txtBienso.getText();
        try {
           Conect pt = new Conect();
            ResultSet rs;
            if(s1.isEmpty())
                rs = pt.GetXD("thanhtoan");
            else rs = pt.GetHD(s1);
            int i = 0;     
            while (rs.next()) {
                dem++;
            }

            pt.Close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyPhuongTien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
    public void show_timkiem() {
        dtModel.setRowCount(Dem1());
        String s1=txtBienso.getText();
        try {
            Conect pt = new Conect();
            ResultSet rs;
            if(s1.isEmpty())
                rs = pt.GetXD("thanhtoan");
            else rs = pt.GetHD(s1);
            int i = 0;
            while (rs.next()) {
                tbHD.setValueAt(rs.getString("mathe"), i, 0);
                tbHD.setValueAt(rs.getString("tenchuxe"), i, 1);
                tbHD.setValueAt(rs.getString("bienso"), i, 2);
                tbHD.setValueAt(rs.getString("sodt"), i, 3);
                tbHD.setValueAt(rs.getString("songay_gui"), i, 4);
                tbHD.setValueAt(rs.getString("loaixe"), i, 5);
                tbHD.setValueAt(rs.getString("total"), i, 6);
                i++;
            }
            pt.Close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
      show_timkiem();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXActionPerformed
        txtBienso.setText("");
        txtBienso.requestFocus();
        tbHD.removeAll();
        ShowTable();
    }//GEN-LAST:event_btnXActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HoaDon frm = new HoaDon();
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExxit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbHD;
    private javax.swing.JTextField txtBienso;
    // End of variables declaration//GEN-END:variables
}
