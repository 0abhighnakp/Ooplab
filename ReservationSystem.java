import java.util.Vector;

class ReservationSystem {
    private Vector<Flight> flights = new Vector<>();
    private Vector<Hotel> hotels = new Vector<>();

    class Flight {
        private String flightNumber;
        private int capacity;
        private int reservedSeats;

        Flight(String flightNumber, int capacity) {
            this.flightNumber = flightNumber;
            this.capacity = capacity;
            this.reservedSeats = 0;
        }

        boolean searchFlight(String flightNumber) {
            for (Flight flight : flights) {
                if (flight.flightNumber.equals(flightNumber)) {
                    System.out.println("Flight " + flightNumber + " is available.");
                    return true;
                }
            }
            System.out.println("Flight " + flightNumber + " not found.");
            return false;
        }

        boolean bookFlight(String flightNumber, int numSeats) {
            for (Flight flight : flights) {
                if (flight.flightNumber.equals(flightNumber)) {
                    int availableSeats = flight.capacity - flight.reservedSeats;
                    if (numSeats <= availableSeats) {
                        flight.reservedSeats += numSeats;
                        System.out.println(numSeats + " seats booked on flight " + flightNumber);
                        return true;
                    } else {
                        System.out.println("Not enough seats available on flight " + flightNumber);
                        return false;
                    }
                }
            }
            System.out.println("Flight " + flightNumber + " not found.");
            return false;
        }

        boolean cancelFlight(String flightNumber, int numSeats) {
            for (Flight flight : flights) {
                if (flight.flightNumber.equals(flightNumber)) {
                    if (numSeats <= flight.reservedSeats) {
                        flight.reservedSeats -= numSeats;
                        System.out.println(numSeats + " seats canceled on flight " + flightNumber);
                        return true;
                    } else {
                        System.out.println("Invalid number of seats to cancel on flight " + flightNumber);
                        return false;
                    }
                }
            }
            System.out.println("Flight " + flightNumber + " not found.");
            return false;
        }
    }

    class Hotel {
        private String hotelName;
        private int rooms;
        private int bookedRooms;

        Hotel(String hotelName, int rooms) {
            this.hotelName = hotelName;
            this.rooms = rooms;
            this.bookedRooms = 0;
        }

        boolean searchHotel(String hotelName) {
            for (Hotel hotel : hotels) {
                if (hotel.hotelName.equals(hotelName)) {
                    System.out.println(hotelName + " is available.");
                    return true;
                }
            }
            System.out.println(hotelName + " not found.");
            return false;
        }

        boolean bookHotel(String hotelName, int numRooms) {
            for (Hotel hotel : hotels) {
                if (hotel.hotelName.equals(hotelName)) {
                    int availableRooms = hotel.rooms - hotel.bookedRooms;
                    if (numRooms <= availableRooms) {
                        hotel.bookedRooms += numRooms;
                        System.out.println(numRooms + " rooms booked at " + hotelName);
                        return true;
                    } else {
                        System.out.println("Not enough rooms available at " + hotelName);
                        return false;
                    }
                }
            }
            System.out.println(hotelName + " not found.");
            return false;
        }

        boolean cancelHotel(String hotelName, int numRooms) {
            for (Hotel hotel : hotels) {
                if (hotel.hotelName.equals(hotelName)) {
                    if (numRooms <= hotel.bookedRooms) {
                        hotel.bookedRooms -= numRooms;
                        System.out.println(numRooms + " rooms canceled at " + hotelName);
                        return true;
                    } else {
                        System.out.println("Invalid number of rooms to cancel at " + hotelName);
                        return false;
                    }
                }
            }
            System.out.println(hotelName + " not found.");
            return false;
        }
    }

    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();

        ReservationSystem.Flight flight1 = reservationSystem.new Flight("F001", 100);
        reservationSystem.flights.add(flight1);

        ReservationSystem.Hotel hotel1 = reservationSystem.new Hotel("Hilton", 50);
        reservationSystem.hotels.add(hotel1);

        flight1.searchFlight("F001");
        flight1.bookFlight("F001", 3);
        flight1.cancelFlight("F001", 2);

        hotel1.searchHotel("Hilton");
        hotel1.bookHotel("Hilton", 5);
        hotel1.cancelHotel("Hilton", 3);
    }
}
