package ut7.agenda.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Clase AgendaContactos
 * 
 * @author Alex Calderón, Irune Arratibel, Daniel Jiménez
 * @version 1.0
 *
 */
public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	/**
	 * Constructor de AgendaContactos
	 */
	public AgendaContactos() {
		agenda = new TreeMap<Character, Set<Contacto>>();
	}
	
	/**
	 * Añade un contacto al Map. Si no hay con su inicial se crea una nueva clave,
	 * sino se añade, comprobando siempre si esta ya metido.
	 * @param Contacto c (el contacto a añadir)
	 */
	public void añadirContacto(Contacto c) {
		char prim = c.getNombre().charAt(0);
		if(agenda.containsKey(prim)) {
			if(!agenda.get(prim).contains(c)) {
				agenda.get(prim).add(c);
			}
		}
		else {
			HashSet<Contacto> cont = new HashSet<Contacto>();
			agenda.put(prim, cont);
			cont.add(c);
			agenda.put(prim, cont);
		}
	}

	public void contactosEnLetra() {

	}

	public void totalContactos() {

	}

	@Override
	public String toString() {

		return null;
	}

	/**
	 * Devuelve un ArrayList con todos los contactos que incluyen 
	 * el texto ,introducido como parámetro, en su nombre o apellidos.	
	 * @param texto
	 * @return ArrayList<Contacto> 
	 */
	public List<Contacto> buscarContactos(String texto) {
		
		ArrayList <Contacto> resul = new ArrayList<Contacto>();
		for(char clave: agenda.keySet()){
			for(Contacto lista: agenda.get(clave)) {
				if(lista.getNombre().contains(texto) || lista.getApellidos().contains(texto) )
					resul.add(lista);
			}
		}  
		
		return resul;

	}

	public List<Personal> personalesEnLetra(char letra) {

		return null;
	}

	/**
	 * Devuelve un ArrayList con los contactos 
	 * que hay que felicitar
	 * @return ArrayList <Personal>
	 */
	public List<Personal> felicitar() {
		ArrayList <Personal> resul = new ArrayList<Personal>();
		for(char clave: agenda.keySet()){
			for(Contacto lista: agenda.get(clave)) {
				if(lista instanceof Personal && ((Personal) lista).esCumpleaños())
					resul.add((Personal)lista);
			}
		}  

		return resul;
	}

	/**
	 * Devuelve TreeMap en el que aparecen los contactos 
	 * personales  organizados de forma que la clave en el nuevo
	 * map es la relación  y el valor asociado, un ArrayList
	 * de cadenas con los apellidos y nombre de todos los
	 * contactos personales que hay en la agenda
	 */
	public void personalesPorRelacion() {

		TreeMap<Relacion,List<Personal>> resul = new TreeMap<Relacion,List<Personal>>();
		
		resul.put(Relacion.PADRE, new ArrayList<Personal>());
		resul.put(Relacion.MADRE, new ArrayList<Personal>());
		resul.put(Relacion.AMIGOS, new ArrayList<Personal>());
		resul.put(Relacion.PAREJA, new ArrayList<Personal>());
		resul.put(Relacion.HIJO, new ArrayList<Personal>());
		resul.put(Relacion.HIJA, new ArrayList<Personal>());
		
		for(char clave: agenda.keySet()){
			for(Contacto lista: agenda.get(clave)) {
				if(lista instanceof Personal) {
					switch(((Personal) lista).getRel()) {
						case PADRE:
							resul.get(Relacion.PADRE).add((Personal) lista);
						case MADRE:
							resul.get(Relacion.MADRE).add((Personal) lista);
						case AMIGOS:
							resul.get(Relacion.AMIGOS).add((Personal) lista);
						case PAREJA:
							resul.get(Relacion.PAREJA).add((Personal) lista);
						case HIJO:
							resul.get(Relacion.HIJO).add((Personal) lista);
						case HIJA:
							resul.get(Relacion.HIJA).add((Personal) lista);
					}
				}
				
		
			}
		}  

		
	}

	/**
	 * Ordena una ArrayList por fecha de nacimiento, pero solo los que empiezan
	 * con una letra determinada. Estos se guardan en otra ArrayList y se trabaja
	 * sobre ella.
	 * @return List<Personal> con los contactos personales ordenados
	 */
	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {
		ArrayList<Personal> ord = new ArrayList<Personal>();
		Set<Contacto> contactos = agenda.get(letra);
		Iterator<Contacto> it = contactos.iterator();
		while(it.hasNext()) {
			Contacto c = it.next();
			if(c instanceof Personal) {
				Personal p = (Personal) c;
				ord.add(p);
			}
		}
		Collections.sort(ord, new Comparator<Personal>() {
				public int compare(Personal p1, Personal p2)  {
					if(p1.getFecha_nac().compareTo(p2.getFecha_nac()) > 0) {
						return 1;
					}
					if(p1.getFecha_nac().compareTo(p2.getFecha_nac()) < 0) {
						return -1;
					}
					return 0;
				}
			
		});

			
		return ord;
	}

}
