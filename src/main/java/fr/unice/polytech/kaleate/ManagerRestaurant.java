package fr.unice.polytech.kaleate;

public class ManagerRestaurant {
    private Restaurant restaurant;

    public ManagerRestaurant(Restaurant r){
        restaurant=r;
    }

    public boolean commandePrete(int c){
        Commande commande = restaurant.getListCommande().getCommandeById(c);
        for (StatutMenu sm : commande.getStatutsMenus()){
                if (sm!=StatutMenu.PRET) return false;
            }
        return true;
    }
}
