import javax.swing.JFrame;

public class UserPanel extends JFrame {
	
	public UserPanel(User user) {
		this.setTitle("User Panel: " + user.getUsername());
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //close and ends when press x
		this.setSize(800, 500); //set default size
		this.setLocationRelativeTo(null); //window opens at center of screen
//		this.setResizable(false); //lock size
	}
	
	public void show() {
		this.setVisible(true);
	}
}
