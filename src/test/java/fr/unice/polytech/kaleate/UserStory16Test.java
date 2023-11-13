package fr.unice.polytech.kaleate;

import io.cucumber.java.fr.*;
import org.junit.jupiter.api.Assertions;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserStory16Test {
    static ManagerRestaurant  managerRestaurant;

    static Restaurant restaurant = new Restaurant();
    //Mettre vraie Date?
    static Creneau creneau = new Creneau(new Date(), new Date());

    static Menu m;


    static Element e1, e2, e3, e4;
    static ChoixElement choixElement1, choixElement2, choixElement3;
    static Composant pain, steak, salade;
    static Composant composantS1, composantS2, composantS3;
    static ChoixComposant choixComposant1, choixComposant2, choixComposant3, choixComposant4;
    static SupplementElement supEl1, supEl2;
    static SupplementComposant supCo1, supCo2;

    static Utilisateur utilisateur;
    static Restaurant restaurant2 = new Restaurant();
    static Menu m2;
    static Menu menuChoisi;
    static Commande commande;

    public static void creerElement(){
        e1 = new Element("Ice Tea");
        e2 = new Element("Coca");
        e3 = new Element("Frite");
        e4 = new Element("Burger Cheese");
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

    public static void creerMenu(){
        m = new Menu(12, "Cheese", creneau);
    }

    public static void creer2ElementsSupplements(){
        supEl1 = new SupplementElement("Glace", 2);
        supEl2 = new SupplementElement("Pomme", 1);
    }

    public static void ajouterChoixElement(Menu m, ChoixElement choixElement){
        m.ajouterElement(choixElement);
    }

    public static void ajouterUnElementSupplement(Menu m, SupplementElement supplementElement){
        m.ajouterElementSupplement(supplementElement);
    }

    public static void creer2ComposantsSupplements(){
        supCo1 = new SupplementComposant("Cheddar", 1);
        supCo2 = new SupplementComposant("Bacon", 2);
    }

    public static void ajouterUnComposantSupplement(Element element, SupplementComposant supplementComposant){
        element.ajoutSupplementComposant(supplementComposant);
    }

    public static void creerMenu2(){
        m2 = new Menu(12, "Cheese", creneau);
    }

    public static void creerMenuDansRestaurant(){
        creerElement();
        creer1ChoixElement();
        creer2ChoixElement();
        creer2ComposantsSupplements();
        creerChoixComposantBurger(e4);
        ajouterUnComposantSupplement(e4, supCo1);
        ajouterUnComposantSupplement(e4, supCo2);
        creerMenu2();
        ajouterChoixElement(m2, choixElement1);
        ajouterChoixElement(m2, choixElement2);
        ajouterChoixElement(m2, choixElement3);
        creer2ElementsSupplements();
        ajouterUnElementSupplement(m2, supEl1);
        ajouterUnElementSupplement(m2, supEl2);
        restaurant2.ajouterMenu(m2);
    }

    public static void creerComposantBurger(){
        pain = new Composant("Pain");
        composantS1 = new Composant("Ketchup");
        composantS2 = new Composant("Moutarde");
        composantS3 = new Composant("Mayonnaise");
        steak = new Composant("Steak");
        salade = new Composant("Salade");
    }

    public static void creerChoixComposantBurger(Element element){
        creerComposantBurger();
        choixComposant1 = new ChoixComposant("Pain", 1);
        choixComposant1.ajoutComposant(pain);
        choixComposant2 = new ChoixComposant("Sauce", 2);
        choixComposant2.ajoutComposant(composantS1);
        choixComposant2.ajoutComposant(composantS2);
        choixComposant2.ajoutComposant(composantS3);
        choixComposant3 = new ChoixComposant("Steak", 1);
        choixComposant3.ajoutComposant(steak);
        choixComposant4 = new ChoixComposant("Salade", 1);
        choixComposant4.ajoutComposant(salade);
        element.ajoutComposant(choixComposant1);
        element.ajoutComposant(choixComposant2);
        element.ajoutComposant(choixComposant3);
        element.ajoutComposant(choixComposant4);
    }



    @Etantdonnéque("je suis un Manager de Restaurant")
    public void je_suis_un_manager_de_restaurant() {
        managerRestaurant = new ManagerRestaurant("Moi", "Manager", restaurant);
        Assertions.assertNotNull(managerRestaurant);
    }
    @Quand("je cree un menu avec {int} elements")
    public void je_cree_un_menu_avec_elements(Integer int1) {
        creerMenu();
        Assertions.assertNotNull(m);
    }
    @Quand("je donne {int} choix pour le premier element")
    public void je_donne_choix_pour_le_premier_element(Integer int1) {
        creerElement();
        creer2ChoixElement();
        ajouterChoixElement(m, choixElement1);
        int taille = m.getChoixElementListe().get(0).getElementListe().size();
        Assertions.assertEquals(2, taille);
    }
    @Quand("je donne {int} choix pour les deux autres")
    public void je_donne_choix_pour_les_deux_autres(Integer int1) {
        creer1ChoixElement();
        ajouterChoixElement(m, choixElement2);
        ajouterChoixElement(m, choixElement3);
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
    @Quand("je cree un menu avec {int} elements supplements")
    public void je_cree_un_menu_avec_supplements(Integer int1) {
        creerMenu();
        creer2ElementsSupplements();
        ajouterUnElementSupplement(m, supEl1);
        ajouterUnElementSupplement(m, supEl2);
        Assertions.assertEquals(2, m.getSupplementElementListe().size());
    }
    @Alors("il est possible pour l'utilisateur de rajouter des elements supplements")
    public void il_est_possible_pour_l_utilisateur_de_rajouter_des_supplements() {
        if(restaurant.getMenus().size() != 2) { managerRestaurant.ajouterUnMenu(m);}
        int nbSupplementPossible = restaurant.getMenus().get(1).getSupplementElementListe().size();
        Assertions.assertEquals(2,nbSupplementPossible);
    }
    @Quand("je cree un menu avec {int} composants supplements pour un element")
    public void je_cree_un_menu_avec_composants_supplements_pour_un_element(Integer int1) {
        creerMenu();
        creer2ComposantsSupplements();
        creerElement();
        ajouterUnComposantSupplement(e4, supCo1);
        ajouterUnComposantSupplement(e4, supCo2);
        creer1ChoixElement();
        creer2ChoixElement();
        ajouterChoixElement(m, choixElement1);
        ajouterChoixElement(m, choixElement2);
        ajouterChoixElement(m, choixElement3);
        int nbSupplements = m.getChoixElementListe().get(2).getElementListe().get(0).getChoixSupplementComposant().size();
        Assertions.assertEquals(2, nbSupplements);

    }
    @Alors("il est possible pour l'utilisateur de rajouter des composants supplements dans cet element")
    public void il_est_possible_pour_l_utilisateur_de_rajouter_des_composants_supplements_dans_cet_element() {
        if(restaurant.getMenus().size() != 3) {
            managerRestaurant.ajouterUnMenu(m);
        }
        if(restaurant.getMenus().size() != 3) {
            managerRestaurant.ajouterUnMenu(m);
        }
        int nbSuppBurger = restaurant.getMenus().get(2).getChoixElementListe().get(2).getElementListe().get(0).getChoixSupplementComposant().size();
        Assertions.assertEquals(2, nbSuppBurger);
    }

    /** PARTIE UTILISATEUR */

    @Etantdonnéque("je suis utilisateur")
    public void je_suis_un_utilisateur() {
        utilisateur = new Utilisateur("nom", "prenom");
        assertNotNull(utilisateur);
    }

    @Quand("Je veux commander un menu {string}")
    public void je_veux_commander_un_menu(String string) {
        creerMenuDansRestaurant();
        menuChoisi = restaurant2.getMenus().getParNom(string);
        Assertions.assertNotNull(menuChoisi);
    }
    @Quand("je veux boire du {string}")
    public void je_veux_boire_du(String string) {
        Element boisson  = menuChoisi.getChoixElementListe().get(0).getElementParNom(string);
        Assertions.assertEquals("Coca", boisson.getNomElement());
        menuChoisi.getChoixElementParNom("Boisson").choisirElement(boisson);
        Element element = menuChoisi.getChoixElementParNom("Boisson").getElementChoisiParNom(string);
        Assertions.assertEquals(string, element.getNomElement());
    }
    @Alors("ma commande contient du {string}")
    public void ma_commande_contient_du(String string) {
        ListeMenus listeMenus = new ListeMenus();
        commande = new Commande(utilisateur, listeMenus, restaurant2);
        utilisateur.setCommandeActuelle(commande);
        utilisateur.addMenu(menuChoisi);
        //Element element = utilisateur.getCommandeActuelle().getMenus().get(0).getChoixElementListe().get(0).getListeChoixElement().get(0);
        Element element = utilisateur.getCommandeActuelle().getMenuParNom("Cheese").getChoixElementParNom("Boisson").getElementChoisiParNom(string);
        Assertions.assertEquals(string, element.getNomElement());
    }
    @Quand("je veux du {string} et de la {string} comme {string} dans mon {string}")
    public void je_veux_du_et_de_la_dans_mon(String string, String string2, String string3, String string4) {
        Composant composant1 = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4).getChoixComposantParNom(string3).getComposantParNom(string);
        Composant composant2 = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4).getChoixComposantParNom(string3).getComposantParNom(string2);
        Assertions.assertEquals("Ketchup", composant1.getNomComposant());
        Assertions.assertEquals("Mayonnaise", composant2.getNomComposant());
        menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4).getChoixComposantParNom(string3).choisirComposant(composant1);
        menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4).getChoixComposantParNom(string3).choisirComposant(composant2);
        int valeur = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4).getChoixComposantParNom(string3).getListeChoixComposant().size();
        Assertions.assertEquals(2, valeur);
        //On vérifie qu'on ne peux pas ajouter un troisième choix
        menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4).getChoixComposantParNom(string3).choisirComposant(composant2);
        int valeur2 = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4).getChoixComposantParNom(string3).getListeChoixComposant().size();
        Assertions.assertEquals(2, valeur2);
    }
    @Alors("mon {string} contient du {string} et de la {string}")
    public void mon_contient_du_et_de_la(String string, String string2, String string3) {
        Composant composant1 = utilisateur.getCommandeActuelle().getMenus().get(0).getChoixElementParNom("Burger").getElementParNom(string).getChoixComposantParNom("Sauce").getComposantChoisiParNom(string2);
        Assertions.assertEquals("Ketchup", composant1.getNomComposant());
        Composant composant2 = utilisateur.getCommandeActuelle().getMenus().get(0).getChoixElementParNom("Burger").getElementParNom(string).getChoixComposantParNom("Sauce").getComposantChoisiParNom(string3);
        Assertions.assertEquals("Mayonnaise", composant2.getNomComposant());
    }
    @Quand("je veux ajouter du {string} dans mon {string} et une {string}")
    public void je_veux_ajouter_du_dans_mon_et_une(String string, String string2, String string3) {
        SupplementComposant supplementComposant = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string2).getSupplementComposantParNom(string);
        Assertions.assertEquals("Bacon", supplementComposant.getNomComposant());
        SupplementElement supplementElement = menuChoisi.getChoixSupplementElementParNom(string3);
        Assertions.assertEquals("Glace", supplementElement.getNomElement());
        menuChoisi.getChoixElementParNom("Burger").getElementParNom(string2).ajoutChoixSupplementSelectionne(supplementComposant);
        SupplementComposant sup = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string2).getSupplementComposantParNom(string);
        Assertions.assertEquals("Bacon", sup.getNomComposant());
        menuChoisi.ajouterElementSupplementSelectionne(supplementElement);
        SupplementElement supEl = menuChoisi.getChoixSupplementElementParNom(string3);
        Assertions.assertEquals("Glace", supEl.getNomElement());
    }
    @Alors("ma commande contient du {string} dans mon {string}")
    public void ma_commande_contient_du_dans_mon(String string, String string2) {
        ListeMenus listeMenus = new ListeMenus();
        commande = new Commande(utilisateur, listeMenus, restaurant2);
        utilisateur.setCommandeActuelle(commande);
        utilisateur.addMenu(menuChoisi);
        SupplementComposant supCo = utilisateur.getCommandeActuelle().getMenus().get(0).getChoixElementParNom("Burger").getElementParNom(string2).getSupplementComposantSelectionneParNom(string);
        Assertions.assertEquals("Bacon", supCo.getNomComposant());
    }

    @Alors("ma commande contient une {string}")
    public void ma_commande_contient_une(String string) {
        SupplementElement supEl = utilisateur.getCommandeActuelle().getMenus().get(0).getSupplementElementListeSelectioneParNom(string);
        Assertions.assertEquals("Glace", supEl.getNomElement());
    }
    @Alors("le prix de ma commande a augmente")
    public void le_prix_de_ma_commande_a_augmente() {
        float prixInitial = utilisateur.getCommandeActuelle().getPrice();
        float prixSupplement = utilisateur.getCommandeActuelle().getPrixAvecSupplement();
        Assertions.assertEquals(12, prixInitial);
        Assertions.assertEquals(14, prixSupplement);
    }


}
