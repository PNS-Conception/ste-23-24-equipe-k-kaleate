package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ListeCommande extends ArrayList<Commande> implements Observer {
    private static ListeCommande instance;
    public ListeCommande(){
        super();
    }

    public ListeCommande(ListeCommande listeCommandes){
        super(listeCommandes);
    }


    public Commande getCommandeById(int id){
        return this.stream().filter(commande -> commande.getId()==id).findFirst().orElse(null);
    }
    public List<Commande> getCommandeByRestaurant(Restaurant restaurant){
        return this.stream().filter(commande -> commande.getRestaurants().contains(restaurant)).toList();
    }
    public List<Commande> getCommandeByCreneau(Creneau creneau){
        //TODO : A tester
        return this.stream().filter(commande -> commande.getMenus().stream().filter(menu -> menu.getCreneau().equals(creneau)).isParallel()).toList();
    }

    @Override
    public String toString() {
        String s = "Liste commande : ";

        for (Commande c : this) {
            s += c.toString() + "\n";
        }
        return s;
    }

    public static ListeCommande getInstance() {
        if (instance == null) {
            instance = new ListeCommande();
        }
        return instance;
    }
    public static void reset(){
        instance = new ListeCommande();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
