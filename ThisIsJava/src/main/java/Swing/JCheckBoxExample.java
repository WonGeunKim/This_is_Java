package Swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JCheckBoxExample extends JFrame{

	private JPanel pWest;
	private JCheckBox cbGlasses;
	private JCheckBox chHair;
	private JLabel lblPicture;
	
	// 메인 윈도우 설정
	public JCheckBoxExample() {
		this.setTitle("JCheckBoxExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getPWest(), BorderLayout.WEST);
		this.getContentPane().add(getLblPicture(), BorderLayout.CENTER);
		this.pack();
	}
	
	// 서쪽에 부착할 JPanel 생성
	public JPanel getPWest() {

		if(pWest == null) {
			pWest = new JPanel(new GridLayout(2, 1));
			
			// JCheckBox 추가
			pWest.add(getCbGlasses());
			pWest.add(getCbHair());
		}
		
		return pWest;
	}

	// JCheckBox 생성
	public JCheckBox getCbGlasses() {

		if(cbGlasses == null) {
			cbGlasses = new JCheckBox();
			cbGlasses.setText("Glasses");
			cbGlasses.addActionListener(actionListener);
		}
		
		return cbGlasses;
	}

	public JCheckBox getCbHair() {

		if(chHair == null) {
			chHair = new JCheckBox();
			chHair.setText("Hair");
			chHair.addActionListener(actionListener);
		}
		
		return chHair;
	}

	// JCheckBox 생성
	public JLabel getLblPicture() {

		if(lblPicture == null) {
			lblPicture = new JLabel();
			lblPicture.setIcon(new ImageIcon(getClass().getResource("game.png")));
		}
		
		return lblPicture;
	}

	// JCheckBox 이벤트 처리 리스너를 위한 필드 선언
	private ActionListener actionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(cbGlasses.isSelected() && chHair.isSelected()) {
				lblPicture.setIcon(new ImageIcon(getClass().getResource("new.gif")));
			} else if(cbGlasses.isSelected()) {
				lblPicture.setIcon(new ImageIcon(getClass().getResource("snow.jpg")));
			} else if(chHair.isSelected()) {
				lblPicture.setIcon(new ImageIcon(getClass().getResource("game.png")));
			} else {
				lblPicture.setIcon(new ImageIcon(getClass().getResource("new.gif")));
			}
			
		}
	};


	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JCheckBoxExample jFrame = new JCheckBoxExample();
				jFrame.setVisible(true);
			}
		});
		
	}

}
