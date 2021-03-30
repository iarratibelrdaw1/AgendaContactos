package ut7.agenda.modelo;

/**
 * Clase Profesional, que hereda de Contacto añadiendo el nombre de la empresa
 * 
 * @author Alex Calderón, Irune Arratibel, Daniel Jiménez
 * @version 1.0
 *
 */
public class Profesional extends Contacto {
	private String nombreEmpresa;

	public Profesional(String nombre, String apellidos, String telefono, String email, String nombreEmpresa) {
		super(nombre, apellidos, telefono, email);
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	@Override
	public String toString() {
		return (super.toString() + "\nEmpresa: " + nombreEmpresa);
				
	}
	
	//@Override
	public String getFirmaEmail() {
		String resul="";
		int aux = (int)(Math.random() * 4 + 1);
		switch(aux) {
			case 1:
				resul = "Atentamente";
			case 2:
				resul = "Saludos";
			case 3:
				resul = "Saludos cordiales";
			case 4:
				resul = "Mis mejores deseos";	
		}
		return resul;
	}
	
	

}
