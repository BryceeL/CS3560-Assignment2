import java.util.ArrayList;

public class MessagesVisitor implements Visitor {
	public int visit(MessageService instance) {
		int messageCount = 0;
		Object[] userObjs = instance.getUsers().toArray();
		ArrayList<User> users = new ArrayList<User>();
		
		//put users from object array to user array
		for(Object o : userObjs) {
			users.add((User) o);
		}
		//count messages from each user from array
		for(User u : users) {
			ArrayList<String> userMsgs = instance.getMessages(u);
			for(String msg : userMsgs) {
				messageCount += 1;
			}
		}
		return messageCount;
	}

}
