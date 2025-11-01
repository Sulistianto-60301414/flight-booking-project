public class Ticket {
    private Booking booking;

    public Ticket(Booking booking) {
        this.booking = booking;
    }

    public void printTicket() {
        System.out.println("=== Flight Ticket ===");
        System.out.println(booking);
        System.out.println("=====================");
    }
}
