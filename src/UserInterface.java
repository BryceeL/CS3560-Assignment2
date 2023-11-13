import java.util.ArrayList;

public interface UserInterface {

	public String getUsername();
	
	public ArrayList<String> getTweetFeed();
	
	public boolean followUser(String username);
	
	public void postTweet(String tweet);
	
	//observer
	public void update(Subject subject);
}
