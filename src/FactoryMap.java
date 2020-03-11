//Autor Luis Rosales 19181
//Hoja de Trabajo 6
//Estructura de Datos
public class FactoryMap<K,V>  {

	//Should implement the case code
	
	public InterMap<K,V> getIniciar(String num){
		
		switch(num) {
			case "1":
				return new _HashMap_();
			case "2":
				return new _TreeMap_();
			case "3": 
				return new _LinkedHashMap_();				
		}
		return null;
	}
}
