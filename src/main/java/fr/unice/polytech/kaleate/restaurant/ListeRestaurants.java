package fr.unice.polytech.kaleate.restaurant;

import fr.unice.polytech.kaleate.commande.Commandable;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.outils.Listeur;

import java.util.ArrayList;
import java.util.List;

public class ListeRestaurants extends ArrayList<Restaurant> implements Listeur {

    public ListeRestaurants(){
        super();
    }

    public ListeRestaurants(ListeRestaurants listRestaurants){
        super(listRestaurants);
    }

    @Override
    public List<Commandable> getMenusDansCreneau(Creneau creneau, Class typeMenu){
        List listeMenu = new ArrayList<Menu>();
        for (Restaurant restaurant : this){
            listeMenu.addAll(restaurant.getMenusDansCreneau(creneau, typeMenu));
        }
        return listeMenu;
    }

    @Override
    public List<Commandable> getAllMenus(Class typeMenu){
        List listeMenu = new ArrayList();
        for (Restaurant restaurant : this){
            listeMenu.addAll(restaurant.getMenus(typeMenu));
        }
        return listeMenu;
    }

    public Restaurant getParNom(String name){
        return this.stream().filter(restaurant -> restaurant.getName().equals(name)).findFirst().orElse(null);
    }
}
