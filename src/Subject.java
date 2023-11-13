import java.util.ArrayList;

public abstract class Subject {
	private ArrayList<User> observers = new ArrayList<User>();
	
	public void attach(User observer) {
		observers.add(observer);
	}
	
	public void unattach(User observer) {
		observers.remove(observer);
	}
	
	public ArrayList<User> getFollowers() {
		return observers;
	}
	
	public void notifyFollowers() {
		for (UserInterface ob : observers) {
			ob.update(this);
		}
	}
}
