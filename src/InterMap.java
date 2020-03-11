//Autor Luis Rosales 19181
//Hoja de Trabajo 6
//Estructura de Datos
import java.util.*;

public interface InterMap<K,V> {
	
	public void correrCartas(K key, V value); //adds a new element to the map
	public V getCarta(K key); //get the value of the key
	public ArrayList getCartas(); //show the cards in the map
	public K buscarCartas(K key); //look if a key is on the map
	public ArrayList getOrdenCartas(); //show the cards in the map ordered by the type
	public int cantidadCartas(int type); //returns the quantity of each type of the cards in the map
	public boolean isEmpty(); //returns true is the map is empty

}
