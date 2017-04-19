package englishchinese;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Button.Tool_panel;
import tool.Panel1;
import worldshow.Word;

public class select_chinese_window extends JFrame {
	
	public TextArea ta;
	public ArrayList<String> word=null;
	public ArrayList<String> word1;//已会单词
    public ArrayList<String> word2;//正在学习的单词
	public Word wo;
	public String text,t;
	public int wnum;
	public JPanel jpanel1;
	public static select_chinese_window test;
	public chineselabel cq,cw, ce,cr,cd,cf;
	public JLabel e1,ex1,p0,p1,p2; 
	public JButton j1, j2, j3, j4;
	public String english_w1,english_wr;
	public String chinese_w1,chinese_w2,chinese_w3,chinese_w4,chinese_w5,chinese_w6;
	
//	public static void main(String[] args) {
//		test=new select_chinese_window();
//	}

	public select_chinese_window(ArrayList<String> w1,ArrayList<String> w2) {
        word1=w1;
        word2=w2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮后，程序结束
		setBounds(200,30,1000,700);//设置大小
		getContentPane().setBackground(new Color(30,30,30));
		setTitle("select chinese");
		jpanel1=new JPanel();
		setdata();
		setjpanel1();
		add(jpanel1,BorderLayout.WEST);
		setVisible(true);

	}

	
	

	
	
	private void setdata() {
		english_w1=word1.get((int) (Math.random()*word1.size()));

		chinese_w1=search(word1.get((int) (Math.random()*word1.size())));
		chinese_w2=search(word1.get((int) (Math.random()*word1.size())));
		chinese_w3=search(word1.get((int) (Math.random()*word1.size())));
		chinese_w4=search(word1.get((int) (Math.random()*word1.size())));
		chinese_w5=search(word1.get((int) (Math.random()*word1.size())));
		chinese_w6=search(word1.get((int) (Math.random()*word1.size())));
		int ram16=new Random().nextInt(6)+1;
		switch(ram16){
		case 1:{chinese_w1=search(english_w1);
		break;}
		case 2:{chinese_w2=search(english_w1);
		break;}
		case 3:{chinese_w3=search(english_w1);;
		break;}
		case 4:{chinese_w4=search(english_w1);
		break;}
		case 5:{chinese_w5=search(english_w1);
		break;}
		case 6:{chinese_w6=search(english_w1);
		break;}
			
		}
		repaint();
		
}







	private String search(String inputWord) {
		
		try {
            BufferedReader br = new BufferedReader(
         new FileReader("C:/Users/Administrator/Desktop/代码合集/dictionary.txt"));
            String line ;
            boolean isFound = false;
             
//            System.out.println(inputWord.substring(0,inputWord.length()-1));
            if(inputWord.equals("")){
                return " ";
            }
                         
            while((line = br.readLine()) != null){
                Scanner in = new Scanner(line);
            	String sword=in.next();//in.next()使用后会自动换行
                if(sword.equals(inputWord)){

                    int offset = inputWord.length();
                    
                    return line.substring(offset);
 
                }
       
        }
		}
        catch (Exception ex) {
            ex.printStackTrace();
        }
	
		return " ";
	}






	private void setjpanel1() {//对主界面进行设计
		jpanel1.setLayout(null);
		jpanel1.setPreferredSize(new Dimension(950, 150));//宽度950
		jpanel1.setBackground(new Color(60,60,60));
		
		
		ex1=new JLabel();
		ex1.setBounds(20, 30, 180,550);
		ex1.setBackground(new Color(220,220,30));
		ex1.setOpaque(true);
		
		
		e1=new JLabel(english_w1);
		e1.setBounds(220, 30, 300,70);
		e1.setForeground(Color.white);
		e1.setBackground(new Color(140,140,200));
		e1.setOpaque(true);
		
		
		p0=new JLabel();
		p1=new JLabel();
		p2=new JLabel();
		p0.setBounds(550, 70, 300,70);
		p1.setBounds(550, 160, 300,70);
		p2.setBounds(550, 250, 300,70);
		p0.setFont(new java.awt.Font("Dialog", 1,20));
		p1.setFont(new java.awt.Font("Dialog", 1,30));
		p2.setFont(new java.awt.Font("Dialog", 1,30));
		p0.setBackground(new Color(190,120,150));
		p1.setBackground(new Color(190,120,150));
		p2.setBackground(new Color(190,120,150));
		p0.setOpaque(true);
		p1.setOpaque(true);
		p2.setOpaque(true);
		
		
		cq=new chineselabel(220, 1, chinese_w1);
		cw=new chineselabel(220, 2, chinese_w2);
		ce=new chineselabel(220, 3, chinese_w3);
		cr=new chineselabel(220, 4, chinese_w4);
		cd=new chineselabel(220, 5, chinese_w5);
		cf=new chineselabel(220, 6, chinese_w6);
		
		
		jpanel1.add(p0);
		jpanel1.add(p1);
		jpanel1.add(p2);
		jpanel1.add(e1);
//		jpanel1.add(ex1);//经验系统
		jpanel1.add(cq);
		jpanel1.add(cw);
		jpanel1.add(ce);
		jpanel1.add(cr);
		jpanel1.add(cd);
		jpanel1.add(cf);
		
		
		//按钮合集
		j1=new JButton ("O 加入正在学习");
		j2=new JButton ("P 不认识");
		j3=new JButton ("K 百度搜索");
		j4=new JButton ("L 备用按钮");
		j1.setBounds(550, 430, 160, 60);
		j2.setBounds(550, 520, 160, 60);
		j3.setBounds(740, 430, 160, 60);
		j4.setBounds(740, 520, 160, 60);
		j1.setBackground(new Color(240,100,100));
		j2.setBackground(new Color(240,100,100));
		j3.setBackground(new Color(240,100,100));
		j4.setBackground(new Color(240,100,100));
		
		
		jpanel1.add(j1);
		jpanel1.add(j2);
		jpanel1.add(j3);
		jpanel1.add(j4);
		j4.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
			switch(e.getKeyChar()){
			case 'q':{ 
				if(search(english_w1).equals(chinese_w1)){
					showword();
					setdata();	
					reshow();
				}
				else
					cq.setBackground(Color.RED);
				
				break;}
			case 'w':{ 
				if(search(english_w1).equals(chinese_w2)){
					showword();
					setdata();	
					reshow();
					}
				else
					cw.setBackground(Color.RED);
				
				break;}
			case 'e':{ 
				if(search(english_w1).equals(chinese_w3)){
					showword();
					setdata();	
					reshow();
					}
				else
					ce.setBackground(Color.RED);
				break;}
			case 'r':{ 
				if(search(english_w1).equals(chinese_w4)){
					showword();
					setdata();	
					reshow();
					}
				else
					cr.setBackground(Color.RED);
				break;}
			case 'd':{ 
				if(search(english_w1).equals(chinese_w5)){
					showword();
					setdata();	
					reshow();
					}
				else
					cd.setBackground(Color.RED);
				
				break;}
			case 'f':{ 
				if(search(english_w1).equals(chinese_w6)){
					showword();
					setdata();	
					reshow();
					}
				else
					cf.setBackground(Color.RED);
				break;}
			case 'o':{ 
				word2.add(english_w1);
				word1.remove(english_w1);
				out();
				outnow();
				break;}
					
			case 'p':{ 
				word1.remove(english_w1);
				out();
				break;}
			
			case 'k':{ 
				baidusousuo(english_w1);
				break;}
			}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			
				
			}});		
		
	
		
	}
	
	private void reshow(){
		e1.setText(english_w1);
		cq.setText(chinese_w1);
		cw.setText(chinese_w2);
		ce.setText(chinese_w3);
		cr.setText(chinese_w4);
		cd.setText(chinese_w5);
		cf.setText(chinese_w6);
		cq.setBackground(new Color(60,160,60));
		cw.setBackground(new Color(60,160,60));
		ce.setBackground(new Color(60,160,60));
		cr.setBackground(new Color(60,160,60));
		cd.setBackground(new Color(60,160,60));
		cf.setBackground(new Color(60,160,60));
		p0.setText("词量:"+word1.size()+"在学："+word2.size());
		
		repaint();
		
	}
	
	public void showword(){
		p1.setText(english_w1);
		p2.setText(search(english_w1));
		
	}
	
	public void baidusousuo(String t){ 
  	   try { 
  		   
  		    String url = "http://www.iciba.com/"+t; 
  		    java.net.URI uri = java.net.URI.create(url); 
  		    // 获取当前系统桌面扩展 
  		    java.awt.Desktop dp = java.awt.Desktop.getDesktop(); 
  		    // 判断系统桌面是否支持要执行的功能 
  		    if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) { 

  		      dp.browse(uri);// 获取系统默认浏览器打开链接 

  		    } 
  		   } catch (java.lang.NullPointerException f) { 
  		    // 此为uri为空时抛出异常 
  		    f.printStackTrace(); 
  		   } catch (java.io.IOException f) { 
  		    // 此为无法获取系统默认浏览器 
  		    f.printStackTrace(); 
  		   } 
  		  }
	
	 public void out(){
		   
		   
	    	try{
		    		
		    		ObjectOutputStream out=new ObjectOutputStream(
		    				new FileOutputStream(
		    						"C:/Users/Administrator/Desktop/代码合集/obj.txt"));
		    		out.writeObject(word1);
		    		out.close();
		    	}catch(IOException e ){
		    		e.printStackTrace();
		    	}
		    	
		   }
	
	 public void outnow(){
		   
		   
	    	try{
		    		
		    		ObjectOutputStream out=new ObjectOutputStream(
		    				new FileOutputStream(
		    						"C:/Users/Administrator/Desktop/代码合集/now.txt"));
		    		out.writeObject(word2);
		    		out.close();
		    	}catch(IOException e ){
		    		e.printStackTrace();
		    	}
		    	
		   }
	
	
	
}
