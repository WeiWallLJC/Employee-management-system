package system;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Searchrs {
	private ImageIcon img=new ImageIcon("src/img/img3.jpg");
	staffdatabase stfdb=new staffdatabase();
	public staffdatabaseOperation stfdbop=new staffdatabaseOperation(stfdb);
	private Vector data1=stfdbop.staffInfo();
	private Vector data2=stfdbop.getHead();
	private Vector data;
	
	public Searchrs(JFrame w,String text1,String text2) {
		JDialog f=new JDialog(w,true);
		f.setLayout(new FlowLayout());
		f.setTitle("查找结果");
		
		data=stfdbop.searchInfo(text1,text2);
		DefaultTableModel tableModel = new DefaultTableModel(data, data2);
		table(tableModel);
		JPanel pan1=new JPanel();
		f.add(table(tableModel),BorderLayout.NORTH);		
		
		JLabel imglabel=new JLabel(img);
		f.getLayeredPane().add(imglabel,new Integer(Integer.MIN_VALUE));
		imglabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		JPanel panel=(JPanel)f.getContentPane();
		panel.setOpaque(false);
		pan1.setOpaque(false);
		
		JButton bt=new JButton("返回");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		f.add(bt,BorderLayout.SOUTH);
		bt.setOpaque(false);
		
		f.setLocation((int)w.getBounds().x+(int)w.getBounds().getWidth(), (int)w.getBounds().y);
		f.setSize((int)w.getBounds().getWidth()-300,(int)w.getBounds().getHeight());
		f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setResizable(false);
	}
	
	public JScrollPane table(DefaultTableModel tableModel) {
		//表格
		JTable jtable=new JTable(tableModel);
		//不可编辑
		jtable.setEnabled(false);
		JScrollPane scrollPane2=new JScrollPane(jtable);
		return scrollPane2;
	}
}