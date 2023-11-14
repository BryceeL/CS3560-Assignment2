import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class UserPanel extends JFrame {
	//ui components
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	//vars
	DefaultListModel<String> listModel = new DefaultListModel<>();
	Dimension panelSize = new Dimension(318, 240);
	Dimension scrollSize = new Dimension(260, 300);
	
	public UserPanel(User user) {
		//frame
		this.setTitle("User Panel: " + user.getUsername());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(650, 430);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		//left panel
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.LIGHT_GRAY);
		leftPanel.setPreferredSize(panelSize);

		this.add(leftPanel, BorderLayout.WEST);
		
		createLeftSection(user);
		
		//right panel
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.LIGHT_GRAY);
		rightPanel.setPreferredSize(panelSize);
		this.add(rightPanel, BorderLayout.EAST);
		
		createRightSection(user);
	}
	
	//-----------function to follow another user and see list of who you follow-----------
	private void createLeftSection(User user) {
		JTextField followUserText = new JTextField(10);
		followUserText.setFont(new Font("Arial", Font.PLAIN, 16));
		leftPanel.add(followUserText);
		
		JButton followUserBtn = new JButton("Follow User");
		followUserBtn.setFont(new Font("Arial", Font.BOLD, 13));
		followUserBtn.setPreferredSize(new Dimension(120,25));
		
		//function: this user (observer) follows another user (subject)
		followUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if( user.followUser(followUserText.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Unable to follow " 
								+ followUserText.getText(), "Error with Follow", JOptionPane.ERROR_MESSAGE);
				} else {
					followUserText.setText("");
					//refresh following list
					listModel.clear();
					for(User following : user.getFollowingList()) {
						listModel.addElement("- " + following.getUsername());
					}
				}
			}
			
		});
		leftPanel.add(followUserBtn);
		
		JLabel label = new JLabel(user.getUsername() + " is Following:");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		leftPanel.add(label);
		
		for(User following : user.getFollowingList()) {
			listModel.addElement("- " + following.getUsername());
		}
		JList<String> followUserList = new JList<>(listModel);
		followUserList.setFont(new Font("Arial", Font.PLAIN, 15));
		JScrollPane scroll = new JScrollPane(followUserList);
		scroll.setPreferredSize(new Dimension(scrollSize));
		leftPanel.add(scroll);
	}
	
	//-----------function post message and see list of posts sent from followings-----------
	private void createRightSection(User user) {
		JTextField messageText = new JTextField(10);
		messageText.setFont(new Font("Arial", Font.PLAIN, 16));
		rightPanel.add(messageText);
		
		JButton postBtn = new JButton("Post");
		postBtn.setFont(new Font("Arial", Font.BOLD, 13));
		postBtn.setPreferredSize(new Dimension(120,25));
		//post message
		postBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if( user.post(messageText.getText()) && !(messageText.getText().trim().equals(""))) {
					JOptionPane.showMessageDialog(null, "Successfully posted your message", "Posted", JOptionPane.PLAIN_MESSAGE);
					messageText.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Unable to post your message", "Error Posting", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		rightPanel.add(postBtn);
		
		JLabel label = new JLabel(user.getUsername() + "'s News Feed: ");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		rightPanel.add(label);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		//get user's feed
		for(String message : user.getNewsFeed()) {
			listModel.addElement("- " + message);
		}
		JList<String> newsList = new JList<>(listModel);
		newsList.setFont(new Font("Arial", Font.PLAIN, 15));
		JScrollPane scroll = new JScrollPane(newsList);
		scroll.setPreferredSize(new Dimension(scrollSize));
		rightPanel.add(scroll);
		
//		JLabel userLabel = new JLabel("("+user.toString()+")");
//		rightPanel.add(userLabel);
		
		//button to refresh news feed
		JButton refreshBtn = new JButton("Refresh News Feed");
		refreshBtn.setPreferredSize(new Dimension(150, 20));
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.clear();
				for(String message : user.getNewsFeed()) {
					listModel.addElement("- " + message);
				}
			}
		});
		rightPanel.add(refreshBtn);
	}
}
