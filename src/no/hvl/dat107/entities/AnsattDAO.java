package no.hvl.dat107.entities;

import java.util.List;
import java.util.Scanner;

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
	
	public Ansatt finnAnsattMedId(int id) {
	
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Ansatt.class, id);
		}
		finally {
			em.close();
		}
	}
	
	public Ansatt finnAnsattMedBruker(String bruker) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Ansatt ansatt = null;
		
		try {
			et.begin();
			TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a WHERE a.bruker = :bruker", Ansatt.class);
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
	
	public void oppdaterAnsatt(Ansatt ansatt) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Scanner scnr = new Scanner(System.in);
		
		try {
			et.begin();
			System.out.println("Vil du oppdatere stilling? ja/nei?");
			if(scnr.nextLine() == "ja") {
				System.out.println("Skriv inn ny stilling: ");
				scnr.nextLine();
				ansatt.setStilling(scnr.nextLine());
			}
			else if(scnr.nextLine() == "nei") {
				System.out.println("Stilling ikke oppdatert!!!");
			}
			System.out.println("Vil du oppdatere lønn? ja/nei?");
			if(scnr.nextLine() == "ja") {
				System.out.println("Skriv inn ny lønn: ");
				scnr.nextInt();
				ansatt.setMaanedslonn(scnr.nextInt());
			}
			else if(scnr.nextLine() == "nei") {
				System.out.println("Lønn ikke oppdatert!!!");
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
	
	public void leggTilAnsatt(Ansatt ansatt) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(ansatt);
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
