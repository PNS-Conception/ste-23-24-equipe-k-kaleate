package fr.unice.polytech.kaleate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
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

public class UserStory2Test {

    @Etantdonnéque("Je suis un restaurateur qui travaille à {string}")
    public void je_suis_un_restaurateur_qui_travaille_à(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Quand("J'ecris {string} dans le terminal")
    public void j_ecris_dans_le_terminal(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Alors("Je vois la liste des commandes passées dans mon restaurant")
    public void je_vois_la_liste_des_commandes_passées_dans_mon_restaurant() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Etantdonnéque("J'ai la liste des commandes passées dans mon restaurant")
    public void j_ai_la_liste_des_commandes_passées_dans_mon_restaurant() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Quand("je sélectionne la première commande")
    public void je_sélectionne_la_première_commande() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Alors("je vois toutes les informations de la commande")
    public void je_vois_toutes_les_informations_de_la_commande() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Etantdonnéque("La commande doit être commmencée à être préparée pour être livrée à temps")
    public void la_commande_doit_être_commmencée_à_être_préparée_pour_être_livrée_à_temps() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Quand("J'ecris {string} et {string} qui correspond au numéro de la commande")
    public void j_ecris_et_qui_correspond_au_numéro_de_la_commande(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Alors("La commande ne peut plus être modifié par le client")
    public void la_commande_ne_peut_plus_être_modifié_par_le_client() {
        // Write code here that turns the phrase above into concrete actions

    }

}
