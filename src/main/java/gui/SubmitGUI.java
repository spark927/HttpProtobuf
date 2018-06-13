package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.alibaba.fastjson.JSONObject;

import test.Demo;

public class SubmitGUI extends JFrame{


	// 定义组件
    JPanel jp1, jp2, jp3, jp4;
    JLabel jlb1, jlb2, jlb3;
    JButton jb1, jb2;
    JTextField jtf1, jtf2, jtf3;


    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	SubmitGUI d1 = new SubmitGUI();

    }

    // 构造函数
    public SubmitGUI() {

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jlb1 = new JLabel("请求类型");
        jlb2 = new JLabel("URL");
        jlb3 = new JLabel("参数");

        jb1 = new JButton("提交");
        jb2 = new JButton("取消");

        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
        this.setLayout(new GridLayout(4, 1));

        // 加入各个组件
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jtf2);
        
        jp3.add(jlb3);
        jp3.add(jtf3);

        jp4.add(jb1);
        jp4.add(jb2);

        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        this.setSize(500, 300);
        this.setTitle("登录");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        jb1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String p1 = jtf1.getText();
		        String p2 = jtf2.getText();
		        String p3 = jtf3.getText();
		        JSONObject jsStr = JSONObject.parseObject(p3);  
		        try {
					Demo.SetLed(p1, p2, jsStr);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
				
			}
		});
        
        
    }

}
