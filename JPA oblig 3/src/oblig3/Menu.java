package oblig3;

import java.sql.Date;
import java.util.Scanner;

public class Menu {
	AnsattDAO adao;

	public Menu() {
		adao = new AnsattDAO();
	}

	public void start() {
		Scanner sc = new Scanner(System.in);
		Ansatt a;
		int valg;
		while(true) {
			System.out.println("Skriv inn tall fra 1-6");
			
			valg = Integer.parseInt(sc.nextLine());
			
			switch(valg) {
			case 1: 
				System.out.println("Brukernavn: ");
				String brukernavn = sc.nextLine();
				System.out.println("Fornavn: ");
				String fornavn = sc.nextLine();
				System.out.println("Etternavn: ");
				String etternavn = sc.nextLine();
				System.out.println("Ansatt dato: ");
				Date ansattdato = Date.valueOf(sc.nextLine());
				System.out.println("Stilling: ");
				String stilling = sc.nextLine();
				System.out.println("Lønn: ");
				int lonn = Integer.parseInt(sc.nextLine());
				System.out.println("Avdeling: ");
				int avdeling = Integer.parseInt(sc.nextLine());
				
				a = new Ansatt(adao.finnNesteId(), brukernavn, fornavn, etternavn, ansattdato, stilling, lonn, avdeling);
				
				adao.leggTilAnsatt(a);
				break;
				
			case 2:
				System.out.println("Id: ");
				a = adao.finnAnsattMedId(Integer.parseInt(sc.nextLine()));
				System.out.println(a);
				break;
				
			case 3:
				System.out.println("Brukernavn: ");
				a = adao.finnAnsattMedBrukernavn(sc.nextLine());
				System.out.println(a);
				break;
				
			case 4:
				adao.skrivUtAnsatte(adao.hentAnsattListe());
				break;
				
			case 5:
				System.out.println("Id: ");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Lønn: ");
				int lonnn = Integer.parseInt(sc.nextLine());
				adao.oppdaterLønn(id, lonnn);
				System.out.println("Lønn oppdatert :)");
				break;
				
			case 6:
				sc.close();
				System.exit(0);
				break;
			
			default:
				break;
			}
		}
	}
}
