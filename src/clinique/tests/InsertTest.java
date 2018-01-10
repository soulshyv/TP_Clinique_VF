package clinique.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import clinique.models.Animal;
import clinique.models.Client;
import clinique.models.Personnel;

public class InsertTest {

	@Test
	public void test() throws Exception {
		Animal animal1 = new Animal(80, "Porg", "Porgy", "M", "Jaune", "Porg", "SW-06-08", "Aucun", false);
		Animal animal2 = new Animal(80, "Porg", "", "M", "Jaune", "Porg", "SW-06-08", "Aucun", false);
		Animal animal3 = new Animal(0, "Porg", "Porgy", "M", "Jaune", "Porg", "SW-06-08", "Aucun", false);
		Client client1 = new Client(79182609, "Luke", "Sky", "PorgLand", "Sur une montagne", "99000", "JedhaCity", "+SW832458796", "Porga", "Vivelesporg@porg.com", "Rien a signaler", false);
		Personnel p1 = new Personnel(567424, "Monbosapin", "Bosapin", "MonBosapindenoel", false);
	}
}
