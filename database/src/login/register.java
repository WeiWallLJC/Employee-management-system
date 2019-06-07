package login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import system.staffdatabase;
import system.staffdatabaseOperation;

public class register {
	userdatabase usdb=new userdatabase();
	public databaseOperation usdbop=new databaseOperation(usdb);
	String text1="";
	String text2="";
	String text3="";
	private ImageIcon img=new ImageIcon("src/img/img4.jpg");
	
	public register(JFrame e) {
		JDialog f=new JDialog(e,true);
		GridBagLayout gb = new GridBagLayout();
		f.setLayout(gb);
		GridBagConstraints gbc = new GridBagConstraints();
		
		JPanel pan1=new JPanel();
		JLabel name=new JLabel(" 用户名");
		pan1.add(name);
		TextField tf_name=new TextField(20);
		pan1.add(tf_name);
		f.add(pan1);

		JPanel pan2=new JPanel();
		JLabel password = new JLabel(" 密    码");
		pan2.add(password);
		JPasswordField psw=new JPasswordField(15);
		psw.setEchoChar('*');
		pan2.add(psw);
		f.add(pan2);
		
		JPanel pan3=new JPanel();
		JLabel password2 = new JLabel("重复密码");
		pan3.add(password2);
		JPasswordField psw2=new JPasswordField(15);
		psw2.setEchoChar('*');
		pan3.add(psw2);
		f.add(pan3);
		
		JButton confirm=new JButton("确认");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1=tf_name.getText();
				text2=new String(psw.getPassword());
				text3=new String(psw2.getPassword());
				
				if(text1.isEmpty())
					JOptionPane.showMessageDialog(null, "用户名不能为空！", "提示", 2);
				else if(text2.isEmpty()||text3.isEmpty())
					JOptionPane.showMessageDialog(null, "密码不能为空！", "提示", 2);
				else if(usdbop.selectName(text1))
					JOptionPane.showMessageDialog(null, "该用户名已被使用！", "提示", 2);
				else if(!text2.equals(text3))
					JOptionPane.showMessageDialog(null, "两次输入密码不同！", "提示", 2);
				else if(!usdbop.selectName(text1) && text2.equals(text3)){
					usdbop.insertData(text1,text2);
					JOptionPane.showMessageDialog(null, "注册成功！", "提示", 2);
					logwindow lg=new logwindow();
					f.dispose();
				}
			}
		});
		JPanel empty1=new JPanel();
		f.add(empty1);	
		JPanel empty2=new JPanel();
		f.add(empty2);
		f.add(confirm);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(pan1, gbc);
		gb.setConstraints(pan2, gbc);
		gb.setConstraints(pan3, gbc);
		gb.setConstraints(empty1, gbc);
		gb.setConstraints(empty2, gbc);
		gb.setConstraints(confirm, gbc);
		
		JLabel imglabel=new JLabel(img);
		f.getLayeredPane().add(imglabel,new Integer(Integer.MIN_VALUE));
		imglabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		JPanel panel=(JPanel)f.getContentPane();
		panel.setOpaque(false);
		pan1.setOpaque(false);
		pan2.setOpaque(false);
		pan3.setOpaque(false);
		empty1.setOpaque(false);
		empty2.setOpaque(false);
		confirm.setOpaque(false);
		
		f.setLocation(700,350);
		f.setSize(400,300);
		f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setResizable(false);
	}
}
