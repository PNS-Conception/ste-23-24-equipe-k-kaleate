package fr.unice.polytech.kaleate;

import java.util.ArrayList;

public class ListCommande extends ArrayList<Commande> {
    public ListCommande(){
        super();
    }

    public ListCommande(ListCommande listCommandes){
        super(listCommandes);
    }


    public Commande getCommandeById(int id){
        return this.stream().filter(commande -> commande.getId()==id).findFirst().orElse(null);
    }
    public ListCommande getCommandeByCreneau(Creneau creneau){
        //TODO : A tester
        return this.stream().filter(commande -> commande.getMenus().stream().filter(menu -> menu.getCreneau().equals(creneau)).isParallel();
    }
}
