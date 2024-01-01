package travel_test;
import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    protected int maxCapacity;

    public Activity(String name, String description, double cost, int capacity) {
        this.setName(name);
        this.setDescription(description);
        this.setCost(cost);
        this.setCapacity(capacity);
        this.maxCapacity = capacity;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * @author kishorekunisetty
	 * @return int available space
	 */
	public int getSpace() {
		if (this.getCapacity()>0) {
			return this.maxCapacity - this.capacity;
		}
		return -1;
	}
}

class ActivityManager {
    /*
    what can be managed by activity manager?

    */
    private List<String> activities;
    private List<Activity> activitiesList;

    public ActivityManager() {
        // Initialize activity list
    	this.activities = new ArrayList<>();
    	this.activitiesList = new ArrayList<>();
    }

    public void addActivity(Activity activity, Destination destination) {
        // Add a new activity
    	if( this.activities.size()>0 && this.activities.contains(activity.getName())) {
    		System.out.println("Activity already taken");
    	}
    	else {
    		String name = activity.getName();
    		this.activities.add(name);
    		this.activitiesList.add(activity);
    		destination.addActivity(activity);
    	}
    }

	public void printAvailableActivities() {
        // Print details of all activities that have spaces available
		System.out.println("### Requirement 4 ####");
        System.out.println("Activities with space : ");
    	if(this.activitiesList.size() > 0) {
    		activitiesList.forEach(activity -> {
    			if(activity.getSpace() > 0){
                    System.out.println("Activity : " + activity.getName());
                    System.out.println("Capacity :" + activity.getSpace());
                }
    		});
    	}
    }

	/**
	 * @return the activities
	 */
//	public List<Activity> getActivities() {
//		return activities;
//	}

	/**
	 * @param activities the activities to set
	 */
//	public void setActivities(List<Activity> activities) {
//		this.activities = activities;
//	}
}
