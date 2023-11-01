package fr.unice.polytech.kaleate;

import java.util.Date;
import java.util.List;

public class Restaurant {
    private ListMenus menus;
    private String name;

    private GestionnaireCommande gestionnaireCommande;

    public Restaurant(){
        this.menus = new ListMenus();
        gestionnaireCommande = new GestionnaireCommande();
    }

    public Restaurant(String name){
        this.menus = new ListMenus();
        this.name = name;
        gestionnaireCommande = new GestionnaireCommande();
    }

    public Restaurant(String name, ListMenus menus){
        this.name = name;
        this.menus = menus;
        gestionnaireCommande = new GestionnaireCommande();
    }

    public ListMenus getMenus(){
        return this.menus;
    }

    public void setMenus(ListMenus menus){
        this.menus = menus;
    }

    public ListMenus getMenusDansCreneau(Creneau creneau){
        ListMenus listMenu = new ListMenus(this.menus);
        listMenu = new ListMenus(listMenu.stream().filter(menu -> !menu.estComprisDansCreneau(creneau)).toList());
        return listMenu;
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

    public ListCommande getListCommande() {
        return  gestionnaireCommande.getListCommande();
    }

    public void setListCommande(ListCommande listCommande) {
        this.gestionnaireCommande.setListCommande(listCommande);
    }

    public boolean validerCommande(Commande commande){
       return gestionnaireCommande.validerCommande(commande);
    }
    public boolean doitEtrePreparee(Commande commande, Date dateActuel){
        //date du début de la livraison - date
        long datePreparationMinimum= commande.getCreneauLivraison().getDebut().getTime();
        if(dateActuel.getTime()>=datePreparationMinimum )
            return true;
        return false;
    }

    public boolean preparerCommande(Commande commande){
        return gestionnaireCommande.preparerCommande(commande);
    }

    public ListCommande getCommandePrete() {
        return gestionnaireCommande.getCommandePrete(this);

    }
}
