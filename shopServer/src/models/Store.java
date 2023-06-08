package models;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.google.gson.Gson;

import structure.BinaryTree;

public class Store {
	private BinaryTree<Product> listProducts;
	private BinaryTree<Person> personList;
	private ArrayList<SaleProducts> saleProductsList;
	private ListUsers <Person> liUsers;
	private Person person;
	private Serialization<ListUsers<Person>> sereUser;
	private SaleProducts actualSaleProducts;
	private ArrayList<Integer>positionDelete;
	
	public Store() {
		listProducts = new BinaryTree<>(Comparator.comparing(Product::getCodProduct));
		personList = new BinaryTree<>(Comparator.comparing(Person::getUserName));
		saleProductsList = new ArrayList<>();
		positionDelete = new ArrayList<>();
		liUsers = new ListUsers<>(positionDelete);
		sereUser = new Serialization<ListUsers<Person>>(liUsers, this);
		person = null;
		actualSaleProducts = null;
	}
	
	public boolean addPerson(Person person) throws Exception {
		int position;
		if(!positionDelete.isEmpty()) {
			position =positionDelete.get(0);
			positionDelete.remove(0);
			person.setPosition(position);
			liUsers.addElementPositionspecific(position, person);
		}else {
			position = liUsers.isEmpety()?0:liUsers.getLatestUser().getPosition()+1;
			person.setPosition(position);
			liUsers.addUser(person);
		}
		boolean com = false;
		validateCodPerson(person.getCod());
		if(personList.search(person) == null && this.person == null) {
			personList.add(person);
			com = personList.search(person) != null? true: false;
		}
		sereUser.save();
		return com;
	}
	public String loadBaseUser() {
		String valuesUser ="";
		for (Person User : liUsers.getListUser()) {
			valuesUser+= User+"\n";
		}	
		return valuesUser;
	}
	
	/**
	 * actuliaza, recaega datos del fichero 
	 * @throws IOException 
	 */
	public String loadDataUsers() throws IOException {
		liUsers = sereUser.readLisPerson();
		positionDelete = liUsers.getPositionFree();
		return loadBaseUser();
	}
	

	
	public void  delete (int index) throws IOException {
		liUsers.deleteUser(index);
		positionDelete.add(index);
		loadDataUsers();
		sereUser.save();
	}
	

	public void validateCodPerson(int cod) {
		person = null;
		Iterator<Person> iterator = personList.iterator();
		while (iterator.hasNext()) {
			Person person = iterator.next();
			if (person.getCod() == cod) {
				this.person = person;
			}
		}
	}
	

	
	public String searchePerson(String userName, String password) {
		Person per = personList.search(new Person(0, "", userName, "", ""));
		if (per != null && per.getPassword().equals(password)) {
			this.person = per;
			if (per.getTypePerson().equals("Administrador")) {
				return "1";
			}else {         
				return "2";
			}
		}
		return "0";
	}
	
	public boolean updatePerson(Person person, int cod) {
		boolean validate = true;
		validateCodPerson(person.getCod());		
		Person per = this.person == null? null:  personList.search(this.person);
		if (per == null || per.getCod() == cod ) {
			validateCodPerson(cod);
			per = this.person;
			if ((per.getUserName().equals(person.getUserName()) || personList.search(person) == null) ) {
				per.setCod(person.getCod());
				per.setName(person.getName());
				per.setUserName(person.getUserName());
				per.setPassword(person.getPassword());
				per.setTypePerson(person.getTypePerson());
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return todos los usuarios q hay en el arbol
	 */
	public String show() {
		return  personList.showInOrder();
	}
	
	public boolean deletePeson(int codPersonActual) throws Exception {
		validateCodPerson(codPersonActual);
		if (this.person != null) {
			personList.delete(person);
			if (personList.isEmpty()) {
				personList.add(person);
				return false;
			}else {
				return true;
			}
		}else {
			throw new Exception();
		}
	}
	
	public String showPersons() {
		return personList.showInOrder();
	}

	public Person getPerson() {
		return person;
	}
	
	public Product validateCodProduct(int cod) {
		person = null;
		Iterator<Product> iterator = listProducts.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getCodProduct() == cod) {
				return product;
			}
		}
		return null;
	}
	
	public boolean addProduct(Product product) {
		listProducts.add(product);
		if(listProducts.search(product) != null) {
			return true;
		}
		return false;
	}
	
	public String showProducts() {
		return listProducts.showInOrder();
	}
	
	public boolean updateProduct(Product product, int codActualProduct) {
		Product newProduct = listProducts.search(new Product(codActualProduct,"","", 0 ,0));
		if (newProduct == null || product.getCodProduct() == codActualProduct || listProducts.search(product) == null) {
				newProduct.setCodProduct(product.getCodProduct());
				newProduct.setName(product.getName());
				newProduct.setDescription(product.getDescription());
				newProduct.setUnits(product.getUnits());
				newProduct.setPriceUnits(product.getPriceUnits());
				return true;			
		}
		return false;
	}
	
	public boolean delteProduct(int codActualProduct) {
		listProducts.delete(new Product(codActualProduct,"", "", 0 ,0));
		if (listProducts.search(new Product(codActualProduct,"", "", 0 ,0)) == null) {
			return true;
		}
		return false;
	}
	
	public void createSale(int idUser, String idClient, String nameClient) {
		SaleProducts saleProductActual = new SaleProducts(idUser, LocalDate.now(), idClient, nameClient);
		saleProductsList.add(saleProductActual);
		this.actualSaleProducts = saleProductActual;
	}
	
	public void createSoldProducts(SoldProducts soldProducts) {
		actualSaleProducts.addPrductSold(soldProducts);
		validateCodProduct(soldProducts.getCodProduct()).recaculateUnits(soldProducts.getSoldUnits());
	}
	
	public String showSoldProducts() {
		return actualSaleProducts.showProductSold();
	}
	
	public String showSales(int codPerson) {
		String result = "";
		for (int i = 0; i < saleProductsList.size(); i++) {
			if (saleProductsList.get(i).getCodUser() == codPerson) {
				result += saleProductsList.get(i) + "\n";
			}
			
		}
		return result;
		
	}
	
	public void showProducSales(int codPerson) {
		String result = "";
		for (int i = 0; i < saleProductsList.size(); i++) {
			if (saleProductsList.get(i).getCodUser() == codPerson) {
				result += saleProductsList.get(i).getSoldProductsList() + "\n";
			}
		}
	}
}
