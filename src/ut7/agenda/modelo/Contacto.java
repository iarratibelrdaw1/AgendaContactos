package ut7.agenda.modelo;

public abstract class Contacto implements Comparable<Contacto>{

	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;

	public Contacto(String nombre, String apellidos, String telefono,
			String email) {
		this.nombre = nombre.toUpperCase();
		this.apellidos = apellidos.toUpperCase();
		this.telefono = telefono;
		this.email = email.toLowerCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public abstract String getFirmaEmail();
	
	// CompareTo
	@Override
	public int compareTo(Contacto o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// Equals
	@Override
	public boolean equals(Object obj)
	 {
	 if ( this == obj) {
	return true;
	 }
	 if ( obj == null) {
	return false;
	 }
	 if(this.getClass() != obj.getClass()) {
	return false;
	 }
	 Contacto p = (Contacto) obj;
	 return p.getApellidos().equalsIgnoreCase(apellidos) && p.getNombre().equalsIgnoreCase(nombre) && p.getEmail().equalsIgnoreCase(email);
	 }

	// HashCode
	@Override
	public int hashCode() {
		return nombre.hashCode() + apellidos.hashCode() + telefono.hashCode() + email.hashCode() * 11;

	}

}
