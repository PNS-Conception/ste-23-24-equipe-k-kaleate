package fr.unice.polytech.kaleate;

public class AdministrateurCampus {
    private Campus campus;

    public AdministrateurCampus(String campusnom){
        campus=new Campus(campusnom);
    }
    public AdministrateurCampus(Campus c){
        campus=c;
    }
    public ListRestaurants listerRestaurants(){
        return campus.listerRestaurants();
    }

    public void ajouterRestaurant(String nom){
        RestaurantFactory r = new RestauPartFacto();
        r.nouveauRestau(nom,campus);
    }

    public void ajouterRestaurant(Restaurant nom){
        campus.ajoutRestaurant(nom);
    }
}
