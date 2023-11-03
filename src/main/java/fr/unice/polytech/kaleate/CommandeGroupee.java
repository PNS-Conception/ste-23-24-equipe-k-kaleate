package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class CommandeGroupee extends Commande{
    ArrayList<Commande> commandes = new ArrayList<>();
    public CommandeGroupee(){
        super();

    }
    public CommandeGroupee(Commande commande){
        super(commande.getUtilisateur(),commande.getMenus(),commande.getRestaurant());
        setCreneauLivraison(commande.getCreneauLivraison());
        commandes.add(commande);

    }
    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }

    public boolean ajouterCommande(Commande commande){
        if(commande.getCreneauLivraison() != null && //la commande est pas initialisé donc pas besoin de verif
                !(commande.getCreneauLivraison().equals(commandes.get(0).getCreneauLivraison()))){// la commande ajoutée doit avoir le meme restaurant que la commande mère
            return false;
        }
        return commandes.add(commande);

    }
}
