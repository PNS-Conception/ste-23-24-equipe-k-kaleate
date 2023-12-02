package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.builder.BuilderMenu;
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
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Lorsque;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Date;

public class UserStory22Test {

    static Utilisateur utilisateur;
    static Restaurant restaurant1, restaurant2;

    static Creneau creneau1, creneau2, creneau3;

    static Menu menu1, menu2, menu3;
    static ContenuMenu contenuMenu1, contenuMenu2, contenuMenu3;

    static Composant vanille, chocolat;
    static ChoixComposant parfum;
    static SupplementComposant chantilly;
    static ChoixSupplementComposant choixSupplementComposant;

    static Element glace, crepe;
    static ChoixElement dessert;
    static SupplementElement chocolatChaud;
    static ChoixSupplementElement choixSupplementElement;

    static void creerComposants() {
        vanille = new Composant("Vanille");
        chocolat = new Composant("Chocolat");
        ArrayList<Composant> composants = new ArrayList<>();
        composants.add(vanille);
        composants.add(chocolat);
        parfum = new BuilderChoixComposant().newChoix("Parfum", 2, composants);
    }

    static void creerSupplementComposant() {
        chantilly = new SupplementComposant("Chantilly", 1);
        BuilderChoixSupplementComposant builderChoixSupplementComposant = new BuilderChoixSupplementComposant();
        ArrayList<SupplementComposant> supplementComposants = new ArrayList<>();
        supplementComposants.add(chantilly);
        builderChoixSupplementComposant.setChoixSupplement(supplementComposants);
        choixSupplementComposant = (ChoixSupplementComposant) builderChoixSupplementComposant.getResult();
    }

    static void creerElements(){
        BuilderElement builderElementGlace = new BuilderElement("Glace");
        builderElementGlace.addChoixComposant(parfum);
        builderElementGlace.addChoixSupplement(choixSupplementComposant);
        glace = builderElementGlace.getResult();
        BuilderElement builderElementCrepe = new BuilderElement("Crepe");
        crepe = builderElementCrepe.getResult();
    }

    static void creerChoixElement() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(glace);
        elements.add(crepe);
        dessert = new BuilderChoixElement().newChoix("Dessert", 1, elements);
    }

    static void creerSupplementElement() {
        BuilderElement builderElementChocolatChaud = new BuilderElement("Chocolat Chaud");
        Element chocolatChaudElement = builderElementChocolatChaud.getResult();
        chocolatChaud = new SupplementElement(chocolatChaudElement, 3);
        BuilderChoixSupplementElement builderChoixSupplementElement = new BuilderChoixSupplementElement();
        ArrayList<SupplementElement> supplementElements = new ArrayList<>();
        supplementElements.add(chocolatChaud);
        builderChoixSupplementElement.setChoixSupplement(supplementElements);
        choixSupplementElement = builderChoixSupplementElement.getResult();
    }

    static void creerContenuMenu(){
        BuilderContenuMenu builderContenuMenu1 = new BuilderContenuMenu();
        builderContenuMenu1.addChoixElement(dessert);
        builderContenuMenu1.setChoixSupplementElement(choixSupplementElement);
        contenuMenu1 = builderContenuMenu1.getResult();
        BuilderContenuMenu builderContenuMenu2 = new BuilderContenuMenu();
        builderContenuMenu2.addChoixElement(dessert);
        builderContenuMenu2.setChoixSupplementElement(choixSupplementElement);
        contenuMenu2 = builderContenuMenu2.getResult();
        BuilderContenuMenu builderContenuMenu3 = new BuilderContenuMenu();
        builderContenuMenu3.addChoixElement(dessert);
        builderContenuMenu3.setChoixSupplementElement(choixSupplementElement);
        contenuMenu3 = builderContenuMenu3.getResult();
    }

    static void creerMenus(){
        menu1 = new Menu(10, "menu1", creneau1);
        menu1.setContenuMenu(contenuMenu1);
        menu2 = new Menu(8, "menu2", creneau2);
        menu2.setContenuMenu(contenuMenu2);
        menu3 = new Menu(12, "menu3", creneau3);
        menu3.setContenuMenu(contenuMenu3);
    }

    static void creerRestaurant(){
        creerComposants();
        creerSupplementComposant();
        creerComposants();
        creerElements();
        creerChoixElement();
        creerSupplementElement();
        creerContenuMenu();
        creerMenus();
        restaurant1 = new Restaurant("Restaurant1");
        restaurant2 = new Restaurant("Restaurant2");
        restaurant1.ajouterMenu(menu1);
        restaurant1.ajouterMenu(menu2);
        restaurant2.ajouterMenu(menu3);
    }

    static void debutCommande(){
        creerRestaurant();
        utilisateur.addMenu(menu1);
        utilisateur.addMenu(menu2);
        utilisateur.addMenu(menu3);
        utilisateur.getCommandeActuelle().getMenus().getParNom("menu1").getContenuMenu().getChoixElementParNom("Dessert").choisir(glace);
        utilisateur.getCommandeActuelle().getMenus().getParNom("menu2").getContenuMenu().getChoixSupplementElement().selectionnerSupplement(chocolatChaud);
        utilisateur.getCommandeActuelle().getMenus().getParNom("menu1").getContenuMenu().getChoixElementParNom("Dessert").getSelectionneParNom("Glace").getChoixSupplementComposantDispo().selectionnerSupplement(chantilly);
        utilisateur.getCommandeActuelle().getMenus().getParNom("menu1").getContenuMenu().getChoixElementParNom("Dessert").getSelectionneParNom("Glace").getChoixParNom("Parfum").choisir(vanille);
        utilisateur.getCommandeActuelle().getMenus().getParNom("menu3").getContenuMenu().getChoixElementParNom("Dessert").choisir(glace);
        utilisateur.getCommandeActuelle().getMenus().getParNom("menu3").getContenuMenu().getChoixElementParNom("Dessert").getSelectionneParNom("Glace").getChoixParNom("Parfum").choisir(vanille);
        utilisateur.getCommandeActuelle().getMenus().getParNom("menu3").getContenuMenu().getChoixElementParNom("Dessert").getSelectionneParNom("Glace").getChoixParNom("Parfum").choisir(chocolat);
    }

    static boolean restaurantContientMenu(Restaurant restaurant, Menu menu){
        for(Menu menuRestaurant : restaurant.getMenus()){
            if(menuRestaurant.equals(menu)){
                return true;
            }
        }
        return false;
    }

    static boolean menuReinitialise(Restaurant restaurant){
        System.out.println(restaurant.getName());
        for(Menu m : restaurant.getMenus()){
            if(m.getContenuMenu().getSupplementElementListeSelectionne().size() != 0){
                return false;
            }
            for (ChoixElement choixElement : m.getContenuMenu().getChoixElementListe()) {
                if(choixElement.getListeSelectionne().size() != 0){
                    return false;
                }
                for(Element e : choixElement.getListe()){
                    if(e.getChoixSupplementComposantDispo().getSupplementsSelectionnes().size() != 0){
                        return false;
                    }
                    for (ChoixComposant choixComposant : e.getChoixComposantListeUtilisation()) {
                        if(choixComposant.getListeSelectionne().size() != 0){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
