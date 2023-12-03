
package fr.unice.polytech.kaleate;

import fr.unice.polytech.kaleate.campus.Utilisateur;

import fr.unice.polytech.kaleate.commande.CommandeSimple;
import fr.unice.polytech.kaleate.menu.*;
import fr.unice.polytech.kaleate.menu.composant.ChoixComposant;
import fr.unice.polytech.kaleate.menu.composant.Composant;
import fr.unice.polytech.kaleate.menu.element.ChoixElement;
import fr.unice.polytech.kaleate.menu.element.Element;
import fr.unice.polytech.kaleate.menu.composant.SupplementComposant;
import fr.unice.polytech.kaleate.menu.element.SupplementElement;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.ManagerRestaurant;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import io.cucumber.java.fr.*;
import org.junit.jupiter.api.Assertions;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

public class UserStory16Test {
    static ManagerRestaurant managerRestaurant;

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
    static Restaurant restaurant2 ;
    static Menu m2;
    static Menu menuChoisi = new Menu();
    static CommandeSimple commande;

    public static void creerElement(){
        e1 = new Element("Ice Tea");
        e2 = new Element("Coca");
        e3 = new Element("Frite");
        e4 = new Element("Burger Cheese");
    }

    public static void creer2ChoixElement(){
        choixElement1 = new ChoixElement("Boisson", 1);
        choixElement1.ajout(e1);
        choixElement1.ajout(e2);
    }

    public static void creer1ChoixElement(String nomChoixEl1, String nomChoixEl2){
        choixElement2 = new ChoixElement(nomChoixEl1, 1);
        choixElement2.ajout(e3);
        choixElement3 = new ChoixElement(nomChoixEl2, 1);
        choixElement3.ajout(e4);
    }

    public static void creerMenu(String nomMenu){
        m = new Menu(12, nomMenu, creneau);
    }

    public static void creer2ElementsSupplements(String glace, String pomme){
        supEl1 = new SupplementElement(glace, 2);
        supEl2 = new SupplementElement(pomme, 1);
    }

    public static void ajouterChoixElement(Menu m, ChoixElement choixElement){

        m.getContenuMenu().ajouterChoixElement(choixElement);
    }

    public static void ajouterUnElementSupplement(Menu m, SupplementElement supplementElement){
        m.getContenuMenu().ajouterElementSupplement(supplementElement);
    }

    public static void creer2ComposantsSupplements(String cheddar, String Bacon){
        supCo1 = new SupplementComposant(cheddar, 1);
        supCo2 = new SupplementComposant(Bacon, 2);
    }

    public static void ajouterUnComposantSupplement(Element element, SupplementComposant supplementComposant){
        element.ajoutSupplement(supplementComposant);
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
        restaurant2 = new Restaurant();
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
        choixComposant1.ajout(pain);
        choixComposant2 = new ChoixComposant("Sauce", 2);
        choixComposant2.ajout(composantS1);
        choixComposant2.ajout(composantS2);
        choixComposant2.ajout(composantS3);
        choixComposant3 = new ChoixComposant("Steak", 1);
        choixComposant3.ajout(steak);
        choixComposant4 = new ChoixComposant("Salade", 1);
        choixComposant4.ajout(salade);
        element.ajoutChoixComposant(choixComposant1);
        element.ajoutChoixComposant(choixComposant2);
        element.ajoutChoixComposant(choixComposant3);
        element.ajoutChoixComposant(choixComposant4);
    }

    public static void creerCacahuetesDansGlace(){
        supCo3 = new SupplementComposant("Cacahuetes", 1);
        supEl1.ajouterSupplementComposant(supCo3);
    }

    public static void creerComposantSauce(String nom1, String nom2, String nom3){
        composantS1 = new Composant(nom1);
        composantS2 = new Composant(nom2);
        composantS3 = new Composant(nom3);
    }

    public void creerChoixComposantPourFrites(String nomComposant){
        choixComposant2 = new ChoixComposant(nomComposant, 2);
        choixComposant2.ajout(composantS1);
        choixComposant2.ajout(composantS2);
        choixComposant2.ajout(composantS3);
        choixComposant3 = new ChoixComposant("Frite", 1);
        choixComposant3.ajout(new Composant("Frite"));
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
        int taille = m.getChoixElementParNom(string3).getListe().size();
        Assertions.assertEquals(2, taille);
    }
    @Quand("je donne des {string} en {string} et un {string} en {string}")
    public void je_donne_des_en_et_un_en(String string, String string2, String string3, String string4) {
        creer1ChoixElement(string2, string4);
        ajouterChoixElement(m, choixElement2);
        ajouterChoixElement(m, choixElement3);
        int taille2 = m.getChoixElementParNom(string2).getListe().size();
        Assertions.assertEquals(1, taille2);
        Element frite = m.getChoixElementParNom(string2).getParNom(string);
        Assertions.assertEquals(string, frite.getNom());
        int taille3 = m.getChoixElementParNom(string4).getListe().size();
        Assertions.assertEquals(1, taille3);
        Element burger = m.getChoixElementParNom(string4).getParNom(string3);
        Assertions.assertEquals(string3, burger.getNom());
    }
    @Quand("je laisse le choix de la {string} pour les {string} entre {string}  {string} et {string}")
    public void je_laisse_le_choix_de_la_pour_les_entre_et(String string, String string2, String string3, String string4, String string5) {
        creerComposantSauce(string3, string4, string5);
        creerChoixComposantPourFrites(string);
        m.getChoixElementParNom("Accompagnement").getParNom(string2).ajoutChoixComposant(choixComposant3);
        m.getChoixElementParNom("Accompagnement").getParNom("Frite").ajoutChoixComposant(choixComposant2);
        int taille = m.getChoixElementParNom("Accompagnement").getParNom(string2).getChoixComposantListeUtilisation().size();
        Assertions.assertEquals(2, taille);
        int tailleChoixSauce = m.getChoixElementParNom("Accompagnement").getParNom(string2)
                .getChoixParNom(string).getListe().size();
        Assertions.assertEquals(3, tailleChoixSauce);
        Composant sauce1 = m.getChoixElementParNom("Accompagnement").getParNom(string2)
                .getChoixParNom(string).getParNom(string3);
        Assertions.assertEquals("Ketchup", sauce1.getNom());
        Composant sauce2 = m.getChoixElementParNom("Accompagnement").getParNom(string2)
                .getChoixParNom(string).getParNom(string4);
        Assertions.assertEquals("Moutarde", sauce2.getNom());
        Composant sauce3 = m.getChoixElementParNom("Accompagnement").getParNom(string2)
                .getChoixParNom(string).getParNom(string5);
        Assertions.assertEquals("Mayonnaise", sauce3.getNom());
    }
    @Quand("j'ajoute {string} au menu de mon restaurant")
    public void j_ajoute_au_menu_de_mon_restaurant(String string) {
        managerRestaurant.ajouterUnMenu(m);
        Assertions.assertEquals(m, managerRestaurant.getRestaurant().getMenus(Menu.class).getParNom(string));
    }
    @Alors("il est possible pour l'utilisateur de choisir entre {string} et {string} pour la {string}")
    public void il_est_possible_pour_l_utilisateur_de_choisir_entre_et_pour_la(String string, String string2, String string3) {
        int nbDechoix1 = ((Menu)restaurant.getMenus(Menu.class).getParNom("Cheese1")).getChoixElementParNom(string3).getListe().size();
        Assertions.assertEquals(2, nbDechoix1);
        Element coca = ((Menu)restaurant.getMenus(Menu.class).getParNom("Cheese1")).getChoixElementParNom(string3).getParNom(string);
        Assertions.assertEquals(string, coca.getNom());
        Element iceTea = ((Menu)restaurant.getMenus(Menu.class).getParNom("Cheese1")).getChoixElementParNom(string3).getParNom(string2);
        Assertions.assertEquals(string2, iceTea.getNom());
    }
    @Alors("il n'est pas possible pour l'utilisateur de choisir pour l'{string} et le {string}")
    public void il_n_est_pas_possible_pour_l_utilisateur_de_choisir_pour_l_et_le(String string, String string2) {
        int nbDeChoix2 = ((Menu)restaurant.getMenus(Menu.class).getParNom("Cheese1")).getChoixElementParNom(string).getListe().size();
        Assertions.assertEquals(1, nbDeChoix2);
        int nbDeChoix3 = ((Menu)restaurant.getMenus(Menu.class).getParNom("Cheese1")).getChoixElementParNom(string2).getListe().size();
        Assertions.assertEquals(1, nbDeChoix3);
    }
    @Alors("l'utilisateur peut choisir {int} {string} entre {string}  {string} et {string}")
    public void l_utilisateur_peut_choisir_entre_et(Integer int1, String string, String string2, String string3, String string4) {
        int nbChoixMax = ((Menu)restaurant.getMenus(Menu.class).getParNom("Cheese1")).getChoixElementParNom("Accompagnement")
                .getParNom("Frite").getChoixParNom(string).getNbChoixPossiblePourUtilisateur();
        Assertions.assertEquals(2, nbChoixMax);
        int nbChoixSauce = ((Menu)restaurant.getMenus(Menu.class).getParNom("Cheese1")).getChoixElementParNom("Accompagnement")
                .getParNom("Frite").getChoixParNom(string).getListe().size();
        Assertions.assertEquals(3, nbChoixSauce);

    }

    @Quand("j'ajoute {int} elements supplements {string} et {string}")
    public void j_ajoute_elements_supplements_et(Integer int1, String string, String string2) {
        creer2ElementsSupplements(string, string2);
        ajouterUnElementSupplement(m, supEl1);
        ajouterUnElementSupplement(m, supEl2);
        Assertions.assertEquals(int1, m.getSupplementElementListe().size());
        SupplementElement supEl = m.getContenuMenu().getChoixSupplementElementParNom(string);
        Assertions.assertEquals(string, supEl.getNom());
        SupplementElement supEl2 = m.getContenuMenu().getChoixSupplementElementParNom(string2);
        Assertions.assertEquals(string2, supEl2.getNom());
    }
    @Alors("il est possible pour l'utilisateur de rajouter une {string} et une {string}")
    public void il_est_possible_pour_l_utilisateur_de_rajouter_une_et_une(String string, String string2) {
        if(restaurant.getMenus(Menu.class).size() != 2) { managerRestaurant.ajouterUnMenu(m);}
        int nbSupplementPossible = ((Menu)restaurant.getMenus(Menu.class).get(1)).getSupplementElementListe().size();
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
        int nbSupplements = m.getChoixElementListe().get(2).getListe().get(0).getChoixSupplementComposant().size();
        Assertions.assertEquals(2, nbSupplements);

    }
    @Alors("il est possible pour l'utilisateur de rajouter du {string} et du {string} dans le {string} du menu {string}")
    public void il_est_possible_pour_l_utilisateur_de_rajouter_du_et_du_dans_le_menu(String string, String string2, String string3, String string4) {
        int nbSuppBurger = ((Menu)restaurant.getMenus(Menu.class).getParNom(string4)).getChoixElementParNom("Burger")
                .getParNom(string3).getChoixSupplementComposant().size();
        Assertions.assertEquals(2, nbSuppBurger);
    }




@Etantdonnéque("je suis utilisateur")
    public void je_suis_un_utilisateur() {
        utilisateur = new Utilisateur("nom", "prenom");
        commande = new CommandeSimple(utilisateur, creneau);
        assertNotNull(utilisateur);
    }

    @Quand("Je veux commander un menu {string}")
    public void je_veux_commander_un_menu(String string) {
        creerMenuDansRestaurant();
        menuChoisi = ((Menu)restaurant2.getMenus(Menu.class).getParNom(string));
        Assertions.assertNotNull(menuChoisi);
        utilisateur.addMenu(menuChoisi);
        Assertions.assertEquals(menuChoisi, utilisateur.getCommandeActuelle().getMenuParNom(string, Menu.class));
    }
    @Quand("je veux boire du {string}")
    public void je_veux_boire_du(String string) {
        Element boisson  = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementListe().get(0).getParNom(string);
        Assertions.assertEquals("Coca", boisson.getNom());
        ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Boisson").reset();
        ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Boisson").choisir(boisson);
        Element element = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).
                getChoixElementParNom("Boisson").getSelectionneParNom(string);
        Assertions.assertEquals(string, element.getNom());
    }
    @Alors("ma commande contient du {string}")
    public void ma_commande_contient_du(String string) {
        ListeMenus listeMenus = new ListeMenus();
        commande = new CommandeSimple(utilisateur, creneau);
        commande.setMenus(listeMenus);
        utilisateur.setCommandeActuelle(commande);
        utilisateur.addMenu(menuChoisi);
        Element element = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class))
                .getChoixElementParNom("Boisson").getSelectionneParNom(string);
        Assertions.assertEquals(string, element.getNom());
    }
    @Quand("je veux du {string} et de la {string} comme {string} dans mon {string}")
    public void je_veux_du_et_de_la_dans_mon(String string, String string2, String string3, String string4) {
        ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Burger").reset();
        Composant composant1 = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Burger")
                .getParNom(string4).getChoixParNom(string3).getParNom(string);
        Composant composant2 = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Burger")
                .getParNom(string4).getChoixParNom(string3).getParNom(string2);
        Assertions.assertEquals("Ketchup", composant1.getNom());
        Assertions.assertEquals("Mayonnaise", composant2.getNom());
        ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Burger").getParNom(string4).getChoixParNom(string3)
                .choisir(composant1);
        ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Burger").getParNom(string4).getChoixParNom(string3)
                .choisir(composant2);
        int valeur = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Burger").getParNom(string4)
                .getChoixParNom(string3).getListeSelectionne().size();
        Assertions.assertEquals(2, valeur);
        //On vérifie qu'on ne peux pas ajouter un troisième choix
        ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Burger").getParNom(string4).getChoixParNom(string3)
                .choisir(composant2);
        int valeur2 = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Burger").getParNom(string4)
                .getChoixParNom(string3).getListeSelectionne().size();
        Assertions.assertEquals(2, valeur2);
    }
    @Alors("mon {string} contient du {string} et de la {string}")
    public void mon_contient_du_et_de_la(String string, String string2, String string3) {
        Composant composant1 = ((Menu)utilisateur.getCommandeActuelle().getMenus().get(0)).getChoixElementParNom("Burger")
                .getParNom(string).getChoixParNom("Sauce").getSelectionneParNom(string2);
        Assertions.assertEquals("Ketchup", composant1.getNom());
        Composant composant2 = ((Menu)utilisateur.getCommandeActuelle().getMenus().get(0)).getChoixElementParNom("Burger")
                .getParNom(string).getChoixParNom("Sauce").getSelectionneParNom(string3);
        Assertions.assertEquals("Mayonnaise", composant2.getNom());
        m2.resetMenu();
        utilisateur.getCommandeActuelle().getMenus().get(0).resetMenu();
        //restaurant2.getMenus(Menu.class).getParNom("Cheese").resetMenu();
    }
    @Quand("je veux ajouter du {string} dans mon {string} et une {string} avec des {string}")
    public void je_veux_ajouter_du_dans_mon_et_une_avec_des(String string, String string2, String string3, String string4) {
        double prixInitial = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getPrix();
        double prixSupplement = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getPrixAvecSupplements();
        Assertions.assertEquals(12, prixInitial);
        Assertions.assertEquals(12, prixSupplement);
        SupplementComposant supplementComposant =((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Burger").getParNom(string2)
                .getSupplementParNom(string);
        Assertions.assertEquals("Bacon", supplementComposant.getNom());
        SupplementElement supplementElement = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getContenuMenu().getChoixSupplementElementParNom(string3);
        Assertions.assertEquals("Glace", supplementElement.getNom());
        ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getChoixElementParNom("Burger").getParNom(string2).ajoutChoixSupplementSelectionne(supplementComposant);
        SupplementComposant sup = menuChoisi.getChoixElementParNom("Burger").getParNom(string2)
                .getSupplementParNom(string);
        Assertions.assertEquals("Bacon", sup.getNom());
        ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getContenuMenu().ajouterElementSupplementSelectionne(supplementElement);
        SupplementElement supEl = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getContenuMenu().getChoixSupplementElementParNom(string3);
        Assertions.assertEquals("Glace", supEl.getNom());
        SupplementComposant supC = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getContenuMenu().getChoixSupplementElementParNom(string3).getElement().getSupplementParNom(string4);
        Assertions.assertEquals("Cacahuetes", supC.getNom());
        ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getContenuMenu().getChoixSupplementElementParNom(string3)
                .getElement().ajoutChoixSupplementSelectionne(supC);
        SupplementComposant supC2 = ((Menu)utilisateur.getCommandeActuelle().getMenuParNom("Cheese", Menu.class)).getContenuMenu().getChoixSupplementElementParNom(string3).getElement().getSupplementParNom(string4);
        Assertions.assertEquals("Cacahuetes", supC2.getNom());

    }
    @Alors("ma commande contient du {string} dans mon {string}")
    public void ma_commande_contient_du_dans_mon(String string, String string2) {
        ListeMenus listeMenus = new ListeMenus();
        commande = new CommandeSimple(utilisateur, creneau);
        commande.setMenus(listeMenus);
        utilisateur.setCommandeActuelle(commande);
        utilisateur.addMenu(menuChoisi);
        SupplementComposant supCo = ((Menu)utilisateur.getCommandeActuelle().getMenus().get(0)).getChoixElementParNom("Burger")
                .getParNom(string2).getSupplementSelectionneParNom(string);
        Assertions.assertEquals("Bacon", supCo.getNom());
        ((Menu)utilisateur.getCommandeActuelle().getMenus().get(0)).getChoixElementParNom("Burger").reset();
    }

    @Alors("ma commande contient une {string}")
    public void ma_commande_contient_une(String string) {
        SupplementElement supEl = ((Menu)utilisateur.getCommandeActuelle().getMenus().get(0)).getContenuMenu().getSupplementElementListeSelectioneParNom(string);
        Assertions.assertEquals("Glace", supEl.getNom());
    }
    @Alors("le prix de ma commande a augmente")
    public void le_prix_de_ma_commande_a_augmente() {
        /*System.out.println(((Menu)utilisateur.getCommandeActuelle().getMenus().get(0)).getPrixBase());
        System.out.println(((Menu)utilisateur.getCommandeActuelle().getMenus().get(0)));
        System.out.println(((Menu)utilisateur.getCommandeActuelle().getMenus().get(0)).getContenuMenu().getChoixElementListe().get(1).getListeSelectionne().get(0).getChoixComposantListeUtilisation().size());*/
        //System.out.println(((Menu)utilisateur.getCommandeActuelle().getMenus().get(0)).getContenuMenu().getChoixElementListe().get(1).getListeSelectionne().get(0).getChoixComposantListeUtilisation().get(0).getNom());
        double prixInitial = utilisateur.getCommandeActuelle().getPrixBase();
        double prixSupplement = utilisateur.getCommandeActuelle().getPrix();
        Assertions.assertEquals(12, prixInitial);
        Assertions.assertEquals(15, prixSupplement);
        m2.resetMenu();
        utilisateur.getCommandeActuelle().getMenus().get(0).resetMenu();
        //restaurant2.getMenus(Menu.class).getParNom("Cheese").resetMenu();
        //restaurant2.getMenus().getParNom("Cheese").resetMenu();
        int nbSupplementElement = ((Menu)utilisateur.getCommandeActuelle().getMenus().get(0)).getContenuMenu().getSupplementElementListeSelectionne().size();
        Assertions.assertEquals(0, nbSupplementElement);
        double prixApresReset = utilisateur.getCommandeActuelle().getPrix();
        Assertions.assertEquals(12, prixApresReset);
        utilisateur.resetCommande();
        Assertions.assertNull(utilisateur.getCommandeActuelle());
    }


}

