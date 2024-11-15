package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GauloisTest {
	
	Gaulois gaulois;
	
	@BeforeEach
	void init() {
		 gaulois = new Gaulois("asterix",1);
	}


	@Test
	void testpotion() {
		gaulois.boirePotion(6);
		assertEquals(gaulois.getEffetPotion(),6);
		
	}
	
	@Test
	void ToSTest() {
		String a = "Gaulois [nom=asterix, force=1, effetPotion=1]";
		assertEquals(a,gaulois.toString());
 		
	}
	
	
	
	
}
