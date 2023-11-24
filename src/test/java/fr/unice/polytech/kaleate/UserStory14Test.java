package fr.unice.polytech.kaleate;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
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
        commande=new Commande(new Utilisateur("Pat","Dinspi"), restaurant.getMenus().getParNom("Burger cheese"), restaurant);
        commande.setId(666);
        ListeCommande lc = new ListeCommande();
        lc.add(commande);
        restaurant.setListCommande(lc);
        assertEquals(commande.getStatut(),StatutCommande.EN_CREATION);
        restaurant.validerCommande(commande);
        assertEquals(commande.getStatut(),StatutCommande.VALIDEE);
        commande.setStatut(StatutCommande.PAYEE);
        restaurant.preparerCommande(commande);
        assertEquals(commande.getStatut(),StatutCommande.EN_PREPARATION);
        restaurant.preparerMenu(commande,commande.getMenuParNom("Burger cheese"));
        tierry=new ManagerRestaurant("Bob","Tierry",restaurant);
        livreur=new Livreur("Michel","Sympa");
        assertEquals(restaurant.getListCommande().size(),1);
        assertEquals(commande.getStatut(),StatutCommande.EN_PREPARATION);
    }
    @Quand("Un livreur recupere la commande prete")
    public void un_livreur_recupere_la_commande_prete() {
        assertEquals(commande.getStatut(),StatutCommande.EN_PREPARATION);
        tierry.commandePrete(666);
        assertEquals(commande.getStatut(),StatutCommande.PRETE);
        assertTrue(livreur.recupere_commande(restaurant,666));
    }

    @Alors("La commande peut être livree")
    public void la_commande_peut_être_livree() {
        assertEquals(commande.getStatut(),StatutCommande.EN_LIVRAISON);
    }
}
