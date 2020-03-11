//Autor Luis Rosales 19181
//Hoja de Trabajo 6
//Estructura de Datos
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main (String [] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String[] cards = null;
		String card, value, key = null, userKey = null,menu;//Key
		boolean menut;
		int last;

	
		FactoryMap FM = new FactoryMap();
		
// Elegir implementacion
		 
		System.out.println("CARTAS");
		System.out.println("ELIGE IMPLEMENTACION");
		System.out.println("1. IMPLEMENTAR HASHMAP");
		System.out.println("2. IMPLEMENTAR TREEMAP");
		System.out.println("3. IMPLEMENTAR LINKEDHASHMAP");
		System.out.print("INGRESE OPCION: ");
		menu = sc.nextLine();
		menut = MenuInvalidoF(menu);
		while (menut != false) {
			System.out.print("INGRESE OTRA VEZ EL QUE DESEE: ");	
			menu = sc.nextLine();
			menut = MenuInvalidoF(menu);
		}
		
		InterMap map = FM.getIniciar(menu);
		
		InterMap user = FM.getIniciar(menu);
		
		
//Leer file

		BufferedReader in = new BufferedReader(new FileReader("cards_desc.txt"));


		while((card = in.readLine()) != null)
		{
		
			cards = card.split("\\|");
			
			
			for (int i = 0; i < cards.length; i++) {
				if (i%2 == 0) {
					key = cards[i];
				}else if (i%2 == 1) {
					value = cards[i];
					map.correrCartas(key, value);
				}			
			}
		}
		
//-------------------------------MENU--------------------------------------------------------------------
		do {
			
			System.out.println("1. AGREGAR CARTA");
			System.out.println("2. BUSCAR CARTA");
			System.out.println("3. INFO CARTAS");
			System.out.println("4. INFO COLECCION POR TIPO");
			System.out.println("5. INFO CARTAS ACTUALES");
			System.out.println("6. INFO CARTAS ACTUALES POR TIPO");
			System.out.println("7. Salir");
			System.out.print("INGRESE LA OPCION: ");
			menu = sc.nextLine();
			menut = PrograDefensiva2(menu);
			while (menut != false) {
				System.out.print("INGRESAR DE NUEVO: ");	
				menu = sc.nextLine();
				menut = PrograDefensiva2(menu);
			}
		
			switch (menu) {
		
			case("1"):
				System.out.println("INGRESE CARTA A INGRESAR: ");
				userKey = sc.nextLine();
				if(map.buscarCartas(userKey) != (null)) {
					user.correrCartas(userKey, map.getCarta(userKey));
					System.out.println("LA CARTA HA SIDO AGREGADA");
				}else
					System.out.println("NO ESTA LA CARTA");
				break;
		
			case("2"):
				System.out.println("INGRESE NOMBRE DE CARTA PARA VER EL TIPO: ");
				userKey = sc.nextLine();
				System.out.println("EL TIPO DE LA CARTA " + userKey + " ES: " + map.getCarta(userKey));
				break;
		
			case("3"):
				if(user.isEmpty()){
					System.out.println("NO HAY CARTAS");
				}else {
					last = user.getCartas().size();
					System.out.println("LA CANTIDAD DE CARTAS SON: "+last);
					System.out.println("LAS CARTAS SON: ");
					for(int a = 0; a < last;a++)
						System.out.println("-"+user.getCartas().get(a));
				}

			break; 
			case("4"):
				if(user.isEmpty()) {
					System.out.println("No hay elementos en la coleccion usuario");
				}
				else {
					last = user.getOrdenCartas().size();
					System.out.println("LA CANTIDAD DE CARTAS POR TIPO SON: ");
					System.out.println("-SPELL: "+ user.cantidadCartas(0)+" CARTAS");
					System.out.println("-TRICK: "+ user.cantidadCartas(1)+" CARTAS");
					System.out.println("-MONSTER: "+ user.cantidadCartas(2)+" CARTAS");
					System.out.println("LAS CARTAS ORDENADAS POR TIPO SON: ");
					for(int a = 0; a < last ;a++)
						System.out.println("-"+user.getOrdenCartas().get(a));
				}
			break;
		
			case("5"):
				last = map.getCartas().size();
				System.out.println("LAS CARTAS EN CANTIDAD SON: "+last);
				System.out.println("LAS CARTAS EXISTENTES SON: ");
				for(int a = 0; a < last;a++)
					System.out.println("*"+map.getCartas().get(a));
		
			break;
		
			case("6"):
				last = map.getOrdenCartas().size();
				System.out.println();
				System.out.println("LA CANTIDAD POR TIPO DE CARTA SON: ");
				System.out.println("*SPELL: "+ map.cantidadCartas(0)+" CARTAS");
				System.out.println("*TRICK: "+ map.cantidadCartas(1)+" CARTAS");
				System.out.println("*MONSTER: "+ map.cantidadCartas(2)+" CARTAS");
				System.out.println();
				System.out.println("LAS CARTAS ORDENADAS POR TIPO SON: ");
				for(int a = 0; a < last;a++)
					System.out.println("*"+map.getOrdenCartas().get(a));
			break;	
			}
		}while(!menu.equals("7"));
			
	}
	
	// Progra defensiva
	
	public static boolean PrograDefensiva2(String me) {
		 boolean invalido = false;
		 if (!me.equals("1") && !me.equals("2") && !me.equals("3") && !me.equals("4") && !me.equals("5") && !me.equals("6") && !me.equals("7") ) 
			 invalido = true;
		else 
			invalido = false;
		 
		 return invalido;
	 }
	
	 public static boolean MenuInvalidoF(String me) {
		 boolean invalido = false;
		 if (!me.equals("1") && !me.equals("2") && !me.equals("3")) 
			 invalido = true;
		else 
			invalido = false;
		 
		 return invalido;
	 }
	
}

