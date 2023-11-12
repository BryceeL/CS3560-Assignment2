import java.util.ArrayList;

public class User implements UserInterface {
	//vars
	private String userName;
	private ArrayList<User> followedUsers;
	
	public User(String userName) {
		this.userName = userName;
	}
	
	public String getUsername() {
		return userName;
	}

	@Override
	public ArrayList<User> getFollowedUsers() {
		return followedUsers;
	}

	@Override
	public ArrayList<String> getTweetFeed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void followUser(User Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postTweet(String tweet) {
		// TODO Auto-generated method stub
		
	}
	
}
