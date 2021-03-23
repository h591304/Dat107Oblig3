package no.hvl.dat107.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ansatt", schema = "oblig3")
public class Ansatt {

	@Id private int ansattID;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate dato;
	private String stilling;
	private BigDecimal maanedslonn;
	
	public Ansatt() {
		
	}
	
	public Ansatt(int ansattID, String brukernavn, String fornavn, String etternavn, LocalDate dato, String stilling,
			BigDecimal maanedslonn) {
		this.ansattID = ansattID;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.dato = dato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
	}

	public int getAnsattID() {
		return ansattID;
	}

	public void setAnsattID(int ansattID) {
		this.ansattID = ansattID;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getAnsattDato() {
		return dato;
	}

	public void setAnsattDato(LocalDate dato) {
		this.dato = dato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public BigDecimal getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(BigDecimal maanedslonn) {
		this.maanedslonn = maanedslonn;
	}

	@Override
	public String toString() {
		return "Ansatt [ ansattID: " + ansattID + " | brukernavn: " + brukernavn + " | fornavn: " + fornavn + "| etternavn: "
				+ etternavn + " | ansattDato: " + dato + " | stilling: " + stilling + " | maanedslonn: " + maanedslonn
				+ " ]";
	}
	
	public void skrivUt() {
		System.out.println(this);
	}
	
}
