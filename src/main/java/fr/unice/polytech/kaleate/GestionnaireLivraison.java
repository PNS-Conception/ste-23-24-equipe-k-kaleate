package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.Commandable;
import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.commande.StatutCommande;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.restaurant.Restaurant;

import java.util.Map;

public class GestionnaireLivraison {
    private Commande commande;
    private Utilisateur utilisateur;

    public GestionnaireLivraison(Commande commande){
        this.commande = commande;
        utilisateur = commande.getUtilisateurRecepteur();
    }
    public void debuterLaCourse(){
        commande.setStatut(StatutCommande.EN_LIVRAISON);}

    public void arriverADestination(){
        commande.setStatut(StatutCommande.A_RECUPERER);}

    public void ajouterAHistorique(){
        utilisateur.getHistorique().add(commande);
        for (Commandable m : commande.getMenus()){
            Restaurant r = m.getRestaurant();
            if (r.tendances().get(m.getName())==null){
                r.tendances().put(m.getName(),1);
            }
            else {
                int val = r.tendances().get(m.getName());
                r.tendances().put(m.getName(),val+1);
            }
        }
    }

    public Commande getCommande() {
        return commande;
    }
}
