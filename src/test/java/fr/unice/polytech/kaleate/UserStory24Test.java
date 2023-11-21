package fr.unice.polytech.kaleate;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.util.Date;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static org.junit.Assert.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")

public class UserStory24Test {
    static Utilisateur user;
    static Commande commande;
    static Restaurant restaurant = new Restaurant();
    public Menu creerMenu(){
        Menu m = new Menu(10,"menu",new Creneau(new Date(),new Date()));
        return m;

    }
    @Etantdonnéque("un utilisateur avec une commande")
    public void un_utilisateur_avec_une_commande() {
        user = new Utilisateur("nom","prenom");
        user.addMenu(creerMenu());
        assertNotNull(user.getCommandeActuelle());
        commande = user.getCommandeActuelle();
        commande.setId(2);

    }
    @Quand("il demande les informations de la commande")
    public void il_demande_les_informations_de_la_commande() throws CommandeException {
        assertThrows(CommandeException.class, () -> {
            int idCommande = user.getIdCommande();
        });
    }
    @Alors("il les récupère seulement s'il a payé sa commande")
    public void il_les_récupère_seulement_s_il_a_payé_sa_commande() throws CommandeException {
            user.payer();
            assertEquals(2,user.getIdCommande());
    }

}
