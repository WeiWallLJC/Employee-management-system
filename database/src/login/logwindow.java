//��¼����
package login;

import javax.swing.*;

import system.window;

import java.awt.*;
import java.awt.event.*;

public class logwindow extends JFrame{
	private ImageIcon img=new ImageIcon("src/img/img.jpg");
	
	userdatabase usdb=new userdatabase();
	public databaseOperation usdbop=new databaseOperation (usdb);
	private String text1;
	private String text2;
	Font font=new Font("����",Font.PLAIN,12);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new logwindow();
	}
	
	public logwindow()
	{
		JFrame f=new JFrame();
		GridBagLayout gb = new GridBagLayout();
		f.setLayout(gb);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill=GridBagConstraints.BOTH;
		gbc.weightx=1;
		
		JPanel pan1=new JPanel();//����һ���µİ���
		JLabel title=new JLabel("��ӭ��½Ա������ϵͳ");
		title.setFont(new Font("����",Font.BOLD, 25));
		pan1.add(title);
		f.add(pan1);
		JPanel empty3=new JPanel();
		f.add(empty3);
		JPanel empty5=new JPanel();
		f.add(empty5);
		JPanel empty6=new JPanel();
		f.add(empty6);
		//������ĵ�½����

		JPanel pan2=new JPanel();//����һ���µİ���
		JLabel name=new JLabel("�û���");
		pan2.add(name);
		TextField tf_name=new TextField(20);
		//tf_name.setText("���ڴ˴������û���");
		pan2.add(tf_name);
		f.add(pan2);
		//�û��������ı�������ڵڶ���������

		JPanel pan3=new JPanel();//����һ���µİ���
		JLabel pass = new JLabel("��    ��");
		pan3.add(pass);
		JPasswordField password=new JPasswordField(15);
		password.setEchoChar('*');
		pan3.add(password);
		JButton modifypsw=new JButton("�޸�����");
		modifypsw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifyPassword modifypassword=new modifyPassword();
			}
		});
		modifypsw.setFont(font);
		f.add(pan3);
		JPanel empty1=new JPanel();
		f.add(empty1);	
		f.add(modifypsw);
		JPanel empty2=new JPanel();
		f.add(empty2);
		JPanel empty4=new JPanel();
		f.add(empty4);
		JPanel empty7=new JPanel();
		f.add(empty7);
		JPanel empty8=new JPanel();
		f.add(empty8);
		
		JPanel pan4 = new JPanel();
		JButton b_log=new JButton("��½");
		pan4.add(b_log);
		b_log.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text1=tf_name.getText();
				text2=new String(password.getPassword());
				
				if(text1.isEmpty())
					JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "��ʾ", 2);
				else if(usdbop.selectName(text1)) {
					if(text2.isEmpty())
						JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "��ʾ", 2);
					else if(usdbop.selectPassword(text2)) {
						new window();
						f.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "�������", "��ʾ", 2);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "�޴��û� ��ע��", "��ʾ", 2);
				}
			}
		});
		JButton b_reg=new JButton("ע��");
		b_reg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				register reg=new register(f);
			}
		});
		pan4.add(b_reg);
		JButton b_exit=new JButton("�˳�");
		b_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);		
			}
		});
		pan4.add(b_exit); 
		f.add(pan4);
			
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(pan1, gbc);
		gb.setConstraints(empty3, gbc);
		gb.setConstraints(empty5, gbc);
		gb.setConstraints(empty6, gbc);
		gb.setConstraints(pan2, gbc);
		gb.setConstraints(pan3, gbc);
		gbc.gridwidth=3;
		gb.setConstraints(empty1, gbc);
		gb.setConstraints(modifypsw, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(empty2, gbc);
		gbc.gridwidth=1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(empty4, gbc);
		gb.setConstraints(empty7, gbc);
		gb.setConstraints(empty8, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(pan4, gbc);
		
		JLabel imglabel=new JLabel(img);
		f.getLayeredPane().add(imglabel,new Integer(Integer.MIN_VALUE));
		imglabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		JPanel panel=(JPanel)f.getContentPane();
		panel.setOpaque(false);
		pan1.setOpaque(false);
		pan2.setOpaque(false);
		pan3.setOpaque(false);
		pan4.setOpaque(false);
		empty1.setOpaque(false);
		empty2.setOpaque(false);
		empty3.setOpaque(false);
		empty4.setOpaque(false);
		empty5.setOpaque(false);
		empty6.setOpaque(false);
		empty7.setOpaque(false);
		empty8.setOpaque(false);
		//����͸����ʾ����ͼƬ
		
		f.setLocation(700,350);
		f.setSize(400,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
	}
}
