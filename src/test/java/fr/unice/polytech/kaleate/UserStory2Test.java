package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.commande.CommandeSimple;
import fr.unice.polytech.kaleate.commande.ListeCommande;
import fr.unice.polytech.kaleate.commande.StatutCommande;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
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

        menus.add(new Menu(10, "Burger cheese", new Creneau(db, df),restaurant));
        menus.add(new Menu(12, "Burger double cheese", new Creneau(db, df),restaurant));
        menus.add(new Menu(8, "Hamburger classic", new Creneau(db, df),restaurant));


        // date qui ne fonctionnent pas
        Date dnb = new Date();
        Date dnf = new Date();

        Calendar c2 = Calendar.getInstance();
        c2.setTime(dnf);
        c2.add(Calendar.DATE, 2);
        dnb = c2.getTime();
        c2.add(Calendar.DATE, 1);
        dnf = c2.getTime();

        menus.add(new Menu(10, "NOT Burger cheese", new Creneau(dnb, dnf),restaurant));
        menus.add(new Menu(12, "NOT Burger double cheese", new Creneau(dnb, dnf),restaurant));
        menus.add(new Menu(8, "NOT Hamburger classic", new Creneau(dnb, dnf),restaurant));
        return menus;
    }

    // TODO : Changer la façon de construire les commandes dans les restaurants : les commmandes sont crées à partir d'un restaurant et non l'inverse

    public static ListeCommande getCommandes(){
        Utilisateur utilisateur = new Utilisateur("Nom","Prenom");

        Date debut = new Date();
        Date fin = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(debut);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        debut = calendar.getTime();
        calendar.set(Calendar.MINUTE, 15);
        fin = calendar.getTime();

        Creneau creneau = new Creneau(debut, fin);


        ListeCommande listeCommande = new ListeCommande();
        for(Menu m : getMenus()){
            Commande commande = new CommandeSimple(utilisateur, creneau);
            commande.addMenu(m);
            listeCommande.add(commande);
        }
        return listeCommande;
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
        assertNotNull(restaurant);
        assertNotNull(restaurant.getListCommande());
        assertNotNull(restaurant.getListCommande().get(0));
        assertNotEquals(0.0, restaurant.getListCommande().get(0).getPrix());
        assertNotNull(restaurant.getListCommande().get(0).getMenus());
    }

    @Etantdonnéque("J'ai la liste des commandes passées dans mon restaurant")
    public void j_ai_la_liste_des_commandes_passées_dans_mon_restaurant() {


    }
    @Quand("je sélectionne la première commande")
    public void je_sélectionne_la_première_commande() {

        commandeSelectionnee = restaurant.getListCommande().get(0);


    }
    @Alors("je vois toutes les informations de la commande")
    public void je_vois_toutes_les_informations_de_la_commande() {
        assertNotNull(commandeSelectionnee);
        assertNotEquals(0.0, commandeSelectionnee.getPrix());
        assertNotNull(commandeSelectionnee.getMenus());
        assertNotNull(commandeSelectionnee.getUtilisateurEmetteur());
        assertNotEquals(0, commandeSelectionnee.getId());
    }

    @Etantdonnéque("Le restaurant peut préparer la commande")
    public void le_restaurant_peut_préparer_la_commande() {
        //TODO : intégrer les capacités aux restaurant pour vérifier ca.

    }
    @Alors("Le restaurant valide la prise en charge de la commande")
    public void le_restaurant_valide_la_prise_en_charge_de_la_commande() {

        assertTrue(restaurant.validerCommande(commandeSelectionnee));
        assertEquals(StatutCommande.VALIDEE, commandeSelectionnee.getStatut());
    }

    @Etantdonnéque("La commande doit être commmencée à être préparée pour être livrée à temps")
    public void la_commande_doit_être_commmencée_à_être_préparée_pour_être_livrée_à_temps() {
        commandeSelectionnee.getMenus().stream().toList().get(0).setTempsPreparation(10);
        Date dateTOT = new Date();
        Date dateTARD = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTOT);
        calendar.set(Calendar.HOUR, 11);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        dateTOT = calendar.getTime();
        //trop tot pour commencer à préparer
        assertFalse(restaurant.doitEtrePreparee(commandeSelectionnee,dateTOT));
        calendar.set(Calendar.MINUTE, 90);
        dateTARD = calendar.getTime();
        //trop tard/à l'heure pour commencer à préparer
        assertTrue(restaurant.doitEtrePreparee(commandeSelectionnee,dateTARD));
    }
    @Quand("Je sélectionne la commande pour la mettre en préparation")
    public void je_sélectionne_la_commande_pour_la_mettre_en_préparation() {
        assertTrue(restaurant.preparerCommande(commandeSelectionnee));
        assertFalse(restaurant.preparerCommande(getCommandes().get(2)));
    }
    @Alors("La commande ne peut plus être modifié par le client")
    public void la_commande_ne_peut_plus_être_modifié_par_le_client() {
        Date db = new Date();
        Date df = new Date();

        assertFalse(commandeSelectionnee.addMenu(new Menu(12, "NOT Burger double cheese", new Creneau(db, df))));
        assertFalse(commandeSelectionnee.removeMenu(commandeSelectionnee.getMenus().stream().toList().get(0)));
    }

}