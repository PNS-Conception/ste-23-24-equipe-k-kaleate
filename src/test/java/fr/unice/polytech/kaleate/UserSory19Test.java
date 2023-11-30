package fr.unice.polytech.kaleate;

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

public class UserSory19Test {
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
        elementsPlat.add(burger);
        elementsPlat.add(salade);
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


}
