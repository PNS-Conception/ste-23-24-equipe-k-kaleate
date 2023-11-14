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
        List listeMenu = new ArrayList<Menu>();
        for (Restaurant restaurant : this){
            listeMenu.addAll(restaurant.getMenusDansCreneau(creneau));
        }
        return listeMenu;
    }
    public List<Menu> getAllMenus(){
        List listeMenu = new ArrayList();
        for (Restaurant restaurant : this){
            listeMenu.addAll(restaurant.getMenus());
        }
        return listeMenu;
    }

    public Restaurant getParNom(String name){
        return this.stream().filter(restaurant -> restaurant.getName().equals(name)).findFirst().orElse(null);
    }
}
