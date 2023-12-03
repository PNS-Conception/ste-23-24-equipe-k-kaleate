package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Campus;
import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.commande.Buffet;
import fr.unice.polytech.kaleate.commande.Commandable;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import fr.unice.polytech.kaleate.campus.Staff;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CommandeBuffetTest {

    static Campus campus;
    static Restaurant restaurant;
    static Staff staff;
    static Utilisateur utilisateur;
    static Buffet commandeBuffet;

    static ListeMenus lmv = new ListeMenus();

    @Soit("un campus {string}")
    public void un_campus(String string) {
        campus = new Campus(string);
    }
    @Soit("un restaurant {string}")
    public void un_restaurant(String string) {
        restaurant = new Restaurant(string);
        campus.ajoutRestaurant(restaurant);
    }
    @Soit("un membre du staff {string} {string}")
    public void un_membre_du_staff(String prenom, String nom) {
        staff = new Staff(prenom, nom);
        campus.ajoutUtilisateur(staff);
    }
    @Soit("un utilisateur {string} {string}")
    public void un_utilisateur(String prenom, String nom) {
        utilisateur = new Utilisateur(prenom, nom);
        campus.ajoutUtilisateur(utilisateur);
    }
    @Etantdonnéque("le restaurant {string} propose un buffet")
    public void le_restaurant_propose_un_buffet(String string) {
        restaurant.setMenus(new ListeMenus());
        restaurant.ajouterMenu(new Menu(10, "Cheese Menu", new Creneau(new Date(2021, 1, 1, 12, 0), new Date(2021, 1, 1, 13, 0))));
        ListeMenus lm = new ListeMenus();
        commandeBuffet = new Buffet("buffet", 10, 20);
        lm.add(new Menu(10, "Cheese buffet", new Creneau(new Date(2021, 1, 1, 12, 0), new Date(2021, 1, 1, 13, 0))));
        lm.add(new Menu(10, "Bacon buffet", new Creneau(new Date(2021, 1, 1, 12, 0), new Date(2021, 1, 1, 13, 0))));
        commandeBuffet.setMenus(lm);
        restaurant.ajouterMenu(commandeBuffet);
    }
    @Quand("{string} commande un buffet")
    public void commande_un_buffet(String string) {
        List<ListeMenus> lm = campus.listerMenus(staff.getTypeMenu()).values().stream().toList();
        ListeMenus lms = new ListeMenus();
        for (ListeMenus l : lm) {
            lms.addAll(l);
        }
        assertTrue(lms.contains(commandeBuffet));
        staff.addMenu(commandeBuffet);
    }
    @Alors("il y aura {int} personnes au buffet")
    public void il_y_aura_personnes_au_buffet(Integer int1) {
        assertEquals(commandeBuffet, staff.getCommandeActuelle());
        ((Buffet) staff.getCommandeActuelle()).setNbPersonnes(int1);
    }
    @Alors("{string} sera le receveur de la commande")
    public void sera_le_receveur_de_la_commande(String string) {
        staff.getCommandeActuelle().setUtilisateurRecepteur(utilisateur);

        assertEquals(utilisateur, staff.getCommandeActuelle().getUtilisateurRecepteur());
        assertNotEquals(staff, staff.getCommandeActuelle().getUtilisateurRecepteur());

        assertEquals(staff, staff.getCommandeActuelle().getUtilisateurEmetteur());
    }
    @Alors("le buffet est retiré de la liste des buffets disponibles")
    public void le_buffet_est_retiré_de_la_liste_des_buffets_disponibles() {
        List<ListeMenus> lm = campus.listerMenus(staff.getTypeMenu()).values().stream().toList();
        ListeMenus lm2 = new ListeMenus();
        for (ListeMenus l : lm) {
            lm2.addAll(l);
        }
        assertFalse(lm2.contains(commandeBuffet));
        assertEquals(1, lm2.size());
    }
    @Alors("le nombre de Menus disponibles est de {int}")
    public void le_nombre_de_menus_disponibles_est_de(Integer int1) {
        assertEquals(int1, Optional.of(((Buffet) staff.getCommandeActuelle()).getNbPersonnes()).get());
    }

    @Quand("{string} essaye commander un menu")
    public void essaye_commander_un_menu(String string) {
        List<ListeMenus> lm = campus.listerMenus(utilisateur.getTypeMenu()).values().stream().toList();
        ListeMenus lmv = new ListeMenus();
        for (ListeMenus l : lm) {
            lmv.addAll(l);
        }
    }
    @Alors("la liste de menus disponibles ne contient pas de buffet")
    public void la_liste_de_menus_disponibles_ne_contient_pas_de_buffet() {
        assertFalse(lmv.contains(commandeBuffet));
    }


    @Quand("il essaye de modifier le contenu du buffet")
    public void il_essaye_de_modifier_le_contenu_du_buffet() {
        assertFalse(staff.addMenu(new Menu(10, "Cheese buffet", new Creneau(new Date(2021, 1, 1, 12, 0), new Date(2021, 1, 1, 13, 0)))));
    }

    @Alors("le contenu du buffet ne change pas")
    public void le_contenu_du_buffet_ne_change_pas() {
        assertEquals(2, staff.getCommandeActuelle().getMenus().size());
    }

    @Soit("{string} commande un menu")
    public void commande_un_menu(String string) {
        staff.addMenu(campus.listerRestaurants().get(0).getMenus(staff.getTypeMenu()).getParNom("Cheese Menu"));

        List<ListeMenus> lm = campus.listerMenus(staff.getTypeMenu()).values().stream().toList();
        ListeMenus lm2 = new ListeMenus();
        for (ListeMenus l : lm) {
            lm2.addAll(l);
        }

        assertEquals(1, lm2.size());
    }
    @Alors("le menu est remis dans la liste des menus du restaurant")
    public void le_menu_est_remis_dans_la_liste_des_menus_du_restaurant() {
        List<ListeMenus> lm = campus.listerMenus(staff.getTypeMenu()).values().stream().toList();
        ListeMenus lm2 = new ListeMenus();
        for (ListeMenus l : lm) {
            lm2.addAll(l);
        }

        assertEquals(1, lm2.size());
    }
    @Alors("la commande de {string} est un buffet")
    public void la_commande_de_est_un_buffet(String string) {
        assertEquals(commandeBuffet, staff.getCommandeActuelle());
    }
}
