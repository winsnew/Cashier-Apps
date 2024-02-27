package javaswingdev.main;

import java.awt.Component;
import javaswingdev.login.Login;
import javaswingdev.form.Form_Food;
import javaswingdev.form.Form_Dashboard;
import javaswingdev.form.Form_transaksi;
import javaswingdev.form.Form_Empty;
//import javaswingdev.login.Login.Level;
import javaswingdev.menu.EventMenuSelected;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {
    
    private static Main main;
    
    public Main(String userRole) {
        this.userRole = userRole;
        main = this;
        initComponents();
        init();
    }
    
    private void init() {
//        main = this;
        titleBar.initJFram(this);
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, int indexSubMenu) {
                // Pemeriksaan level sekarang
                
                if ("admin".equals(userRole)) {
                    handleAdminDashboard(index, indexSubMenu);
                } else if ("kasir".equals(userRole)) {
                    handleKasirDashboard(index, indexSubMenu);
                }
            }
            
        });
        menu.setSelectedIndex(0, 0);
    }
    
    // Metode untuk menangani tampilan dashboard untuk admin
    private void handleAdminDashboard(int index, int indexSubMenu) {
        // Logika tampilan untuk admin
        switch (index) {
            case 0:
                showForm(new Form_Dashboard());
                break;
            case 1:
                showForm(new Form_Food());
                break;
            case 2:
                showForm(new Form_transaksi());
                break;
            case 3:
                handleLogout();
                break;
        }
    }
    private void handleLogout() {
    // Tambahkan logika logout sesuai kebutuhan Anda
    int confirm = JOptionPane.showConfirmDialog(Main.this, "Apakah Anda yakin ingin logout?", "Logout", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        // Lakukan operasi logout
        Login loginFrame = new Login();
        // Open Login Frame
        loginFrame.show();
        this.dispose();
    }
    
}
    // Metode untuk menangani tampilan dashboard untuk kasir
private void handleKasirDashboard(int index, int indexSubMenu) {
    // Logika tampilan untuk kasir
        switch (index) {
            case 0:
                showForm(new Form_transaksi());
                break;
            case 3: // Logout case
            handleLogout();
            break;
            default:
                JOptionPane.showMessageDialog(Main.this, "Kasir tidak memiliki akses ke menu ini");
                break;
        }
}
    
    public void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }
    
    
    
    private String userRole ;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
    public static Main getMain() {
        return main;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        menu = new javaswingdev.menu.Menu();
        titleBar = new javaswingdev.swing.titlebar.TitleBar();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background.setBackground(new java.awt.Color(245, 245, 245));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Login loginForm = new Login();
            loginForm.setVisible(true);

            loginForm.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    try {
                        if (loginForm != null && loginForm.isLoginSuccessful()) {
                            // Set nilai level
                            
                            String userRole = loginForm.getUserRole();
                            Login loginFrame = new Login();
                            // Check if userRoles is not null
                            if (userRole != null) {
                                
                                new Main(userRole).setVisible(true);
                                
                            } else {
                                // Handle the case where userRoles is null
                                JOptionPane.showMessageDialog(null, "Error: User roles is null", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel body;
    private javaswingdev.menu.Menu menu;
    private javax.swing.JPanel panelMenu;
    private javaswingdev.swing.titlebar.TitleBar titleBar;
    // End of variables declaration//GEN-END:variables
}
