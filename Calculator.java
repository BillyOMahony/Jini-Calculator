import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Calculator extends Remote {
	double add(double first, double second) throws RemoteException;
	double subtract(double first, double second) throws RemoteException;
	double multiply(double first, double second) throws RemoteException;
	double divide(double first, double second) throws RemoteException;
}
