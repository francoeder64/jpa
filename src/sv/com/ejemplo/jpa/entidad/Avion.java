package sv.com.ejemplo.jpa.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the avion database table.
 * 
 */
@Entity
@NamedQuery(name="Avion.findAll", query="SELECT a FROM Avion a")
public class Avion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idavion;

	private int capacidad;

	private String descripcion;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="avion")
	private List<Vuelo> vuelos;

	public Avion() {
	}

	public int getIdavion() {
		return this.idavion;
	}

	public void setIdavion(int idavion) {
		this.idavion = idavion;
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Vuelo> getVuelos() {
		return this.vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public Vuelo addVuelo(Vuelo vuelo) {
		getVuelos().add(vuelo);
		vuelo.setAvion(this);

		return vuelo;
	}

	public Vuelo removeVuelo(Vuelo vuelo) {
		getVuelos().remove(vuelo);
		vuelo.setAvion(null);

		return vuelo;
	}

}