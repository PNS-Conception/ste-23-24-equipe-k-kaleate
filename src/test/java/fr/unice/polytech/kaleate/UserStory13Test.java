package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.*;
import fr.unice.polytech.kaleate.livrable.Livreur;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.util.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")

public class UserStory13Test {
    static Livreur livreur;
    static ListeCommande commandesPretes;
    static Restaurant restaurant1;
    static Restaurant restaurant2;
    static Commande commandeChoisie;


    //Generateur de menus
    public static ListeMenus getMenus(Restaurant restaurant){
        ListeMenus menus = new ListeMenus();

        // date qui fonctionnent
        Date db = new Date();
        Date df = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.DATE, 1);
        df = c.getTime();

        Menu menu1 = new Menu(10, "Burger cheese", new Creneau(db, df));
        menu1.setRestaurant(restaurant);
        Menu menu2 = new Menu(12, "Burger double cheese", new Creneau(db, df));
        menu2.setRestaurant(restaurant);
        Menu menu3 = new Menu(8, "Hamburger classic", new Creneau(db, df));
        menu3.setRestaurant(restaurant);


        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);

        return menus;
    }

    public static void createRestaurants(){
        restaurant1 = new Restaurant("Burger King");
        restaurant1.setMenus(getMenus(restaurant1));
        restaurant2 = new Restaurant("McDonalds");
        restaurant2.setMenus(getMenus(restaurant2));
    }

    public static void createCommandes(){
        Utilisateur utilisateur1 = new Utilisateur("nom1", "prenom1");
        Commandable menu1 = restaurant1.getMenus(Commandable.class).get(0);
        CommandeSimple com1 = new CommandeSimple(utilisateur1);
        com1.addMenu(menu1);
        com1.setStatut(StatutCommande.VALIDEE);

        Utilisateur utilisateur2 = new Utilisateur("nom2", "prenom2");
        Commandable menu2 = restaurant1.getMenus(Commandable.class).get(0);
        CommandeSimple com2 = new CommandeSimple(utilisateur2);
        com2.addMenu(menu2);
        com2.setStatut(StatutCommande.EN_PREPARATION);

        Utilisateur utilisateur3 = new Utilisateur("nom3", "prenom3");
        Commandable menu3 = restaurant1.getMenus(Commandable.class).get(0);
        CommandeSimple com3 = new CommandeSimple(utilisateur3);
        com3.addMenu(menu3);
        com3.setStatut(StatutCommande.PRETE);

        ListeCommande listeCommandeR1 = new ListeCommande();
        listeCommandeR1.add(com1);
        listeCommandeR1.add(com2);
        listeCommandeR1.add(com3);

        restaurant1.setListCommande(listeCommandeR1);

        Utilisateur utilisateur4 = new Utilisateur("nom4", "prenom4");
        Commandable menu4 = restaurant2.getMenus(Commandable.class).get(0);
        CommandeSimple com4 = new CommandeSimple(utilisateur4);
        com4.addMenu(menu4);
        com4.setStatut(StatutCommande.EN_CREATION);

        Utilisateur utilisateur5 = new Utilisateur("nom5", "prenom5");
        Commandable menu5 = restaurant2.getMenus(Commandable.class).get(0);
        CommandeSimple com5 = new CommandeSimple(utilisateur5);
        com5.addMenu(menu5);
        com5.setStatut(StatutCommande.PRETE);

        Utilisateur utilisateur6 = new Utilisateur("nom3", "prenom3");
        Commandable menu6 = restaurant2.getMenus(Commandable.class).get(0);
        CommandeSimple com6 = new CommandeSimple(utilisateur6);
        com6.addMenu(menu6);
        com6.setStatut(StatutCommande.PRETE);

        ListeCommande listeCommandeR2 = new ListeCommande();
        listeCommandeR2.add(com4);
        listeCommandeR2.add(com5);
        listeCommandeR2.add(com6);

        restaurant2.setListCommande(listeCommandeR2);


    }

    public ListeCommande getCommandesPretes(){
        createRestaurants();
        createCommandes();
        ListeCommande commande = new ListeCommande();
        commande.addAll(restaurant1.getCommandePrete());
        commande.addAll(restaurant2.getCommandePrete());
        return commande;
    }



    @Etantdonnéque("Je suis un livreur")
    public void je_suis_un_livreur() {
        livreur = new Livreur("je", "livre");
        Assertions.assertNotNull(livreur);
    }

    @Quand("Je demande a voir la liste des commandes")
    public void je_demande_a_voir_la_liste_des_commandes() {
        commandesPretes = getCommandesPretes();
        Assertions.assertEquals(3,commandesPretes.size());
    }

    @Alors("je selectionne la commande numero {int}")
    public void je_selectionne_la_commande_numero(Integer int1) {
        commandeChoisie = commandesPretes.get(int1 - 1);
        List<Commandable> com = commandeChoisie.getMenus().stream().toList();
        Assertions.assertEquals("Burger double cheese", com.get(0).getName());
    }
}
