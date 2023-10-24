package fr.unice.polytech.kaleate;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Commande {
    private Set<Menu> menus;
    private Utilisateur utilisateur;

    private StatutCommande statut = StatutCommande.EN_CREATION;

    private int id;

    private static int nextID = 1;

    private Creneau creneauLivraison;

    public Commande(Utilisateur utilisateur, Set<Menu> menus){
        this.menus = menus;
        this.utilisateur = utilisateur;
        id = nextID;
        nextID++;
    }

    public Commande(Utilisateur utilisateur, Menu menu){
        this.menus = new HashSet<>();
        this.menus.add(menu);
        this.utilisateur = utilisateur;
    }
    public Commande(Utilisateur utilisateur, Menu menu,Creneau creneauLivraison){
        this.menus = new HashSet<>();
        this.menus.add(menu);
        this.utilisateur = utilisateur;
        this.creneauLivraison = creneauLivraison;
    }
    public Commande(){
        this.menus = new HashSet<Menu>();
    }

    public Set<Menu> getMenus(){
        return this.menus;
    }

    public void setMenus(Set<Menu> menus){
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
    }

    public Creneau getCreneauLivraison() {
        return creneauLivraison;
    }

    public void setCreneauLivraison(Creneau creneauLivraison) {
        this.creneauLivraison = creneauLivraison;
    }

    public List<Menu> getListMenus() {
        return this.menus.stream().toList();
    }

    public boolean contains(Menu menu) {
        return this.menus.contains(menu);
    }
}
