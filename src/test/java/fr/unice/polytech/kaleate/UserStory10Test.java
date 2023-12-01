package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.CommandeSimple;
import fr.unice.polytech.kaleate.commande.ListeCommande;
import fr.unice.polytech.kaleate.commande.StatutCommande;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.menu.StatutMenu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.ManagerRestaurant;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.fr.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class UserStory10Test {
    static Restaurant pizzaroc;
    static CommandeSimple com;
    static ManagerRestaurant managerRestaurant;

    public void preparerMenus(int n){
        for (int i=0; i<com.getMenus().size() & n>0;i++){
            if (pizzaroc.finirPreparationMenu(com,com.getListeMenus().get(i))) {
                n--;
            }
        }
    }

    @Soit("le restaurant {string}")
    public void le_restaurant(String string) {
        pizzaroc=new Restaurant();

    }
    @Soit("la commande {int} validee avec une liste de {int} menus du Restaurant {string}")
    public void la_commande_validee_avec_une_liste_de_menus_du_restaurant(int int1, int int2, String string) {
        Date db = new Date();
        Date df = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.DATE, 1);
        df = c.getTime();
        Menu m1 = new Menu(15,"pizza-fiesta",new Creneau(db,df));
        Menu m2 = new Menu(9,"pizza-solo",new Creneau(db,df));
        Menu m3 = new Menu(5,"pizza-youpi",new Creneau(db,df));
        pizzaroc.ajouterMenu(m1);
        pizzaroc.ajouterMenu(m2);
        pizzaroc.ajouterMenu(m3);

        Utilisateur michel = new Utilisateur("Michel","Legoat");

        com=new CommandeSimple(michel);
        com.addMenu(pizzaroc.getMenus().get(0));
        com.addMenu(pizzaroc.getMenus().get(0));
        com.addMenu(pizzaroc.getMenus().get(0));

        assertNotEquals(com.getId(),int1);
        com.setId(int1);
        assertEquals(com.getId(),int1);

        ListeCommande lc = new ListeCommande();

        lc.add(com);

        pizzaroc.setListCommande(lc);
        assertTrue(pizzaroc.validerCommande(com));
        assertTrue(pizzaroc.preparerCommande(com));
        assertEquals(int2, com.getListeMenus().size());

    }
    @Soit("je suis manager du restaurant {string}")
    public void je_suis_manager_du_restaurant(String string) {
        managerRestaurant=new ManagerRestaurant(pizzaroc);
        assertNotNull(managerRestaurant);
    }
    @Quand("je veux dire que la commande est prete")
    public void je_veux_dire_que_la_commande_est_prete() {
        managerRestaurant.commandePrete(666);
    }
    @Alors("la commande n'est pas prete")
    public void la_commande_n_est_pas_prete() {
        je_veux_dire_que_la_commande_est_prete();
        assertNotEquals(StatutCommande.PRETE, com.getStatut());
    }

    @Étantdonnéque("{int} menus de la commande {int} sont prets")
    public void menus_de_la_commande_sont_prets(int int1, int int2) {
        preparerMenus(int1);
        int res=0;
        for (int i=0; i<com.getMenus().size();i++){
            if (com.getStatutsMenus().get(i)== StatutMenu.PRET)
                res++;
        }
        assertEquals(res,int1);

    }
    @Alors("la commande est prete")
    public void la_commande_est_prete() {
        je_veux_dire_que_la_commande_est_prete();
        assertEquals(StatutCommande.PRETE, com.getStatut());
    }

}
