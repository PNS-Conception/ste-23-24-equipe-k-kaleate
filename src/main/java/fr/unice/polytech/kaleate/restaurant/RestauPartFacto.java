package fr.unice.polytech.kaleate.restaurant;

import fr.unice.polytech.kaleate.campus.Campus;

public class RestauPartFacto implements RestaurantFactory{
    @Override
    public Restaurant nouveauRestau(String name, Campus campus) {
        Restaurant r = new Restaurant(name);
        campus.ajoutRestaurant(r);
        return r;
    }
}
