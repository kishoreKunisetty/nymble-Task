package travel_test;

import travel_test.passenger.Passenger;
// import travel_test.passenger;
import travel_test.passenger.MembershipType;


/**
 * This driver file contains all the information about destinations ,activities, passengers etc.
 * @author  Kishore Kunisetty
 * @version 1.0
 * @since   2023-12-31 
 */
public class Main {
    public static void main(String[] args) {

    	//initialize passengers
        Passenger kishore = new Passenger("Kishore",123,100,MembershipType.STANDARD);
        Passenger aathira = new Passenger("aathira",123,300,MembershipType.STANDARD);
        Passenger shubham = new Passenger("shubham",123,500,MembershipType.GOLD);
        
        // Creating the travel package
        TravelPackage mumbaiToDelhi = new TravelPackage("Mumbai to Delhi Tour", 50);
        TravelPackage mumbaiToBangalore = new TravelPackage("Mumbai to Bangalore Tour", 50);
        
        TravelPackageManager travelManager = new TravelPackageManager();

        // Creating the destination
        Destination delhi = new Destination("Delhi");
        Destination bangalore = new Destination("Bangalore");

        // Adding the activity to the destination
        Activity cityTour = new Activity("City Tour", "A comprehensive city tour ", 200.00, 30);
        Activity businessTrip = new Activity(" Business Trip", "A Business Trip ", 300.00, 30);
        // this should raise "Activity already taken";
        Activity function = new Activity(" Function ", "A Family Function Trip ", 400.00, 30);

        // initialising Activity Manager
        ActivityManager activityManager = new ActivityManager();
        
        // Adding the activity to destination to the travel package
        activityManager.addActivity(cityTour, delhi);
        activityManager.addActivity(businessTrip, bangalore);
        activityManager.addActivity(cityTour, bangalore);
        
        // Adding the destination to the travel package
        travelManager.addDestination(delhi, mumbaiToDelhi);
        travelManager.addDestination(bangalore, mumbaiToBangalore);

        // Adding the passenger to the travel package
        travelManager.addPassenger(kishore, mumbaiToDelhi);
        travelManager.addPassenger(shubham, mumbaiToBangalore);


        // Passenger signs up for the City Tour activity
        kishore.signUpForActivity(cityTour);
        shubham.signUpForActivity(businessTrip);
        shubham.signUpForActivity(cityTour);

        // Print itinerary and passenger details (this method should be implemented in TravelPackage class)
        mumbaiToDelhi.printItinery();
        mumbaiToDelhi.printPassengerList();
        mumbaiToDelhi.printPassengerDetails();
        
        mumbaiToBangalore.printItinery();
        mumbaiToBangalore.printPassengerList();
        mumbaiToBangalore.printPassengerDetails();
        
        System.out.println();
        activityManager.printAvailableActivities();
    }
}
