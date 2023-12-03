package fr.unice.polytech.kaleate.commande;

import com.sun.management.DiagnosticCommandMBean;
import fr.unice.polytech.kaleate.campus.Staff;
import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.menu.StatutMenu;
import fr.unice.polytech.kaleate.outils.Creneau;
import fr.unice.polytech.kaleate.restaurant.Restaurant;

import java.util.*;
import java.util.stream.Collectors;

public class Buffet extends Commande implements Commandable {

    private String nom;
    HashMap<Menu, Integer> menus = new HashMap<>();
    int id;
    Utilisateur recepteur;

    Creneau creneau;

    Staff emetteur;

    int MIN_PERSONNES;
    int MAX_PERSONNES;


    public Buffet(String nom, int minPersonnes, int maxPersonnes) {
        this.nom = nom;
        if (minPersonnes < 1) throw new IllegalArgumentException("Le nombre de personnes doit être supérieur à 0");
        if (minPersonnes > maxPersonnes) throw new IllegalArgumentException("Le nombre de personnes minimum doit être inférieur au nombre de personnes maximum");
        this.MIN_PERSONNES = minPersonnes;
        id = nextID;
        nextID++;
    }

    public void setNbPersonnes(int nbPersonnes) {
        if (nbPersonnes < 1) throw new IllegalArgumentException("Le nombre de personnes doit être supérieur à 0");
        for (Menu menu : menus.keySet()) {
            menus.put(menu, nbPersonnes);
        }
    }

    public int getNbPersonnes() {
        Optional<Integer> max = menus.values().stream().max(Integer::compareTo);
        return (max.isPresent()) ? max.get() : 0;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    @Override
    public Creneau getCreneau() {
        return creneau;
    }

    @Override
    public void setTempsPreparation(int i) {
        for (Menu menu : menus.keySet()) {
            menu.setTempsPreparation(i);
        }
    }

    @Override
    public void setStatutPaye() {
        for (Menu menu : menus.keySet()) {
            menu.setStatutPaye();
        }
        this.statut = StatutCommande.PAYEE;
    }

    @Override
    public String getName() {
        return nom;
    }

    @Override
    public boolean estMenuParNom(String s) {
        return nom.equals(s);
    }

    @Override
    public boolean chevaucheCreneau(Creneau creneau) {
        return this.creneau.chevaucheCreneau(creneau);
    }

    @Override
    public void setCommande(Commande commandeSimple) {
        for(Menu menu : menus.keySet()){
            menu.setCommande(this);
        }
    }

    @Override
    public void verifContenuMenu() {
        for(Menu menu : menus.keySet()){
            menu.verifContenuMenu();
        }
    }

    @Override
    public void setRestaurant(Restaurant restaurant) {
        for(Menu menu : menus.keySet()){
            menu.setRestaurant(restaurant);
        }
    }

    @Override
    public Restaurant getRestaurant() {
        if(menus.keySet().stream().map(Menu::getRestaurant).collect(Collectors.toSet()).size() >1) throw new RuntimeException("Le buffet contient plusieurs restaurants");
        return menus.keySet().stream().toList().get(0).getRestaurant();
    }

    @Override
    public void setStatutValide() {
        for(Menu menu : menus.keySet()){
            menu.setStatutValide();
        }
        statut = StatutCommande.VALIDEE;
    }

    @Override
    public void setStatutEnPreparation() {
        for(Menu menu : menus.keySet()){
            menu.setStatutEnPreparation();
        }
        statut = StatutCommande.EN_PREPARATION;
    }

    @Override
    public void setStatutPret() {
        for(Menu menu : menus.keySet()){
            menu.setStatutPret();
        }
        statut = StatutCommande.PRETE;
    }

    @Override
    public void setStatut(StatutMenu statutMenu) {
        for(Menu menu : menus.keySet()){
            menu.setStatut(statutMenu);
        }
    }

    @Override
    public StatutMenu getStatut() {
        boolean isPret = true;
        boolean isValide = true;

        if(statut == StatutCommande.EN_LIVRAISON || statut == StatutCommande.LIVREE) return StatutMenu.PRET;

        for(Menu menu : menus.keySet()){
            if(menu.getStatut() != StatutMenu.PRET) isPret = false;
            if(menu.getStatut() != StatutMenu.VALIDE) isValide = false;
        }
        return isPret ? StatutMenu.PRET : isValide ? StatutMenu.VALIDE : StatutMenu.EN_PREPARATION;
    }

    @Override
    public void resetMenu() {
        for(Menu menu : menus.keySet()){
            menu.resetMenu();
        }
    }

    public void setName(String nom) {
        this.nom = nom;
    }

    public void setMinPersonnes(int minPersonnes) {
        if (minPersonnes < 1) throw new IllegalArgumentException("Le nombre de personnes doit être supérieur à 0");
        if(minPersonnes > MAX_PERSONNES) throw new IllegalArgumentException("Le nombre de personnes minimum doit être inférieur au nombre de personnes maximum");
        MIN_PERSONNES = minPersonnes;
    }

    public void setMaxPersonnes(int maxPersonnes) {
        if (maxPersonnes < 1) throw new IllegalArgumentException("Le nombre de personnes doit être supérieur à 0");
        if(maxPersonnes < MIN_PERSONNES) throw new IllegalArgumentException("Le nombre de personnes maximum doit être supérieur au nombre de personnes minimum");
        MAX_PERSONNES = maxPersonnes;
    }

    public int getMinPersonnes() {
        return MIN_PERSONNES;
    }

    public int getMaxPersonnes() {
        return MAX_PERSONNES;
    }

    public void setNbPersonnesPourUnMenu(int nbPersonnes, Menu menu) {
        if (nbPersonnes < 1) throw new IllegalArgumentException("Le nombre de personnes doit être supérieur à 0");
        if (!menus.containsKey(menu)) throw new EmptyStackException();
        menus.put(menu, nbPersonnes);
    }

    public void setNbPersonnePourMenuParIndex(int nbPersonnes, int index) {
        if (nbPersonnes < 1) throw new IllegalArgumentException("Le nombre de personnes doit être supérieur à 0");
        if (index < 0 || index >= menus.size()) throw new IndexOutOfBoundsException();
        menus.put(menus.keySet().stream().toList().get(index), nbPersonnes);
    }

    @Override
    public ListeMenus getMenus() {
        return new ListeMenus(menus.keySet().stream().collect(ListeMenus::new, (m, v) -> m.add(v), ListeMenus::addAll));
    }

    @Override
    public void setMenus(ListeMenus menus) {
        this.menus = menus.stream().collect(HashMap::new, (m, v) -> m.put((Menu) v, MIN_PERSONNES), HashMap::putAll);
    }

    /**
     * Ajouter un menu au buffet est bloquée
     * @param menu
     * @return false
     */
    @Override
    public boolean addMenu(Commandable menu) {
        return false;
    }

    /**
     * Supprimer un menu au buffet est bloquée
     * @param menu
     * @return false
     */
    @Override
    public boolean removeMenu(Commandable menu) {
        return false;
    }

    /**
     * Non modifiable
     * @return false
     */
    @Override
    public boolean modifiable() {
        return false;
    }

    @Override
    public float getTempsPreparation() {
        float temps = 0;
        for (Menu menu : menus.keySet()) {
            temps += menu.getTempsPreparation();
        }
        return temps;
    }

    @Override
    public Utilisateur getUtilisateurRecepteur() {
        return recepteur;
    }

    @Override
    public Utilisateur getUtilisateurEmetteur() {
        return emetteur;
    }

    @Override
    public void setUtilisateurRecepteur(Utilisateur utilisateur) {
        this.recepteur = utilisateur;
    }

    @Override
    public void setUtilisateurEmetteur(Utilisateur utilisateur) {
        if(utilisateur instanceof Staff)
            this.emetteur = (Staff) utilisateur;
        else throw new RuntimeException("L'emetteur doit être un staff");
    }

    @Override
    public boolean elligibleReduction() {
        return false;
    }

    @Override
    public void reset() {
        this.getRestaurant().ajouterMenu(this);
    }

}
