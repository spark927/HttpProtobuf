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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.alibaba.fastjson.JSONObject;

import test.Demo;

public class SubmitGUI extends JFrame{


	// 定义组件
    JPanel jp1, jp2, jp3, jp4, jp5;
    JLabel type, url, data, result;
    JButton submit, cancel;
    JTextField type_text, url_text, data_text;
	JTextArea result_text;


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
        jp5 = new JPanel();

        type = new JLabel("请求类型");
        url = new JLabel("URL");
        data = new JLabel("参数");
        result = new JLabel("返回值");

        submit = new JButton("提交");
        cancel = new JButton("取消");

        type_text = new JTextField(10);
        url_text = new JTextField(10);
        data_text = new JTextField(10);
        result_text = new JTextArea(2, 10);
        this.setLayout(new GridLayout(5, 1));

        // 加入各个组件
        jp1.add(type);
        jp1.add(type_text);

        jp2.add(url);
        jp2.add(url_text);
        
        jp3.add(data);
        jp3.add(data_text);
        
        jp4.add(result);
        jp4.add(result_text);

        jp5.add(submit);
        jp5.add(cancel);

        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);

        this.setSize(500, 300);
        this.setTitle("测试工具");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String p1 = type_text.getText();
		        String p2 = url_text.getText();
		        String p3 = data_text.getText();
		        JSONObject jsStr = JSONObject.parseObject(p3);  
		        try {
					String code = Demo.Login(p1, p2, jsStr);
					result_text.setText(code);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
			}
		});
        
    }

}
