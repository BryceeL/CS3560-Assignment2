import java.util.ArrayList;

public class PositiveVisitor implements Visitor{
	
	private String[] positiveWords = {"cool", "nice", "awesome", "beautiful",
			"love", "good", "great", "excellent"};
	MessagesVisitor totalMessages = new MessagesVisitor();
	
	public int visit(MessageService instance) {
		int messagesCount = MessageService.getInstance().accept(totalMessages);
		double positveCount = 0;
		Object[] userObjs = instance.getUsers().toArray();
		ArrayList<User> users = new ArrayList<User>();
		
		//put users from object array to user array
		for(Object o : userObjs) {
			users.add( (User) o);
		}
		
		//get messages from each user from array
		for(User u : users) {
			ArrayList<String> userMsgs = instance.getMessages(u);
			for(String msg : userMsgs) {
				positiveSearch:
				//search for positive word in each message
				for(String pword : positiveWords) {
					if(msg.toLowerCase().contains(pword)) {
						positveCount += 1;
						break positiveSearch;
					}
				}
			}
		}
		return (int) (positveCount/messagesCount * 100);
	}

}
