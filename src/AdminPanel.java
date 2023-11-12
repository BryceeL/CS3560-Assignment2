import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class AdminPanel extends JFrame {
	//components
	private JPanel leftPanel;
	private JPanel leftUpPanel;
	private JTree tree;
	
	private JPanel rightPanel;
	
	private JPanel rightUpPanel;
	private JTextField userIdText;
	private JTextField groupIdText;
	private JButton userIdBtn;
	private JButton groupIdBtn;
	
	private JPanel rightMidPanel;
	private JButton openUserBtn;
	
	private JPanel rightBtmPanel;
	private JButton totalUsersBtn;
	private JButton totalGroupsBtn;
	private JButton totalMsgsBtn;
	private JButton postivePercentBtn;
	
	
	
	public AdminPanel() {
		//frame
		this.setTitle("Admin Panel");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //close and ends when press x
		this.setSize(800, 500); //set default size
		this.setLocationRelativeTo(null); //window opens at center of screen
		this.setResizable(false); //lock size
		this.setVisible(true);
		
		//left Panel
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.GRAY);
		leftPanel.setPreferredSize(new Dimension(400, 0));
		this.add(leftPanel, BorderLayout.WEST);
		
		//left UP Panel
		leftUpPanel = new JPanel();
		leftUpPanel.setBackground(Color.LIGHT_GRAY);
		leftUpPanel.setPreferredSize(new Dimension(400, 40));
		leftPanel.add(leftUpPanel, BorderLayout.NORTH);
		
		createTree();
		
		//right Panel
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.GRAY);
		rightPanel.setPreferredSize(new Dimension(400, 0));
		this.add(rightPanel, BorderLayout.EAST);
		
		Dimension rightPanelSize = new Dimension(400, 140);
		//right up Panel
		rightUpPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		rightUpPanel.setBackground(Color.GRAY);
		rightUpPanel.setPreferredSize(rightPanelSize);
		rightPanel.add(rightUpPanel);
		
		createIdSection();
		
		//right mid Panel
		rightMidPanel = new JPanel();
		rightMidPanel.setBackground(Color.GRAY);
		rightMidPanel.setPreferredSize(rightPanelSize);
		rightPanel.add(rightMidPanel);
		
		createUserViewBtn();
		
		//right bottom Panel
		rightBtmPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
		rightBtmPanel.setBackground(Color.GRAY);
		rightBtmPanel.setPreferredSize(rightPanelSize);
		rightPanel.add(rightBtmPanel);
		
		createStatSection();
	}
	
	private void createTree() {
		JLabel label = new JLabel("Tree View");
		label.setFont(new Font("Arial", Font.BOLD, 24));
		label.setForeground(Color.BLACK);
		leftUpPanel.add(label);
		
		DefaultMutableTreeNode RootNode = new DefaultMutableTreeNode("Root");
		tree = new JTree(RootNode);
		tree.setPreferredSize(new Dimension(300,400));
		leftPanel.add(tree);
	}
	
	private void createIdSection() {
		Dimension btnSize = new Dimension(120, 30);
		
		userIdText = new JTextField(12);
		userIdText.setFont(new Font("Arial", Font.PLAIN, 20));
		rightUpPanel.add(userIdText);
		
		userIdBtn = new JButton("Add User");
		userIdBtn.setFont(new Font("Arial", Font.BOLD, 14));
		userIdBtn.setPreferredSize(btnSize);
		rightUpPanel.add(userIdBtn);
		
		groupIdText = new JTextField(12);
		groupIdText.setFont(new Font("Arial", Font.PLAIN, 20));
		rightUpPanel.add(groupIdText);
		
		groupIdBtn = new JButton("Add Group");
		groupIdBtn.setFont(new Font("Arial", Font.BOLD, 14));
		groupIdBtn.setPreferredSize(btnSize);
		rightUpPanel.add(groupIdBtn);
	}
	
	private void createUserViewBtn() {
		openUserBtn = new JButton("Open User View");
		openUserBtn.setFont(new Font("Arial", Font.BOLD, 18));
		openUserBtn.setPreferredSize(new Dimension(250, 50));
		rightMidPanel.add(openUserBtn);
	}
	
	private void createStatSection() {
		Dimension btnSize = new Dimension(160, 40);
		totalUsersBtn = new JButton("Show Total Users");
		totalUsersBtn.setPreferredSize(btnSize);
		rightBtmPanel.add(totalUsersBtn);
		
		totalGroupsBtn = new JButton("Show Total Groups");
		totalGroupsBtn.setPreferredSize(btnSize);
		rightBtmPanel.add(totalGroupsBtn);
		
		totalMsgsBtn = new JButton("<html>Show Total<br>Messages</html>");
		totalMsgsBtn.setPreferredSize(btnSize);
		rightBtmPanel.add(totalMsgsBtn);
		
		postivePercentBtn = new JButton("<html>Show Positve<br>Percentage</html>");
		postivePercentBtn.setPreferredSize(btnSize);
		rightBtmPanel.add(postivePercentBtn);
	}
}
