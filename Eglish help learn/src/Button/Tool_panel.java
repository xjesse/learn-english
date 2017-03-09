package Button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Lis.openact;
import english_learn.window;
import worldshow.wordjlabel;


public  class Tool_panel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	
	private window widd;
	public wordshuxing fy,wordnumber,unknow,unknowl,learning;
	public JTextField t1,t2;
	
	
	public Tool_panel(window window){
		//添加操作按钮
		
		this.widd=window;
		setLayout(null);
		setPreferredSize(new Dimension(200, 50));
		
		setBackground(Color.CYAN);
		fy=new wordshuxing(10, 10, 60,"这里是翻译");
		unknow=new wordshuxing(10, 80,40, "未知单词数：");
		unknowl=new wordshuxing(10, 140,40, "未知：");
		add(new wordshuxing(10, 200,40, "陌生率："));
		wordnumber=new wordshuxing(10, 260,40, "总单词数：");
		learning=new wordshuxing(10, 320,40, "属性2");
		add(unknow);
		add(unknowl);
		add(fy);
		add(wordnumber);
		
		add(learning);
		
		
		t1 =new Etextfield(10 , 450 ,150 ,20);
		t2=new Etextfield(10 , 490 ,150 ,20);
		
		
		add(t1);
		add(t2);
		JButton OT=new JButton("open");
		OT.setBounds(10,370, 80, 70);
		OT.addActionListener(new openact(widd));
		JButton FT=new JButton("添加翻译");
		FT.setBounds(20,540, 120, 30);
		FT.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				WriteDate(t1.getText()+"  "+t2.getText());
				t1.setText("");
				t2.setText("");
				
				
			}
			
		});
		
		
		add(FT);
		add(OT);//open text button;
		
		
//		TextField text1 = new TextField("输入密码：", 10);  
////        text1.setEditable(false);  
//        TextField text2 = new TextField(10);  
//        text2.setEchoChar('*');  
//          
//        add(text1);  
//        add(text2);  
//        setVisible(true);  
//        validate();
		
		
	}
	
//	public void show (){
//		
//		add(fy);
//		add(new wordshuxing(10, 80,40, "未知单词："));
//		add(new wordshuxing(10, 140,40, "未知："));
//		add(new wordshuxing(10, 200,40, "陌生率："));
//		add(new wordshuxing(10, 260,40, "属性2"));
//		add(new wordshuxing(10, 320,40, "属性2"));
//		add(new Etextfield(10 , 450 ,150 ,20));
//		add(new Etextfield(10 , 490 ,150 ,20));
//	}
	
	
	
	
	public static void WriteDate(String nfile) {

		try{


		FileReader read = new FileReader(new File("C:/Users/Administrator/Desktop/许云苏的机器人/dictionary.txt"));//打开txt

		StringBuffer sb = new StringBuffer();

		char ch[] = new char[1024];

		int d = read.read(ch);

		while(d!=-1){

		String str = new String(ch,0,d);

		sb.append(str);

		d = read.read(ch);

		}

		System.out.println(sb.toString());

		BufferedWriter output = new BufferedWriter(new FileWriter("C:/Users/Administrator/Desktop/许云苏的机器人/dictionary.txt"));//保存TXT位置

		output.write(String.valueOf(sb.toString()));


		output.write(String.valueOf(nfile)+"\r\n");


		output.close();

		} catch (Exception ex) {

		System.out.println(ex);

		}

		}
	
	
	

}
