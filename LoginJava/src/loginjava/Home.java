package loginjava;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;

public class Home extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/todolist","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Items() {
        try {
            pst = con.prepareStatement("SELECT itemnum FROM tasklist");
            rs = pst.executeQuery();
            txtItemList.removeAllItems();
            
            while(rs.next()){
                txtItemList.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Fetch() {
        try {
            int fetching;
            pst = con.prepareStatement("SELECT * FROM tasklist");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            fetching = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)tdMain.getModel();
            df.setRowCount(0);
            
            while (rs.next()) {
                Vector fetch = new Vector();
                
                for(int a=1; a<=fetching; a++) {
                    fetch.add(rs.getString("itemnum"));
                    fetch.add(rs.getString("task"));
                    fetch.add(rs.getString("details"));
                    fetch.add(rs.getString("deadline"));
                    fetch.add(rs.getString("category"));  
                }
                df.addRow(fetch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Home() {
        initComponents();
        Connect();
        Items();
        Fetch();
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        View = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Details = new javax.swing.JLabel();
        TaskName = new javax.swing.JLabel();
        Deadline = new javax.swing.JLabel();
        Category = new javax.swing.JLabel();
        txtTname = new javax.swing.JTextField();
        txtDetails = new javax.swing.JTextField();
        txtDeadline = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        ItemNumber = new javax.swing.JLabel();
        txtItemList = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnDownload = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdMain = new javax.swing.JTable();

        jButton2.setBackground(new java.awt.Color(78, 108, 80));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(170, 139, 86));
        jButton2.setText("Create");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(78, 108, 80));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(170, 139, 86));
        jButton4.setText("View");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        View.setBackground(new java.awt.Color(78, 108, 80));
        View.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        View.setForeground(new java.awt.Color(170, 139, 86));
        View.setText("View");
        View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(57, 81, 68));

        jPanel1.setBackground(new java.awt.Color(57, 81, 68));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 235, 206));
        jLabel2.setText("To-Do List");

        Details.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Details.setForeground(new java.awt.Color(170, 139, 86));
        Details.setText("Details: ");
        Details.setToolTipText("");

        TaskName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TaskName.setForeground(new java.awt.Color(170, 139, 86));
        TaskName.setText("Task Name: ");
        TaskName.setToolTipText("");

        Deadline.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Deadline.setForeground(new java.awt.Color(170, 139, 86));
        Deadline.setText("Deadline: ");
        Deadline.setToolTipText("");

        Category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Category.setForeground(new java.awt.Color(170, 139, 86));
        Category.setText("Category: ");
        Category.setToolTipText("");

        txtTname.setBackground(new java.awt.Color(240, 235, 206));
        txtTname.setForeground(new java.awt.Color(170, 139, 86));

        txtDetails.setBackground(new java.awt.Color(240, 235, 206));
        txtDetails.setForeground(new java.awt.Color(170, 139, 86));

        txtDeadline.setBackground(new java.awt.Color(240, 235, 206));
        txtDeadline.setForeground(new java.awt.Color(170, 139, 86));

        txtCategory.setBackground(new java.awt.Color(240, 235, 206));
        txtCategory.setForeground(new java.awt.Color(170, 139, 86));

        ItemNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ItemNumber.setForeground(new java.awt.Color(170, 139, 86));
        ItemNumber.setText("Task Order:");
        ItemNumber.setToolTipText("");

        txtItemList.setBackground(new java.awt.Color(240, 235, 206));
        txtItemList.setForeground(new java.awt.Color(170, 139, 86));
        txtItemList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtItemList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemListActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(78, 108, 80));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(240, 240, 240));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSignOut.setBackground(new java.awt.Color(78, 108, 80));
        btnSignOut.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnSignOut.setForeground(new java.awt.Color(240, 240, 240));
        btnSignOut.setText("Sign Out");
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(57, 81, 68));

        btnCreate.setBackground(new java.awt.Color(78, 108, 80));
        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(240, 240, 240));
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(78, 108, 80));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(240, 240, 240));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(78, 108, 80));
        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(240, 240, 240));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemove)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove))
                .addContainerGap())
        );

        btnDownload.setBackground(new java.awt.Color(78, 108, 80));
        btnDownload.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnDownload.setForeground(new java.awt.Color(240, 240, 240));
        btnDownload.setText("Download to Excel");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(78, 108, 80));

        tdMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Task Order", "        Task", "       Details", "      Deadline", "     Category"
            }
        ));
        tdMain.setToolTipText("");
        jScrollPane1.setViewportView(tdMain);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TaskName)
                                            .addComponent(Details)
                                            .addComponent(Deadline)
                                            .addComponent(Category))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtDeadline, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                            .addComponent(txtDetails, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTname, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCategory))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ItemNumber)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDownload)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtItemList, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch)
                                    .addComponent(btnSignOut, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDownload)
                            .addComponent(btnSignOut))))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TaskName)
                    .addComponent(txtTname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Details)
                    .addComponent(txtDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemNumber))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Deadline)
                    .addComponent(txtDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Category)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String task = txtTname.getText();
        String details = txtDetails.getText();
        String deadline = txtDeadline.getText();
        String category = txtCategory.getText();
        
        try {
            pst = con.prepareStatement("INSERT INTO tasklist (task,details,deadline,category)VALUES(?,?,?,?)");
            pst.setString(1,task);
            pst.setString(2, details);
            pst.setString(3, deadline);
            pst.setString(4,category);
            
            int execution = pst.executeUpdate();
            
            if(execution==1) {
                JOptionPane.showMessageDialog(this,"New task has been created.");
                txtTname.setText("");
                txtDetails.setText("");
                txtDeadline.setText("");
                txtCategory.setText("");
                Fetch();
                Items();
            }else{
                JOptionPane.showMessageDialog(this,"Failed to create.");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String task = txtTname.getText();
            String details = txtDetails.getText();
            String deadline = txtDeadline.getText();
            String category = txtCategory.getText();
            String itemnum = txtItemList.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE tasklist SET task=?,details=?,deadline=?,category=? WHERE itemnum=?");
            
            pst.setString(1,task);
            pst.setString(2, details);
            pst.setString(3, deadline);
            pst.setString(4,category);
            pst.setString(5,itemnum);
            
            
            int execution = pst.executeUpdate();
            
            if(execution==1) {
                JOptionPane.showMessageDialog(this,"The task has been updated.");
                txtTname.setText("");
                txtDetails.setText("");
                txtDeadline.setText("");
                txtCategory.setText("");
                txtTname.requestFocus();
                Fetch();
                Items();
            }else{
                JOptionPane.showMessageDialog(this,"Failed to update.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            String itemnum = txtItemList.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM tasklist WHERE itemnum=?");
            pst.setString(1, itemnum);
            
            int execution = pst.executeUpdate();
            
            if(execution==1) {
                JOptionPane.showMessageDialog(this,"The task has been removed.");
                txtTname.setText("");
                txtDetails.setText("");
                txtDeadline.setText("");
                txtCategory.setText("");
                txtTname.requestFocus();
                Fetch();
                Items();
            }else{
                JOptionPane.showMessageDialog(this,"Failed to remove.");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void txtItemListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemListActionPerformed

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        JOptionPane.showMessageDialog(rootPane, "You are succesfully log out....");
                new Loginf().setVisible(true);
                this.setVisible(false);
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String itemnum = txtItemList.getSelectedItem().toString();
            
            pst = con.prepareStatement("SELECT * FROM tasklist WHERE itemnum=?");
            pst.setString(1,itemnum);
            rs = pst.executeQuery();
            
            if(rs.next()==true){
                txtTname.setText(rs.getString(2));
                txtDetails.setText(rs.getString(3));
                txtDeadline.setText(rs.getString(4));
                txtCategory.setText(rs.getString(5));
            }else {
                JOptionPane.showMessageDialog(this,"Task not found.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        String filename = "D:\\YourTask.csv";

        try {
            FileWriter fw = new FileWriter(filename);
            pst = con.prepareStatement("SELECT * FROM tasklist");
            rs = pst.executeQuery();

            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append(',');
                fw.append(rs.getString(5));
                fw.append('\n');
            }
            JOptionPane.showMessageDialog(this,"YourTask.csv has been successfully downloaded.");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDownloadActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Category;
    private javax.swing.JLabel Deadline;
    private javax.swing.JLabel Details;
    private javax.swing.JLabel ItemNumber;
    private javax.swing.JLabel TaskName;
    private javax.swing.JButton View;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tdMain;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtDeadline;
    private javax.swing.JTextField txtDetails;
    private javax.swing.JComboBox<String> txtItemList;
    private javax.swing.JTextField txtTname;
    // End of variables declaration//GEN-END:variables

    private PreparedStatement setString(int i, String task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
