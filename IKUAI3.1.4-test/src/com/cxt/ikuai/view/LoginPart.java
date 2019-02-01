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
 
 //1.定义Login类，
public class LoginPart implements InitUI {
	JTextField textName = new JTextField();
	JPasswordField textPass=new JPasswordField();
	JFrame frmScreen = new JFrame();
	public void Initial(){
	   frmScreen.setResizable(false);
		// 3.在initUI方法中，实例化JFrame类的对象。
		ImageIcon icon = new ImageIcon("image/logo.png");
		frmScreen.setIconImage(icon.getImage());
		frmScreen.getContentPane().setForeground(Color.BLACK);
		frmScreen.setForeground(Color.WHITE);
		// 4.设置窗体对象的属性值：标题、大小、显示位置、关闭操作、布局、禁止调整大小、可见、...
		frmScreen.setTitle("\u7BA1\u7406\u5458\u767B\u9646");// 设置窗体的标题
		frmScreen.setSize(500, 365);// 设置窗体的大小，单位是像素
		frmScreen.setDefaultCloseOperation(2);// 设置窗体的关闭操作；3表示关闭窗体退出程序；2、1、0
		frmScreen.setLocationRelativeTo(null);// 设置窗体相对于另一个组件的居中位置，参数null表示窗体相对于屏幕的中央位置
		frmScreen.setResizable(false);
			
	 
			// 5.实例化元素组件对象，将元素组件对象添加到窗体上（组件添加要在窗体可见之前完成）。
		// 实例化ImageIcon图标类的对象，该对象加载磁盘上的图片文件到内存中，这里的路径要用两个\
		// 用标签来接收图片，实例化JLabel标签对象，该对象显示icon图标
		JLabel labIcon = new JLabel(icon);
		labIcon.setBounds(129, 13, 265, 65);
		//设置标签大小
		//labIcon.setSize(30,20);setSize方法只对窗体有效，如果想设置组件的大小只能用
		Dimension dim = new Dimension(400,65);
		frmScreen.getContentPane().setLayout(null);
		labIcon.setPreferredSize(dim);
		// 将labIcon标签添加到窗体上
			frmScreen.getContentPane().add(labIcon);
	 
			
			// 实例化JLabel标签对象，该对象显示"账号："
		JLabel labName = new JLabel("User\uFF1A");
		labName.setFont(new Font("宋体", Font.PLAIN, 20));
		labName.setBounds(119, 106, 60, 47);
		// 将labName标签添加到窗体上
			frmScreen.getContentPane().add(labName);
	 
			// 实例化JTextField标签对象
		textName.setBounds(178, 116, 216, 30);
		Dimension dim1 = new Dimension(330,30);
		//textName.setSize(dim);//setSize这方法只对顶级容器有效，其他组件使用无效。
		textName.setPreferredSize(dim1);//设置除顶级容器组件其他组件的大小
		// 将textName标签添加到窗体上
			frmScreen.getContentPane().add(textName);
	 
			//实例化JLabel标签对象，该对象显示"密码："
		JLabel labpass= new JLabel("Pass:");
		labpass.setFont(new Font("宋体", Font.PLAIN, 20));
		labpass.setBounds(119, 174, 73, 39);
		//将labpass标签添加到窗体上
		frmScreen.getContentPane().add(labpass);
		
		
		//实例化JPasswordField
		textPass.setBounds(178, 180, 216, 30);
		//设置大小
		textPass.setPreferredSize(dim1);//设置组件大小
		//添加textword到窗体上
		frmScreen.getContentPane().add(textPass);
		//设置按钮的显示内容
		Dimension dim2 = new Dimension(200,30);
		
		JButton btnNewButton = new JButton("\u9000 \u51FA");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
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
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().equals(AdminPropertyReader.getProperty("username"))&&AdminPropertyReader.getProperty("password").equals(String.valueOf(textPass.getPassword()))){
					ChangePass cp = new ChangePass();
					cp.UI();
					frmScreen.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "          登录失败！", "ERROR", JOptionPane.ERROR_MESSAGE);
					textName.setText("");
					textPass.setText("");
				}
			}
		});
	btnNewButton_1.setBounds(80, 266, 94, 27);
	frmScreen.getContentPane().add(btnNewButton_1);
	frmScreen.setVisible(true);// 设置窗体为可见
	}
	public LoginPart(Index in) {
		this.Initial();
		JButton btnNewButton_1 = new JButton("登 录");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().equals(AdminPropertyReader.getProperty("username"))&&AdminPropertyReader.getProperty("password").equals(String.valueOf(textPass.getPassword()))){
					FunctionManage fm = new FunctionManage(in);
					frmScreen.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "          登录失败！", "ERROR", JOptionPane.ERROR_MESSAGE);
					textName.setText("");
					textPass.setText("");
				}
			}
		});
	
	btnNewButton_1.setBounds(80, 266, 94, 27);
	frmScreen.getContentPane().add(btnNewButton_1);
	frmScreen.setVisible(true);// 设置窗体为可见
	}
	public LoginPart(String sign) {
		this.Initial();
		JButton btnNewButton_1 = new JButton("登 录");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().equals(AdminPropertyReader.getProperty("username"))&&AdminPropertyReader.getProperty("password").equals(String.valueOf(textPass.getPassword()))){
					ArpIndex ab = new ArpIndex();
					frmScreen.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "          登录失败！", "ERROR", JOptionPane.ERROR_MESSAGE);
					textName.setText("");
					textPass.setText("");
				}
			}
		});
	btnNewButton_1.setBounds(80, 266, 94, 27);
	frmScreen.getContentPane().add(btnNewButton_1);
	frmScreen.setVisible(true);// 设置窗体为可见
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
