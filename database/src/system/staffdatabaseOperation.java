//员工信息数据库相关操作函数
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
		conn=myDB.getMyConnection();//取得对象
		stmt=myDB.getMyStatement();//取得sql语句
	}
	
	public Vector record() {
		PreparedStatement preparedStatement = null;

		Vector rows = null;
		Vector columnHeads = null;
		try {
			preparedStatement = conn.prepareStatement("select * from staffop");
			ResultSet result1 = preparedStatement.executeQuery();
			
			if(result1.wasNull())
				JOptionPane.showMessageDialog(null, "结果集中无记录");
			
			rows = new Vector();
			
			ResultSetMetaData rsmd = result1.getMetaData();
					
			while(result1.next()){
				rows.addElement(getNextRow(result1,rsmd));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功打开数据库。");
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
				JOptionPane.showMessageDialog(null, "结果集中无记录");
			
			rows = new Vector();
			
			ResultSetMetaData rsmd = result1.getMetaData();
					
			while(result1.next()){
				rows.addElement(getNextRow(result1,rsmd));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功打开数据库。");
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
			if(text2=="工号") {
				preparedStatement = conn.prepareStatement("select 工号,姓名,性别,年龄,部门,职务,电话 from staff where 工号='"+text+"'");
				result1 = preparedStatement.executeQuery();
			}
			else if(text2=="姓名") {
				preparedStatement = conn.prepareStatement("select 工号,姓名,性别,年龄,部门,职务,电话 from staff where 姓名='"+text+"'");
				result1 = preparedStatement.executeQuery();
			}
			else if(text2=="部门") {
				preparedStatement = conn.prepareStatement("select 工号,姓名,性别,年龄,部门,职务,电话 from staff where 部门='"+text+"'");
				result1 = preparedStatement.executeQuery();
			}
			
			if(result1.wasNull())
				JOptionPane.showMessageDialog(null, "结果集中无记录");
			
			rows = new Vector();
			
			ResultSetMetaData rsmd = result1.getMetaData();
					
			while(result1.next()){
				rows.addElement(getNextRow(result1,rsmd));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功打开数据库。");
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
			ResultSet rs=stmt.executeQuery(sql);//返回结果集
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
			ResultSet rs=stmt.executeQuery(sql);//返回结果集
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
			String newType1=new String(num.getBytes(),"GBK");//字节转码
			String newType2=new String(name.getBytes(),"GBK");
			String newType3=new String(sex.getBytes(),"GBK");
			String newType4=new String(age.getBytes(),"GBK");
			String newType5=new String(part.getBytes(),"GBK");
			String newType6=new String(job.getBytes(),"GBK");
			String newType7=new String(phone.getBytes(),"GBK");
			String sql="INSERT INTO staff(工号,姓名,性别,年龄,部门,职务,电话)VALUES('"+newType1+"','"+newType2+"','"+newType3+"','"+newType4+"','"+newType5+"','"+newType6+"','"+newType7+"')";
			stmt.executeUpdate(sql);//更新语句
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	
	public void delete(String mname,String text){
		String sql=null;
		if(text=="姓名")
			sql="DELETE FROM staff WHERE 姓名='"+mname+"'";
		else if(text=="部门")
			sql="DELETE FROM staff WHERE 部门='"+mname+"'";
		else if(text=="工号")
			sql="DELETE FROM staff WHERE 工号='"+mname+"'";
		try{
			stmt.executeUpdate(sql);
			//System.out.println("一条记录被删除");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void update(String num,String name,String sex,String age,String part,String job,String phone,String bname,String textn) {
		String sql=null;
		if (textn=="姓名")
			sql="UPDATE staff SET 姓名='"+name+"',职务='"+job+"',工号='"+num+"',性别='"+sex+"',年龄='"+age+"',部门='"+part+"',电话='"+phone+"' where 姓名='"+bname+"'";
		if (textn=="工号")
			sql="UPDATE staff SET 姓名='"+name+"',职务='"+job+"',工号='"+num+"',性别='"+sex+"',年龄='"+age+"',部门='"+part+"',电话='"+phone+"' where 工号='"+bname+"'";
		try{
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public boolean selectName(String mname){//查询id
		String sql="SELECT 姓名 FROM staff";
		try{
			number1=0;
			ResultSet rs=stmt.executeQuery(sql);//返回结果集
			while(rs.next()){//指针向后移动
				name=rs.getString("姓名");
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
	
	public boolean selectId(String mname){//查询id
		String sql="SELECT 工号 FROM staff";
		try{
			number1=0;
			ResultSet rs=stmt.executeQuery(sql);//返回结果集
			while(rs.next()){//指针向后移动
				id=rs.getString("工号");
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
	
	public boolean selectpart(String mname){//查询id
		String sql="SELECT 部门 FROM staff";
		try{
			number1=0;
			ResultSet rs=stmt.executeQuery(sql);//返回结果集
			while(rs.next()){//指针向后移动
				name=rs.getString("部门");
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
	
	public boolean selectnum(String mname){//查询id
		String sql="SELECT 工号 FROM staff";
		try{
			number1=0;
			ResultSet rs=stmt.executeQuery(sql);//返回结果集
			while(rs.next()){//指针向后移动
				name=rs.getString("工号");
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
