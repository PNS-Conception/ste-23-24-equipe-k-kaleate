package fr.unice.polytech.kaleate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

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

    static Utilisateur utilisateur;
    static ListMenus menus;
    static ListMenus menusDansCreneau;
    static Creneau creneau;

    @Given("je suis un utilisateur")
    public void je_suis_un_utilisateur() {
        // Write code here that turns the phrase above into concrete actions
        utilisateur = new Utilisateur("nom", "prenom");
    }

    @Given("je suis un utilisateur qui souhaite commander")
    public void je_suis_un_utilisateur_qui_souhaite_commander() {
        menus = new ListMenus(Menu.getMenus());
    }

    @Then("je precise le creneau de ma commande pour avoir la liste des menus disponibles")
    public void je_precise_le_creneau_de_ma_commande_pour_avoir_la_liste_des_menus_disponibles() {
        Date debut = new Date();
        Date fin = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(debut);
        calendar.add(Calendar.HOUR_OF_DAY, 2);

        creneau = new Creneau(debut, fin);
        menusDansCreneau = menus.getMenusDansCreneau(creneau);
        assertTrue(menusDansCreneau.size() == 3);
        assertTrue(menusDansCreneau.contains(menus.get(0)));
        assertFalse(menusDansCreneau.contains(menus.get(3)));
    }

    @Given("je suis un utilisateur qui souhaite commander dans la liste des menus disponibles pour le creneau")
    public void je_suis_un_utilisateur_qui_souhaite_commander_dans_la_liste_des_menus_disponibles_pour_le_creneau() {
        //TODO jsp quoi y mettre
    }

    @Then("je selectionne le menu {string}")
    public void je_selectionne_le_menu(String string) {
        Menu menu = menusDansCreneau.getMenuParNom(string);
        Menu m = menus.get(0);
        assertEquals(menu, menusDansCreneau.getMenuParNom(string));
    }
}
