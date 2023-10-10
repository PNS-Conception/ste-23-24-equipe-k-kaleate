package fr.unice.polytech.kaleate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")
public class UserStory1Test {

    @Given("je suis un utilisateur connecté")
    public void je_suis_connecte_avec_mon_compte_etudiant() {

    }

     @Given("je suis un utilisateur {string} {string} connecté du campus {string}")
    public void je_suis_un_utilisateur_campus(String name,String surname, String campus){

     }

     @Given("j'ai la liste des menus de l'ensemble des restaurants {string}")
     public void j_ai_la_liste_des_menus_du_campus(String campus){

     }

    @Given("j'ai ajouté le menu {string}")
    public void j_ai_ajoute_le_menu(String campus){

    }

    @Alors("je devrais voir la liste des menus de l'ensemble des restaurant {string}")
    public void je_devrais_voir_la_liste_des_menus_de_l_ensemble_des_restaurant(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

    @Quand("je saisie le menu {string}")
    public void je_saisie_le_menu(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Alors("Ma commande est crée avec le menu à l'interieur")
    public void ma_commande_est_crée_avec_le_menu_à_l_interieur() {
        // Write code here that turns the phrase above into concrete actions
    }


    @Quand("je valide ma commande")
    public void je_valide_ma_commande() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Alors("je vais être redirigé vers le paiement de ma commande")
    public void je_vais_être_redirigé_vers_le_paiement_de_ma_commande() {
        // Write code here that turns the phrase above into concrete actions

    }


}
