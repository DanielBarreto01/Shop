package models;

import java.util.ArrayList;

public class ListUsers <T> {
	private ArrayList<Integer>positionFree;
	private ArrayList<T> listUser ;
	
	
	public ListUsers (ArrayList<Integer> positionFree) {
		this.positionFree = positionFree;
		listUser = new ArrayList<>();
	}
	
	
	
	public ArrayList<T> getListUser() {
		return listUser;
	}

	

	public ArrayList<Integer> getPositionFree() {
		return positionFree;
	}



	public void addUser(T value) {
		listUser.add(value);
		
	}
	/**
	 * inserta elemnto en posicion especifeca
	 * @param index posicion
	 * @param value elemento a agaregar
	 */
	public void addElementPositionspecific(int index ,T value) {
		listUser.add(index, value);
	}
	
	/**
	 * obtiene el total de los elemetos en el arrayList
	 * @return numero total de elementos 
	 */
	public int getTotalUser() {
		return listUser.size();
	}
	
	public void deleteUser(int index) {
		listUser.remove(index);
	}
	
	public boolean isEmpety() {
		return listUser.isEmpty();
	}
	
	/**
	 * obtiene el ultimo elemnto del arrayList
	 * @return ultimo eleemnto
	 */
	public T getLatestUser() {
		return getUser(getTotalUser()-1);
	}
	
	/**
	 * obtiene elemento en un indice en especifico
	 * @param index posicion del elemnto a traer 
	 * @return elemnto que estaba en la posicion
	 */
	public T getUser (int index) {
		return listUser.get(index);
	}
	
}
