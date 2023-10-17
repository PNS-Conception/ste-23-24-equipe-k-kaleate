package fr.unice.polytech.kaleate;

import java.util.HashSet;
import java.util.Set;

public class Commande {
    private Set<Menu> menus;
    private Utilisateur utilisateur;

    private int id;

    private static int nextID = 1;

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

    public Commande(){
        this.menus = new HashSet<Menu>();
    }

    public Set<Menu> getMenus(){
        return this.menus;
    }

    public void setMenus(Set<Menu> menus){
        this.menus = menus;
    }

    public void addMenu(Menu menu){
        this.menus.add(menu);
    }

    public void removeMenu(Menu menu){
        this.menus.remove(menu);
    }

    public float getPrice(){
        float price = 0;
        for(Menu menu : this.menus){
            price += menu.getPrice();
        }
        return price;
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
}
