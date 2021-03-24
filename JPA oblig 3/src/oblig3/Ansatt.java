package oblig3;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
@NamedQuery(name = "hentAlleAnsatte", query ="SELECT a FROM Ansatt a")
public class Ansatt {
	
	@Id
	private int aid;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private Date ansattdato;
	private String stilling;
	private int lonn;
	private int avdeling;
	
	public Ansatt() {
	}
	
	public Ansatt(int aid, String brukernavn, String fornavn, String etternavn, Date ansattdato, String stilling, int lonn, int avdeling) {
		this.aid = aid;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansattdato = ansattdato;
		this.stilling = stilling;
		this.lonn = lonn;
		this.avdeling = avdeling;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
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

	public Date getAnsattdato() {
		return ansattdato;
	}

	public void setAnsattdato(Date ansattdato) {
		this.ansattdato = ansattdato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getLonn() {
		return lonn;
	}

	public void setLonn(int lonn) {
		this.lonn = lonn;
	}
	
	public int getAvdeling() {
		return avdeling;
	}
	
	public void setAvdeling(int avdeling) {
		this.avdeling = avdeling;
	}

	@Override
	public String toString() {
		return "Ansatt " + aid + ", brukernavn = " + brukernavn + ", fornavn = " + fornavn + ", etternavn = " + etternavn
				+ ", ansattdato = " + ansattdato + ", stilling = " + stilling + ", lønn = " + lonn + ", avdeling = " + avdeling;
	}
}

