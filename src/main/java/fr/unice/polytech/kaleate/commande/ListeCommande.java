package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.outils.Creneau;

import java.util.ArrayList;
import java.util.List;

public class ListeCommande extends ArrayList<CommandeSimple> {
    private static ListeCommande instance;
    public ListeCommande(){
        super();
    }

    public ListeCommande(ListeCommande listeCommandes){
        super(listeCommandes);
    }


    public CommandeSimple getCommandeById(int id){
        return this.stream().filter(commande -> commande.getId()==id).findFirst().orElse(null);
    }
    public List<CommandeSimple> getCommandeByCreneau(Creneau creneau){
        //TODO : A tester
        return this.stream().filter(commande -> commande.getMenus().stream().filter(menu -> menu.getCreneau().equals(creneau)).isParallel()).toList();
    }

    @Override
    public String toString() {
        String s = "Liste commande : ";

        for (CommandeSimple c : this) {
            s += c.toString() + "\n";
        }
        return s;
    }

    public static ListeCommande getInstanc() {
        if (instance == null) {
            instance = new ListeCommande();
        }
        return instance;
    }

}
