package fr.unice.polytech.kaleate.restaurant;

import fr.unice.polytech.kaleate.commande.Commandable;
import fr.unice.polytech.kaleate.commande.Commande;
import fr.unice.polytech.kaleate.commande.StatutCommande;
import fr.unice.polytech.kaleate.menu.ContenuMenu;
import fr.unice.polytech.kaleate.menu.Menu;
import fr.unice.polytech.kaleate.menu.element.ChoixElement;
import fr.unice.polytech.kaleate.outils.Creneau;

import java.util.Map;
import java.util.Optional;

public class ManagerRestaurant {
    private String nom;
    private String prenom;
    private Restaurant restaurant;

    public ManagerRestaurant(String nom, String prenom, Restaurant restaurant){
        this.nom = nom;
        this.prenom = prenom;
        this.restaurant = restaurant;
    }

    public ManagerRestaurant(Restaurant r){
        this.restaurant = r;
        this.nom = "Nom";
        this.prenom = "Prenom";
    }

    public void ajouterUnMenu(Commandable m){
        restaurant.ajouterMenu(m);
    }

    public void supprimerUnMenu(Commandable m){
        restaurant.supprimerMenu(m);
    }

    public void modifierUnMenu(Menu m, ChoixElement choixElement){
        Optional<Menu> optionalMenu = restaurant.getMenus(Menu.class).stream().map(menu -> (Menu) menu).filter(menu -> menu.getName().equals(m.getName())).findFirst();

        if (optionalMenu.isPresent()) {
            Menu menu = optionalMenu.get();
            if(menu.getContenuMenu() == null){
                menu.setContenuMenu(new ContenuMenu());
            }
            menu.getContenuMenu().ajouterChoixElement(choixElement);
        }
        else {
            throw new RuntimeException("le menu n'existe pas veillez le créer");
        }
    }

    public boolean commandePrete(int c){
        Commande commande = restaurant.getListCommande().getCommandeById(c);
        if(commande == null){
            return false;
        }
        return commande.getStatutCommande() == StatutCommande.PRETE;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant r) {
        this.restaurant = r;
    }

    public void modifierCreneauMenu(Menu menu, Creneau creneau){
        if (menu != null) {
            menu.setCreneau(creneau);
        }
        else {
            System.out.println("le menu n'existe pas veillez le créer");
        }
    }
    public Map<String, Integer> tendancesRestaurant(){
        return restaurant.tendances();
    }
}
