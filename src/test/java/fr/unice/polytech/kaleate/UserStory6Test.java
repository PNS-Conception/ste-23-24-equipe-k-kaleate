package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.commande.CommandeSimple;
import fr.unice.polytech.kaleate.commande.ListeCommande;
import fr.unice.polytech.kaleate.commande.StatutCommande;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnée;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.util.Date;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static org.junit.Assert.*;
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "fr.unice.polytech.kaleate")



public class UserStory6Test {

    static Restaurant restaurant = new Restaurant("Ratatouille");
    static Utilisateur user;
    static Commande commande;

    static Menu m =new Menu(10,"menu simple",new Creneau(new Date(),new Date()));

    static Menu m2 =new Menu(11,"menu simple2",new Creneau(new Date(),new Date()));
    static Menu m3 =new Menu(11,"menu simple3",new Creneau(new Date(),new Date()));
    public static void setUpRestaurant(){
        ListeCommande.reset();
        m.setRestaurant(restaurant);
        m2.setRestaurant(restaurant);
        m3.setRestaurant(new Restaurant("aaaa"));
        ListeCommande listeCommande = ListeCommande.getInstance();
        if(listeCommande.size()<4) {
            listeCommande.add(new CommandeSimple(new Utilisateur("1", "1"), m));
            listeCommande.add(new CommandeSimple(new Utilisateur("1", "1"), m));
            listeCommande.add(new CommandeSimple(new Utilisateur("1", "1"), m));
            listeCommande.add(new CommandeSimple(new Utilisateur("1", "1"), m3));
        }
        for(Commande c : listeCommande){
            c.setStatut(StatutCommande.VALIDEE);
        }
        restaurant.setListCommande(listeCommande);

    }
    @Soit("Je suis un restaurant qui a eu un problème")
    public void je_suis_un_restaurant_qui_a_eu_un_problème() {
        setUpRestaurant();
        assertEquals(3,restaurant.getListCommande().size());

    }
    @Etantdonnée("une commande avec un menu")
    public void une_commande_avec_un_menu() {
        user = new Utilisateur("Cristiano","Ronaldo");
        user.addMenu(m);

    }

    @Quand("j'annule le menu")
    public void j_annule_le_menu() {
        assertEquals(4,restaurant.getListCommande().size());
        float solde = user.getSolde();
        restaurant.annulerPreparationMenu(user.getCommandeActuelle(),m);
        assertEquals((int)( solde +m.getPrix()),(int)user.getSolde() );
    }

    @Alors("la commande disparait de liste a faire")
    public void la_commande_disparait_de_liste_a_faire() {

        assertEquals(3,restaurant.getListCommande().size());
    }
    @Etantdonnée("une commande avec plusieurs menus")
    public void une_commande_avec_plusieurs_menus() {
        user = new Utilisateur("Cristiano","Ronaldo");
        user.addMenu(m);
        user.addMenu(m2);

    }

    @Quand("j'annule un seul menu")
    public void j_annule_un_seul_menu() {
        float solde = user.getSolde();
        restaurant.annulerPreparationMenu(user.getCommandeActuelle(),m);
        assertEquals((int)( solde +m.getPrix()),(int)user.getSolde() );
    }
    @Alors("la commande est toujours la mais avec un menu en moins")
    public void la_commande_est_toujours_la_mais_avec_un_menu_en_moins() {
        assertTrue(ListeCommande.getInstance().contains(user.getCommandeActuelle()));
        assertEquals(2,user.getCommandeActuelle().getMenus().size());
        assertEquals(11,(int)user.getCommandeActuelle().getPrix());
    }

}