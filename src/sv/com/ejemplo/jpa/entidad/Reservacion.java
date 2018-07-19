package sv.com.ejemplo.jpa.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the reservacion database table.
 * 
 */
@Entity
@NamedQuery(name="Reservacion.findAll", query="SELECT r FROM Reservacion r")
public class Reservacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idreservacion;

	private int nboletos;

	private BigDecimal precio;

	//bi-directional many-to-one association to Vuelo
	@ManyToOne
	@JoinColumn(name="idvuelo")
	private Vuelo vuelo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Reservacion() {
	}

	public int getIdreservacion() {
		return this.idreservacion;
	}

	public void setIdreservacion(int idreservacion) {
		this.idreservacion = idreservacion;
	}

	public int getNboletos() {
		return this.nboletos;
	}

	public void setNboletos(int nboletos) {
		this.nboletos = nboletos;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Vuelo getVuelo() {
		return this.vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}