package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class ListRestaurants extends ArrayList<Restaurant> {

    public ListRestaurants(){
        super();
    }

    public ListRestaurants(ListRestaurants listRestaurants){
        super(listRestaurants);
    }

    public ListMenus getMenusDansCreneau(Creneau creneau){
        ListMenus listMenu = new ListMenus();
        for (Restaurant restaurant : this){
            listMenu.addAll(restaurant.getMenusDansCreneau(creneau));
        }
        return listMenu;
    }

    public ListMenus getAllMenus(){
        ListMenus listMenu = new ListMenus();
        for (Restaurant restaurant : this){
            listMenu.addAll(restaurant.getMenus());
        }
        return listMenu;
    }

    public Restaurant getRestaurantByName(String name){
        return this.stream().filter(restaurant -> restaurant.getName().equals(name)).findFirst().orElse(null);
    }
}
