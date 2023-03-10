package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

public class JTreeExample2 extends JFrame{
	
	private JTree jTree;
	
	// 메인 윈도우 설정
	public JTreeExample2() {
		this.setTitle("JTreeExample2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJTree()), BorderLayout.CENTER);
		this.setSize(200, 150);
	}
	
	// JTree 생성
	public JTree getJTree() {
		
		if(jTree == null) {
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("그룹리스트");
			
			DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("친구");
			node1.add(new DefaultMutableTreeNode("친구1"));
			node1.add(new DefaultMutableTreeNode("친구2"));
			root.add(node1);
			
			DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("회사동료");
			node2.add(new DefaultMutableTreeNode("동료1"));
			node2.add(new DefaultMutableTreeNode("동료2"));
			root.add(node2);
			
			jTree = new JTree(root);
			
			// 노드 표현 방법 변경
			jTree.setCellRenderer(new MyTreeCellRenderer());
			
		}
		
		return jTree;
	}

	// TreeCellRenderer 정의
	public class MyTreeCellRenderer implements TreeCellRenderer {

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
				boolean leaf, int row, boolean hasFocus) {
			if(!leaf) {
				JLabel jLabel = new JLabel();
				jLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
				// 노드 간 상하 간격
				
				jLabel.setIcon(new ImageIcon(getClass().getResource("snow.jpg")));
				jLabel.setText(value.toString());
				return jLabel;
			} else {
				JPanel jPanel = new JPanel();
				jPanel.setBackground(Color.WHITE);
				jPanel.setLayout(new BorderLayout());
				jPanel.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
				// 노드 간 상하 간격
				
				JLabel lblWest = new JLabel(new ImageIcon(getClass().getResource("new.gif")));
				JLabel lblCenter = new JLabel("  " + value.toString() + "  ");
				JLabel lblEast = new JLabel(new ImageIcon(getClass().getResource("game.png")));
				
				jPanel.add(lblWest, BorderLayout.WEST);
				jPanel.add(lblCenter, BorderLayout.CENTER);
				jPanel.add(lblEast, BorderLayout.EAST);
				
				if(sel) {
					// 노드 선택 시 오렌지 배경색 설정
					jPanel.setBackground(Color.ORANGE);
				}
				return jPanel;
		}
	}
}


	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JTreeExample2 jFrame = new JTreeExample2();
				jFrame.setVisible(true);
			}
		});
	}

}
