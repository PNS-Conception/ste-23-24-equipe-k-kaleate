package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.commande.CommandeSimple;
import fr.unice.polytech.kaleate.commande.ListeCommande;
import fr.unice.polytech.kaleate.commande.StatutCommande;
import fr.unice.polytech.kaleate.livrable.Livreur;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.ManagerRestaurant;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UserStory4_3Test {

    static Restaurant r1;
    static Restaurant r2;
    static Utilisateur u;
    static Commande c;
    static Livreur l;

    void setup(){
        r1=new Restaurant("Restau pizza");
        r2=new Restaurant("Restau Sushi");
        ListeMenus l1 = new ListeMenus();
        l1.add(new Menu(19,"Pizza 1",new Creneau(new Date(),new Date()),r1));
        l1.add(new Menu(18,"Pizza 2",new Creneau(new Date(),new Date()),r1));
        l1.add(new Menu(17,"Pizza 3",new Creneau(new Date(),new Date()),r1));
        r1.setMenus(l1);
        ListeMenus l2 = new ListeMenus();
        l2.add(new Menu(19,"Sushi 1",new Creneau(new Date(),new Date()),r2));
        l2.add(new Menu(18,"Sushi 2",new Creneau(new Date(),new Date()),r2));
        l2.add(new Menu(17,"Sushi 3",new Creneau(new Date(),new Date()),r2));
        r2.setMenus(l2);
        u=new Utilisateur("Toto","Titi");
        c=new CommandeSimple(u);
        c.addMenu(new Menu(19,"Pizza 1",new Creneau(new Date(),new Date()),r1));
        c.addMenu(new Menu(19,"Pizza 1",new Creneau(new Date(),new Date()),r1));
        c.addMenu(new Menu(18,"Pizza 2",new Creneau(new Date(),new Date()),r1));
        c.addMenu(new Menu(18,"Sushi 2",new Creneau(new Date(),new Date()),r2));
        u.setCommandeActuelle(c);
        ListeCommande lc = new ListeCommande();
        lc.add(c);
        r1.setListCommande(lc);
        r2.setListCommande(lc);
        u.payer();
        r1.preparerMenu(c,c.getMenus().get(0));
        r1.finirPreparationMenu(c,c.getMenus().get(0));
        r1.preparerMenu(c,c.getMenus().get(1));
        r1.finirPreparationMenu(c,c.getMenus().get(1));
        r1.preparerMenu(c,c.getMenus().get(2));
        r1.finirPreparationMenu(c,c.getMenus().get(2));
        r2.preparerMenu(c,c.getMenus().get(3));
        r2.finirPreparationMenu(c,c.getMenus().get(3));
        ManagerRestaurant mr1 = new ManagerRestaurant(r1);
        ManagerRestaurant mr2 = new ManagerRestaurant(r2);

        mr1.commandePrete(c.getId());
        mr2.commandePrete(c.getId());

        l = new Livreur("Ca","roule");

        l.recupere_commande(r1,c.getId());
        l.recupere_commande(r2,c.getId());

    }
    @Soit("Un restaurant ayant un historique de menus commandés")
    public void un_restaurant_ayant_un_historique_de_menus_commandes() {
        setup();
        assertEquals(3,r1.tendances().keySet().size());
        assertEquals(3,r2.tendances().keySet().size());
    }
    @Quand("Le livreur a terminé une livraison avec au moins un des menus du restaurant")
    public void le_livreur_a_terminé_une_livraison_avec_au_moins_un_des_menus_du_restaurant() {
        l.arriverADestination();
        u.recupererCommande();
        l.terminerLivraison();
        assertEquals(StatutCommande.LIVREE,c.getStatut());
    }
    @Alors("l'historique des menus commandés est mis à jour")
    public void l_historique_des_menus_commandés_est_mis_à_jour() {
        assertEquals(Optional.of(2),Optional.of(r1.tendances().get("Pizza 1")));
        assertEquals(Optional.of(1),Optional.of(r1.tendances().get("Pizza 2")));
        assertEquals(Optional.of(0),Optional.of(r1.tendances().get("Pizza 3")));
    }
    @Quand("je consulte mon historique de menus commandés")
    public void je_consulte_mon_historique_de_menus_commandés() {
        assertEquals(3,r2.tendances().keySet().size());
    }
    @Alors("je peux voir mes menus les plus commandés")
    public void je_peux_voir_mes_menus_les_plus_commandés() {
        r2.tendances().put("Sushi 2",1);
        assertEquals("Sushi 2",r2.tendances().keySet().stream().toList().get(0));
    }
}
