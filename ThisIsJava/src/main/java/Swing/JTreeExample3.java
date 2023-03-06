package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

public class JTreeExample3 extends JFrame{
	
	private JTree jTree;
	
	// 메인 윈도우 설정
	public JTreeExample3() {
		this.setTitle("JTreeExample3");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJTree()), BorderLayout.CENTER);
		this.setSize(200, 150);
	}
	
	//JTree 생성
	public JTree getJTree() {
		
		if(jTree == null) {
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("그룹리스트");
			
			DefaultMutableTreeNode node1 =  new DefaultMutableTreeNode("친구");
			node1.add(new DefaultMutableTreeNode("친구1"));
			node1.add(new DefaultMutableTreeNode("친구2"));
			root.add(node1);
			
			jTree = new JTree(root);
			jTree.setCellRenderer(new MyTreeCellRenderer());
			
			// 이벤트 리스너 추가
			jTree.addTreeSelectionListener(treeSelectionListener);
			jTree.addMouseListener(mouseListener);
			
		}
		
		return jTree;
	}
	
	// TreeSelectionListener 필드 선언
	private TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
		
		@Override
		public void valueChanged(TreeSelectionEvent e) {
			
			TreePath treePath = e.getPath();
			DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
			
			String nodeText = (String) treeNode.getUserObject();
			JOptionPane.showMessageDialog(JTreeExample3.this, "노드 변경 : " + nodeText);
		}
	};
	
	// MouseListener 필드 선언
	private MouseListener mouseListener = new MouseAdapter() {
		
		public void mouseClicked(java.awt.event.MouseEvent e) {
			
			// 더블 클릭이 되었을 경우에만 실행
			if(e.getClickCount() == 2) {
				TreePath treePath = jTree.getPathForLocation(e.getX(), e.getY());
				DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
				String nodeText = (String) treeNode.getUserObject();
				JOptionPane.showMessageDialog(JTreeExample3.this, "더블 클릭 : " + nodeText);
			}
			
		}
	};

	// TreeCellRenderer 정의
	public class MyTreeCellRenderer implements TreeCellRenderer {
		
		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
				boolean leaf, int row, boolean hasFocus) {

			if(!leaf) {
				JLabel jLabel = new JLabel();
				jLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
				jLabel.setIcon(new ImageIcon(getClass().getResource("snow.jpg")));
				jLabel.setText(value.toString());
				return jLabel;
				
			}else {
				JPanel jPanel = new JPanel();
				jPanel.setBackground(Color.WHITE);
				jPanel.setLayout(new BorderLayout());
				jPanel.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
				
				JLabel lblWest = new JLabel(new ImageIcon(getClass().getResource("new.gif")));
				JLabel lblCenter = new JLabel("  " + value.toString() + "  ");
				JLabel lblEast = new JLabel(new ImageIcon(getClass().getResource("game.png")));
				
				jPanel.add(lblWest, BorderLayout.WEST);
				jPanel.add(lblCenter, BorderLayout.CENTER);
				jPanel.add(lblEast, BorderLayout.EAST);
				
				if(sel) {
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
				
				JTreeExample3 jFrame = new JTreeExample3();
				jFrame.setVisible(true);
			}
		});
		
	}




}
