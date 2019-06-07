//Ա����Ϣ���ݿ���ز�������
package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import login.userdatabase;

public class staffdatabaseOperation {
	private staffdatabase mystfDB=null;
	private Connection conn=null;
	private Statement stmt=null;
	private int number1=0;
	private int number2=0;
	private String name;
	private String job;
	private String id;
	
	public staffdatabaseOperation(staffdatabase myDB){
		conn=myDB.getMyConnection();//ȡ�ö���
		stmt=myDB.getMyStatement();//ȡ��sql���
	}
	
	public Vector record() {
		PreparedStatement preparedStatement = null;

		Vector rows = null;
		Vector columnHeads = null;
		try {
			preparedStatement = conn.prepareStatement("select * from staffop");
			ResultSet result1 = preparedStatement.executeQuery();
			
			if(result1.wasNull())
				JOptionPane.showMessageDialog(null, "��������޼�¼");
			
			rows = new Vector();
			
			ResultSetMetaData rsmd = result1.getMetaData();
					
			while(result1.next()){
				rows.addElement(getNextRow(result1,rsmd));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("δ�ɹ������ݿ⡣");
			e.printStackTrace();
		}
		return rows;
	}
	
	public Vector staffInfo() {
		PreparedStatement preparedStatement = null;

		Vector rows = null;
		Vector columnHeads = null;
		try {
			preparedStatement = conn.prepareStatement("select * from staff");
			ResultSet result1 = preparedStatement.executeQuery();
			
			if(result1.wasNull())
				JOptionPane.showMessageDialog(null, "��������޼�¼");
			
			rows = new Vector();
			
			ResultSetMetaData rsmd = result1.getMetaData();
					
			while(result1.next()){
				rows.addElement(getNextRow(result1,rsmd));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("δ�ɹ������ݿ⡣");
			e.printStackTrace();
		}
		return rows;
	}
	
	public Vector searchInfo(String text,String text2) {
		PreparedStatement preparedStatement = null;

		Vector rows = null;
		Vector columnHeads = null;
		try {
			ResultSet result1 = null;
			if(text2=="����") {
				preparedStatement = conn.prepareStatement("select ����,����,�Ա�,����,����,ְ��,�绰 from staff where ����='"+text+"'");
				result1 = preparedStatement.executeQuery();
			}
			else if(text2=="����") {
				preparedStatement = conn.prepareStatement("select ����,����,�Ա�,����,����,ְ��,�绰 from staff where ����='"+text+"'");
				result1 = preparedStatement.executeQuery();
			}
			else if(text2=="����") {
				preparedStatement = conn.prepareStatement("select ����,����,�Ա�,����,����,ְ��,�绰 from staff where ����='"+text+"'");
				result1 = preparedStatement.executeQuery();
			}
			
			if(result1.wasNull())
				JOptionPane.showMessageDialog(null, "��������޼�¼");
			
			rows = new Vector();
			
			ResultSetMetaData rsmd = result1.getMetaData();
					
			while(result1.next()){
				rows.addElement(getNextRow(result1,rsmd));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("δ�ɹ������ݿ⡣");
			e.printStackTrace();
		}
		return rows;
	}
	
	private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
		Vector currentRow = new Vector();
		for(int i = 1; i <= rsmd.getColumnCount(); i++){
			currentRow.addElement(rs.getString(i));
		}
		return currentRow;
	}
	
	public Vector getopHead() {
		String sql="SELECT * FROM staffop";
		Vector columnHeads = null;
		try {
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			columnHeads = new Vector();
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++)
				columnHeads.addElement(rsmd.getColumnName(i));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return columnHeads;
	}
	
	public Vector getHead() {
		String sql="SELECT * FROM staff";
		Vector columnHeads = null;
		try {
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			columnHeads = new Vector();
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++)
				columnHeads.addElement(rsmd.getColumnName(i));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return columnHeads;
	}
	
	public void create(String num,String name,String sex,String age,String part,String job,String phone) {
		try{
			String newType1=new String(num.getBytes(),"GBK");//�ֽ�ת��
			String newType2=new String(name.getBytes(),"GBK");
			String newType3=new String(sex.getBytes(),"GBK");
			String newType4=new String(age.getBytes(),"GBK");
			String newType5=new String(part.getBytes(),"GBK");
			String newType6=new String(job.getBytes(),"GBK");
			String newType7=new String(phone.getBytes(),"GBK");
			String sql="INSERT INTO staff(����,����,�Ա�,����,����,ְ��,�绰)VALUES('"+newType1+"','"+newType2+"','"+newType3+"','"+newType4+"','"+newType5+"','"+newType6+"','"+newType7+"')";
			stmt.executeUpdate(sql);//�������
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	
	public void delete(String mname,String text){
		String sql=null;
		if(text=="����")
			sql="DELETE FROM staff WHERE ����='"+mname+"'";
		else if(text=="����")
			sql="DELETE FROM staff WHERE ����='"+mname+"'";
		else if(text=="����")
			sql="DELETE FROM staff WHERE ����='"+mname+"'";
		try{
			stmt.executeUpdate(sql);
			//System.out.println("һ����¼��ɾ��");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void update(String num,String name,String sex,String age,String part,String job,String phone,String bname,String textn) {
		String sql=null;
		if (textn=="����")
			sql="UPDATE staff SET ����='"+name+"',ְ��='"+job+"',����='"+num+"',�Ա�='"+sex+"',����='"+age+"',����='"+part+"',�绰='"+phone+"' where ����='"+bname+"'";
		if (textn=="����")
			sql="UPDATE staff SET ����='"+name+"',ְ��='"+job+"',����='"+num+"',�Ա�='"+sex+"',����='"+age+"',����='"+part+"',�绰='"+phone+"' where ����='"+bname+"'";
		try{
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public boolean selectName(String mname){//��ѯid
		String sql="SELECT ���� FROM staff";
		try{
			number1=0;
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			while(rs.next()){//ָ������ƶ�
				name=rs.getString("����");
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
	
	public boolean selectId(String mname){//��ѯid
		String sql="SELECT ���� FROM staff";
		try{
			number1=0;
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			while(rs.next()){//ָ������ƶ�
				id=rs.getString("����");
				number1++;
				if(id.equals(mname)){
					//System.out.print("number1:"+number1);
					return true;
				}
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean selectpart(String mname){//��ѯid
		String sql="SELECT ���� FROM staff";
		try{
			number1=0;
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			while(rs.next()){//ָ������ƶ�
				name=rs.getString("����");
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
	
	public boolean selectnum(String mname){//��ѯid
		String sql="SELECT ���� FROM staff";
		try{
			number1=0;
			ResultSet rs=stmt.executeQuery(sql);//���ؽ����
			while(rs.next()){//ָ������ƶ�
				name=rs.getString("����");
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
}
