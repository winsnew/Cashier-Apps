
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class koneksi {

    public static Connection conn;
    
    public static Connection getKoneksi() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/aplikasi_kasir","root","");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                // Ganti dengan penanganan exception yang sesuai dengan kebutuhan Anda
            }
        }
        return conn;
    }
    public static void closeKoneksi() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Ganti dengan penanganan exception yang sesuai dengan kebutuhan Anda
            }
        }
    }
        
        
    
    
    
}
