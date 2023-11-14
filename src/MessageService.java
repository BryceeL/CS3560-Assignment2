import java.util.ArrayList;
import java.util.HashMap;

public class MessageService {

	//hash map with names as keys and its content as respective content
	private static HashMap<User, ArrayList<String>> hashmap = new HashMap<User, ArrayList<String>>(); 
	private static MessageService instance;
	
	private MessageService() {};
	
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
	
	public int getUserSetSize() {
		return hashmap.keySet().size();
	}
	
	//save user's message to its array
	public void saveMessage(User user, String message) {
		getMessages(user).add(message);
	}
	
	//add user to hashmap 
	public void addUser(User user) {
		hashmap.put(user, new ArrayList<String>());
	}
	
	//find user(aka key) from hashmap
	public User getUser(String username) {
		for(User user : hashmap.keySet()) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
}
