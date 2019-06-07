package login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import system.staffdatabase;
import system.staffdatabaseOperation;

public class modifyPassword {
	private ImageIcon img=new ImageIcon("src/img/img4.jpg");
	userdatabase usdb=new userdatabase();
	public databaseOperation usdbop=new databaseOperation (usdb);
	private String text1="";
	private	String text2="";
	private String text3="";
	
	public modifyPassword() {
		JFrame f=new JFrame();
		GridBagLayout gb = new GridBagLayout();
		f.setLayout(gb);
		GridBagConstraints gbc = new GridBagConstraints();
		
		JPanel pan1=new JPanel();
		JLabel user=new JLabel("用户名");
		pan1.add(user);
		TextField tf_user=new TextField(20);
		pan1.add(tf_user);
		f.add(pan1);
		
		JPanel pan2=new JPanel();//生成一个新的版面
		JLabel pass = new JLabel("原密码");
		pan2.add(pass);
		JPasswordField password=new JPasswordField(15);
		password.setEchoChar('*');
		pan2.add(password);
		f.add(pan2);
		
		JPanel pan3=new JPanel();//生成一个新的版面
		JLabel pass2 = new JLabel("新密码");
		pan3.add(pass2);
		JPasswordField password2=new JPasswordField(15);
		password2.setEchoChar('*');
		pan3.add(password2);
		f.add(pan3);

		JButton confirm=new JButton("确认");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1=tf_user.getText();
				text2=new String(password.getPassword());
				text3=new String(password2.getPassword());
				if(text1.isEmpty())
					JOptionPane.showMessageDialog(null, "用户名不能为空！", "提示", 2);
				else if(text2.isEmpty())
					JOptionPane.showMessageDialog(null, "原密码不能为空！", "提示", 2);
				else if(text3.isEmpty())
					JOptionPane.showMessageDialog(null, "新密码不能为空！", "提示", 2);
				else if(!usdbop.selectName(text1))
					JOptionPane.showMessageDialog(null, "无此用户！", "提示", 2);
				else if(usdbop.selectName(text1))
				{
					if(text2.equals(text3))
						JOptionPane.showMessageDialog(null, "新密码不能与原密码相同！", "提示", 2);
					else if(usdbop.selectPassword(text2)) {
						usdbop.deleteData(text1);
						usdbop.insertData(text1, text3);
						JOptionPane.showMessageDialog(null, "修改密码成功！", "提示", 2);
						f.dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "原密码错误！", "提示", 2);
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
