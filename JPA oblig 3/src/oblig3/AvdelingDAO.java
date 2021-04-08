package oblig3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AvdelingDAO {

	EntityManagerFactory emf;

	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("Oblig3PersistenceUnit");
	}

	public Avdeling finnAvdelingMedId(int id) {
		EntityManager em = emf.createEntityManager();
		Avdeling avd = null;

		try {
			avd = em.find(Avdeling.class, id);
		} finally {
			em.close();
		}
		return avd;
	}

	public void ansattIAvdeling(int id) {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a where a.avdeling = :avid", Ansatt.class)
				.setParameter("avid", id);
		List<Ansatt> resultat = query.getResultList();

		TypedQuery<Avdeling> query2 = em.createQuery("SELECT a from Avdeling a where a.avid = :avid", Avdeling.class)
				.setParameter("avid", id);
		Avdeling resultat2 = query2.getSingleResult();

		for (Ansatt r : resultat) {
			if (r.getAid() == resultat2.getSjefid()) {
				System.out.println("***" + r + "***");
			} else {
				System.out.println(r);
			}
		}

	}

	public boolean oppdaterAnsattAvdeling(int id, int avid) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a where a.aid = :aid", Ansatt.class)
				.setParameter("aid", id);
		Ansatt resultat = query.getSingleResult();

		TypedQuery<Avdeling> query2 = em
				.createQuery("SELECT a from Avdeling a where a.sjefid = :sjefid", Avdeling.class)
				.setParameter("sjefid", resultat.getAid());
		List<Avdeling> resultat2 = query2.getResultList();

		if (resultat2.isEmpty()) {
			try {
				et.begin();
				resultat.setAvdeling(avid);
				resultat = em.merge(resultat);
				et.commit();
				return true;
			} finally {
				em.close();
			}
		} else {
			em.close();
			return false;
		}
	}

	public boolean leggTilAvdeling(Avdeling avd) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			avd = em.merge(avd);
			et.commit();
		} catch (Exception e) {
			return false;
		} finally {
			em.close();
		}
		return true;
	}
}
