package travel_test;

import travel_test.passenger.Passenger;
// import travel_test.passenger;
import travel_test.passenger.MembershipType;

public class Main {
    public static void main(String[] args) {

        /*
         [TODO] make it more modularised and create multiple scenario's
          for each testcase and formated print statements
        */
        Passenger kishore = new Passenger("Kishore",123,100,MembershipType.STANDARD, null);
        Passenger aathira = new Passenger("aathira",123,300,MembershipType.STANDARD, null);
        Passenger shubham = new Passenger("shubham",123,500,MembershipType.STANDARD, null);
        // Creating the travel package
        TravelPackage mumbaiToDelhi = new TravelPackage("Mumbai to Delhi Tour", 50);
        TravelPackage mumbaiToBangalore = new TravelPackage("Mumbai to Bangalore Tour", 50);
        TravelPackageManager travelManager = new TravelPackageManager();

        // Creating the destination
        Destination delhi = new Destination("Delhi");
        Destination bangalore = new Destination("Bangalore");

        // Adding the activity to the destination
        Activity cityTour = new Activity("City Tour", "A comprehensive city tour ", 200.00, 30);
        Activity businessTrip = new Activity(" Business Trip", "A Business Trip ", 400.00, 30);
        Activity function = new Activity(" Function ", "A Family Function Trip ", 400.00, 30);
//        delhi.addActivity(cityTour);

        ActivityManager activityManager = new ActivityManager();
        // Adding the destination to the travel package
        activityManager.addActivity(cityTour, delhi);
        activityManager.addActivity(businessTrip, bangalore);
        activityManager.addActivity(cityTour, bangalore);
        
        travelManager.addDestination(delhi, mumbaiToDelhi);
        travelManager.addDestination(bangalore, mumbaiToBangalore);

        // Creating a passenger
        travelManager.addPassenger(kishore, mumbaiToDelhi);
        travelManager.addPassenger(shubham, mumbaiToBangalore);
//        StandardPassenger passenger = new StandardPassenger("John Doe", 101, 1000.00);

        // Adding the passenger to the travel package
//        mumbaiToDelhi.addPassenger(kishore);

        // Passenger signs up for the City Tour activity
        kishore.signUpForActivity(cityTour);
        shubham.signUpForActivity(businessTrip);

        // Print itinerary and passenger details (this method should be implemented in TravelPackage class)
        mumbaiToDelhi.printItinery();
        mumbaiToDelhi.printPassengerList();
        mumbaiToDelhi.printPassengerDetails();
        activityManager.printAvailableActivities();
    }
}
