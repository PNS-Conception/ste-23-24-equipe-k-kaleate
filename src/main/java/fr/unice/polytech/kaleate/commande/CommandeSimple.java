package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.restaurant.Restaurant;
import fr.unice.polytech.kaleate.menu.StatutMenu;
import fr.unice.polytech.kaleate.campus.Utilisateur;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;

import java.util.*;
import java.util.stream.Collectors;


public class CommandeSimple extends Commande implements Observer {
    private Utilisateur utilisateur;
    private ListeMenus menus = new ListeMenus();

    public CommandeSimple(Utilisateur utilisateur){
        this.menus = new ListeMenus();
        this.utilisateur = utilisateur;
        this.id = getNexID();
    }

    public CommandeSimple(Utilisateur utilisateur, Creneau creneauLivraison){
        this.menus = new ListeMenus();
        this.utilisateur = utilisateur;
        this.creneauLivraison = creneauLivraison;
        this.id = getNexID();
    }

    public CommandeSimple(){
        this.menus = new ListeMenus();
    }

    public ListeMenus getMenus(){
        return this.menus;
    }

    public void setMenus(ListeMenus menus){
        this.menus = menus;
    }

    @Override
    public boolean addMenu(Commandable menu){
        if(modifiable()) {
            menu.setCommande(this);
            menu.getRestaurant().supprimerMenu(menu);
            return this.menus.add(menu);
        }
        return false;
    }

    @Override
    public boolean removeMenu(Commandable menu){
        if(modifiable()) {
            menu.setCommande(null);
            menu.getRestaurant().ajouterMenu(menu);
            return this.menus.remove(menu);
        }
        return false;
    }
    @Override
    public boolean modifiable(){
        return statut == StatutCommande.EN_CREATION || statut == StatutCommande.VALIDEE;
    }

    @Override
    public Utilisateur getUtilisateurRecepteur() {
        return utilisateur;
    }
    @Override
    public Utilisateur getUtilisateurEmetteur() { return getUtilisateurRecepteur();}
    @Override
    public void setUtilisateurRecepteur(Utilisateur utilisateur) { this.utilisateur = utilisateur;}
    @Override
    public void setUtilisateurEmetteur(Utilisateur utilisateur) { this.utilisateur = utilisateur;}

    @Override
    public void reset() {
        for(Commandable m : getMenus()) {
            m.setCommande(null);
            m.resetMenu();
            m.getRestaurant().ajouterMenu(m);
        }
        this.menus = new ListeMenus();
        this.creneauLivraison = null;
        this.statut = StatutCommande.EN_CREATION;
        this.utilisateur = null;
    }


    public List<Commandable> getListeMenus() {
        return this.menus.stream().toList();
    }

}
