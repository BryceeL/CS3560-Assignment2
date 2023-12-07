import java.util.ArrayList;

public class Group {
	private String name;
	private long creationTime;
	
	public Group(String name) {
		this.name = "GROUP:" + name;
		creationTime = System.currentTimeMillis();
		addGroup(this);
	}
	
	public String getName() {
		return name;
	}
	
	public long getCreationTime() {
		return creationTime;
	}
	
	public static void addGroup(Group group) {
		MessageService.getInstance().addGroup(group);
	}
	
	public static ArrayList<Group> getGroups() {
		return MessageService.getInstance().getGroups();
	}
}
