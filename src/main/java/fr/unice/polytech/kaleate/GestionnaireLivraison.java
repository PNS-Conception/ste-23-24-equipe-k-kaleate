package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.commande.StatutCommande;

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
    }

    public Commande getCommande() {
        return commande;
    }
}
