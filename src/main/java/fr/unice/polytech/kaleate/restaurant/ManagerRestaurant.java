package fr.unice.polytech.kaleate.restaurant;

import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.commande.CommandeSimple;
import fr.unice.polytech.kaleate.commande.StatutCommande;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.menu.StatutMenu;

public class ManagerRestaurant {
    private String nom;
    private String prenom;
    private Restaurant restaurant;

    public ManagerRestaurant(String nom, String prenom, Restaurant restaurant){
        this.nom = nom;
        this.prenom = prenom;
        this.restaurant = restaurant;
    }

    public ManagerRestaurant(Restaurant r){
        this.restaurant = r;
        this.nom = "Nom";
        this.prenom = "Prenom";
    }

    public void ajouterUnMenu(Menu m){
        restaurant.ajouterMenu(m);
    }

    public boolean commandePrete(int c){
        Commande commande = restaurant.getListCommande().getCommandeById(c);
        if(commande == null){
            return false;
        }
        return commande.getStatut() == StatutCommande.PRETE;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
