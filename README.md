# Flight Booking Project

A simple console-based flight booking system in Java.

## Features
- List available flights
- Book a flight (auto-assign seat)
- Cancel a booking
- Check flight status
- Manage flight schedules
- View customer details

## Requirements
- Java 17+ (works on Java 23 as well)

## Run locally
From the project folder:

```powershell
# Compile to ./out
javac -d out *.java

# Run the app
java -cp out Main
```

You'll see a menu; enter numbers to navigate. Press `0` to exit.

## Project structure
```
Airline.java
Booking.java
CrewMember.java
Customer.java
Flight.java
FlightManager.java
Main.java
Pilot.java
Schedule.java
Seat.java
Ticket.java
```

## License
Specify your preferred license (e.g., MIT). You can add a `LICENSE` file later.
