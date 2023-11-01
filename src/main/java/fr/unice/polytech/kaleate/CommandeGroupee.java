package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class CommandeGroupee extends Commande{
    ArrayList<Commande> commandes = new ArrayList<>();

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
}
