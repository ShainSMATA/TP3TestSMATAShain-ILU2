package controleur;

import villagegaulois.Village;
import villagegaulois.Etal;
import personnages.Gaulois;

public class ControlAcheterProduit {
    private Village village;
    private ControlVerifierIdentite controlVerifierIdentite;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

    public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) 
    {
        this.village = village;
        this.controlVerifierIdentite = controlVerifierIdentite;
        this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
    }

    public boolean verifierIdentite(String nomAcheteur) 
    {
        return controlVerifierIdentite.verifierIdentite(nomAcheteur);
    }

    public String[] donnerEtalsProduit(String produit) 
    {
        Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
        
        if (vendeurs == null || vendeurs.length == 0) 
        {
            return new String[0];
        }

        String[] infosMarche = new String[vendeurs.length * 3];
        int index = 0;

        for (Gaulois vendeur : vendeurs) 
        {
            Etal etal = village.rechercherEtal(vendeur);
            
            if (etal != null) 
            {
                infosMarche[index++] = vendeur.getNom();
                infosMarche[index++] = String.valueOf(etal.getQuantite());
                infosMarche[index++] = etal.getProduit();
            }
        }
        return infosMarche;
    }

    public String acheterProduit(String nomAcheteur, String nomVendeur, String produit, int quantiteAchetee) 
    {
        Gaulois vendeur = village.trouverHabitant(nomVendeur);
        
        if (vendeur == null) 
        {
            return "Désolé, le vendeur " + nomVendeur + " n'appartient pas au village.";
        }

        Etal etal = village.rechercherEtal(vendeur);
        
        if (etal == null || !etal.contientProduit(produit)) 
        {
            return "Désolé, le vendeur " + nomVendeur + " ne vend pas ce produit.";
        }

        int quantiteDisponible = etal.getQuantite();
        
        if (quantiteDisponible == 0) 
        {
            return nomAcheteur + " veut acheter " + quantiteAchetee + " " + produit + ", malheureusement il n’y en a plus !";
        } 
        else if (quantiteAchetee > quantiteDisponible) 
        {
            etal.acheterProduit(quantiteDisponible);
            return nomAcheteur + " veut acheter " + quantiteAchetee + " " + produit + ", mais " + nomVendeur + " n'en a que " + quantiteDisponible + ". " + nomAcheteur + " achète tout le stock.";
        } 
        else 
        {
            etal.acheterProduit(quantiteAchetee);
            return nomAcheteur + " achète " + quantiteAchetee + " " + produit + " à " + nomVendeur + ".";
        }
    }
}