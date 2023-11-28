package fr.unice.polytech.kaleate.livrable;

import fr.unice.polytech.kaleate.GestionnaireLivraison;
import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.commande.CommandeSimple;
import fr.unice.polytech.kaleate.commande.StatutCommande;
import fr.unice.polytech.kaleate.restaurant.Restaurant;

public class Livreur {
    private Commande commande;
    private String nom;
    private String prenom;

    private GestionnaireLivraison gestionnaireLivraison;

    public Livreur(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;

    }

    public Commande getCommande() {
        return commande;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Commande getCommmande() {
        return gestionnaireLivraison.getCommande();
    }
    public void attribuerCommande(Commande commande){
        gestionnaireLivraison = new GestionnaireLivraison(commande);
    }

    public void debuterLaCourse(){
        gestionnaireLivraison.debuterLaCourse();
      }

    public void arriverADestination(){
        gestionnaireLivraison.arriverADestination();
        }

    public void terminerLivraison(){
        gestionnaireLivraison.ajouterAHistorique();
        gestionnaireLivraison = null;

    }

    /**
     * Recuperer la commande prete i du restaurant r
     * @param r
     * @param i
     * @return
     */
    public boolean recupere_commande(Restaurant r, int i){
        Commande c = r.getCommandePrete().getCommandeById(i);
        System.out.println(c);
        if (c!=null & (this.gestionnaireLivraison==null||this.getCommmande().getStatut()== StatutCommande.LIVREE)){
            attribuerCommande(c);
            debuterLaCourse();
            return true;
        }
        return false;
    }
}
