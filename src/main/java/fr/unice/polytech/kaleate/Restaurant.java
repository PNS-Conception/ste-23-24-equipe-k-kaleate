package fr.unice.polytech.kaleate;

import java.util.Date;

public class Restaurant {
    private ListeMenus menus;
    private String name;
    private ListeCommande listeCommande;

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
        return listeCommande;
    }

    public void setListCommande(ListeCommande listeCommande) {
        this.listeCommande = listeCommande;
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

    public boolean preparerMenu(Commande commande, Menu menu){
        if(commande.getStatut()== StatutCommande.VALIDEE){
            return commande.preparerMenu(menu);
        }
        return false;
    }

    public boolean preparerCommande(Commande commande){
        if(commande.getStatut()== StatutCommande.VALIDEE){
            commande.setStatut(StatutCommande.EN_PREPARATION);
            return true;
        }

        return false;
    }

    public ListeCommande getCommandePrete() {
        ListeCommande comPrete = new ListeCommande();
        for (Commande c : listeCommande) {
            if (c.getStatut().equals(StatutCommande.PRETE)) {
                comPrete.add(c);
            }
        }
        return comPrete;
    }
}
