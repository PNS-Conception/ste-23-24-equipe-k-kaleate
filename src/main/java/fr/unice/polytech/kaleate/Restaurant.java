package fr.unice.polytech.kaleate;

import java.util.Date;
import java.util.List;

public class Restaurant {
    private ListeMenus menus;
    private String name;

    private GestionnaireCommande gestionnaireCommande;

    public Restaurant(){
        gestionnaireCommande = new GestionnaireCommande();
        this.menus = new ListeMenus();
        this.listeCommande = new ListeCommande();
    }

    public Restaurant(String name){
        this.menus = new ListeMenus();
        this.listeCommande = new ListeCommande();
        this.name = name;
        gestionnaireCommande = new GestionnaireCommande();
    }

    public Restaurant(String name, ListeMenus menus){
        this.name = name;
        this.menus = menus;
<<<<<<< HEAD
        gestionnaireCommande = new GestionnaireCommande();
=======
        this.listeCommande = new ListeCommande();
>>>>>>> 7c9125d7faeb6c662a23eb2fd510d9428feb7468
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
        return  gestionnaireCommande.getListCommande();
    }

    public void setListCommande(ListeCommande listCommande) {
        this.gestionnaireCommande.setListCommande(listCommande);
    }

    public boolean validerCommande(Commande commande){
<<<<<<< HEAD
       return gestionnaireCommande.validerCommande(commande);
=======
        if(commande.getStatut()!= StatutCommande.EN_CREATION){
            return false;
        }
        listeCommande.add(commande);
        commande.setStatut(StatutCommande.VALIDEE);
        return true;
>>>>>>> 7c9125d7faeb6c662a23eb2fd510d9428feb7468
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
        return gestionnaireCommande.preparerCommande(commande);
    }

    public ListeCommande getCommandePrete() {
        return gestionnaireCommande.getCommandePrete(this);

    }


    public void ajouterMenu(Menu m){
        menus.add(m);
    }
}
