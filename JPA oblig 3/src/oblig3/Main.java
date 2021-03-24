package oblig3;

import java.sql.Date;

public class Main {

	public static void main(String[] args) {
//		Menu menu = new Menu();
//		menu.start();
		AvdelingDAO avd = new AvdelingDAO();
		avd.ansattIAvdeling(1);
	}

}
