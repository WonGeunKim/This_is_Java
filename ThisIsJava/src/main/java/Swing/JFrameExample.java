package Swing;

import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JFrameExample extends JFrame{

	public JFrameExample() {
		
		// JWindow의 크기
		this.setSize(600, 500);
		
		// 제목 표시줄 내용
		this.setIconImage(new ImageIcon(getClass().getResource("game.png")).getImage());
		// 아이콘은 setIcomImage() 메소드로 설정
		// ImageIcon 객체의 getImage() 메소드로 Image 객체를 얻어 매개값으로 설정
		
		this.setTitle("메인창");
		// 창 제목은 setTitle() 메소드로 설정
		
		// 종료 버튼의 기본 기능
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 프로세스를 완전히 종료하려면 setDefaultCloseOperation() 메소드로 종료 버튼의 기본 기능을 변경해야 한다
		// JFrame.EXIT_ON_CLOSE - 윈도우 프로세스를 종료
		
		// JWindow를 화면 중앙으로 띄우기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - this.getWidth() / 2;
		int leftTopY = centerPoint.y - this.getHeight() / 2;
		this.setLocation(leftTopX, leftTopY);
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JFrameExample jFrame = new JFrameExample();
				jFrame.setVisible(true);
			}
		});
	}

}
