package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.commande.CommandeSimple;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;

import java.util.Calendar;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        /*Utilisateur user = new Utilisateur("com","mande");
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(new Menu(1, "cov", new Creneau(new Date(), new Date())));
        menus.add(new Menu(2, "ide", new Creneau(new Date(), new Date())));
        menus.add(new Menu(3, "ad", new Creneau(new Date(), new Date())));
        Commande c = new Commande(user, menus, new Restaurant("rest"));
        c.valideeCommande();
        System.out.println(c.getStatut());
        menus.get(0).setStatutEnPreparation();
        System.out.println(c.getStatut());
        menus.get(0).setStatutPret();
        System.out.println(c.getStatut());
        menus.get(1).setStatutPret();
        System.out.println(c.getStatut());
        menus.get(2).setStatutPret();
        System.out.println(c.getStatut());*/

        Commande c = new CommandeSimple();

        ListeMenus menus = new ListeMenus();
        menus.add(new Menu(1, "cov", new Creneau(new Date(), new Date())));
        menus.add(new Menu(2, "ide", new Creneau(new Date(), new Date())));
        menus.add(new Menu(3, "ad", new Creneau(new Date(), new Date())));

        for (Menu m : menus) {
            c.addMenu(m);
        }

        c.valideeCommande();
        c.enregistrerCommande();

        System.out.println("commande " + c.getStatut());

        for (Menu m : menus) {
            System.out.println("menu " + m.getStatut());
            m.setStatutEnPreparation();
            System.out.println("menu " + m.getStatut());
            System.out.println("commande " + c.getStatut());
        }

        for(Menu m : menus){
            m.setStatutPret();
            System.out.println("menu " + m.getStatut());
            System.out.println("commande " + c.getStatut());
        }
    }
}
