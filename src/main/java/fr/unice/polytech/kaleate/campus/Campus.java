package fr.unice.polytech.kaleate.campus;

import fr.unice.polytech.kaleate.Localisation;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.restaurant.ListeRestaurants;
import fr.unice.polytech.kaleate.restaurant.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class Campus {
    private String nom;
    private ListeRestaurants restaurantsPartenaires;
    private ListeUtilisateur listeDesUtilisateurs;

    private Localisation centre;
    private float rayon;

    public Campus(String n){
        nom=n;
        restaurantsPartenaires=new ListeRestaurants();
        listeDesUtilisateurs = new ListeUtilisateur();
    }

    public Campus(String n, Localisation l){
        nom=n;
        restaurantsPartenaires=new ListeRestaurants();
        listeDesUtilisateurs = new ListeUtilisateur();
        centre=l;
        rayon=0;
    }
    public ListeRestaurants listerRestaurants(){
        return restaurantsPartenaires;
    }

    public ListeUtilisateur getListeDesUtilisateurs() {
        return listeDesUtilisateurs;
    }

    public void ajoutRestaurant(Restaurant r){
        restaurantsPartenaires.add(r);
    }

    public void ajoutUtilisateur(Utilisateur u) {
        listeDesUtilisateurs.add(u);
    }

    public void retirerRestaurant(Restaurant r){
        restaurantsPartenaires.remove(r);
    }

    public void supprimerUtilisateur(Utilisateur u){
        listeDesUtilisateurs.remove(u);
    }

    public Map<Restaurant, ListeMenus> listerMenus(){
        Map<Restaurant, ListeMenus> m = new HashMap<>();
        for (Restaurant r : restaurantsPartenaires){
            m.put(r,r.getMenus());
        }
        return m;
    }

    public String getNom() {
        return nom;
    }

    public void setRayon(float rayon) {
        this.rayon = rayon;
    }

    public Localisation getCentre() {
        return centre;
    }

    public void setCentre(Localisation centre) {
        this.centre = centre;
    }

    public float getRayon() {
        return rayon;
    }
}
