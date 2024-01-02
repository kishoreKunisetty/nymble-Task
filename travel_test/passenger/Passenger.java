package travel_test.passenger;

import travel_test.Activity;

import java.util.ArrayList;
import java.util.List;


/**
 * This class contains all the data about Passenger, etc.
 * @author  Kishore Kunisetty
 * @version 1.0
 * @since   2023-12-31 
 */
public class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    protected MembershipType membershipType;
    private List<Activity> activities;

    public Passenger(String name, int passengerNumber, double balance, MembershipType membershipType) {
        // should we store source and destination?
        this.setName(name);
        this.setPassengerNumber(passengerNumber);
        this.balance = balance;
        this.membershipType = membershipType;
        this.activities = new ArrayList<>();
    }

    public void signUpForActivity(Activity activity) {
        double cost = calculateCost(activity);
        int initial_capacity = activity.getCapacity();
        if (this.balance >= cost) {
        	// passenger can buy activity
            this.balance -= cost;
            activity.setCapacity(initial_capacity - 1);
            // Additional logic for signing up
            this.activities.add(activity);
        } else {
            // Handle insufficient balance
        	System.out.println("insufficient balance to buy activity");
        }
    }

    public double calculateCost(Activity activity) {
        switch (this.membershipType) {
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
	 * @return the passengerNumber
	 */
	public int getPassengerNumber() {
		return passengerNumber;
	}

	/**
	 * @param passengerNumber the passengerNumber to set
	 */
	public void setPassengerNumber(int passengerNumber) {
		this.passengerNumber = passengerNumber;
	}

    // Other methods and attributes
	public double getBalance() {
		if(this.membershipType == MembershipType.PREMIUM) {
			return 0;
		}
		return this.balance;
		
	}
	
	public MembershipType getMembership() {
		return this.membershipType;
	}
}


