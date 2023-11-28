package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Campus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;
import io.cucumber.java.fr.Étantdonnéque;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserStory8_3Test {

    static Campus campus;
    @Soit("le campus {string} avec une liste de restaurants et leurs menus :")
    public void le_campus_avec_une_liste_de_restaurants_et_leurs_menus(String string, DataTable dataTable) {
        campus = new Campus(string);

        List<List<String>> rows = dataTable.asLists(String.class);

        for (List<String> columns : rows) {
            if (campus.listerRestaurants().getParNom(columns.get(0))==null)
                campus.ajoutRestaurant(new Restaurant(columns.get(0)));
            Date db = new Date();
            Date df = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(df);
            c.add(Calendar.DATE, 1);
            df = c.getTime();

            Random random = new Random();
            float randomFloat = random.nextFloat();
            float price = randomFloat * 15;
            campus.listerRestaurants().getParNom(columns.get(0)).getMenus().add(new Menu(price,columns.get(1),new Creneau(db,df)));
        }
    }
    @Étantdonnéque("je selectionne le campus {string}")
    public void je_selectionne_le_campus(String string) {
       assertNotNull(campus);
    }
    @Quand("je choisis de consulter les menus du campus {string}")
    public void je_choisis_de_consulter_les_menus_du_campus(String string) {
        assertEquals(campus.getNom(),string);
    }
    @Alors("je devrai avoir {int} restaurants chacun {int} menus")
    public void je_devrai_avoir_x_restaurants_avec_y_menus(int x, int y) {
        assertEquals(campus.listerMenus().keySet().size(),x);
        for (Restaurant r : campus.listerMenus().keySet()){
            assertEquals(campus.listerMenus().get(r).size(),y);
        }
    }
}
