import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.Scanner;

public class HotelClient {
    public static void main(String[] args) {
        try {
            HotelInterface hotel = (HotelInterface) Naming.lookup("rmi://localhost/HotelService");
            try (Scanner scanner = new Scanner(System.in)) {
                int choice;
                String guestName;
                
                do {
                    System.out.println("\n--- Hotel Booking Menu ---");
                    System.out.println("1. Book Room");
                    System.out.println("2. Cancel Booking");
                    System.out.println("3. View All Bookings");
                    System.out.println("4. Exit");
                    System.out.print("Enter choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // clear buffer
                    
                    switch (choice) {
                        case 1 -> {
                            System.out.print("Enter guest name: ");
                            guestName = scanner.nextLine();
                            System.out.println(hotel.bookRoom(guestName));
                        }
                        
                        case 2 -> {
                            System.out.print("Enter guest name: ");
                            guestName = scanner.nextLine();
                            System.out.println(hotel.cancelBooking(guestName));
                        }
                        
                        case 3 -> {
                            Map<String, String> bookings = hotel.getAllBookings();
                            if (bookings.isEmpty()) {
                                System.out.println("No bookings found.");
                            } else {
                                System.out.println("--- Current Bookings ---");
                                bookings.forEach((name, room) -> System.out.println(name + " -> " + room));
                            }
                        }
                        
                        case 4 -> System.out.println("Exiting...");
                        
                        default -> System.out.println("Invalid choice. Try again.");
                    }
                    
                } while (choice != 4);
            }

        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println("Client Exception: " + e);
        }
    }
}
