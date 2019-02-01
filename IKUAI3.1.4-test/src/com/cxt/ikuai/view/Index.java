package com.cxt.ikuai.view;

//记事本界面
import javax.swing.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.cxt.ikuai.controller.ACLPropertyReader;
import com.cxt.ikuai.controller.Base64_encrypt;
import com.cxt.ikuai.controller.WebAdminPropertyReader;
import com.cxt.ikuai.model.JavaHttpHandle;
import com.cxt.ikuai.model.MyURL;
import com.cxt.ikuai.model.PostCookie;
import com.cxt.ikuai.model.ACLManage;
import com.cxt.ikuai.model.GetACLStatus;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Index extends JFrame implements InitUI {
	public Index() {
	}
    // 菜单条组件

    JMenuBar jmb;
    JMenu menu1, menu2;
    JMenuItem item1, item2;
    private JButton btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3,btnNewButton_4,btnNewButton_5,btnNewButton_6,btnNewButton_7;
    public static Index in = new Index();
    public static Index getIndex(){
    	in = new Index();
    	in.InitialIndex();
    	return in;
    }
	public static JavaHttpHandle jhh = new JavaHttpHandle();
    
	static String b,b_1,b_2,b_3 = "";
	public static String cookie = "";
	static MyURL myurl = MyURL.getMyURL();
	static ACLManage acl = new ACLManage();
	static int ensure = 0;
	public static String status;
    public static void main(String[] args) {
    	in.InitialIndex();
		PostCookie postcookie = PostCookie.getPostCookie();
		
		String admin,passwd,pass;
		admin = WebAdminPropertyReader.getProperty("user");
		passwd = DigestUtils.md5Hex(WebAdminPropertyReader.getProperty("pass"));
		pass = Base64_encrypt.commonsCodeBase64(WebAdminPropertyReader.getProperty("pass"));
		
		String paramvalue = "{\"username\":\""+admin+"\",\"passwd\":\""+passwd+"\",\"pass\":\""+pass+"\"}";
		//输入用户名，密码进行登录Action_login,获得服务器状态码，破解该网址，拿到访问权
		
		jhh.sendPost(MyURL.Action_login,paramvalue);
		//服务器返回Result=10000,执行static/custom/login.html中的remark中的setCookie("username",user,30)。。。。0
		System.out.println("以后访问都要带的cookie:"+jhh.getCookie()+";username=admin;login=1");
		cookie=jhh.getCookie()+";username=admin;login=1";
		status = jhh.sendPost(MyURL.ACLManage, cookie,acl.GetShowAclJson());
		System.out.println(status);
		
		in.AutoUpdateAllStatus();
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
	public void InitialIndex() {
		//界面优化
		UI();
		
	    jmb = new JMenuBar();
	    this.setResizable(false);
        menu1 = new JMenu("Arp设定");
        menu1.addMouseListener(new MouseAdapter() {

        	@Override
        	public void mousePressed(MouseEvent e) {
        		LoginPart lp = new LoginPart("arp");
        	}
        });
        menu2 = new JMenu("系统设置");

        item1 = new JMenuItem("管理密码更改");
        item1.setBackground(Color.WHITE);
        item1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginPart lp = new LoginPart();
        		
        	}
        });
        item2 = new JMenuItem("\u53D7\u9650\u7F51\u5740\u8BBE\u7F6E");
        item2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginPart lp = new LoginPart(in);
        	}
        });
        // 给菜单选项添加快捷方式


        // 将菜单添加到菜单栏上

        menu2.add(item1);
        menu2.add(item2);

        // 将菜单添加到菜单条上
        jmb.add(menu1);
        jmb.add(menu2);

        // 将菜单添加到窗体上
        this.setJMenuBar(jmb);
        // 展示
        this.setTitle("\u5B66\u751F\u4E0A\u7F51\u63A7\u5236");
        ImageIcon icon = new ImageIcon("image/logo.png");
        this.setIconImage(icon.getImage());
        this.setSize(600, 423);
        this.setDefaultCloseOperation(2);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        b = ACLPropertyReader.getProperty("remark_1");
        btnNewButton = new JButton("允许访问"+b);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//访问ACL规则页面
        		//System.out.println(acl.GetShowAclJson());
        		//jhh.sendPost(myurl.ACLManage, cookie,acl.GetBPAclJson(ACLPropertyReader.getProperty("id_1"),"up"));
        		jhh.sendPost(MyURL.ACLManage, cookie, acl.GetBPAclJson(ACLPropertyReader.getProperty("id_1"), "up"));
        		String status = jhh.sendPost(MyURL.ACLManage, cookie,acl.GetShowAclJson());

        		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_1"),"1");
        		if(ensure == 1){
        			btnNewButton.setEnabled(false);
        			btnNewButton_4.setEnabled(true);
        		}else if(ensure == 0){
        			btnNewButton.setEnabled(false);
        			btnNewButton_4.setEnabled(true);
        		}else{
        			JOptionPane.showMessageDialog(null, "       二合规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
        		};
        	}
        });
        btnNewButton.setBounds(162, 59, 172, 27);
        getContentPane().add(btnNewButton);
        
        b_1 = ACLPropertyReader.getProperty("remark_2");
        btnNewButton_1 = new JButton("允许访问"+b_1);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jhh.sendPost(MyURL.ACLManage, cookie, acl.GetBPAclJson(ACLPropertyReader.getProperty("id_2"), "up"));
        		String status = jhh.sendPost(MyURL.ACLManage, cookie,acl.GetShowAclJson());
        		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_2"),"2");
        		if(ensure == 1){
        			btnNewButton_1.setEnabled(false);
        			btnNewButton_5.setEnabled(true);
        		}else if(ensure == 0){
        			btnNewButton_1.setEnabled(false);
        			btnNewButton_5.setEnabled(true);
        		}else{
        			JOptionPane.showMessageDialog(null, "       三合规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
        		};
        	}
        });
        btnNewButton_1.setBounds(162, 123, 172, 27);
        getContentPane().add(btnNewButton_1);
        
        b_2 = ACLPropertyReader.getProperty("remark_3");
        btnNewButton_2 = new JButton("允许访问"+b_2);
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jhh.sendPost(MyURL.ACLManage, cookie, acl.GetBPAclJson(ACLPropertyReader.getProperty("id_3"), "up"));
        		String status = jhh.sendPost(MyURL.ACLManage, cookie,acl.GetShowAclJson());
        		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_3"),"3");
        		if(ensure == 1){
        			btnNewButton_2.setEnabled(false);
        			btnNewButton_6.setEnabled(true);
        		}else if(ensure == 0){
        			btnNewButton_2.setEnabled(false);
        			btnNewButton_6.setEnabled(true);
        		}else{
        			JOptionPane.showMessageDialog(null, "       四合规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
        		};
        	}
        });
        btnNewButton_2.setBounds(162, 185, 172, 27);
        getContentPane().add(btnNewButton_2);
        
        b_3 = ACLPropertyReader.getProperty("remark_4");
        btnNewButton_3 = new JButton("允许访问"+b_3);
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jhh.sendPost(MyURL.ACLManage, cookie, acl.GetBPAclJson(ACLPropertyReader.getProperty("id_4"), "up"));
        		String status = jhh.sendPost(MyURL.ACLManage, cookie,acl.GetShowAclJson());
        		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_4"),"4");
        		if(ensure == 1){
        			btnNewButton_3.setEnabled(false);
        			btnNewButton_7.setEnabled(true);
        		}else if(ensure == 0){
        			btnNewButton_3.setEnabled(false);
        			btnNewButton_7.setEnabled(true);
        		}else{
        			JOptionPane.showMessageDialog(null, "       403规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
        		};
        	}
        });
        btnNewButton_3.setBounds(162, 250, 172, 27);
        getContentPane().add(btnNewButton_3);
        
        JLabel lblNewLabel = new JLabel("\u4E8C\u5408\u673A\u623F:");
        lblNewLabel.setBounds(76, 63, 72, 18);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("\u4E09\u5408\u673A\u623F:");
        lblNewLabel_1.setBounds(76, 127, 72, 18);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("\u56DB\u5408\u673A\u623F:");
        lblNewLabel_2.setBounds(76, 189, 72, 18);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("403\u673A\u623F:");
        lblNewLabel_3.setBounds(76, 254, 72, 18);
        getContentPane().add(lblNewLabel_3);
        
        btnNewButton_4 = new JButton("禁止访问"+b);
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jhh.sendPost(MyURL.ACLManage, cookie, acl.GetBPAclJson(ACLPropertyReader.getProperty("id_1"), "down"));
        		String status = jhh.sendPost(MyURL.ACLManage, cookie,acl.GetShowAclJson());

        		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_1"),"1");
        		if(ensure == 1){
        			btnNewButton_4.setEnabled(true);
        			btnNewButton.setEnabled(false);
        		}else if(ensure == 0){
        			btnNewButton_4.setEnabled(false);
        			btnNewButton.setEnabled(true);
        		}else{
        			JOptionPane.showMessageDialog(null, "       二合规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
        		};
        	}
        });
        btnNewButton_4.setBounds(348, 59, 172, 27);
        getContentPane().add(btnNewButton_4);
        
        btnNewButton_5 = new JButton("禁止访问"+b_1);
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jhh.sendPost(MyURL.ACLManage, cookie, acl.GetBPAclJson(ACLPropertyReader.getProperty("id_2"), "down"));
        		String status = jhh.sendPost(MyURL.ACLManage, cookie,acl.GetShowAclJson());

        		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_2"),"2");
        		if(ensure == 1){
        			btnNewButton_5.setEnabled(true);
        			btnNewButton_1.setEnabled(false);
        		}else if(ensure == 0){
        			btnNewButton_5.setEnabled(false);
        			btnNewButton_1.setEnabled(true);
        		}else{
        			JOptionPane.showMessageDialog(null, "       三合规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
        		};
        	}
        });
        btnNewButton_5.setBounds(348, 123, 172, 27);
        getContentPane().add(btnNewButton_5);
        
        btnNewButton_6 = new JButton("禁止访问"+b_2);
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jhh.sendPost(MyURL.ACLManage, cookie, acl.GetBPAclJson(ACLPropertyReader.getProperty("id_3"), "down"));
        		String status = jhh.sendPost(MyURL.ACLManage, cookie,acl.GetShowAclJson());

        		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_3"),"3");
        		if(ensure == 1){
        			btnNewButton_6.setEnabled(true);
        			btnNewButton_2.setEnabled(false);
        		}else if(ensure == 0){
        			btnNewButton_6.setEnabled(false);
        			btnNewButton_2.setEnabled(true);
        		}else{
        			JOptionPane.showMessageDialog(null, "       四合规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
        		};
        	}
        });
        btnNewButton_6.setBounds(348, 185, 172, 27);
        getContentPane().add(btnNewButton_6);
        
        btnNewButton_7 = new JButton("禁止访问"+b_3);
        btnNewButton_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jhh.sendPost(MyURL.ACLManage, cookie, acl.GetBPAclJson(ACLPropertyReader.getProperty("id_4"), "down"));
        		String status = jhh.sendPost(MyURL.ACLManage, cookie,acl.GetShowAclJson());

        		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_4"),"4");
        		if(ensure == 1){
        			btnNewButton_7.setEnabled(true);
        			btnNewButton_3.setEnabled(false);
        		}else if(ensure == 0){
        			btnNewButton_7.setEnabled(false);
        			btnNewButton_3.setEnabled(true);
        		}else{
        			JOptionPane.showMessageDialog(null, "       403规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
        		};
        	}
        });
        btnNewButton_7.setBounds(348, 250, 172, 27);
        getContentPane().add(btnNewButton_7);
        ButtonGroup b = new ButtonGroup();
        b.add(btnNewButton);
        
        this.setVisible(true);
        
        
	}
	public void AutoUpdateAllStatus(){
		String status = jhh.sendPost(MyURL.ACLManage, cookie,acl.GetShowAclJson());
		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_1"),"1");
		if(ensure == 1){
			btnNewButton.setEnabled(false);
			btnNewButton_4.setEnabled(true);
		}else if(ensure == 0){
			btnNewButton.setEnabled(true);
			btnNewButton_4.setEnabled(false);
		}else{
			JOptionPane.showMessageDialog(null, "       二合规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
			btnNewButton.setEnabled(false);
			btnNewButton_4.setEnabled(false);
		}
		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_2"),"2");
		if(ensure == 1){
			btnNewButton_1.setEnabled(false);
			btnNewButton_5.setEnabled(true);
		}else if(ensure == 0){
			btnNewButton_1.setEnabled(true);
			btnNewButton_5.setEnabled(false);
		}else{
			JOptionPane.showMessageDialog(null, "       三合规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
			btnNewButton_1.setEnabled(false);
			btnNewButton_5.setEnabled(false);
		}
		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_3"),"3");
		if(ensure == 1){
			btnNewButton_2.setEnabled(false);
			btnNewButton_6.setEnabled(true);
		}else if(ensure == 0){
			btnNewButton_2.setEnabled(true);
			btnNewButton_6.setEnabled(false);
		}else{
			JOptionPane.showMessageDialog(null, "       四合规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
			btnNewButton_2.setEnabled(false);
			btnNewButton_6.setEnabled(false);
		}
		ensure = GetACLStatus.getStatus(status,ACLPropertyReader.getProperty("remark_4"),"4");
		if(ensure == 1){
			btnNewButton_3.setEnabled(false);
			btnNewButton_7.setEnabled(true);
		}else if(ensure == 0){
			btnNewButton_3.setEnabled(true);
			btnNewButton_7.setEnabled(false);
		}else{
			JOptionPane.showMessageDialog(null, "       403规则不存在！", "操作失败", JOptionPane.ERROR_MESSAGE);
			btnNewButton_3.setEnabled(false);
			btnNewButton_7.setEnabled(false);
		}
	}
}