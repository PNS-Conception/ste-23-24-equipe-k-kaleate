package fr.unice.polytech.kaleate;

import io.cucumber.java.fr.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class UserStory7Test {
    static Restaurant pizzaroc;
    static Commande com;
    static ManagerRestaurant managerRestaurant;

    public void preparerMenus(int n){
        for (int i=0; i<com.getMenus().size() & n>0;i++){
            if (pizzaroc.preparerMenu(com,com.getListeMenus().get(i)))
                n--;
        }
    }

    @Soit("le restaurant {string}")
    public void le_restaurant(String string) {
        pizzaroc=new Restaurant();

    }
    @Soit("la commande {int} validee avec une liste de {int} menus du Restaurant {string}")
    public void la_commande_validee_avec_une_liste_de_menus_du_restaurant(int int1, int int2, String string) {
        ArrayList<Menu> lm = new ArrayList<>();
        Date db = new Date();
        Date df = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.DATE, 1);
        df = c.getTime();
        lm.add(new Menu(15,"pizza-fiesta",new Creneau(db,df)));
        lm.add(new Menu(9,"pizza-solo",new Creneau(db,df)));
        ListeMenus menus = new ListeMenus(lm);
        pizzaroc.setMenus(menus);

        Utilisateur michel = new Utilisateur("Michel","Legoat");

        com=new Commande(michel,new ArrayList<>(),pizzaroc);
        com.addMenu(pizzaroc.getMenus().get(0));
        com.addMenu(pizzaroc.getMenus().get(0));
        com.addMenu(pizzaroc.getMenus().get(1));

        assertNotEquals(com.getId(),int1);
        com.setId(int1);
        assertEquals(com.getId(),int1);

        assertTrue(pizzaroc.validerCommande(com));
        assertEquals(com.getListeMenus().size(),int2);

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
        assertNotEquals(com.getStatut(),StatutCommande.PRETE);
    }

    @Étantdonnéque("{int} menus de la commande {int} sont prets")
    public void menus_de_la_commande_sont_prets(int int1, int int2) {
        preparerMenus(int1);
        int res=0;
        for (int i=0; i<com.getMenus().size();i++){
            if (com.getStatutsMenus().get(i)==StatutMenu.PRET)
                res++;
        }
        assertEquals(res,int1);

    }
    @Alors("la commande est prete")
    public void la_commande_est_prete() {
        je_veux_dire_que_la_commande_est_prete();
        assertEquals(com.getStatut(),StatutCommande.PRETE);
    }

}
