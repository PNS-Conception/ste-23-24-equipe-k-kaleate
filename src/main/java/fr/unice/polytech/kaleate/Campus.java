package fr.unice.polytech.kaleate;

public class Campus {
    private String nom;
    private ListRestaurants restaurantsPartenaires;

    public Campus(String n){
        nom=n;
        restaurantsPartenaires=new ListRestaurants();
    }

    public ListRestaurants listerRestaurants(){
        return restaurantsPartenaires;
    }

    public void ajoutRestaurant(Restaurant r){
        restaurantsPartenaires.add(r);
    }

    public void retirerRestaurant(Restaurant r){
        restaurantsPartenaires.remove(r);
    }
}
