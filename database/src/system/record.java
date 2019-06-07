package system;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class record {
	private ImageIcon img=new ImageIcon("src/img/img3.jpg");
	staffdatabase stfdb=new staffdatabase();
	public staffdatabaseOperation stfdbop=new staffdatabaseOperation(stfdb);
	private Vector data2=stfdbop.getopHead();
	private Vector data;
	
	public record(JFrame w) {
		JDialog f=new JDialog(w,true);
		GridBagLayout gb = new GridBagLayout();
		f.setLayout(gb);
		GridBagConstraints gbc = new GridBagConstraints();
		f.setResizable(false);
		f.setTitle("操作记录");
		
		data=stfdbop.record();
		DefaultTableModel tableModel = new DefaultTableModel(data, data2);
		table(tableModel);
		JPanel pan1=new JPanel();
		f.add(table(tableModel));		
		
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
		JPanel empty1=new JPanel();
		f.add(empty1);	
		f.add(bt);
		empty1.setOpaque(false);
		bt.setOpaque(false);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(pan1, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(empty1, gbc);
		gb.setConstraints(bt, gbc);
		
		f.setLocation((int)w.getBounds().x+(int)w.getBounds().getWidth(), (int)w.getBounds().y);
		f.setSize((int)w.getBounds().getWidth()-200,(int)w.getBounds().getHeight());
		f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setResizable(false);
	}
	
	public JScrollPane table(DefaultTableModel tableModel) {
		//表格
		JTable jtable=new JTable(tableModel);
		//不可编辑
		jtable.setEnabled(false);
		jtable.getColumnModel().getColumn(0).setPreferredWidth(150);
		jtable.getColumnModel().getColumn(1).setPreferredWidth(150);
		jtable.getColumnModel().getColumn(2).setPreferredWidth(80);
		jtable.getColumnModel().getColumn(3).setPreferredWidth(80);
		jtable.getColumnModel().getColumn(4).setPreferredWidth(150);
		jtable.getColumnModel().getColumn(5).setPreferredWidth(150);
		jtable.getColumnModel().getColumn(6).setPreferredWidth(150);
		jtable.getColumnModel().getColumn(7).setPreferredWidth(150);
		jtable.getColumnModel().getColumn(8).setPreferredWidth(500);
		JScrollPane scrollPane2=new JScrollPane(jtable);
		return scrollPane2;
	}
}