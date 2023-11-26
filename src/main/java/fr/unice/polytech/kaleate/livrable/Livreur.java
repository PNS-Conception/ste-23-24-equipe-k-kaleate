package fr.unice.polytech.kaleate.livrable;

import fr.unice.polytech.kaleate.commande.CommandeSimple;

public class Livreur {
    private CommandeSimple commande;
    private String nom;
    private String prenom;

    public Livreur(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.commande = null;
    }

    public CommandeSimple getCommande() {
        return commande;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setCommande(CommandeSimple commande) {
        this.commande = commande;
    }
}
