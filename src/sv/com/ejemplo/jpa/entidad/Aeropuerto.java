package sv.com.ejemplo.jpa.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aeropuerto database table.
 * 
 */
@Entity
@NamedQuery(name="Aeropuerto.findAll", query="SELECT a FROM Aeropuerto a")
public class Aeropuerto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idaeropuerto;

	private String aeropuerto;

	private String ciudad;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="idpais")
	private Pai pai;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="aeropuerto1")
	private List<Vuelo> vuelos1;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="aeropuerto2")
	private List<Vuelo> vuelos2;

	public Aeropuerto() {
	}

	public int getIdaeropuerto() {
		return this.idaeropuerto;
	}

	public void setIdaeropuerto(int idaeropuerto) {
		this.idaeropuerto = idaeropuerto;
	}

	public String getAeropuerto() {
		return this.aeropuerto;
	}

	public void setAeropuerto(String aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Pai getPai() {
		return this.pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}

	public List<Vuelo> getVuelos1() {
		return this.vuelos1;
	}

	public void setVuelos1(List<Vuelo> vuelos1) {
		this.vuelos1 = vuelos1;
	}

	public Vuelo addVuelos1(Vuelo vuelos1) {
		getVuelos1().add(vuelos1);
		vuelos1.setAeropuerto1(this);

		return vuelos1;
	}

	public Vuelo removeVuelos1(Vuelo vuelos1) {
		getVuelos1().remove(vuelos1);
		vuelos1.setAeropuerto1(null);

		return vuelos1;
	}

	public List<Vuelo> getVuelos2() {
		return this.vuelos2;
	}

	public void setVuelos2(List<Vuelo> vuelos2) {
		this.vuelos2 = vuelos2;
	}

	public Vuelo addVuelos2(Vuelo vuelos2) {
		getVuelos2().add(vuelos2);
		vuelos2.setAeropuerto2(this);

		return vuelos2;
	}

	public Vuelo removeVuelos2(Vuelo vuelos2) {
		getVuelos2().remove(vuelos2);
		vuelos2.setAeropuerto2(null);

		return vuelos2;
	}

}