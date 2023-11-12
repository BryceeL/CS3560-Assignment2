import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class UserPanel extends JFrame {
	private JPanel leftPanel;
	private JTextField followUserText;
	private JButton followUserBtn;
	
	
	private JPanel rightPanel;
	private JList followUserList;
	
	public UserPanel(User user) {
		//frame
		this.setTitle("User Panel: " + user.getUsername());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		//top panel
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.RED);
		leftPanel.setPreferredSize(new Dimension(400, 230));

		this.add(leftPanel, BorderLayout.WEST);
		
		createTopSection();
		
		//bottom panel
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.BLUE);
		rightPanel.setPreferredSize(new Dimension(400, 240));
		this.add(rightPanel, BorderLayout.EAST);
	}
	
	private void createTopSection() {
		followUserText = new JTextField(20);
		leftPanel.add(followUserText);
		
		followUserBtn = new JButton("Follow User");
		leftPanel.add(followUserBtn);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		JList<String> followUserList = new JList<>(listModel);
		
		JScrollPane list = new JScrollPane(followUserList);
		list.setPreferredSize(new Dimension(200,300));
		leftPanel.add(list);
		
		
	}
}
