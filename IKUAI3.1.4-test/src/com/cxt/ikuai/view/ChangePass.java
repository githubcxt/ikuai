package com.cxt.ikuai.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.cxt.ikuai.controller.AdminPropertyReader;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePass extends JFrame implements InitUI {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Create the frame.
	 */
	public ChangePass() {
		JFrame frmScreen = new JFrame();
	    this.setResizable(false);
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
		//���ñ�ǩ��С
		//labIcon.setSize(30,20);setSize����ֻ�Դ�����Ч���������������Ĵ�Сֻ����
		frmScreen.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(189, 64, 221, 24);
		frmScreen.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 127, 221, 24);
		frmScreen.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 191, 221, 24);
		frmScreen.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		frmScreen.getContentPane().add(textField);
		frmScreen.getContentPane().add(textField_1);
		frmScreen.getContentPane().add(textField_2);
		
		lblNewLabel = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBounds(69, 65, 86, 18);
		frmScreen.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(69, 128, 94, 18);
		frmScreen.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(69, 192, 108, 18);
		frmScreen.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u751F\u6548");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(textField.getText().equals(AdminPropertyReader.getProperty("password"))){
					if(textField.getText().equals(textField_1.getText())||textField.getText().equals(textField_2.getText())){
						JOptionPane.showMessageDialog(null, "       �¾�������ͬ��", "�޸�ʧ��", JOptionPane.ERROR_MESSAGE);
					}
					else if(textField_1.getText().equals(textField_2.getText())&&textField_1.getText().length()!=0){
						JOptionPane.showMessageDialog(null, "                      �޸ĳɹ���", "�޸ĳɹ�", JOptionPane.PLAIN_MESSAGE);
						AdminPropertyReader.setProperty("password",textField_1.getText());
						frmScreen.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "    ���������벻ͬ/Ϊ�գ�", "�޸�ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "       ���������", "�޸�ʧ��", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 18));
		btnNewButton.setBounds(61, 268, 113, 27);
		frmScreen.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmScreen.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 18));
		btnNewButton_1.setBounds(297, 268, 113, 27);
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
