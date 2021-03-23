package no.hvl.dat107.klient;

import no.hvl.dat107.entities.Ansatt;
import no.hvl.dat107.entities.AnsattDAO;

import java.util.Scanner;

import no.hvl.dat107.entities.*;

public class Meny {

	public void start() {
		
		//søker opp ansatt med etter id
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Tast 0, for å avslutte programmet");
		System.out.println("Tast 1, for søking etter Ansatt etter ID");
		System.out.println("Tast 2, for søking etter Ansatt på brukernavn");
		System.out.println("Tast 3, for utlisting av alle ansatte");
		System.out.println("Tast 4, for å oppdatere ansattinformasjon");
		System.out.println("Tast 5, for å legge til en ny ansatt");
		int input = scnr.nextInt();
		
		System.out.println("Du tastet " + input);
		
		switch(input) {
			
		case 0:
			System.out.println("Programmet er avsluttet!!!");
			break;
		
		case 1:
			System.out.println("Skriv inn ID nummeret til en ansatt: ");
			input = scnr.nextInt();
		
		case 2:
			System.out.println("Skriv inn initialene til en bruker: ");
			input = scnr.nextInt();
		
		case 3:
			System.out.println("Liste over alle ansatte: ");
			
		case 4:
			System.out.println("Hvilken informasjon vil du oppdatere: ");
			System.out.println("Tast 1, for stilling");
			System.out.println("Tast 2, for lønn");
			input = scnr.nextInt();
			
			switch(input) {
			
			case 1:
				System.out.println("Du har tastet 1 for stilling");
				
			case 2:
				System.out.println("Du har tastet 2 for lønn");
			}
			
		case 5:
			System.out.println("Du har valgt å legge til en ny ansatt");
		}		
		
	}
}
