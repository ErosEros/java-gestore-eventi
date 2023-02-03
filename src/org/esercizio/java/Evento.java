package org.esercizio.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.EventObject;

public class Evento {

	private String titolo;
//	LOCAL DATE
	private LocalDate data;
//  FORMATTATORE DATA
	private final DateTimeFormatter formattatore = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private int numeroPostiTotale;
	private int numeroPostiPrenotati;

	public Evento(String titolo, String data, int numeroPostiTotale) throws Exception {
		super();
		this.titolo = titolo;
		this.data = controlloData(data);
		this.numeroPostiTotale =ciSonoPosti(numeroPostiTotale);
		this.numeroPostiPrenotati = 0;
	}
	
//	GETTERS E SETTERS

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(String data) throws Exception {
		this.data = controlloData(data);
	}

	public int getNumeroPostiTotale() {
		return numeroPostiTotale;
	}


	public int getNumeroPostiPrenotati() {
		return numeroPostiPrenotati;
	}
	
//	CONTROLLO DATA
	public LocalDate controlloData(String data) throws Exception {
		LocalDate dataLoc = LocalDate.parse(data,formattatore);
		if (dataLoc.isBefore(LocalDate.now())) {
			throw new Exception("La data non è valida!;");
		}
		return dataLoc;
	}
	
//  POSTI DISPONIBILI
	public int ciSonoPosti(int posti) throws Exception {
		if (posti <= 0) {
			throw new Exception("I posti non sono validi");
		}
		return posti;
	}

//	AGGIUNGI POSTO
	public void aggiungiPosto() throws Exception {
		if(data.isBefore(LocalDate.now())) {
			throw new Exception("La data è già passata");
		}
		if (numeroPostiPrenotati == numeroPostiTotale) {
			throw new Exception("Al completo");
		}
		numeroPostiPrenotati++;

	}

//	TOGLI POSTO
	public void togliPosto() throws Exception {
		if(data.isBefore(LocalDate.now())) {
			throw new Exception("La data è già passata.");
		}
		if (numeroPostiPrenotati <= 0) {
			throw new Exception("Non ci sono posti da togliere");
		}
		numeroPostiPrenotati--;
	}

	@Override
	public String toString() {
		return "Evento [titolo=" + titolo + ", data=" + data + "]";
	}
}