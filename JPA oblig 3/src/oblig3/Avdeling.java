package oblig3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
@NamedQuery(name = "hentAlleAvdelinger", query ="SELECT avd FROM Avdeling avd")

//@NamedNativeQueries({
//	@NamedNativeQuery(
//			name = "hentsjef", 
//			query = "select Ansatt.* from Avdeling inner join Ansatt on Ansatt.aid = Avdeling.sjefid where Avdeling.avid = ?",
//			resultClass = Avdeling.class
//			)
//})

public class Avdeling {
	@Id
//	@ManyToOne
	private int avid;
	private String navn;
	private int sjefid;
	
	public Avdeling() {
		
	}
	
	public Avdeling(int avid, String navn, int sjefid) {
		this.avid = avid;
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
