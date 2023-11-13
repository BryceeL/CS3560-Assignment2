import java.util.ArrayList;

public class User extends Subject implements UserInterface {
	//variables
	private String userName;
	private ArrayList<User> followedUsers = new ArrayList<User>(); //others that this user follow
	private ArrayList<User> followingUsers = new ArrayList<User>(); //others following this user
	
	private static ArrayList<User> allUsersList = new ArrayList<User>();
	
	public User(String userName) {
		this.userName = userName;
	}
	
	public String getUsername() {
		return userName;
	}

	@Override
	public ArrayList<String> getTweetFeed() {
		// TODO Auto-generated method stub
		return null;
	}

	//become observer of another user (subject)
	@Override
	public boolean followUser(String username) {
		//could not find user
		User desiredUser = getUser(username);
		
		//false if user not found, alr following user, or following self
		if(desiredUser == null || desiredUser.getFollowers().indexOf(this) != -1 || desiredUser.getUsername().equals(this.getUsername())) {
			return false;
		} else {	
			desiredUser.attach(this);
			System.out.println(desiredUser.getFollowers()); 
			
			return true;
		}
		
	}

	@Override
	public void postTweet(String tweet) {
		// TODO Auto-generated method stub
		
	}

	//update the followers
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		
	}
	
	//STATIC METHODS
	//add user to static list
	public static void addUser(User user) {
		allUsersList.add(user);
	}
	
	//get static list
	public static ArrayList<User> getUserList() {
		return allUsersList;
	}
	
	//HELPER METHODS
	private static User getUser(String user) {
		for(User u : allUsersList) {
			if(u.getUsername().equals(user))
				return u;
		}
		return null;
	}
	
	//
	
}
