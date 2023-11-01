package fr.unice.polytech.kaleate;

import java.util.ArrayList;
import java.util.List;

public class ListCommande extends ArrayList<Commande> {
    private static ListCommande instance;
    public ListCommande(){
        super();
    }

    public ListCommande(ListCommande listCommandes){
        super(listCommandes);
    }


    public Commande getCommandeById(int id){
        return this.stream().filter(commande -> commande.getId()==id).findFirst().orElse(null);
    }
    public List<Commande> getCommandeByCreneau(Creneau creneau){
        //TODO : A tester
        return this.stream().filter(commande -> commande.getMenus().stream().filter(menu -> menu.getCreneau().equals(creneau)).isParallel()).toList();
    }

    @Override
    public String toString() {
        return "ListCommande{" +
                "modCount=" + modCount +
                '}';
    }

    public static ListCommande getInstance() {
        if (instance == null) {
            instance = new ListCommande();
        }
        return instance;
    }
}
