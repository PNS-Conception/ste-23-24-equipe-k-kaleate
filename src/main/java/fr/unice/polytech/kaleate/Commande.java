package fr.unice.polytech.kaleate;

import java.util.*;

public class Commande {
    private List<Menu> menus;
    private List<StatutMenu> statutsMenus;
    private Utilisateur utilisateur;

    private StatutCommande statut = StatutCommande.EN_CREATION;

    private int id;

    private static int nextID = 1;

    private Creneau creneauLivraison;
    private Restaurant restaurant;

    public Commande(Utilisateur utilisateur, List<Menu> menus, Restaurant restaurant){
        this.menus = menus;
        this.utilisateur = utilisateur;
        this.restaurant = restaurant;
        id = nextID;
        nextID++;
    }

    public Commande(Utilisateur utilisateur, Menu menu, Restaurant Restaurant){
        this.menus = new ArrayList<>();
        this.menus.add(menu);
        this.utilisateur = utilisateur;
        this.restaurant = Restaurant;
    }
    public Commande(Utilisateur utilisateur, Menu menu,Creneau creneauLivraison, Restaurant Restaurant){
        this.menus = new ArrayList<>();
        this.menus.add(menu);
        this.utilisateur = utilisateur;
        this.creneauLivraison = creneauLivraison;
        this.restaurant = Restaurant;
    }
    public Commande(){
        this.menus = new ArrayList<>();
    }

    public List<Menu> getMenus(){
        return this.menus;
    }

    public void setMenus(List<Menu> menus){
        this.menus = menus;
    }

    public boolean addMenu(Menu menu){
        if(modifiable())
            return this.menus.add(menu);
        return false;
    }

    public boolean removeMenu(Menu menu){
        if(modifiable())
           return this.menus.remove(menu);
        return false;
    }
    public boolean modifiable(){
        if(statut == StatutCommande.EN_CREATION ||statut == StatutCommande.VALIDEE ){
            return true;
        }else{
            return false;
        }
    }
    public float getPrice(){
        float price = 0;
        for(Menu menu : this.menus){
            price += menu.getPrice();
        }
        return price;
    }

    public float getPrixAvecSupplement(){
        float prix = getPrice();
        for(Menu menu : this.menus){
            prix += menu.getPrixAvecSupplements();
        }
        return prix;
    }

    public float getTempsPreparation(){
        float tps = 0;
        for(Menu menu : this.menus){
            tps += menu.getTempsPreparation();
        }
        return tps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
        if (statut.equals(StatutCommande.VALIDEE)){
            statutsMenus =new ArrayList<>();
            for (Menu m : this.menus){
                statutsMenus.add(StatutMenu.VALIDE);
            }
        }
    }

    public Creneau getCreneauLivraison() {
        return creneauLivraison;
    }

    public void setCreneauLivraison(Creneau creneauLivraison) {
        this.creneauLivraison = creneauLivraison;
    }

    public List<Menu> getListeMenus() {
        return this.menus.stream().toList();
    }

    public boolean contains(Menu menu) {
        return this.menus.contains(menu);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean preparerMenu(Menu mp){
        if (contains(mp)) {
            for (int i=0; i<menus.size(); i++){
                if (mp.equals(menus.get(i))&& statutsMenus.get(i)==StatutMenu.VALIDE){
                    statutsMenus.set(i,StatutMenu.PRET);
                    return true;
                }
            }
        }
        return false;
    }

    public List<StatutMenu> getStatutsMenus(){
        return statutsMenus;
    }

    public Menu getMenuParNom(String nomMenu){
        return this.menus.stream().filter(menu -> menu.estMenuParNom(nomMenu)).findFirst().orElse(null);
    }
}
