package mylib;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyLib {
    public static Connection makeConnection() throws Exception {
        Connection cn = null;
        String IP = "DESKTOP-GISFHHL"; // Địa chỉ IP của máy chủ mới
        String port = "1433"; // Cổng mặc định của SQL Server
        String uid = "SA"; // Tên người dùng của máy chủ mới
        String pwd = "12345"; // Mật khẩu của máy chủ mới
        String db = "DBWEBFOOD13"; // Tên cơ sở dữ liệu trên máy chủ mới
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + IP + ":" + port + ";databaseName=" + db + ";user=" + uid + ";password=" + pwd;
        Class.forName(driver);
        cn = DriverManager.getConnection(url);
        return cn;
    }
}
