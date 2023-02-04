package Swing;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JScrollPaneExample extends JFrame{

	private JScrollPane scrollImage;
	private JLabel lblimage;
	
	// 메인 윈도우 설정
	public JScrollPaneExample() {
		this.setTitle("JScrollPaneExample");
		this.setSize(200, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JFrame 중앙에 JScrollPane 추가
		this.getContentPane().add(getScrollImage(), BorderLayout.CENTER);
	}
	
	// JScrollPane 생성
	private Component getScrollImage() {

		if(scrollImage == null) {
			scrollImage = new JScrollPane(getLblImage());
		}
		
		return scrollImage;
	}

	// 
	private JLabel getLblImage() {

		if(lblimage == null) {
			lblimage = new JLabel();
			lblimage.setIcon(new ImageIcon(getClass().getResource("snow.jpg")));
		}
		
		return lblimage;
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JScrollPaneExample jFrame = new JScrollPaneExample();
				jFrame.setVisible(true);
			}
			
		});
		
	}

}
