import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
//singleton & visitable
public class MessageService implements Visitable {

	//hash map with names as keys and its content as respective content
	private static HashMap<User, ArrayList<String>> hashmap = new HashMap<User, ArrayList<String>>();
	private static ArrayList<Group> groupList = new ArrayList<Group>();
	private static MessageService instance;
	
	private MessageService() {};
	
	//get instance
	public static MessageService getInstance() {
		if (instance == null) {
			instance = new MessageService();
		}
		return instance;
	}
	
	//get messages posted by a user
	public ArrayList<String> getMessages(User user) {
		return hashmap.get(user);
	}
	
	//get all users from static hashmap
	public Set<User> getUsers() { 
		return hashmap.keySet();
	}
	
	//save user's message to its array of messages
	public void saveMessage(User user, String message) {
		getMessages(user).add(message);
	}
	
	//add user to hashmap 
	public void addUser(User user) {
		hashmap.put(user, new ArrayList<String>());
	}
	
	//find user(aka key) from static hashmap
	public User getUser(String username) {
		for(User user : getUsers() ) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	//add group to static list
	public void addGroup(Group group) {
		groupList.add(group);
	}
	
	//get static list
	public ArrayList<Group> getGroups() {
		return groupList;
	}

	//accepts visitors
	public int accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
