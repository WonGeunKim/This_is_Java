package Swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// JTextArea : 멀티 라인의 텍스트를 편집할 수 있는 컴포넌트 
// JTextArea는 자체적으로 스크롤을 제공하지 않으므로 JScrollPane에 추가해서 사용

public class JTextAreaExample extends JFrame{
	
	private JTextArea txtDisplay;
	private JPanel pSouth;
	private JTextField txtInput;
	private JButton btnSend;
	
	// 메인 윈도우 설정
	public JTextAreaExample() {
		this.setTitle("JTextAreaExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
		this.setSize(300, 200);
	}
	
	// JTextArea 생성
	public JTextArea getTxtDisplay() {
		if(txtDisplay == null) {
			txtDisplay = new JTextArea();
			txtDisplay.setEditable(false);
		}
		return txtDisplay;
	}

	// 남쪽에 부착할 JPanel 생성
	public JPanel getPSouth() {

		if(pSouth == null) {
			pSouth = new JPanel();
			pSouth.setLayout(new BorderLayout());
			pSouth.add(getTxtInput(), BorderLayout.CENTER);
			pSouth.add(getBtnSend(), BorderLayout.EAST);
		}
		
		return pSouth;
	}

	// JTextField 생성
	public JTextField getTxtInput() {

		if(txtInput == null) {
			txtInput = new JTextField();
		}
		
		return txtInput;
	}

	// JButton 생성
	public JButton getBtnSend() {

		if(btnSend == null) {
			btnSend = new JButton();
			btnSend.setText("전송");
			btnSend.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					getTxtDisplay().append(getTxtInput().getText() + "\n");
					getTxtInput().setText("");
				}
			});
		}
		
		return btnSend;
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JTextAreaExample jFrame = new JTextAreaExample();
				jFrame.setVisible(true);
			}
		});
		
	}

}
