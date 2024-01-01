package travel_test;

import java.util.ArrayList;
import travel_test.passenger.*;
import java.util.List;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.setName(name);
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    // Methods for managing itinerary, passengers, etc.
    public int getPassengerCapacity(){
        return this.passengerCapacity;
    }

    public void setPassengerCapacity(int newCapacity){
        this.passengerCapacity = newCapacity;
    }

	public List<Destination> getDestinationList() {
		// TODO Auto-generated method stub
		return this.itinerary;
	}

	public void setDestinationList(List<Destination> arrayList) {
		// TODO Auto-generated method stub
		this.itinerary = arrayList;
		
	}

	public List<Passenger> getPassengerList() {
		// TODO Auto-generated method stub
		return this.passengers;
	}

	public void setPassengerList(List<Passenger> arrayList) {
		// TODO Auto-generated method stub
		this.passengers = arrayList;
		
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

	public void printPassengerList() {
		// TODO Auto-generated method stub

	        System.out.println();
	        System.out.println("## Requirement 2 ##");
	        System.out.println("Package Name 01 : " + this.getName());
	        System.out.println("Passenger Capacity : " + this.getPassengerCapacity());
	        // if condition print only if passengers are there
	        if (this.passengers.size() == 0) {
	        	System.out.println("No passengers are added");
	        }
	        else {
	        	System.out.println("Number of passenger currently enrolled in : " + this.passengers.size());
		        System.out.println("Details of passenger currently enrolled in : ");
		        this.getPassengerList().forEach(passenger -> {
		            System.out.println("Passenger Name :" + passenger.getName());
		            System.out.println("Passenger Num : " + passenger.getPassengerNumber());
		        });
	        }
		
	}

	public void printPassengerDetails() {
		// TODO Auto-generated method stub
		System.out.println();
        System.out.println("#### Requirement 3 ####");
        System.out.println("Passenger Details ");
        if (this.passengers.size() > 0) {
			this.passengers.forEach(passenger -> {
				System.out.println("Passenger Name : " + passenger.getName());
				System.out.println("Passenger Number : " + passenger.getPassengerNumber());
				if(passenger.getMembership() == MembershipType.PREMIUM) {
					System.out.println("Passenger is Premium member");
				}
				else {
					System.out.println("Passenger Balance : " + passenger.getBalance());
				}
				if(this.getDestinationList().size() > 0) {
					this.getDestinationList().forEach(Destination -> {
						Destination.printDestinations(passenger.getMembership(), false, false);
					});
				}
			});
		}
		
	}

	public void printItinery() {
		// TODO Auto-generated method stub
		System.out.println();
        System.out.println("## Requirement 1 ##");
        System.out.println("Package Name : " + this.getName());
        System.out.println("Destinations And Activities Present : " );
        this
                .getDestinationList()
                .forEach(destination -> {
                    System.out.println(destination.getName());
                    destination.printDestinations(null, true, true);
                });
	}
}

/**
 * Implementation class or Service class for TravelPackage
 * @author  Vatsal Gupta
 * @version 1.0
 * @since   2023-07-01
 */
class TravelPackageManager{
    /**
     * @param passenger
     * @param TravelPackage
     * @return
     */
    
    public boolean addPassenger(Passenger passenger, TravelPackage TravelPackage) {
        /*01 : Check Capacity and ass passenger*/
        if(TravelPackage.getPassengerCapacity() > 0){
            reducePassengerCapacity(TravelPackage);
            addPassengerToTravelPackage( passenger,  TravelPackage);
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @param TravelPackage
     */
    private void reducePassengerCapacity(TravelPackage TravelPackage) {
        TravelPackage.setPassengerCapacity(TravelPackage.getPassengerCapacity() - 1);
    }

    /**
     * @param destination
     * @param TravelPackage
     * @return
     */
    
    public boolean addDestination(Destination destination, TravelPackage TravelPackage) {
        return addDestinationToTravelPackage(destination , TravelPackage);
    }

    /**
     *
     * @param destination
     * @param TravelPackage
     * @return
     */
    private boolean addDestinationToTravelPackage(Destination destination, TravelPackage TravelPackage) {
        if(TravelPackage.getDestinationList() == null)
            TravelPackage.setDestinationList(new ArrayList<Destination>());

        return TravelPackage.getDestinationList().add(destination);
    }

    /**
     *
     * @param passenger
     * @param TravelPackage
     */
    private void addPassengerToTravelPackage(Passenger passenger, TravelPackage TravelPackage){
        if(TravelPackage.getPassengerList() == null)
            TravelPackage.setPassengerList(new ArrayList<>());

        TravelPackage.getPassengerList().add(passenger);
    }
}