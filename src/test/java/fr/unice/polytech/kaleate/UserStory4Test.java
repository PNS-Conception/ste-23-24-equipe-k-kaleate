package fr.unice.polytech.kaleate;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")
public class UserStory4Test {

    static Utilisateur user = new Utilisateur("J'aime","Manger");
    static Livreur livreur = new Livreur("vroum","Le Tmax");
    static Commande commande;

    @Soit("un livreur et un utilisateur et une commande appartenant à l'utilisateur")
    public void un_livreur_et_un_utilisateur_et_une_commande_appartenant_à_l_utilisateur() {
        Menu menu = new Menu(10,"Menu du chef",new Creneau(new Date(),new Date()));
        Restaurant restaurant = new Restaurant("CHEFFF");
        commande = new Commande(user,menu,restaurant);
        user.setCommandeActuelle(commande);
        livreur.setCommande(commande);
        livreur.debuterLaCourse();
        assertEquals(StatutCommande.EN_ROUTE,commande.getStatut());

    }
    @Quand("Le livreur confirme qu'il est arrivé")
    public void le_livreur_confirme_qu_il_est_arrivé() {
        livreur.arriverADestination();
        assertEquals(StatutCommande.A_RECUPERER,commande.getStatut());
    }
    @Alors("le client valide qu'il a reçu la commande")
    public void le_client_valide_qu_il_a_reçu_la_commande() {
        // Write code here that turns the phrase above into concrete actions
       
    }
}
