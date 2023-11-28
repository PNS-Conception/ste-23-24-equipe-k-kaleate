package fr.unice.polytech.kaleate.commande;

import fr.unice.polytech.kaleate.restaurant.Restaurant;

import java.util.stream.Collectors;

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
        for (Commande c: listCommande) {
            if(c.getRestaurants().contains(restaurant))
                if(c.getStatut().equals(StatutCommande.PRETE))
                    comPrete.add(c);
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
