package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.commande.Commandable;
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

import java.util.Date;
import java.util.List;

public class UserStory18_2Test {
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
        pain = new BuilderChoixComposant().newChoix("Pain", 1, List.of(painBrioche));
        viande = new BuilderChoixComposant().newChoix("Viande", 1, List.of(steak));
        fromage = new BuilderChoixComposant().newChoix("Fromage", 1, List.of(cheddar, emmental));
        compositionSalade = new BuilderChoixComposant().newChoix("Composition Salade", 2, List.of(tomate, mozza));
        parfum = new BuilderChoixComposant().newChoix("Parfum", 3, List.of(chocolat, vanille, fraise));
    }

    public static void creationDesSupplementComposant(){
        supplementBacon = new SupplementComposant("Bacon", 2);
        supplementMayonnaise = new SupplementComposant("Mayonnaise", 1);
    }

    public static void creationDesChoixSupplementComposant(){
        BuilderChoixSupplementComposant builderChoixSupplementComposant = new BuilderChoixSupplementComposant();
        builderChoixSupplementComposant.setChoixSupplement(List.of(supplementBacon, supplementMayonnaise));
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
        plat = new BuilderChoixElement().newChoix("Plat", 1, List.of(burger, salade));
        dessert = new BuilderChoixElement().newChoix("Dessert", 1, List.of(glace));
    }

    public static void creationSupplementElement(){
        BuilderElement builderElementFrite = new BuilderElement("Frite");
        Element elementFrite = builderElementFrite.getResult();
        supplementFrites = new SupplementElement(elementFrite, 2);
    }

    public static void creationChoixSupplementElement(){
        BuilderChoixSupplementElement builderChoixSupplementElement = new BuilderChoixSupplementElement();
        builderChoixSupplementElement.setChoixSupplement(List.of(supplementFrites));
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

    /**
     * Initialisation
     */
    @Etantdonnéque("je suis un manager de magasin")
    public void je_suis_un_manager_de_magasin() {
        creationRestaurant();
        managerRestaurant = new ManagerRestaurant(restaurant);
        Assertions.assertNotNull(managerRestaurant);
    }

    /**
     * Scénario : Modifier le nom d'un element
     */

    @Quand("je veux modifier le nom de mon element {string} en {string} dans le choix element {string} de mon menu {string}")
    public void je_veux_modifier_le_nom_de_mon_element_en_dans_le_choix_element_de_mon_menu(String string, String string2, String string3, String string4) {
        ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string4)).getContenuMenu().getChoixElementParNom(string3).getParNom(string).setNom(string2);
        String nouveauNom = ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string4)).getContenuMenu().getChoixElementParNom(string3).getParNom(string2).getNom();
        Assertions.assertEquals(string2, nouveauNom);
    }
    @Alors("le nom de mon element est {string} dans le choix element {string} de mon menu {string}")
    public void le_nom_de_mon_element_est_dans_le_choix_element_de_mon_menu(String string, String string2, String string3) {
        String nouveauNom = ((Menu)restaurant.getMenus(Commandable.class).getParNom(string3)).getContenuMenu().getChoixElementParNom(string2).getParNom(string).getNom();
        Assertions.assertEquals(string, nouveauNom);
    }

    /**
     * Scénario : Modifier le nom d'un composant
     */

    @Quand("je veux modifier le nom de mon composant {string} en {string} dans le choix composant {string} de mon element {string} dans le choix element {string} de mon menu {string}")
    public void je_veux_modifier_le_nom_de_mon_composant_en_dans_le_choix_composant_de_mon_element_dans_le_choix_element_de_mon_menu(String string, String string2, String string3, String string4, String string5, String string6) {
        ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string6)).getContenuMenu().getChoixElementParNom(string5).getParNom(string4).getChoixParNom(string3).getParNom(string).setNom(string2);
        String nouveauNom = ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string6)).getContenuMenu().getChoixElementParNom(string5).getParNom(string4).getChoixParNom(string3).getParNom(string2).getNom();
        Assertions.assertEquals(string2, nouveauNom);
    }
    @Alors("le nom de mon composant est {string} dans le choix composant {string} de mon element {string} dans le choix element {string} de mon menu {string}")
    public void le_nom_de_mon_composant_est_dans_le_choix_composant_de_mon_element_dans_le_choix_element_de_mon_menu(String string, String string2, String string3, String string4, String string5) {
        String nouveauNom = ((Menu)restaurant.getMenus(Commandable.class).getParNom(string5)).getContenuMenu().getChoixElementParNom(string4).getParNom(string3).getChoixParNom(string2).getParNom(string).getNom();
        Assertions.assertEquals(string, nouveauNom);
    }

    /**
     * Scénario : Modifier le nom d'un choix element
     */

    @Quand("je veux modifier le nom de mon choix element {string} en {string} dans mon menu {string}")
    public void je_veux_modifier_le_nom_de_mon_choix_element_en_dans_mon_menu(String string, String string2, String string3) {
        ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string3)).getContenuMenu().getChoixElementParNom(string).setNom(string2);
        String nouveauNom = ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string3)).getContenuMenu().getChoixElementParNom(string2).getNom();
        Assertions.assertEquals(string2, nouveauNom);
    }
    @Alors("le nom de mon choix element est {string} dans mon menu {string}")
    public void le_nom_de_mon_choix_element_est_dans_mon_menu(String string, String string2) {
        String nouveauNom = ((Menu)restaurant.getMenus(Commandable.class).getParNom(string2)).getContenuMenu().getChoixElementParNom(string).getNom();
        Assertions.assertEquals(string, nouveauNom);
    }

    /**
     * Scénario : Modifier le nom d'un choix composant
     */

    @Quand("je veux modifier le nom de mon choix composant {string} en {string} dans mon element {string} de mon choix element {string} de mon menu {string}")
    public void je_veux_modifier_le_nom_de_mon_choix_composant_en_dans_mon_element_de_mon_choix_element_de_mon_menu(String string, String string2, String string3, String string4, String string5) {
        ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string5)).getContenuMenu().getChoixElementParNom(string4).getParNom(string3).getChoixParNom(string).setNom(string2);
        String nouveauNom = ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string5)).getContenuMenu().getChoixElementParNom(string4).getParNom(string3).getChoixParNom(string2).getNom();
        Assertions.assertEquals(string2, nouveauNom);
    }
    @Alors("le nom de mon choix composant est {string} dans mon element {string} de mon choix element {string} de mon menu {string}")
    public void le_nom_de_mon_choix_composant_est_dans_mon_element_de_mon_choix_element_de_mon_menu(String string, String string2, String string3, String string4) {
        String nouveauNom = ((Menu)restaurant.getMenus(Commandable.class).getParNom(string4)).getContenuMenu().getChoixElementParNom(string3).getParNom(string2).getChoixParNom(string).getNom();
        Assertions.assertEquals(string, nouveauNom);
    }

    /**
     * Scénario : Modifier le nombre de choix d'un choix element
     */

    @Quand("je veux modifier le nombre de choix de mon choix element {string} en {int} dans mon menu {string}")
    public void je_veux_modifier_le_nombre_de_choix_de_mon_choix_element_en_dans_mon_menu(String string, Integer int1, String string2) {
        ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string2)).getContenuMenu().getChoixElementParNom(string).setNbChoixPossiblePourUtilisateur(int1);
        Integer nouveauNombre = ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string2)).getContenuMenu().getChoixElementParNom(string).getNbChoixPossiblePourUtilisateur();
        Assertions.assertEquals(int1, nouveauNombre);
    }
    @Alors("le nombre de choix de mon choix element {string} est {int} dans mon menu {string}")
    public void le_nombre_de_choix_de_mon_choix_element_est_dans_mon_menu(String string, Integer int1, String string2) {
        Integer nouveauNombre = ((Menu)restaurant.getMenus(Commandable.class).getParNom(string2)).getContenuMenu().getChoixElementParNom(string).getNbChoixPossiblePourUtilisateur();
        Assertions.assertEquals(int1, nouveauNombre);
    }

    /**
     * Scénario : Modifier le nombre de choix d'un choix composant
     */

    @Quand("je veux modifier le nombre de choix de mon choix composant {string} en {int} dans mon element {string} de mon choix element {string} de mon menu {string}")
    public void je_veux_modifier_le_nombre_de_choix_de_mon_choix_composant_en_dans_mon_element_de_mon_choix_element_de_mon_menu(String string, Integer int1, String string2, String string3, String string4) {
        ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string4)).getContenuMenu().getChoixElementParNom(string3).getParNom(string2).getChoixParNom(string).setNbChoixPossiblePourUtilisateur(int1);
        Integer nouveauNombre = ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string4)).getContenuMenu().getChoixElementParNom(string3).getParNom(string2).getChoixParNom(string).getNbChoixPossiblePourUtilisateur();
        Assertions.assertEquals(int1, nouveauNombre);
    }
    @Alors("le nombre de choix de mon choix composant {string} est {int} dans mon element {string} de mon choix element {string} de mon menu {string}")
    public void le_nombre_de_choix_de_mon_choix_composant_est_dans_mon_element_de_mon_choix_element_de_mon_menu(String string, Integer int1, String string2, String string3, String string4) {
        Integer nouveauNombre = ((Menu)restaurant.getMenus(Commandable.class).getParNom(string4)).getContenuMenu().getChoixElementParNom(string3).getParNom(string2).getChoixParNom(string).getNbChoixPossiblePourUtilisateur();
        Assertions.assertEquals(int1, nouveauNombre);
    }

    /**
     * Scénario : Modifier le nom d'un supplemennt composant
     */

    @Quand("je veux modifier le nom de mon supplement composant {string} en {string} dans mon choix supplement composant de mon element {string} de mon choix element {string} de mon menu {string}")
    public void je_veux_modifier_le_nom_de_mon_supplement_composant_en_dans_mon_choix_supplement_composant_de_mon_element_de_mon_choix_element_de_mon_menu(String string, String string2, String string3, String string4, String string5) {
        ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string5)).getContenuMenu().getChoixElementParNom(string4).getParNom(string3).getSupplementParNom(string).setNom(string2);
        String nouveauNom = ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string5)).getContenuMenu().getChoixElementParNom(string4).getParNom(string3).getSupplementParNom(string2).getNom();
        Assertions.assertEquals(string2, nouveauNom);
    }
    @Alors("le nom de mon supplement composant est {string} dans mon choix supplement composant de mon element {string} de mon choix element {string} de mon menu {string}")
    public void le_nom_de_mon_supplement_composant_est_dans_mon_choix_supplement_composant_de_mon_element_de_mon_choix_element_de_mon_menu(String string, String string2, String string3, String string4) {
        String nouveauNom = ((Menu)restaurant.getMenus(Commandable.class).getParNom(string4)).getContenuMenu().getChoixElementParNom(string3).getParNom(string2).getSupplementParNom(string).getNom();
        Assertions.assertEquals(string, nouveauNom);
    }

    /**
     * Scénario : Modifier le nom d'un supplement element
     */

    @Quand("je veux modifier le nom de mon supplement element {string} en {string} dans mon choix supplement element de mon menu {string}")
    public void je_veux_modifier_le_nom_de_mon_supplement_element_en_dans_mon_choix_supplement_element_de_mon_menu(String string, String string2, String string3) {
        ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string3)).getContenuMenu().getChoixSupplementElementParNom(string).setNom(string2);
        String nouveauNom = ((Menu)managerRestaurant.getRestaurant().getMenus(Commandable.class).getParNom(string3)).getContenuMenu().getChoixSupplementElementParNom(string2).getNom();
        Assertions.assertEquals(string2, nouveauNom);
    }
    @Alors("le nom de mon supplement element est {string} dans mon choix supplement element de mon menu {string}")
    public void le_nom_de_mon_supplement_element_est_dans_mon_choix_supplement_element_de_mon_menu(String string, String string2) {
        String nouveauNom = ((Menu)restaurant.getMenus(Commandable.class).getParNom(string2)).getContenuMenu().getChoixSupplementElementParNom(string).getNom();
        Assertions.assertEquals(string, nouveauNom);
    }
}
