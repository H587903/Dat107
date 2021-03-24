package oblig3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattDAO {

	EntityManagerFactory emf;

	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("Oblig3PersistenceUnit");
	}

	public void skrivUtAnsatte(List<Ansatt> liste) {
		for (Ansatt a : liste) {
			System.out.println(a.toString());
		}
	}

	public Ansatt finnAnsattMedId(int id) {
		EntityManager em = emf.createEntityManager();

		Ansatt a = null;

		try {
			a = em.find(Ansatt.class, id);
		} finally {
			em.close();
		}
		return a;
	}

	public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
		EntityManager em = emf.createEntityManager();

		Ansatt a = null;

		try {
			a = em.createQuery("SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn", Ansatt.class)
					.setParameter("brukernavn", brukernavn).getSingleResult();
		} finally {
			em.close();
		}
		return a;
	}

	public List<Ansatt> hentAnsattListe() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a", Ansatt.class);
		List<Ansatt> a = query.getResultList();

		return a;
	}

	public boolean oppdaterLønn(int id, int lonn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Ansatt a = null;
		
		try {
			et.begin();
			
			a = em.find(Ansatt.class, id);
			a.setLonn(lonn);
			
			a = em.merge(a);
			
			et.commit();
		} catch (Exception e) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public boolean leggTilAnsatt(Ansatt a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			a = em.merge(a);
			et.commit();
		} catch (Exception e) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public int finnNesteId() {
		List<Ansatt> a = hentAnsattListe();
		int id = a.get(a.size() - 1).getAid();
		return id + 1;
	}
}
