import java.util.ArrayList;

public class User extends Subject implements UserInterface {
	//variables
	private String userName;
	
	private ArrayList<String> newsFeed = new ArrayList<String>();
	
//	private ArrayList<User> followedUsers = new ArrayList<User>(); //others that this user follow
//	private ArrayList<User> followingUsers = new ArrayList<User>(); //others following this user
	
//	private static ArrayList<User> allUsersList = new ArrayList<User>();
	
	
	public User(String userName) {
		this.userName = userName;
		User.addUser(this);
	}
	
	public String getUsername() {
		return userName;
	}

	public ArrayList<String> getNewsFeed() {
		return newsFeed;
	}
	
	//become observer of another user (subject)
	public boolean followUser(String username) {
		//could not find user
		User desiredUser = getUser(username);
		
		//false if desired user not found, alr following user, or following self
		if(desiredUser == null || desiredUser.getFollowers().indexOf(this) != -1 || desiredUser.getUsername().equals(this.getUsername())) {
			return false;
		} else {	
			desiredUser.attach(this);
			System.out.println(desiredUser.getFollowers()); 
			return true;
		}
	}

	public boolean post(String message) {
		MessageService.getInstance().saveMessage(this, message);
		notifyFollowers();
		return true;
	}

	//update the followers
	public void update(Subject sub) {
		if(sub instanceof User)
		{
			User subject = (User) sub;
			//add subject's messages to this user's newsfeed
			ArrayList<String> subMessages = MessageService.getInstance().getMessages(subject);
			
			//add message if it doesn't alr exist in feed or feed is empty
			for(String msg : subMessages) {
				if(newsFeed.indexOf(subject.getUsername() + ": "+ msg) == -1 || newsFeed.size() == 0) { //PROBLEM, NOT CHECKING DUPLICATES??
					newsFeed.add(subject.getUsername() + ": " + msg);
					System.out.println(userName + " recieved " + subject.getUsername() + 
							"'s message: " + msg);
				}
			}
		}
	}

	//add user to static list
	public static void addUser(User user) {
		MessageService.getInstance().addUser(user);
	}
	
	//return user based on its string name
	private User getUser(String user) {
		return MessageService.getInstance().getUser(user);
	}
	
}
