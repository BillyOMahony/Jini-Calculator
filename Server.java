import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Calculator {
	public Server() {}
	public double add(double first, double second) {
		double result = first + second;
		return result;
	}
	
	public double subtract(double first, double second){
		double result = first - second;
		return result;
	}
	
	public double multiply(double first, double second){
		double result = first * second;
		return result;
	}
	
	public double divide(double first, double second){
		double result = first/second;
		return result;
	}
	
	public static void main(String args[]) {
		try {
			Server obj = new Server();
			Calculator stub = (Calculator)UnicastRemoteObject.exportObject(obj, 0);
			// Bind the remote object's stub in the registry
			Registry registry =	LocateRegistry.getRegistry();
			registry.bind("Calculator", stub);
			System.err.println("Server ready"); 
		}catch (Exception e) {
			System.err.println("Server exception: " +
			e.toString());
			e.printStackTrace();
		}
	}
}