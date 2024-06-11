/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quan_ly_bai_giu_xe;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Admin
 */
public class QuanLyPhuongTien extends javax.swing.JFrame {
    DefaultTableModel dtModel;
   
     
//    LocalDateTime currentTime = LocalDateTime.now();
    public  QuanLyPhuongTien() {
       initComponents();
       dtModel = (DefaultTableModel)tbShow.getModel();
       ShowTable();
       txtMathe.setEnabled(false);
       txtTenChu.setEditable(true);
       txtBienSo.setEditable(true);
       txtSDT.setEditable(true);
       cbLoai.setEnabled(true);
       txtDateIn.setEditable(true);
       txtTotalDate.setEnabled(false);
       lbMaloai.setVisible(true);
       cbMaloai.setVisible(true);      
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

     public int Dem() {
        int dem = 0;
        try {
           Conect pt = new Conect();
            ResultSet rs = pt.getdata("phuongtien");
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

      public void ShowTable() {
        dtModel.setRowCount(Dem());//Thiết lập số dòng của jtable = số dòng của bảng của DataBase
        try {
            Conect pt = new Conect();
            ResultSet rs = pt.getdata("phuongtien");
            int i = 0;
             while (rs.next()) {
                tbShow.setValueAt(rs.getString("mathe"), i, 0);
                tbShow.setValueAt(rs.getString("tenchuxe"), i, 1);
                tbShow.setValueAt(rs.getString("sdt"), i, 2);
                tbShow.setValueAt(rs.getString("bienso"), i, 3);
                tbShow.setValueAt(rs.getString("loaixe"), i, 4);                
                tbShow.setValueAt(rs.getString("ngayvao"), i, 5);                
                i++;
            }
            pt.Close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(QuanLyPhuongTien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      void tbShow_SelectionChanged(){
        txtTotalDate.setText("");
        int row = tbShow.getSelectedRow();
        if(row>=0){
            String mathe = (String) dtModel.getValueAt(row, 0);
            String tenchuxe = (String) dtModel.getValueAt(row, 1);
            String sdt = (String) dtModel.getValueAt(row, 2);
            String bienso = (String) dtModel.getValueAt(row, 3);
            String loaixe = (String) dtModel.getValueAt(row, 4);
            String ngayvao = (String) dtModel.getValueAt(row, 5);
               
            txtMathe.setText(mathe);
            txtTenChu.setText(tenchuxe);
            txtBienSo.setText(bienso);
            txtSDT.setText(sdt);
            cbLoai.setSelectedItem(loaixe);
            txtDateIn.setText(ngayvao);
        }else{
            {
                txtMathe.setText("");
                txtTenChu.setText("");
               txtBienSo.setText("");
               txtSDT.setText("");
               txtDateIn.setText("");
               txtTotalDate.setText("");
            }
        }
    } 
    
    boolean checksdt(){
    String phoneNumber = txtSDT.getText();
    // Kiểm tra xem số điện thoại có chứa ký tự không phải số hay không
        if (!phoneNumber.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "đây không phải số điện thoại , chỉ nhập số.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return  true;
    }
    public boolean checkDate() {
        String inputDate = txtDateIn.getText();
        // Định dạng ngày tháng
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // Tắt chế độ linh hoạt (lenient) để kiểm tra chính xác
        try {
            dateFormat.parse(inputDate);
            return true; // Ngày tháng hợp lệ
        } catch (ParseException e) {
            // Ngày tháng không hợp lệ - hiển thị cảnh báo
            JOptionPane.showMessageDialog(null, "Sai định dạng! Hãy nhập đúng định dạng yyyy-MM-dd .", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThanhtoan = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbShow = new javax.swing.JTable();
        txtMathe = new javax.swing.JTextField();
        txtTenChu = new javax.swing.JTextField();
        txtBienSo = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        cbLoai = new javax.swing.JComboBox<>();
        txtDateIn = new javax.swing.JTextField();
        txtTotalDate = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        lbMaloai = new javax.swing.JLabel();
        cbMaloai = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("Quản Lý Phương Tiện");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Thẻ :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên Chủ Xe :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Biển Số :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("SĐT :");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Loại Xe :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ngày Vào :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số Ngày Đã Gửi:");

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThanhtoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThanhtoan.setForeground(new java.awt.Color(255, 51, 51));
        btnThanhtoan.setText("Thanh Toán");
        btnThanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhtoanActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        tbShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã thẻ", "Tên chủ xe", "SĐT", "Biển Số Xe", "Loại xe ", "Ngày vào"
            }
        ));
        jScrollPane1.setViewportView(tbShow);

        txtMathe.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtTenChu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtBienSo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        cbLoai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ô Tô", "Xe Máy", "Xe Đạp", "Xe Máy Điện" }));
        cbLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLoaiItemStateChanged(evt);
            }
        });

        txtDateIn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtTotalDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClear.setText("Làm mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lbMaloai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMaloai.setText("Mã Loại :");

        cbMaloai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbMaloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OT", "XM", "XĐ", "XMĐ" }));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Yêu cầu nhập đúng định dạng năm-tháng-ngày");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMathe, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenChu, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBienSo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbMaloai, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(jLabel7)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTotalDate)
                                .addComponent(txtDateIn, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhtoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThoat)))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMathe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBienSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDateIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMaloai)
                            .addComponent(cbMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnThanhtoan)
                    .addComponent(btnThoat)
                    .addComponent(btnThem)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private boolean check(String mathe) {
        boolean check = false;
        try {
            Conect pt = new Conect();

            ResultSet rs = pt.getdata("phuongtien");
            while (rs.next()) {
                if (rs.getString(1).equals(mathe) == true) {
                    check = true;
                }
            }
            pt.Close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dangnhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

public int Dem1() {
        int dem = 0;
        String bienso = txtBienSo.getText();
        try {
           Conect pt = new Conect();
            ResultSet rs = pt.Check(bienso);
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

public boolean Insert() {
        String loaixe = (String) cbLoai.getSelectedItem();
        String tenchuxe = txtTenChu.getText();
        String SDT = txtSDT.getText();
        String Maloai = (String) cbMaloai.getSelectedItem();
        String ngayvao= txtDateIn.getText();
        String bienso = txtBienSo.getText();
 
        Conect pt;
        try {
            pt = new Conect();
            if(txtBienSo.getText().equals("")){
                pt.InsertPT(tenchuxe,bienso,SDT,loaixe,ngayvao,Maloai);
                pt.Close();
                return true;
            }
            else if(Dem1()==0){
                pt.InsertPT(tenchuxe,bienso,SDT,loaixe,ngayvao,Maloai);
                pt.Close();
                return true;
            }
            else{
                pt.Close();
                return false;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(QuanLyPhuongTien.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        btnThanhtoan.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);     
        txtMathe.setEnabled(false);
        txtTenChu.setEditable(true);
        txtBienSo.setEditable(true);
        txtSDT.setEditable(true);
        cbLoai.setEnabled(true);
        txtDateIn.setEditable(true);
        txtTotalDate.setEnabled(false);
        lbMaloai.setVisible(true);
        cbMaloai.setVisible(true);
          
        if(CheckInput()==false){
           return;
        } else if(!checksdt()){
            return;
        } else if(!checkDate()){
            return;
        } else {
            if(Insert())
            {
                ShowTable();
                JOptionPane.showMessageDialog(null, "Đã thêm thành công");
            }
            else{
                JOptionPane.showMessageDialog(null, "Biển số xe đã tồn tại trong cơ sở dữ liệu");
            }
        }
            
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       
        int rs = tbShow.getSelectedRow();
             if(rs<0){
             JOptionPane.showMessageDialog(null, "Bạn chưa chọn phương tiện",
                     "Chưa chọn Phương tiện", JOptionPane.INFORMATION_MESSAGE);
             return;
             }
             else{
             int result =  JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phương tiện này không?",
                     "Xóa ?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
             String mathe = txtMathe.getText();
             
             if(result == JOptionPane.OK_OPTION){
                    Delete(mathe);
                    ShowTable();
                    JOptionPane.showMessageDialog(null, "Xóa thành công","Thành công",
                            JOptionPane.INFORMATION_MESSAGE);
             }
             }
    }//GEN-LAST:event_btnXoaActionPerformed
 public void capnhatDL() {
     String mathe=txtMathe.getText();
        String tenchuxe = txtTenChu.getText();
         String bienso = txtBienSo.getText();
          String SDT = txtSDT.getText();
           String loaixe = (String) cbLoai.getSelectedItem();
           String Maloai = (String) cbMaloai.getSelectedItem();
           String ngayvao= txtDateIn.getText();
     Conect pt;
        try {
            pt = new Conect();
            pt.Update(tenchuxe,bienso ,SDT,loaixe,ngayvao,Maloai,mathe);
            pt.Close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyPhuongTien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
       txtMathe.setEnabled(false);
          txtTenChu.setEditable(true);
           txtBienSo.setEditable(true);
            txtSDT.setEditable(true);
             cbLoai.setEnabled(true);
             txtDateIn.setEditable(true);
             
             txtTotalDate.setEditable(false);
             lbMaloai.setVisible(true);
             cbMaloai.setVisible(true);
             btnThem.setEnabled(false);
             btnXoa.setEnabled(false);
             btnThanhtoan.setEnabled(false);
        int rs = tbShow.getSelectedRow();
             if(rs<0){
             JOptionPane.showMessageDialog(null, "Bạn chưa chọn phương tiện",
                     "Chưa chọn Phương tiện", JOptionPane.INFORMATION_MESSAGE);
             return;
             }
             else{
                 capnhatDL();
            ShowTable();
            JOptionPane.showMessageDialog(null, "Bạn đã cập nhật thành công!"); 
             }
    }//GEN-LAST:event_btnSuaActionPerformed
 public void InsertHD(  long total) {
         String mathe=txtMathe.getText();
        String tenchuxe = txtTenChu.getText();
         String bienso = txtBienSo.getText();
          String SDT = txtSDT.getText();
           String loaixe = (String) cbLoai.getSelectedItem();
           String songay_gui= txtTotalDate.getText();
          String totall = String.valueOf(total);
           
          
        Conect pt;
        try {
            pt = new Conect();
            pt.InsertHD(mathe,tenchuxe, bienso,SDT,loaixe,songay_gui,totall);
            pt.Close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(QuanLyPhuongTien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        int rs = tbShow.getSelectedRow();
        if(rs<0){
             JOptionPane.showMessageDialog(null, "Bạn chưa chọn phương tiện",
                     "Chưa chọn Phương tiện", JOptionPane.INFORMATION_MESSAGE);
             return;
             }
        else{
            String mathe=txtMathe.getText();
        //String tenchuxe = txtTenChu.getText();
        String bienso = txtBienSo.getText();
        //String SDT = txtSDT.getText();
        //String loaixe = (String) cbLoai.getSelectedItem();
        //String songaygui= (String )txtTotalDate.getText();
        int selectedRow = tbShow.getSelectedRow(); // Lấy chỉ số dòng được chọn trong JTable
        if (selectedRow != -1) { // Kiểm tra xem có dòng nào được chọn không
        String dateString = (String) tbShow.getValueAt(selectedRow, 5);
        String Loai1 = (String) tbShow.getValueAt(selectedRow, 4);// Lấy giá trị từ dòng và cột tương ứng
        try {
            LocalDate currentDate = LocalDate.now();
            LocalDate selectedDate = LocalDate.parse(dateString); // Chuyển đổi chuỗi thành LocalDate
            long daysDifference = ChronoUnit.DAYS.between(selectedDate, currentDate);
            String differenceString = String.valueOf(daysDifference); // Chuyển đổi thành chuỗi
            txtTotalDate.setText(differenceString);
            int giatien=0;
            if(Loai1.equals("Ô Tô")){
                giatien=50000;
            }
            else if( Loai1.equals("Xe Máy")){
               giatien=20000;
            }
             else if( Loai1.equals("Xe Máy Điện")){
                giatien=15000;
            }
             else{
                giatien=5000;
            }
            long total= daysDifference * giatien;
            String totall = String.valueOf(total); 
//            String tableData = "|Phương tiện | Giá/ngày|\n|Xe đạp|5000 VNĐ|\n|Xe máy điện|15000 VNĐ|\n|Xe máy|20000 VNĐ|\n|Ô tô|50000 VNĐ|";
////           tách chuỗi tableData dựa tên kí tự \n
//        String[] rows = tableData.split("\n");
//
//        StringBuilder message = new StringBuilder();
//        message.append("<html><table>");
//
//        for (int i = 0; i < rows.length; i++) {
//            String[] cells = rows[i].split("\\|");
//            message.append("<tr>");
//
//            for (String cell : cells) {
//                String data = cell.trim();
//                if (!data.isEmpty()) {
//                    if (i == 0) {
//                        message.append("<th>").append(data).append("</th>");
//                    } else {
//                        message.append("<td>").append(data).append("</td>");
//                    }
//                }
//            }
//
//            message.append("</tr>");
//        }
//
//        message.append("</table></html>");
              String tableData = "<html><div style='text-align: center ;'>" +
                "<table style='border: 1px solid black;'>" +
                "<tr><th>Phương tiện</th><th>Giá/ngày</th></tr>" +
                "<tr><td>Xe đạp</td><td>5000</td></tr>" +
                "<tr><td>Xe máy điện</td><td>15000</td></tr>" +
                "<tr><td>Xe máy</td><td>20000</td></tr>" +
                "<tr><td>Ô tô</td><td>50000</td></tr>" +
                "</table>" +
                "</div></html>";

       // JOptionPane.showMessageDialog(null, tableData);
      
int result =JOptionPane.showConfirmDialog(null,tableData.toString()+"\nBạn có muốn thanh toán phương tiện biển số : " +bienso+" với số tiền :" +total+ " VNĐ không?",
             "Thanh toán ?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE); 
            if(result == JOptionPane.OK_OPTION){
                Delete(mathe);
                InsertHD(total);
                ShowTable();
                JOptionPane.showInternalMessageDialog(null, "Thanh toán thành công");
            }
        } catch (DateTimeParseException ex) {
            Logger.getLogger(QuanLyPhuongTien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
   
    }//GEN-LAST:event_btnThanhtoanActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
              Exit();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       tbShow.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                tbShow_SelectionChanged();
            }
        });
    }//GEN-LAST:event_formWindowOpened

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
         txtMathe.setText("");
                txtTenChu.setText("");
               txtBienSo.setText("");
               txtSDT.setText("");
               txtDateIn.setText("");
               txtTotalDate.setText("");
               btnSua.setEnabled(true);
             btnXoa.setEnabled(true); 
             btnThem.setEnabled(true);
               btnThanhtoan.setEnabled(true);
               int select=tbShow.getSelectedRow();
               if(select>0){
               tbShow.removeRowSelectionInterval(select, select);
               }
               else{
                   return;
               }
    }//GEN-LAST:event_btnClearActionPerformed

    private void cbLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLoaiItemStateChanged
        // TODO add your handling code here:
        if(cbLoai.getSelectedItem().equals("Xe Đạp")){
            txtBienSo.setText("");
            txtBienSo.setEditable(false);
        } 
        else 
            txtBienSo.setEditable(true);
        
        cbMaloai.setSelectedIndex(cbLoai.getSelectedIndex());
    }//GEN-LAST:event_cbLoaiItemStateChanged
 public void Delete(String mathe) {

        Conect pt;
        try {
            pt = new Conect();
            pt.Delete(mathe);
            pt.Close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyPhuongTien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 boolean CheckInput(){
        String tenchuxe = txtTenChu.getText().trim();
        String bienso = txtBienSo.getText().trim();
        String sdt = txtSDT.getText().trim();
        String ngayvao=txtDateIn.getText().trim();       
        String Loaixe = (String) cbLoai.getSelectedItem();
        if(tenchuxe.length()==0){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên chủ phương tiện",
                    "Chưa nhập tên chủ phương tiện",
                    JOptionPane.WARNING_MESSAGE);
            txtTenChu.requestFocus();
            return false;
        }
        if(bienso.length()==0 && !Loaixe.equals("Xe Đạp")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập Biển số phương tiện",
                    "Chưa nhập Biển số phương tiện",
                    JOptionPane.WARNING_MESSAGE);
            txtBienSo.requestFocus();
            return false;
        }
        if(sdt.length()==0){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập Số điện thoại",
                    "Chưa nhập số điện thoại",
                    JOptionPane.WARNING_MESSAGE);
            txtSDT.requestFocus();
            return false;
        }
        if(ngayvao.length()==0){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày vào của phương tiện",
                    "Chưa nhập ngày vào của phương tiện",
                    JOptionPane.WARNING_MESSAGE);
            txtDateIn.requestFocus();
            return false;
        }
//        if(ngaygui.length()==0){
//            JOptionPane.showMessageDialog(null, "Vui lòng nhập số ngày gửi của phương tiện",
//                    "Chưa nhập số ngày gửi của phương tiện",
//                    JOptionPane.WARNING_MESSAGE);
//            txtTotalDate.requestFocus();
//            return false;
//        }
        if(Loaixe== null|| Loaixe.length()==0){
           JOptionPane.showMessageDialog(null, "Chưa có loại xe . Vui lòng thêm ít nhất 1 "
                   + "loại ", "Chưa có mã loại",
                    JOptionPane.WARNING_MESSAGE);
            btnThoat.requestFocus();
            return false; 
        }
        return true;
    } 
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
            java.util.logging.Logger.getLogger(QuanLyPhuongTien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhuongTien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhuongTien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhuongTien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyPhuongTien frm = new QuanLyPhuongTien();
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThanhtoan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JComboBox<String> cbMaloai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMaloai;
    private javax.swing.JTable tbShow;
    private javax.swing.JTextField txtBienSo;
    private javax.swing.JTextField txtDateIn;
    private javax.swing.JTextField txtMathe;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenChu;
    private javax.swing.JTextField txtTotalDate;
    // End of variables declaration//GEN-END:variables
}
