package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Serialization <T> {
	private T valueObjet;
	private final String path;
	private Store store;
	
	public Serialization(T valueObjet, Store store) {
		this.valueObjet = valueObjet;
		this.store = store;
		this.path = "./assets/listUser.json";
	}
	public Serialization() {
		this.path = "./assets/listUser.json";
	}

	public void save() throws IOException {
		T objetValue = valueObjet;
		Gson gson = new Gson();
		String jsonUser = gson.toJson(objetValue);
		FileWriter myWriter = new FileWriter(path);
		myWriter.write(jsonUser);
		myWriter.close();
	}
	
	
	public String getInfoFile() throws IOException {
		String datasJson = "";
		String objLine= "";
		BufferedReader br = new BufferedReader(new FileReader(path));
		while((objLine = br.readLine())!= null ) {
			datasJson += objLine;
		}
		br.close();
	//	System.out.println("Todos"+ datasJson);
		return datasJson;
	}
	
	public ListUsers<Person> readLisPerson() throws IOException {
		File file = new File (path);
		String datasJson = getInfoFile();
		Gson gson = new Gson();
		ListUsers<Person>  objetValue =  gson.fromJson(datasJson, new TypeToken<ListUsers<Person>>(){
		}.getType());
		return objetValue;
	}
	
	
	
	
	

}
