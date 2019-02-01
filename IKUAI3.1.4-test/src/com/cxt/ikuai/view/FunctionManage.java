package com.cxt.ikuai.view;


import javax.swing.JFrame;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.cxt.ikuai.controller.ACLPropertyReader;
import com.cxt.ikuai.model.GetACLComments;
import com.cxt.ikuai.model.MyURL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FunctionManage extends JFrame implements InitUI {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public static String s[];
	public static String status = Index.jhh.sendPost(MyURL.ACLManage, Index.cookie,Index.acl.GetShowAclJson());
	public FunctionManage(Index in) {
		UI();
		JFrame frmScreen = new JFrame();
	    this.setResizable(false);
        this.setDefaultCloseOperation(2);
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
		frmScreen.getContentPane().setLayout(null);
 
		
		// ʵ����JLabel��ǩ���󣬸ö�����ʾ"�˺ţ�"
		JLabel labName = new JLabel("\u529F \u80FD 1:");
		labName.setBounds(31, 30, 86, 37);
		labName.setFont(new Font("����", Font.PLAIN, 20));
		// ��labName��ǩ��ӵ�������
		frmScreen.getContentPane().add(labName);
 
		//ʵ����JLabel��ǩ���󣬸ö�����ʾ"���룺"
		JLabel labpass= new JLabel("\u529F \u80FD 2:");
		labpass.setBounds(31, 80, 86, 44);
		labpass.setFont(new Font("����", Font.PLAIN, 20));
		//��labpass��ǩ��ӵ�������
		frmScreen.getContentPane().add(labpass);
		//���ð�ť����ʾ����
		
		JLabel lblNewLabel = new JLabel("\u529F \u80FD 3:");
		lblNewLabel.setBounds(31, 137, 86, 40);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		frmScreen.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u529F \u80FD 4:");
		lblNewLabel_1.setBounds(31, 200, 86, 24);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		frmScreen.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(129, 35, 169, 24);
		frmScreen.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 90, 169, 24);
		frmScreen.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(129, 145, 169, 24);
		frmScreen.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEnabled(false);
		
		textField_3 = new JTextField();
		textField_3.setBounds(129, 200, 169, 24);
		frmScreen.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEnabled(false);
		
		JButton btnNewButton = new JButton("\u751F\u6548");
		btnNewButton.setBounds(63, 278, 113, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = 1;
				if(textField.getText().length()!=0){
					ACLPropertyReader.setProperty("remark_1", textField.getText());
					JOptionPane.showMessageDialog(null, "                   �ɹ��޸�"+count+++"������", "�޸ĳɹ�", JOptionPane.PLAIN_MESSAGE);
				}
				if(textField_1.getText().length()!=0){
					ACLPropertyReader.setProperty("remark_2", textField_1.getText());
					JOptionPane.showMessageDialog(null, "                   �ɹ��޸�"+count+++"������", "�޸ĳɹ�", JOptionPane.PLAIN_MESSAGE);
				}
				if(textField_2.getText().length()!=0){
					ACLPropertyReader.setProperty("remark_3", textField_2.getText());
					JOptionPane.showMessageDialog(null, "                   �ɹ��޸�"+count+++"������", "�޸ĳɹ�", JOptionPane.PLAIN_MESSAGE);
				}
				if(textField_3.getText().length()!=0){
					ACLPropertyReader.setProperty("remark_4", textField_3.getText());
					JOptionPane.showMessageDialog(null, "                   �ɹ��޸�"+count+++"������", "�޸ĳɹ�", JOptionPane.PLAIN_MESSAGE);
				}
				in.dispose();
				frmScreen.dispose();
				Index.getIndex().AutoUpdateAllStatus();
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 18));
		frmScreen.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setBounds(280, 278, 113, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmScreen.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 18));
		frmScreen.getContentPane().add(btnNewButton_1);
		
		s = GetACLComments.getComments(status);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedItem().toString()!="--��ѡ��--")
					textField.setText(comboBox.getSelectedItem().toString());
				else if(comboBox.getSelectedItem().toString()=="--��ѡ��--"){
        			textField.setText("");
        		}
			}
		});
		comboBox.setBounds(312, 35, 154, 24);
		s[0] = "--��ѡ��--";
		comboBox.setModel(new DefaultComboBoxModel(s));
		frmScreen.getContentPane().add(comboBox);
		
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_1.getSelectedItem().toString()!="--��ѡ��--")
					textField_1.setText(comboBox_1.getSelectedItem().toString());
				else if(comboBox_1.getSelectedItem().toString()=="--��ѡ��--"){
        			textField_1.setText("");
        		}
			}
		});
		comboBox_1.setBounds(312, 90, 154, 24);
		comboBox_1.setModel(new DefaultComboBoxModel(s));
		frmScreen.getContentPane().add(comboBox_1);

		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_2.getSelectedItem().toString()!="--��ѡ��--")
					textField_2.setText(comboBox_2.getSelectedItem().toString());
				else if(comboBox_2.getSelectedItem().toString()=="--��ѡ��--"){
        			textField_2.setText("");
        		}
			}
		});
		comboBox_2.setBounds(312, 145, 154, 24);
		comboBox_2.setModel(new DefaultComboBoxModel(s));
		frmScreen.getContentPane().add(comboBox_2);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_3.getSelectedItem().toString()!="--��ѡ��--")
					textField_3.setText(comboBox_3.getSelectedItem().toString());
				else if(comboBox_3.getSelectedItem().toString()=="--��ѡ��--"){
        			textField_3.setText("");
        		}
			}
		});
		comboBox_3.setModel(new DefaultComboBoxModel(s));
		comboBox_3.setBounds(312, 199, 154, 24);
		frmScreen.getContentPane().add(comboBox_3);
		
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
