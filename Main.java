import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static FlightManager manager = new FlightManager();

    public static void main(String[] args) {
        System.out.println("=== Welcome to Flight Booking System ===");

        // Add some sample data
        manager.addSampleData();

        while (true) {
            System.out.println("\n1. Display Available Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Check Flight Status");
            System.out.println("5. Manage Flight Schedules");
            System.out.println("6. View Customer Details");
            System.out.println("0. Exit");
            System.out.print("Select option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> manager.displayAvailableFlights();
                case 2 -> manager.bookFlight(sc);
                case 3 -> manager.cancelBooking(sc);
                case 4 -> manager.checkFlightStatus(sc);
                case 5 -> manager.manageFlightSchedules(sc);
                case 6 -> manager.viewCustomerDetails(sc);
                case 0 -> {
                    System.out.println("Exiting system... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
