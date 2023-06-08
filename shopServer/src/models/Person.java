package models;

public class Person {
	private int cod;
	private int position;
	private String name;
	private String userName;
	private String password;
	private String typePerson;
	
	public Person(int cod, String name, String userName, String password, String typePerson) {
		this.position = -1;
		this.cod = cod;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.typePerson = typePerson;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getTypePerson() {
		return typePerson;
	}

	public void setTypePerson(String typePerson) {
		this.typePerson = typePerson;
	}

	@Override
	public String toString() {
		return  cod + "-" + name + "-" + userName + "-" + password + "-" + typePerson;
	}
	
}
