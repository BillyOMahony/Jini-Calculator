import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	private Client() {}
	public static void main(String[] args) {
		String host = (args.length < 1) ? null : args[0];
		try {
			System.out.println("Host: " + host);
				Registry registry = LocateRegistry.getRegistry(host);
				Calculator stub = (Calculator) registry.lookup("Calculator");
				while(1==1){
					Scanner scanner = new Scanner(System.in);
					System.out.println("Enter first number:");
					double first = scanner.nextDouble();
					System.out.println("Enter math symbol[+, -, *, /]");
					String math = scanner.next();
					System.out.println("Enter second number:");
					double second = scanner.nextDouble();
					if(math.equals("+")){
						Double response = stub.add(first, second);
						System.out.println("response: " + response); 
					}else if(math.equals("-")){
						Double response = stub.subtract(first, second); 
						System.out.println("response: " + response); 
					}else if(math.equals("*")){
						Double response = stub.multiply(first, second);
						System.out.println("response: " + response); 
					}else if(math.equals("/")){
						Double response = stub.divide(first, second);
						System.out.println("response: " + response); 
					}else{
						System.out.println("Incorrect input, try again");
					}
					
				}
		}catch (Exception e) {
			System.err.println("Client exception: " +
			e.toString());
			e.printStackTrace();
		}
	}
}
