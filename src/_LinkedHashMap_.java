//Autor Luis Rosales 19181
//Hoja de Trabajo 6
//Estructura de Datos
import java.util.*;

public class _LinkedHashMap_<K,V> implements InterMap<K,V>{

	protected Map<K,V> cartas;
	
	public _LinkedHashMap_() {
		cartas = new LinkedHashMap<K,V>();
	}

	@Override
	public void correrCartas(K key, V value) {
		// TODO Auto-generated method stub
		cartas.put(key, value);
		
	}

	@Override
	public V getCarta(K key) {
		// TODO Auto-generated method stub
		V value;
		value = cartas.get(key);
		return value;
	}


	@Override
	public ArrayList<String> getCartas() {
		// TODO Auto-generated method stub
		ArrayList<String> cardsArray = new ArrayList<String>(); 
		Iterator iterador = cartas.entrySet().iterator();
    
		Map.Entry producto;
		while (iterador.hasNext()) {
			producto = (Map.Entry) iterador.next();
		
			cardsArray.add(producto.getKey() + "|" + producto.getValue());
			}
		
		return cardsArray;

	}

	/**
	 * searchCards
	 * pre: the map is full
	 * post: returns the key if this is on the map
	 * @return vKey: the key that the user gave
	 */
	@Override
	public K buscarCartas(K key) {
		K vkey = null;
		// TODO Auto-generated method stub
		   if (cartas.containsKey(key)) {
			   vkey = key;
		   }

		return vkey;
	}

	/**
	 * getOrderCards
	 * pre: the map is full and disorded
	 * post: returns an arraylist with all the cards order by type
	 * @returns hechizo: array with the order cards
	 */
	@Override
	public ArrayList getOrdenCartas() {
		// TODO Auto-generated method stub
		ArrayList<String> hechizo = new ArrayList<String>(); 
		for(Map.Entry m:cartas.entrySet()) {
			if (m.getValue().equals("Hechizo")) {
				hechizo.add(m.getKey()+"|"+m.getValue()); 
				}
		}
		for(Map.Entry m:cartas.entrySet()) {
			if (m.getValue().equals("Trampa")) {
				hechizo.add(m.getKey()+"|"+m.getValue()); 
				}
		}
		
		for(Map.Entry m:cartas.entrySet()) {
			if (m.getValue().equals("Monstruo")) {
				hechizo.add(m.getKey()+"|"+m.getValue()); 
				}
		}
		return hechizo;
	}

	/**
	 * Empty
	 * pre:
	 * post: returns if the map is empty
	 * @return 
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return cartas.isEmpty();
	}

	/**
	 * cantCards
	 * pre: the map is full
	 * post: returns the quantity of each type of the cards on the map
	 * @return cant
	 */
	@Override
	public int cantidadCartas(int type) {
		// TODO Auto-generated method stub
		int contMonster = 0;
		int contHechizo = 0;
		int contTrampa = 0;
		int cant = 0;
		for(Map.Entry m:cartas.entrySet()) {
			if (m.getValue().equals("Hechizo")) {
				contHechizo += 1;
				}
		}
		for(Map.Entry m:cartas.entrySet()) {
			if (m.getValue().equals("Trampa")) {
				contTrampa +=1;
				}
		}
		
		for(Map.Entry m:cartas.entrySet()) {
			if (m.getValue().equals("Monstruo")) {
				contMonster +=1;
				}
		}

		if(type == 0)
			cant = contHechizo;
		else if(type == 1)
			cant = contTrampa;
		else
			cant = contMonster;
		return cant;
	}

	
}
