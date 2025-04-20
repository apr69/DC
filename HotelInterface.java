import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface HotelInterface extends Remote {
    String bookRoom(String guestName) throws RemoteException;
    String cancelBooking(String guestName) throws RemoteException;
    Map<String, String> getAllBookings() throws RemoteException;
}
