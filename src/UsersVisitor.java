
public class UsersVisitor implements Visitor {
	//visitor gets total amount of users from instance
	public int visit(MessageService instance) {
		return instance.getUsers().size();
	}
}
