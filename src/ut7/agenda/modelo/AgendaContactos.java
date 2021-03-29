package ut7.agenda.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	public AgendaContactos() {

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

	public List<Contacto> buscarContactos(String texto) {

		return null;

	}

	public List<Personal> personalesEnLetra(char letra) {

		return null;
	}

	public List<Personal> felicitar() {

		return null;
	}

	public void personalesPorRelacion() {

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
				public int compare(Personal p1, Personal p2) {
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
