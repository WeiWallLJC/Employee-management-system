//用户数据库
package login;

import java.sql.*;

public class userdatabase {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/STAFF";
    
    static final String USER = "root";
    static final String PASS = "5973666";
    
    private Connection conn = null;
    private Statement stmt = null;
 
    public userdatabase(){
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
        
            // 打开链接
            System.out.println("数据库驱动程序加载成功");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            stmt = conn.createStatement();
            System.out.println("连接user数据库成功\n");
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    public Connection getMyConnection() {
    	return conn;
    }
    public Statement getMyStatement() {
    	return stmt;
    }
    public void closeMyConnection() {
    	try {
    		stmt.close();
    		conn.close();
    		System.out.println("断开数据库成功");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public void startMyConnection() {
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		stmt = conn.createStatement();
    		System.out.println("连接数据库成功");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public String toString() {
    	return 	"数据库驱动程序"+JDBC_DRIVER+",链接地址"+DB_URL+"，用户名"+USER+"，密码"+PASS;
    }
}
