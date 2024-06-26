package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.Commandable;

import fr.unice.polytech.kaleate.commande.CommandeSimple;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.ListeRestaurants;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static org.junit.Assert.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")
public class UserStory1Test {

    static ListeRestaurants restaurants;
    static Utilisateur utilisateur;
    static List<Commandable> menus;
    static List<Commandable> menusDansCreneau;
    static Creneau creneau;
    static Restaurant restau;
    static Commandable menuChoisi;


    static Commandable m1, m2, m3, m4, m5, m6;
    static Restaurant r1, r2;


    //Generateur de menus
    public static void getMenus(){

        // date qui fonctionnent
        Date db = new Date();
        Date df = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.DATE, 1);
        df = c.getTime();

        m1 = new Menu(10, "Burger cheese", new Creneau(db, df));
        m2 = new Menu(12, "Burger double cheese", new Creneau(db, df));
        m3 = new Menu(8, "Hamburger classic", new Creneau(db, df));


        // date qui ne fonctionnent pas
        Date dnb = new Date();
        Date dnf = new Date();

        Calendar c2 = Calendar.getInstance();
        c2.setTime(dnf);
        c2.add(Calendar.DATE, 2);
        dnb = c2.getTime();
        c2.add(Calendar.DATE, 1);
        dnf = c2.getTime();

        m4 = new Menu(10, "NOT Burger cheese", new Creneau(dnb, dnf));
        m5 = new Menu(12, "NOT Burger double cheese", new Creneau(dnb, dnf));
        m6 = new Menu(8, "NOT Hamburger classic", new Creneau(dnb, dnf));

    }

    public static ListeRestaurants getRestaurants(){
        ListeRestaurants restaurants = new ListeRestaurants();
        r1 = new Restaurant("Burger King");
        r2 = new Restaurant("Not Burger King");
        getMenus();
        r1.ajouterMenu(m1);
        r1.ajouterMenu(m2);
        r1.ajouterMenu(m3);
        r1.ajouterMenu(m4);
        r1.ajouterMenu(m5);
        r1.ajouterMenu(m6);
        r2.ajouterMenu(m1);
        r2.ajouterMenu(m2);
        r2.ajouterMenu(m3);
        r2.ajouterMenu(m4);
        r2.ajouterMenu(m5);
        r2.ajouterMenu(m6);

        restaurants.add(r1);
        restaurants.add(r2);
        return restaurants;
    }


    @Etantdonnéque("je suis un utilisateur")
    public void je_suis_un_utilisateur() {
        // Write code here that turns the phrase above into concrete actions
        utilisateur = new Utilisateur("nom", "prenom");
        assertNotNull(utilisateur);
    }

    @Etantdonnéque("je suis un utilisateur qui souhaite commander")
    public void je_suis_un_utilisateur_qui_souhaite_commander() {
        restaurants = getRestaurants();
        assertNotEquals(0, restaurants.size());
    }

    @Alors("je precise le creneau de ma commande pour avoir la liste des menus disponibles")
    public void je_precise_le_creneau_de_ma_commande_pour_avoir_la_liste_des_menus_disponibles() {
        Date debut = new Date();
        Date fin = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(debut);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        debut = calendar.getTime();
        calendar.set(Calendar.MINUTE, 15);
        fin = calendar.getTime();

        creneau = new Creneau(debut, fin);
        menusDansCreneau = restaurants.getMenusDansCreneau(creneau, utilisateur.getTypeMenu());
        assertEquals(6,menusDansCreneau.size());
        assertTrue(menusDansCreneau.contains(restaurants.getParNom("Burger King").getMenus(Commandable.class).get(0)));
        assertTrue(menusDansCreneau.contains(restaurants.getParNom("Burger King").getMenus(Commandable.class).get(0)));
        assertTrue(menusDansCreneau.contains(restaurants.getParNom("Burger King").getMenus(Commandable.class).get(1)));
        assertTrue(menusDansCreneau.contains(restaurants.getParNom("Burger King").getMenus(Commandable.class).get(1)));
        assertTrue(menusDansCreneau.contains(restaurants.getParNom("Burger King").getMenus(Commandable.class).get(2)));
        assertTrue(menusDansCreneau.contains(restaurants.getParNom("Burger King").getMenus(Commandable.class).get(2)));
        assertFalse(menusDansCreneau.contains(restaurants.getParNom("Burger King").getMenus(Commandable.class).get(3)));
    }

    @Etantdonnéque("je suis un utilisateur qui souhaite commander dans la liste des menus disponibles pour le creneau")
    public void je_suis_un_utilisateur_qui_souhaite_commander_dans_la_liste_des_menus_disponibles_pour_le_creneau() {
        menus = new ListeRestaurants(restaurants).getMenusDansCreneau(creneau, utilisateur.getTypeMenu());
        assertNotEquals(0, menus.size());
    }

    @Etantdonnéque("je suis un utilisateur qui souhaite commander dans la liste des menus du restaurant {string}")
    public void je_suis_un_utilisateur_qui_souhaite_commander_dans_la_liste_des_menus_du_restaurant(String string) {

        restau = restaurants.getParNom(string);
        menus = restaurants.getParNom(string).getMenus(Commandable.class);
        assertNotEquals(menus.size(),0);
    }

    @Alors("je selectionne le menu {string}")
    public void je_selectionne_le_menu(String string) {
        Commandable menu = new ListeMenus(menus).getParNom(string);
        menuChoisi = new ListeMenus(menus).get(0);
        assertEquals(menu, new ListeMenus(menusDansCreneau).getParNom(string));
        assertEquals(menuChoisi,menu);
    }

    @Alors("je crée une commande avec le menu {string}")
    public void je_crée_une_commande_avec_le_menu(String string) {
        assertEquals(menuChoisi.getName(), string);
        CommandeSimple commande = new CommandeSimple(utilisateur);
        commande.addMenu(menuChoisi);
        assertTrue(commande.contains(menuChoisi));
    }
}
