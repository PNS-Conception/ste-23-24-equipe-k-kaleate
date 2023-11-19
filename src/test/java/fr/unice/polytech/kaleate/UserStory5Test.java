package fr.unice.polytech.kaleate;

import io.cucumber.java.da.Men;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class UserStory5Test {

    static ManagerRestaurant manager;
    static Restaurant restaurant = new Restaurant();
    static Menu menuChoisi;
    static ChoixElement choixElement;
    static Date db = new Date();
    static Date df = new Date();

    @Soit("le manager {string} {string} du restaurant {string}")
    public void leManagerDuRestaurant(String arg0, String arg1, String arg2) {
        restaurant.setName(arg0);
        manager = new ManagerRestaurant(arg0, arg1, restaurant);
    }

    @Quand("il ajoute un nouveau menu {string} pour {int} euros à la carte")
    public void il_ajoute_un_nouveau_menu_pour_euros_a_la_carte(String arg0, int arg1) {
        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.DATE, 1);
        df = c.getTime();

        Creneau creneau = new Creneau(db, df);
        menuChoisi = new Menu(arg1, arg0, creneau);
        manager.ajouterUnMenu(menuChoisi);
    }

    @Alors("le restaurant {string} propose un menu supplémentaire")
    public void le_restaurant_propose_un_menu_supplementaire(String string) {
        assertEquals(menuChoisi.getName(), restaurant.getMenus().getParNom(menuChoisi.getName()).getName());
    }

    @Alors("la liste des menus augmente de {int}")
    public void la_liste_des_menus_augmente_de(Integer int1) {
        assertEquals(restaurant.getMenus().size(), 1);
    }

    @Quand("il supprimer le menu {string} de la carte")
    public void il_supprimer_le_menu_de_la_carte(String string) {
        Menu menu = restaurant.getMenus().getParNom(string);
        manager.supprimerUnMenu(menu);
    }

    @Alors("le restaurant {string} met à jour son catalogue de menus")
    public void le_restaurant_met_a_jour_son_catalogue_de_menus(String string) {
        System.out.println(restaurant.getMenus());
    }

    @Alors("la liste des menus diminue de {int}")
    public void la_liste_des_menus_diminue_de(Integer int1) {
        assertEquals(0, restaurant.getMenus().size()-int1);
    }

    @Quand("il modifie un élément du menu {string} de la carte")
    public void il_modifie_un_element_du_menu_de_la_carte(String string) {
        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.DATE, 1);
        df = c.getTime();

        Creneau creneau = new Creneau(db, df);
        menuChoisi = new Menu(10, string, creneau);
        manager.ajouterUnMenu(menuChoisi);

        choixElement = new ChoixElement("Boisson", 1);

        manager.modifierUnMenu(menuChoisi, choixElement);
    }

    @Alors("le restaurant {string} met à jour son catalogue de menu")
    public void le_restaurant_met_a_jour_son_catalogue_de_menu(String string) {
        assertTrue(restaurant.getMenus().getParNom("Burger cheese").getChoixElementListe().contains(choixElement));
    }
}
