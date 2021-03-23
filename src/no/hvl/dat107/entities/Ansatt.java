package no.hvl.dat107.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Ansatt {

	@Id private int ansattID;
	private int brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansattDato;
	private String stilling;
	private int maanedslonn;
	
	public Ansatt(int ansattID, int brukernavn, String fornavn, String etternavn, LocalDate ansattDato, String stilling,
			int maanedslonn) {
		this.ansattID = ansattID;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansattDato = ansattDato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
	}

	public int getAnsattID() {
		return ansattID;
	}

	public void setAnsattID(int ansattID) {
		this.ansattID = ansattID;
	}

	public int getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(int brukernavn) {
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
		return ansattDato;
	}

	public void setAnsattDato(LocalDate ansattDato) {
		this.ansattDato = ansattDato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(int maanedslonn) {
		this.maanedslonn = maanedslonn;
	}

	@Override
	public String toString() {
		return "Ansatt [ ansattID: " + ansattID + " | brukernavn: " + brukernavn + " | fornavn: " + fornavn + "| etternavn: "
				+ etternavn + " | ansattDato: " + ansattDato + " | stilling: " + stilling + " | maanedslonn: " + maanedslonn
				+ " ]";
	}
	
	public void skrivUt() {
		System.out.println(this.toString());
	}
	
}
