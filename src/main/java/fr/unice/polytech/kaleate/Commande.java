package fr.unice.polytech.kaleate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Commande {
    private Set<Menu> menus;
    private Utilisateur utilisateur;

    public Commande(Utilisateur utilisateur, Set<Menu> menus){
        this.menus = menus;
        this.utilisateur = utilisateur;
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

    public Utilisateur getUtilisateur(){
        return this.utilisateur;
    }

    public List<Menu> getListMenus() {
        return this.menus.stream().toList();
    }

    public boolean contains(Menu menu) {
        return this.menus.contains(menu);
    }
}
