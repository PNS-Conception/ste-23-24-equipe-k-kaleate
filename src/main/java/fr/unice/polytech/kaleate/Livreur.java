package fr.unice.polytech.kaleate;

public class Livreur {
    private Commande commande;
    private String nom;
    private String prenom;
    

    public Livreur(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.commande = null;
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

    public void debuterLaCourse(){commande.setStatut(StatutCommande.EN_ROUTE);}

    public void arriverADestination(){commande.setStatut(StatutCommande.A_RECUPERER);}
}
