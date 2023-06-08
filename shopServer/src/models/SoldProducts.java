package models;

public class SoldProducts {
	private static int idt;
	private int codProduct;
	private String name;
	private String description;
	private double priceTotalSold;
	private int soldUnits;
	
	
	
	
	public SoldProducts(int codProduct, String name, String description,  double priceTotalSold, int soldUnits) {
		this.idt = ++ idt;
		this.codProduct = codProduct;
		this.name = name;
		this.description = description;
		this.soldUnits = soldUnits;
		this.priceTotalSold = priceTotalSold * soldUnits;
		
	}

	
	
	public int getCodProduct() {
		return codProduct;
	}


	public String getDescription() {
		return description;
	}


	public int getSoldUnits() {
		return soldUnits;
	}


	public double getPriceTotalSold() {
		return priceTotalSold;
	}


	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return idt + "-" + codProduct + "-" + name + " " + description + "-" + soldUnits + "-" + priceTotalSold;
	}
}
