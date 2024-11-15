package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					//TODO
					StringBuilder estgaulois = new StringBuilder();
					//a complete
					
					estgaulois.append("Bienvenu villagois"+nomVisiteur);
					estgaulois.append("\n" );
					estgaulois.append("Quelle est votre force ?" );
					int forceGaulois =Clavier.entrerEntier(estgaulois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);// apres la fleche , on est dans control emmenager donc ecrire avant
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder estdruid =new StringBuilder();
		estdruid.append("Bienvenu druid"+ nomVisiteur );
		estdruid.append("\n" );
		estdruid.append("Quelle est votre force" );
		int forceDruide =Clavier.entrerEntier(estdruid.toString());
		int effetpotionMax;
		int effetpotionMin;
		
		do {//do while pour dabord initialiser les val puis le faire
			estdruid.append("Quelle est la force de la potion la plus faible que vous produisiez");
			effetpotionMin =Clavier.entrerEntier(estdruid.toString());
			estdruid.append("Quelle est la force de la potion la plus forte que vous produisiez");
			effetpotionMax =Clavier.entrerEntier(estdruid.toString());
			if(effetpotionMax<effetpotionMin) {
				estdruid.append("Attention Druid , Vous vou etes tromper entre le minimum et le maximum");
				
			}
			
		}while(effetpotionMax<effetpotionMin);
			controlEmmenager.ajouterDruide(nomVisiteur, forceDruide,effetpotionMin,effetpotionMax);
				
		
		
		
		
	}
}
