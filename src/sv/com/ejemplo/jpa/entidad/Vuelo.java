package sv.com.ejemplo.jpa.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vuelo database table.
 * 
 */
@Entity
@NamedQuery(name="Vuelo.findAll", query="SELECT v FROM Vuelo v")
public class Vuelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idvuelo;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private BigDecimal precio;

	//bi-directional many-to-one association to Reservacion
	@OneToMany(mappedBy="vuelo")
	private List<Reservacion> reservacions;

	//bi-directional many-to-one association to Avion
	@ManyToOne
	@JoinColumn(name="idavion")
	private Avion avion;

	//bi-directional many-to-one association to Aeropuerto
	@ManyToOne
	@JoinColumn(name="idorigen")
	private Aeropuerto aeropuerto1;

	//bi-directional many-to-one association to Aeropuerto
	@ManyToOne
	@JoinColumn(name="iddestino")
	private Aeropuerto aeropuerto2;

	public Vuelo() {
	}

	public int getIdvuelo() {
		return this.idvuelo;
	}

	public void setIdvuelo(int idvuelo) {
		this.idvuelo = idvuelo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Reservacion> getReservacions() {
		return this.reservacions;
	}

	public void setReservacions(List<Reservacion> reservacions) {
		this.reservacions = reservacions;
	}

	public Reservacion addReservacion(Reservacion reservacion) {
		getReservacions().add(reservacion);
		reservacion.setVuelo(this);

		return reservacion;
	}

	public Reservacion removeReservacion(Reservacion reservacion) {
		getReservacions().remove(reservacion);
		reservacion.setVuelo(null);

		return reservacion;
	}

	public Avion getAvion() {
		return this.avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Aeropuerto getAeropuerto1() {
		return this.aeropuerto1;
	}

	public void setAeropuerto1(Aeropuerto aeropuerto1) {
		this.aeropuerto1 = aeropuerto1;
	}

	public Aeropuerto getAeropuerto2() {
		return this.aeropuerto2;
	}

	public void setAeropuerto2(Aeropuerto aeropuerto2) {
		this.aeropuerto2 = aeropuerto2;
	}

}