package fr.unice.polytech.kaleate;

import java.util.Date;

public class Restaurant {
    private ListeMenus menus;
    private String name;
    private ListCommande listCommande;

    public Restaurant(){
        this.menus = new ListeMenus();
    }

    public Restaurant(String name){
        this.menus = new ListeMenus();
        this.name = name;
    }

    public Restaurant(String name, ListeMenus menus){
        this.name = name;
        this.menus = menus;
    }

    public ListeMenus getMenus(){
        return this.menus;
    }

    public void setMenus(ListeMenus menus){
        this.menus = menus;
    }

    public ListeMenus getMenusDansCreneau(Creneau creneau){
        ListeMenus listMenu = new ListeMenus(this.menus);
        listMenu = new ListeMenus(listMenu.stream().filter(menu -> !menu.estComprisDansCreneau(creneau)).toList());
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
        return listCommande;
    }

    public void setListCommande(ListCommande listCommande) {
        this.listCommande = listCommande;
    }

    public boolean validerCommande(Commande commande){
        if(commande.getStatut()!= StatutCommande.EN_CREATION){
            return false;
        }
        commande.setStatut(StatutCommande.VALIDEE);
        return true;
    }
    public boolean doitEtrePreparee(Commande commande, Date dateActuel){
        //date du début de la livraison - date
        long datePreparationMinimum= commande.getCreneauLivraison().getDebut().getTime();
        if(dateActuel.getTime()>=datePreparationMinimum )
            return true;
        return false;
    }

    public boolean preparerCommande(Commande commande){
        if(commande.getStatut()== StatutCommande.VALIDEE){
            commande.setStatut(StatutCommande.EN_PREPARATION);
            return true;
        }

        return false;
    }

    public ListCommande getCommandePrete() {
        ListCommande comPrete = new ListCommande();
        for (Commande c : listCommande) {
            if (c.getStatut().equals(StatutCommande.PRETE)) {
                comPrete.add(c);
            }
        }
        return comPrete;
    }
}
