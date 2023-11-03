package fr.unice.polytech.kaleate;

import io.cucumber.java.fr.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class UserStory3Test {
    static Utilisateur userA = new Utilisateur("User","A");
    static Utilisateur userB = new Utilisateur("User","B");

    static Commande commandeUserA;
    static Commande commandeUserB;

    static CommandeGroupee commandeGroupee;

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

    public void commandeMemeCreneau(){
        // date qui fonctionnent
        Date db = new Date();
        Date df = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.DATE, 1);
        df = c.getTime();

        Restaurant restaurant1 = new Restaurant("Restau 1",new ListMenus(getMenus()));
        commandeGroupee = new CommandeGroupee();
        commandeUserA = new Commande(userA,restaurant1.getMenus().get(0),new Creneau(db, df),restaurant1);
        commandeUserB = new Commande(userB,restaurant1.getMenus().get(0),new Creneau(db, df),restaurant1);
    }
    public void commandeDiffCreneau(){
        Restaurant restaurant1 = new Restaurant("Restau 1",new ListMenus(getMenus()));

        // date qui fonctionnent
        Date db = new Date();
        Date df = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.DATE, 1);
        df = c.getTime();

         commandeGroupee = new CommandeGroupee();
         commandeUserA = new Commande(userA,restaurant1.getMenus().get(0),new Creneau(db, df),restaurant1);
        c.setTime(df);
        c.add(Calendar.DATE, 3);
        df = c.getTime();
         commandeUserB = new Commande(userB,restaurant1.getMenus().get(0),new Creneau(db, df),restaurant1);
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
        assertFalse( commandeGroupee.ajouterCommande(commandeGroupee.getCode()+9999, commandeUserB));
         commandeGroupee.ajouterCommande(commandeGroupee.getCode(), commandeUserB);
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
        System.out.println(commandeUserA.getUtilisateur());
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

}
