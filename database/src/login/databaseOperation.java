//�û����ݿ���ز�������
package login;

import java.sql.*;

public class databaseOperation {
	private userdatabase myDB=null;
	private Connection conn=null;
	private Statement stmt=null;
	private int number1=0;
	private int number2=0;
	private String name;
	private String password;
	
	public databaseOperation(userdatabase myDB){
		conn=myDB.getMyConnection();//ȡ�ö���
		stmt=myDB.getMyStatement();//ȡ��sql���
	}
	
	public void insertData(String name,String password){
		try{
			String newType1=new String(name.getBytes(),"GBK");//�ֽ�ת��
			String newType2=new String(password.getBytes(),"GBK");
			String sql="INSERT INTO user(username,password)VALUES('"+newType1+"','"+newType2+"')";
			stmt.executeUpdate(sql);//�������
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	
	public void deleteData(String mname){
		String sql="DELETE FROM user WHERE username='"+mname+"'";
		try{
			stmt.executeUpdate(sql);
			//System.out.println("һ����¼��ɾ��");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public boolean  selectPassword(String mpassword){//��ѯ����
		String sql="SELECT username,password FROM user";
		try{
			number2=0;
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			while(rs.next()){//ָ������ƶ�
				password=rs.getString("password");
				number2++;
				//System.out.print(rs.getString("password")+"  ");
				if(password.equals(mpassword)&&(number2==number1)){
					//System.out.print("number2:"+number2);
					return true;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean selectName(String mname){//��ѯid
		String sql="SELECT username,password FROM user";
		try{
			number1=0;
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			while(rs.next()){//ָ������ƶ�
				name=rs.getString("username");
				number1++;
				if(name.equals(mname)){
					//System.out.print("number1:"+number1);
					return true;
				}
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public String getName(){
		return name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setNumber1(){
		number1=0;
	}
	
	public void setNumber2(){
		number2=0;
	}
}
