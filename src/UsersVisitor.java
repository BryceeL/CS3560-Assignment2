
public class UsersVisitor implements Visitor {
	//visitor gets total amount of users from instance
	public String visit(MessageService instance) {
		return Integer.toString(instance.getUsers().size());
	}
}
