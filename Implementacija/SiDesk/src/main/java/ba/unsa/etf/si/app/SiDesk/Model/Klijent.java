package ba.unsa.etf.si.app.SiDesk.Model;

import java.util.ArrayList;

public class Klijent {

	private String ime;
	private String prezime;
	private String brojTelefona;
	private int starost;
	private String zaposlenje;
	
	private ArrayList<TelefonskiPoziv> pozivi;
	
	public Klijent() {
		
	}
	
	public Klijent(String ime, String prezime, String brojTelefona, int starost, String zaposlenje) {
		this.ime=ime;
		this.prezime=prezime;
		this.brojTelefona=brojTelefona;
		this.starost=starost;
		this.zaposlenje=zaposlenje;
	}
	
	
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public int getStarost() {
		return starost;
	}

	public void setStarost(int starost) {
		this.starost = starost;
	}

	public String getZaposlenje() {
		return zaposlenje;
	}

	public void setZaposlenje(String zaposlenje) {
		this.zaposlenje = zaposlenje;
	}
	
	
    public ArrayList<TelefonskiPoziv> getPozivi() {
		return pozivi;
	}

	public void setPozivi(ArrayList<TelefonskiPoziv> pozivi) {
		this.pozivi = pozivi;
	}

	
	
}
