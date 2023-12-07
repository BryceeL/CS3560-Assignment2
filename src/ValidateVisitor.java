import java.util.ArrayList;

public class ValidateVisitor implements Visitor {
	@Override
	public String visit(MessageService instance) {
		Object[] userObjs = instance.getUsers().toArray();
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Group> groups = instance.getGroups();
		
		//put users from object array to user array
		for(Object o : userObjs) {
			users.add( (User) o);
		}	
		
		//compare users
		for(User user : users) {
			for(User comparedUser : users) {
				//if user has same name as another user or contains space
				if ( (user.getUsername().equals(comparedUser.getUsername()) && user != comparedUser)
						|| user.getUsername().contains(" ") ) {
					return "0";
				}
			}
		}
		//compare groups
		for(Group group : groups) {
			for(Group comparedGroup : groups) {
				//if user has same name as another user or contains space
				if ( (group.getName().equals(comparedGroup.getName()) && group != comparedGroup)
						|| group.getName().contains(" ") ) {
					return "0";
				}
			}
		}
		return "1"; //false
	}

}
