package sv.com.ejemplo.jpa.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String idusuario;

	private String apellidos;

	private String clave;

	private String email;

	private String nombres;

	private String telefono;

	//bi-directional many-to-one association to Reservacion
	@OneToMany(mappedBy="usuario")
	private List<Reservacion> reservacions;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol rol;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="idpais")
	private Pai pai;

	public Usuario() {
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Reservacion> getReservacions() {
		return this.reservacions;
	}

	public void setReservacions(List<Reservacion> reservacions) {
		this.reservacions = reservacions;
	}

	public Reservacion addReservacion(Reservacion reservacion) {
		getReservacions().add(reservacion);
		reservacion.setUsuario(this);

		return reservacion;
	}

	public Reservacion removeReservacion(Reservacion reservacion) {
		getReservacions().remove(reservacion);
		reservacion.setUsuario(null);

		return reservacion;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Pai getPai() {
		return this.pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}

}