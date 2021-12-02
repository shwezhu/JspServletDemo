import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class can be used to initialize the database connection
public class DatabaseConnection {
    protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
        // static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        // static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";

        // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
        // 这里一定要注意下面这句话localhost:3306/jspdemo?的jspdemo 是你的数据库名字 你自己创建的 每个数据库里面有若干个表
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/jspdemo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        // 数据库的用户名与密码，需要根据自己的设置
        final String user = "shaowen";
        final String password = "778899";

        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);

        // 返回连接实例
        System.out.println("Connecting to mysql...");
        return DriverManager.getConnection(DB_URL, user, password);
    }
}