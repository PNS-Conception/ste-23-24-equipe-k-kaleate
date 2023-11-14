package fr.unice.polytech.kaleate;

public class RestauPartFacto implements RestaurantFactory{
    @Override
    public Restaurant nouveauRestau(String name, Campus campus) {
        Restaurant r = new Restaurant(name);
        campus.ajoutRestaurant(r);
        return r;
    }
}
