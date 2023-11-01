package fr.unice.polytech.kaleate;

import io.cucumber.java.fr.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserStory3Test {
    static Utilisateur userA = new Utilisateur("User","A");
    static Utilisateur userB = new Utilisateur("User","B");

    static Commande commandeUserA;
    static Commande commandeUserB;

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

    public void commandeMemeRestau(){
        Restaurant restaurant1 = new Restaurant("Restau 1",new ListMenus(getMenus()));

       // Restaurant restaurant2 = new Restaurant("Restau 2",new ListMenus(getMenus()));

       commandeUserA = new Commande(userA,restaurant1.getMenus().get(0),restaurant1);
       commandeUserB = new Commande(userB,restaurant1.getMenus().get(0),restaurant1);
    }


    @Etantdonné("User A et User B qui ont chacun leur commande mais dans des restaurants differents")
    public void user_a_et_user_b_qui_ont_chacun_leur_commande_mais_dans_des_restaurants_differents() {
        // Write code here that turns the phrase above into concrete actions
        commandeMemeRestau();

    }
    @Etantdonné("User A qui accepte que des utilisateur rejoignent sa commande")
    public void user_a_qui_accepte_que_des_utilisateur_rejoignent_sa_commande() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Quand("User B rentre l'idendifiant de la commande de User A")
    public void user_b_rentre_l_idendifiant_de_la_commande_de_user_a() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Alors("User B n'a pas rejoint la commande de User A")
    public void user_b_n_a_pas_rejoint_la_commande_de_user_a() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Etantdonné("User A et User B qui ont chacun leur commande")
    public void user_a_et_user_b_qui_ont_chacun_leur_commande() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Etantdonné("User A qui rejette que des utilisateur rejoignent sa commande")
    public void user_a_qui_rejette_que_des_utilisateur_rejoignent_sa_commande() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Alors("User B a rejoint la commande de User {int}")
    public void user_b_a_rejoint_la_commande_de_user(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }
}
