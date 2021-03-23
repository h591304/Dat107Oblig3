package no.hvl.dat107.klient;

import no.hvl.dat107.entities.Ansatt;
import no.hvl.dat107.entities.AnsattDAO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import no.hvl.dat107.entities.*;

public class Meny {

	public void start() {
		
		//søker opp ansatt med etter id
		
		AnsattDAO ansatt = new AnsattDAO();
		Scanner scnr = new Scanner(System.in);
		
		meny();
		
		int input = scnr.nextInt();
		System.out.println("Du tastet " + input);
		
		while(input != 0) {
			switch(input) {
			case 1:
				System.out.println("Skriv inn ID nummeret til en ansatt: ");
				int ansID = scnr.nextInt();
				scnr.nextLine();
				Ansatt a = ansatt.finnAnsattMedId(ansID);
				System.out.println(a);
				break;
				
			case 2:
				System.out.println("Skriv inn et brukernavn: ");
				String user = scnr.nextLine();
				System.out.println(ansatt.finnAnsattMedBruker(user));
				break;
				
			case 3:
				System.out.println("Liste over alle ansatte: ");
				ansatt.listeOverAlleAnsatte();
				break;
				
			case 4:
				System.out.println("Oppgi ansattid: ");
				ansID = scnr.nextInt();
				System.out.println("Oppgi ny stilling for ansatt: ");
				String stilling = scnr.nextLine();
				ansatt.oppdaterAnsattStilling(stilling, ansID);
				
				break;
				
			case 5:
				System.out.println("Oppgi ansattid: ");
				ansID = scnr.nextInt();
				System.out.println("Oppgi ny lønn for ansatt");
				BigDecimal lonn = scnr.nextBigDecimal();
				ansatt.oppdaterAnsattLonn(lonn, ansID);
				break;
				
			case 6:
				System.out.println("Oppgi ansattID");
				int id1 = scnr.nextInt();
				scnr.nextLine();
				
				System.out.println("Oppgi brukernavn: ");
				String username1 = scnr.nextLine();
				
				System.out.println("Oppgi fornavn: ");
				String fornavn1 = scnr.nextLine();
				
				System.out.println("Oppgi etternavn: ");
				String etternavn1 = scnr.nextLine();
				
				System.out.println("Oppgi ansattdato: ");
				LocalDate ansattDato1 = LocalDate.now();
				scnr.nextLine();
				
				System.out.println("Oppgi stilling: ");
				String stilling1 = scnr.nextLine();
				
				System.out.println("Oppgi månedslønn: ");
				BigDecimal lonn1 = scnr.nextBigDecimal();
				
				Ansatt nyAnsatt = new Ansatt(id1, username1, fornavn1, etternavn1, ansattDato1, 
						stilling1, lonn1);
				ansatt.leggTilAnsatt(nyAnsatt);
				break;
				
				default:
					System.out.println("Feil inntastning!!");
			}
			System.out.println("Avslutt program? tast 0");
			input = scnr.nextInt();
		}
		scnr.close();
		System.out.println("Programmet er ferdig :)");
	}
	
	public static void meny() {
		
		System.out.println("----------MENY----------");
		System.out.println();
		System.out.println("Tast 0, for å avslutte programmet");
		System.out.println("Tast 1, for søking etter Ansatt etter ID");
		System.out.println("Tast 2, for søking etter Ansatt på brukernavn");
		System.out.println("Tast 3, for utlisting av alle ansatte");
		System.out.println("Tast 4, for å oppdatere stilling for en ansatt");
		System.out.println("Tast 5, for å oppdatere lønn for en ansatt");
		System.out.println("Tast 6, for å legge til en ny ansatt");
		System.out.println();
		System.out.println("------------------------\n");
		
	}
}
