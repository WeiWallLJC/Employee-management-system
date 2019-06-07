//管理系统界面
package system;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class window extends JFrame{
	private ImageIcon img=new ImageIcon("src/img/img2.jpg");
	staffdatabase stfdb=new staffdatabase();
	public staffdatabaseOperation stfdbop=new staffdatabaseOperation(stfdb);
	private Vector data1=stfdbop.staffInfo();
	private Vector data2=stfdbop.getHead();
	JTable jtable;
	
	public static void main(String[] args) {
		new window();
	}
	
	public window() {
		JFrame f=new JFrame();
		f.setLayout(new BorderLayout());
		f.setTitle("员工管理系统");
		
		data1=stfdbop.staffInfo();
		DefaultTableModel tableModel = new DefaultTableModel(data1, data2);
		//表格
		jtable=new JTable(tableModel);
		//不可编辑
		jtable.setEnabled(false);
		JScrollPane scrollPane=new JScrollPane(jtable);
		JPanel pan1=new JPanel();
		f.add(scrollPane,BorderLayout.NORTH);		
		
		//按钮
		JButton bt1=new JButton("查找");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search search=new Search(f);
	    	}
		});
		JButton bt2=new JButton("新建");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create createwin=new create(f);
			}
		});
		JButton bt3=new JButton("删除");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete deletewin=new delete(f);
			}
		});
		JButton bt4=new JButton("修改");
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update updatewin=new update(f);	
			}
		});
		JButton bt6=new JButton("记录");
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				record rec=new record(f);
			}
		});
		JButton bt5=new JButton("退出");
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);		
			}
		});
		pan1.add(bt1);
		pan1.add(bt2);
		pan1.add(bt3);
		pan1.add(bt4);
		pan1.add(bt6);
		pan1.add(bt5);
		f.add(pan1);
		
		JLabel imglabel=new JLabel(img);
		f.getLayeredPane().add(imglabel,new Integer(Integer.MIN_VALUE));
		imglabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		JPanel panel=(JPanel)f.getContentPane();
		
		//设置透明
		pan1.setOpaque(false);
		panel.setOpaque(false);
		
		f.setLocation(400,200);
		f.setSize(800,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
	}
}
