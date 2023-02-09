package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JPanelExample extends JFrame{

	private JPanel panelSouth;
	private JButton btnOk;
	private JButton btnCancel;
	
	// 메인 윈도우 설정
	public JPanelExample() {
		this.setTitle("JPanelExample");
		this.setSize(250, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 남쪽에 JPanel 추가
		this.getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
	}
	
	// JPanel 생성
	private JPanel getPanelSouth() {
		
		if(panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.setBackground(Color.WHITE);
			panelSouth.add(getBtnOk());
			panelSouth.add(getBtnCancel());
		}
		
		return panelSouth;
	}

	// OK 버튼 생성
	private JButton getBtnOk() {
		
		if(btnOk == null) {
			btnOk = new JButton();
			btnOk.setText("확인");
		}
		
		return btnOk;
	}

	// Cancel 버튼 생성
	private JButton getBtnCancel() {

		if(btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("취소");
		}
		
		return btnCancel;
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JPanelExample jFrame = new JPanelExample();
				jFrame.setVisible(true);
			}
			
		});
		
	}

}
