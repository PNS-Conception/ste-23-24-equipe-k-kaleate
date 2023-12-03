package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.AdministrateurCampus;
import fr.unice.polytech.kaleate.campus.Campus;
import fr.unice.polytech.kaleate.campus.Localisation;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static org.junit.Assert.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")

public class UserStory12Test {

    static AdministrateurCampus ac;

    @Soit("Je suis un administrateur campus")
    public void je_suis_un_administrateur_campus() {
        ac=new AdministrateurCampus(new Campus("Sophia_tech",new Localisation(0,0)));
        assertNotNull(ac);
    }

    @Quand("J'augmente le rayon autour du campus")
    public void j_augmente_le_rayon_autour_du_campus() {
        assertEquals(0,ac.getCampus().getRayon(),0.0);
        ac.changerRayon(15);
        assertNotEquals(0,ac.getCampus().getRayon(),0.0);

    }
    @Alors("je peux accepter plus de restaurants")
    public void je_peux_accepter_plus_de_restaurants() {
        Restaurant r1 = new Restaurant("peperoni",new ListeMenus(),new Localisation(20,0));
        assertFalse(ac.ajouterRestaurant(r1));
        ac.changerRayon(30);
        assertTrue(ac.ajouterRestaurant(r1));
    }

}
