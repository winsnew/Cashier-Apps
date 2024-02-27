package javaswingdev.form;

import config.koneksi;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javaswingdev.card.ModelCard;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Form_Dashboard extends javax.swing.JPanel {
    Connection con;
    DefaultTableModel riwayatTableModel;
    public Form_Dashboard() {
        initComponents();
        init();
        connect();
        riwayatTableModel = (DefaultTableModel) riwayatTable.getModel();
        tampilRiwayatTransaksi();
    }

    private void init() {
        riwayatTable.fixTable(jScrollPane1);
        
        // Menghitung total pendapatan dari transaksi
        String totalPendapatan = hitungTotalPendapatan();

        // Menampilkan total pada card pertama
        card1.setData(new ModelCard(null, null, null, totalPendapatan, "Report Income Monthly"));
        
    }
    public void connect() {
    con=null;
    try{
        con=koneksi.getKoneksi();
    }catch (Exception e) {       
       System.out.print("error koneksi database" + e);
   }
}
    
    private String hitungTotalPendapatan() {
    double totalPendapatan = 0.0;

    // Hitung total pendapatan dari transaksi
    for (int i = 0; i < riwayatTable.getRowCount(); i++) {
        try {
            // Ambil nilai dari kolom total bayar dan tambahkan ke total pendapatan
            double totalBayar = Double.parseDouble(riwayatTable.getValueAt(i, 1).toString());
            totalPendapatan += totalBayar;
        } catch (NumberFormatException e) {
            // Handle jika nilai di kolom total bayar tidak bisa di-parse sebagai double
            e.printStackTrace();
        }
    }

    // Format total pendapatan sebagai string
    return String.format("%.2f", totalPendapatan);
}
    
    private void tampilRiwayatTransaksi() {
        try {
            String query = "SELECT kode_transaksi, total_bayar, kembalian, tanggal_bayar FROM riwayat_transaksi";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

//            // Menghapus semua baris yang ada di tabel
//            riwayatTable.setRowCount(0);
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            // Mengisi tabel dengan data dari hasil query
            while (resultSet.next()) {
                String kodeTransaksi = resultSet.getString("kode_transaksi");
                String totalBayar = currencyFormat.format(resultSet.getDouble("total_bayar"));
                String kembalian = currencyFormat.format(resultSet.getDouble("kembalian"));
                java.util.Date tglDate = resultSet.getDate("tanggal_bayar");
                String tgl_bayar = new SimpleDateFormat("dd-MM-yyyy").format(tglDate);

                riwayatTable.addRow(new Object[]{kodeTransaksi, totalBayar, kembalian, tgl_bayar});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new javaswingdev.card.Card();
        card2 = new javaswingdev.card.Card();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        riwayatTable = new javaswingdev.swing.table.Table();

        setOpaque(false);

        card2.setColor1(new java.awt.Color(95, 211, 226));
        card2.setColor2(new java.awt.Color(26, 166, 170));
        card2.setIcon(javaswingdev.GoogleMaterialDesignIcon.PIE_CHART);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        riwayatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Transaksi", "Total Bayar", "Kembalian", "Tanggal"
            }
        ));
        riwayatTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(riwayatTable);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.card.Card card1;
    private javaswingdev.card.Card card2;
    private javax.swing.JScrollPane jScrollPane1;
    private javaswingdev.swing.table.Table riwayatTable;
    private javaswingdev.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
