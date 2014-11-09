/**  
* @Project: regutil
* @Title: MainFrame.java
* @Package com.zhang
* @Description: 正则表达式工具
* @author zhanghongbin mypczhanghongbin@gmail.com
* @date 2014-11-9 下午6:35:37
* @Copyright: 2014 zhanghongbin. All rights reserved.
* @version V1.0  
*/
package com.zhang;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @ClassName MainFrame
 * @Description TODO
 * @author zhanghongbin mypczhanghongbin@gmail.com
 * @date 2014-11-9
 */
public class MainFrame extends JFrame{

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long	serialVersionUID	= 1L;
	private JTextField jfRegx,jfStr;
	private JButton test;
	private JLabel tp1,tp2,jlResult;
	private Container container;
	
	public MainFrame(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		
		this.setSize(600, 400);
		this.setLocation(350, 100);
		this.setResizable(false);
		this.setTitle("正则表达式测试工具");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jfRegx = new JTextField();
		jfStr = new JTextField();
		test = new JButton("测试");
		jlResult = new JLabel("等待测试...");
		tp1 = new JLabel("正则式：");
		tp2 = new JLabel("待测项：");
		
		container = this.getContentPane();
		container.setLayout(null);
		
		tp1.setBounds(90, 30, 80, 30);
		jfRegx.setBounds(170, 30,350, 30);
		
		tp2.setBounds(90, 90, 80, 30);
		jfStr.setBounds(170, 90, 350, 30);
		
		test.setBounds(440, 140, 100, 30);
		
		jlResult.setBounds(90, 190, 430, 200);
		
		container.add(tp1);
		container.add(jfRegx);
		container.add(tp2);
		container.add(jfStr);
		container.add(test);
		container.add(jlResult);
		
		this.setVisible(true);
		
		test.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent env) {
				
				
				String regx = jfRegx.getText();
				String str = jfStr.getText();
				if(regx.isEmpty()==false){
					if(str.isEmpty()==false){
						Pattern pt = Pattern.compile(regx);
						Matcher mt = pt.matcher(str);
						int i = 0;
						StringBuffer bf = new StringBuffer();
						bf.append("<html><body>");
						bf.append("<h2 style='color:#ff0000'>");
						boolean is =false;
						while(mt.find()){
							bf.append("|"+mt.group()+"|");
							i++;
							is= true;
						}
						
						if(is==false){
							bf.append("对不起，没有找到到匹配项！");
							bf.append("</h2>");
							bf.append("</body></html>");
						}else{
							bf.append("<br><br>");
							bf.append("一共找打"+i+"个匹配组！");
							bf.append("</h3>");
							bf.append("</body></html>");
						}
						
						jlResult.setText(bf.toString());
						
					}else{
						JOptionPane.showConfirmDialog(null, "亲，要填写待测式哦！", "提示", JOptionPane.YES_NO_OPTION); 
					}
					
				}else{
					JOptionPane.showConfirmDialog(null, "亲，要填写正则式哦！", "提示", JOptionPane.YES_NO_OPTION); 
					
				}
				
			
			}});
	}

	/** 
	 * @Title: main 
	 * @Description: TODO
	 */
	public static void main(String[] args) {
		new MainFrame();
	}

}
