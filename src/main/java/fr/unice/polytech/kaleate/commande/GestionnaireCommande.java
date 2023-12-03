package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.restaurant.Restaurant;

public class GestionnaireCommande {

    private ListeCommande listCommande;

    public GestionnaireCommande(){
        listCommande = ListeCommande.getInstance();
    }

    public boolean validerCommande(Commande commande){
        if(commande.getStatutCommande()!= StatutCommande.EN_CREATION){
            return false;
        }
        commande.setStatut(StatutCommande.VALIDEE);
        return true;
    }

    public boolean preparerCommande(Commande commande){
        if(commande.getStatutCommande()== StatutCommande.VALIDEE){
            commande.setStatut(StatutCommande.EN_PREPARATION);
            return true;
        }

        return false;
    }

    public ListeCommande getCommandePrete(Restaurant restaurant) {
        ListeCommande comPrete = new ListeCommande();
        for (Commande c: listCommande) {
            if(c.getRestaurants().contains(restaurant))
                if(c.getStatutCommande().equals(StatutCommande.PRETE))
                    comPrete.add(c);
        }
        return comPrete;
    }

    public ListeCommande getListCommande() {
        return listCommande;
    }
    public ListeCommande getListCommande(Restaurant restaurant) {
        ListeCommande liste = new ListeCommande();
        liste.addAll(listCommande.getCommandeByRestaurant(restaurant));
        return liste;
    }
    public void setListCommande(ListeCommande listCommande) {
        this.listCommande = listCommande;
    }
    public boolean annulerPreparationMenu(Commande c,Commandable m){
        return c.removeMenuDepuisRestaurant(m);
    }
}
