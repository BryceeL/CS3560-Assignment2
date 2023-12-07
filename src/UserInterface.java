import java.util.ArrayList;

public interface UserInterface {

	public String getUsername();
	
	public long getCreationTime();
	
	public long getLastUpdateTime();
	
	public ArrayList<String> getNewsFeed();
	
	public boolean followUser(String username);
	
	public boolean post(String message);
	
	//observer
	public void update(Subject sub);
}
