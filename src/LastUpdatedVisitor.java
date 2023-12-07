public class LastUpdatedVisitor implements Visitor {
	@Override
	public String visit(MessageService instance) {
		User user = instance.getLastPostedUser();
		if (user != null) {
			return user.getUsername();
		} else {
			return null;
		}	
	}
}
