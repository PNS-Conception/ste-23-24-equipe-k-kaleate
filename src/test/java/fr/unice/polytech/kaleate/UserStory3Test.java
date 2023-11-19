package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.CommandeSimple;
import fr.unice.polytech.kaleate.commande.CommandeGroupee;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.fr.*;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static org.junit.Assert.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")

public class UserStory3Test {
    static Utilisateur userA = new Utilisateur("User","A");
    static Utilisateur userB = new Utilisateur("User","B");
    static Utilisateur userC = new Utilisateur("User","C");

    static List<Menu> menus;
    static CommandeSimple commandeUserA;
    static CommandeSimple commandeUserB;

    static CommandeGroupee commandeGroupee;

    public static List<Menu> getMenus(){
        List<Menu> menus = new ArrayList<Menu>();

        // date qui fonctionnent
        Date db = new Date();
        Date df = new Date();

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, 1);
        db = c.getTime();
        c.setTime(df);
        c.add(Calendar.MINUTE, 2);
        df = c.getTime();

        menus.add(new Menu(10, "Burger cheese", new Creneau(db, df)));
        menus.add(new Menu(12, "Burger double cheese", new Creneau(db, df)));
        menus.add(new Menu(8, "Hamburger classic", new Creneau(db, df)));

        c.setTime(df);
        c.setTime(db);
        c.add(Calendar.HOUR, 2);
        db = c.getTime();
        c.add(Calendar.HOUR,1);
        df = c.getTime();

        menus.add(new Menu(10, "Burger cheese 2", new Creneau(db, df)));
        menus.add(new Menu(12, "Burger double cheese 2", new Creneau(db, df)));
        menus.add(new Menu(8, "Hamburger classic 2", new Creneau(db, df)));
        return menus;
    }

    public void commandeMemeCreneau(){
        // date qui fonctionnent
        Date db = new Date();
        Date df = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.HOUR, 1);
        df = c.getTime();

        Restaurant restaurant1 = new Restaurant("Restau 1",new ListeMenus(getMenus()));
        commandeGroupee = new CommandeGroupee();
        commandeUserA = new CommandeSimple(userA,restaurant1.getMenus().get(0),new Creneau(db, df),restaurant1);
        userA.setCommandeActuelle(commandeUserA);
        commandeUserB = new CommandeSimple(userB,restaurant1.getMenus().get(0),new Creneau(db, df),restaurant1);
        userB.setCommandeActuelle(commandeUserB);
    }
    public void commandeDiffCreneau(){
        Restaurant restaurant1 = new Restaurant("Restau 1",new ListeMenus(getMenus()));

        // date qui fonctionnent
        Date db = new Date();
        Date df = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.HOUR, 1);
        df = c.getTime();

         commandeGroupee = new CommandeGroupee();
         commandeUserA = new CommandeSimple(userA,restaurant1.getMenus().get(0),new Creneau(db, df),restaurant1);
        userA.setCommandeActuelle(commandeUserA);
        c.setTime(df);
        c.setTime(db);
        c.add(Calendar.HOUR, 2);
        db = c.getTime();
        c.add(Calendar.HOUR,1);
        df = c.getTime();
         commandeUserB = new CommandeSimple(userB,restaurant1.getMenus().get(3),new Creneau(db, df),restaurant1);
        userB.setCommandeActuelle(commandeUserB);
    }



    @Etantdonné("User A qui accepte que des utilisateurs rejoignent sa commande et ont le meme creneau")
    public void user_a_qui_accepte_que_des_utilisateurs_rejoignent_sa_commande_et_ont_le_meme_creneau() {
        // Write code here that turns the phrase above into concrete actions
        commandeMemeCreneau();
        commandeUserA = new CommandeGroupee(commandeUserA);
        assertEquals(userA,commandeUserA.getUtilisateur());
        commandeGroupee = (CommandeGroupee) commandeUserA;
        assertEquals(commandeUserA.getMenus(),commandeGroupee.getMenus());
    }


    @Quand("User B rentre l'idendifiant de la commande de User A")
    public void user_b_rentre_l_idendifiant_de_la_commande_de_user_a() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse( userB.rejoindreCommandegroupee(commandeGroupee,commandeGroupee.getCode()+9999));
        userB.rejoindreCommandegroupee(commandeGroupee,commandeGroupee.getCode());
    }

    @Alors("User B a rejoint la commande de User A")
    public void user_b_a_rejoint_la_commande_de_user() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(2,commandeGroupee.getCommandes().size());
        assertEquals(userA,commandeGroupee.getCommandes().get(0).getUtilisateur());
        assertEquals(userB,commandeGroupee.getCommandes().get(1).getUtilisateur());

    }

    @Etantdonné("User A qui accepte que des utilisateurs rejoignent sa commande et n'ont pas le meme creneau")
    public void user_a_qui_accepte_que_des_utilisateurs_rejoignent_sa_commande_et_n_ont_pas_le_meme_creneau() {
        // Write code here that turns the phrase above into concrete actions
        commandeDiffCreneau();
        commandeUserA = new CommandeGroupee(commandeUserA);
        assertEquals(userA,commandeUserA.getUtilisateur());
        commandeGroupee = (CommandeGroupee) commandeUserA;
        assertEquals(commandeUserA.getMenus(),commandeGroupee.getMenus());
    }

    @Alors("la commande de User A ne contient qu'une seule commande")
    public void la_commande_de_user_a_ne_contient_qu_une_seule_commande() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(1,commandeGroupee.getCommandes().size());
        assertEquals(userA,commandeGroupee.getCommandes().get(0).getUtilisateur());
    }

    @Etantdonné("User C qui rejoint la commande groupée")
    public void user_c_qui_rejoint_la_commande_groupée() {
        // Write code here that turns the phrase above into concrete actions
        commandeMemeCreneau();
        userC = new Utilisateur("User","C");
        commandeUserA = new CommandeGroupee(commandeUserA);
        assertEquals(userA,commandeUserA.getUtilisateur());
        commandeGroupee = (CommandeGroupee) commandeUserA;
        int size = commandeGroupee.getCommandes().size();
        assertTrue(userC.rejoindreCommandegroupee(commandeGroupee,commandeGroupee.getCode()));
        assertEquals(size+1,commandeGroupee.getCommandes().size());
    }
    @Quand("User C affiche la liste des menus")
    public void user_c_affiche_la_liste_des_menus() {
        // Write code here that turns the phrase above into concrete actions
        ListeMenus listeMenus = new ListeMenus(getMenus());
        assertEquals(userC.getCommandeActuelle().getCreneauLivraison(),commandeGroupee.getCreneauLivraison());
        menus = listeMenus.getMenusDansCreneau(userC.getCommandeActuelle().getCreneauLivraison());


    }
    @Alors("la liste ne contient que les menus ayant le créneau de la commande groupée")
    public void la_liste_ne_contient_que_les_menus_ayant_le_créneau_de_la_commande_groupée() {
        // Write code here that turns the phrase above into concrete actions
          assertEquals(3,menus.size());
          assertEquals("Burger cheese",menus.get(0).getName());

    }
    @Etantdonné("User C qui est dans la commande groupée")
    public void user_c_qui_est_dans_la_commande_groupée() {
        // Write code here that turns the phrase above into concrete actions
        userC = new Utilisateur("User","C");
        commandeUserA = new CommandeGroupee(commandeUserA);
        assertEquals(userA,commandeUserA.getUtilisateur());
        commandeGroupee = (CommandeGroupee) commandeUserA;
        assertTrue(userC.rejoindreCommandegroupee(commandeGroupee,commandeGroupee.getCode()));
        assertTrue(commandeGroupee.getCommandes().contains(userC.getCommandeActuelle()));

    }
    @Quand("User C ajoute un menu a sa commande")
    public void user_c_ajoute_un_menu_a_sa_commande() {
        // Write code here that turns the phrase above into concrete actions
        userC.addMenu(menus.get(0));
        assertEquals(1,userC.getCommandeActuelle().getMenus().size());
        assertEquals(10,(int) userC.getCommandeActuelle().getPrice());
    }
    @Alors("la commande de User C dans la commande groupée a bien été modifée")
    public void la_commande_de_user_c_dans_la_commande_groupée_a_bien_été_modifée() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(1,commandeGroupee.getCommandes().get(1).getMenus().size());
        assertEquals(10,(int)commandeGroupee.getCommandes().get(1).getPrice());
    }

}
