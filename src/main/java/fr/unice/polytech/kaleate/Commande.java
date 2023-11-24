package fr.unice.polytech.kaleate;

import java.util.*;

public class Commande {
    private List<Menu> menus;
    private List<StatutMenu>  statutsMenus =new ArrayList<>();
    private Utilisateur utilisateur;

    private StatutCommande statut = StatutCommande.EN_CREATION;

    private int id;

    private static int nextID = 1;

    private Creneau creneauLivraison;
    private Restaurant restaurant;

    public Commande(Utilisateur utilisateur, List<Menu> menus, Restaurant restaurant){
        this.menus = menus;
        this.utilisateur = utilisateur;
        id = nextID;
        nextID++;
        this.restaurant = restaurant;
    }

    public Commande(Utilisateur utilisateur, Menu menu, Restaurant restaurant){
        this.menus = new ArrayList<>();
        addMenu(menu);
        this.utilisateur = utilisateur;
        this.restaurant = restaurant;
    }
    public Commande(Utilisateur utilisateur, Menu menu,Creneau creneauLivraison, Restaurant restaurant){
        this.menus = new ArrayList<>();
        addMenu(menu);
        this.utilisateur = utilisateur;
        this.creneauLivraison = creneauLivraison;
        this.restaurant = restaurant;
    }
    public Commande(){
        this.menus = new ArrayList<>();
    }
    public Commande(Utilisateur u){
        this.menus = new ArrayList<>();
        utilisateur = u;
    }
    public List<Menu> getMenus(){
        return this.menus;
    }

    public void setMenus(List<Menu> menus){
        this.menus = menus;
    }

    public boolean addMenu(Menu menu){
        if(modifiable()) {
            statutsMenus.add(StatutMenu.SELECTIONNE);
            return this.menus.add(menu);
        }
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
        for(int i =0;i<menus.size();i++){
            if(statutsMenus.get(i).compareTo(StatutMenu.ANNULE) != 0)
                price += menus.get(i).getPrice();
        }
        return price;
    }

    public float getPrixAvecSupplement(){
        float prix = getPrice();
        for(int i =0;i<menus.size();i++){
            if(statutsMenus.get(i).compareTo(StatutMenu.ANNULE) != 0)
                prix += menus.get(i).getPrixAvecSupplements();
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

            for (int i=0;i<menus.size();i++){
                statutsMenus.set(i,StatutMenu.VALIDE);
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


    public boolean annulerMenu(Menu mp){
        if (contains(mp)) {
            for (int i=0; i<menus.size(); i++){
                if (mp.equals(menus.get(i))&& statutsMenus.get(i)!=StatutMenu.PRET){
                    statutsMenus.set(i,StatutMenu.ANNULE);
                    checkAnnulationCommande();
                    utilisateur.rembourser(menus.get(i));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkAnnulationCommande(){
        for(StatutMenu s : statutsMenus){
            if(s.compareTo(StatutMenu.ANNULE) != 0){
                return false;
            }
        }
        setStatut(StatutCommande.ANNULEE);

        return true;
    }
    public List<StatutMenu> getStatutsMenus(){
        return statutsMenus;
    }

    public Menu getMenuParNom(String nomMenu){
        return this.menus.stream().filter(menu -> menu.estMenuParNom(nomMenu)).findFirst().orElse(null);
    }
}
