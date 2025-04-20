import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class HotelServerMain {
    public static void main(String[] args) {
        try {
            //LocateRegistry.createRegistry(1099); // start RMI registry
            HotelServer server = new HotelServer();
            Naming.rebind("HotelService", server);
            System.out.println("Hotel Booking Server is running...");
        } catch (MalformedURLException | RemoteException e) {
            System.out.println("Server Exception: " + e);
        }
    }
}
