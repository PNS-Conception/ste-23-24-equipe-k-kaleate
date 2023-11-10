package fr.unice.polytech.kaleate;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.fr.*;
import org.junit.jupiter.api.Assertions;

import java.util.Date;

public class UserStory16Test {
    static ManagerRestaurant  managerRestaurant;

    static Restaurant restaurant = new Restaurant();
    //Mettre vraie Date?
    static Creneau creneau = new Creneau(new Date(), new Date());

    static Menu m;


    static Element e1, e2, e3, e4;
    static ChoixElement choixElement1, choixElement2, choixElement3;

    public static void creerElement(){
        e1 = new Element("Ice Tea", 1);
        e2 = new Element("Coca", 1);
        e3 = new Element("Frite", 2);
        e4 = new Element("Burger Cheese", 4);
    }

    public static void creer2ChoixElement(){
        choixElement1 = new ChoixElement("Boisson", 1);
        choixElement1.ajoutElement(e1);
        choixElement1.ajoutElement(e2);
    }

    public static void creer1ChoixElement(){
        choixElement2 = new ChoixElement("Accompagnement", 1);
        choixElement2.ajoutElement(e3);
        choixElement3 = new ChoixElement("Burger", 1);
        choixElement3.ajoutElement(e4);
    }



    @Etantdonnéque("je suis un Manager de Restaurant")
    public void je_suis_un_manager_de_restaurant() {
        managerRestaurant = new ManagerRestaurant("Moi", "Manager", restaurant);
        Assertions.assertNotNull(managerRestaurant);
    }
    @Quand("je cree un menu avec {int} elements")
    public void je_cree_un_menu_avec_elements(Integer int1) {
        m = new Menu(12, "Cheese", creneau);
        Assertions.assertNotNull(m);
    }
    @Quand("je donne {int} choix pour le premier element")
    public void je_donne_choix_pour_le_premier_element(Integer int1) {
        creerElement();
        creer2ChoixElement();
        m.ajouterElement(choixElement1);
        int taille = m.getChoixElementListe().get(0).getElementListe().size();
        Assertions.assertEquals(2, taille);
    }
    @Quand("je donne {int} choix pour les deux autres")
    public void je_donne_choix_pour_les_deux_autres(Integer int1) {
        creer1ChoixElement();
        m.ajouterElement(choixElement2);
        m.ajouterElement(choixElement3);
        int taille2 = m.getChoixElementListe().get(1).getElementListe().size();
        Assertions.assertEquals(1, taille2);
        int taille3 = m.getChoixElementListe().get(2).getElementListe().size();
        Assertions.assertEquals(1, taille3);
    }
    @Quand("je l'ajoute au menu de mon restaurant")
    public void je_l_ajoute_au_menu_de_mon_restaurant() {
        managerRestaurant.ajouterUnMenu(m);
        Assertions.assertEquals(m, managerRestaurant.getRestaurant().getMenus().get(0));
    }
    @Alors("il est possible pour l'utilisateur de choisir un des deux elements pour le premier choix")
    public void il_est_possible_pour_l_utilisateur_de_choisir_un_des_deux_elements_pour_le_premier_choix() {
        int nbDechoix1 = restaurant.getMenus().get(0).getChoixElementListe().get(0).getElementListe().size();
        Assertions.assertEquals(2, nbDechoix1);
    }
    @Alors("il n'est pas possible pour l'utilisateur de choisir pour les deux autres elements")
    public void il_n_est_pas_possible_pour_l_utilisateur_de_choisir_pour_les_deux_autres_elements() {
        int nbDeChoix2 = restaurant.getMenus().get(0).getChoixElementListe().get(1).getElementListe().size();
        Assertions.assertEquals(1, nbDeChoix2);
        int nbDeChoix3 = restaurant.getMenus().get(0).getChoixElementListe().get(2).getElementListe().size();
        Assertions.assertEquals(1, nbDeChoix3);
    }
}
