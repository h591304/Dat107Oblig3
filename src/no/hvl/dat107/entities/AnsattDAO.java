package no.hvl.dat107.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattDAO {

	private EntityManagerFactory emf;
	
	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattPU");
	}
	
	public void leggTilAnsatt(Ansatt ansatt) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(ansatt);
	        et.commit();
	        System.out.println("Den nye ansatte er nå lagt til databasen!!!");
	    }
		
		catch (Throwable e) {
	        e.printStackTrace();
	        et.rollback();
	    } 
		finally {
	        em.close();
	    }
	}
	
	public Ansatt finnAnsattMedId(int id) {
	
		EntityManager em = emf.createEntityManager();
		
		Ansatt ansatt = null;
		
		try {
			ansatt = em.find(Ansatt.class, id);
		}
		finally {
			em.close();
		}
		return ansatt;
	}
	
	public Ansatt finnAnsattMedBruker(String bruker) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Ansatt ansatt = null;
		
		try {
			et.begin();
			String strQuery = "SELECT a FROM Ansatt a" + "WHERE a.bruker = :bruker";
			TypedQuery<Ansatt> query = em.createQuery(strQuery, Ansatt.class);
			query.setParameter("bruker", bruker);
			ansatt = query.getSingleResult();
			et.commit();
		}
		catch (Throwable e){
			e.printStackTrace();
			et.rollback();
		}
		finally {
			em.close();
		}
		return ansatt;
	}
	
	public List<Ansatt> listeOverAlleAnsatte() {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		List<Ansatt> ansatt = null;
		
		try {
			et.begin();
			TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a", Ansatt.class);
			ansatt = query.getResultList();
			et.commit();
		}
		catch(Throwable e) {
			e.printStackTrace();
			et.rollback();
		}
		finally {
			em.close();
		}
		return ansatt;
	}
	
	public void oppdaterAnsattStilling(String stilling, int id) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Du har valgt å endre stilling");
		
		try {
			et.begin();
			Ansatt a = em.find(Ansatt.class, id);
			
			if(a != null) {
				a.setStilling(stilling);
				em.merge(a);
			}
	        
			et.commit();
	    }
		catch (Throwable e) {
			e.printStackTrace();
	        et.rollback();
	    } 
		finally {
	        em.close();
	    }
	}
	
	public void oppdaterAnsattLonn(BigDecimal lonn, int id) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Du har valgt å endre stilling");
		
		try {
			et.begin();
			Ansatt a = em.find(Ansatt.class, id);
			
			if(a != null) {
				a.setMaanedslonn(lonn);
				em.merge(a);
			}
			et.commit();
	    }
		catch (Throwable e) {
			e.printStackTrace();
	        et.rollback();
	    } 
		finally {
	        em.close();
	    }

	}
	
}
