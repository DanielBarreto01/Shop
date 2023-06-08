package presenters;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import models.Store;
import models.Person;
import models.Product;


public class PresenterServer {
    private final int PUERTO = 1234;
    private ServerSocket serverSocket;
    private Socket socket;
    private Store store;
  
    
    public PresenterServer() throws IOException {
        serverSocket = new ServerSocket(PUERTO);
        store = new Store();
        loadData();
    }
  
    /**
     *	escucha a clientes y acepta a los clientes  
     * @throws IOException
     * @throws SocketException
     */
	public void start() throws IOException, SocketException {
		while (true) {
			Socket socket = serverSocket.accept();
			new ThreadPerson(socket, store).start();
		}
	}

	public void loadData() {
		try {
			store.addPerson(new Person(28, "sergio soto", "sergio.soto", "1", "Administrador"));
			store.addPerson(new Person(77, "daniel barreto", "daniel.barreto", "2",  "Administrador"));
			store.addPerson(new Person(20, "juan", "brandon", "2",  "Administrador"));
			store.addPerson(new Person(29, "pedro", "felipe", "1", "usuario"));
			store.addPerson(new Person(24, "sara", "sara", "1", "Usuario"));
			store.addProduct(new Product(1, "arroz", "250", 20, 200.0));
			store.addProduct(new Product(25, "cafe", "400 gramos", 50, 2500.0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	store.addPerson(new Person(23, "Maikol ordones", "maikol.ordones", "2", "Administrador"));
		store.addPerson(new Person(35, "Pedro Infante", "m", "5", "Usuario"));
		store.addPerson(new Person(40, "Nestor tovar", "nestor.tovar", "5", "Administrador"));
		
		store.addProduct(new Product(1, "arroz", "250", 20, 200.0));
		store.addProduct(new Product(25, "cafe", "400 gramos", 50, 2500.0));*/
	
		
	}
}