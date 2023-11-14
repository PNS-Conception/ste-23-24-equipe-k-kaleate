package fr.unice.polytech.kaleate;

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
