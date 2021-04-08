package oblig3;

import java.sql.Date;
import java.util.Scanner;

public class Menu {
	AnsattDAO adao;
	AvdelingDAO avdao;

	public Menu() {
		adao = new AnsattDAO();
		avdao = new AvdelingDAO();
	}

	public void start() {
		Scanner sc = new Scanner(System.in);
		Ansatt a;
		Avdeling avd;

		int valg;
		while (true) {
			System.out.println("Skriv inn tall fra 1-10");

			valg = Integer.parseInt(sc.nextLine());

			switch (valg) {
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

				a = new Ansatt(brukernavn, fornavn, etternavn, ansattdato, stilling, lonn, avdeling);

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
				System.out.println("Avdeling med Id: ");
				id = Integer.parseInt(sc.nextLine());
				System.out.println(avdao.finnAvdelingMedId(id));
				break;

			case 7:
				System.out.println("List avdeling med id: ");
				id = Integer.parseInt(sc.nextLine());
				avdao.ansattIAvdeling(id);
				break;

			case 8:
				System.out.println("Oppdater ansatt med id: ");
				id = Integer.parseInt(sc.nextLine());
				System.out.println("Flytt til avdeling med id: ");
				int avid = Integer.parseInt(sc.nextLine());
				if (avdao.oppdaterAnsattAvdeling(id, avid)) {
					System.out.println("Avdeling oppdatert!");
				} else {
					System.out.println("Kunne ikkje oppdatere avdeling...");
				}
				break;

			case 9:
				System.out.println("Legg til ny avdeling: ");
				System.out.println("Navn: ");
				String navn = sc.nextLine();
				System.out.println("Sjefid: ");
				int sjefid = Integer.parseInt(sc.nextLine());
				avd = new Avdeling(navn, sjefid);
				if (avdao.leggTilAvdeling(avd)) {
					System.out.println("Avdeling Lagt til!");
				} else {
					System.out.println("Kunne ikkje legge til avdeling...");
				}
				break;

			case 10:
				sc.close();
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}
}
