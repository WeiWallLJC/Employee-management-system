//�û����ݿ�
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
            // ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");
        
            // ������
            System.out.println("���ݿ�����������سɹ�");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            stmt = conn.createStatement();
            System.out.println("����user���ݿ�ɹ�\n");
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
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
    		System.out.println("�Ͽ����ݿ�ɹ�");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public void startMyConnection() {
    	try {
    		conn = DriverManager.getConnection(DB_URL,USER,PASS);
    		stmt = conn.createStatement();
    		System.out.println("�������ݿ�ɹ�");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public String toString() {
    	return 	"���ݿ���������"+JDBC_DRIVER+",���ӵ�ַ"+DB_URL+"���û���"+USER+"������"+PASS;
    }
}
