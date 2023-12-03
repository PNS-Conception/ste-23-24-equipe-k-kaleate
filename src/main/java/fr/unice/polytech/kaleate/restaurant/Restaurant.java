package fr.unice.polytech.kaleate.restaurant;

import fr.unice.polytech.kaleate.Evaluable;
import fr.unice.polytech.kaleate.Localisation;
import fr.unice.polytech.kaleate.commande.*;
import fr.unice.polytech.kaleate.menu.ContenuMenu;
import fr.unice.polytech.kaleate.menu.ListeMenus;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.outils.Creneau;


import java.util.*;

import java.util.stream.Collectors;

public class Restaurant extends Evaluable {
    private ListeMenus menus;
    private Map<String, Integer> menusCommandes;
    private String name;

    private Localisation localisation;

    private GestionnaireCommande gestionnaireCommande;

    public Restaurant(){
        gestionnaireCommande = new GestionnaireCommande();
        this.menus = new ListeMenus();
        this.menusCommandes=new HashMap<>();
    }

    public Restaurant(String name){
        this.menus = new ListeMenus();
        this.name = name;
        gestionnaireCommande = new GestionnaireCommande();
        this.menusCommandes=new HashMap<>();
    }

    public Restaurant(String name, ListeMenus menus){
        this.name = name;
        this.menus = menus;
        this.gestionnaireCommande = new GestionnaireCommande();
        this.menusCommandes=new HashMap<>();
    }

    public Restaurant(String name, ListeMenus menus,Localisation l){
        this.name = name;
        this.menus = menus;
        this.gestionnaireCommande = new GestionnaireCommande();
        this.localisation=l;
        this.menusCommandes=new HashMap<>();
        for (Commandable m : menus){
            menusCommandes.put(m.getName(),0);
        }
    }

    public ListeMenus getMenus(Class typeMenu){
        return this.menus.stream().filter(typeMenu::isInstance).collect(Collectors.toCollection(ListeMenus::new));
    }

    public void setMenus(ListeMenus menus){
        this.menus = menus;
        for (Commandable m : menus){
            menusCommandes.put(m.getName(),0);
        }
    }

    public ListeMenus getMenusDansCreneau(Creneau creneau, Class typeMenu){
        ListeMenus listeMenu = new ListeMenus(this.menus);
        listeMenu = new ListeMenus(listeMenu.stream().filter(menu -> menu.chevaucheCreneau(creneau) && typeMenu.isInstance(menu)).toList());
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
    public boolean finirPreparationMenu(Commande commande, Commandable menu){
        if(commande.getStatutCommande() == StatutCommande.EN_PREPARATION || commande.getStatutCommande() == StatutCommande.VALIDEE){

            return commande.finirPreparationMenu(menu);
        }
        return false;
    }


    public boolean preparerMenu(Commande commande, Commandable menu){
        if(commande.getStatutCommande() == StatutCommande.EN_PREPARATION || commande.getStatutCommande() == StatutCommande.VALIDEE || commande.getStatutCommande() == StatutCommande.PAYEE){
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
    public void annulerPreparationMenu(Commande c,Commandable m){
        gestionnaireCommande.annulerPreparationMenu(c,m);
    }

    public void ajouterMenu(Commandable m){
        m.setRestaurant(this);
        menus.add(m);
    }

    public void supprimerMenu(Commandable m){
        menus.remove(m);
    }

    public void resetMenu(){
        this.menus = new ListeMenus();
        menusCommandes.clear();
    }

     public Localisation getLocalisation() {
        return localisation;
    }


    public Map<String, Integer> tendances() {
        menusCommandes = menusCommandes.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        )
                );
        return menusCommandes;
    }

}
