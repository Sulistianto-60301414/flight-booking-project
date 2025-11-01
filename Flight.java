import java.util.*;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private Schedule schedule;
    private int availableSeats;
    private Airline airline;
    private ArrayList<CrewMember> crewList = new ArrayList<>();
    private ArrayList<Seat> seats = new ArrayList<>();

    public Flight(String flightNumber, String origin, String destination, Schedule schedule, int seatCount,
            Airline airline) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.schedule = schedule;
        this.availableSeats = seatCount;
        this.airline = airline;
        for (int i = 1; i <= seatCount; i++)
            seats.add(new Seat("S" + i));
    }

    public void addCrew(CrewMember c) {
        crewList.add(c);
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Seat bookSeat() {
        for (Seat s : seats) {
            if (!s.isBooked()) {
                s.setBooked(true);
                availableSeats--;
                return s;
            }
        }
        return null;
    }

    public void cancelSeat(Seat s) {
        s.setBooked(false);
        availableSeats++;
    }

    public String status() {
        return "Flight " + flightNumber + " from " + origin + " to " + destination +
                " departs at " + schedule.getDeparture() +
                " | Arrival: " + schedule.getArrival() +
                " | Status: On Time | Seats Left: " + availableSeats;
    }

    public String toString() {
        return flightNumber + " | " + origin + " → " + destination + " | " + schedule +
                " | Seats: " + availableSeats + " | Crew: " + crewList.size();
    }
}
