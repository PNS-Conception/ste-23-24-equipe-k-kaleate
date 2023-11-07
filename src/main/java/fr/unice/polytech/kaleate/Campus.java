package fr.unice.polytech.kaleate;

import java.util.HashMap;
import java.util.Map;

public class Campus {
    private String nom;
    private ListeRestaurants restaurantsPartenaires;
    private ListeUtilisateur listeDesUtilisateurs;

    public Campus(String n){
        nom=n;
        restaurantsPartenaires=new ListeRestaurants();
        listeDesUtilisateurs = new ListeUtilisateur();
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

    public void supprimerUtilisateurr(Utilisateur u){
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
}
