import java.util.*;

public class FlightManager {
    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addSampleData() {
        Airline airline = new Airline("Qatar Airways");
        Pilot pilot = new Pilot("Ali", "Captain");
        CrewMember crew1 = new CrewMember("Sara", "Cabin Crew");
        CrewMember crew2 = new CrewMember("Omar", "Cabin Crew");

        Flight f1 = new Flight("QR101", "Doha", "Dubai", new Schedule("10:00", "12:00"), 3, airline);
        f1.addCrew(pilot);
        f1.addCrew(crew1);
        f1.addCrew(crew2);

        flights.add(f1);
    }

    public void displayAvailableFlights() {
        System.out.println("\n--- Available Flights ---");
        for (Flight f : flights) {
            System.out.println(f);
        }
    }

    public void bookFlight(Scanner sc) {
        displayAvailableFlights();
        System.out.print("Enter Flight Number to book: ");
        String flightNum = sc.nextLine();

        Flight selected = findFlight(flightNum);
        if (selected == null) {
            System.out.println("Flight not found!");
            return;
        }

        if (selected.getAvailableSeats() == 0) {
            System.out.println("Sorry, no seats available!");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Contact Info: ");
        String contact = sc.nextLine();
        System.out.print("Seat Preference (Window/Aisle): ");
        String pref = sc.nextLine();

        Customer c = new Customer(name, contact);
        customers.add(c);

        Seat seat = selected.bookSeat();
        Booking b = new Booking(UUID.randomUUID().toString(), c, selected, seat);
        bookings.add(b);

        System.out.println("Booking successful! Reference: " + b.getReference());
    }

    public void cancelBooking(Scanner sc) {
        System.out.print("Enter Booking Reference: ");
        String ref = sc.nextLine();
        Booking found = findBooking(ref);

        if (found != null) {
            found.getFlight().cancelSeat(found.getSeat());
            bookings.remove(found);
            System.out.println("Booking canceled successfully.");
        } else {
            System.out.println("Booking not found!");
        }
    }

    public void checkFlightStatus(Scanner sc) {
        System.out.print("Enter Flight Number: ");
        String num = sc.nextLine();
        Flight f = findFlight(num);

        if (f != null)
            System.out.println(f.status());
        else
            System.out.println("Flight not found!");
    }

    public void manageFlightSchedules(Scanner sc) {
        System.out.print("Enter new Flight Number: ");
        String num = sc.nextLine();
        System.out.print("Origin: ");
        String origin = sc.nextLine();
        System.out.print("Destination: ");
        String dest = sc.nextLine();
        System.out.print("Departure Time: ");
        String dep = sc.nextLine();
        System.out.print("Arrival Time: ");
        String arr = sc.nextLine();
        System.out.print("Total Seats: ");
        int seats = sc.nextInt();
        sc.nextLine();

        Flight newFlight = new Flight(num, origin, dest, new Schedule(dep, arr), seats, new Airline("UDST Air"));
        flights.add(newFlight);

        System.out.println("Flight added successfully!");
    }

    public void viewCustomerDetails(Scanner sc) {
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        for (Booking b : bookings) {
            if (b.getCustomer().getName().equalsIgnoreCase(name)) {
                System.out.println(b);
            }
        }
    }

    private Flight findFlight(String num) {
        for (Flight f : flights) {
            if (f.getFlightNumber().equalsIgnoreCase(num))
                return f;
        }
        return null;
    }

    private Booking findBooking(String ref) {
        for (Booking b : bookings) {
            if (b.getReference().equals(ref))
                return b;
        }
        return null;
    }
}
