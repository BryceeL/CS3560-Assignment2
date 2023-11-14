
public class GroupVisitor implements Visitor{
	public int visit(MessageService instance) {
		return instance.getGroups().size();
	}

}
