package frontiere;

import controleur.ControlAcheterProduit;
import java.util.Scanner;

public class BoundaryAcheterProduit 
{
    private ControlAcheterProduit controlAcheterProduit;
    private Scanner scanner = new Scanner(System.in);

    public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) 
    {
        this.controlAcheterProduit = controlAcheterProduit;
    }

    public void acheterProduit(String nomAcheteur) 
    {
        if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) 
        {
            System.out.println("Je suis désolée " + nomAcheteur + ", mais il faut être un habitant de notre village pour acheter ici.");
            return;
        }

        System.out.println("Quel produit voulez-vous acheter ?");
        String produit = scanner.nextLine();
        String[] etalsProduit = controlAcheterProduit.donnerEtalsProduit(produit);

        if (etalsProduit.length == 0) 
        {
            System.out.println("Désolé, personne ne vend ce produit au marché.");
            return;
        }

        System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
        
        for (int i = 0; i < etalsProduit.length; i += 3) 
        {
            System.out.println((i / 3 + 1) + " - " + etalsProduit[i]);
        }

        int choixVendeur = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (choixVendeur < 0 || choixVendeur * 3 >= etalsProduit.length) 
        {
            System.out.println("Choix invalide.");
            return;
        }

        String nomVendeur = etalsProduit[choixVendeur * 3];
        System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);

        System.out.println("Combien de " + produit + " voulez-vous acheter ?");
        int quantiteAchetee = scanner.nextInt();
        scanner.nextLine();

        String resultatAchat = controlAcheterProduit.acheterProduit(nomAcheteur, nomVendeur, produit, quantiteAchetee);
        System.out.println(resultatAchat);
    }
}