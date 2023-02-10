package Swing;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GridLayoutExample extends JFrame{

	private JButton[][] btn;
	
	// 메인 윈도우 설정
	public GridLayoutExample() {
		
		setTitle("GridLayoutExample");
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// GridLayout으로 변경하고 버튼 추가
		setLayout(new GridLayout(2, 3));
		for(int i = 0; i < 2; i++) {
			
			for(int j = 0; j < 3; j++) {
				getContentPane().add(getBtn()[i][j]);
			}
		}
		
	}
	
	// 버튼 배열 생성
	public JButton[][] getBtn() {

		if(btn == null) {
			btn = new JButton[2][3];
			
			for(int x = 0; x < 2; x++) {
				for(int y = 0; y < 3; y++) {
					btn[x][y] = new JButton();
					btn[x][y].setText("[" + x + "][" + y + "]");
				}
			}
		}
		
		return btn;
	}


	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				GridLayoutExample jFrame = new GridLayoutExample();
				jFrame.setVisible(true);
			}
			
		});
		
	}

}
