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

import java.util.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static org.junit.Assert.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")

public class UserStory2Test {

   static Restaurant restaurant = new Restaurant();
    static Commande commandeSelectionnee;

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


        // date qui ne fonctionnent pas
        Date dnb = new Date();
        Date dnf = new Date();

        Calendar c2 = Calendar.getInstance();
        c2.setTime(dnf);
        c2.add(Calendar.DATE, 2);
        dnb = c2.getTime();
        c2.add(Calendar.DATE, 1);
        dnf = c2.getTime();

        menus.add(new Menu(10, "NOT Burger cheese", new Creneau(dnb, dnf)));
        menus.add(new Menu(12, "NOT Burger double cheese", new Creneau(dnb, dnf)));
        menus.add(new Menu(8, "NOT Hamburger classic", new Creneau(dnb, dnf)));
        return menus;
    }
    public static ListCommande getCommandes(){
        Utilisateur utilisateur = new Utilisateur("Nom","Prenom");
        ListCommande listCommande = new ListCommande();
        for(Menu m : getMenus()){
            listCommande.add(new Commande(utilisateur,m));
        }
        return listCommande;
    }
    @Etantdonnéque("Je suis un restaurateur qui travaille à {string}")
    public void je_suis_un_restaurateur_qui_travaille_à(String string) {
         restaurant = new Restaurant(string);
         restaurant.setListCommande(getCommandes());
        assertNotNull(restaurant);

    }

    @Alors("Je demande à voir la liste des commandes passées dans mon restaurant")
    public void je_demande_à_voir_la_liste_des_commandes_passées_dans_mon_restaurant() {
        assertNotEquals(restaurant.getListCommande().size(),0);
        assertNotNull(restaurant.getListCommande().get(0).getPrice());
        assertNotNull(restaurant.getListCommande().get(0).getMenus());
    }

    @Etantdonnéque("J'ai la liste des commandes passées dans mon restaurant")
    public void j_ai_la_liste_des_commandes_passées_dans_mon_restaurant() {
        // je ne sais pas quoi coder la

    }
    @Quand("je sélectionne la première commande")
    public void je_sélectionne_la_première_commande() {

        commandeSelectionnee = restaurant.getListCommande().get(0);


    }
    @Alors("je vois toutes les informations de la commande")
    public void je_vois_toutes_les_informations_de_la_commande() {
        assertNotNull(commandeSelectionnee.getPrice());
        assertNotNull(commandeSelectionnee.getMenus());
        assertNotNull(commandeSelectionnee.getUtilisateur());
        assertNotNull(commandeSelectionnee.getId());
    }

    @Etantdonnéque("Le restaurant peut préparer la commande")
    public void le_restaurant_peut_préparer_la_commande() {
        //TODO : intégrer les capacités aux restaurant pour vérifier ca.

    }
    @Alors("Le restaurant valide la prise en charge de la commande")
    public void le_restaurant_valide_la_prise_en_charge_de_la_commande() {
        // Write code here that turns the phrase above into concrete actions
        restaurant.validerCommande(commandeSelectionnee);
        assertEquals(commandeSelectionnee.getStatut(),StatutCommande.VALIDEE);
    }

    @Etantdonnéque("La commande doit être commmencée à être préparée pour être livrée à temps")
    public void la_commande_doit_être_commmencée_à_être_préparée_pour_être_livrée_à_temps() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Quand("Je sélectionne la commande pour la mettre en préparation")
    public void je_sélectionne_la_commande_pour_la_mettre_en_préparation() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Alors("La commande ne peut plus être modifié par le client")
    public void la_commande_ne_peut_plus_être_modifié_par_le_client() {
        // Write code here that turns the phrase above into concrete actions

    }

}
