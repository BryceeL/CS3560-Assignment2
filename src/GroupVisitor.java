
public class GroupVisitor implements Visitor{
	public String visit(MessageService instance) {
		return Integer.toString(instance.getGroups().size());
	}

}
