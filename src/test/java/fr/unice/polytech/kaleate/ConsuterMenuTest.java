package fr.unice.polytech.kaleate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class ConsuterMenuTest {
    @Given("je suis connecte avec mon compte etudiant")
    public void je_suis_connecte_avec_mon_compte_etudiant() {
        // Write code here that turns the phrase above into concrete actions
        
    }
    @When("j'ecris {string} dans le terminal")
    public void j_ecris_dans_le_terminal(String string) {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("je vois la liste des menus disponibles pour mon campus")
    public void je_vois_la_liste_des_menus_disponibles_pour_mon_campus() {
        // Write code here that turns the phrase above into concrete actions
    }


}
