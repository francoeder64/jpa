package sv.com.davivienda.examen.prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sv.com.ejemplo.jpa.entidad.*;

public class Prueba {

	public static void main(String[] args) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
		Usuario usuario = new Usuario();
		usuario.setNombres("creado desde jpa");
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}

}
