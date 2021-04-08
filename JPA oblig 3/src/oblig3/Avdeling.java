package oblig3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
@NamedQuery(name = "hentAlleAvdelinger", query = "SELECT avd FROM Avdeling avd")
public class Avdeling {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int avid;
	private String navn;
	private int sjefid;

	public Avdeling() {

	}

	public Avdeling(String navn, int sjefid) {
		this.navn = navn;
		this.sjefid = sjefid;
	}

	public int getAvid() {
		return avid;
	}

	public void setAvid(int avid) {
		this.avid = avid;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getSjefid() {
		return sjefid;
	}

	public void setSjefid(int sjefid) {
		this.sjefid = sjefid;
	}

	@Override
	public String toString() {
		return "Avdeling " + avid + ", navn = " + navn + ", sjefid = " + sjefid;
	}

}
