package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.CommandeGroupee;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import static org.junit.Assert.*;
import java.util.Date;

public class UserStory25Test {

    static Utilisateur user;
    static  Utilisateur user2;
    static Utilisateur user3;
    static Restaurant resto;

    public static void userCommandeSimple(){
        user = new Utilisateur("Le","Rat");
        resto = new Restaurant("resto");
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));

        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
    }
    public static void userCommandeGroupee(){
        user = new Utilisateur("Le","Rat");
        user2 = new Utilisateur("Le2","Rat2");
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user.setCreneauLivraison(new Creneau(new Date(),new Date()));
        user.setCommandeActuelle(new CommandeGroupee(user.getCommandeActuelle()));
        CommandeGroupee commandeTmp = (CommandeGroupee) user.getCommandeActuelle();
        user2.rejoindreCommandegroupee(commandeTmp,commandeTmp.getCode());
        user2.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user2.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user2.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user2.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
         user3 = new Utilisateur("Le3","Rat3");
        user3.rejoindreCommandegroupee(commandeTmp,commandeTmp.getCode());
        user3.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user3.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user3.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user3.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
        user3.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date()), resto));
    }
    @Etantdonnéque("un utilisateur avec une commande de dix menus")
    public void un_utilisateur_avec_une_commande_de_dix_menus() {
        userCommandeSimple();
        assertEquals(10, user.getCommandeActuelle().getMenus().size());
    }
    @Quand("je paye ma commande")
    public void je_paye_ma_commande() {
        user.payer();

    }
    @Alors("une réduction est appliquée sur le prix de ma commande")
    public void une_réduction_est_appliquée_sur_le_prix_de_ma_commande() {
        assertEquals(910,(int)user.getSolde());
    }


    @Etantdonnéque("plusieurs utilsateurs dans une meme commande groupée ont dix menus")
    public void plusieurs_utilsateurs_dans_une_meme_commande_groupée_ont_dix_menus() {
        userCommandeGroupee();
        assertEquals(4,user2.getCommandeActuelle().getMenus().size());
        assertEquals(5,user3.getCommandeActuelle().getMenus().size());
        assertEquals(1,user.getCommandeActuelle().getMenus().size());
    }
    @Quand("chacun paye sa commande")
    public void chacun_paye_sa_commande() {
        user.payer();
        user2.payer();
        user3.payer();
    }
    @Alors("une réduction est appliquée sur le prix de chaque commande")
    public void une_réduction_est_appliquée_sur_le_prix_de_chaque_commande() {
        assertEquals(991,(int) user.getSolde());
        assertEquals(964,(int) user2.getSolde());
        assertEquals(955,(int) user3.getSolde());

    }

}
