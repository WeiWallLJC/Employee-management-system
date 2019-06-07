//����ϵͳ����
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
		f.setTitle("Ա������ϵͳ");
		
		data1=stfdbop.staffInfo();
		DefaultTableModel tableModel = new DefaultTableModel(data1, data2);
		//���
		jtable=new JTable(tableModel);
		//���ɱ༭
		jtable.setEnabled(false);
		JScrollPane scrollPane=new JScrollPane(jtable);
		JPanel pan1=new JPanel();
		f.add(scrollPane,BorderLayout.NORTH);		
		
		//��ť
		JButton bt1=new JButton("����");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search search=new Search(f);
	    	}
		});
		JButton bt2=new JButton("�½�");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create createwin=new create(f);
			}
		});
		JButton bt3=new JButton("ɾ��");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete deletewin=new delete(f);
			}
		});
		JButton bt4=new JButton("�޸�");
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update updatewin=new update(f);	
			}
		});
		JButton bt6=new JButton("��¼");
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				record rec=new record(f);
			}
		});
		JButton bt5=new JButton("�˳�");
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
		
		//����͸��
		pan1.setOpaque(false);
		panel.setOpaque(false);
		
		f.setLocation(400,200);
		f.setSize(800,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
	}
}
