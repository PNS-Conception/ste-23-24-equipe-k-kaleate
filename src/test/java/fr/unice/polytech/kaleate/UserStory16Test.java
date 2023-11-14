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
    static SupplementComposant supCo1, supCo2, supCo3;

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

    public static void creer1ChoixElement(String nomChoixEl1, String nomChoixEl2){
        choixElement2 = new ChoixElement(nomChoixEl1, 1);
        choixElement2.ajoutElement(e3);
        choixElement3 = new ChoixElement(nomChoixEl2, 1);
        choixElement3.ajoutElement(e4);
    }

    public static void creerMenu(String nomMenu){
        m = new Menu(12, nomMenu, creneau);
    }

    public static void creer2ElementsSupplements(String glace, String pomme){
        supEl1 = new SupplementElement(glace, 2);
        supEl2 = new SupplementElement(pomme, 1);
    }

    public static void ajouterChoixElement(Menu m, ChoixElement choixElement){
        m.ajouterChoixElement(choixElement);
    }

    public static void ajouterUnElementSupplement(Menu m, SupplementElement supplementElement){
        m.ajouterElementSupplement(supplementElement);
    }

    public static void creer2ComposantsSupplements(String cheddar, String Bacon){
        supCo1 = new SupplementComposant(cheddar, 1);
        supCo2 = new SupplementComposant(Bacon, 2);
    }

    public static void ajouterUnComposantSupplement(Element element, SupplementComposant supplementComposant){
        element.ajoutSupplementComposant(supplementComposant);
    }

    public static void creerMenu2(){
        m2 = new Menu(12, "Cheese", creneau);
    }

    public static void creerMenuDansRestaurant(){
        creerElement();
        creer1ChoixElement("Accompagnement", "Burger");
        creer2ChoixElement();
        creer2ComposantsSupplements("Cheddar", "Bacon");
        creerChoixComposantBurger(e4);
        ajouterUnComposantSupplement(e4, supCo1);
        ajouterUnComposantSupplement(e4, supCo2);
        creerMenu2();
        ajouterChoixElement(m2, choixElement1);
        ajouterChoixElement(m2, choixElement2);
        ajouterChoixElement(m2, choixElement3);
        creer2ElementsSupplements("Glace", "pomme");
        creerCacahuetesDansGlace();
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

    public static void creerCacahuetesDansGlace(){
        supCo3 = new SupplementComposant("Cacahuetes", 1);
        supEl1.ajoutSupplementComposant(supCo3);
    }

    public static void creerComposantSauce(String nom1, String nom2, String nom3){
        composantS1 = new Composant(nom1);
        composantS2 = new Composant(nom2);
        composantS3 = new Composant(nom3);
    }

    public void creerChoixComposantPourFrites(String nomComposant){
        choixComposant2 = new ChoixComposant(nomComposant, 2);
        choixComposant2.ajoutComposant(composantS1);
        choixComposant2.ajoutComposant(composantS2);
        choixComposant2.ajoutComposant(composantS3);
        choixComposant3 = new ChoixComposant("Frite", 1);
        choixComposant3.ajoutComposant(new Composant("Frite"));
    }


    @Etantdonnéque("je suis un Manager de Restaurant")
    public void je_suis_un_manager_de_restaurant() {
        managerRestaurant = new ManagerRestaurant("Moi", "Manager", restaurant);
        Assertions.assertNotNull(managerRestaurant);
    }
    @Quand("je cree un menu {string}")
    public void je_cree_un_menu(String string) {
        creerMenu(string);
        Assertions.assertNotNull(m);
    }
    @Quand("je donne le choix entre {string} et {string} pour la {string}")
    public void je_donne_le_choix_entr_et_pour_la(String string, String string2, String string3) {
        creerElement();
        creer2ChoixElement();
        ajouterChoixElement(m, choixElement1);
        int taille = m.getChoixElementParNom(string3).getElementListe().size();
        Assertions.assertEquals(2, taille);
    }
    @Quand("je donne des {string} en {string} et un {string} en {string}")
    public void je_donne_des_en_et_un_en(String string, String string2, String string3, String string4) {
        creer1ChoixElement(string2, string4);
        ajouterChoixElement(m, choixElement2);
        ajouterChoixElement(m, choixElement3);
        int taille2 = m.getChoixElementParNom(string2).getElementListe().size();
        Assertions.assertEquals(1, taille2);
        Element frite = m.getChoixElementParNom(string2).getElementParNom(string);
        Assertions.assertEquals(string, frite.getNomElement());
        int taille3 = m.getChoixElementParNom(string4).getElementListe().size();
        Assertions.assertEquals(1, taille3);
        Element burger = m.getChoixElementParNom(string4).getElementParNom(string3);
        Assertions.assertEquals(string3, burger.getNomElement());
    }
    @Quand("je laisse le choix de la {string} pour les {string} entre {string}  {string} et {string}")
    public void je_laisse_le_choix_de_la_pour_les_entre_et(String string, String string2, String string3, String string4, String string5) {
        creerComposantSauce(string3, string4, string5);
        creerChoixComposantPourFrites(string);
        m.getChoixElementParNom("Accompagnement").getElementParNom(string2).ajoutComposant(choixComposant3);
        m.getChoixElementParNom("Accompagnement").getElementParNom("Frite").ajoutComposant(choixComposant2);
        int taille = m.getChoixElementParNom("Accompagnement").getElementParNom(string2).getChoixComposantListe().size();
        Assertions.assertEquals(2, taille);
        int tailleChoixSauce = m.getChoixElementParNom("Accompagnement").getElementParNom(string2)
                .getChoixComposantParNom(string).getComposantListe().size();
        Assertions.assertEquals(3, tailleChoixSauce);
        Composant sauce1 = m.getChoixElementParNom("Accompagnement").getElementParNom(string2)
                .getChoixComposantParNom(string).getComposantParNom(string3);
        Assertions.assertEquals("Ketchup", sauce1.getNomComposant());
        Composant sauce2 = m.getChoixElementParNom("Accompagnement").getElementParNom(string2)
                .getChoixComposantParNom(string).getComposantParNom(string4);
        Assertions.assertEquals("Moutarde", sauce2.getNomComposant());
        Composant sauce3 = m.getChoixElementParNom("Accompagnement").getElementParNom(string2)
                .getChoixComposantParNom(string).getComposantParNom(string5);
        Assertions.assertEquals("Mayonnaise", sauce3.getNomComposant());
    }
    @Quand("j'ajoute {string} au menu de mon restaurant")
    public void j_ajoute_au_menu_de_mon_restaurant(String string) {
        managerRestaurant.ajouterUnMenu(m);
        Assertions.assertEquals(m, managerRestaurant.getRestaurant().getMenus().getParNom(string));
    }
    @Alors("il est possible pour l'utilisateur de choisir entre {string} et {string} pour la {string}")
    public void il_est_possible_pour_l_utilisateur_de_choisir_entre_et_pour_la(String string, String string2, String string3) {
        int nbDechoix1 = restaurant.getMenus().getParNom("Cheese1").getChoixElementParNom(string3).getElementListe().size();
        Assertions.assertEquals(2, nbDechoix1);
        Element coca = restaurant.getMenus().getParNom("Cheese1").getChoixElementParNom(string3).getElementParNom(string);
        Assertions.assertEquals(string, coca.getNomElement());
        Element iceTea = restaurant.getMenus().getParNom("Cheese1").getChoixElementParNom(string3).getElementParNom(string2);
        Assertions.assertEquals(string2, iceTea.getNomElement());
    }
    @Alors("il n'est pas possible pour l'utilisateur de choisir pour l'{string} et le {string}")
    public void il_n_est_pas_possible_pour_l_utilisateur_de_choisir_pour_l_et_le(String string, String string2) {
        int nbDeChoix2 = restaurant.getMenus().getParNom("Cheese1").getChoixElementParNom(string).getElementListe().size();
        Assertions.assertEquals(1, nbDeChoix2);
        int nbDeChoix3 = restaurant.getMenus().getParNom("Cheese1").getChoixElementParNom(string2).getElementListe().size();
        Assertions.assertEquals(1, nbDeChoix3);
    }
    @Alors("l'utilisateur peut choisir {int} {string} entre {string}  {string} et {string}")
    public void l_utilisateur_peut_choisir_entre_et(Integer int1, String string, String string2, String string3, String string4) {
        int nbChoixMax = restaurant.getMenus().getParNom("Cheese1").getChoixElementParNom("Accompagnement")
                .getElementParNom("Frite").getChoixComposantParNom(string).getNbChoixComposantMax();
        Assertions.assertEquals(2, nbChoixMax);
        int nbChoixSauce = restaurant.getMenus().getParNom("Cheese1").getChoixElementParNom("Accompagnement")
                .getElementParNom("Frite").getChoixComposantParNom(string).getComposantListe().size();
        Assertions.assertEquals(3, nbChoixSauce);

    }

    @Quand("j'ajoute {int} elements supplements {string} et {string}")
    public void j_ajoute_elements_supplements_et(Integer int1, String string, String string2) {
        creer2ElementsSupplements(string, string2);
        ajouterUnElementSupplement(m, supEl1);
        ajouterUnElementSupplement(m, supEl2);
        Assertions.assertEquals(int1, m.getSupplementElementListe().size());
        SupplementElement supEl = m.getChoixSupplementElementParNom(string);
        Assertions.assertEquals(string, supEl.getNomElement());
        SupplementElement supEl2 = m.getChoixSupplementElementParNom(string2);
        Assertions.assertEquals(string2, supEl2.getNomElement());
    }
    @Alors("il est possible pour l'utilisateur de rajouter une {string} et une {string}")
    public void il_est_possible_pour_l_utilisateur_de_rajouter_une_et_une(String string, String string2) {
        if(restaurant.getMenus().size() != 2) { managerRestaurant.ajouterUnMenu(m);}
        int nbSupplementPossible = restaurant.getMenus().get(1).getSupplementElementListe().size();
        Assertions.assertEquals(2,nbSupplementPossible);
    }
    @Quand("j'ajoute {int} composants supplements {string} et {string} pour le {string}")
    public void j_ajoute_composants_supplements_et_pour_le(Integer int1, String string, String string2, String string3) {
        creer2ComposantsSupplements(string, string2);
        creerElement();
        ajouterUnComposantSupplement(e4, supCo1);
        ajouterUnComposantSupplement(e4, supCo2);
        creer1ChoixElement("Accompagnement", "Burger");
        creer2ChoixElement();
        ajouterChoixElement(m, choixElement1);
        ajouterChoixElement(m, choixElement2);
        ajouterChoixElement(m, choixElement3);
        int nbSupplements = m.getChoixElementListe().get(2).getElementListe().get(0).getChoixSupplementComposant().size();
        Assertions.assertEquals(2, nbSupplements);

    }
    @Alors("il est possible pour l'utilisateur de rajouter du {string} et du {string} dans le {string} du menu {string}")
    public void il_est_possible_pour_l_utilisateur_de_rajouter_du_et_du_dans_le_menu(String string, String string2, String string3, String string4) {
        int nbSuppBurger = restaurant.getMenus().getParNom(string4).getChoixElementParNom("Burger")
                .getElementParNom(string3).getChoixSupplementComposant().size();
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
        Element element = menuChoisi.getChoixElementParNom("Boisson").getElementSelectioneParNom(string);
        Assertions.assertEquals(string, element.getNomElement());
    }
    @Alors("ma commande contient du {string}")
    public void ma_commande_contient_du(String string) {
        ListeMenus listeMenus = new ListeMenus();
        commande = new Commande(utilisateur, listeMenus, restaurant2);
        utilisateur.setCommandeActuelle(commande);
        utilisateur.addMenu(menuChoisi);
        Element element = utilisateur.getCommandeActuelle().getMenuParNom("Cheese")
                .getChoixElementParNom("Boisson").getElementSelectioneParNom(string);
        Assertions.assertEquals(string, element.getNomElement());
    }
    @Quand("je veux du {string} et de la {string} comme {string} dans mon {string}")
    public void je_veux_du_et_de_la_dans_mon(String string, String string2, String string3, String string4) {
        Composant composant1 = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4)
                .getChoixComposantParNom(string3).getComposantParNom(string);
        Composant composant2 = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4)
                .getChoixComposantParNom(string3).getComposantParNom(string2);
        Assertions.assertEquals("Ketchup", composant1.getNomComposant());
        Assertions.assertEquals("Mayonnaise", composant2.getNomComposant());
        menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4).getChoixComposantParNom(string3)
                .choisirComposant(composant1);
        menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4).getChoixComposantParNom(string3)
                .choisirComposant(composant2);
        int valeur = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4)
                .getChoixComposantParNom(string3).getListeComposantSelectionne().size();
        Assertions.assertEquals(2, valeur);
        //On vérifie qu'on ne peux pas ajouter un troisième choix
        menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4).getChoixComposantParNom(string3)
                .choisirComposant(composant2);
        int valeur2 = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string4)
                .getChoixComposantParNom(string3).getListeComposantSelectionne().size();
        Assertions.assertEquals(2, valeur2);
    }
    @Alors("mon {string} contient du {string} et de la {string}")
    public void mon_contient_du_et_de_la(String string, String string2, String string3) {
        Composant composant1 = utilisateur.getCommandeActuelle().getMenus().get(0).getChoixElementParNom("Burger")
                .getElementParNom(string).getChoixComposantParNom("Sauce").getComposantSelectionneParNom(string2);
        Assertions.assertEquals("Ketchup", composant1.getNomComposant());
        Composant composant2 = utilisateur.getCommandeActuelle().getMenus().get(0).getChoixElementParNom("Burger")
                .getElementParNom(string).getChoixComposantParNom("Sauce").getComposantSelectionneParNom(string3);
        Assertions.assertEquals("Mayonnaise", composant2.getNomComposant());
        m2.resetMenu();
        utilisateur.getCommandeActuelle().getMenus().get(0).resetMenu();
        restaurant2.getMenus().getParNom("Cheese").resetMenu();
    }
    @Quand("je veux ajouter du {string} dans mon {string} et une {string} avec des {string}")
    public void je_veux_ajouter_du_dans_mon_et_une_avec_des(String string, String string2, String string3, String string4) {
        SupplementComposant supplementComposant = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string2)
                .getSupplementComposantParNom(string);
        Assertions.assertEquals("Bacon", supplementComposant.getNomComposant());
        SupplementElement supplementElement = menuChoisi.getChoixSupplementElementParNom(string3);
        Assertions.assertEquals("Glace", supplementElement.getNomElement());
        menuChoisi.getChoixElementParNom("Burger").getElementParNom(string2).ajoutChoixSupplementSelectionne(supplementComposant);
        SupplementComposant sup = menuChoisi.getChoixElementParNom("Burger").getElementParNom(string2)
                .getSupplementComposantParNom(string);
        Assertions.assertEquals("Bacon", sup.getNomComposant());
        menuChoisi.ajouterElementSupplementSelectionne(supplementElement);
        SupplementElement supEl = menuChoisi.getChoixSupplementElementParNom(string3);
        Assertions.assertEquals("Glace", supEl.getNomElement());
        SupplementComposant supC = menuChoisi.getChoixSupplementElementParNom(string3).getSupplementComposantParNom(string4);
        Assertions.assertEquals("Cacahuetes", supC.getNomComposant());
        menuChoisi.getChoixSupplementElementParNom(string3).ajoutChoixSupplementSelectionne(supC);
        SupplementComposant supC2 = menuChoisi.getChoixSupplementElementParNom(string3).getSupplementComposantParNom(string4);
        Assertions.assertEquals("Cacahuetes", supC2.getNomComposant());

    }
    @Alors("ma commande contient du {string} dans mon {string}")
    public void ma_commande_contient_du_dans_mon(String string, String string2) {
        ListeMenus listeMenus = new ListeMenus();
        commande = new Commande(utilisateur, listeMenus, restaurant2);
        utilisateur.setCommandeActuelle(commande);
        utilisateur.addMenu(menuChoisi);
        SupplementComposant supCo = utilisateur.getCommandeActuelle().getMenus().get(0).getChoixElementParNom("Burger")
                .getElementParNom(string2).getSupplementComposantSelectionneParNom(string);
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
        Assertions.assertEquals(15, prixSupplement);
        m2.resetMenu();
        utilisateur.getCommandeActuelle().getMenus().get(0).resetMenu();
        restaurant2.getMenus().getParNom("Cheese").resetMenu();
    }


}
