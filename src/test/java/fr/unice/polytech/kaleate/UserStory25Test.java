package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import static org.junit.Assert.*;
import java.util.Date;

public class UserStory25Test {

    static Utilisateur user;

    public static void userCommandeSimple(){
        user = new Utilisateur("Le","Rat");
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date())));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date())));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date())));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date())));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date())));

        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date())));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date())));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date())));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date())));
        user.addMenu(new Menu(10,"menu",new Creneau(new Date(),new Date())));
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

    }
    @Quand("chacun paye sa commande")
    public void chacun_paye_sa_commande() {

    }
    @Alors("une réduction est appliquée sur le prix de chaque commande")
    public void une_réduction_est_appliquée_sur_le_prix_de_chaque_commande() {

    }

}
