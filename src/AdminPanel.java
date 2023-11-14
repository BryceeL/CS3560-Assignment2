import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class AdminPanel extends JFrame {
	//ui components
	private JPanel leftPanel;
	private JPanel leftUpPanel;
	private JTree tree;
	
	private JPanel rightPanel;
	
	private JPanel rightUpPanel;
//	private JTextField userIdText;
//	private JTextField groupIdText;
//	private JButton userIdBtn;
//	private JButton groupIdBtn;
	
	private JPanel rightMidPanel;
//	private JButton openUserBtn;
	
	private JPanel rightBtmPanel;
//	private JButton totalUsersBtn;
//	private JButton totalGroupsBtn;
//	private JButton totalMsgsBtn;
//	private JButton postivePercentBtn;
	
	//variables
	private DefaultMutableTreeNode selectedNode;
	
	public AdminPanel() {
		//frame
		this.setTitle("Admin Panel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminate execution on x
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
		//right UP Panel
		rightUpPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		rightUpPanel.setBackground(Color.GRAY);
		rightUpPanel.setPreferredSize(rightPanelSize);
		rightPanel.add(rightUpPanel);
		
		createIdSection();
		
		//right MID Panel
		rightMidPanel = new JPanel();
		rightMidPanel.setBackground(Color.GRAY);
		rightMidPanel.setPreferredSize(rightPanelSize);
		rightPanel.add(rightMidPanel);
		
		createUserViewSection();
		
		//right BOTTOM Panel
		rightBtmPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
		rightBtmPanel.setBackground(Color.GRAY);
		rightBtmPanel.setPreferredSize(rightPanelSize);
		rightPanel.add(rightBtmPanel);
		
		createStatSection();
	}
	
	//-----------creates tree and its label on left of frame-----------
	private void createTree() {
		JLabel label = new JLabel("Tree View");
		label.setFont(new Font("Arial", Font.BOLD, 24));
		label.setForeground(Color.BLACK);
		leftUpPanel.add(label);
		
		DefaultMutableTreeNode RootNode = new DefaultMutableTreeNode("Root");
		tree = new JTree(RootNode);
		tree.setPreferredSize(new Dimension(300,400));
		
		//--DEBUG!!!!
		User Auser = new User("Trey");
		DefaultMutableTreeNode AuserNode = new DefaultMutableTreeNode(Auser.getUsername());
		RootNode.add(AuserNode);
		User Buser = new User("Bryce");
		DefaultMutableTreeNode BuserNode = new DefaultMutableTreeNode(Buser.getUsername());
		RootNode.add(BuserNode);
		
		//respond to selected node
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if(node != null) {
					Object nodeData = node.getUserObject(); //gets selected node's object data
					selectedNode = node;
					System.out.println("Selected: " + selectedNode);
				}
			}
			
		});

		leftPanel.add(tree);
	}
	
	//-----------creates textfields and submit buttons on top right of frame-----------
	private void createIdSection() {
		Dimension btnSize = new Dimension(120, 30);
		
		//text field to input user
		JTextField userIdText = new JTextField(12);
		userIdText.setFont(new Font("Arial", Font.PLAIN, 20));
		rightUpPanel.add(userIdText);
		
		//button to submit user
		JButton userIdBtn = new JButton("Add User");
		userIdBtn.setFont(new Font("Arial", Font.BOLD, 14));
		userIdBtn.setPreferredSize(btnSize);
		//add user under selected node (MAKE IT SO IT CAN ONLY BE ADD TO GROUP NODE)
		userIdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedNode != null) {//&& it is added to group && user doesn't already exist
					if(!userIdText.getText().trim().equals("")) {
						User user = new User(userIdText.getText());
						DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user.getUsername());
						selectedNode.add(userNode);
						userIdText.setText("");
						((DefaultTreeModel) tree.getModel()).reload();
					} else {
						JOptionPane.showMessageDialog(null, "Please fill in the username field", 
								"Username Field Empty", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select a node to add user "+ 
							userIdText.getText(), "No selected Node", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		rightUpPanel.add(userIdBtn);
		
		//text field to input group
		JTextField groupIdText = new JTextField(12);
		groupIdText.setFont(new Font("Arial", Font.PLAIN, 20));
		rightUpPanel.add(groupIdText);
		
		//button to submit group
		JButton groupIdBtn = new JButton("Add Group");
		groupIdBtn.setFont(new Font("Arial", Font.BOLD, 14));
		groupIdBtn.setPreferredSize(btnSize);
		//adds group to tree under the root
		groupIdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Group group = new Group(groupIdText.getText());
				Group.add(group);
				DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode("GROUP: " + group.getName());		
				DefaultMutableTreeNode rootOfTree = (DefaultMutableTreeNode) tree.getModel().getRoot();
				rootOfTree.add(groupNode);
				groupIdText.setText("");
				((DefaultTreeModel) tree.getModel()).reload();
			}
		});
		rightUpPanel.add(groupIdBtn);
	}
	
	//-----------creates button to view user on right middle of frame-----------
	private void createUserViewSection() {
		JButton openUserBtn = new JButton("Open User View");
		openUserBtn.setFont(new Font("Arial", Font.BOLD, 18));
		openUserBtn.setPreferredSize(new Dimension(250, 50));
		
		//open user panel for a particular user
		openUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedNode != null)
				{
					String nodeData = (String) selectedNode.getUserObject();
					User user = MessageService.getInstance().getUser(nodeData);
					if( user != null) {
						UserPanel userframe = new UserPanel(user);
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Please select a valid user node from the tree",
											"Invalid Node", JOptionPane.ERROR_MESSAGE);
			
			}
			
		});
		
		rightMidPanel.add(openUserBtn);
	}
	
	//-----------create buttons to view statistics on right bottom of frame-----------
	private void createStatSection() {
		Dimension btnSize = new Dimension(160, 40);
		JButton totalUsersBtn = new JButton("Show Total Users");
		totalUsersBtn.setPreferredSize(btnSize);
		//display total users
		totalUsersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Total Users: " 
						+ MessageService.getInstance().getUserSetSize(), "Total Users", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		});
		rightBtmPanel.add(totalUsersBtn);
		
		JButton totalGroupsBtn = new JButton("Show Total Groups");
		totalGroupsBtn.setPreferredSize(btnSize);
		//display total groups
		totalGroupsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Total Groups: " 
						+ Group.getGroups().size(), "Total Groups", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		rightBtmPanel.add(totalGroupsBtn);
		
		JButton totalMsgsBtn = new JButton("<html>Show Total<br>Messages</html>");
		totalMsgsBtn.setPreferredSize(btnSize);
		//display total messages
		totalMsgsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Total Messages: " 
						+ null, "Total Messages", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		rightBtmPanel.add(totalMsgsBtn);
		
		JButton postivePercentBtn = new JButton("<html>Show Positve<br>Percentage</html>");
		postivePercentBtn.setPreferredSize(btnSize);
		//display positive percentage
		postivePercentBtn.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Positive Percentage: " 
						+ null, "Total Messages", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		rightBtmPanel.add(postivePercentBtn);
	}
}
