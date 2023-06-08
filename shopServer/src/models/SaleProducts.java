package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class SaleProducts {
	private static int codSale;
	private int codUser;
	private double priceTotalSale;
	private LocalDate saleDate;
	private String clientName;
	private String idClient;
	private ArrayList<SoldProducts> soldProductsList;
	
	public SaleProducts(int codUser, LocalDate saleDate, String clientName, String idClient) {
		this.codSale = ++codSale;
		this.codUser = codUser;
		this.priceTotalSale = 0;
		this.saleDate = saleDate;
		this.clientName = clientName;
		this.idClient = idClient;
		soldProductsList = new ArrayList<>();
	}
	
	public void addPrductSold(SoldProducts soldProducts) {
		soldProductsList.add(soldProducts);
	}
	
	public int getCodUser() {
		return codUser;
	}

	public static int getCodSale() {
		return codSale;
	}

	public double getPriceTotalSale() {
		return priceTotalSale;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public String getClientName() {
		return clientName;
	}

	public String getIdClient() {
		return idClient;
	}

	public ArrayList<SoldProducts> getSoldProductsList() {
		return soldProductsList;
	}

	public String showProductSold() {
		String result = "";
		for (int i = 0; i < soldProductsList.size(); i++) {
			result += soldProductsList.get(i) + "\n";
		}
		return result;
	}
	
	@Override
	public String toString() {
		return codSale + "-" + codUser + "-" + clientName + "-" + saleDate.toString();
	}
}
