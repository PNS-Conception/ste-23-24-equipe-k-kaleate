package fr.unice.polytech.kaleate;

import java.util.Date;

public class GestionnaireCommande {

    private ListCommande listCommande;

    public GestionnaireCommande(){
        listCommande = ListCommande.getInstance();
    }

    public boolean validerCommande(Commande commande){
        if(commande.getStatut()!= StatutCommande.EN_CREATION){
            return false;
        }
        commande.setStatut(StatutCommande.VALIDEE);
        return true;
    }

    public boolean preparerCommande(Commande commande){
        if(commande.getStatut()== StatutCommande.VALIDEE){
            commande.setStatut(StatutCommande.EN_PREPARATION);
            return true;
        }

        return false;
    }

    public ListCommande getCommandePrete(Restaurant restaurant) {
        ListCommande comPrete = new ListCommande();
        for (Commande c : listCommande) {
            if (c.getStatut().equals(StatutCommande.PRETE) && c.getRestaurant().equals(restaurant)) {
                comPrete.add(c);
            }
        }
        return comPrete;
    }

    public ListCommande getListCommande() {
        return listCommande;
    }

    public void setListCommande(ListCommande listCommande) {
        this.listCommande = listCommande;
    }
}
