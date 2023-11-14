package fr.unice.polytech.kaleate;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import java.util.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static org.junit.Assert.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")
public class UserStory7Test {
    static Utilisateur utilisateur= new Utilisateur("Ziad","Bouhlel");
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
    public void creerCommande(Utilisateur u1){
        u1.addMenu(getMenus().get(0));
        u1.addMenu(getMenus().get(1));
    }

    @Soit("Un utilisateur ayant une commande avec deux menus à l'intérieur")
    public void un_utilisateur_ayant_une_commande_avec_deux_menus_à_l_intérieur() {
        creerCommande(utilisateur);
        assertEquals(2,utilisateur.getCommandeActuel().getMenus().size());


    }
    @Quand("l'utilisateur a assez d'argent pour payer sa commande et décide de la payer")
    public void l_utilisateur_a_assez_d_argent_pour_payer_sa_commande_et_décide_de_la_payer() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Alors("La commande est payée et change de statut")
    public void la_commande_est_payée_et_change_de_statut() {
        // Write code here that turns the phrase above into concrete actions

    }
}