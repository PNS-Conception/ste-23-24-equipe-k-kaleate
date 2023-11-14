package fr.unice.polytech.kaleate;

public class AdministrateurCampus {
    private Campus campus;

    public AdministrateurCampus(String campusnom){
        campus=new Campus(campusnom);
    }
    public AdministrateurCampus(Campus c){
        campus=c;
    }

    public ListeRestaurants listerRestaurants(){
        return campus.listerRestaurants();
    }

    public ListeUtilisateur listeUtilisateur(){
        return campus.getListeDesUtilisateurs();
    }

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

    public void ajouterRestaurant(Restaurant nom){
        campus.ajoutRestaurant(nom);
    }

    public void ajouterUtilisateur(Utilisateur utilisateur){
        campus.ajoutUtilisateur(utilisateur);
    }
}
