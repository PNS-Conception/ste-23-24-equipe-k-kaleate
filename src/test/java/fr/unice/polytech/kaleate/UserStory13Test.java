package fr.unice.polytech.kaleate;

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
    static ListCommande commandesPretes;
    static Restaurant restaurant1;
    static Restaurant restaurant2;
    static Commande commandeChoisie;


    //Generateur de menus
    public static List<Menu> getMenus(){
        List<Menu> menus = new ArrayList<Menu>();

        // date qui fonctionnent
        Date db = new Date();
        Date df = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.DATE, 1);
        df = c.getTime();

        menus.add(new Menu(10, "Burger cheese", new Creneau(db, df)));
        menus.add(new Menu(12, "Burger double cheese", new Creneau(db, df)));
        menus.add(new Menu(8, "Hamburger classic", new Creneau(db, df)));

        return menus;
    }

    public static void createRestaurants(){
        restaurant1 = new Restaurant("Burger King", new ListMenus(getMenus()));
        restaurant2 = new Restaurant("McDonalds", new ListMenus(getMenus()));
    }

    public static void createCommandes(){
        Utilisateur utilisateur1 = new Utilisateur("nom1", "prenom1");
        Menu menu1 = restaurant1.getMenus().get(0);
        Commande com1 = new Commande(utilisateur1, menu1, restaurant1);
        com1.setStatut(StatutCommande.VALIDEE);

        Utilisateur utilisateur2 = new Utilisateur("nom2", "prenom2");
        Menu menu2 = restaurant1.getMenus().get(1);
        Commande com2 = new Commande(utilisateur2, menu2, restaurant1);
        com2.setStatut(StatutCommande.EN_PREPARATION);

        Utilisateur utilisateur3 = new Utilisateur("nom3", "prenom3");
        Menu menu3 = restaurant1.getMenus().get(2);
        Commande com3 = new Commande(utilisateur3, menu3, restaurant1);
        com3.setStatut(StatutCommande.PRETE);

        ListCommande listCommandeR1 = new ListCommande();
        listCommandeR1.add(com1);
        listCommandeR1.add(com2);
        listCommandeR1.add(com3);

        restaurant1.setListCommande(listCommandeR1);

        Utilisateur utilisateur4 = new Utilisateur("nom4", "prenom4");
        Menu menu4 = restaurant2.getMenus().get(0);
        Commande com4 = new Commande(utilisateur4, menu4, restaurant2);
        com4.setStatut(StatutCommande.EN_CREATION);

        Utilisateur utilisateur5 = new Utilisateur("nom5", "prenom5");
        Menu menu5 = restaurant2.getMenus().get(1);
        Commande com5 = new Commande(utilisateur5, menu5, restaurant2);
        com5.setStatut(StatutCommande.PRETE);

        Utilisateur utilisateur6 = new Utilisateur("nom3", "prenom3");
        Menu menu6 = restaurant2.getMenus().get(2);
        Commande com6 = new Commande(utilisateur6, menu6, restaurant2);
        com6.setStatut(StatutCommande.PRETE);

        ListCommande listCommandeR2 = new ListCommande();
        listCommandeR2.add(com4);
        listCommandeR2.add(com5);
        listCommandeR2.add(com6);

        restaurant2.setListCommande(listCommandeR2);


    }

    public ListCommande getCommandesPretes(){
        createRestaurants();
        createCommandes();
        ListCommande commande = new ListCommande();
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
        System.out.println(commandesPretes.size());
        commandeChoisie = commandesPretes.get(int1 - 1);
        List<Menu> com = commandeChoisie.getMenus().stream().toList();
        Assertions.assertEquals("Burger double cheese", com.get(0).getName());
    }
}
