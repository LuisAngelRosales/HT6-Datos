//Autor Luis Rosales 19181
//Hoja de Trabajo 6
//Estructura de Datos
import java.util.*;

public class _HashMap_<K,V> implements InterMap<K,V>{
	
	protected Map<K,V> cartas;
	
	public _HashMap_() {
		cartas = new HashMap<K,V>();
	}


	/**
	 * pushCards
	 * pre:
	 * post: adds new items to the map
	 */
	@Override
	public void correrCartas(K key, V value) {
		// TODO Auto-generated method stub
		cartas.put(key, value);
		
	}

	/**
	 * getCard
	 * pre: the map is full
	 * post: returns the value of the key
	 * @return value: the value of the key that the user gave
	 */
	@Override
	public V getCarta(K key) {
		// TODO Auto-generated method stub
		V value;
		value = cartas.get(key);
		return value;
	}

	/**
	 * getCards
	 * pre: the map is full
	 * post: returns an arraylist with all the cards on the map
	 * @return cardsArray: array with all the cards
	 */
	@Override
	public ArrayList<String> getCartas() {
		
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
	@Override
	public ArrayList getOrdenCartas() {
		// TODO Auto-generated method stub
		ArrayList<String> hechizo = new ArrayList<String>(); 
		for(Map.Entry m:cartas.entrySet()) {
			if (m.getValue().equals("H")) {
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


	@Override
	public int cantidadCartas(int type) {
	
		int contMonster = 0;
		int contSpell = 0;
		int contTrick = 0;
		int cantidad = 0;
		for(Map.Entry m:cartas.entrySet()) {
			if (m.getValue().equals("Hechizo")) {
				contSpell += 1;
				}
		}
		for(Map.Entry m:cartas.entrySet()) {
			if (m.getValue().equals("Trampa")) {
				contTrick +=1;
				}
		}
		
		for(Map.Entry m:cartas.entrySet()) {
			if (m.getValue().equals("Moustruo")) {
				contMonster +=1;
				}
		}

		if(type == 0)
			cantidad = contSpell;
		else if(type == 1)
			cantidad = contTrick;
		else
			cantidad = contMonster;
		return cantidad;
	}



	
}
