package fr.unice.polytech.kaleate.restaurant;

import fr.unice.polytech.kaleate.Evaluable;
import fr.unice.polytech.kaleate.Localisation;
import fr.unice.polytech.kaleate.commande.*;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Restaurant extends Evaluable {
    private ListeMenus menus;
    private String name;

    private Localisation localisation;

    private GestionnaireCommande gestionnaireCommande;

    public Restaurant(){
        gestionnaireCommande = new GestionnaireCommande();
        this.menus = new ListeMenus();
    }

    public Restaurant(String name){
        this.menus = new ListeMenus();
        this.name = name;
        gestionnaireCommande = new GestionnaireCommande();
    }

    public Restaurant(String name, ListeMenus menus){
        this.name = name;
        this.menus = menus;
        this.gestionnaireCommande = new GestionnaireCommande();
    }

    public Restaurant(String name, ListeMenus menus,Localisation l){
        this.name = name;
        this.menus = menus;
        this.gestionnaireCommande = new GestionnaireCommande();
        this.localisation=l;
    }

    public ListeMenus getMenus(){
        return this.menus;
    }

    public void setMenus(ListeMenus menus){
        this.menus = menus;
    }

    public ListeMenus getMenusDansCreneau(Creneau creneau){
        ListeMenus listeMenu = new ListeMenus(this.menus);
        listeMenu = new ListeMenus(listeMenu.stream().filter(menu -> menu.chevaucheCreneau(creneau)).toList());
        return listeMenu;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n" + name +
                "\n" + menus;
    }

    public ListeCommande getListCommande() {
        return  gestionnaireCommande.getListCommande(this);
    }

    public void setListCommande(ListeCommande listCommande) {
        this.gestionnaireCommande.setListCommande(listCommande);
    }

    public boolean validerCommande(Commande commande){
       return gestionnaireCommande.validerCommande(commande);
    }
    public boolean doitEtrePreparee(Commande commande, Date dateActuel){
        //date du début de la livraison - date
        long datePreparationMinimum = commande.getCreneauLivraison().getDebut().getTime();
        if(dateActuel.getTime()>=datePreparationMinimum )
            return true;
        return false;
    }

    /**
     * Permet de preparer le menu specifique d'une commande EN_COURS de preparation
     * @param commande
     * @param menu
     * @return boolean
     */
    public boolean finirPreparationMenu(Commande commande, Menu menu){
        if(commande.getStatut() == StatutCommande.EN_PREPARATION || commande.getStatut() == StatutCommande.VALIDEE){
            return commande.finirPreparationMenu(menu);
        }
        return false;
    }


    public boolean preparerMenu(Commande commande, Menu menu){
        if(commande.getStatut() == StatutCommande.EN_PREPARATION || commande.getStatut() == StatutCommande.VALIDEE){
            return commande.preparerMenu(menu);
        }
        return false;
    }

    public boolean preparerCommande(Commande commande){
        return gestionnaireCommande.preparerCommande(commande);
    }

    public ListeCommande getCommandePrete() {
        return gestionnaireCommande.getCommandePrete(this);

    }
    public void annulerPreparationMenu(Commande c,Menu m){
        gestionnaireCommande.annulerPreparationMenu(c,m);
    }

    public void ajouterMenu(Menu m){
        m.setRestaurant(this);
        menus.add(m);
    }

    public void supprimerMenu(Menu m){
        menus.remove(m);
    }

    public void resetMenu(){
        this.menus = new ListeMenus();
    }

     public Localisation getLocalisation() {
        return localisation;
    }
}
