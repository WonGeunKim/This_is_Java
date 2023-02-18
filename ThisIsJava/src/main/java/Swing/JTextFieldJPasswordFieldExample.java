package Swing;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// JTextField와 JPasswordField는 단일 라인의 텍스트 입력란을 제공하는 컴포넌트
// 차이점은 JPasswordField는 사용자의 입력을 다른 사람이 볼 수 없도록 숨긴다는 것

public class JTextFieldJPasswordFieldExample extends JFrame{
	
	private JTextField txtId;
	private JPasswordField txtPassword;
	
	// 메인 윈도우 설정
	public JTextFieldJPasswordFieldExample() {
		this.setTitle("JTextField & JPasswordField");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(2, 2));
		this.getContentPane().add(new JLabel("아이디", JLabel.CENTER));
		this.getContentPane().add(getTxtId());
		this.getContentPane().add(new JLabel("패스워드", JLabel.CENTER));
		this.getContentPane().add(getTxtPassword());
		this.setSize(200, 100);
		
	}
	
	// JTextFiedl 생성
	public JTextField getTxtId() {

		if(txtId == null) {
			txtId = new JTextField();
			txtId.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() >= KeyEvent.VK_A && e.getKeyCode() <= KeyEvent.VK_Z) {
						JOptionPane.showMessageDialog(JTextFieldJPasswordFieldExample.this, "알파벳 이군요");
					}else {
						JOptionPane.showMessageDialog(JTextFieldJPasswordFieldExample.this, "알파벳이 아니군요");
					}
				}
			});
		}
		return txtId;
	}

	// JPasswordField 생성
	public JPasswordField getTxtPassword() {

		if(txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String password = new String(txtPassword.getPassword());
					JOptionPane.showMessageDialog(JTextFieldJPasswordFieldExample.this, "입력한 패스워드 : " + password);
				}
			});
		}
		return txtPassword;
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JTextFieldJPasswordFieldExample jFrame = new JTextFieldJPasswordFieldExample();
				jFrame.setVisible(true);
			}
		});
		
	}

}
