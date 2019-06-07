package system;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Search {
	private ImageIcon img=new ImageIcon("src/img/img3.jpg");
	staffdatabase stfdb=new staffdatabase();
	public staffdatabaseOperation stfdbop=new staffdatabaseOperation(stfdb);
	private String text1="";
	String text2="";
	
	public Search(JFrame w) {
		JDialog f=new JDialog(w,true);
		f.setLayout(new BorderLayout());
		String[] list= {"工号","姓名","部门"};
		f.setTitle("查找信息");
		
		JPanel pan1=new JPanel();
		JComboBox jcomboBox=new JComboBox(list);
		pan1.add(jcomboBox);
		TextField tf_name=new TextField(20);
		pan1.add(tf_name);
		f.add(pan1,BorderLayout.WEST);
		
		JButton confirm=new JButton("确认");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1=tf_name.getText();
				text2=(String)jcomboBox.getSelectedItem();
				if(text1.isEmpty())
					JOptionPane.showMessageDialog(null, "要查找的员工信息不能为空！", "提示", 2);
				else if(text2=="姓名"&&!stfdbop.selectName(text1))
					JOptionPane.showMessageDialog(null, "该信息不存在！", "提示", 2);
				else if(text2=="部门"&&!stfdbop.selectpart(text1))
					JOptionPane.showMessageDialog(null, "该信息不存在！", "提示", 2);
				else if(text2=="工号"&&!stfdbop.selectnum(text1))
					JOptionPane.showMessageDialog(null, "该信息不存在！", "提示", 2);
				else
				{
					f.dispose();
					Searchrs searchrs=new Searchrs(w,text1,text2);
				}
			}
		});
		f.add(confirm,BorderLayout.EAST);
		
		JLabel imglabel=new JLabel(img);
		f.getLayeredPane().add(imglabel,new Integer(Integer.MIN_VALUE));
		imglabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		JPanel panel=(JPanel)f.getContentPane();
		panel.setOpaque(false);
		pan1.setOpaque(false);
		confirm.setOpaque(false);
		
		f.setLocation(700,350);
		f.setSize(400,75);
		f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setResizable(false);
	}
}
