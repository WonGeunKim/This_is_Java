package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JComboBoxExample extends JFrame{

	private JPanel pNorth;
	private JComboBox comboString;
	private JComboBox comboImage;
	private JLabel jLabel;
	
	// 메인 윈도우 설정
	public JComboBoxExample() {
		this.setTitle("JComboBoxExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().add(getPNorth(), BorderLayout.NORTH);
		this.getContentPane().add(getJLabel(), BorderLayout.CENTER);
		this.setSize(250, 200);
		
	}
	
	// 상단 목록 JPanel 생성
	public JPanel getPNorth() {
		
		if(pNorth == null) {
			pNorth = new JPanel();
			pNorth.add(getComboString());
			pNorth.add(getComboImage());
		}
		
		return pNorth;
	}

	// 텍스트 목록을 갖는 JComboBox 생성
	public JComboBox getComboString() {
		
		if(comboString == null) {
			String[] arrString = {
					"Cantaloupe", "Grapefruit", "Grapes", "Kiwi", "Peach",
					"pineapple", "strawberry", "tomato", "watermelon"};
			
			comboString = new JComboBox(arrString);
			comboString.setBackground(Color.WHITE);
			comboString.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int selectIndex = comboString.getSelectedIndex();
					ImageIcon image = new ImageIcon(getClass().getResource("fruit" + (selectIndex + 1) + ".jpg"));
					getJLabel().setIcon(image);
				}
			});
		}
		
		return comboString;
	}


	public JComboBox getComboImage() {
		
		if(comboImage == null) {
			
			Vector vImage = new Vector();
			
			for(int i = 0; i < 10; i++) {
				ImageIcon image = new ImageIcon(getClass().getResource("fruit" + i + ".jpg"));
				vImage.add(image);
			}
			
			comboImage = new JComboBox(vImage);
			comboImage.setBackground(Color.WHITE);
			comboImage.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					ImageIcon image = (ImageIcon) comboImage.getSelectedItem();
					getJLabel().setIcon(image);
				}
			});
		}
		
		return comboImage;
	}

	// 선택된 항목의 이미지를 보여주는 JLabel 생성
	public JLabel getJLabel() {
		
		if(jLabel == null) {
			jLabel = new JLabel();
			jLabel.setHorizontalAlignment(JLabel.CENTER);
		}
		
		return jLabel;
	}


	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JComboBoxExample jFrame = new JComboBoxExample();
				jFrame.setVisible(true);
			}
		});
	}

}
