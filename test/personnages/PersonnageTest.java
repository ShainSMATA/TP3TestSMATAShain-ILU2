package personnages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonnageTest {

	Personnage personnage;
	
	@BeforeEach
	void init() {
		 personnage = new Personnage("moi",5);
	}


	@Test
	void teststring() {
		String a = "[nom=moi, force=5]";
		assertEquals(a,personnage.toString());
		
	}
	@Test
	void testpp() {
		String b = "moi : ";
		assertEquals(b,personnage.prendreParole());
		
	}
	
	@Test
	void testgetforce() {
		int force = 5;
		assertEquals(force,personnage.getForce());
		
	}
	
	@Test
	void testgetnom() {
		String nom = "moi";
		assertEquals(nom,personnage.getNom());
		
	}
	
	
	@Test
	void ErrForce() {     
	   
		assertThrows(         
				AssertionError.class,         
				()->{Personnage personnage = new Personnage("toi",-5);}         
				); 
		} 
	

	
	
}
