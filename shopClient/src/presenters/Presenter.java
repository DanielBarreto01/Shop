package presenters;

import net.Connection;

import java.io.IOException;

public class Presenter {

    private Connection connection;
    private String nameActualPerson;
    private int codActualPersaon;

    public Presenter() throws IOException {
        connection = new Connection();
    }

    public boolean add( int cod, String name, String username, String password, String typeperson) throws IOException {
        connection.writeInt(1);
        connection.writeInt(cod);
        connection.writeString(name);
        connection.writeString(username);
        connection.writeString(password);
        connection.writeString(typeperson);
        return connection.readBoolean();
    }

    public String searchPerson(String username, String password) throws IOException {
      //  boolean option = false;
        connection.writeInt(2);
        connection.writeString(username);
        connection.writeString(password);
        nameActualPerson = connection.readString();
        codActualPersaon = Integer.parseInt(connection.readString());
        return  connection.readString() ;
    }

    public String searchUpdatePerson(int codPerson) throws IOException {
        connection.writeInt(3);
        connection.writeInt(codPerson);
        return connection.readString();
    }

    public boolean updatePerson(String cod, String name, String username, String password, String typePerson, int codActualPerson) throws IOException {
        connection.writeInt(4);
        connection.writeInt(Integer.parseInt(cod));
        connection.writeString(name);
        connection.writeString(username);
        connection.writeString(password);
        connection.writeString(typePerson);
        connection.writeInt(codActualPerson);
        return connection.readBoolean();
    }

    public boolean deltePerson(int codPersonActual) throws IOException {
        connection.writeInt(5);
        connection.writeInt(codPersonActual);
        return connection.readBoolean();
    }

    public String showPerson() throws IOException{
        connection.writeInt(6);
        return connection.readString();
    }

    public boolean registerProduct(int codProduct, String name, String description, int units, double priceUnits) throws IOException {
        connection.writeInt(7);
        connection.writeInt(codProduct);
        connection.writeString(name);
        connection.writeString(description);
        connection.writeInt(units);
        connection.writeDouble(priceUnits);
        return connection.readBoolean();
    }

    public String searchUpdateAndDelteProduct(int codProduct) throws IOException {
        connection.writeInt(8);
        connection.writeInt(codProduct);
        if (connection.readBoolean()) {
            return connection.readString();
        }
        return "";
    }
    public String showProducts() throws IOException {
        connection.writeInt(10);
        return  connection.readString();
    }

    public boolean updateProduct(int codProduct, String name, String description, int units, double priceUnits, int codActualProduct) throws IOException {
        connection.writeInt(9);
        connection.writeInt(codProduct);
        connection.writeString(name);
        connection.writeString(description);
        connection.writeInt(units);
        connection.writeDouble(priceUnits);
        connection.writeInt(codActualProduct);
        return connection.readBoolean();
    }

    public boolean deleteProduct(int codActualProduct) throws IOException {
        connection.writeInt(11);
        connection.writeInt(codActualProduct);
        return connection.readBoolean();
    }

    public void registerCleint(String idClient, String nameClient) throws IOException {
        connection.writeInt(12);
        connection.writeInt(codActualPersaon);
       // connection.readInt();
        connection.writeString(idClient);
        connection.writeString(nameClient);
    }

    public void registerSoldProducts(int codProduct, String name, String description, double priceTotalSold, int soldUnits) throws IOException {
        connection.writeInt(13);
        connection.writeInt(codProduct);
        connection.writeString(name);
        connection.writeString(description);
        connection.writeDouble(priceTotalSold);
        connection.writeInt(soldUnits);
    }

    public String showSoldProducts() throws IOException {
        connection.writeInt(14);
        return connection.readString();
    }

    public String showSales(int codUser) throws IOException {
        connection.writeInt(15);
        System.out.println(codUser);
        connection.writeInt(codUser);
        return connection.readString();
    }

    public String getNameActualPerson() {
        return nameActualPerson;
    }
}

