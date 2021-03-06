package tool;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.apache.log4j.Logger;

import english_reader.window;
import englishchinese.select_chinese_window;
import mian.Mianwindow;
import reciteenlish.recitewindow;
import test.Mylog;
import test.T1;


//主界面的工具栏
public class Panel1 extends JPanel{
/**主界面的窗口
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static final int Arrylist = 0;
private static final int String = 0;
	private Mianwindow Mianwindow1;
public Panel1(Mianwindow w1){
	this.Mianwindow1=w1;
	setLayout(null);
	setPreferredSize(new Dimension(850, 50));//主界面的宽度；
//	setBackground(new Color(54 ,54, 54));

	
	 JPanel  GImage = new JPanel() {  
  	  
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {  
            ImageIcon icon = new ImageIcon("C:/Users/Administrator/Desktop/图片素材库/timg.jpg");  
            Image img = icon.getImage();  
            g.drawImage(img, 0, 0, icon.getIconWidth(),  
                    icon.getIconHeight(), icon.getImageObserver());    
        }  

    };  
	
    GImage.setBounds(0,0,900,700);
	
	
    JButton MB1=new JButton("阅读器");
    MB1.setBounds(80,80, 130, 90);
	MB1.setBorder(new LineBorder(new Color(28,134,238)));
	
	
	MB1.setBackground(new Color(0,166,80));
	MB1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			englishreader();//执行函数，打开阅读器。
			T1 tt1=new T1();
			Logger logger = tt1.getMyLog(Mylog.class);
			logger.debug("点击了阅读器");
            w1.setVisible(false);
		}

	});
	MB1.addMouseListener(new MouseListener(){


		@Override
		public void mouseEntered(MouseEvent e) {
	
			MB1.setBounds(70,70, 150, 110);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {

			MB1.setBounds(80,80,130, 90);
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
	});
	
	
	
	
	
	
	 JButton MB2=new JButton("背单词");
	    MB2.setBounds(260,80, 130, 90);
//		MB2.setBorder(new LineBorder(Color.CYAN));
		MB2.setBackground( new Color(0 ,238 ,118));
		MB2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {			

			}
	
		});
	

		MB2.addMouseListener(new MouseListener(){

			@Override
			public void mouseEntered(MouseEvent e) {
				
				MB2.setBounds(250,70, 150, 100);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				

				MB2.setBounds(260,80, 130, 90);
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				reciteword();
				T1 tt1=new T1();
				Logger logger = tt1.getMyLog(Mylog.class);
				logger.debug("点击了背诵");
				w1.setVisible(false);
						}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

		});
		
	
		
		
		 JButton MB3=new JButton("英认中");
		    MB3.setBounds(440,80, 130, 90);
			MB3.setBackground( new Color(28,134,238));
			MB3.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						selectchinese();
						T1 tt1=new T1();
						Logger logger = tt1.getMyLog(Mylog.class);
						logger.debug("点击了英认中");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					w1.setVisible(false);
					
				}
	
			});
		

			MB3.addMouseListener(new MouseListener(){

				@Override
				public void mouseEntered(MouseEvent e) {
					
					MB3.setBounds(430,70, 150, 100);
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					

					MB3.setBounds(440,80, 130, 90);
					
				}

				@Override
				public void mouseClicked(MouseEvent e) { 
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					
				}
				
			});

	
    add(MB1);
    add(MB2);
    add(MB3);
    add(GImage); 

    
}

//函数调用下
public void englishreader(){
	@SuppressWarnings("unused")
	window wid = new window(Mianwindow1.word1,Mianwindow1.word2);

	
}

public void reciteword(){
	@SuppressWarnings("unused")
	recitewindow Win=new recitewindow(Mianwindow1.word1,Mianwindow1.word2 );	
}

public void selectchinese() throws ClassNotFoundException{
	@SuppressWarnings("unused")
	select_chinese_window Wic=new select_chinese_window(Mianwindow1.word1,Mianwindow1.word2 );
	
}

}