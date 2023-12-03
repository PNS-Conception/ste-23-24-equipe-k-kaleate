package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.*;
import fr.unice.polytech.kaleate.livrable.Livreur;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.ManagerRestaurant;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class UserStory14Test {

    private static Livreur livreur;
    private static Commande commande;

    private static Restaurant restaurant;

    private static ManagerRestaurant tierry;
    @Soit("Une commande prête à être livree")
    public void une_commande_prête_à_être_livree() {
        Date db = new Date();
        Date df = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(df);
        c.add(Calendar.DATE, 1);
        df = c.getTime();
        restaurant=new Restaurant("Pizza");
        restaurant.ajouterMenu(new Menu(10, "Burger cheese", new Creneau(db, df)));
        restaurant.ajouterMenu(new Menu(12, "Burger double cheese", new Creneau(db, df)));
        commande= new CommandeSimple(new Utilisateur("Pat","Dinspi"));
        commande.addMenu(restaurant.getMenus(Commandable.class).getParNom("Burger cheese"));
        commande.addMenu(restaurant.getMenus(Commandable.class).getParNom("Burger double cheese"));
        commande.setId(666);
        ListeCommande lc = new ListeCommande();
        lc.add(commande);
        restaurant.setListCommande(lc);
        assertEquals(commande.getStatutCommande(), StatutCommande.EN_CREATION);
        restaurant.validerCommande(commande);
        assertEquals(commande.getStatutCommande(),StatutCommande.VALIDEE);

        restaurant.preparerMenu(commande,commande.getMenuParNom("Burger cheese", Commandable.class));
        assertEquals(commande.getStatutCommande(),StatutCommande.EN_PREPARATION);
        restaurant.preparerMenu(commande,commande.getMenuParNom("Burger double cheese", Commandable.class));
        assertEquals(commande.getStatutCommande(),StatutCommande.EN_PREPARATION);
        restaurant.finirPreparationMenu(commande,commande.getMenuParNom("Burger cheese", Commandable.class));
        assertEquals(commande.getStatutCommande(),StatutCommande.EN_PREPARATION);
        restaurant.finirPreparationMenu(commande,commande.getMenuParNom("Burger double cheese", Commandable.class));
        livreur=new Livreur("Michel","Sympa");
        assertEquals(restaurant.getListCommande().size(),1);
        assertEquals(commande.getStatutCommande(),StatutCommande.PRETE);
    }
    @Quand("Un livreur recupere la commande prete")
    public void un_livreur_recupere_la_commande_prete() {
        assertEquals(commande.getStatutCommande(),StatutCommande.PRETE);
        System.out.println(commande.getStatutCommande());
        assertTrue(livreur.recupere_commande(restaurant,666));
        System.out.println(commande.getStatutCommande());
    }

    @Alors("La commande peut être livree")
    public void la_commande_peut_être_livree() {
        assertEquals(commande.getStatutCommande(),StatutCommande.EN_LIVRAISON);
    }
}
