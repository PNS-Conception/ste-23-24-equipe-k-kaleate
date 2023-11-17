package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.AdministrateurCampus;
import fr.unice.polytech.kaleate.restaurant.ListeRestaurants;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")

public class UserStory8Test {

    static AdministrateurCampus ac;
    static ListeRestaurants l;

    @Soit("Je suis l'administrateur du campus {string}")
    public void je_suis_l_administrateur_du_campus(String string) {
        ac=new AdministrateurCampus(string);
        assertNotNull(ac);
    }
    @Quand("Je demande l'ensemble des restaurants partenaires de mon campus")
    public void je_demande_l_ensemble_des_restaurants_partenaires_de_mon_campus() {
        l = ac.listerRestaurants();
    }
    @Alors("J'obtiens la liste des restaurants partenaires du Campus {string}")
    public void j_obtiens_la_liste_des_restaurants_partenaires_du_campus(String string) {
        assertEquals(l,new ListeRestaurants());
    }

    @Quand("J'ajoute le restaurant {string}")
    public void j_ajoute_le_restaurant(String string) {
        ac.ajouterRestaurant(string);
    }

    @Etantdonnéque("le nombre de restaurants du campus est de {int}")
    public void le_nombre_de_restaurants_du_campus_est_de(int int1) {
        assertEquals(ac.listerRestaurants().size(),int1);
    }
    @Alors("le nombre de restaurants augmente de {int}")
    public void le_nombre_de_restaurant_change(int i) {
        assertEquals(l.size()+i,ac.listerRestaurants().size());
    }

}
