public class Schedule {
    private String departure;
    private String arrival;

    public Schedule(String departure, String arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public String toString() {
        return departure + " → " + arrival;
    }
}
