package org.esercizio.java;
import java.util.Scanner;
public class Main {

	public static void main(String[] args)throws Exception  {
		// TODO Auto-generated method stub
		
		//SCANNER
		Scanner s = new Scanner(System.in);
		int posti = 0;

		System.out.println("Inserisci un evento? 1-si 2-no");
		String scelta = s.nextLine();
		if (scelta.equals("1")) {
			System.out.println("Inserisci il titolo dell'evento");
			String titolo = s.nextLine();
			System.out.println("Inserisci la data");
			String data = s.nextLine();
			try {
				System.out.println("Inserisci il numero di postiTotale");
				posti = s.nextInt();
				s.nextLine();

			} catch (Exception e) {
				System.out.println("Inserisci un numero!");

			}

			Evento e = new Evento(titolo, data, posti);

			System.out.println("Vuoi prenotare ? 1 - si 2-no");
			String sceltaP = s.nextLine();

			if (sceltaP.equals("1")) {

				System.out.println("Quanti posti vuoi prenotare?");
				int postiPrenotati = s.nextInt();
				s.nextLine();

				for (int i = 1; i <= postiPrenotati; i++) {

					try {
						e.aggiungiPosto();
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
				}

				System.out.println("I posti prenotati sono: " + e.getNumeroPostiPrenotati());
				System.out.println("I posti disponibili sono : " + e.getNumeroPostiTotale());

				System.out.println("Vuoi disdire qualche posto? 1-si 2-no");
				String sceltaD = s.nextLine();
				
				if (sceltaD.equals("1")) {
					System.out.println("Quanti posti vuoi disdire?");
					int postiTolti = s.nextInt();
					s.nextLine();
					for (int i = 1; i <= postiTolti; i++) {

						try {
							e.togliPosto();
						} catch (Exception e2) {
							System.out.println(e2.getMessage());
						}

					}
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
		}
	}

}
