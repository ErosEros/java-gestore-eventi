package org.esercizio.java;
import java.util.Scanner;
public class Main {

	public static void main(String[] args)throws Exception  {
		// TODO Auto-generated method stub
		
//		STAMPO IL CONCERTO
		Concerto c = new Concerto("Dualipa","02/01/2024",100,"18:00","1234.567");
		System.out.println(c);
		
		
		//SCANNER
		Scanner s = new Scanner(System.in);
		int posti = 0;

//		PONGO UNA DOMANDA ALL'UTENTE
		System.out.println("Inserisci un evento? 1-si 2-no");
		String scelta = s.nextLine();
		
//		CONDIZIONE SI
		if (scelta.equals("1")) {
			System.out.println("Inserisci il titolo dell'evento");
			String titolo = s.nextLine();
			System.out.println("Inserisci la data");
			String data = s.nextLine();
			
//		GESTISCO L'ERRORE			
			try {
				System.out.println("Inserisci il numero di postiTotale");
				posti = s.nextInt();
				s.nextLine();

			} catch (Exception e) {
				System.out.println("Inserisci un numero!");

			}

//			CREO L'EVENTO
			Evento e = new Evento(titolo, data, posti);

//			PONGO UNA DOMANDA ALL'UTENTE
			System.out.println("Vuoi prenotare ? 1 - si 2-no");
			String sceltaP = s.nextLine();

//			CONDIZIONE SI
			if (sceltaP.equals("1")) {
				System.out.println("Quanti posti vuoi prenotare?");
				int postiPrenotati = s.nextInt();
				s.nextLine();
				
//				CICLO LE PRENOTAZIONI
				for (int i = 1; i <= postiPrenotati; i++) {

					try {
						e.aggiungiPosto();
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
				}

//				STAMPO LE PRENOTAZIONI E I POSTI TOTALI
				System.out.println("I posti prenotati sono: " + e.getNumeroPostiPrenotati());
				System.out.println("I posti disponibili sono : " + e.getNumeroPostiTotale());

				System.out.println("Vuoi disdire qualche posto? 1-si 2-no");
				String sceltaD = s.nextLine();
				
//				PONGO UNA DOMANDA ALL'UTENTE
				if (sceltaD.equals("1")) {
					System.out.println("Quanti posti vuoi disdire?");
					int postiTolti = s.nextInt();
					s.nextLine();
					
//				CICLO LE PRENOTAZIONI PER I POSTI TOLTI		
					for (int i = 1; i <= postiTolti; i++) {

//				GESTISCO L'ERRORE
						try {
							e.togliPosto();
						} catch (Exception e2) {
							System.out.println(e2.getMessage());
						}

					}
//					STAMPO LE PRENOTAZIONI E I POSTI TOTALI
					System.out.println("I posti prenotati sono: " + e.getNumeroPostiPrenotati());
					System.out.println("I posti disponibili sono : " + e.getNumeroPostiTotale());

				} else {

					System.out.println("I posti prenotati sono: " + e.getNumeroPostiPrenotati());
					System.out.println("I posti disponibili sono : " + e.getNumeroPostiTotale());
				}

			} else {
				System.out.println("Arrivederci");
			}

		} else {
			System.out.println("Ciao bello");
			s.close(); }
	} 
	
}
