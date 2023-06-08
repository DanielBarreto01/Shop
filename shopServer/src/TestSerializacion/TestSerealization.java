package TestSerializacion;

import models.Person;
import models.Store;

public class TestSerealization {

	public static void main(String[] args) {
		 Store store = new Store();
		try {
			
			System.out.println(store.loadDataUsers());  // cargar datos 
			
		/*	// Agregar personas
			store.addPerson(new Person(28, "sara", "sergio.soto", "1", "Administrador"));
			store.addPerson(new Person(28, "sergio soto", "sergio.soto", "1", "Administrador"));
			store.addPerson(new Person(20, "daniel barreto", "daniel.barreto", "2",  "Administrador"));
			store.addPerson(new Person(20, "juan", "daniel.barreto", "2",  "Administrador"));
			//store.delete(0);
			System.out.println(store.loadDataUsers());*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
