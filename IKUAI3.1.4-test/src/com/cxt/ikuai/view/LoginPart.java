package com.cxt.ikuai.view;
import java.awt.Dimension;
 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.cxt.ikuai.controller.AdminPropertyReader;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
 //1.����Login�࣬
public class LoginPart implements InitUI {
	JTextField textName = new JTextField();
	JPasswordField textPass=new JPasswordField();
	JFrame frmScreen = new JFrame();
	public void Initial(){
	   frmScreen.setResizable(false);
		// 3.��initUI�����У�ʵ����JFrame��Ķ���
		ImageIcon icon = new ImageIcon("image/logo.png");
		frmScreen.setIconImage(icon.getImage());
		frmScreen.getContentPane().setForeground(Color.BLACK);
		frmScreen.setForeground(Color.WHITE);
		// 4.���ô�����������ֵ�����⡢��С����ʾλ�á��رղ��������֡���ֹ������С���ɼ���...
		frmScreen.setTitle("\u7BA1\u7406\u5458\u767B\u9646");// ���ô���ı���
		frmScreen.setSize(500, 365);// ���ô���Ĵ�С����λ������
		frmScreen.setDefaultCloseOperation(2);// ���ô���Ĺرղ�����3��ʾ�رմ����˳�����2��1��0
		frmScreen.setLocationRelativeTo(null);// ���ô����������һ������ľ���λ�ã�����null��ʾ�����������Ļ������λ��
		frmScreen.setResizable(false);
			
	 
			// 5.ʵ����Ԫ��������󣬽�Ԫ�����������ӵ������ϣ�������Ҫ�ڴ���ɼ�֮ǰ��ɣ���
		// ʵ����ImageIconͼ����Ķ��󣬸ö�����ش����ϵ�ͼƬ�ļ����ڴ��У������·��Ҫ������\
		// �ñ�ǩ������ͼƬ��ʵ����JLabel��ǩ���󣬸ö�����ʾiconͼ��
		JLabel labIcon = new JLabel(icon);
		labIcon.setBounds(129, 13, 265, 65);
		//���ñ�ǩ��С
		//labIcon.setSize(30,20);setSize����ֻ�Դ�����Ч���������������Ĵ�Сֻ����
		Dimension dim = new Dimension(400,65);
		frmScreen.getContentPane().setLayout(null);
		labIcon.setPreferredSize(dim);
		// ��labIcon��ǩ��ӵ�������
			frmScreen.getContentPane().add(labIcon);
	 
			
			// ʵ����JLabel��ǩ���󣬸ö�����ʾ"�˺ţ�"
		JLabel labName = new JLabel("User\uFF1A");
		labName.setFont(new Font("����", Font.PLAIN, 20));
		labName.setBounds(119, 106, 60, 47);
		// ��labName��ǩ��ӵ�������
			frmScreen.getContentPane().add(labName);
	 
			// ʵ����JTextField��ǩ����
		textName.setBounds(178, 116, 216, 30);
		Dimension dim1 = new Dimension(330,30);
		//textName.setSize(dim);//setSize�ⷽ��ֻ�Զ���������Ч���������ʹ����Ч��
		textName.setPreferredSize(dim1);//���ó��������������������Ĵ�С
		// ��textName��ǩ��ӵ�������
			frmScreen.getContentPane().add(textName);
	 
			//ʵ����JLabel��ǩ���󣬸ö�����ʾ"���룺"
		JLabel labpass= new JLabel("Pass:");
		labpass.setFont(new Font("����", Font.PLAIN, 20));
		labpass.setBounds(119, 174, 73, 39);
		//��labpass��ǩ��ӵ�������
		frmScreen.getContentPane().add(labpass);
		
		
		//ʵ����JPasswordField
		textPass.setBounds(178, 180, 216, 30);
		//���ô�С
		textPass.setPreferredSize(dim1);//���������С
		//���textword��������
		frmScreen.getContentPane().add(textPass);
		//���ð�ť����ʾ����
		Dimension dim2 = new Dimension(200,30);
		
		JButton btnNewButton = new JButton("\u9000 \u51FA");
		btnNewButton.setFont(new Font("����", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmScreen.dispose();
			}
		});
		btnNewButton.setBounds(317, 266, 93, 27);
		frmScreen.getContentPane().add(btnNewButton);
	}
	/**
	 * @wbp.parser.constructor
	 */
	public LoginPart() {
		this.Initial();
		JButton btnNewButton_1 = new JButton("\u767B \u5F55");
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().equals(AdminPropertyReader.getProperty("username"))&&AdminPropertyReader.getProperty("password").equals(String.valueOf(textPass.getPassword()))){
					ChangePass cp = new ChangePass();
					cp.UI();
					frmScreen.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "          ��¼ʧ�ܣ�", "ERROR", JOptionPane.ERROR_MESSAGE);
					textName.setText("");
					textPass.setText("");
				}
			}
		});
	btnNewButton_1.setBounds(80, 266, 94, 27);
	frmScreen.getContentPane().add(btnNewButton_1);
	frmScreen.setVisible(true);// ���ô���Ϊ�ɼ�
	}
	public LoginPart(Index in) {
		this.Initial();
		JButton btnNewButton_1 = new JButton("�� ¼");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().equals(AdminPropertyReader.getProperty("username"))&&AdminPropertyReader.getProperty("password").equals(String.valueOf(textPass.getPassword()))){
					FunctionManage fm = new FunctionManage(in);
					frmScreen.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "          ��¼ʧ�ܣ�", "ERROR", JOptionPane.ERROR_MESSAGE);
					textName.setText("");
					textPass.setText("");
				}
			}
		});
	
	btnNewButton_1.setBounds(80, 266, 94, 27);
	frmScreen.getContentPane().add(btnNewButton_1);
	frmScreen.setVisible(true);// ���ô���Ϊ�ɼ�
	}
	public LoginPart(String sign) {
		this.Initial();
		JButton btnNewButton_1 = new JButton("�� ¼");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().equals(AdminPropertyReader.getProperty("username"))&&AdminPropertyReader.getProperty("password").equals(String.valueOf(textPass.getPassword()))){
					ArpIndex ab = new ArpIndex();
					frmScreen.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "          ��¼ʧ�ܣ�", "ERROR", JOptionPane.ERROR_MESSAGE);
					textName.setText("");
					textPass.setText("");
				}
			}
		});
	btnNewButton_1.setBounds(80, 266, 94, 27);
	frmScreen.getContentPane().add(btnNewButton_1);
	frmScreen.setVisible(true);// ���ô���Ϊ�ɼ�
	}
	@Override
	public void UI() {
		// TODO Auto-generated method stub
		BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
	    try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
