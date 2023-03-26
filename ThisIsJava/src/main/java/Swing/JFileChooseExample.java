package Swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFileChooseExample extends JFrame{
	
	private JButton btnFileOpne, btnFileSave;
	
	
	// 메인 윈도우 설정
	public JFileChooseExample() {
		this.setTitle("JFileChooseExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(2, 1));
		this.getContentPane().add(getBtnFileOpne());
		this.getContentPane().add(getBtnFileSave());
		this.setSize(150, 100);
	}
	
	// 열기 버튼 생성
	public JButton getBtnFileOpne() {
		
		if(btnFileOpne == null) {
			btnFileOpne = new JButton();
			btnFileOpne.setText("File Open");
			btnFileOpne.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// 파일 열기 다이얼로그 보여주기
					JFileChooser jFileChooser = new JFileChooser();
					jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
							"그림파일(*.jpg, *.gif, *.bmp)", "jpg", "gif", "bmp"
							));
					jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
							"텍스트 파일(*.txt)", "txt"
							));
					
					int option = jFileChooser.showOpenDialog(JFileChooseExample.this);
					
					// 어떤 버튼을 클릭했는지 확인하기
					if(option == JFileChooser.APPROVE_OPTION) {
						
						File file = jFileChooser.getSelectedFile();
						System.out.println("열어야 할 파일 절대경로 : " + file.getAbsolutePath());
						System.out.println("열어야 할 파일 이름 : " + file.getName());
						
					} else if(option == JFileChooser.CANCEL_OPTION) {
						System.out.println("취소 또는 닫기를 눌렀군요");
					}
					
				}
			});
		}
		
		return btnFileOpne;
	}

	// 저장 버튼 생성
	public JButton getBtnFileSave() {
		
		if(btnFileSave == null) {
			btnFileSave = new JButton();
			btnFileSave.setText("File Save");
			btnFileSave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// 파일 저장 다이얼로그 보여주기
					JFileChooser jFileChooser = new JFileChooser();
					jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
							"그림파일(*.jpg, *.gif, *.bmp)", "jpg", "gif", "bmp"
							));
					jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
							"텍스트 파일(*.txt)", "txt"
							));
					
					int option = jFileChooser.showOpenDialog(JFileChooseExample.this);
					
					// 어떤 버튼을 클릭했는지 확인하기
					if(option == JFileChooser.APPROVE_OPTION) {
						
						File file = jFileChooser.getSelectedFile();
						System.out.println("저장할 파일 : " + file.getAbsolutePath());
					} else if(option == JFileChooser.CANCEL_OPTION) {
						System.out.println("취소 또는 닫기를 눌렀군요");
					}
				}
			});
		}
		
		return btnFileSave;
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JFileChooseExample jFrame = new JFileChooseExample();
				jFrame.setVisible(true);
			}
		});
		
		
	}

}
