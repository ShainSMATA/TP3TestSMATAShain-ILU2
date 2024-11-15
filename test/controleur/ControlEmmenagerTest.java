package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
	
	@BeforeEach
	void init() { 
		Village village = new Village(null, 0, 0);
		Chef chef = new Chef("lui",3,village); 
		village.setChef(chef); 
	}
	

	@Test
	void isHabitantTest() {
		
	}

	@Test
	void testIsHabitant() {
		fail("Not yet implemented");
	}

	@Test
	void testAjouterDruide() {
		fail("Not yet implemented");
	}

	@Test
	void testAjouterGaulois() {
		fail("Not yet implemented");
	}

}
