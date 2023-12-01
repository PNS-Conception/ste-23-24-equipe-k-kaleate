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

public class UserStory20Test {
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

    static SupplementComposant supplementBacon, supplementMayonnaise;
    static ChoixSupplementComposant supplementBurger;

    static Element burger, salade, glace;

    static ChoixElement plat, dessert;

    static SupplementElement supplementFrites;
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
        supplementBacon = new SupplementComposant("Bacon", 2);
        supplementMayonnaise = new SupplementComposant("Mayonnaise", 1);
    }

    public static void creationDesChoixSupplementComposant(){
        BuilderChoixSupplementComposant builderChoixSupplementComposant = new BuilderChoixSupplementComposant();
        ArrayList<SupplementComposant> supplementsBurger = new ArrayList<>();
        supplementsBurger.add(supplementBacon);
        supplementsBurger.add(supplementMayonnaise);
        builderChoixSupplementComposant.setChoixSupplement(supplementsBurger);
        supplementBurger = (ChoixSupplementComposant) builderChoixSupplementComposant.getResult();
    }

    public static void creationDesElement(){
        BuilderElement builderElementBurger = new BuilderElement("Burger Cheese");
        builderElementBurger.addChoixComposant(pain);
        builderElementBurger.addChoixComposant(viande);
        builderElementBurger.addChoixComposant(fromage);
        builderElementBurger.addChoixSupplement(supplementBurger);
        burger = builderElementBurger.getResult();
        BuilderElement builderElementSalade = new BuilderElement("Salade");
        builderElementSalade.addChoixComposant(compositionSalade);
        salade = builderElementSalade.getResult();
        BuilderElement builderElementGlace = new BuilderElement("Glace");
        builderElementGlace.addChoixComposant(parfum);
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
    }

    public static void creationChoixSupplementElement(){
        BuilderChoixSupplementElement builderChoixSupplementElement = new BuilderChoixSupplementElement();
        List<SupplementElement> supplementElements = new ArrayList<>();
        supplementElements.add(supplementFrites);
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
        utilisateur.getCommandeActuelle().getMenuParNom("menu1").getContenuMenu().getChoixElementParNom("Plat").getSelectionneParNom("Burger Cheese").getChoixParNom("Fromage").choisir(emmental);
        utilisateur.getCommandeActuelle().getMenuParNom("menu1").getContenuMenu().getChoixSupplementElement().selectionnerSupplement(supplementFrites);
        utilisateur.getCommandeActuelle().getMenuParNom("menu1").getContenuMenu().getChoixElementParNom("Plat").getSelectionneParNom("Burger Cheese").getChoixSupplementComposantDispo().selectionnerSupplement(supplementBacon);
    }

    @Etantdonnéque("je suis un utilisateur qui est en train de commander le menu {string}")
    public void je_suis_un_utilisateur_qui_est_en_train_de_commander_le_menu(String string) {
        utilisateur = new Utilisateur("utilisateur", "utilisateur");
        Assertions.assertNotNull(utilisateur);
    }
    @Alors("quand j'ajoute mon menu {string} a ma commande")
    public void quand_j_ajoute_mon_menu_a_ma_commande(String string) {
        creationRestaurant();
        menuChoisi = restaurant.getMenus().getParNom(string);
        Assertions.assertNotNull(menuChoisi);
        utilisateur.addMenu(menuChoisi);
        Assertions.assertEquals(1, utilisateur.getCommandeActuelle().getMenus().size());
        Menu menuCommande = restaurant.getMenus().getParNom("menu1");
        Assertions.assertNull(menuCommande);
    }
    @Alors("je choisis {string} {string} {string} et {string} pour mon menu {string}")
    public void je_choisis_et_pour_mon_menu(String string, String string2, String string3, String string4, String string5) {
        choisir();
        Element elementChoisi = utilisateur.getCommandeActuelle().getMenuParNom(string5).getContenuMenu().getChoixElementParNom("Plat").getSelectionneParNom("Burger Cheese");
        Assertions.assertNotNull(elementChoisi);
        Composant composantChoisi = elementChoisi.getChoixParNom("Fromage").getSelectionneParNom("Emmental");
        Assertions.assertNotNull(composantChoisi);
        SupplementComposant supplementComposantChoisi = elementChoisi.getSupplementSelectionneParNom("Bacon");
        Assertions.assertNotNull(supplementComposantChoisi);
        SupplementElement supplementElementChoisi = menuChoisi.getContenuMenu().getChoixSupplementElementParNom("Frite");
        Assertions.assertNotNull(supplementElementChoisi);
    }
    @Quand("je supprime l'element {string} dans mon choix element {string} de mon menu {string}")
    public void je_supprime_l_element_dans_mon_choix_element_de_mon_menu(String string, String string2, String string3) {
        utilisateur.getCommandeActuelle().getMenuParNom(string3).getContenuMenu().getChoixElementParNom(string2).supprimerElementSelectionneParNom(string);
        Element elementChoisi = utilisateur.getCommandeActuelle().getMenuParNom(string3).getChoixElementParNom(string2).getSelectionneParNom(string);
        Assertions.assertNull(elementChoisi);
    }
    @Alors("je ne vois pas l'element {string} dans mon choix element {string} de mon menu {string} de ma commande")
    public void je_ne_vois_pas_l_element_dans_mon_choix_element_de_mon_menu_de_ma_commande(String string, String string2, String string3) {
        Element elementChoisi = utilisateur.getCommandeActuelle().getMenus().getParNom(string3).getContenuMenu().getChoixElementParNom(string2).getSelectionneParNom(string);
        Assertions.assertNull(elementChoisi);
    }
    @Alors("quand je paye ma commande l'element choisi pour le choix element {string} est l'element par defaut soit {string}")
    public void quand_je_paye_ma_commande_l_element_choisi_pour_le_choix_element_est_l_element_par_defaut_soit(String string, String string2) {
        utilisateur.payer();
        Element elementChoisi = utilisateur.getCommandeActuelle().getMenuParNom("menu1").getContenuMenu().getChoixElementParNom(string).getSelectionneParNom(string2);
        Assertions.assertNotNull(elementChoisi);
    }

    @Quand("je supprime l'element {string} dans mon choix composant {string} de mon element {string} dans mon choix element {string} de mon menu {string}")
    public void je_supprime_l_element_dans_mon_choix_composant_de_mon_element_dans_mon_choix_element_de_mon_menu(String string, String string2, String string3, String string4, String string5) {
        utilisateur.getCommandeActuelle().getMenuParNom(string5).getContenuMenu().getChoixElementParNom(string4).getSelectionneParNom(string3).getChoixParNom(string2).supprimerComposantSelectionneParNom(string);
        Composant composantChoisi = utilisateur.getCommandeActuelle().getMenuParNom(string5).getContenuMenu().getChoixElementParNom(string4).getSelectionneParNom(string3).getChoixParNom(string2).getSelectionneParNom(string);
        Assertions.assertNull(composantChoisi);
    }
    @Alors("je ne vois pas l'element {string} dans mon choix composant {string} de mon element {string} dans mon choix element {string} de mon menu {string} de ma commande")
    public void je_ne_vois_pas_l_element_dans_mon_choix_composant_de_mon_element_dans_mon_choix_element_de_mon_menu_de_ma_commande(String string, String string2, String string3, String string4, String string5) {
        Composant composantChoisi = utilisateur.getCommandeActuelle().getMenus().getParNom(string5).getContenuMenu().getChoixElementParNom(string4).getSelectionneParNom(string3).getChoixParNom(string2).getSelectionneParNom(string);
        Assertions.assertNull(composantChoisi);
    }
    @Alors("quand je paye ma commande l'element choisi pour le choix composant {string} de mon element {string} dans mon choix element {string} est l'element par defaut soit {string}")
    public void quand_je_paye_ma_commande_l_element_choisi_pour_le_choix_composant_de_mon_element_dans_mon_choix_element_est_l_element_par_defaut_soit(String string, String string2, String string3, String string4) {
        utilisateur.payer();
        Composant composantChoisi = utilisateur.getCommandeActuelle().getMenuParNom("menu1").getContenuMenu().getChoixElementParNom(string3).getSelectionneParNom(string2).getChoixParNom(string).getSelectionneParNom(string4);
        Assertions.assertNotNull(composantChoisi);
    }
    @Quand("je supprime l'element supplement {string} de mon menu {string}")
    public void je_supprime_l_element_supplement_de_mon_menu(String string, String string2) {
        utilisateur.getCommandeActuelle().getMenuParNom(string2).getContenuMenu().getChoixSupplementElement().supprimerSupplementSelectionneParNom(string);
        SupplementElement supplementElementChoisi = utilisateur.getCommandeActuelle().getMenuParNom(string2).getContenuMenu().getChoixSupplementElement().getSupplementSelectionneParNom(string);
        Assertions.assertNull(supplementElementChoisi);
    }
    @Alors("je ne vois pas l'element supplement {string} de mon menu {string} de ma commande")
    public void je_ne_vois_pas_l_element_supplement_de_mon_menu_de_ma_commande(String string, String string2) {
        SupplementElement supplementElementChoisi = utilisateur.getCommandeActuelle().getMenus().getParNom(string2).getContenuMenu().getChoixSupplementElement().getSupplementSelectionneParNom(string);
        Assertions.assertNull(supplementElementChoisi);
    }

}
