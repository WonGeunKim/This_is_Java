package Swing;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class JTabbedPaneExample extends JFrame{

	private JTabbedPane jTabbedPane;
	private JPanel tab1Panel;
	private JPanel tab2Panel;
	
	// 메인 윈도우 설정
	public JTabbedPaneExample() {
		this.setTitle("JTabbedPaneExample");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getJTabbedPane(), BorderLayout.CENTER);
	}
	
	// JTabbedPane 생성 및 Tab 추가
	private Component getJTabbedPane() {
		
		if(jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			
			jTabbedPane.setTabPlacement(JTabbedPane.LEFT);
			// 탭의 위치를 설정하려면 setTabPlacement() 메소드로 탭의 위치 상수를 지정
			
			jTabbedPane.addTab("탭1", getTab1Panel());
			// JTabbedPane에 탭을 추가하려면 addTab() 메소드를 이용
			
			jTabbedPane.addTab("탭2", getTab2Panel());
		}
		
		return jTabbedPane;
	}
	
	// Tab1에 추가될 JPanel 생성
	private Component getTab2Panel() {

		if(tab1Panel == null) {
			tab1Panel = new JPanel();
			JLabel jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon(getClass().getResource("game.png")));
			tab1Panel.add(jLabel);
		}
		
		return tab1Panel;
	}

	// Tab2에 추가될 JPanel 생성
	private Component getTab1Panel() {
		
		if(tab2Panel == null) {
			tab2Panel = new JPanel();
			JLabel jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon(getClass().getResource("snow.jpg")));
			tab2Panel.add(jLabel);
		}
		
		return tab2Panel;
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JTabbedPaneExample jFrame = new JTabbedPaneExample();
				jFrame.setVisible(true);
			}
		});
	}

}
