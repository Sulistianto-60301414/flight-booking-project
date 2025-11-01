public class Booking {
    private String reference;
    private Customer customer;
    private Flight flight;
    private Seat seat;

    public Booking(String ref, Customer c, Flight f, Seat s) {
        this.reference = ref;
        this.customer = c;
        this.flight = f;
        this.seat = s;
    }

    public String getReference() {
        return reference;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public String toString() {
        return "Booking Ref: " + reference + "\n" + customer + "\nFlight: " + flight.getFlightNumber() +
                " | Seat: " + seat.getSeatNumber();
    }
}
