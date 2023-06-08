package presenters;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import models.Person;
import models.Product;
import models.SaleProducts;
import models.SoldProducts;
import models.Store;
import net.Conection;

public class ThreadPerson extends Thread {
	
	private Conection conection;
	private Store store;

	
	public ThreadPerson(Socket socket, Store store) throws IOException {
		conection = new Conection(socket);
		this.store = store;
	}
	
	@Override
	public void run() {
		while (true) {
			try {			
				int option = conection.readInt();
				switch (option) {
				case 1:
					createPerson();
					break;
				case 2:
					searchPerson();
					break;
				case 3: 
					SearchUpdatePerson();
					break; 
				case 4:
					updatePerson();
					break;
				case 5: 
					deletePerson();
					break;
				case 6:
					conection.writeString(store.show());
					break;
				case 7:
					createProduct();
					break;
				case 8:
					searchUpdateProduct();
					break;
				case 9:
					updateProduct();
					break;
				case 10:
					conection.writeString(store.showProducts());
					break;
				case 11:
					deleteProduct();
					break;
				case 12:
					registerSale();
					break;
				case 13:
					registerSoldProducts();
					break;
				case 14:
					showSoldProducts();
					break;
				case 15:
					showSales();
					break;
				}

			} catch (IOException e) {
			}
		}
	}
	
	public void searchPerson()  {
		String option = "";
		try {
			option = store.searchePerson(conection.readString(), conection.readString());
			if (!option.equals("0")) {
				conection.writeString((store.getPerson() + "") .split("-")[1]);
				conection.writeString(store.getPerson().getCod() + "");
			}else {
				conection.writeString("");
				conection.writeString("");
			}
			conection.writeString(option);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void createPerson() {
		boolean com;
		try {
			com = store.addPerson(new Person(conection.readInt(), conection.readString(), conection.readString(), conection.readString(), conection.readString()));
			conection.writeBoolean(com);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void SearchUpdatePerson() throws IOException {
		store.validateCodPerson(conection.readInt());
		conection.writeString(store.getPerson() + "");
	}
	
	public void updatePerson() {
		boolean validate = false;
		try {
			 validate = store.updatePerson(new Person(conection.readInt(), conection.readString(), conection.readString(), conection.readString(), conection.readString()), conection.readInt());
			 if (validate) {
					conection.writeBoolean(true);;
				}
				else {
					conection.writeBoolean(false);;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public void deletePerson() {
		boolean validate = false;
		try {
			validate = store.deletePeson(conection.readInt());
			if (validate) {
				conection.writeBoolean(true);
			}else {
				conection.writeBoolean(validate);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createProduct() {
		boolean validate = false;
		try {
			validate = store.addProduct(new Product(conection.readInt(), conection.readString(), conection.readString(), conection.readInt(), conection.readDouble()));
			conection.writeBoolean(validate);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void searchUpdateProduct() throws IOException {
		Product product = store.validateCodProduct(conection.readInt());
		if (product != null) {
			conection.writeBoolean(true);
			conection.writeString(product + "");
		}else {
			conection.writeBoolean(false);
		}
	}
	
	public void updateProduct() {
		boolean validate = false;
		try {
			validate = store.updateProduct(new Product(conection.readInt(), conection.readString(), conection.readString(), conection.readInt(), conection.readDouble()), conection.readInt());
			if (validate) {
				conection.writeBoolean(true);;
			}
			else {
				conection.writeBoolean(false);;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct() {
		boolean validate = false;
		try {
			validate = store.delteProduct(conection.readInt());
			if (validate) {
				conection.writeBoolean(true);
			} else {
				conection.writeBoolean(false);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void registerSale() {
		try {
			store.createSale(conection.readInt(), conection.readString(), conection.readString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void registerSoldProducts() {	
		try {		
			SoldProducts soldProducts = new SoldProducts(conection.readInt(), conection.readString(),  conection.readString(), conection.readDouble(), conection.readInt());
			store.createSoldProducts(soldProducts);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showSoldProducts() {
		try {
			conection.writeString(store.showSoldProducts());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showSales() {
		try {
			conection.writeString(store.showSales(conection.readInt()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
