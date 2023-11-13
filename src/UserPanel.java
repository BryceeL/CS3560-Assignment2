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
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	public UserPanel(User user) {
		//frame
		this.setTitle("User Panel: " + user.getUsername());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(750, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		//top panel
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.LIGHT_GRAY);
		leftPanel.setPreferredSize(new Dimension(400, 230));

		this.add(leftPanel, BorderLayout.WEST);
		
		createLeftSection(user);
		
		//bottom panel
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.LIGHT_GRAY);
		rightPanel.setPreferredSize(new Dimension(400, 240));
		this.add(rightPanel, BorderLayout.EAST);
		
		createRightSection(user);
	}
	
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
				// TODO Auto-generated method stub
				if( user.followUser(followUserText.getText()) == false)
					JOptionPane.showMessageDialog(null, "Unable to follow " 
								+ followUserText.getText(), "Error with Follow", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Successfully followed " 
							+ followUserText.getText(), "Followed", JOptionPane.PLAIN_MESSAGE);
			}
			
		});
		
		leftPanel.add(followUserBtn);
		
		JLabel label = new JLabel(user.getUsername() + "'s Followers:");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		leftPanel.add(label);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		
//		System.out.println(user.getFollowers());
		for(User follower : user.getFollowers()) {
			listModel.addElement("- " + follower.getUsername());
		}
		
		JList<String> followUserList = new JList<>(listModel);
		followUserList.setFont(new Font("Arial", Font.PLAIN, 15));
		JScrollPane scroll = new JScrollPane(followUserList);
		scroll.setPreferredSize(new Dimension(300,350));
		leftPanel.add(scroll);
	}
	private void createRightSection(User user) {
		JTextField tweetText = new JTextField(10);
		tweetText.setFont(new Font("Arial", Font.PLAIN, 16));
		rightPanel.add(tweetText);
		
		JButton postBtn = new JButton("Post");
		postBtn.setFont(new Font("Arial", Font.BOLD, 13));
		postBtn.setPreferredSize(new Dimension(120,25));
		rightPanel.add(postBtn);
		
		JLabel label = new JLabel(user.getUsername() + "'s News Feed: ");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		rightPanel.add(label);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		JList<String> newsList = new JList<>(listModel);
		JScrollPane scroll = new JScrollPane(newsList);
		scroll.setPreferredSize(new Dimension(300,350));
		rightPanel.add(scroll);
		
		JLabel userLabel = new JLabel("("+user.toString()+")");
		rightPanel.add(userLabel);
	}
}
