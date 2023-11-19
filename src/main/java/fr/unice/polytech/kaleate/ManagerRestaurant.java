package fr.unice.polytech.kaleate;

import java.util.Optional;

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

    public void supprimerUnMenu(Menu m){
        restaurant.supprimerMenu(m);
    }

    public void modifierUnMenu(Menu m, ChoixElement choixElement){
        Optional<Menu> optionalMenu = restaurant.getMenus()
                .stream()
                .filter(me -> me.estMenuParNom(m.getName()))
                .findFirst();

        if (optionalMenu.isPresent()) {
            Menu menu = optionalMenu.get();
            menu.ajouterChoixElement(choixElement);
        }
        else {
            System.out.println("le menu n'existe pas veillez le créer");
        }
    }

    public boolean commandePrete(int c){
        Commande commande = restaurant.getListCommande().getCommandeById(c);
        for (StatutMenu sm : commande.getStatutsMenus()){
                if (sm!=StatutMenu.PRET) return false;
            }
        commande.setStatut(StatutCommande.PRETE);
        return true;
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
