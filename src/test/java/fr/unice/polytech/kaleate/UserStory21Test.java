package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.menu.BuilderContenuMenu;
import fr.unice.polytech.kaleate.menu.ContenuMenu;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.menu.composant.BuilderChoixComposant;
import fr.unice.polytech.kaleate.menu.composant.ChoixComposant;
import fr.unice.polytech.kaleate.menu.composant.Composant;
import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;
import fr.unice.polytech.kaleate.menu.element.*;
import fr.unice.polytech.kaleate.menu.supplement.BuilderChoixSupplementComposant;
import fr.unice.polytech.kaleate.menu.supplement.BuilderChoixSupplementElement;
import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplementComposant;
import fr.unice.polytech.kaleate.menu.supplement.ChoixSupplementElement;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.ManagerRestaurant;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserStory21Test {
    static Utilisateur utilisateur;
    static Menu menuChoisi;

    static Creneau creneau = new Creneau(new Date(), new Date());

    static Restaurant restaurant;
    static ManagerRestaurant managerRestaurant;

    static Composant painBrioche, steak, cheddar, emmental, tomate, mozza;
    static Composant chocolat, vanille, fraise;

    static ChoixComposant pain, viande, fromage;
    static ChoixComposant compositionSalade;
    static ChoixComposant parfum;

    static SupplementComposant supplementChantilly, supplementCoulisChocolat;
    static ChoixSupplementComposant supplementExtraGlace;

    static Element burger, salade, glace;

    static ChoixElement plat, dessert;

    static SupplementElement supplementFrites, supplementPotatoes;
    static ChoixSupplementElement supplementMenu1;

    static ContenuMenu contenuMenu;

    static Menu menu;

    public static void creationDesComposant(){
        painBrioche = new Composant("Pain Brioche");
        steak = new Composant("Steak");
        cheddar = new Composant("Cheddar");
        emmental = new Composant("Emmental");
        tomate = new Composant("Tomate");
        mozza = new Composant("Mozza");
        chocolat = new Composant("Chocolat");
        vanille = new Composant("Vanille");
        fraise = new Composant("Fraise");
    }

    public static void creationDesChoixComposant(){
        ArrayList<Composant> composantPain = new ArrayList<>();
        composantPain.add(painBrioche);
        pain = new BuilderChoixComposant().newChoix("Pain", 1, composantPain);
        ArrayList<Composant> composantViande = new ArrayList<>();
        composantViande.add(steak);
        viande = new BuilderChoixComposant().newChoix("Viande", 1, composantViande);
        ArrayList<Composant> composantFromage = new ArrayList<>();
        composantFromage.add(cheddar);
        composantFromage.add(emmental);
        fromage = new BuilderChoixComposant().newChoix("Fromage", 1, composantFromage);
        ArrayList<Composant> composantSalade = new ArrayList<>();
        composantSalade.add(tomate);
        composantSalade.add(mozza);
        compositionSalade = new BuilderChoixComposant().newChoix("Composition Salade", 2, composantSalade);
        ArrayList<Composant> composantParfum = new ArrayList<>();
        composantParfum.add(chocolat);
        composantParfum.add(vanille);
        composantParfum.add(fraise);
        parfum = new BuilderChoixComposant().newChoix("Parfum", 3, composantParfum);
    }

    public static void creationDesSupplementComposant(){
        supplementChantilly = new SupplementComposant("Chantilly", 1);
        supplementCoulisChocolat = new SupplementComposant("Coulis Chocolat", 2);
    }

    public static void creationDesChoixSupplementComposant(){
        BuilderChoixSupplementComposant builderChoixSupplementComposant = new BuilderChoixSupplementComposant();
        ArrayList<SupplementComposant> supplementsGlace = new ArrayList<>();
        supplementsGlace.add(supplementChantilly);
        supplementsGlace.add(supplementCoulisChocolat);
        builderChoixSupplementComposant.setChoixSupplement(supplementsGlace);
        supplementExtraGlace = (ChoixSupplementComposant) builderChoixSupplementComposant.getResult();
    }

    public static void creationDesElement(){
        BuilderElement builderElementBurger = new BuilderElement("Burger Cheese");
        builderElementBurger.addChoixComposant(pain);
        builderElementBurger.addChoixComposant(viande);
        builderElementBurger.addChoixComposant(fromage);
        burger = builderElementBurger.getResult();
        BuilderElement builderElementSalade = new BuilderElement("Salade");
        builderElementSalade.addChoixComposant(compositionSalade);
        salade = builderElementSalade.getResult();
        BuilderElement builderElementGlace = new BuilderElement("Glace");
        builderElementGlace.addChoixComposant(parfum);
        builderElementGlace.addChoixSupplement(supplementExtraGlace);
        glace = builderElementGlace.getResult();
    }

    public static void creationChoixElement(){
        List<Element> elementsPlat = new ArrayList<>();
        elementsPlat.add(salade);
        elementsPlat.add(burger);
        plat = new BuilderChoixElement().newChoix("Plat", 1, elementsPlat);
        List<Element> elementsDessert = new ArrayList<>();
        elementsDessert.add(glace);
        dessert = new BuilderChoixElement().newChoix("Dessert", 1, elementsDessert);
    }

    public static void creationSupplementElement(){
        BuilderElement builderElementFrite = new BuilderElement("Frite");
        Element elementFrite = builderElementFrite.getResult();
        supplementFrites = new SupplementElement(elementFrite, 2);
        BuilderElement builderElementPotatoes = new BuilderElement("Potatoes");
        Element elementPotatoes = builderElementPotatoes.getResult();
        supplementPotatoes = new SupplementElement(elementPotatoes, 2);
    }

    public static void creationChoixSupplementElement(){
        BuilderChoixSupplementElement builderChoixSupplementElement = new BuilderChoixSupplementElement();
        List<SupplementElement> supplementElements = new ArrayList<>();
        supplementElements.add(supplementFrites);
        supplementElements.add(supplementPotatoes);
        builderChoixSupplementElement.setChoixSupplement(supplementElements);
        supplementMenu1 = (ChoixSupplementElement) builderChoixSupplementElement.getResult();
    }

    public static void creationContenuMenu(){
        BuilderContenuMenu builderContenuMenu = new BuilderContenuMenu();
        builderContenuMenu.addChoixElement(plat);
        builderContenuMenu.addChoixElement(dessert);
        builderContenuMenu.setChoixSupplementElement(supplementMenu1);
        contenuMenu = builderContenuMenu.getResult();
    }

    public static void creerMenu(){
        menu = new Menu(12,"menu1", creneau);
        menu.setContenuMenu(contenuMenu);
    }

    public static void creationRestaurant(){
        creationDesComposant();
        creationDesChoixComposant();
        creationDesSupplementComposant();
        creationDesChoixSupplementComposant();
        creationDesElement();
        creationChoixElement();
        creationSupplementElement();
        creationChoixSupplementElement();
        creationContenuMenu();
        creerMenu();
        restaurant = new Restaurant("restaurant");
        restaurant.ajouterMenu(menu);
    }

    public static void choisir(){
        utilisateur.getCommandeActuelle().getMenuParNom("menu1").getContenuMenu().getChoixElementParNom("Plat").choisir(burger);
        utilisateur.getCommandeActuelle().getMenuParNom("menu1").getContenuMenu().getChoixSupplementElement().selectionnerSupplement(supplementFrites);
        utilisateur.getCommandeActuelle().getMenuParNom("menu1").getContenuMenu().getChoixElementParNom("Dessert").choisir(glace);
        utilisateur.getCommandeActuelle().getMenuParNom("menu1").getContenuMenu().getChoixElementParNom("Dessert").getSelectionneParNom("Glace").getChoixSupplementComposantDispo().selectionnerSupplement(supplementChantilly);
        utilisateur.getCommandeActuelle().getMenuParNom("menu1").getContenuMenu().getChoixElementParNom("Dessert").getSelectionneParNom("Glace").getChoixParNom("Parfum").choisir(vanille);
    }
    @Etantdonnéque("je suis un utilisateur qui commande un menu {string}")
    public void je_suis_un_utilisateur_qui_commande_un_menu(String string) {
        utilisateur = new Utilisateur("utilisateur", "utilisateur");
        Assertions.assertNotNull(utilisateur);
    }
    @Alors("quand j'ajoute ce menu {string} a ma commande")
    public void quand_j_ajoute_ce_menu_a_ma_commande(String string) {
        creationRestaurant();
        menuChoisi = restaurant.getMenus().getParNom(string);
        Assertions.assertNotNull(menuChoisi);
        utilisateur.addMenu(menuChoisi);
        Assertions.assertEquals(1, utilisateur.getCommandeActuelle().getMenus().size());
        Menu menuCommande = restaurant.getMenus().getParNom("menu1");
        Assertions.assertNull(menuCommande);
    }
    @Alors("je choisis {string}, {string}, {string} et {string} pour mon menu {string}")
    public void je_choisis_et_pour_mon_menu(String string, String string2, String string3, String string4, String string5) {
        choisir();
        Element elementChoisiBurger = utilisateur.getCommandeActuelle().getMenuParNom(string5).getContenuMenu()
                .getChoixElementParNom("Plat").getSelectionneParNom("Burger Cheese");
        Assertions.assertNotNull(elementChoisiBurger);
        Element elementChoisiGlace = utilisateur.getCommandeActuelle().getMenuParNom(string5).getContenuMenu()
                .getChoixElementParNom("Dessert").getSelectionneParNom("Glace");
        Assertions.assertNotNull(elementChoisiGlace);
        SupplementElement supplementElementChoisiFrites = utilisateur.getCommandeActuelle().getMenuParNom(string5)
                .getContenuMenu().getChoixSupplementElement().getSupplementSelectionneParNom("Frite");
        Assertions.assertNotNull(supplementElementChoisiFrites);
        SupplementComposant supplementComposantChoisiChantilly = utilisateur.getCommandeActuelle().getMenuParNom(string5)
                .getContenuMenu().getChoixElementParNom("Dessert").getSelectionneParNom("Glace").getSupplementSelectionneParNom("Chantilly");
        Assertions.assertNotNull(supplementComposantChoisiChantilly);
        Composant composantChoisiVanille = utilisateur.getCommandeActuelle().getMenuParNom(string5).getContenuMenu()
                .getChoixElementParNom("Dessert").getSelectionneParNom("Glace")
                .getChoixParNom("Parfum").getSelectionneParNom("Vanille");
        Assertions.assertNotNull(composantChoisiVanille);
    }
    @Quand("je remplace {string} par {string} pour mon choix element {string} dans mon menu {string}")
    public void je_remplace_par_pour_mon_choix_element_dans_mon_menu(String string, String string2, String string3, String string4) {
        utilisateur.getCommandeActuelle().getMenus().getParNom(string4).getContenuMenu().getChoixElementParNom(string3)
                .supprimerElementSelectionneParNom(string);
        Element elementChoisi = utilisateur.getCommandeActuelle().getMenus().getParNom(string4).getContenuMenu()
                .getChoixElementParNom(string3).getParNom(string2);
        utilisateur.getCommandeActuelle().getMenus().getParNom(string4).getContenuMenu().getChoixElementParNom(string3).choisir(elementChoisi);
        Element nouvelElement = utilisateur.getCommandeActuelle().getMenus().getParNom(string4).getContenuMenu()
                .getChoixElementParNom(string3).getSelectionneParNom(string2);
        Assertions.assertNotNull(nouvelElement);
        Assertions.assertEquals(string2, nouvelElement.getNom());
        Element ancienElement = utilisateur.getCommandeActuelle().getMenus().getParNom(string4).getContenuMenu()
                .getChoixElementParNom(string3).getSelectionneParNom(string);
        Assertions.assertNull(ancienElement);
    }

    @Alors("mon menu {string} contient pour le choix element {string} {string}")
    public void mon_menu_contient_pour_le_choix_element(String string, String string2, String string3) {
        Element elementChoisi = utilisateur.getCommandeActuelle().getMenus().getParNom(string).getContenuMenu().getChoixElementParNom(string2)
                .getParNom(string3);
        Assertions.assertNotNull(elementChoisi);
        Assertions.assertEquals(string3, elementChoisi.getNom());
    }

    @Quand("je remplace {string} par {string} pour mon supplement element dans mon menu {string}")
    public void je_remplace_par_pour_mon_supplement_element_dans_mon_menu(String string, String string2, String string3) {
        utilisateur.getCommandeActuelle().getMenus().getParNom(string3).getContenuMenu().getChoixSupplementElement()
                .supprimerSupplementSelectionneParNom(string);
        SupplementElement supplementElementChoisi = utilisateur.getCommandeActuelle().getMenus().getParNom(string3)
                .getContenuMenu().getChoixSupplementElement().getSupplementParNom(string2);
        utilisateur.getCommandeActuelle().getMenus().getParNom(string3).getContenuMenu().getChoixSupplementElement()
                .selectionnerSupplement(supplementElementChoisi);
        SupplementElement nouveauSupplementElement = utilisateur.getCommandeActuelle().getMenus().getParNom(string3)
                .getContenuMenu().getChoixSupplementElement().getSupplementSelectionneParNom(string2);
        Assertions.assertNotNull(nouveauSupplementElement);
        Assertions.assertEquals(string2, nouveauSupplementElement.getNom());
        SupplementElement ancienSupplementElement = utilisateur.getCommandeActuelle().getMenus().getParNom(string3)
                .getContenuMenu().getChoixSupplementElement().getSupplementSelectionneParNom(string);
        Assertions.assertNull(ancienSupplementElement);

    }

    @Alors("mon menu {string} contient pour le supplement element {string}")
    public void mon_menu_contient_pour_le_supplement_element(String string, String string2) {
        SupplementElement supplementElementChoisi = utilisateur.getCommandeActuelle().getMenus().getParNom(string).getContenuMenu().getChoixSupplementElement()
                .getSupplementSelectionneParNom(string2);
        Assertions.assertNotNull(supplementElementChoisi);
        Assertions.assertEquals(string2, supplementElementChoisi.getNom());
    }

    @Quand("je remplace {string} par {string} pour mon choix composant {string} de mon element {string} de mon choix element {string} dans mon menu {string}")
    public void je_remplace_par_pour_mon_choix_composant_de_mon_element_de_mon_choix_element_dans_mon_menu(String string, String string2, String string3, String string4, String string5, String string6) {
        utilisateur.getCommandeActuelle().getMenus().getParNom(string6).getContenuMenu().getChoixElementParNom(string5)
                .getParNom(string4).getChoixParNom(string3).supprimerComposantSelectionneParNom(string);
        Composant composantChoisi = utilisateur.getCommandeActuelle().getMenus().getParNom(string6).getContenuMenu().getChoixElementParNom(string5)
                .getParNom(string4).getChoixParNom(string3).getParNom(string2);
        utilisateur.getCommandeActuelle().getMenus().getParNom(string6).getContenuMenu().getChoixElementParNom(string5).getParNom(string4)
                .getChoixParNom(string3).choisir(composantChoisi);
        Composant nouveauComposant = utilisateur.getCommandeActuelle().getMenus().getParNom(string6).getContenuMenu().getChoixElementParNom(string5)
                .getParNom(string4).getChoixParNom(string3).getSelectionneParNom(string2);
        Assertions.assertNotNull(nouveauComposant);
        Assertions.assertEquals(string2, nouveauComposant.getNom());
        Composant ancienComposant = utilisateur.getCommandeActuelle().getMenus().getParNom(string6).getContenuMenu().getChoixElementParNom(string5)
                .getParNom(string4).getChoixParNom(string3).getSelectionneParNom(string);
        Assertions.assertNull(ancienComposant);
    }

    @Alors("mon menu {string} contient pour le choix composant {string} de mon element {string} de mon choix element {string} {string}")
    public void mon_menu_contient_pour_le_choix_composant_de_mon_element_de_mon_choix_element(String string, String string2, String string3, String string4, String string5) {
        Composant composantChoisi = utilisateur.getCommandeActuelle().getMenus().getParNom(string).getContenuMenu().getChoixElementParNom(string4)
                .getParNom(string3).getChoixParNom(string2).getParNom(string5);
        Assertions.assertNotNull(composantChoisi);
        Assertions.assertEquals(string5, composantChoisi.getNom());
    }

    @Quand("je remplace {string} par {string} pour mon supplement composant de mon element {string} de mon choix element {string} dans mon menu {string}")
    public void je_remplace_par_pour_mon_supplement_composant_de_mon_element_de_mon_choix_element_dans_mon_menu(String string, String string2, String string3, String string4, String string5) {
        utilisateur.getCommandeActuelle().getMenus().getParNom(string5).getContenuMenu().getChoixElementParNom(string4)
                .getParNom(string3).getChoixSupplementComposantDispo().supprimerSupplementSelectionneParNom(string);
        SupplementComposant supplementComposantChoisi = utilisateur.getCommandeActuelle().getMenus().getParNom(string5).getContenuMenu().getChoixElementParNom(string4)
                .getParNom(string3).getChoixSupplementComposantDispo().getSupplementParNom(string2);
        utilisateur.getCommandeActuelle().getMenus().getParNom(string5).getContenuMenu().getChoixElementParNom(string4).getParNom(string3)
                .getChoixSupplementComposantDispo().selectionnerSupplement(supplementComposantChoisi);
        SupplementComposant nouveauSupplementComposant = utilisateur.getCommandeActuelle().getMenus().getParNom(string5).getContenuMenu().getChoixElementParNom(string4)
                .getParNom(string3).getChoixSupplementComposantDispo().getSupplementSelectionneParNom(string2);
        Assertions.assertNotNull(nouveauSupplementComposant);
        Assertions.assertEquals(string2, nouveauSupplementComposant.getNom());
        SupplementComposant ancienSupplementComposant = utilisateur.getCommandeActuelle().getMenus().getParNom(string5).getContenuMenu().getChoixElementParNom(string4)
                .getParNom(string3).getChoixSupplementComposantDispo().getSupplementSelectionneParNom(string);
        Assertions.assertNull(ancienSupplementComposant);
    }

    @Alors("mon menu {string} contient pour le supplement composant de mon element {string} de mon choix element {string} {string}")
    public void mon_menu_contient_pour_le_supplement_composant_de_mon_element_de_mon_choix_element(String string, String string2, String string3, String string4) {
        SupplementComposant supplementComposantChoisi = utilisateur.getCommandeActuelle().getMenus().getParNom(string).getContenuMenu().getChoixElementParNom(string3)
                .getParNom(string2).getChoixSupplementComposantDispo().getSupplementSelectionneParNom(string4);
        Assertions.assertNotNull(supplementComposantChoisi);
        Assertions.assertEquals(string4, supplementComposantChoisi.getNom());
    }


}
