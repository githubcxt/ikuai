package com.cxt.ikuai.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.json.JSONArray;
import org.json.JSONObject;

import com.cxt.ikuai.model.ARPManage;
import com.cxt.ikuai.model.GetArpMacList;
import com.cxt.ikuai.model.MyURL;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ArpIndex extends JFrame implements InitUI {
	JFrame frmScreen = new JFrame();;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
    JMenuBar jmb = new JMenuBar();
    JMenu menu = new JMenu("\u8F6C \u81F3 -> \u5220 \u9664");
    static int count = 0;
	private static String status;
	/**
	 * Launch the application.
	 */
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
	/**
	 * Create the frame.
	 */
	public ArpIndex() {
		UI();
        frmScreen.setTitle("Arp设定");
		ImageIcon icon = new ImageIcon("image/logo.png");
		frmScreen.setIconImage(icon.getImage());
		frmScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmScreen.setResizable(false);
        frmScreen.setBounds(100, 100, 500, 420);

        frmScreen.getContentPane().setLayout(null);
		frmScreen.setLocationRelativeTo(null);
		frmScreen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("I P:");
		lblNewLabel.setBounds(90, 38, 90, 18);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		frmScreen.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M A C:");
		lblNewLabel_1.setBounds(90, 88, 81, 18);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		frmScreen.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("\u540D \u79F0:");
		lblNewLabel_4.setBounds(90, 140, 81, 18);
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		frmScreen.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(330, 30));
		textField.setBounds(180, 35, 218, 27);
		frmScreen.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(330, 30));
		textField_1.setBounds(180, 85, 218, 27);
		frmScreen.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setPreferredSize(new Dimension(330, 30));
		textField_2.setBounds(180, 137, 218, 27);
		frmScreen.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("\u7ED1 \u5B9A");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(51, 300, 101, 35);
		frmScreen.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u53D6 \u6D88");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmScreen.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(339, 300, 101, 35);
		frmScreen.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("\u6240\u5C5E\u7F51\u5361:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(90, 190, 90, 18);
		frmScreen.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u7ED1\u5B9A\u7C7B\u578B:");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(90, 242, 90, 18);
		frmScreen.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"lan1"}));
		comboBox.setBounds(180, 186, 218, 27);
		frmScreen.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u552F\u4E00"}));//该字符串是"唯一"
		comboBox_1.setBounds(180, 239, 218, 27);
		frmScreen.getContentPane().add(comboBox_1);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ARPManage am = new ARPManage();
				status = Index.jhh.sendPost(MyURL.ACLManage, Index.cookie,ARPManage.GetShowArpJson());


				int flag = 0;
				if(count % 2 == 0){
					JSONObject jsonouter = new JSONObject(status);
					jsonouter = (JSONObject)jsonouter.get("Data");
					JSONArray ja = (JSONArray)jsonouter.get("data");
					
					GetArpMacList gam = new GetArpMacList();
					String s[] = gam.GetMacList(status);
					for(int i = 0; i < s.length; i++){
						if(s[i].equals(textField_1.getText())){
							String id = ja.getJSONObject(i).get("id").toString();
							String old_ip = ja.getJSONObject(i).get("ip_addr").toString();
							status = Index.jhh.sendPost(MyURL.ACLManage, Index.cookie, am.GetEditArpJson(textField.getText(), textField_1.getText(), textField_2.getText(),old_ip,id));
							System.out.println(textField_2.getText());
							JSONObject jmessage = new JSONObject(status);
							if(jmessage.get("ErrMsg").equals("Success")){
								JOptionPane.showMessageDialog(null, "                   修改成功！","操作成功",JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "      "+jmessage.get("ErrMsg").toString(), "操作失败", JOptionPane.ERROR_MESSAGE);
							}
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							flag = 1;	
						}
					}
					if(flag == 0){
						status = Index.jhh.sendPost(MyURL.ACLManage, Index.cookie, am.GetAddArpJson(textField.getText(), textField_1.getText(), textField_2.getText()));
						JSONObject jmessage = new JSONObject(status);
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						if(jmessage.get("ErrMsg").equals("Success")){
							JOptionPane.showMessageDialog(null, "                   绑定成功！","操作成功",JOptionPane.PLAIN_MESSAGE);	
						}else{
							JOptionPane.showMessageDialog(null, "      "+jmessage.get("ErrMsg").toString().substring(9), "操作失败", JOptionPane.ERROR_MESSAGE);
						}
					}
				}else{
					JSONObject jsonouter = new JSONObject(status);
					jsonouter = (JSONObject)jsonouter.get("Data");
					JSONArray ja = (JSONArray)jsonouter.get("data");
					int i;
					GetArpMacList gam = new GetArpMacList();
					String s[] = gam.GetMacList(status);
					for(i = 0; i < s.length; i++){
						if(s[i].equals(textField_1.getText())){
							String id = ja.getJSONObject(i).get("id").toString();
							String ip_addr = ja.getJSONObject(i).get("ip_addr").toString();
							status = Index.jhh.sendPost(MyURL.ACLManage, Index.cookie, am.GetDelArpJson(id, ip_addr));
							JSONObject jmessage = new JSONObject(status);
							if(jmessage.get("ErrMsg").equals("Success")){
								JOptionPane.showMessageDialog(null, "                   删除成功！","操作成功",JOptionPane.PLAIN_MESSAGE);	
							}else{
								//这个循环规避掉一个异常！！完美处理，做笔记
								//JOptionPane.showMessageDialog(null, "      "+jmessage.get("ErrMsg").toString(), "操作失败", JOptionPane.ERROR_MESSAGE);
							}
							textField_1.setText("");
							break;
						}
					}
					if(i == s.length){
						JOptionPane.showMessageDialog(null, "           删除失败！", "操作失败", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				count++;//奇数:跳转删除页面；偶数:跳转绑定页面
				if(count % 2 != 0){
					menu.setText("转 至 -> 绑 定");
					textField.setText("-----------LOCK-----------");
					textField.setBackground(Color.LIGHT_GRAY);
					textField.setEditable(false);
					
					textField_1.setText("");
					
					textField_2.setText("-----------LOCK-----------");
					textField_2.setBackground(Color.LIGHT_GRAY);
					textField_2.setEditable(false);
					btnNewButton.setText("删 除");
				}else{
					menu.setText("转 至 -> 删 除");
					textField.setText("");
					textField.setBackground(textField_1.getBackground());
					textField.setEditable(true);
					
					textField_1.setText("");
					
					textField_2.setText("");
					textField_2.setBackground(textField_1.getBackground());
					textField_2.setEditable(true);
					btnNewButton.setText("绑 定");
				}
			}
		});
		jmb.add(menu);
		frmScreen.setJMenuBar(jmb);
		frmScreen.setVisible(true);
	}
}
