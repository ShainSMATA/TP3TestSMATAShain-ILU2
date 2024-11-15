package frontiere;

import java.util.Scanner;
import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);
	

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		
		controlPrendreEtal.verifierIdentite(nomVendeur);
		
		if(nomVendeur == null) {
			
			System.out.println("Je suis desole" +  nomVendeur + " mais il faut etre un habitant de notre  village pour commencer ici");
		}else {
			
			System.out.println("Bonjour" + nomVendeur+ ", je vais regarder si je peux vous trouver un etal");
			
			
			
			if(!controlPrendreEtal.resteEtals()) {  
				System.out.println("Desole"+ nomVendeur+ "je n'ai plus d'etal qui ne soit pas deja occupée");
				
				
			}else {
				
			}
			
			
			
		}
		
		
		
		
	}

	private void installerVendeur(String nomVendeur) {
		//full print
	}
}
