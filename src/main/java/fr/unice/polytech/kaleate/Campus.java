package fr.unice.polytech.kaleate;

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
}
