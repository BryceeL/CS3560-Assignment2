import java.util.ArrayList;

public class Group {
	private String name;
	
	public Group(String name) {
		this.name = "GROUP:" + name;
		addGroup(this);
	}
	
	public String getName() {
		return name;
	}
	
	public static void addGroup(Group group) {
		MessageService.getInstance().addGroup(group);
	}
	
	public static ArrayList<Group> getGroups() {
		return MessageService.getInstance().getGroups();
	}
}
