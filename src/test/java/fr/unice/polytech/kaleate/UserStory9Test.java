package fr.unice.polytech.kaleate;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etqu;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UserStory9Test {

    static ManagerRestaurant manager;
    static Restaurant restaurant = new Restaurant();
    static Menu menuChoisi;

    @Soit("un manager {string} {string} du restaurant {string}")
    public void un_manager_du_restaurant(String arg0, String arg1, String arg2) {
        restaurant.setName(arg2);
        manager = new ManagerRestaurant(arg0, arg1, restaurant);
    }

    @Quand("je modifie le créneau de mon menu {string} qui est à {int} euros il a un créneau qui commence à {int} h {int} et se termine à {int} h {int}")
    public void jeModifieLeCreneauDeMonMenuQuiEstAEurosIlAUnCreneauQuiCommenceAHEtSeTermineAH(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        Creneau creneau = new Creneau(new Date(2023, Calendar.NOVEMBER,28,arg2,arg3), new Date(2023, Calendar.NOVEMBER,28,arg4,arg5));
        menuChoisi = new Menu(arg1, arg0, creneau);
        assertEquals(creneau, menuChoisi.getCreneau());
    }

    @Alors("mon menu {string} a maintenant un créneau qui commence à {int} h {int} et termine à {int}h{int}")
    public void monMenuAMaintenantUnCreneauQuiCommenceAHEtTermineAH(String arg0, int arg1, int arg2, int arg3, int arg4) {
        Creneau creneau = new Creneau(new Date(2023, Calendar.NOVEMBER,28,arg1,arg2), new Date(2023, Calendar.NOVEMBER,28,arg3,arg4));
        manager.modifierCreneauMenu(menuChoisi, creneau);
        assertEquals(creneau, menuChoisi.getCreneau());
    }
}
