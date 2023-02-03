package Swing;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

// 새로운 개발자 정의 우니도우는 다음과 같이 JWindow를 상속해서 만들 수 있다
public class JWindowExample extends JWindow{

	public JWindowExample() {
		
		// JWindow의 크기
		this.setSize(600, 350);
		// 윈도우는 반드시 폭과 놓이가 있어야 하기 때문에 생성자에서 setSize() 메소드로 설정
		
		// 윈도우를 화면 중앙에 띄우기 위해서는 화면의 중앙 지점을 얻어서 윈도우의 좌측 상단 모서리의 좌표를 계산해야 한다
		// JWindow를 화면 중앙으로 띄우기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		// java.awt.GraphicsEnvironment는 그래픽 환경에 대한 정보를 가지고 있는 객체
		// 이 객체는 정적 메소드이 getLocalGraphicsEnvironment()를 호출해서 얻을 수 있다
		
		Point centerPoint = ge.getCenterPoint();
		// getCenterPoint() 메소드는 화면 중앙 지점의 X좌표와 Y좌표를 가지고 있는 Point 객체를 리턴
		
		int leftTopX = centerPoint.x - this.getWidth() / 2;
		int leftTopY = centerPoint.y - this.getHeight() / 2;
		
		this.setLocation(leftTopX, leftTopY);
		// setLocation() 메소드로 좌측 상단 모서리 좌표를 설정
		
		// JWindow에 이미지가 포함된 JLabel 추가
		JLabel label = new JLabel();
		// JLabel은 글자 및 이미지를 포함할 수 있는 컴포넌트
		
		label.setIcon(new ImageIcon(getClass().getResource("game.png")));
		// setIcon() 메소드로 ImageIcon 객체를 매개값으로 주면 이미지를 나타낼 수 있다
		
		getContentPane().add(label, BorderLayout.CENTER);
		
		
		// 마우스 클릭 이벤트 처리
		this.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JWindowExample jwindow = new JWindowExample();
				
				jwindow.setVisible(true);
				// JWindow를 화면에 띄우려면 setVisible(true) 메소드를 호출
			}
		});
	}

}
