package system;

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

public class Modify {
	private ImageIcon img=new ImageIcon("src/img/img3.jpg");
	staffdatabase stfdb=new staffdatabase();
	public staffdatabaseOperation stfdbop=new staffdatabaseOperation(stfdb);
	String text1="";
	String text2="";
	String text3="";
	String text4="";
	String text5="";
	String text6="";
	String text7="";
	
	public Modify(String text,JFrame w,String textn) {
		JDialog f=new JDialog(w,true);
		GridBagLayout gb = new GridBagLayout();
		f.setLayout(gb);
		GridBagConstraints gbc = new GridBagConstraints();
		f.setTitle("修改信息");
		
		JPanel pan1=new JPanel();
		JLabel num=new JLabel("工号");
		pan1.add(num);
		TextField tf_num=new TextField(20);
		pan1.add(tf_num);
		f.add(pan1);

		JPanel pan2=new JPanel();
		JLabel name = new JLabel("姓名");
		pan2.add(name);
		TextField tf_name=new TextField(20);
		pan2.add(tf_name);
		f.add(pan2);
		
		JPanel pan3=new JPanel();
		JLabel sex = new JLabel("性别");
		pan3.add(sex);
		TextField tf_sex=new TextField(20);
		pan3.add(tf_sex);
		f.add(pan3);
		
		JPanel pan4=new JPanel();
		JLabel age = new JLabel("年龄");
		pan4.add(age);
		TextField tf_age=new TextField(20);
		pan4.add(tf_age);
		f.add(pan4);
		
		JPanel pan5=new JPanel();
		JLabel part = new JLabel("部门");
		pan5.add(part);
		TextField tf_part=new TextField(20);
		pan5.add(tf_part);
		f.add(pan5);
		
		JPanel pan6=new JPanel();
		JLabel job = new JLabel("职务");
		pan6.add(job);
		TextField tf_job=new TextField(20);
		pan6.add(tf_job);
		f.add(pan6);
		
		JPanel pan7=new JPanel();
		JLabel phone = new JLabel("电话");
		pan7.add(phone);
		TextField tf_phone=new TextField(20);
		pan7.add(tf_phone);
		f.add(pan7);
		
		JButton confirm=new JButton("确认");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1=tf_num.getText();
				text2=tf_name.getText();
				text3=tf_sex.getText();
				text4=tf_age.getText();
				text5=tf_part.getText();
				text6=tf_job.getText();
				text7=tf_phone.getText();
				if(text1.isEmpty())
					JOptionPane.showMessageDialog(null, "员工姓名不能为空！", "提示", 2);
				else if(text1.isEmpty())
					JOptionPane.showMessageDialog(null, "员工职位不能为空！", "提示", 2);
				else
				{
					stfdbop.update(text1,text2,text3,text4,text5,text6,text7,text,textn);
					JOptionPane.showMessageDialog(null, "修改信息成功！", "提示", 2);
					w.dispose();
					window wind=new window();
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
		gb.setConstraints(pan4, gbc);
		gb.setConstraints(pan5, gbc);
		gb.setConstraints(pan6, gbc);
		gb.setConstraints(pan7, gbc);
		gbc.gridwidth=3;
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
		pan4.setOpaque(false);
		pan5.setOpaque(false);
		pan6.setOpaque(false);
		pan7.setOpaque(false);
		empty1.setOpaque(false);
		empty2.setOpaque(false);
		confirm.setOpaque(false);
		
		f.setLocation(700,350);
		f.setSize(350,300);
		f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setResizable(false);
	}
}
