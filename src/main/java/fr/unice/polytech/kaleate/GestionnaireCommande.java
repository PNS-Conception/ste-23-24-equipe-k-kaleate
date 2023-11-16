package fr.unice.polytech.kaleate;

import java.util.Date;

public class GestionnaireCommande {

    private ListeCommande listCommande;

    public GestionnaireCommande(){
        listCommande = ListeCommande.getInstanc();
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

    public ListeCommande getCommandePrete(Restaurant restaurant) {
        ListeCommande comPrete = new ListeCommande();
        for (Commande c : listCommande) {
            if (c.getStatut().equals(StatutCommande.PRETE) && c.getRestaurant().equals(restaurant)) {
                comPrete.add(c);
            }
        }
        return comPrete;
    }

    public ListeCommande getListCommande() {
        return listCommande;
    }

    public void setListCommande(ListeCommande listCommande) {
        this.listCommande = listCommande;
    }
}
