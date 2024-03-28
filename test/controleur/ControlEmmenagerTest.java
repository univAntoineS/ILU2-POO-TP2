package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	
	
	@BeforeEach
	public void initialiserSituation()
	{
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles",10,5);
		this.abraracourcix = new Chef("Abraracourcis",10,village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(this.village);
		assertNotNull(controlEmmenager,"Constructeur ne revois pas null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(this.village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("n'existe pas trop"));
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
	}

	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(this.village);
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(this.village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
	}

}
