package gui.admin;

import gui.util.Toast;
import utils.CSVHelper;

import javax.swing.table.DefaultTableModel;

/**
 * Dialog to view system reports from reports.csv.
 * @author Youssef Adel 258270
 */
public class ViewReportsDialog extends javax.swing.JDialog {

    private DefaultTableModel tableModel;
    private javax.swing.JTable tblReports;

    public ViewReportsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadReports();
    }

    public ViewReportsDialog(java.awt.Frame parent) {
        this(parent, true);
    }

    private void initComponents() {
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JButton btnRefresh = new javax.swing.JButton();
        javax.swing.JButton btnClose = new javax.swing.JButton();

        tblReports = new javax.swing.JTable();
        tblReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Date", "Action", "User", "Details"}
        ));
        jScrollPane1.setViewportView(tblReports);

        setTitle("System Reports");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Action Reports");

        btnRefresh.setFont(new java.awt.Font("sansserif", 1, 13));
        btnRefresh.setText("Refresh");
        btnRefresh.setPreferredSize(new java.awt.Dimension(100, 35));
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);

        btnClose.setFont(new java.awt.Font("sansserif", 1, 13));
        btnClose.setText("Close");
        btnClose.setPreferredSize(new java.awt.Dimension(100, 35));
        btnClose.addActionListener(this::btnCloseActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        loadReports();
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void loadReports() {
        tableModel = (DefaultTableModel) tblReports.getModel();
        tableModel.setRowCount(0);

        java.io.File reportsFile = new java.io.File("data/reports.csv");

        if (!reportsFile.exists()) {
            Toast.showInfo(this, "No reports available yet.");
            return;
        }

        try {
            java.util.List<String> lines = CSVHelper.readLines("data/reports.csv");

            if (lines.isEmpty()) {
                Toast.showInfo(this, "No reports available yet.");
                return;
            }

            for (String line : lines) {
                java.util.List<String> fields = CSVHelper.parseLine(line);

                if (fields.size() >= 4) {
                    tableModel.addRow(new Object[]{
                        fields.get(0),
                        fields.get(1),
                        fields.get(2),
                        fields.get(3)
                    });
                }
            }

            Toast.showSuccess(this, "Loaded " + tableModel.getRowCount() + " report(s)");

        } catch (Exception e) {
            Toast.showError(this, "Failed to load reports: " + e.getMessage());
        }
    }
}
