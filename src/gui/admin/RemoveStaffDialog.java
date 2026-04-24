package gui.admin;

import javax.swing.JOptionPane;

import manager.BankSystem;
import models.user.Admin;
import models.user.User;

import javax.swing.table.DefaultTableModel;

/**
 * Dialog to remove a staff member by selecting from the list.
 * @author Youssef Adel 258270
 */
public class RemoveStaffDialog extends javax.swing.JDialog {

    private BankSystem bank;
    private DefaultTableModel tableModel;

    public RemoveStaffDialog(java.awt.Frame parent, BankSystem bank) {
        super(parent, true);
        this.bank = bank;
        initComponents();
        loadStaff();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTable tblStaff = new javax.swing.JTable();
        javax.swing.JButton btnRemove = new javax.swing.JButton();
        javax.swing.JButton btnClose = new javax.swing.JButton();

        tableModel = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Name", "Job Title", "Email", "Phone"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblStaff.setModel(tableModel);
        jScrollPane1.setViewportView(tblStaff);

        setTitle("Remove Staff");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select Staff to Remove");

        btnRemove.setFont(new java.awt.Font("sansserif", 1, 13));
        btnRemove.setText("Remove Selected");
        btnRemove.setPreferredSize(new java.awt.Dimension(140, 35));
        btnRemove.addActionListener(evt -> {
            int selectedRow = tblStaff.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a staff member to remove", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String email = (String) tableModel.getValueAt(selectedRow, 2);

            int confirm = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to remove " + tableModel.getValueAt(selectedRow, 0) + "?",
                "Confirm Removal",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE
            );

            if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                boolean removed = false;
                for (User u : bank.getUsers()) {
                    if (u instanceof Admin && u.getEmail().equalsIgnoreCase(email)) {
                        bank.getUsers().remove(u);
                        removed = true;
                        break;
                    }
                }

                if (removed) {
                    bank.saveAllData();
                    JOptionPane.showMessageDialog(this, "Staff member removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadStaff();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to remove staff member", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnClose.setFont(new java.awt.Font("sansserif", 1, 13));
        btnClose.setText("Close");
        btnClose.setPreferredSize(new java.awt.Dimension(100, 35));
        btnClose.addActionListener(evt -> dispose());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }

    private void loadStaff() {
        tableModel.setRowCount(0);
        for (User u : bank.getUsers()) {
            if (u instanceof Admin) {
                Admin a = (Admin) u;
                tableModel.addRow(new Object[]{
                    a.getName(),
                    a.getJobTitle(),
                    a.getEmail(),
                    a.getPhoneNumber()
                });
            }
        }
    }
}
