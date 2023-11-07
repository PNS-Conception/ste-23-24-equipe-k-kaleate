package fr.unice.polytech.kaleate;

import java.util.ArrayList;
import java.util.List;

public class ListeRestaurants extends ArrayList<Restaurant> implements Listeur{

    public ListeRestaurants(){
        super();
    }

    public ListeRestaurants(ListeRestaurants listRestaurants){
        super(listRestaurants);
    }

    public List<Menu> getMenusDansCreneau(Creneau creneau){
        List listMenu = new ArrayList<Menu>();
        for (Restaurant restaurant : this){
            listMenu.addAll(restaurant.getMenusDansCreneau(creneau));
        }
        return listMenu;
    }
    public List<Menu> getAllMenus(){
        List listMenu = new ArrayList();
        for (Restaurant restaurant : this){
            listMenu.addAll(restaurant.getMenus());
        }
        return listMenu;
    }

    public Restaurant getParNom(String name){
        return this.stream().filter(restaurant -> restaurant.getName().equals(name)).findFirst().orElse(null);
    }
}
