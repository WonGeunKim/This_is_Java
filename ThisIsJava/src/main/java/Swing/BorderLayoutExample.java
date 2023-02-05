package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BorderLayoutExample extends JFrame{

	private JTextField txtNorth;
	private JTextArea txtCenter;
	private JButton btnSouth;
	
	// 메인 윈도우 설정
	public BorderLayoutExample() {
		this.setTitle("BorderLayoutExample");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 북쪽, 중앙, 남쪽에 컴포넌트 배치
		this.getContentPane().add(getTxtNorth(), BorderLayout.NORTH);
		this.getContentPane().add(getTxtCenter(), BorderLayout.CENTER);
		this.getContentPane().add(getBtnSouth(), BorderLayout.SOUTH);
	}

	// JButton 생성
	private JButton getBtnSouth() {
		
		if(btnSouth == null) {
			btnSouth = new JButton();
			btnSouth.setText("남쪽 컴포넌트");
		}
		
		return btnSouth;
	}

	// JTextArea
	private JTextArea getTxtCenter() {

		if(txtCenter == null) {
			txtCenter = new JTextArea();
			txtCenter.append("중앙 컴포넌트\n");
			txtCenter.append("동쪽 컴포넌트가 없으니 동쪽으로 확장\n");
			txtCenter.append("서쪽 컴포넌트가 없으니 서쪽으로 확장\n");
		}
		
		return txtCenter;
	}

	// JTextField 생성
	private JTextField getTxtNorth() {
		
		if(txtNorth == null) {
			txtNorth = new JTextField();
			txtNorth.setText("북쪽 컴포넌트");
			txtNorth.setBackground(Color.yellow);
		}
		
		return txtNorth;
	}

	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				BorderLayoutExample jFrame = new BorderLayoutExample();
				jFrame.setVisible(true);
			}
			
		});
	}

}
