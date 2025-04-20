import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class HotelServer extends UnicastRemoteObject implements HotelInterface {
    private final Map<String, String> bookings;

    protected HotelServer() throws RemoteException {
        super();
        bookings = new HashMap<>();
    }

    @Override
    public synchronized String bookRoom(String guestName) throws RemoteException {
        if (bookings.containsKey(guestName)) {
            return "Guest '" + guestName + "' already has a room booked.";
        } else {
            bookings.put(guestName, "Room " + (bookings.size() + 1));
            return "Room booked for " + guestName;
        }
    }

    @Override
    public synchronized String cancelBooking(String guestName) throws RemoteException {
        if (bookings.containsKey(guestName)) {
            bookings.remove(guestName);
            return "Booking cancelled for " + guestName;
        } else {
            return "No booking found for " + guestName;
        }
    }

    @Override
    public Map<String, String> getAllBookings() throws RemoteException {
        return bookings;
    }
}
