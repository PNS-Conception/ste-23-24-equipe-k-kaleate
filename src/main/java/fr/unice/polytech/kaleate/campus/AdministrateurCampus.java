package fr.unice.polytech.kaleate.campus;

import fr.unice.polytech.kaleate.restaurant.ListeRestaurants;
import fr.unice.polytech.kaleate.restaurant.RestauPartFacto;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import fr.unice.polytech.kaleate.restaurant.RestaurantFactory;

public class AdministrateurCampus {
    private Campus campus;

    /**
     * Associe un Administrateur campus à un nouveau campus appelé campusnom
     * @param campusnom
     */
    public AdministrateurCampus(String campusnom){
        campus=new Campus(campusnom);
    }

    /**
     * Associe un Administrateur campus au campus c
     * @param c
     */
    public AdministrateurCampus(Campus c){
        campus=c;
    }

    public ListeRestaurants listerRestaurants(){
        return campus.listerRestaurants();
    }

    public ListeUtilisateur listeUtilisateur(){
        return campus.getListeDesUtilisateurs();
    }

    /**
     * L'administrateur rajoute un nouveau restaurant partenaire
     * @param nom
     */
    public void ajouterRestaurant(String nom){
        RestaurantFactory r = new RestauPartFacto();
        r.nouveauRestau(nom,campus);
    }

    public void ajouterUtilisateur(String nom, String prenom){
        Utilisateur newUtilisateur = new Utilisateur(nom, prenom);
        campus.ajoutUtilisateur(newUtilisateur);
    }

    public void supprimerUtilisateur(String nom){
        Utilisateur utilisateur = listeUtilisateur().getParNom(nom);
        campus.supprimerUtilisateur(utilisateur);
    }

  /**
     * L'administarteur ajoute le restaurant nom au campus
     * @param nom
     * @return boolean
     */
    public boolean ajouterRestaurant(Restaurant nom){
        if (campus.getCentre().estDansLeRayonDe(nom.getLocalisation(), campus.getRayon())) {
            campus.ajoutRestaurant(nom);
            return true;
        }
        return false;
    }

    public void ajouterUtilisateur(Utilisateur utilisateur){
        campus.ajoutUtilisateur(utilisateur);
    }

    public void changerRayon(float r){
        campus.setRayon(r);
    }

    public Campus getCampus() {
        return campus;
    }

    public double getNoteUtilisateur(Utilisateur utilisateur) {
        for (Utilisateur u : getCampus().getListeDesUtilisateurs()){
            if (utilisateur.equals(u))
                return utilisateur.getNote();
        }
        throw new RuntimeException(utilisateur.toString()+" n\' est pas inscrit dans la liste des utilisateurs");
    }
}
