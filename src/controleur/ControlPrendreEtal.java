package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		
		return village.rechercherEtalVide();
		
		
		
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		//TODO a completer
		int numeroEtal = -1;
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
		

	}
}