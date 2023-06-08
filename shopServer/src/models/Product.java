package models;

public class Product {
	private int codProduct;
	private String name;
	private String description;
	private int units;
	private double priceUnits;
	
	public Product(int codProduct, String name, String description, int units, double priceUnits) {
		this.codProduct = codProduct;
		this.name = name;
		this.description = description;
		this.units = units;
		this.priceUnits = priceUnits;
	}

	public int getCodProduct() {
		return codProduct;
	}

	public void setCodProduct(int codProduct) {
		this.codProduct = codProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getPriceUnits() {
		return priceUnits;
	}

	public void setPriceUnits(double priceUnits) {
		this.priceUnits = priceUnits;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void recaculateUnits(int unitsSale) {
		if (this.units > 0) {
			this.units = units - unitsSale;
		}else {
			this.units = 0;
		}
	}
		
	
	@Override
	public String toString() {
		return codProduct + "-" + name + "-" + description + "-" + units + "-" + priceUnits;
	}
}
