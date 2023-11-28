package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.AdministrateurCampus;
import fr.unice.polytech.kaleate.campus.Campus;
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
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserStory17Test {

    static Restaurant restaurant;
    static Utilisateur utilisateur;

    static Livreur livreur;

    static Commande commande;

    static Campus campus;

    static AdministrateurCampus administrateurCampus;

    static Avis avis5etoile;

    @Before
    void setUp(){
        restaurant=new Restaurant("r");
        Menu m = new Menu(4,"tacos",new Creneau(new Date(),new Date()));
        m.setRestaurant(restaurant);
        List<Menu> lm = new ArrayList<>();
        lm.add(m);
        restaurant.setMenus(new ListeMenus(lm));
        utilisateur= new Utilisateur("Michel","Dubois");
        campus = new Campus("c");
        administrateurCampus = new AdministrateurCampus(campus);
        administrateurCampus.ajouterUtilisateur(utilisateur);

        commande = new CommandeSimple(utilisateur);
        commande.addMenu(m);
        utilisateur.setCommandeActuelle(commande);

        utilisateur.payer();

        restaurant.preparerMenu(commande,m);
        restaurant.finirPreparationMenu(commande,m);

        ManagerRestaurant r = new ManagerRestaurant(restaurant);
        ListeCommande lc = new ListeCommande();
        lc.add(commande);
        restaurant.setListCommande(lc);
        r.commandePrete(commande.getId());

        livreur = new Livreur("Ca","roule");

        livreur.recupere_commande(restaurant,commande.getId());

        livreur.arriverADestination();

        utilisateur.recupererCommande();

        livreur.terminerLivraison();

    }

    @Quand("je suis satisfait de mes repas dans le restaurant auquel j'ai commandé")
    public void je_suis_satisfait_de_mes_repas_dans_le_restaurant_auquel_j_ai_commandé() {
        avis5etoile=new Avis(5,"franchement propre");
        assertNotNull(avis5etoile);
    }
    @Alors("je peux attribuer une note au restaurant")
    public void je_peux_attribuer_une_note_au_restaurant() {
        setUp();
        assertEquals(0,utilisateur.getAvis().size());
        utilisateur.evaluer(avis5etoile,commande.getRestaurants().get(0));
        assertEquals(1,restaurant.getAvis().size());
        assertEquals(0,utilisateur.getAvis().size());
    }
    @Alors("ma note est visible pour les autres utilisateurs")
    public void ma_note_est_visible_pour_les_autres_utilisateurs() {
        assertTrue(restaurant.getAvis().containsKey(utilisateur));
    }

    @Etantdonnéque("je suis un utilisateur livré")
    public void je_suis_un_utilisateur_livré() {
        assertEquals(commande,utilisateur.getHistorique().get(0));
    }
    @Quand("je veux noter le livreur")
    public void je_veux_noter_le_livreur() {
        avis5etoile=new Avis(5,"franchement propre");
        assertNotNull(avis5etoile);
    }
    @Alors("je peux attribuer une note au livreur")
    public void je_peux_attribuer_une_note() {
        utilisateur.evaluer(avis5etoile,livreur);
        assertEquals(1,livreur.getAvis().size());
        assertEquals(0,utilisateur.getAvis().size());
    }
    @Alors("ma note est visible pour le restaurant et les autres utilisateurs")
    public void ma_note_est_visible_pour_le_restaurant_et_les_autres_utilisateurs() {
        assertTrue(livreur.getAvis().containsKey(utilisateur));
    }

    @Etantdonnéque("je suis un livreur")
    public void je_suis_un_livreur() {
        assertNotNull(livreur);
    }
    @Quand("j'ai effectué une livraison")
    public void j_ai_effectué_une_livraison() {
        assertEquals(StatutCommande.LIVREE,commande.getStatut());
    }
    @Alors("je peux attribuer une note à l'usager")
    public void je_peux_attribuer_une_note_à_l_usager() {
        assertEquals(0,utilisateur.getAvis().size());
        livreur.evaluer(avis5etoile,utilisateur);
        assertEquals(1,utilisateur.getAvis().size());
    }
    @Alors("ma note est visible pour les autres utilisateurs et l'administrateur")
    public void ma_note_est_visible_pour_les_autres_utilisateurs_et_l_administrateur() {
        double val =5;
        assertEquals(val,administrateurCampus.getNoteUtilisateur(utilisateur),0.01);
    }
}
