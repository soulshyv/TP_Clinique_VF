package clinique.main;

import java.sql.Connection;
import java.sql.SQLException;

import clinique.dal.jdbc.JdbcTools;
import clinique.models.Animal;
import clinique.models.Client;
import clinique.models.Personnel;

public class Main {

	public static void main(String[] args) {
		try {
			Animal animal1 = new Animal("Porgy", "Porg", 80, "M", "Jaune", "Porg", "SW-06-08", "Aucun", false);
			Animal animal2 = new Animal("", "Porg", 80, "M", "Jaune", "Porg", "SW-06-08", "Aucun", false);
			Animal animal3 = new Animal("Porgy", "Porg", 0, "M", "Jaune", "Porg", "SW-06-08", "Aucun", false);
			Client client1 = new Client(79182609, "Luke", "Sky", "PorgLand", "Sur une montagne", "99000", "JedhaCity", "+SW832458796", "Porga", "Vivelesporg@porg.com", "Rien a signaler", false);
			Personnel p1 = new Personnel(567424, "Monbosapin", "Bosapin", "MonBosapindenoel", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ca marche");
	}

}