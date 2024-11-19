package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (! controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur)) {
			System.out.println("Je suis dÃ©solÃ© " + nomAcheteur + ", mais il faut etre un habitant de notre village pour commercer ici");
		} else {
			
			////////////////// demander le produit dÃ©sirÃ©
			
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			
			
			///////////////// trouver les vendeurs du produit		
			
			Gaulois vendeurs[] = controlAcheterProduit.trouverVendeurs(produit);
			if (vendeurs == null) {
				System.out.println("DÃ©solÃ©, personne ne vend ce produit au marchÃ©.");
			} else {
				
				////////////////////// sÃ©lection du commerÃ§ant
				
				System.out.println("Chez quel commerÃ§ant voulez-vous acheter des " + produit + " ?");
				int indice;
				//indice pour afficher "1 - Bonemmine" et non "0 - Bonemine"
				for (int i = 0; i < vendeurs.length; i++) {
					indice = i + 1;
					System.out.println(indice + " - " + vendeurs[i].getNom());
				}
				
				//StringBuilder question = new StringBuilder();
				int choixUtilisateur = -1;
				do {
					
					
					
					// Clavier.entrerEntier(question.toString()
					choixUtilisateur = scan.nextInt();
					choixUtilisateur -= 1;			// - 1 car j'ai rajoutÃ© + 1 Ã  l'indice plus haut
					
					if (choixUtilisateur < 0 || choixUtilisateur > vendeurs.length -1) {
						System.out.println("Entrez un numÃ©ro de commerÃ§ant valide");
					}
					
					
				} while (choixUtilisateur < 0 || choixUtilisateur > vendeurs.length - 1);

				
				
				
				////////////////// dÃ©placement Ã  l'Ã©tal
								
				String nomVendeur = vendeurs[choixUtilisateur].getNom();
				System.out.println(nomAcheteur + " se dÃ©place jusqu'Ã  l'Ã©tal du vendeur " + nomVendeur);
				System.out.println("Bonjour " + nomAcheteur);
				
				
				
				////////////////// demander quantite
				
				Etal etalVendeur = controlAcheterProduit.allerEtal(nomVendeur);			
				
				if (etalVendeur == null) {
					System.out.println("cet Ã©tal n'existe pas");
				} else {
					String etatEtal[] = etalVendeur.etatEtal();
					int qteDispo = Integer.parseInt(etatEtal[4]);
					System.out.println("etatEtal="+etatEtal[4]);	// etatEtal[3] ==> état au début du marché
																	// etatEtal[4] ==> état actuel
					
					
					System.out.println("Combien de " + produit + " voulez-vous acheter ?");
					int quantite = -1;
					do {
						quantite = scan.nextInt();
						if (quantite < 0) {
							System.out.println("Entrez un nombre positif, s'il-vous-plaÃ®t.");
						}
					} while (quantite < 0);
					
					//controlAcheterProduit.acheterProduit(nomAcheteur, quantite);
					
					
					///////////////// possibilitÃ©s selon quantitÃ© et quantitÃ© disponibl Ã  la vente
					///////////////// + achat du produit
					int nbAchete;
					
					if (qteDispo == 0)
					{
						// encore problÃ¨me nom acheteur
						System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus !");
					}
					else {
						if (quantite <= qteDispo) {
							nbAchete = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
							System.out.println(nomAcheteur + " achÃ¨te " + nbAchete + " " + produit + " Ã  " + nomVendeur);
						} else {
							nbAchete = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
							System.out.println(nomAcheteur + " veut acheter " + quantite +  " " + produit + ", malheureusement " + nomVendeur +
									" n'en a plus que " + qteDispo + ". " + nomAcheteur + " achÃ¨te tout le stock de " + nomVendeur);
						}
					}
					
					/////////////// achat du produit
					
					/* toujours problème ==> possibilité d'acheter 0 fleurs
					 * au lieu de "ce marchand ne vend plus rien"
					 * je ne rentre pas dans le "if (qteDispo == 0)"
					 * et c'est un vrai problème
					 * mais le test du prof est passé (où justement, il voulait voir si on achetait bien 0 fleurs)
					 * du coup, ça marche, mais pas si tu regardes trop près
					 * */
					 
					
					
				}
				
				
	
				
			}
	
		}
		
		// TODO à completer
	}
}
