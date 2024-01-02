package travel_test;

import java.util.ArrayList;
import travel_test.passenger.*;
import java.util.List;


/**
 * Implementation class for Destination
 * @author  Kishore Kunisetty
 * @version 1.0
 * @since   2023-12-31
 */
public class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }
    
    public String getName() {
    	return this.name;
    }
    
    public List<Activity> getActivites(){
    	return this.activities;
    }
    
    public void addActivity(Activity activity) {
    	this.activities.add(activity);
    }

    // Methods to manage activities
    public void printDestinations(MembershipType membershipType, boolean showCapacity, boolean showDescription) {
    	System.out.println("Destination : " + this.name);
    	if(this.activities.size() > 0) {
    		this.activities.forEach( activity -> {
    			System.out.println("Activity : " + activity.getName());
    			if(membershipType != null) {
    				System.out.println("Cost paid : " + this.calculateCost(activity, membershipType));
    			}
    			if(showCapacity) {
    				System.out.println("capacity : " + activity.getCapacity());
    			}
    			if(showDescription) {
    				System.out.println("Description : " + activity.getDescription());
    			}
    		});
    	}
    }
    
    private double calculateCost(Activity activity, MembershipType membershipType) {
        switch (membershipType) {
            case STANDARD:
                return activity.getCost();
            case GOLD:
                return activity.getCost() * 0.9; // 10% discount
            case PREMIUM:
                return 0; // Free for premium members
            default:
                throw new IllegalArgumentException("Unknown membership type");
        }
    }
}
