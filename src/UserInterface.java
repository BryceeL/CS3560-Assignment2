import java.util.ArrayList;

public interface UserInterface {

	public String getUsername();
	
	public ArrayList<User> getFollowedUsers();
	
	public ArrayList<String> getTweetFeed();
	
	public void followUser(User Id);
	
	public void postTweet(String tweet);
}
