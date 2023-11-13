import java.util.ArrayList;

public class Group {
	private String name;
	
	private static ArrayList<Group> groupList = new ArrayList<Group>();
	
	public Group(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static void add(Group group) {
		groupList.add(group);
	}
	
	public static ArrayList<Group> getGroups() {
		return groupList;
	}
}
