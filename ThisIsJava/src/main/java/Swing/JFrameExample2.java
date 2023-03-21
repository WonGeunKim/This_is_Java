package Swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JFrameExample2 extends JFrame{

	private JButton btnOpenDialog;
	
	// 메인 윈도우 설정
	public JFrameExample2() {
		this.setTitle("JFrame");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getBtnOpenDialog(), BorderLayout.SOUTH);
	}
	
	// 남쪽 버튼 생성
	public JButton getBtnOpenDialog() {
		
		if(btnOpenDialog == null) {
			btnOpenDialog = new JButton();
			btnOpenDialog.setText("다이얼로그 띄우기");
			btnOpenDialog.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// 다이얼로그 띄우기
					JDialogExample jDialog = new JDialogExample(JFrameExample2.this);
					jDialog.setVisible(true);
				}
			});
		}
		
		return btnOpenDialog;
	}


	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrameExample2 jFrame = new JFrameExample2();
				jFrame.setVisible(true);
			}
		});
	}

}
